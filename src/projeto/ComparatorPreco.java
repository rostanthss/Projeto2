package projeto;

import java.util.Comparator;

import projeto.item.Item;
/**
 * Classe Comparator, usada para ordenacao de itens em ordem crescente de precos
 * 
 */
public class ComparatorPreco implements Comparator<Item> {
	
    @Override
    public int compare(Item c1, Item c2) {
 
        if (c1.getPreco() < c2.getPreco()) {
        	return -1;
        }
        if (c1.getPreco() > c2.getPreco()) {
        	return 1;
        }
        return 0;
    }
}
