package grupo4.espe.factura.mongodb;

import java.util.ArrayList;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import grupo4.espe.factura.mundo.ClienteEmpresa;
import grupo4.espe.factura.mundo.ClienteParticular;
import grupo4.espe.factura.mundo.Producto;

public class ConexionMongo {

	/**
	 * Crea las coleccion para los clientes, tanto particulares como empresas y
	 * particulares, para finalizar los productos
	 * 
	 * @param pCollectionProductos   > coleccion en la cual se guardan los datos de
	 *                               los productos
	 * @param pCollectionParticulare > coleccion en la cual se guardan los datos de
	 *                               los clientes particulares
	 * @param pCollectionEmpresa     > coleccion en la cual se guardan los datos de
	 *                               los clientes empresariales
	 * @param productos              > ArrayList de los productos
	 * @param particulares           > ArrayList de los clientes particulares
	 * @param empresas               > ArrayList de los clientes empresarialres
	 */

	public static void createDB(DBCollection pCollectionProductos,

			DBCollection pCollectionParticulares, DBCollection pCollectionEmpresa,

			ArrayList<Producto> productos, ArrayList<ClienteParticular> particulares,
			ArrayList<ClienteEmpresa> empresas) {

		// PASO 4: CRUD (Create-Read-Update-Delete)

		// PASO 4.1: "CREATE" -> Metemos los objetos productos (o documentos en Mongo)
		// en la coleccion Futbolista
		for (Producto pro : productos) {
			pCollectionProductos.insert(pro.toDBObjectProducto());
		}

		for (ClienteParticular parti : particulares) {

			pCollectionParticulares.insert(parti.toDBObjectClienteParticular());
		}

		for (ClienteEmpresa empre : empresas) {

			pCollectionEmpresa.insert(empre.toDBObjectClienteEmpresa());

		}

	}

	/**
	 * Lee los documentos almacenados en la base de datos
	 * 
	 * @param pCollectionProductos > coleccion en la cual se guardan los datos de
	 *                             los productos
	 */

	public static void readDbProductos(DBCollection pCollectionProductos) {

		// PASO 4.2.1: "READ" -> Leemos todos los documentos de la base de datos

		// Numero de documentos para la coleccion de los productos
		int numDocumentosProductos = (int) pCollectionProductos.getCount();

		System.out.println("\n");
		System.out.println("Número de documentos en la colección Productos: " + numDocumentosProductos + "\n");

		// Busco todos los documentos de la colección de los productos y los imprime

		DBCursor cursor1 = pCollectionProductos.find();

		try {
			while (cursor1.hasNext()) {

				System.out.println(cursor1.next().toString());
			}
		} finally {
			cursor1.close();

		}

	}

	public static void readDbParticulares(DBCollection pCollectionParticulares) {

		// PASO 4.2.1: "READ" -> Leemos todos los documentos de la base de datos

		// Numero de documentos para la coleccion de los productos
		int numDocumentosParticulares = (int) pCollectionParticulares.getCount();

		System.out.println("\n");
		System.out.println("Número de documentos en la colección Particulares: " + numDocumentosParticulares + "\n");

		// Busco todos los documentos de la colección de los productos y los imprime

		DBCursor cursor1 = pCollectionParticulares.find();

		try {
			while (cursor1.hasNext()) {

				System.out.println(cursor1.next().toString());
			}
		} finally {
			cursor1.close();

		}

	}

	public static void readDbEmpresa(DBCollection pCollectionEmpresas) {

		// PASO 4.2.1: "READ" -> Leemos todos los documentos de la base de datos

		// Numero de documentos para la coleccion de los productos
		int numDocumentosEmpresas = (int) pCollectionEmpresas.getCount();

		System.out.println("\n");
		System.out.println("Número de documentos en la colección Empresas: " + numDocumentosEmpresas + "\n");

		// Busco todos los documentos de la colección de los productos y los imprime

		DBCursor cursor1 = pCollectionEmpresas.find();

		try {
			while (cursor1.hasNext()) {

				System.out.println(cursor1.next().toString());
			}
		} finally {
			cursor1.close();

		}

	}

	public static void readQueryNombreCliente(DBCollection pCollectionParticulares) {

		DBObject query = new BasicDBObject("nombre", new BasicDBObject("$regex", "Fernando"));
		DBCursor cursor = pCollectionParticulares.find(query);

		try {

			while (cursor.hasNext()) {

				ClienteParticular cliente = new ClienteParticular((BasicDBObject) cursor.next());
				System.out.println(cliente.toString());

			}

		} finally {

			cursor.close();
		}

	}
	
	
	public static void updateDBPrecioProductos(DBCollection pCollectionProductos) {
		
		//Actualizamos el precio de los telefonos
		DBObject find = new BasicDBObject("precio", new BasicDBObject("$gt", 1));
		DBObject updated = new BasicDBObject().append("$inc", new BasicDBObject().append("precio", 3));
		pCollectionProductos.update(find, updated, false, true);
		
	}
	
	
	public static void deleteDB(DBCollection coleccionProductos) {
		
		//Borrar los telefonos con el precio de $10
		DBObject finDoc = new BasicDBObject("precio", 10);
		coleccionProductos.remove(finDoc);
		
		
	}
	

}
