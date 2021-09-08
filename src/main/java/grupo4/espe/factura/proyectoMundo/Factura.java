package grupo4.espe.factura.proyectoMundo;

import java.sql.Date;
import java.util.ArrayList;

import com.mongodb.BasicDBObject;

public class Factura extends Cliente{

	/*
	 * Fecha en que se emitio la factura
	 */
	//private Date fecha;

	/*
	 * Numero de factura
	 */
	private int numeroFactura;

	/*
	 * Subtotal de factura
	 */
	private Double subtotal;

	/*
	 * Descuento
	 */
	private Double descuento;

	/*
	 * Sub total con descuento
	 */
	private Double subDescuento;

	/*
	 * Representa al cliente
	 */

	private Cliente cliente;

	/*
	 * ArrayList de los productos
	 */

	private ArrayList<Producto> productos;

	/*
	 * IVA 12%
	 */

	private static Double iva = 0.12;

	/*
	 * Atributo que representa el valor del iva
	 */

	private double totalImpuesto;

	/*
	 * Total a pagar
	 */
	private Double totalPagar;
/*
	//Datos de cliente
	private Cliente datosCliente;

	private String cedula = datosCliente.getCedula();
	private String nombreCliente = datosCliente.getNombre();
	private String telefono = datosCliente.getTelefono();
	private String correo = datosCliente.getCorreo();
	private String direccion = datosCliente.getDireccion();
*/
	//Conversion de datos
	//String fechaFac = fecha.toString();
	String numeroDeFactura = Integer.toString(numeroFactura);

	public Factura(/*String fecha,*/String numeroDeFactura, String cedula, String cliente, String telefono, String correo, String direccion) {

		super(cedula, cliente, telefono, correo, direccion);
		//this.fechaFac = fecha;
		this.numeroDeFactura = numeroDeFactura;
		/*this.cedula = cedula;
		this.nombreCliente = cliente;
		this.telefono = telefono;
		this.correo = correo;
		this.direccion = direccion;
*/
		//this.subtotal = subtotal;
		//this.descuento = descuento;
		//this.subDescuento = subDescuento;
		//this.totalPagar = totalPagar;
		//this.totalImpuesto = pImpuesto;
		//this.productos = pProducto;
	}

	public BasicDBObject toDBObjectFactura() {
		BasicDBObject dBObjectFactura = new BasicDBObject();

		//dBObjectFactura.append("fecha", this.getFecha());
		dBObjectFactura.append("numero factura", this.getNumeroFactura());
		dBObjectFactura.append("cedula", this.getCedula());
		dBObjectFactura.append("nombre", this.getNombre());
		dBObjectFactura.append("telefono", this.getTelefono());
		dBObjectFactura.append("correo", this.getCorreo());
		dBObjectFactura.append("direccion", this.getDireccion());
		
		return dBObjectFactura;
	}

	/*public Factura(BasicDBObject dBObjectFactura) {

	}

/*
	public Producto(BasicDBObject dBObjectProducto) {
		this.codigo = dBObjectProducto.getString("codigo");
		this.descripcion = dBObjectProducto.getString("descripcion");
		this.precio = dBObjectProducto.getDouble("precio");
	}
	 */

	/*public Date getFecha() {
		return fecha;
	}*/

	public int getNumeroFactura() {
		return numeroFactura;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public Double getDescuento() {
		return descuento;
	}

	public Double getSubDescuento() {
		return subDescuento;
	}

	public Double getTotalPagar() {
		return totalPagar;
	}
	/*
	//Getters de cliente
	public String getCedula() {
		return this.cedula;
	}
	
	public String getNombreCliente() {
		return this.nombreCliente;
	}
	
	public String getTelefono() {
		return this.telefono;
	}
	
	public String getCorreo() {
		return this.correo;
	}
	
	public String getDireccion() {
		return this.direccion;
	}

*/

	/*public void setFecha(Date fecha) {
		this.fecha = fecha;
	}*/

	public void setNumeroFactura(int numeroFactura) {
		this.numeroFactura = numeroFactura;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}

	public void setSubDescuento(Double subDescuento) {
		this.subDescuento = subDescuento;
	}

	public void setIva(Double iva) {
		this.iva = iva;
	}

	public void setTotalPagar(Double totalPagar) {
		this.totalPagar = totalPagar;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public double getTotalImpuesto() {
		return totalImpuesto;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}

	public void setTotalImpuesto(double totalImpuesto) {
		this.totalImpuesto = totalImpuesto;
	}

	public static Double getIva() {
		return iva;
	}




	public Double calcularSubtotal() {

		double subtotal = 0.0;

		for (Producto produc : productos) {

			subtotal += produc.calcularImporte();

		}

		return subtotal;

	}

	public Double calcularIva() {

		double subtotal = 0.0;
		double totalImpuesto = 0.0;

		for (Producto produc : productos) {

			subtotal += produc.calcularImporte();

			totalImpuesto = subtotal * 0.14;

		}

		return totalImpuesto;

	}

	public Double calcularTotal() {


		double subtotal = 0.0;
		double totalImpuesto = 0.0;
		double totalPagar = 0.0;


		for (Producto produc : productos) {

			subtotal += produc.calcularImporte();

			totalImpuesto = subtotal * 0.14;

			totalPagar = subtotal + totalImpuesto;

		}

		return totalPagar;

	}


}
