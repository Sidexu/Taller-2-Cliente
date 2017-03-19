package ventanas.controladoresVentanas;

import java.rmi.RemoteException;
import javax.swing.JOptionPane;

import ventanas.managerIFachada;
import Excepciones.ExcepcionBus;
import Excepciones.ExcepcionExcursion;
import Excepciones.ExcepcionPersistencia;
import Excepciones.ExcepcionRMI;
import valueObjects.VOBoletoTipo;

public class controladorVentaBoleto {
	
	public static void ventaBoleto(String codigo,String edad,String procedencia,String cel,String descuento) 
	{
		boolean error = false;
		
		String COD = codigo.trim();
		if(COD.equals(new String(""))){
			error=true;
			JOptionPane.showMessageDialog(null,"Error el c�digo no puede ser vac�o", "Duck Boat Window", 0);	
		}else{
			String PROC = procedencia.trim();
			if(PROC.equals(new String(""))){
				error=true;
				JOptionPane.showMessageDialog(null,"Error la procedencia no puede ser vac�a", "Duck Boat Window", 0);
			}
		}
		
		if(!error){
			try{
				float DESC= Float.parseFloat(descuento);
				if(DESC < 0){
					error=true;
					JOptionPane.showMessageDialog(null,"Error, el descuento no puede ser negativo", "Duck Boat Window", 0);	
				}
			}catch(NumberFormatException e){
				error=true;
				JOptionPane.showMessageDialog(null,"Error, el descuento debe ser numerico", "Duck Boat Window", 0);	
			}
		}
		if(!error){
			try{
				int EDAD= Integer.parseInt(edad);
				if(EDAD < 0 || EDAD>150){
					error=true;
					JOptionPane.showMessageDialog(null,"Error, la edad no puede ser negativa o mayor a 150 a�os", "Duck Boat Window", 0);
				}
			}catch(NumberFormatException e){
				error=true;
				JOptionPane.showMessageDialog(null,"Error, la edad debe ser numerica", "Duck Boat Window", 0);
			}
		}
		if(!error){
			try{
				long CEL= Long.parseLong(cel);
				if(CEL < 0){
					error=true;
					JOptionPane.showMessageDialog(null,"Error, el celular no puede ser negativo", "Duck Boat Window", 0);
				}
			}catch(NumberFormatException e){
				error=true;
				JOptionPane.showMessageDialog(null,"Error, el celular debe ser numerico o super� el tama�o m�ximo admitido", "Duck Boat Window", 0);
			}
		}
	
			if(!error){
				VOBoletoTipo voBol= new VOBoletoTipo(0,Integer.parseInt(edad),procedencia,Long.parseLong(cel),Float.parseFloat(descuento));
		
				try {
					String result="";
					result=managerIFachada.getInstancia().getIFachada().ventaBoleto(codigo, voBol);
					JOptionPane.showMessageDialog(null,"Se ingres� el boleto correctamente!"+result, "Duck Boat Window", 1);
				} catch (ExcepcionPersistencia e) {
					JOptionPane.showMessageDialog(null,e.darMensaje(), "Duck Boat Window", 0);
				} catch (ExcepcionRMI e) {
					JOptionPane.showMessageDialog(null,e.darMensaje(), "Duck Boat Window", 0);
				}catch(ExcepcionBus e){
					JOptionPane.showMessageDialog(null,e.darMensaje(), "Duck Boat Window", 0);
				}catch(ExcepcionExcursion e){
					JOptionPane.showMessageDialog(null,e.darMensaje(), "Duck Boat Window", 0);
				}catch (RemoteException e){
					JOptionPane.showMessageDialog(null, "Error en la conexi�n", "Duck Boat Window", 0);
				}
			}

	}
}
