package Logica.Excepciones;

public class ExcepcionExcursion extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msg;
	
	public ExcepcionExcursion (String mensaje){ 
		this.msg = mensaje; 
	}
	public String darMensaje(){
		return msg; 
	}
}
