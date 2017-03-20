package Logica.Excepciones;

public class ExcepcionRMI extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msg;

	public ExcepcionRMI(String msg) {
		this.msg = msg;
	}

	public String darMensaje() {
		return msg;
	}
}