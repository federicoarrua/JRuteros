package enumJruteros;

public enum Privacidad {
	PUBLICA("Pública"),
	PRIVADA("Privada");
	
	private final String text;
	
	private Privacidad(final String text){
		this.text = text;
	}
	
	public String toString(){
		return text;
	}
}