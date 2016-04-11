package enumJruteros;

public enum Dificultad {
	FACIL("Fácil"),
	MODERADO("Moderado"),
	DIFICIL("Difícil"),
	MUYDIFICIL("Muy Difícil"),
	EXPERTO("Experto");
	
	private final String text;
	
	private Dificultad(final String text){
		this.text = text;
	}
	
	public String toString(){
		return text;
	}
}
