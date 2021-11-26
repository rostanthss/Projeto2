package projeto.item;
/**
 * Classe que representa um objeto Item, do tipo que se compra por Unidade.
 * 
 * @author Rostanth Santana
 */
public class ItemPorUnidade extends Item {
	
	/**
	 * SerialID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Representa a quantidade minima em que esse Item eh vendido.
	 */
	private int unidade;
	
	/**
	 * Cria um Item por Unidade.
	 * 
	 * @param nome
	 * 			Nome do Item
	 * @param categoria
	 * 			Categoria de Item
	 * @param unidade
	 * 			Quantidadade de venda do item
	 * @param localDeCompra
	 * 			Local onde o Item pode ser comprado
	 * @param preco
	 * 			Preco do item
	 */
    public ItemPorUnidade(String nome, String categoria, int unidade, String localDeCompra, double preco) {
    	
        super(nome, categoria, localDeCompra, preco);      
        this.setunidade(unidade);
    }
    
    /**
     * Retorna um Inteiro que indica a quantidade minima de venda do item
     */
    public int getUnidade() {
    	return unidade;
    }

    /**
     * Altera a quantidade do item para o valor recebido.
     * 
     * @param unidade
     */
    public void setunidade(int unidade) {
		if (unidade < 0) {
	        	throw new IllegalArgumentException("valor de unidade nao pode ser menor que zero.");
	        }
		this.unidade = unidade;
	}
 
	/**
	 * Representacao String de um Item por Unidade
	 */
    @Override
    public String toString() {
        return super.toString() + ", Preco: " + exibirPrecos();
    }
}