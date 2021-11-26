package projeto;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.junit.Before;
import org.junit.Test;

import projeto.item.ControllerItens;
import projeto.item.Item;

public class OrdenacaoTest {

	ControllerItens itens = new ControllerItens();
	
	@Before
	public void setBefore() {
		this.itens.adicionaItemPorQtd("Agua Sanitaria Drogon", "limpeza", 1, "l", "Supermercado Excepcional", 2.19);
		this.itens.adicionaItemPorQuilo("Peito de peru Saara", "alimento industrializado", 1.0, "Mercadinho Bem Barato", 34.49);
		this.itens.adicionaItemPorQtd("Agua Mineral Ideal", "limpeza", 2, "l", "Supermercado EhNois", 2.0);
		this.itens.adicionaItemPorQtd("Queijo ralado", "alimento industrializado", 60, "grama", "Supermercado SemNome", 1.20);
		this.itens.adicionaItemPorUnidade("Creme dental Oral-C", "higiene pessoal", 3, "Mercadinho Bem Barato", 3.79);
		this.itens.adicionaItemPorQuilo("Limao", "alimento nao industrializado", 1.0, "Supermercado Excepcional", 4.19);
		this.itens.adicionaItemPorUnidade("Coentro", "alimento nao industrializado", 1, "Mercadinho Bem Barato", 1.39);
		this.itens.adicionaItemPorQtd("Capsula Dois Coracoes", "alimento industrializado", 8, "capsulas", "Supermercado BuyMore", 10.89);
		this.itens.adicionaItemPorUnidade("Creme dental do Gianecchini", "higiene pessoal", 2, "Mercadinho das Estrelas", 3.50);

		Collection<Item> valores = this.itens.getColecaoItens().values();
		ArrayList<Item> novosItens = new ArrayList<>(valores);
		Collections.sort(novosItens);
	}

	@Test
	public void testToStringOrdenado() {
		assertEquals("3. Agua Mineral Ideal, limpeza, 2 l, Preco: <Supermercado EhNois, R$ 2,00;>", this.itens.getItem(0));
	}
	
	@Test
	public void testToStringOrdenado1() {
		assertEquals("14. Creme dental Oral-C, higiene pessoal, Preco: <Mercadinho Bem Barato, R$ 3,79;>", this.itens.getItem(4));
	}
	
	@Test
	public void testToStringOrdenado2() {
		assertEquals("", this.itens.getItem(10));
	}
	
	@Test
	public void testToStringOrdenado3() {
		assertEquals("36. Creme dental do Gianecchini, higiene pessoal, Preco: <Mercadinho das Estrelas, R$ 3,50;>", this.itens.getItem(5));
	}
	
	/**
	 * Deve retornar uma string vazia pois o item com id 25 nao existe.
	 */
	@Test
	public void testToStringOrdenado5() {
		assertEquals("", this.itens.getItem(25));
	}
}
