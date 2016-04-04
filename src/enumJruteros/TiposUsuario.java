package enumJruteros;

public enum TiposUsuario {
	ADMIN("admin"),
	REGULAR("regular");
	
	private final String text;
	
	private TiposUsuario(final String text){
		this.text = text;
	}
	
	public String toString(){
		return text;
	}
}
