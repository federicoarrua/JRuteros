package enumJruteros;

public enum Formato {
	IDA("Ida"),
	CIRCULAR("Circular");
	
	private final String text;
	
	private Formato(final String text){
		this.text = text;
	}
	
	public String toString(){
		return text;
	}
}