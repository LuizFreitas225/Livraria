package model;

public enum Categoria {
    NACIONAL (1, "LIVRO NACIONAL"),
	INTERNACIONAL (2, "LIVRO INTERNACIONAL");
	
	private int value;
	private String label;
	
	Categoria (int value, String label) {
		this.value = value;
		this.label = label;
	}
	
	public int getValue() {
		return value;
	}
	
	public String getLabel() {
		return label;
	} 
	
	public static Categoria buscarPorValue(int id) {
    	for( Categoria categoria : Categoria.values()) {
    		if( categoria.getValue() == id)
    			return categoria;
    	}
		return null;
    }
}
