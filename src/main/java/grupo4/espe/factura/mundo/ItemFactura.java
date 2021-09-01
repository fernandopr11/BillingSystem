package grupo4.espe.factura.mundo;


/*
Clase que representa al cliente al item de la factura
*/

public class ItemFactura {

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/*
	 * Cantidad comprada de cada producto
	 */
	private int cantidad;

	/*
	 * Objeto producto
	 */
	private Producto producto;

	/*
	 * Constructor el cual crea un item de la factura con la cantidad comprada y el
	 * objeto producto
	 * 
	 * @param cantidad cantidad comprada de cada producto, cantidad > 0 && cantidad
	 * != 0 != ""
	 * 
	 * @param producto producto comprado en la tienda con la inicializacion de sus
	 * atributos
	 * 
	 * 
	 */

	public ItemFactura(int cantidad, Producto producto) {
		this.cantidad = cantidad;
		this.producto = producto;
	}

	/**
	 * Retorna la cantidad especifica comprada de cada producto
	 * 
	 * @return La cantidad especifica
	 */
	public int getCantidad() {
		return cantidad;
	}

	/**
	 * @param la cantidad de cada producto
	 * 
	 *           Modifica el valor de la cantidad
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * Retorna el objeto producto
	 * 
	 * @return El objeto producto
	 */
	public Producto getProducto() {
		return producto;
	}

	/**
	 * @param el objeto producto
	 * 
	 *           Modifica el valor de los atributos del objeto producto
	 */
	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	/**
	 * Retorna el importe
	 * 
	 * @return cantidad multiplicada por el precio del producto
	 */
	public Double calcularImporte() {
		return this.cantidad * this.producto.getPrecio();
	}

	@Override
	public String toString() {
		return producto.toString() + "\t" + cantidad + "\t" + calcularImporte();
	}
}
