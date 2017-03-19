package ventanas.controladoresVentanas;


import java.rmi.RemoteException;

import javax.swing.JOptionPane;

import valueObjects.VOBoletoTipo;
import ventanas.managerIFachada;
import Excepciones.ExcepcionExcursion;
import Excepciones.ExcepcionPersistencia;
import Excepciones.ExcepcionRMI;


public class controladorBoletosVendidosXEx {

	
	public static VOBoletoTipo[] boletosVendidosXEx(String codigo, String tipoBoleto) {
		VOBoletoTipo[] arr=null;
		boolean error = false;
		String MSG = "";
		String COD = codigo.trim();
		if(COD.equals(new String(""))){
			error=true;
			MSG = "Error el código no puede ser vacío";
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
				JOptionPane.showMessageDialog(null, "Error en la conexión", "Duck Boat Window", 0);
			}
		}else{
			JOptionPane.showMessageDialog(null, MSG, "Duck Boat Window", 0);
		}
		return arr;
	}
	
}
