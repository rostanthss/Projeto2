package projeto;

import java.util.Comparator;

import projeto.lista.Compra;
/**
 * Classe Comparator, usado para ordenar compras por categoria.
 * 
 */
public class ComparatorCategoria implements Comparator<Compra>{

	@Override
	public int compare(Compra compra1, Compra compra2) {
		
		CategoriasEnum categoria1 = compra1.getItem().getCategoriasEnum();
		CategoriasEnum categoria2 = compra2.getItem().getCategoriasEnum();
		
		return categoria1.compareTo(categoria2);
	}


}
