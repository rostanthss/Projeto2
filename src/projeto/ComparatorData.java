package projeto;

import java.util.Comparator;

import projeto.lista.ListaDeCompras;
/**
 * Classe Comparator, usado para ordenar listas de compras pela data de criacao.
 * 
 * @author Cleciana Santana

 */
public class ComparatorData implements Comparator<ListaDeCompras> {


	@Override
	public int compare(ListaDeCompras lista1, ListaDeCompras lista2) {
		
		if (lista1.getData().isBefore(lista2.getData())) {
			return -1;
		}
		if (lista1.getData().isAfter(lista2.getData())) {
			return 1;
		}
		return 0;
	}

}
