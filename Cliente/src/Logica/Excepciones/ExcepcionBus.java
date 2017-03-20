package Logica.Excepciones;

public class ExcepcionBus extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msg;
	
	public ExcepcionBus (String mensaje){ 
		this.msg = mensaje; 
	}
	public String darMensaje(){
		return msg; 
	}
}
