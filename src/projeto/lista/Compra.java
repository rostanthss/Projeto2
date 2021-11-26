package projeto.lista;

import java.io.Serializable;

import projeto.item.Item;

/**
 * Classe que representa uma Compra, guarda o Item associado a ela uma quantidade desses Itens.
 * 
 * @author Rostanth Santana
 */
public class Compra implements Serializable {

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Inteiro que indica a quantidade de itens a ser comprada.
	 */
	private int quantidade;
	/**
	 * Objeto Item associado a compra.
	 */
	private Item item;
	
	/**
	 * Instancia um objeto Compra recebendo sua quantidade e um objeto Item associado.
	 * 
	 * @param quantidade
	 * 			Quantidade de Item.
	 * @param item
	 * 			Objeto Item associado.
	 */
	public Compra(int quantidade, Item item) {
		setQuantidade(quantidade);
		this.item = item;
	}

	/**
	 * @return
	 * 			Retorna a quantidade de itens de uma Compra.
	 */
	public int getQuantidade() {
		return this.quantidade;
	}

	/**
	 * Altera a quantidade de Itens da compra.
	 * 
	 * @param novaQuantidade
	 */
	public void setQuantidade(int novaQuantidade) {
		if (quantidade < 0) {
			throw new IllegalArgumentException("Erro: Quantidade nao pode ser menor que zero.");
		}
		this.quantidade = novaQuantidade;
	}
	
	/**
	 * Pega o item associado a compra.
	 * 
	 * @return
	 * 			Objeto item
	 */
	public Item getItem() {
		return item;
	}
	
	/* 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		return result;
	}

	/* 
	 * Verifica se duas compras sao iguais
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		Compra other = (Compra) obj;
		if (item == null) {
			if (other.item != null)
				return false;
			
		} else if (!item.equals(other.item))
			return false;
		
		return true;
	}

	/**
	 * Representacao String de um objeto Compra.
	 */
	public String toString() {
		return this.quantidade + " " + item.getInfo();
	}

}
