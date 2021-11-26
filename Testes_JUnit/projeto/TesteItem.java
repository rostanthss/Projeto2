package projeto;

import static org.junit.Assert.*;
import org.junit.Test;

import projeto.item.Item;
import projeto.item.ItemPorQuantidade;
import projeto.item.ItemPorQuilo;
import projeto.item.ItemPorUnidade;

/**
 * Testes de unidade para classe Item e filhas.
 * 
 * @author Rostanth Santana.
 */
public class TesteItem {
	/**
	 * Este teste cria itens por quilo e garante que eles sao diferentes e nao
	 * nulos.
	 */
	@Test
	public void CriaItemPorQuilo() {
		ItemPorQuilo item = new ItemPorQuilo("batata", "alimento nao industrializado", "Baratao", 1.50, 1.2);
		ItemPorQuilo novoitem = new ItemPorQuilo("laranja", "alimento nao industrializado", "Baratao", 2.30, 2.0);
		assertNotEquals(item, novoitem);
	}

	/**
	 * Este teste calcula o preco do item usando o metodo calculaPreco da classe
	 * item.
	 */
	@Test
	public void testGetPreco() {
		ItemPorQuilo item = new ItemPorQuilo("batata", "alimento nao industrializado", "Baratao", 2, 1);
		String lol = item.getPreco() + "";
		assertEquals(lol, "1.0");
	}

	/**
	 * Este metodo testa o getId do item.
	 */
	@Test
	public void testidNumerico() {
		ItemPorQuilo item = new ItemPorQuilo("batata", "alimento nao industrializado", "Baratao", 2, 1);
		assertEquals(0, item.getIdItem());
	}

	/**
	 * Testa o toString do item.
	 */
	@Test
	public void testToString() {
		Item item = new ItemPorQuantidade("Fini", "alimento industrializado", "Supermercado SemNome", "grama", 60,
				1.20);
		assertEquals("0. Fini, alimento industrializado, 60 grama, Preco: <Supermercado SemNome, R$ 1,20;>",
				item.toString());
	}

	/**
	 * Este teste cria um itemPorQuantidade e garante que ele exista.
	 */
	@Test
	public void testCriarItemPorQtd() {
		Item item = new ItemPorQuantidade("Agua Sanitaria Drogon", "limpeza", "Supermercado Excepcional", "l", 1, 2.19);
		assertNotNull(item);
	}

	/**
	 * Este teste cria um itemPorUnidade e garante que ele exista.
	 */
	@Test
	public void testCriaItemPorUnidade() {
		ItemPorUnidade itemPorUnidade = new ItemPorUnidade("Queijo minas Dali", "alimento industrializado", 2,
				"Baratao", 2.0);
		assertNotNull(itemPorUnidade);
	}

	/**
	 * Este teste cria um itemPorQuilo e garante que ele exista.
	 */
	@Test
	public void testCriaItemPorQuilo() {
		ItemPorUnidade itemPorQuilo = new ItemPorUnidade("Queijo minas Dali", "alimento industrializado", 2, "Baratao",
				2.0);
		assertNotNull(itemPorQuilo);
	}
	
	/**
	 * Este teste cria um itemPorQuilo com um nome nulo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCriaItemPorQuiloNomeNulo() {
		ItemPorUnidade itemPorQuilo = new ItemPorUnidade("", "alimento industrializado", 2, "Baratao",
				2.0);
		assertNotNull(itemPorQuilo);
	}
	
	/**
	 * Este teste cria um itemPorQuilo com um categoria nulo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCriaItemPorQuiloCategoriaNulo() {
		ItemPorUnidade itemPorQuilo = new ItemPorUnidade("Queijo", "", 2, "Baratao",
				2.0);
		assertNotNull(itemPorQuilo);
	}
	/**
	 * Este teste cria um itemPorQuilo com o preco negativo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCriaItemPorQuiloUnidadeNegativo() {
		ItemPorUnidade itemPorQuilo = new ItemPorUnidade("Queijo", "limpeza", -2, "Baratao",
				2.0);
		assertNotNull(itemPorQuilo);
	}
	
	/**
	 * Este teste cria um itemPorQuilo com o local de compra nulo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCriaItemPorQuiloLocalDeCompraNulo() {
		ItemPorUnidade itemPorQuilo = new ItemPorUnidade("Queijo", "limpeza", 2, "",
				2.0);
		assertNotNull(itemPorQuilo);
	}

	/**
	 * Este teste cria um itemPorQuilo com um categoria nulo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCriaItemPorQuiloPrecoNegativo() {
		ItemPorUnidade itemPorQuilo = new ItemPorUnidade("Queijo", "", 2, "Baratao",
				-2.0);
		assertNotNull(itemPorQuilo);
	}

}
