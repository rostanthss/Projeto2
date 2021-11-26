package projeto.item;
/**
 * Representação da Classe item para itens comprados por quantidade. Ex: 100 gramas
 * 
 * @author Rostanth Santana
 */
public class ItemPorQuantidade extends Item {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Quantidadade de venda do item
	 */
	private int quantidade;
	/**
	 * Representa qual a unidade de medida usada no item Ex: gramas.
	 */
	private String unidadeDeMedida;

	/**
	 * Cria um Item por Unidade.
	 * 
	 * @param nome
	 * 			Nome do Item
	 * @param categoria
	 * 			Categoria de Item
	 * @param qtd
	 * 			Quantidadade de venda do item
	 * @param unidadeDeMedida
	 * 			String que representa qual a unidade de medida usada no item Ex: gramas.
	 * @param preco
	 * 			Preco do item
	 */
	public ItemPorQuantidade(String nome, String categoria, String localDeCompra, String unidadeDeMedida, int qtd, double preco) {
		
		super(nome, categoria, localDeCompra, preco);
		
		if (unidadeDeMedida.trim().isEmpty() || unidadeDeMedida == null) {
			throw new IllegalArgumentException("unidade de medida nao pode ser vazia ou nula.");
		}
		this.setUnidadeDeMedida(unidadeDeMedida);
		this.setQuantidade(qtd);
	}

	/**
	 * Altera a quantidade do item
	 * 
	 * @param qtd
	 * 			quantidade
	 */
	public void setQuantidade(int qtd) {
		if (qtd < 0) {
			throw new IllegalArgumentException("valor de quantidade nao pode ser menor que zero.");
		}
		this.quantidade = qtd;
	}

	/**
	 * Atualiza a unidade de medida atual do item
	 * 
	 * @param novoValor
	 * 			String q substitui a unidade atual de medida
	 */
	public void setUnidadeDeMedida(String novoValor) {
		this.unidadeDeMedida = novoValor;
	}

	/**
	 * Pega o valor que indica a quantidade de venda deste item.
	 * 
	 * @return
	 * 		Valor que indica a quantidade
	 */
	public int getQuantidade() {
		return quantidade;
	}

	/**
	 * Pega a string que indica a unidade de medida utilizada neste item.
	 * @return
	 * 		String que indica a unidade de medida
	 */
	public String getUnidadeDeMedida() {
		return unidadeDeMedida;
	}

	/**
	 * Metodo auxiliar, retorna informacoes proprias de um ItemPorQuantidade, 
	 * sobrescreve o metodo getInfo da superclasse Item
	 */
	@Override
	public String getInfo() {
		return super.getInfo() + ", " + this.quantidade + " " + this.unidadeDeMedida;
	}
	/**
	 * Representacao String de um Item por Quantidade
	 */
	@Override
	public String toString() {
		return super.toString() + ", " + this.quantidade + " " + this.unidadeDeMedida + ", Preco: " + exibirPrecos();
	}

}
