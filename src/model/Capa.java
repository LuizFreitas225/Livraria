package model;

public enum Capa {
    
    
        DURA (1, "DURA"),
        MOLE (2, "MOLE");
        
        private int value;
        private String label;
        
        Capa (int value, String label) {
            this.value = value;
            this.label = label;
        }
        
        public int getValue() {
            return value;
        }
        
        public String getLabel() {
            return label;
        }
    
        public static Capa buscarPorValue(int id) {
        	for( Capa capa : Capa.values()) {
        		if( capa.getValue() == id)
        			return capa;
        	}
			return null;
        }
}
