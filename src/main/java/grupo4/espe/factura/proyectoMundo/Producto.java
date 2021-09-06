package grupo4.espe.factura.proyectoMundo;

import com.mongodb.BasicDBObject;

public class Producto {

	// Atributos
	/*
	 * Codigo del producto
	 */
	private String codigo;
	/*
	 * Descripcion del producto
	 */
	private String descripcion;
	/*
	 * Precio unitario del producto
	 */
	private double precio;
	/*
	 * Cantidad disponible en inventario
	 */
	private int cantidad;

	public Producto(String codigo, String descripcion, double precio, int cantidad) {

		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precio = precio;
		this.cantidad = cantidad;
	}
	
	public Producto() {
		
		
	}

	public BasicDBObject toDBObjectProducto() {

		// Creamos una instancia BasicDBObject
		BasicDBObject dBObjectProducto = new BasicDBObject();

		// Agrega el valor del atributo nombre al objeto de mongoDB
		dBObjectProducto.append("codigo", this.getCodigo());

		// Agrega el valor del atributo precio al objeto de mongoDB
		dBObjectProducto.append("descripcion", this.getDescripcion());

		// Agrega el valor del atributo precio al objeto de mongoDB
		dBObjectProducto.append("precio", this.getPrecio());

		// Agrega el valor del atributo precio al objeto de mongoDB
		dBObjectProducto.append("cantidad", this.getCantidad());
		return dBObjectProducto;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "Producto [codigo=" + this.codigo + ", descripcion=" + this.descripcion + ", precio=" + this.precio
				+ ", cantidad=" + this.cantidad + "]";
	}

}
