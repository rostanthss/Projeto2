package projeto;

import static org.junit.Assert.*;
import org.junit.Test;
import projeto.item.ControllerItens;
import projeto.item.Item;

/**
 * Caso de teste do Controller de Itens;
 * 
 * @author Igor Franca
 */

public class ControllerItensTest {
	/**
	 * Controller de Itens
	 */
	ControllerItens itens = new ControllerItens();

	/**
	 * Esse metodo testa o metodo que permite o controller adicionar ItemPorQtd no
	 * Mapa de itens do controller.
	 */
	@Test
	public void testAdicionaItemPorQtd() {
		this.itens.adicionaItemPorQtd("Agua Sanitaria Drogon", "limpeza", 1, "l", "Supermercado Excepcional", 2.19);
	}

	/**
	 * Esse metodo testa o metodo que permite o controller adicionar ItemPorQtd no
	 * Mapa de itens do controller. Porem sem passar o nome, esperando a excecao
	 * IllegalArgumentException.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAdicionaItemPorQtdNomeNull() {
		this.itens.adicionaItemPorQtd("", "limpeza", 1, "l", "Supermercado Excepcional", 2.19);
	}

	/**
	 * Esse metodo testa o metodo que permite o controller adicionar ItemPorQtd no
	 * Mapa de itens do controller. Porem sem passar a categoria, esperando a
	 * excecao IllegalArgumentException.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAdicionaItemPorQtdCategoriaNull() {
		this.itens.adicionaItemPorQtd("Agua Sanitaria Drogon", "", 1, "l", "Supermercado Excepcional", 2.19);
	}

	/**
	 * Esse metodo testa o metodo que permite o controller adicionar ItemPorQtd no
	 * Mapa de itens do controller. Porem passando uma quantidade negativa,
	 * esperando a excecao IllegalArgumentException.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAdicionaItemPorQtdQuantidadeNegativa() {
		this.itens.adicionaItemPorQtd("Agua Sanitaria Drogon", "limpeza", -1, "l", "Supermercado Excepcional", 2.19);
	}

	/**
	 * Esse metodo testa o metodo que permite o controller adicionar ItemPorQtd no
	 * Mapa de itens do controller. Porem sem passar a unidade de medida, esperando
	 * a excecao IllegalArgumentException.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAdicionaItemPorQtdUnidadeNull() {
		this.itens.adicionaItemPorQtd("Agua Sanitaria Drogon", "limpeza", 1, "", "Supermercado Excepcional", 2.19);
	}

	/**
	 * Esse metodo testa o metodo que permite o controller adicionar ItemPorQtd no
	 * Mapa de itens do controller. Porem sem passar o local de compra, esperando a
	 * excecao IllegalArgumentException.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAdicionaItemPorQtdLocalDeCompraNull() {
		this.itens.adicionaItemPorQtd("Agua Sanitaria Drogon", "limpeza", 1, "l", "", 2.19);
	}

	/**
	 * Esse metodo testa o metodo que permite o controller adicionar ItemPorQtd no
	 * Mapa de itens do controller. Porem passando um preco negativo, esperando a
	 * excecao IllegalArgumentException.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAdicionaItemPorQtdPrecoNegativo() {
		this.itens.adicionaItemPorQtd("Agua Sanitaria Drogon", "limpeza", 1, "l", "Mercado", -2.19);
	}

	/**
	 * Esse metodo testa o metodo que permite o controller adicionar ItemPorUnidade
	 * no Mapa de itens do controller.
	 */
	@Test
	public void testAdicionaItemPorUnidade() {
		this.itens.adicionaItemPorUnidade("Esponja de Aco Assolange", "limpeza", 1, "mercado", 3.50);
	}

	/**
	 * Esse metodo testa o metodo que permite o controller adicionar ItemPorUnidade
	 * no Mapa de itens do controller. Porem sem passar o nome, esperando a excecao
	 * IllegalArgumentException.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAdicionaItemPorUnidadeNomeNulo() {
		this.itens.adicionaItemPorUnidade("", "limpeza", 1, "mercado", 3.50);
	}

	/**
	 * Esse metodo testa o metodo que permite o controller adicionar ItemPorUnidade
	 * no Mapa de itens do controller. Porem sem passar a categoria, esperando a
	 * excecao IllegalArgumentException.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAdicionaItemPorUnidadeCategoriaNulo() {
		this.itens.adicionaItemPorUnidade("Pasta", "", 1, "mercado", 3.50);
	}

	/**
	 * Esse metodo testa o metodo que permite o controller adicionar ItemPorUnidade
	 * no Mapa de itens do controller. Porem passando uma quantidade negativa,
	 * esperando a excecao IllegalArgumentException.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAdicionaItemPorUnidadeQuantidadeNegativa() {
		this.itens.adicionaItemPorUnidade("Detergente", "limpeza", -1, "mercado", 3.50);
	}

	/**
	 * Esse metodo testa o metodo que permite o controller adicionar ItemPorUnidade
	 * no Mapa de itens do controller. Porem sem passar o local de compra do item,
	 * esperando a excecao IllegalArgumentException.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAdicionaItemPorUnidadeLocalDeCompraNull() {
		this.itens.adicionaItemPorUnidade("Detergente", "limpeza", 1, "", 3.50);
	}

	/**
	 * Esse metodo testa o metodo que permite o controller adicionar ItemPorUnidade
	 * no Mapa de itens do controller. Porem passando um preco negativo, esperando a
	 * excecao IllegalArgumentException.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAdicionaItemPorUnidadePrecoNegativo() {
		this.itens.adicionaItemPorUnidade("Detergente", "limpeza", 1, "ml", -1);
	}

	/**
	 * Esse metodo testa o metodo que permite o controller adicionar ItemPorQuilo no
	 * Mapa de itens do controller.
	 */
	@Test
	public void testAdicionaItemPorQuilo() {
		this.itens.adicionaItemPorQuilo("Limao alienigina", "alimento nao industrializado", 1.0,
				"Supermercado Excepcional", 4.19);
	}

	/**
	 * Esse metodo testa o metodo que permite o controller adicionar ItemPorQuilo no
	 * Mapa de itens do controller. Porem sem passar o nome do item, esperando a
	 * excecao IllegalArgumentException.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAdicionaItemPorQuiloNomeNUll() {
		this.itens.adicionaItemPorQuilo("", "alimento nao industrializado", 1.0, "Supermercado Excepcional", 4.19);
	}

	/**
	 * Esse metodo testa o metodo que permite o controller adicionar ItemPorQuilo no
	 * Mapa de itens do controller. Porem sem passar a categoria do item, esperando
	 * a excecao IllegalArgumentException.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAdicionaItemPorQuiloCategoriaNUll() {
		this.itens.adicionaItemPorQuilo("Limao", "", 1.0, "Supermercado Excepcional", 4.19);
	}

	/**
	 * Esse metodo testa o metodo que permite o controller adicionar ItemPorQuilo no
	 * Mapa de itens do controller. Porem passando um peso negativo para o item,
	 * esperando a excecao IllegalArgumentException.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAdicionaItemPorQuiloPesoNegativo() {
		this.itens.adicionaItemPorQuilo("Pera", "alimento nao industrializado", -1, "Mercado", 4.19);
	}

	/**
	 * Esse metodo testa o metodo que permite o controller adicionar ItemPorQuilo no
	 * Mapa de itens do controller. Porem sem passar o local de compra do item,
	 * esperando a excecao IllegalArgumentException.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAdicionaItemPorQuiloSuperMercadoNUll() {
		this.itens.adicionaItemPorQuilo("Pera", "alimento nao industrializado", 1.0, "", 4.19);
	}

	/**
	 * Esse metodo testa o metodo que permite o controller adicionar ItemPorQuilo no
	 * Mapa de itens do controller. Porem passando um preco negativo para o item,
	 * esperando a excecao IllegalArgumentException.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAdicionaItemPorQuiloPrecoNegativo() {
		this.itens.adicionaItemPorQuilo("Pera", "alimento nao industrializado", 1.0, "Mercado", -4.19);
	}

	/**
	 * Esta testando o metodo que atualiza um item passando o id do item desejado,
	 * qual atributo voce deseja atualizar, e o novo valor do atributo. Nesse caso
	 * nao ha objetos com o indice passado.
	 */
	@Test(expected = NullPointerException.class)
	public void testAtualizaItemNulo() {
		this.itens.atualizaItem(0, "quantidade", "2");
	}

	/**
	 * Este teste esta cobrindo o ExibeItem do controller, onde deve ser passado o
	 * id do item desejado e retornara o toString desse Item. Nesse teste o id e
	 * invalido.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testExibeItemIdNegativo() {
		this.itens.exibeItem(-1);
	}

	/**
	 * Este teste esta cobrindo o ExibeItem do controller, onde deve ser passado o
	 * id do item desejado e retornara o toString desse Item. Nesse teste o item e
	 * nulo.
	 */
	@Test(expected = NullPointerException.class)
	public void testExibeItemNulo() {
		this.itens.exibeItem(1);
	}

	/**
	 * Este teste esta cobrindo o metodo deletaItem do controller, metodo que remove
	 * do mapa o item com o id que foi passado.
	 */
	@Test
	public void testDeletaItem() {
		this.itens.adicionaItemPorQtd("Oregano", "alimento industrializado", 60, "grama", "Supermercado SemNome", 1.20);
		this.itens.adicionaItemPorQtd("Cebola", "alimento industrializado", 60, "grama", "Supermercado SemNome", 1.20);
		this.itens.deletaItem("0");
		int tamanhoDoMapa2 = this.itens.getColecaoItens().size();
		assertEquals(tamanhoDoMapa2, 2);
	}

	/**
	 * Este teste esta cobrindo o metodo getItem do controller de itens que retorna
	 * o toString() do item com id que foi passado.
	 */
	@Test
	public void testGetItem() {
		this.itens.adicionaItemPorQtd("Queijo ralado", "alimento industrializado", 60, "grama", "Supermercado SemNome",
				1.20);
		assertEquals("6. Queijo ralado, alimento industrializado, 60 grama, Preco: <Supermercado SemNome, R$ 1,20;>",
				this.itens.getItem(0));
	}

	/**
	 * Este teste esta cobrindo o metodo getItemPorCategoria do controller de itens.
	 */
	@Test
	public void testGetItemPorCategoria() {
		this.itens.adicionaItemPorQtd("Arroz", "alimento industrializado", 60, "grama", "Supermercado SemNome", 1.20);
		assertEquals("4. Arroz, alimento industrializado, 60 grama, Preco: <Supermercado SemNome, R$ 1,20;>",
				this.itens.getItemPorCategoria("alimento industrializado", 0));
	}

	/**
	 * Este teste esta cobrindo o metodo getItemPorMenorPreco do controller de
	 * itens.
	 */
	@Test
	public void testGetItemPorMenorPreco() {
		this.itens.adicionaItemPorQtd("Macarrao", "alimento industrializado", 60, "grama", "Supermercado SemNome",
				1.20);
		assertEquals("11. Macarrao, alimento industrializado, 60 grama, Preco: <Supermercado SemNome, R$ 1,20;>",
				this.itens.getItemPorMenorPreco(0));
	}

	/**
	 * Este teste esta cobrindo o metodo getItemPorPesquisa do controller de itens.
	 */
	@Test
	public void testGetItemPorPesquisa() {
		this.itens.adicionaItemPorQtd("Fini", "alimento industrializado", 60, "grama", "Supermercado SemNome", 1.20);
		assertEquals("3. Fini, alimento industrializado, 60 grama, Preco: <Supermercado SemNome, R$ 1,20;>",
				this.itens.getItemPorPesquisa("Fini", 0));
	}

	/**
	 * Este teste esta cobrindo o metodo getItemInstance do controller de itens.
	 */
	@Test
	public void testGetItemInstance() {
		this.itens.adicionaItemPorQtd("Tomate", "alimento industrializado", 60, "grama", "Supermercado SemNome", 1.20);
		Item item = this.itens.getItemInstance(2);
		assertNotEquals(null, item);
	}

	/**
	 * Este teste esta cobrindo o metodo getItemInstance do controller de itens.
	 * Passando uma posicao negativa.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetItemInstancePosicaoNegativa() {
		this.itens.adicionaItemPorQtd("Peito de Peru", "alimento industrializado", 60, "grama", "Supermercado SemNome",
				1.20);
		this.itens.getItemInstance(-1);
	}

}
