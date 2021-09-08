package grupo4.espe.factura.proyectoMundo;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import grupo4.espe.factura.mongodb.ConexionMongoTecnoSmart;

public class TiendaTecnoSmart {

	// ----------------------------
	// Atributos
	// ----------------------------

	/*
	 * Inventario de la tienda
	 */

	private ArrayList<Producto> productos;

	/*
	 * Facturas generadas
	 */

	/*
	 * Facturas generadas
	 */

	private ArrayList<Factura> facturas;

	public TiendaTecnoSmart() {

		productos = new ArrayList<Producto>();

		facturas = new ArrayList<Factura>();
	}

	// ----------------------------------------
	// Metodos funcionales
	// ----------------------------------------

	/*
	 * Agregar un producto
	 */

	public void agregarProducto(String codigo, String descripcion, double precio, int cantidad) {

		Producto producto = new Producto(codigo, descripcion, precio, cantidad);

		productos.add(producto);

	}
	/*
	 * Agregar una factura
	 */

	/*public void agregarFactura(Date fecha, String numeroFactura, Double subtotal, Double descuento, Double subDescuento,
			Double totalPagar, Cliente pCliente, ArrayList<Producto> pProducto, Double pImpuesto) {

		Factura factura = new Factura(pCliente, pProducto);

		facturas.add(factura);

	}*/

	/*
	 * Devuelve la lista de los productos de la tienda
	 */

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	/*
	 * Metodo para mostrar el producto mas caro de la tienda
	 */

	public String darProductoMasCaro() {

		String resultadoProductoMasCaro = "";

		Producto productoMasCaro = null;

		double precioProductoMasCaro = 0.0;

		for (Producto productoActual : productos) {

			if (productoActual.getPrecio() > precioProductoMasCaro) {

				productoMasCaro = productoActual;

				resultadoProductoMasCaro = productoActual.toString();

			}

		}

		return resultadoProductoMasCaro;

	}

	/*
	 * Metodo para mostrar el producto mas barato de la tienda
	 */

	public String darProductoMasBarato() {

		String resultado = "";

		Producto menosCostoso = null;

		double precioMenosCostoso = 0.0;

		if (productos.size() > 0) {

			menosCostoso = productos.get(0);

			precioMenosCostoso = productos.get(0).getPrecio();

			for (int i = 0; i < productos.size(); i++) {

				Producto actual = productos.get(i);

				if (actual.getPrecio() < precioMenosCostoso) {

					resultado = actual.toString();

					menosCostoso = actual;

				}

			}

		}

		return resultado;

	}

	/*
	 * Metodo para dar el precio promedio de venta de los productos
	 */

	public Double darPromedioPrecioVenta() {

		int cantidadProductos = productos.size();
		double sumarPrecioVenta = 0.0;
		double promedioVenta = 0;

		for (Producto produc : productos) {

			sumarPrecioVenta += produc.getPrecio();

			promedioVenta = (sumarPrecioVenta / cantidadProductos);

		}

		return promedioVenta;

	}

	/*
	 * Metodo para buscar un producto por el codigo
	 */

	public Producto buscarProductoPorCodigo(String pCodigo) {

		Producto buscado = null;

		int i = 0;

		while (i < productos.size() && buscado == null) {

			Producto actual = productos.get(i);

			if (actual.getCodigo().equals(pCodigo)) {

				buscado = actual;

			}

		}

		return buscado;

	}

	/*
	 * Metodo para buscar una factura por el numero
	 */

	public Factura buscarFacturaNumero(int numero) {

		Factura buscada = null;

		int i = 0;

		while (i < facturas.size() && buscada == null) {

			Factura actual = facturas.get(i);

			if (actual.getNumeroFactura() == numero) {

				buscada = actual;

			}

		}

		return buscada;

	}

	/*
	 * Metodo para grabar el array list de los producto en mongoDB
	 */

	public void grabarMongoDB_Paucar_Fernando() {

		ConexionMongoTecnoSmart mongo = new ConexionMongoTecnoSmart();

		try {

			// Llamada al metodo para conectar a la base de datos
			mongo.conectarMongoDB();

			// Guardar los productos en la base de datos
			mongo.grabarMongoDB(productos);

		} catch (UnknownHostException e) {

			e.printStackTrace();
		}

	}

}