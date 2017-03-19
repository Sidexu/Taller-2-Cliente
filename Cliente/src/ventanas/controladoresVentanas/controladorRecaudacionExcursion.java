package ventanas.controladoresVentanas;

import java.rmi.RemoteException;
import javax.swing.JOptionPane;

import ventanas.managerIFachada;
import Excepciones.ExcepcionExcursion;
import Excepciones.ExcepcionPersistencia;
import Excepciones.ExcepcionRMI;

public class controladorRecaudacionExcursion {

	public static void recaudacionExcursion(String codEx) {
		float recaudacion=0;
		boolean error = false;
		String MSG = "";
		String COD = codEx.trim();
		if(COD.equals(new String(""))){
			error=true;
			MSG = "Error el c�digo no puede ser vac�o";
		}
		if(!error){
			try {
				recaudacion= managerIFachada.getInstancia().getIFachada().recaudacionExcursion(codEx);
				JOptionPane.showMessageDialog(null, "La recaudaci�n para la excursi�n "+codEx+" es: "+recaudacion, "Duck Boat Window", 1);
			} catch (ExcepcionPersistencia e) {
				JOptionPane.showMessageDialog(null,e.darMensaje(), "Duck Boat Window", 0);
			} catch (ExcepcionRMI e) {
				JOptionPane.showMessageDialog(null,e.darMensaje(), "Duck Boat Window", 0);
			}catch(ExcepcionExcursion e){
				JOptionPane.showMessageDialog(null,e.darMensaje(), "Duck Boat Window", 0);
			}catch (RemoteException e){
				JOptionPane.showMessageDialog(null, "Error en la conexi�n", "Duck Boat Window", 0);
			}
		}else{
			JOptionPane.showMessageDialog(null, MSG, "Duck Boat Window", 0);
		}
		
	}
}
