package ventanas.controladoresVentanas;

import java.rmi.RemoteException;

import javax.swing.JOptionPane;

import ventanas.managerIFachada;
import Logica.Excepciones.ExcepcionPersistencia;
import Logica.Excepciones.ExcepcionRMI;
import Logica.valueObjects.VOExcursionDisp;

public class controladorExcursionesXDestino {

	public static VOExcursionDisp[] excursionesXDestino(String destino) {
		VOExcursionDisp[] arr=null;
		boolean error = false;
		String MSG = "";
		String DES = destino.trim();
		if(DES.equals(new String(""))){
			error=true;
			MSG = "Error el c�digo no puede ser vac�o";
		}
		if(!error){
			try {
				arr= managerIFachada.getInstancia().getIFachada().excursionesXDestino(destino);
				if(arr.length == 0){
					JOptionPane.showMessageDialog(null,"No hay ninguna excursi�n con ese destino", "Duck Boat Window", 2);
				}
			} catch (ExcepcionPersistencia e) {
				JOptionPane.showMessageDialog(null,e.darMensaje(), "Duck Boat Window", 0);
			} catch (ExcepcionRMI e) {
				JOptionPane.showMessageDialog(null,e.darMensaje(), "Duck Boat Window", 0);
			}catch (RemoteException e){
				JOptionPane.showMessageDialog(null, "Error en la conexi�n", "Duck Boat Window", 0);
			}
		}else{
			JOptionPane.showMessageDialog(null, MSG, "Duck Boat Window", 0);
		}
		return arr;
	}
}
