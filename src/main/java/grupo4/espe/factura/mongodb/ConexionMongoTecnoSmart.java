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
	
	/*public void encontrarProducto(DB db, String codigo) {
		BasicDBObject documento = new BasicDBObject("codigo", new BasicDBObject("$regex", codigo));
		DBCursor cursor = db.getCollection("Inventario").find(documento);
		 
		List<Producto> productos = new ArrayList<Producto>();
		Producto producto = null;
		Iterator<DBObject> iter = cursor.iterator();
		while (iter.hasNext()) {
		  Document documento2 = (Document) iter.next();
		  producto = new Producto();
		  producto.setCodigo(((BasicBSONObject) documento2).getString("codigo"));
		  producto.setDescripcion(((BasicBSONObject) documento2).getString("descripcion"));
		  producto.setPrecio(((BasicBSONObject) documento2).getDouble("precio"));
		  productos.add(producto);
		}
	}
	*/
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
	
	/*public void   mostrarProducto(DBCollection collection, String codigo){
		DBCollection colect = collection;
		
		BasicDBObject consulta = new BasicDBObject();
        consulta.put("codigo", codigo);
        
        DBCursor cursor = colect.find(consulta);
        try {
        while(cursor.hasNext()) {
        	System.out.println(consulta.toString());
         }
        }finally {
        	cursor.close();
        }
	}
        */
	/*
	 * public static void buscarPorNombre(DB db, DBCollection coleccion, String nombre) {
        DBCollection colect = coleccion;
        
        // CREAMOS LA CONSULTA CON EL CAMPO NOMBRE
        BasicDBObject consulta = new BasicDBObject();
        consulta.put("nombre", nombre);
        
        // BUSCA Y MUESTRA TODOS LOS DOCUMENTOS QUE COINCIDAN CON LA CONSULTA
        DBCursor cursor = colect.find(consulta);
        while(cursor.hasNext()) {
        	String nombreM = (String) cursor.next().get("nombre");
        	txtMNombre.setText(nombreM);
        	
        	int edadM = (Integer) cursor.curr().get("edad");
        	String valEdad = Integer.toString(edadM);
        	txtMEdad.setText(valEdad);
        }
	 */
}
