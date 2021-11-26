package projeto;

import java.util.Comparator;

import projeto.lista.ListaDeCompras;
/**
 * Classe Comparator, usado para ordenar listas usando suas descricoes, por ordem alfabetica.
 * 
 * @author Cleciana Santana
 */
public class ComparatorDescrLista implements Comparator<ListaDeCompras> {

	@Override
	public int compare(ListaDeCompras lista1, ListaDeCompras lista2) {
		
		return lista1.getDescricao().compareToIgnoreCase(lista2.getDescricao());
	}

}
