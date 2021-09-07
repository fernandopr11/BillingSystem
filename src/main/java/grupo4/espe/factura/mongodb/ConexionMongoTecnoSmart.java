package grupo4.espe.factura.mongodb;

import java.net.UnknownHostException;
import java.util.ArrayList;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

import grupo4.espe.factura.proyectoMundo.Producto;

public class ConexionMongoTecnoSmart {

	// -----------------------------------
	// Atributos
	// -----------------------------------

	/*
	 * Atributo que representa la base de datos
	 */
	DB db;

	/*
	 * Cliente para la base de datos
	 */
	MongoClient cliente;

	/*
	 * Metodo para realizar la conexion a mongoDB
	 */

	public DB conectarMongoDB() throws UnknownHostException {

		db = null;

		// Conexion
		cliente = new MongoClient("localhost", 27017);

		// Base de datos
		db = cliente.getDB("BaseDatosTecnoSmart");

		return db;

	}
	
	public void grabarMongoDB(ArrayList<Producto> misProductos) {
		
		DBCollection coleccion =  (DBCollection) db.getCollection("Inventario");
		
		for(Producto producto: misProductos) {
			
			coleccion.insert(producto.toDBObjectProducto());
			
		}
		
		
		
	}

}
