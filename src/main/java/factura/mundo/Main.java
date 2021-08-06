package factura.mundo;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;


public class Main {
	
	// -----------------------------------------------------------------
		// Subprogramas
		// -----------------------------------------------------------------

		/**
		 * Retorna un mensaje de bienvenida
		 * 
		 * @return El mensaje de bienvenida
		 */
		public static void bienvenida() {

			System.out.println("----Sistema de facturacion tienda electronica---");
			System.out.println("Grupo: 4");
			System.out.println("Asignatura: Programacion Orientada a Objetos");
			System.out.println("Fecha: 23/06/2021 \n");

		}

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
		 * @param pCollectionProductos   > coleccion en la cual se guardan los datos de
		 *                               los productos
		 * @param pCollectionParticulare > coleccion en la cual se guardan los datos de
		 *                               los clientes particulares
		 * @param pCollectionEmpresa     > coleccion en la cual se guardan los datos de
		 *                               los clientes empresariales
		 */

		public static void readDb(DBCollection pCollectionProductos,

				DBCollection pCollectionParticulares, DBCollection pCollectionEmpresa) {

			// PASO 4.2.1: "READ" -> Leemos todos los documentos de la base de datos

			// Numero de documentos para la coleccion de los productos
			int numDocumentosProductos = (int) pCollectionProductos.getCount();

			// Numero de documentos para la coleccion de los clientes particulares
			int numDocumentosParticulares = (int) pCollectionParticulares.getCount();

			// Numero de documentos para la coleccion de los clientes empresariales
			int numDocumentosEmpresas = (int) pCollectionEmpresa.getCount();

			System.out.println("\n");
			System.out.println("Número de documentos en la colección Productos: " + numDocumentosProductos + "\n");
			System.out.println("Número de documentos en la colección Particulares: " + numDocumentosParticulares + "\n");
			System.out.println("Número de documentos en la colección Empresas: " + numDocumentosEmpresas + "\n");

			// Busco todos los documentos de la colección de los productos y los imprime

			DBCursor cursor1 = pCollectionProductos.find();

			DBCursor cursor2 = pCollectionParticulares.find();

			DBCursor cursor3 = pCollectionEmpresa.find();

			try {
				while (cursor1.hasNext() || cursor2.hasNext( ) || cursor3.hasNext()) {

					System.out.println(cursor1.next().toString());			
					System.out.println(cursor1.next().toString());	
					System.out.println(cursor3.next().toString());

				}
			} finally {
				cursor1.close();
				cursor2.close();
				cursor3.close();
			}

		}
	public static void main(String[] args) {

		bienvenida();

		// ArrayList para los productos de la tienda
		ArrayList<Producto> productos = new ArrayList<Producto>();

		// ArrayList para los clientes particulares
		ArrayList<ClienteParticular> particulares = new ArrayList<ClienteParticular>();

		// ArrayList para los clientes empresariales
		ArrayList<ClienteEmpresa> empresas = new ArrayList<ClienteEmpresa>();

		// Variables generales
		int tipoCliente = 0;
		String descripcion;

		// Variables para el producto
		Producto producto;
		String nombreProducto;
		double precio = 0;
		int cantidadMaximaProducto = 0, cantidadEspecifica = 0;
		boolean controlString = false;

		// Variables para el cliente general
		String telefono = "";
		String correo = null, direccion = null;

		// Variables para el cliente tipo empresa
		String ruc = " ";
		String nombreEmpresa = " ";

		// Variables para el cliente particular
		String cedula = " ", nombre = " ";

		// Instancia de la calse escaner
		Scanner entradaDatos = new Scanner(System.in);

		// Instancia de las clases
		ClienteParticular particular = null;
		ClienteEmpresa empresa = null;
		Factura facturaParticular = null;
		Factura facturaEmpresa = null;

		Double total = 0.0;

		System.out.print("Ingrese la descripcion de la compra > ");
		descripcion = entradaDatos.nextLine();

		do {

			System.out.print("\nIngrese el tipo de cliente \n1. Cliente particular\n2. Cliente empresa \n\n> ");
			tipoCliente = entradaDatos.nextInt();

			entradaDatos.nextLine();

			System.out.println("");
			System.out.println("---------Llenado de datos de los clientes---------");
			System.out.println("");

			switch (tipoCliente) {

			case 1:

				System.out.print("Ingresa el nombre > ");
				nombre = entradaDatos.nextLine();

				System.out.print("Ingresa el numero de cedula > ");
				cedula = entradaDatos.nextLine();

				System.out.print("Ingresa el numero de telefono > ");
				telefono = entradaDatos.nextLine();

				System.out.print("Ingresa la direccion > ");
				direccion = entradaDatos.nextLine();

				System.out.print("Ingresa el correo electronico > ");
				correo = entradaDatos.nextLine();

				// Instancia de la clase cliente particular
				particular = new ClienteParticular(telefono, correo, direccion, cedula, nombre);

				// Instancia de la clase factura
				facturaParticular = new Factura(descripcion, particular);

				// Se agregan los clientes particulares al arrayList
				particulares.add(new ClienteParticular(telefono, correo, direccion, cedula, nombre));

				total = facturaParticular.getTotal();

				break;

			case 2:

				System.out.print("Ingresa el nombre de la empresa > ");
				nombreEmpresa = entradaDatos.nextLine();

				System.out.print("Ingresa el RUC > ");
				ruc = entradaDatos.nextLine();

				System.out.print("Ingresa el numero de telefono > ");
				telefono = entradaDatos.nextLine();

				System.out.print("Ingresa la direccion > ");
				direccion = entradaDatos.nextLine();

				System.out.print("Ingresa el correo electronico > ");
				correo = entradaDatos.nextLine();

				// Instancia de la clase cliente empresa
				empresa = new ClienteEmpresa(telefono, correo, direccion, ruc, nombreEmpresa);

				// Instancia de la clase factura
				facturaEmpresa = new Factura(descripcion, empresa);

				// Se agregan los clientes de tipo empresas al arrauList
				empresas.add(new ClienteEmpresa(telefono, correo, direccion, ruc, nombreEmpresa));

				break;

			default:

				System.out.println("Tipo de cliente incorrecto");
				break;
			}

		} while (tipoCliente != 1 && tipoCliente != 2);

		System.out.println("");
		System.out.println("---------Llenado campos para la compra---------");
		System.out.println("");

		System.out.print("Ingrese la cantidad de productos comprados > ");
		cantidadMaximaProducto = entradaDatos.nextInt();

		for (int i = 1; i <= cantidadMaximaProducto; i++) {

			producto = new Producto();

			System.out.println("\n------Llenar los datos del producto [" + producto.getCodigo() + "]------");

			System.out.print("\nIngrese el nombre del producto  [" + producto.getCodigo() + "] > ");
			nombreProducto = entradaDatos.next();
			producto.setNombre(nombreProducto);

			do {
				controlString = false;
				entradaDatos.nextLine();

				try {

					System.out.print("Ingrese el precio del producto [" + producto.getCodigo() + "] > ");
					precio = entradaDatos.nextFloat();
					producto.setPrecio(precio);
					entradaDatos.nextLine();

				} catch (InputMismatchException e) {

					System.out.println("Error debe ingresar caracteres numericos mayores a 0");
					controlString = true;
				}

			} while (precio < 0 || controlString);

			do {
				controlString = false;

				try {

					System.out.print("Ingrese la cantidad a comprar del producto [" + producto.getCodigo() + "] > ");
					cantidadEspecifica = entradaDatos.nextInt();
					entradaDatos.nextLine();

				} catch (InputMismatchException e) {

					System.out.println("Error debe ingresar caracteres numericos mayores a 0 y enteros");
					controlString = true;
				}

			} while (cantidadEspecifica < 0 || controlString);

			if (tipoCliente == 1) {

				facturaParticular.addItemFactura(new ItemFactura(cantidadEspecifica, producto));

			} else if (tipoCliente == 2) {

				facturaEmpresa.addItemFactura(new ItemFactura(cantidadEspecifica, producto));

			}

			System.out.println();
			entradaDatos.nextLine();
			productos.add(new Producto(nombreProducto, precio));
		}

		if (tipoCliente == 1) {

			System.out.println(facturaParticular.generarDetalleParticular());

		} else if (tipoCliente == 2) {

			System.out.println(facturaEmpresa.generarDetalleEmpresa());

		}

		try {

			// Conexion al server de MondoDB recire como argumento el host y el numero del
			// puerto
			MongoClient mongoClient = new MongoClient("localhost", 27017);

			/*
			 * Base de datos y coleccion para los productos
			 */
			// Conexión a la base de datos para de la tienda TecnoSmart
			DB db = mongoClient.getDB("TecnoSmart");

			// Obtenemos una coleccion para trabajar con los productos
			DBCollection collectionProductos = db.getCollection("Productos");

			// Obtenemos una coleccion para con los clientes particulares
			DBCollection collectionParticulares = db.getCollection("Particulares");

			// Obtenemos una colleccion para trabajar con los clientes de empresa
			DBCollection collectionEmpresa = db.getCollection("Empresas");

			//Crear la base de datos
			createDB(collectionProductos, collectionParticulares, collectionEmpresa, productos, particulares, empresas);

			DBCursor cursor1, cursor2, cursor3;

			//Leer la base de datos
			readDb(collectionProductos, collectionParticulares, collectionEmpresa);

			// PASO FINAL: Cerrar la conexion
			mongoClient.close();

		} catch (UnknownHostException ex) {
			System.out.println("Exception al conectar al server de Mongo: " + ex.getMessage());
		}

	}

}
