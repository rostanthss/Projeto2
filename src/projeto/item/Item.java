package projeto.item;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Set;

import projeto.CategoriasEnum;
/**
 * 
 * @author Igor Franca, Cleciana Santana
 * 
 */
public abstract class Item implements Comparable<Item>, Serializable {

    /**
	 * SerialID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Int que identifica um item, eh unico e gerado automaticamente apos a criacao do objeto
	 */
	private int idItem;
	/**
	 * Descreve um item / nome de comercializacao. Ex.: Queijo Coalho DaCasa
	 */
    private String nome;
    /**
     * Preco de comercializacao do item.
     */
    private double preco;
    /**
     * Listagem de categorias as quais um item pode pertencer.
     */
    private CategoriasEnum categoria;
    /**
     * Mapa que relaciona uma String que representa o localDeCompra, com um Double que indica o preco do item
     */
    private HashMap <String,Double> mapaLocalPrecos;

    /**
     * Construtor de Item, nao pode ser instanciado, eh usado para setar atributos comuns a todos os itens.
     * 
     * @param nome
     * 			nome do item
     * @param categoria
     * 			categoria a qual o item pertence
     * @param localDeCompra
     * 			onde o item pode ser comprado
     * @param preco
     * 			valor de comercializacao do item
     */
	public Item(String nome, String categoria, String localDeCompra, double preco){

		this.setNome(nome);
		this.setCategoria(categoria);
		this.setPreco(preco);
	    this.mapaLocalPrecos = new HashMap<>();
	    adicionaPreco(localDeCompra, preco);
    }

	/**
	 * Metodo usado para adicionar um local de compra e um preco ao Item
	 * 
	 * @param localDeCompra
	 * 			Estabelecimento em que foi realizada a compra
	 * @param preco
	 * 			Custo do item no estabelecimento
	 */
	public void adicionaPreco(String localDeCompra, double preco) {

		if (localDeCompra.trim().isEmpty() || localDeCompra == null) {
			throw new IllegalArgumentException("local de compra nao pode ser vazio ou nulo.");
		}
		if (preco < 0) {
			throw new IllegalArgumentException("preco de item invalido.");
		}
		mapaLocalPrecos.put(localDeCompra, preco);
	}
	
	/**
	 * Pega o preco do item
	 * 
	 * @return
	 * 			Double, preco do item
	 */
    public double getPreco() {
        return this.preco;
    }

	/**
	 * Pega o nome do item
	 * 
	 * @return
	 * 			String, nome do item
	 */
    public String getNome() {
        return this.nome;
    }

	/**
	 * Pega a categoria do item
	 * 
	 * @return
	 * 			String, categoria do item
	 */
    public String getCategoria() {
        return this.categoria.toString();
    }
    
	/**
	 * Pega a listagem de categorias do item
	 * 
	 * @return
	 * 			CategoriasEnum
	 */
    public CategoriasEnum getCategoriasEnum() {
        return this.categoria;
    }
	
    /**
     * Retorna o mapa de precos do item
     */
	public HashMap<String,Double> getMapaDeLocalEPrecos(){
		return this.mapaLocalPrecos;
	}
    
    /**
     * Seta a categoria do item para a string passada como parametro.
     * 
     * @param categoria
     * 			categoria do item
     */
    public void setCategoria(String categoria) {
		if (categoria.trim().isEmpty() || categoria == null) {
			throw new IllegalArgumentException("categoria nao pode ser vazia ou nula.");
		}
		
		try {
			this.categoria = CategoriasEnum.valueOf(categoria.toUpperCase().replaceAll(" ", "_"));
		} catch (Exception e) {
			throw new IllegalArgumentException("categoria nao existe.");
		}
    }

    /**
     * Atualiza o preco atual do item
     * 
     * @param preco
     * 			double, indica o preco
     */
    public void setPreco(double preco) {
		if (preco < 0) {
			throw new IllegalArgumentException("preco de item invalido.");
		}
        this.preco = preco;
    }

    /**
     * Altera o nome do item para o nome recebido
     * 
     * @param nome
     * 			String que indica o novo nome de item
     */
    public void setNome(String nome) {
		if (nome.trim().isEmpty()|| nome == null) {
			throw new IllegalArgumentException("nome nao pode ser vazio ou nulo.");
		}
        this.nome = nome;
    }

	/**
	 * Retorna uma string representacao contendo todos os locais de compra e preco associados
	 * 
	 * @return
	 * 			String contendo todos os locais de compra e precos
	 */
	public String exibirPrecos() {
		String saida = "<";
		Set<java.util.Map.Entry<String, Double>> auxiliar = mapaLocalPrecos.entrySet();
		
		for (java.util.Map.Entry<String, Double> entry : auxiliar) {
			saida += entry.getKey() + ", R$ " + String.format("%.2f", entry.getValue()).replace(".",",") + ";";
		}
		return saida + ">";
	}

	/**
	 * Acessa o id de um item
	 * 
	 * @return
	 * 			inteiro que identifica o item
	 */
	public int getIdItem() {
		return this.idItem;
	}
	
	/**
	 * Usado pelo controller para atribuir um id ao item se este for criado com sucesso
	 * 
	 * @param id
	 * 			int que identifica o item
	 */
	void setId(int id) {
		this.idItem = id;
	}
	
	/**
	 * Verifica se dois itens são iguais, baseado em seus nomes e categorias
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (categoria != other.categoria)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

    /**
     * Gera um inteiro único de cada objeto Item que o identifica como sendo deste tipo.
     */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

    /**
     * Configura a comparacao de dois itens, usando seus nomes, por ordem alfabetica
     */
	@Override
	public int compareTo(Item item) {
		return this.getNome().compareTo(item.getNome());
	}
	
	/**
	 * Metodo auxiliar, retorna informacoes proprias de um Item: NOME, CATEGORIA.
	 */
	public String getInfo() {
		return this.nome + ", " + this.categoria;
	}

    /**
     * Retorna uma representacao do objeto no formato
     * ID. NOME, CATEGORIA
     */
    @Override
    public String toString() {
    	return this.idItem + ". " + this.nome + ", " + this.categoria;
    }
	
}
