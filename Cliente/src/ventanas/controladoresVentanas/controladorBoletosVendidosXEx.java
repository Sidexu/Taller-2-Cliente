package ventanas.controladoresVentanas;


import java.rmi.RemoteException;

import javax.swing.JOptionPane;

import ventanas.managerIFachada;
import Logica.Excepciones.ExcepcionExcursion;
import Logica.Excepciones.ExcepcionPersistencia;
import Logica.Excepciones.ExcepcionRMI;
import Logica.valueObjects.VOBoletoTipo;


public class controladorBoletosVendidosXEx {

	
	public static VOBoletoTipo[] boletosVendidosXEx(String codigo, String tipoBoleto) {
		VOBoletoTipo[] arr=null;
		boolean error = false;
		String MSG = "";
		String COD = codigo.trim();
		if(COD.equals(new String(""))){
			error=true;
			MSG = "Error el c�digo no puede ser vac�o";
		}
		if(!error){
			try {
				arr= managerIFachada.getInstancia().getIFachada().boletosVendidosXEx(codigo, tipoBoleto);
				if(arr.length == 0){
					JOptionPane.showMessageDialog(null,"No hay datos para listar", "Duck Boat Window", 2);
				}
			} catch (ExcepcionPersistencia e){
				JOptionPane.showMessageDialog(null, e.darMensaje(), "Duck Boat Window", 0);
			} catch (ExcepcionRMI e) {
				JOptionPane.showMessageDialog(null, e.darMensaje(), "Duck Boat Window", 0);
			} catch (ExcepcionExcursion e) {
				JOptionPane.showMessageDialog(null, e.darMensaje(), "Duck Boat Window", 0);
			}catch (RemoteException e){
				JOptionPane.showMessageDialog(null, "Error en la conexi�n", "Duck Boat Window", 0);
			}
		}else{
			JOptionPane.showMessageDialog(null, MSG, "Duck Boat Window", 0);
		}
		return arr;
	}
	
}
