package factura.mundo;

import java.util.ArrayList;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;

/*
Clase que representa al cliente empresa
*/
public class ClienteEmpresa extends Cliente {	
	

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/*
	 * Numero de ruc de la empresa 
	 */
	private String ruc;
	
	/*
	 * Nombre de la empresa 
	 */
	private String nombreEmpresa;
	
	/*
	 * ArrayList de tipo string de los clientes empresariales
	 */
	private ArrayList<String> empresa;
	
	
	/*
	 * Constructor el cual crea un cliente de tipo empresa con el nombre de la empresa y el numero de
	 * ruc Invoca al constructor padre mediante la palabra reservada super
	 * 
	 * @param telefono numero de telefono del cliente, telefono != null && telefono
	 * != ""
	 * 
	 * @param correo correo electronico del cliente, correo != null && correo != ""
	 * 
	 * @param direccion direccion del domicilio del, cliente direccion != null &&
	 * direccion != ""
	 * 
	 * @param pRuc numero de RUC de la empres
	 * 
	 * @param pNombreEmpresa nombre del la empresa
	 * 
	 */
	public ClienteEmpresa(String telefono, String correo, String direccion, String pRuc, 
			String pNombreEmpresa) {
		super(telefono, correo, direccion);
		
		this.ruc = pRuc;
		this.nombreEmpresa = pNombreEmpresa;
		
	}
	/*
	 * Constructor para transforma un objeto de MongoDb a un Objeto Java
	 * 
	 * @param dbOjectCliente
	 */
	
	public ClienteEmpresa(BasicDBObject dbObjectClienteEmpresa) {

		super(dbObjectClienteEmpresa);
		
		// Obtiene el valor del atributo nombreEmpresa mediante el metodo getString
		this.nombreEmpresa = dbObjectClienteEmpresa.getString("nombreEmpresa");

		// Obtiene el valor del atributo RUC mediante el metodo getString
		this.ruc = dbObjectClienteEmpresa.getString("ruc");

		
	}
	
	/*
	 * Metodo utlizado para mostrar agregar los atributos de la clase
	 * clienteEmpresa al objeto mongoDB
	 *
	 * @return dbOjectCliente
	 */
	
	public BasicDBObject toDBObjectClienteEmpresa() {

		
		// Creamos una instancia BasicDBObject
		BasicDBObject dBObjectClienteEmpresa = new BasicDBObject();
		
		// Agrega el valor del atributo nombreEmpresa al objeto de mongoDB
		dBObjectClienteEmpresa.append("nombreEmpresa", this.getNombreEmpresa());
		
		// Agrega el valor del atributo ruc al objeto de mongoDB
		dBObjectClienteEmpresa.append("ruc", this.getRuc());
		
		// Agrega el valor del atributo telefono al objeto de mongoDB
		dBObjectClienteEmpresa.append("telefono", this.getTelefono());
		
		// Agrega el valor del atributo correo al objeto de mongoDB
		dBObjectClienteEmpresa.append("correo", this.getCorreo());
		
		// Agrega el valor del atributo direccion al objeto de mongoDB
		dBObjectClienteEmpresa.append("direccion", this.getDireccion());
		
		
		// Retorna el objeto mondoDB
		return dBObjectClienteEmpresa;
	}

	/**
	 * Retorna el numero de ruc
	 * 
	 * @return El numero de ruc
	 */
	
	public String getRuc() {
		return ruc;
	}

	/**
	 * @param cedula Numero de ruc de la empresa
	 * 
	 *               Modifica el valor del atributo ruc
	 */
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	/**
	 * Retorna el nombre de la empresa
	 * 
	 * @return El nombre de la empresa
	 */
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	/**
	 * @param nombreEmpresa Nombre de la empresa
	 * 
	 *       Modifica el valor del atributo nombreEmpresa
	 */

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}
	
	
	/*
	 * Return el valor de cada uno de los atributos del cliente empresa
	 */
	
	public String toString() {
		
		return "Nombre: " + this.getNombreEmpresa() + " / Ruc: " + this.getRuc() + "Telefono: " + this.getTelefono()
		
		+ " / Correo: " + this.getCorreo() + "/ Direccion: " + this.getDireccion() ;
	}    

}
