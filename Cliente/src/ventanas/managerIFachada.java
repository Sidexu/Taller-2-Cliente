package ventanas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.util.Properties;

import Logica.Excepciones.ExcepcionPersistencia;
import Logica.Excepciones.ExcepcionRMI;
import defaultP.IFachada;


public class managerIFachada {
	private static managerIFachada instancia;
	private IFachada fach;
	
	private managerIFachada() throws ExcepcionPersistencia, ExcepcionRMI
	{
		try 
		{
			Properties p = new Properties();
			String nomArch = "config/config.properties";
			p.load (new FileInputStream (nomArch));
			String ip = p.getProperty("ipServidor");
			String puerto = p.getProperty("puertoServidor");
			String ruta = "//" + ip + ":" + puerto + "/obj";
			fach = (IFachada) Naming.lookup(ruta);
		}catch (FileNotFoundException e)
		{
			throw new ExcepcionPersistencia("Error al leer el archivo de configuraci�n");
		}
		catch (NotBoundException | IOException e) 
		{
			throw new ExcepcionRMI("Error de comunicacion");
		}
	}
	
	public static managerIFachada getInstancia() throws ExcepcionPersistencia, ExcepcionRMI
	{
		try{
			instancia = new managerIFachada();
		}catch (ExcepcionPersistencia e){
			throw new ExcepcionPersistencia(e.darMensaje());
		} catch (ExcepcionRMI e) {
			throw new ExcepcionRMI(e.darMensaje());
		}
		
		
		return instancia;
	}
	
	public IFachada getIFachada()
	{
		return fach;
	}
}
