package enumJruteros;

public enum Genero {
	M("m"),
	F("f");
	
	private final String text;
	
	private Genero(final String text){
		this.text = text;
	}
	
	public String toString(){
		return text;
	}
}
