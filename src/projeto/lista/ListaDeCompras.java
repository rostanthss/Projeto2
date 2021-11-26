package projeto.lista;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import projeto.item.Item;

/**
 * Classe que representa um objeto Lista, guarda e manipula as compras cadastradas no sistema.
 * 
 * @author Victor Braga, Cleciana Santana,Rostanth Santana
 */
public class ListaDeCompras implements Comparable<ListaDeCompras>, Serializable {

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Mapa de Compras de uma Lista onde o Id de um Item é a chave, e o valor é um objeto Compra
	 */
	private Map<Integer, Compra> colecaoCompras;
	/**
	 * Guarda as informacoes data/hora em que a Lista foi criada
	 */
	private LocalDate data;
	/**
	 * String que descreve uma lista. Ex: 'Feira quinzenal'
	 */
	private String descricao;
	/**
	 * Após a finalizacao de uma Lista , indica em que Estabelecimento foram realizadas as compras.
	 */
	private String localDaCompra;
	/**
	 * Após a finalizacao de uma Lista , indica o valor total das compras.
	 */
	private double valorFinalCompra;
	
	private int size;
	private ArrayList<String> locaisDasCompras;
	
	
	/**
	 * Construtor, instancia um objeto ListaDECompras. Recebe uma descricao(String).
	 * 
	 * @param descricao
	 * 			String que descreve uma lista. Ex: 'Feira quinzenal'
	 */
	public ListaDeCompras(String descricao) {
		if (descricao.trim().isEmpty() || descricao == null) {
			throw new IllegalArgumentException("descritor nao pode ser vazio ou nulo.");
		}
		this.descricao = descricao;
		this.data = LocalDate.now();
		this.colecaoCompras = new HashMap<>();
	}
	
	/**
	 * Retorna a string descricao da lista.
	 */
	public String getDescricao() {
		return descricao;
	}
	
	/**
	 * Atualza a descricao de uma lista de compras, usando o parametro novaDescricao.
	 * 
	 * @param novaDescricao
	 * 			String que eh usada para substituir a descricao atual.
	 */
	public void setDescricao(String novaDescricao) {
		this.descricao = novaDescricao;
	}
	
	/**
	 * Getter de localDaCompra
	 * @return
	 * 			Retorna uma String que informa o local onde foram feitas as compras
	 */
	public String getLocaDaCompra() {
		return localDaCompra;
	}

	/**
	 * Setter para locaDaCompra. Lanca uma excecao caso o local de compra seja vazio ou nulo.
	 * 
	 * @param localDaCompra
	 * 			String que indica o local onde a compra foi realizada.
	 */
	public void setLocaDaCompra(String localDaCompra) {
		if (localDaCompra.trim().isEmpty() || localDaCompra == null) {
			throw new IllegalArgumentException("local nao pode ser vazio ou nulo.");
		}
		this.localDaCompra = localDaCompra;
	}

	/**
	 * Getter de ValorFinal
	 * @return
	 * 			Retorna um double que indica o valor total das compras da Lista.
	 */
	public double getValorFinalCompra() {
		return valorFinalCompra;
	}

	/**
	 * Altera o valor total das compras da lista.
	 * 
	 * @param valorFinalCompra
	 * 			double que indica o valor total das compras
	 */
	public void setValorFinalCompra(double valorFinalCompra) {
		if (valorFinalCompra <= 0) {
			throw new IllegalArgumentException("valor final da lista invalido.");
		}
		this.valorFinalCompra = valorFinalCompra;
	}

	/**
	 * Getter de informacao sobre data/hora de criacao da Lista
	 * 
	 * @return
	 * 			Informacoes sobre data/hora de criacao da lista.
	 */
	public LocalDate getData() {
		return data;
	}

	/**
	 * @return
	 * 			tamanho da lista de compras.
	 */
	public int getSize() {
		return this.size;
	}
	
	/**
	 * 
	 * @param itemid
	 * 
	 * @return
	 * 			quantidade do item na lista
	 */
	public int getQuantidade(int itemid) {
		return this.colecaoCompras.get(itemid).getQuantidade();
	}
	/**
	 * 
	 * @return
	 * 			retorna todos os locas de compra dos itens da lista
	 */
	public ArrayList<String> getLocaisDasCompras(){
		return this.locaisDasCompras;
	}

	/**
	 * 
	 * @param temp
	 * @param valor
	 */
	public void finalizarListaTemporariasDeCompras(String temp, double valor) {
		this.descricao = temp;
		this.valorFinalCompra = valor;
	}

	/**
	 * Verifica se um item ja esta cadastrado na lista
	 * @param idItem
	 * 			id do item associado a compra
	 * @return
	 * 			Boolean, True se o item existe, False caso contrario
	 */
	boolean verificaItem(int idItem) {
		return this.colecaoCompras.containsKey(idItem);
	}
	
	/**
	 * Adiciona um objeto Compra na colecao de compras de uma Lista.
	 * 
	 * @param quantidade
	 * 			Quantidade de itens da compra.
	 * @param item
	 * 			Item associado a compra.
	 */
	public void adicionarCompra(int quantidade, Item item) {
		if (quantidade < 0) {
			throw new IllegalArgumentException("Erro na compra de item: quantidade nao pode ser menor que 0");
		}
		Compra novaCompra = new Compra(quantidade, item);
		this.colecaoCompras.put(item.getIdItem(), novaCompra);
	}
	
	/**
	 * Pesquisa uma compra na lista, lanca excecoes caso a compra nao exista ou 
	 * o id do Item associado seja invalido.
	 * 
	 * @param idNumerico
	 * 			Identificador do Item que esta associado a compra.
	 * @return
	 * 			Retorna a String representacao da compra.
	 */
	public String pesquisaCompra(int idNumerico) {
		
		if (!verificaItem(idNumerico)) {
			throw new NullPointerException("compra nao encontrada na lista.");
		}
		if (idNumerico < 0) {
			throw new IllegalArgumentException("item id invalido.");
		}

		Compra novaCompra = this.colecaoCompras.get(idNumerico);
		return novaCompra.toString();
	}
	
	/**
	 * 	Retorna a String representacao de uma compra na lista. Caso a compra
	 *  nao exista retorna uma String vazia.
	 * 
	 * @param posicaoItem
	 * 			Inteiro que indentifica a compra desejada.
	 */
	public String retornaCompra(int posicaoItem) {
		Compra compra = this.colecaoCompras.get(posicaoItem);
		if (compra == null) {
			return "";
		}
		return compra.toString();
	}

	/**
	 * Metodo que atualiza a quantidade de itens de uma compra. Lanca excecao caso o item
	 * nao exista ou a operacao recebida seja invalida.
	 * 
	 * @param itemId
	 * 			Identificador do Item da compra
	 * @param operacao
	 * 			Operacao a ser efetuada na quantidade. Pode ser "adiciona" ou "diminui".
	 * @param quantidade
	 * 			Quantidade de Item a ser acrescida ou retirada da compra.
	 */
	public void atualizaCompra(int itemId, String operacao, int quantidade) {
		Compra compraAux = this.colecaoCompras.get(itemId);
		
		if (compraAux == null) {
			throw new NullPointerException("Erro na atualizacao de compra: compra nao encontrada na lista.");
		}
		if (operacao.equals("adiciona")) {
			compraAux.setQuantidade(compraAux.getQuantidade() + quantidade);
			
		} else if (operacao.equals("diminui")) {
			compraAux.setQuantidade(compraAux.getQuantidade() - quantidade);
			
			if (compraAux.getQuantidade() <= 0) {
				this.colecaoCompras.remove(itemId);
			}
		}	
	}

	/**
	 * Deleta a compra identificada pelo Id da Lista.
	 * 
	 * @param identificador
	 * 			Identifica a compra.
	 */
	public void deletaCompra(int identificador) {
		this.colecaoCompras.remove(identificador);
	}
	
	/**
	 * Pega a colecao de compras da Lista
	 * @return
	 * 			Um Map que contem as compras da lista
	 */
	public Map<Integer, Compra> getCompras() {
		return this.colecaoCompras;
	}
	
	public void setCompras(Map<Integer, Compra> map) {
		this.colecaoCompras = map;
	}
	
	public boolean verificaDescritor(String descritor) {
		for (Compra C : colecaoCompras.values()) {
			if(C.getItem().getNome().equals(descritor)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Configura a comparacao entre listas usando seus descritores por ordem alfabetica
	 * sem se importar com maiusculas ou minusculas.
	 */
	@Override
	public int compareTo(ListaDeCompras lista) {
		return this.descricao.compareToIgnoreCase(lista.descricao);
	}

	/**
	 * Retorna a representacao de uma Lista De Compras.
	 */
	public String toString() {
		return this.descricao;
	}

}
