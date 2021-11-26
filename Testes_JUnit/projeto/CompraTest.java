package projeto;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import projeto.item.ControllerItens;
import projeto.lista.Compra;
import projeto.lista.ControllerListaCompras;

public class CompraTest {

	private ControllerItens contItens = new ControllerItens();
	private ControllerListaCompras contLista = new ControllerListaCompras();
	private int id1, id2, id3;
	private Compra compra;
	
	@Before
	public void setUpBefore() {
		id1 = this.contItens.adicionaItemPorQtd("Pasta de dente", "higiene pessoal", 200, "g", "Baratao", 2.20);
		id2 = this.contItens.adicionaItemPorQuilo("batata", "alimento nao industrializado", 1.50, "Baratao", 1.2);
		id3 = this.contItens.adicionaItemPorUnidade("Queijo minas Dali", "alimento industrializado", 2, "Baratão", 2.0);

		this.contLista.adicionaListaDeCompras("test Lista");
		this.compra = new Compra(2, this.contItens.getItemInstance(id3));
		this.contLista.adicionarCompraALista("test Lista", 8, this.contItens.getItemInstance(this.id1));
		this.contLista.adicionarCompraALista("test Lista", 5, this.contItens.getItemInstance(this.id2));
		this.contLista.adicionarCompraALista("test Lista", 2, this.contItens.getItemInstance(this.id3));
	}
	
	/**
	 * Deve lancar excecao ao passar um item nao cadastrado(nulo)
	 */
	@Test (expected=NullPointerException.class)
	public void testCompraNullException() {
		this.contLista.adicionarCompraALista("test Lista", 1, this.contItens.getItemInstance(0));
	}
	
	/**
	 * Deve lancar excecao ao passar uma descricao invalida
	 */
	@Test (expected=IllegalArgumentException.class)
	public void testCompraException() {
		this.contLista.adicionarCompraALista(" ", 1, this.contItens.getItemInstance(id2));
	}
	
	/**
	 * Deve lancar excecao ao passar uma quantidade invalida
	 */
	@Test (expected=IllegalArgumentException.class)
	public void testCompraQtdException() {
		this.contLista.adicionarCompraALista("test Lista", -3, this.contItens.getItemInstance(id1));
	}

	/**
	 * Deve retornar com sucesso o toString da compra, associado ao item de id3.
	 */
	@Test
	public void testToString() {
		assertEquals("2 Queijo minas Dali, alimento industrializado", this.compra.toString());
	}

}
