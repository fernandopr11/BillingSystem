package grupo4.espe.factura.proyectoMundo;

import java.net.UnknownHostException;
import java.util.ArrayList;

import com.mongodb.BasicDBObject;

public class TiendaTecnoSmart {

	// ----------------------------
	// Atributos
	// ----------------------------

	/*
	 * Inventario de la tienda
	 */

	private ArrayList<Producto> productos;

	public TiendaTecnoSmart() {

		productos = new ArrayList<Producto>();

	}

	public void agregarProducto(String codigo, String descripcion, double precio, int cantidad) {

		Producto producto = new Producto(codigo, descripcion, precio, cantidad);

		productos.add(producto);

	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void grabarMongoDB_Paucar_Fernando() {

		ConexionMongoTecnoSmart mongo = new ConexionMongoTecnoSmart();

		try {

			//Llamada al metodo para conectar a la base de datos
			mongo.conectarMongoDB();
			
			
			//Guardar los productos en la base de datos
			mongo.grabarMongoDB(productos);
			
			
		} catch (UnknownHostException e) {

			e.printStackTrace();
		}

	}

}