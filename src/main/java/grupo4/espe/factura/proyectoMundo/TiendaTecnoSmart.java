package grupo4.espe.factura.proyectoMundo;

import java.net.UnknownHostException;
import java.util.ArrayList;

import com.mongodb.BasicDBObject;

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

	public TiendaTecnoSmart() {

		productos = new ArrayList<Producto>();

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
	 * Devuelve la lista de los productos de la tienda
	 */

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	/*
	 * Metodo para mostrar el producto mas caro de la tienda
	 */

	public String darProductoMasCaro(ArrayList<Producto> misProductos) {

		String resultadoProductoMasCaro = "";

		Producto productoMasCaro = null;

		double precioProductoMasCaro = 0.0;

		for (Producto productoActual : misProductos) {

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

	public String darProductoMasBarato(ArrayList<Producto> misProductos) {

		String resultado = "";

		Producto menosCostoso = null;

		double precioMenosCostoso = 0.0;

		if (misProductos.size() > 0) {

			menosCostoso = misProductos.get(0);
			precioMenosCostoso = misProductos.get(0).getPrecio();

			for (int i = 0; i < misProductos.size(); i++) {

				Producto actual = misProductos.get(i);

				if (actual.getPrecio() < precioMenosCostoso) {

					menosCostoso = actual;
					precioMenosCostoso = actual.getPrecio();

					resultado = actual.toString();

				}

			}

		}

		return resultado;

	}

	/*
	 * 
	 */

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