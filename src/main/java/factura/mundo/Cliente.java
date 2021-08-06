package factura.mundo;

import java.util.ArrayList;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;

/*
 Clase que representa al cliente
*/

public class Cliente {

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/*
	 * El telefono del cliente
	 */
	protected String telefono;

	/*
	 * El correo electronico del cliente
	 */
	protected String correo;

	/*
	 * La direccion de la vivienda del cliente
	 */
	protected String direccion;

	/*
	 * ArraysList de tipo string de los clientes
	 */
	protected ArrayList<String> clientes;

	/*
	 * Constructor el cual crea un cliente con su numero de telefono, correo
	 * electronico y la direccion del domicilio
	 * 
	 * @param telefono numero de telefono del cliente, telefono != null && telefono
	 * != ""
	 * 
	 * @param correo correo electronico del cliente, correo != null && correo != ""
	 * 
	 * @param direccion direccion del domicilio del, cliente direccion != null &&
	 * direccion != ""
	 * 
	 */

	public Cliente(String telefono, String correo, String direccion) {

		this.telefono = telefono;
		this.correo = correo;
		this.direccion = direccion;
	}

	/*
	 * Constructor vacio del cual inicializa los atributos como una cadena vacia
	 */
	public Cliente() {

		telefono = "";
		correo = "";
		direccion = "";

	}

	/*
	 * Constructor para transforma un objeto de MongoDb a un Objeto Java
	 * 
	 * @param dbOjectCliente
	 */

	public Cliente(BasicDBObject dbObjectCliente) {

		// Obtiene el valor del atributo telefono mediante el metodo getString
		this.telefono = dbObjectCliente.getString("telefono");

		// Obtiene el valor del atributo correo mediante el metodo getString
		this.correo = dbObjectCliente.getString("correo");

		// lisClientes obtiene el valor del array list de nombre clientes
		BasicDBList lisClientes = (BasicDBList) dbObjectCliente.get("clientes");

		// Crea un nuevo arrayList de tipo string
		this.clientes = new ArrayList<String>();

		// Recorre el array list de clientes y agrega al array el objeto cli llamando al
		// metodo toString
		for (Object cli : lisClientes) {
			this.clientes.add(cli.toString());
		}
	}

	/*
	 * Metodo utlizado para mostrar, agregar los atributos de la clase cliente al
	 * objeto mongoDB
	 *
	 * @return dbOjectCliente
	 */
	public BasicDBObject toDBObjeCliente() {

		// Creamos una instancia BasicDBObject
		BasicDBObject dBObjectCliente = new BasicDBObject();

		// Agrega el valor del atributo telefono al objeto de mongoDB
		dBObjectCliente.append("Telefono: ", this.getTelefono());

		// Agrega el valor del atributo correo al objeto mondoDB
		dBObjectCliente.append("Correo: ", this.getCorreo());

		// Agrega el valor del atributo direccion al objeto mongoDB
		dBObjectCliente.append("Direccion: ", this.getDireccion());

		// Retorna el objeto mongo db
		return dBObjectCliente;
	}

	/**
	 * Retorna el numero de telefono
	 * 
	 * @return El numero de telefono
	 */

	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono Numero de telefono del cliente.
	 * 
	 *                 Modifica el valor del atributo telefono
	 */

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * Retorna el correo electronico del cliente
	 * 
	 * @return El correo electronico
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * @param correo Correo electronico del cliente
	 * 
	 *               Modifica el valor del correo electronico
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/**
	 * Retorna la direccion del domicilio del cliente
	 * 
	 * @return La direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion Direccion del domicilio del cliente
	 * 
	 *                  Modifica la direccion
	 */

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/*
	 * Return el valor de cada uno de los atributos del cliente
	 */

	public String toString() {

		return "Telefono: " + this.getTelefono() + " / Correo: " + this.getCorreo() + "/ Direccion: "
				+ this.getDireccion();

	}
}
