package projeto;

/**
 * Enum de categorias usado na verificacao de categorias valida para criacao e atualizacao de items.
 * 
 */
public enum CategoriasEnum {
	
	HIGIENE_PESSOAL("higiene pessoal"), LIMPEZA("limpeza"), ALIMENTO_INDUSTRIALIZADO("alimento industrializado"), ALIMENTO_NAO_INDUSTRIALIZADO("alimento nao industrializado");

	private final String valor;
	
	CategoriasEnum (String valor) {
		this.valor = valor;
	}
	
	public String toString() {
		return valor;
	}
	
	
}
