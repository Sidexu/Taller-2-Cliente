package defaultP;
import java.rmi.Remote;
import java.rmi.RemoteException;

import valueObjects.VOBoletoTipo;
import valueObjects.VOBus;
import valueObjects.VOBusCant;
import valueObjects.VOExcursion;
import valueObjects.VOExcursionDisp;
import Excepciones.ExcepcionBus;
import Excepciones.ExcepcionExcursion;
import Excepciones.ExcepcionPersistencia;

public interface IFachada extends Remote{
	
	//Requerimiento 1
	 public void registroNuevoBus(VOBus vo) throws ExcepcionBus,RemoteException;
	//Requerimiento 2
	 public VOBusCant [] listadoGralBuses()  throws RemoteException;
	//Requerimiento 3
	public VOExcursionDisp [] listadoExcursionesXBus(String mat) throws ExcepcionExcursion, RemoteException;
	//Requerimiento 4
	public void registroExcursion(VOExcursion vo) throws ExcepcionExcursion, ExcepcionBus, RemoteException;
	//Requerimiento 5
	public String reasignacionExcursion(String codigo) throws ExcepcionExcursion, ExcepcionBus, RemoteException;
	//Requerimiento 6
	public void respaldoDatos() throws ExcepcionPersistencia, RemoteException;
	//Requerimiento 7
	public String ventaBoleto(String codEx,VOBoletoTipo vo) throws ExcepcionExcursion, ExcepcionBus, RemoteException;
	//Requerimiento 8
	public float recaudacionExcursion(String codEx) throws ExcepcionExcursion, RemoteException;
	//REQUERIMIENTO 9
	public VOBoletoTipo[] boletosVendidosXEx(String codigo, String tipoBoleto) throws ExcepcionExcursion, RemoteException;
	//REQUERIMIENTO 10
	public VOExcursionDisp[] excursionesXDestino(String destino) throws RemoteException;
	//REQUERIMIENTO 11
	public VOExcursionDisp[] excursionesXPrecio(float precio1, float precio2) throws RemoteException;
}
