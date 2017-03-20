package Logica.Excepciones;

public class ExcepcionVentana extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msg;

	public ExcepcionVentana(String msg) {
		this.msg = msg;
	}

	public String darMensaje() {
		return msg;
	}
}