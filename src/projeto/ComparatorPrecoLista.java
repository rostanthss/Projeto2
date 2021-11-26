package projeto;

import java.util.Comparator;
import projeto.lista.ListaDeCompras;

/**
 * Classe Comparator, usado para ordenar listas de compras em ordem crescente com
 * base em seus precos finais de compra.
 * 
 * @author Rostanth Santana
 */
public class ComparatorPrecoLista implements Comparator<ListaDeCompras> {
	
	@Override
	public int compare(ListaDeCompras lista1, ListaDeCompras lista2) {
		
		if (lista1.getValorFinalCompra() < lista2.getValorFinalCompra()) {
        	return -1;
        }
        if (lista1.getValorFinalCompra() > lista2.getValorFinalCompra()) {
        	return 1;
        }
        return 0;
	}
}
