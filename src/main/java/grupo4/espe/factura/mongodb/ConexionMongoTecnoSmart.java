package grupo4.espe.factura.mongodb;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.text.Document;

import org.bson.BasicBSONObject;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
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
	
	
	public void  mostrarProducto(DBCollection collection, String codigo){
		DBObject query = new BasicDBObject("codigo", new BasicDBObject("$regex", codigo));
		DBCursor cursor = collection.find(query);
		try {
			while (cursor.hasNext()) {
				Producto producto = new Producto((BasicDBObject) cursor.next());
				System.out.println(producto.toString());
			}
		} finally {
			cursor.close();
		}
	}
	
}
