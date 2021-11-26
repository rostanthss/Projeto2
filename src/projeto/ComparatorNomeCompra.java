package projeto;

import java.util.Comparator;

import projeto.lista.Compra;
/**
 * Classe Comparator, usado para ordenar compras pelo nome, em ordem alfabetica.
 * 
 * @author Rostanth Santana
 */
public class ComparatorNomeCompra implements Comparator<Compra> {

	@Override
	public int compare(Compra compra1, Compra compra2) {
		
		String nome1 = compra1.getItem().getNome();
		String nome2 = compra2.getItem().getNome();
		
		return nome1.compareTo(nome2);
	}

	
}
