package grupo4.espe.factura.mundo;

import java.io.Serializable;
import java.util.ArrayList;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;

/*
 Clase que representa a los productos
 */

public class Producto {

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/*
	 * Primer producto agregado
	 */

	private int codigo;

	/*
	 * Nombre del producto
	 */
	private String nombre;

	/*
	 * Precio del producto
	 */
	private double precio;
	/*
	 * Codigo del ultimo producto agregado
	 */

	private static int ultimoCodigo;

	/*
	 Constructor que inicializa el codigo del primer producto con el ultimo producto agregado
	 */
	
	public Producto() {

		this.codigo = ++ultimoCodigo;

	}

	/*
	 * Constructor que crea un producto con el precio
	 * @param precio > precio del producto
	 * != ""
	 * 
	 */
	public Producto(Float precio) {

		this.precio = precio;

	}
	
	/*
	 * Constructor que crea un producto con el nombre y el precio
	 * @param pNombre > nombre del producto
	 * @param pPrecio > precio del producto
	 * != ""
	 * 
	 */
	public Producto(String pNombre, double pPrecio) {

		this.nombre = pNombre;
		this.precio = pPrecio;
	}

	/*
	 * Constructor para transforma un objeto de MongoDb a un Objeto Java
	 * 
	 * @param dbOjectCliente
	 */
	public Producto(BasicDBObject dbObjectProducto) {
		
		// Obtiene el valor del atributo nombre mediante el metodo getString
		this.nombre = dbObjectProducto.getString("nombre");
		
		// Obtiene el valor del atributo precio mediante el metodo getString
		this.precio = dbObjectProducto.getDouble("precio");

	}

	/*
	 * Metodo utlizado para mostrar, agregar los atributos de la clase producto al
	 * objeto mongoDB
	 *
	 * @return dbOjectCliente
	 */
	
	public BasicDBObject toDBObjectProducto() {

		// Creamos una instancia BasicDBObject
		BasicDBObject dBObjectProducto = new BasicDBObject();

		// Agrega el valor del atributo nombre al objeto de mongoDB
		dBObjectProducto.append("nombre", this.getNombre());
		
		// Agrega el valor del atributo precio al objeto de mongoDB
		dBObjectProducto.append("precio", this.getPrecio());

		return dBObjectProducto;
	}

	/**
	 * Retorna el codigo del producto
	 * 
	 * @return El codigo del producto
	 */
	public int getCodigo() {
		return codigo;
	}
	
	/**
	 * Retorna el nombre del producto
	 * 
	 * @return El nombre del producto
	 */

	public String getNombre() {
		return nombre;
	}
	
	/**
	 * @param nombre Nombre del producto
	 * 
	 *                 Modifica el valor del atributo nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Retorna el precio
	 * 
	 * @return El precio del producto
	 */
	public Double getPrecio() {
		return precio;
	}

	/**
	 * @param precio > Precio del producto
	 * 
	 *                 Modifica el valor del atributo precio
	 */
	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	@Override
	/*
	 * Return el valor de cada uno de los atributos del producto
	 */
	public String toString() {
		return codigo + "\t" + nombre + "\t" + precio;
	}
}
