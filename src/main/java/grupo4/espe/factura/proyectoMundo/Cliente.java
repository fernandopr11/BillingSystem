package grupo4.espe.factura.proyectoMundo;

import com.mongodb.BasicDBObject;

public class Cliente {

	// Atributos
	/*
	 * Cedula o RUC de cliente
	 */
	private String cedula;
	/*
	 * Nombre de cliente
	 */
	private String nombre;
	/*
	 * Numero de telefono
	 */
	private int telefono;
	/*
	 * Correo del cliente
	 */
	private String correo;
	/*
	 * Direccion del cliente
	 */
	private String direccion;

	public Cliente(String cedula, String nombre, int telefono, String correo, String direccion) {
		this.cedula = cedula;
		this.nombre = nombre;
		this.telefono = telefono;
		this.correo = correo;
		this.direccion = direccion;
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

		// Agrega el valor del atributo cedula al objeto de mongoDB
		dBObjectCliente.append("cedula", this.getCedula());

		// Agrega el valor del atributo nombre al objeto de mongoDB
		dBObjectCliente.append("nombre", this.getNombre());

		// Agrega el valor del atributo telefono al objeto de mongoDB
		dBObjectCliente.append("telefono", this.getTelefono());

		// Agrega el valor del atributo correo al objeto mondoDB
		dBObjectCliente.append("correo", this.getCorreo());

		// Agrega el valor del atributo direccion al objeto mongoDB
		dBObjectCliente.append("direccion", this.getDireccion());

		// Retorna el objeto mongo db
		return dBObjectCliente;
	}

	public String getCedula() {
		return cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public int getTelefono() {
		return telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Cliente [cedula=" + cedula + ", nombre=" + nombre + ", telefono=" + telefono + ", correo=" + correo
				+ ", direccion=" + direccion + "]";
	}

}
