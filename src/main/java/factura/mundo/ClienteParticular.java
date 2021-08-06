package factura.mundo;

import java.util.ArrayList;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;


/*
Clase que representa al cliente particular
*/

public class ClienteParticular extends Cliente {

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/*
	 * Numero de cedula del cliente
	 */
	private String cedula;

	/*
	 * Nombre del cliente
	 */
	private String nombre;

	/*
	 * ArraysList de tipo string de los clientes particulares
	 */
	private ArrayList<String> particulares;

	/*
	 * Constructor el cual crea un cliente particular con el nombre y el numero de
	 * cedula Invoca al constructor padre mediante la palabra reservada super
	 * 
	 * @param telefono numero de telefono del cliente, telefono != null && telefono
	 * != ""
	 * 
	 * @param correo correo electronico del cliente, correo != null && correo != ""
	 * 
	 * @param direccion direccion del domicilio del, cliente direccion != null &&
	 * direccion != ""
	 * 
	 * @param pCedula numero de cedula del cliente particular
	 * 
	 * @param pNombre nombre del cliente particular
	 * 
	 */
	public ClienteParticular(String telefono, String correo, String direccion, String pCedula, String pNombre) {

		super(telefono, correo, direccion);

		this.cedula = pCedula;
		this.nombre = pNombre;

	}

	/*
	 * Constructor para transformar un objeto de MongoDb a un Objeto Java
	 * 
	 * @param dbOjectCliente
	 */
	public ClienteParticular(BasicDBObject dbObjectClienteParticular) {

		// Obtiene el valor del atributo nombre mediante el metodo getString
		this.nombre = dbObjectClienteParticular.getString("nombre");

		// Obtiene el valor del atributo cedula mediante el metodo getString
		this.cedula = dbObjectClienteParticular.getString("cedula");

		BasicDBList lisClientes = (BasicDBList) dbObjectClienteParticular.get("particulares");

		// Crea un nuevo arrayList de tipo string
		this.particulares = new ArrayList<String>();

		// Recorre el array list de clientes y agrega al array el objeto part llamando al
		// metodo toString
		for (Object part : lisClientes) {
			this.particulares.add(part.toString());
		}
	}

	/*
	 * Metodo utlizado para mostrar agregar los atributos de la clase
	 * clienteParticular al objeto mongoDB
	 *
	 * @return dbOjectCliente
	 */

	public BasicDBObject toDBObjectClienteParticular() {

		// Creamos una instancia BasicDBObject
		BasicDBObject dBObjectClienteParticular = new BasicDBObject();

		// Agrega el valor del atributo nombre al objeto de mongoDB
		dBObjectClienteParticular.append("Nombre: ", this.getNombre());

		// Agrega el valor del atributo cedula al objeto de mongoDB
		dBObjectClienteParticular.append("Cedula: ", this.getCedula());

		// Agrega el valor del atributo telefono al objeto de mongoDB
		dBObjectClienteParticular.append("Telefono: ", this.getTelefono());

		// Agrega el valor del atributo direccion al objeto de mongoDB
		dBObjectClienteParticular.append("Direccion: ", this.getDireccion());

		// Agrega el valor del atributo correo al objeto de mongoDB
		dBObjectClienteParticular.append("Correo Electronico: ", this.getCorreo());

		// Retorna el objeto mondoDB
		return dBObjectClienteParticular;
	}

	/**
	 * Retorna el numero de cedula
	 * 
	 * @return El numero de cedula
	 */

	public String getCedula() {
		return cedula;
	}

	/**
	 * @param cedula Numero de cedula del cliente
	 * 
	 *               Modifica el valor del atributo cedula
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	/**
	 * Retorna el nombre del cliente
	 * 
	 * @return El nombre del cliente
	 */

	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre Nombre del cliente
	 * 
	 *       Modifica el valor del atributo nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/*
	 * Return el valor de cada uno de los atributos del cliente particular
	 */
	public String toString() {

		return "Nombre: " + this.getNombre() + " / Cedula: " + this.getCedula() + "Telefono: " + this.getTelefono()

				+ " / Correo: " + this.getCorreo() + "/ Direccion: " + this.getDireccion();

	}

}
