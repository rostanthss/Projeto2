package projeto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import easyaccept.EasyAccept;
import projeto.item.ControllerItens;
import projeto.item.Item;
import projeto.lista.ControllerListaCompras;
/**
 *  Classe Facade, delega as operacoes do usuario aos controllers necessarios.
 *  
 * @author Victor Braga, Cleciana Santana
 * 		   Igor Franca, Rostanth
 */
public class Facade implements Serializable {

	/**
	 * Arquivo utilizado para escrever e ler os dados do sistema.
	 */
	private File data = new File("data.txt");
	/**
	 * SerialId
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Controller de Itens que podem ser comprados
	 */
	private ControllerItens controllerDeItens = new ControllerItens();
	/**
	 * Controller de ListasDeCompras
	 */
	private ControllerListaCompras controllerDeListas = new ControllerListaCompras();
	
	public static void main (String[] args) {
		args = new String[] {"projeto.Facade", "testes/use_case1.txt", "testes/use_case1_exception.txt", 
							 "testes/use_case2.txt", "testes/use_case2_exception.txt",
							 "testes/use_case3.txt", "testes/use_case3_exception.txt",
							 "testes/use_case4.txt", "testes/use_case4_exception.txt",
							 "testes/use_case5.txt",
							 "testes/use_case6.txt", "testes/use_case6_exception.txt",
							 "testes/use_case7.txt"};
		
		EasyAccept.main(args);
	}

	/**
	 * Retorna o controller de itens, metodo auxiliar usado na inicializacao do sistema.
	 */
	private ControllerItens getControllerItens() {
		return this.controllerDeItens;
	}
	
	/**
	 * Retorna o controller de Listas de Compras, metodo auxiliar usado na inicializacao do sistema.
	 */
	private ControllerListaCompras getControllerLista() {
		return this.controllerDeListas;
	}
	
	/**
	 * Metodo que pega a data atual do sistema.
	 * 
	 * @return
	 * 			Retorna a representacao em string da data atual.
	 */
	public String dataAtual() {
		return LocalDate.now().toString();
	}

	/**
	 * Le o arquivo data para recuperar os dados salvos da ultima utilizacao do sistema.
	 */
	public void iniciaSistema() {
		try {
			InputStream is = new FileInputStream(this.data);
			ObjectInputStream ois = new ObjectInputStream(is);
			
			Facade facade = (Facade) ois.readObject();
			this.controllerDeItens = facade.getControllerItens();
			this.controllerDeListas = facade.getControllerLista();
			ois.close();
			
		} catch (IOException c) {
			c.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Guarda os dados da sessao em um arquivo para serem utilizados na proxima inicializacao.
	 */
	public void fechaSistema() {
		try {
			OutputStream fw = new FileOutputStream(this.data);
			ObjectOutputStream oos = new ObjectOutputStream(fw);
			oos.writeObject(this);
			oos.close();
			
		} catch (Exception f) {
			f.printStackTrace();
		}
	}
	
	/**
	 * Fecha a aplicacao.
	 */
	public void quit() {
		System.exit(0);
	}
	
	/**
	 * Metodo que adiciona um item que se compra com uma quantidade fixa. Ex:
	 * Algodão branco 200g
	 * 
	 * @param nome
	 *            eh o nome do que descreve o produto
	 * @param categoria
	 *            que define sua finalidade Ex: No caso de algoda seria: higiene
	 *            pessoal
	 * @param qtd
	 *            um inteiro que diz a quantidade que esse produto contem
	 * @param unidadeDeMedida
	 *            unidade de medida usada por esse produto
	 * @param localDeCompra
	 *            Local onde o produto foi comprado
	 * @param preco
	 *            preco do item
	 * @return retorna o idNumerico desse produto
	 */
	public int adicionaItemPorQtd(String nome, String categoria, int qtd, String unidadeDeMedida, String localDeCompra, double preco) {
		return this.controllerDeItens.adicionaItemPorQtd(nome, categoria, qtd, unidadeDeMedida, localDeCompra, preco);
	}

	/**
	 * 
	 * Metodo que adiciona um item que se compra por peso. Ex: 200g de carne
	 * 
	 * @param nome
	 *            eh o nome do que descreve o produto
	 * @param categoria
	 *            que define sua finalidade Ex: 200g de picinha: Alimntos nao
	 *            industrializdos
	 * @param kg
	 *            um numero real que diz a quantidade que foi comprada desse produto
	 * @param localDeCompra
	 *            Local onde o produto foi comprado
	 * @param preco
	 *            preco do item
	 * @return retorna o int idNumerico que identifica o item.
	 */
	public int adicionaItemPorQuilo(String nome, String categoria, double kg, String localDeCompra, double preco) {
		return this.controllerDeItens.adicionaItemPorQuilo(nome, categoria, kg, localDeCompra, preco);
	}

	/**
	 * 
	 * Metodo que adiciona um item que se compra por unidade. Ex: 1 queijo minas.
	 * 
	 * @param nome
	 *            eh o nome do que descreve o produto
	 * @param categoria
	 *            que define sua finalidade Ex: 1 queijo minhas: Alimntos
	 *            industrializdos
	 * @param unidade
	 *            um numero inteiro que diz a quantidade de itens daquele que foi
	 *            comprada
	 * @param localDeCompra
	 *            Local onde o produto foi comprado
	 * @param preco
	 *            preco do item
	 * @return retorna o int idNumerico que identifica o item.
	 */
	public int adicionaItemPorUnidade(String nome, String categoria, int unidade, String localDeCompra, double preco) {
		return this.controllerDeItens.adicionaItemPorUnidade(nome, categoria, unidade, localDeCompra, preco);
	}

	/**
	 * Metodo que permite modificar os parametros de um item, exceto seu idNumerico
	 * 
	 * @param idNumerico
	 *            inteiro que identifica cada item e nao pode ser alterado
	 * @param atributo
	 *            string que leva o mesmo nome do atributo que se quer moficar
	 * @param novoValor
	 *            String que recebe a nova String que se quer alterar.
	 */
	public void atualizaItem(int idNumerico, String atributo, String novoValor) {
		this.controllerDeItens.atualizaItem(idNumerico, atributo, novoValor);
	}

	/**
	 * Metodo que apos cadastrar um item, permite que se atribua um preco a esse
	 * item e o associe a um local de compra esse metodo pode armazenar varios
	 * precos e seus respectivos locais de compra. Um mapa eh usado para armazenar
	 * estes dados.
	 * 
	 * @param idNumerico
	 *            int que identifica cada produto e eh imutavel
	 * @param localDeCompra
	 *            local onde o produto foi comprado com aquele determinado preco
	 * @param preco
	 *            preco do protudo no local de compra especificado
	 */
	public void adicionaPrecoItem(int idNumerico, String localDeCompra, double preco) {
		this.controllerDeItens.adicionaPrecoItem(idNumerico, localDeCompra, preco);
	}

	/**
	 * Metodo que recebe um inteiro idNumerico (que identifica cada item), e
	 * retorna a string que representa o item. Alem disso o metodo
	 * ordena a lista de itens por ordem alfabetica.
	 * 
	 * @return retorna a representacao do item indicado atraves do idnumerico.
	 */
	public String exibeItem(int idNumerico) {
		return this.controllerDeItens.exibeItem(idNumerico);
	}
	
	/**
	 * Metodo que recebe o idNumerico do item e atraves dele deleta-o do sistema.
	 * 
	 * @param idNumerico
	 *            int que intenfica cada item e eh imutavel.
	 */
	public void deletaItem(String idNumerico) {
		this.controllerDeItens.deletaItem(idNumerico);
	}

	/**
	 * Metodo que recebe um inteiro idNumerico (que identifica cada item), e
	 * atraves desse id retorna a string que representa o item. Alem disso o metodo
	 * ordena a lista de itens cadastrados por ordem alfabetica
	 * 
	 * @return retorna a representacao o item indicado atraves do idnumerico
	 */
	public String getItem(int idNumerico) {
		return this.controllerDeItens.getItem(idNumerico);
	}
	
	/**
	 * Metodo que pesquisa e retorna um Item da categoria informada usando seu id.
	 * Caso o item nao exista retorna: "".
	 * 
	 * @param categoria
	 * @param posicao
	 * @return
	 * 			Retorna representacao String do Item.
	 */
	public String getItemPorCategoria(String categoria, int posicao) {
		return this.controllerDeItens.getItemPorCategoria(categoria, posicao);
	}
	
	/**
	 * Ordena os itens em ordem crescente de precos e busca pelo item com o id indicado.
	 * 
	 * @param posicao
	 * 			posicao em que o item esta apos ordenacao.
	 * @return
	 * 			String representacao do item.
	 */
	public String getItemPorMenorPreco(int posicao) {
		return this.controllerDeItens.getItemPorMenorPreco(posicao);
	}
	
	/**
	 * Retorna todos os itens que contem a string pesquisada no nome.
	 * 
	 * @param strPesquisada
	 * 			string que eh usada para pesquisa
	 * @param posicao
	 * 			posicao do item
	 * @return
	 * 			String representacao do item, se existir.
	 */
	public String getItemPorPesquisa(String strPesquisada, int posicao) {
		return this.controllerDeItens.getItemPorPesquisa(strPesquisada, posicao);
	}
	
	/**
	 * Retorna a String representacao de uma compra na lista. Caso a compra nao exista
	 * retorna uma String vazia.
	 * 
	 * @param descritor
	 * 			Descricao da lista de compras
	 * @param posicao
	 * 			Id do item associado a compra
	 */
	public String getItemLista(String descritor, int posicao) {
		return this.controllerDeListas.getItemLista(descritor, posicao);
	}
	
	/**
	 * Retorna o descritor das listas criadas na data passada, com a posicao especificada.
	 * 
	 * @param data
	 * @param posicaoLista
	 * @return
	 * 			Descricao da lista que ocupada a posicao informada, se existir.
	 */
	public String getItemListaPorData(String data, int posicaoLista) {
		return this.controllerDeListas.getItemListaPorData(data, posicaoLista);
	}
	
	/**
	 * Retorna, dentre as listas, as que contem compra associada ao item com ID especificado.
	 * Ordenadas por data e, em segundo plano, por ordem alfabetica.
	 * 
	 * @param id
	 * 			ID associado ao item.
	 * @param posicaoLista
	 * 			posicao que a lista ocupa apos ordenacao.
	 * @return
	 * 			Retorna uma string no formato: Data - DescricaoLista.
	 */
	public String getItemListaPorItem(int id, int posicaoLista) {
		return this.controllerDeListas.getItemListaPorItem(id, posicaoLista);
	}
	
	/**
	 * Metodo que cria uma lista de compras recebendo sua descricao e adiciona essa
	 * lista à uma colecao de listas. Lanca uma excecao caso a descricao seja nula ou vazia.
	 */
	public String adicionaListaDeCompras(String descritor) {
		return this.controllerDeListas.adicionaListaDeCompras(descritor);
	}
	
	/**
	 * Método que retorna representacao String de uma compra caso esta esteja
	 * cadastrada na Lista
	 * 
	 * @param descritorLista
	 * 			Descricao da Lista que pode conter a compra
	 * @return
	 * 			Retorna uma String representacao do Objeto Compra
	 */
	public String pesquisaListaDeCompras(String descritorLista) {
		return this.controllerDeListas.pesquisaListaDeCompras(descritorLista);
	}
	
	/**
	 * Metodo que procura listas de compra criadas na data especificada.
	 * 
	 * @param data
	 * 			data, no formato dd/MM/yyyy
	 * @return
	 * 			Retorna as listas criadas na data.
	 */
	public String pesquisaListasDeComprasPorData(String data) {
		return this.controllerDeListas.pesquisaListaDeComprasPorData(data);
	}
	
	/**
	 * Procura por listas que contenham compras com o item associado ao id especificado pelo usuario.
	 * 
	 * @param id
	 * 			id do item
	 * @return
	 * 			Todas as listas que contenham compras com o item
	 */
	public String pesquisaListasDeComprasPorItem(int id) {
		return this.controllerDeListas.pesquisaListasDeComprasPorItem(id);
	}
	
	/**
	 * Adiciona uma compra a lista de compras, recebendo sua descricao, um
	 * objeto Item e a quantidade deste Item na lista. Lanca excecao se o item nao existe.
	 * 
	 * @param descritor
	 * 			Descricao da lista de compras
	 * @param quantidade
	 * 			Quantidade de Itens da compra
	 * @param idItem
	 * 			Item a ser comprado
	 */
	public void adicionaCompraALista(String descritor, int quantidade, int idItem) {
		Item item = this.controllerDeItens.getColecaoItens().get(idItem);
		this.controllerDeListas.adicionarCompraALista(descritor, quantidade, item);
	}
	
	/**
	 * Retorna representacao String de uma compra caso esta esteja cadastrada na Lista
	 * 
	 * @param descritor
	 * 			Descricao da Lista que pode conter a compra
	 * @param itemId
	 * 			ID do Item desejado
	 * @return
	 * 			Retorna uma String representacao do Objeto Compra
	 */
	public String pesquisaCompraEmLista(String descritor, int itemId) {
		return this.controllerDeListas.pesquisaCompraEmLista(descritor, itemId);
	}
	
	/**
	 * Metodo que atualiza a quantidade de itens de uma compra. Lanca excecao caso o item
	 * nao exista ou a operacao recebida seja invalida.
	 * 
	 * @param descritor
	 * 			Descritor da lista que contem a compra
	 * @param itemId
	 * 			Identificador do Item da compra
	 * @param operacao
	 * 			Operacao a ser efetuada na quantidade. Pode ser "adiciona" ou "diminui".
	 * @param quantidade
	 * 			Quantidade de Item a ser acrescida ou retirada da compra.
	 */
	public void atualizaCompraDeLista(String descritor, int itemId, String operacao, int quantidade) {
		this.controllerDeListas.atualizaCompraDeLista(descritor, itemId, operacao, quantidade);
	}
	
	/**
	 * Método que, quando o usuario realiza as compras, finaliza uma lista.
	 * 
	 * @param descritor
	 * 			Descricao da lista de compras
	 * @param localDaCompra
	 * 			Estabelecimento em que foram realizadas as compras
	 * @param valorFinalDaCompra
	 * 			Valor Total de todas as compras feitas em um local
	 */
	public void finalizarListaDeCompras(String descritor, String localDaCompra, double valorFinalDaCompra) {
		this.controllerDeListas.finalizarListaDeCompras(descritor, localDaCompra, valorFinalDaCompra);
	}
	
	/**
	 * Deleta, da Lista de compras, a que esta associada ao Item recebido.
	 * 
	 * @param descritor
	 * 			Descritor da Lista que contem a compra.
	 * @param idItem
	 * 			Identificador do Item associado a compra que sera remoivda.
	 */
	public void deletaCompraDeLista(String descritor, int idItem) {
		Item item = this.controllerDeItens.getColecaoItens().get(idItem);
		this.controllerDeListas.deletaCompraDeLista(descritor, item);
	}
	
	public void geraAutomaticaUltimaLista() {
		this.controllerDeListas.geraAutomaticaUltimaLista();
	}
	
	public void geraAutomaticaItem(String descritorItem) {
		this.controllerDeListas.geraAutomaticaItem(descritorItem);
	}
	
	public String sugereMelhorEstabelecimento(String descricaoDaLista,int posicaoEstabelecimento,int posicaoLista) {
		return controllerDeListas.sugereMelhorEstabelecimento(descricaoDaLista, posicaoEstabelecimento, posicaoLista);
	}
}
