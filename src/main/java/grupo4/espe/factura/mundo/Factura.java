package grupo4.espe.factura.mundo;


import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

import com.mongodb.BasicDBObject;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
Clase que representa la factura
*/

public class Factura {

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/*
	 * Ruc de la empresa inicializado
	 */
	private String ruc = "2350818148-001";

	/*
	 * Descripcion de la compra
	 */
	private String descripcion;

	/*
	 * Fecha de la compra
	 */
	private Date fecha;

	/*
	 * Hora de emision de la factura
	 */
	private LocalTime horaActual;

	/*
	 * Objeto particular de la clase Cliente particular
	 */
	private ClienteParticular particular;

	/*
	 * Objeto empresa de la clase ClienteEmpresa
	 */
	private ClienteEmpresa empresa;

	/*
	 * Array de la clase ItemFactura
	 */
	private ItemFactura[] items;

	/*
	 * Indice de los Items
	 */
	private int indiceItem;

	/*
	 * Valor total de la compra
	 */
	private double total;

	/*
	 * Subtotal de la compra
	 */
	private double subtotal;

	/*
	 * Iva de la compra
	 */
	private double iva;

	/**
	 * Crea las coleccion para las facturas de tipo cliente particular con la
	 * descripcion y el objeto particular
	 * 
	 * @param descripcion > descripcion de la compra
	 * @param particular  > objeto que representa al cliente particular
	 */
	public Factura(String descripcion, ClienteParticular particular) {
		this.descripcion = descripcion;
		this.particular = particular;
		this.items = new ItemFactura[34];
		this.fecha = new Date();

	}

	/**
	 * Crea las coleccion para las facturas de tipo cliente empresa con la
	 * descripcion y el objeto empresa
	 * 
	 * @param descripcion > descripcion de la compra
	 * @param empresa     > objeto que representa al cliente empresa
	 */
	public Factura(String descripcion, ClienteEmpresa empresa) {
		this.descripcion = descripcion;
		this.empresa = empresa;
		this.items = new ItemFactura[34];
		this.fecha = new Date();
	}

	public Factura(BasicDBObject dbObjectFactura) {

		this.ruc = dbObjectFactura.getString("ruc");
		this.descripcion = dbObjectFactura.getString("descripcion");
		this.fecha = dbObjectFactura.getDate("fecha");
		this.subtotal = dbObjectFactura.getDouble("subtotal");
		this.iva = dbObjectFactura.getDouble("iva");
		this.total = dbObjectFactura.getDouble("total");

	}

	public BasicDBObject toDBObjectFactura() {

		BasicDBObject dBObjectFactura = new BasicDBObject();

		dBObjectFactura.append("RUC: ", this.getRuc());
		dBObjectFactura.append("Descripcion: ", this.getDescripcion());
		dBObjectFactura.append("Fecha: ", this.getFecha());
		dBObjectFactura.append("Subtotal: ", this.getSubtotal());
		dBObjectFactura.append("Iva: ", this.getIva());
		dBObjectFactura.append("Total: ", this.getTotal());

		return dBObjectFactura;

	}

	/**
	 * Retorna el numero de RUC de la empresa
	 * 
	 * @return El numero de telefono
	 */

	public String getRuc() {
		return ruc;
	}

	/**
	 * Retorna la descripcion de la compra
	 * 
	 * @return El numero de telefono
	 */

	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion descripcion de la compra
	 * 
	 *                    Modifica el valor de la descripcion
	 */

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Retorna la fecha de la compra
	 * 
	 * @return El numero de telefono
	 */

	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha fecha de la compra
	 * 
	 *              Modifica el valor de la fecha de compra
	 */

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * Retorna el objeto cliente particular
	 * 
	 * @return El cliente particular
	 */

	public ClienteParticular getParticular() {
		return particular;
	}

	/**
	 * @param particular cliente particular
	 * 
	 *                   Modifica el los valores de los atributos del cliente
	 *                   particular
	 */
	public void setParticular(ClienteParticular particular) {
		this.particular = particular;
	}

	/**
	 * Retorna el objeto cliente empresa
	 * 
	 * @return El cliente empresa
	 */
	public ClienteEmpresa getEmpresa() {
		return empresa;
	}

	/**
	 * @param particular cliente particular
	 * 
	 *                   Modifica el los valores de los atributos del cliente
	 *                   particular
	 */
	public void setEmpresa(ClienteEmpresa empresa) {
		this.empresa = empresa;
	}

	/**
	 * Retorna el total de la compra
	 * 
	 * @return El total de la compra
	 */
	public Double getTotal() {
		return total;
	}

	/**
	 * @param total total de la compra
	 * 
	 *              Modifica el valor del atributo total de la compra
	 */
	public void setTotal(float total) {
		this.total = total;
	}

	/**
	 * Retorna el subtotal de la compra
	 * 
	 * @return El subtotal de la compra
	 */
	public Double getSubtotal() {
		return subtotal;
	}

	/**
	 * @param subtotal subtotal de la compra
	 * 
	 *                 Modifica el valor del atributo subtotal de la compra
	 */
	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}

	/**
	 * Retorna el iva de la compra
	 * 
	 * @return El iva de la compra
	 */
	public Double getIva() {
		return iva;
	}

	/**
	 * @param iva iva de la compra
	 * 
	 *            Modifica el valor del iva de la compra
	 */
	public void setIva(float iva) {
		this.iva = iva;
	}

	/**
	 * Retorna los items
	 * 
	 * @return Los items com los productos
	 */
	public ItemFactura[] getItems() {
		return items;
	}

	/**
	 * @param item
	 * 
	 *             Agrega los items a la factura
	 */
	public void addItemFactura(ItemFactura item) {

		this.items[indiceItem++] = item;
	}

	/**
	 * Retorna el subtotal
	 * 
	 * @return el subtotal de la compra
	 */

	public Double calcularSubtotal() {

		// Se inicializa el subtotal en cero
		subtotal = 0.0;

		// Se recorre el array de los items
		for (int i = 0; i < indiceItem; i++) {

			// Se incremente el subtotal invocando al metodo calularImporte() del objeto
			// items
			subtotal += this.items[i].calcularImporte();

		}
		// Se retorna el valor del subtotal
		return subtotal;
	}

	/**
	 * Retorna el iva de la compra
	 * 
	 * @return el iva de la compra
	 */

	public Double calcularIva() {

		// Inicializa el subtoal en cero
		subtotal = 0.0;

		// Inicializa el iva en cero
		iva = 0.0;

		for (int i = 0; i < indiceItem; i++) {

			// Se incremente el subtotal invocando al metodo calularImporte() del objeto
			// items
			subtotal += this.items[i].calcularImporte();

			// Inicializa el iva con el producto del subtotal * 0.14
			iva = subtotal * 0.14f;
		}

		// Retorna el valor del Iva
		return iva;
	}

	/**
	 * Retorna el total
	 * 
	 * @return el total de la compra
	 */
	public Double calcularTotal() {

		// Inicializa el subtoal en cero
		subtotal = 0.0;

		// Initicializa el iva en cero
		iva = 0.0;

		// Initicializa el total en cero
		total = 0.0;

		for (int i = 0; i < indiceItem; i++) {

			// Se incremente el subtotal invocando al metodo calularImporte() del objeto
			// items
			subtotal += this.items[i].calcularImporte();

			// Inicializa el iva con el producto del subtotal * 0.14
			iva = subtotal * 0.14f;

			// Inicializa el total con la suma del subtotal mas el iva
			total = subtotal + iva;
		}

		// Retorna el total
		return total;
	}

	/**
	 * Retorna detalle de la factura
	 * 
	 * @return El detalle de la factura para el cliente particular
	 */
	public String generarDetalleParticular() {
		StringBuilder sb = new StringBuilder("   TecnoSmart  ");

		sb.append("Ruc:" + ruc).append("\n").append("\nCliente: ").append(particular.getNombre()).append("\nCedula: ")
				.append(particular.getCedula()).append("\nTelefono: ").append(particular.getTelefono())
				.append("\nCorreo :").append(particular.getCorreo()).append("\nDireccion: ")
				.append(particular.getDireccion()).append("\nDescripci�n: ").append(this.descripcion).append("\n");

		horaActual = LocalTime.now();

		sb.append("\nHora de Emision: ").append(horaActual);

		SimpleDateFormat df = new SimpleDateFormat("dd 'de' MMMM 'del' yyyy");
		sb.append("\nFecha Emisi�n: ").append(df.format(this.fecha)).append("\n")
				.append("\n#\tNombre\t$\t Cant.\t Total \n");

		for (int i = 0; i < indiceItem; i++) {
			sb.append(this.items[i].toString()).append("\n");
		}

		sb.append("\nSubTotal: $").append(calcularSubtotal());

		sb.append("\nIva: $").append(calcularIva());

		sb.append("\nTotal: $").append(calcularTotal());

		return sb.toString();
	}

	/**
	 * Retorna detalle de la factura
	 * 
	 * @return El detalle de la factura para el cliente empresa
	 */
	public String generarDetalleEmpresa() {

		StringBuilder sb = new StringBuilder("   TecnoSmart  ");

		sb.append("Ruc:" + ruc).append("\n").append("\nNombre Empresa: ").append(empresa.getNombreEmpresa())
				.append("\nRuc: ").append(empresa.getRuc()).append("\nTelefono: ").append(empresa.getTelefono())
				.append("\nCorreo :").append(empresa.getCorreo()).append("\nDireccion: ").append(empresa.getDireccion())
				.append("\nDescripci�n: ").append(this.descripcion).append("\n");

		horaActual = LocalTime.now();

		sb.append("\nHora de Emision: ").append(horaActual);

		SimpleDateFormat df = new SimpleDateFormat("dd 'de' MMMM, yyyy");
		sb.append("\nFecha Emisi�n: ").append(df.format(this.fecha)).append("\n")
				.append("\n#\tNombre\t$\t Cant.\t Total \n");

		for (int i = 0; i < indiceItem; i++) {
			sb.append(this.items[i].toString()).append("\n");
		}

		sb.append("\nSubTotal: $").append(calcularSubtotal());

		sb.append("\nIva: $").append(calcularIva());

		sb.append("\nTotal: $").append(calcularTotal());

		return sb.toString();
	}

}
