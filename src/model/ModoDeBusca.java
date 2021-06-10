package model;

public enum ModoDeBusca  {
	 NOME(1, "Nome"),
     AUTOR (2, "Autor"),
     DEFAULT(3, "Default");;
      
      private int value;
      private String label;
      
      ModoDeBusca  (int value, String label) {
          this.value = value;
          this.label = label;
      }
      
      public int getValue() {
          return value;
      }
      
      public String getLabel() {
          return label;
      }
  
      public static ModoDeBusca  buscarPorValue(int id) {
      	for( ModoDeBusca  modo : ModoDeBusca.values()) {
      		if( modo.getValue() == id)
      			return modo;
      	}
			return null;
      }
}
