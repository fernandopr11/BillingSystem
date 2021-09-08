package grupo4.espe.factura.proyectoMundo;

import java.sql.Date;
import java.util.ArrayList;

import com.mongodb.BasicDBObject;

public class Factura {

	/*
	 * Fecha en que se emitio la factura
	 */
	// private Date fecha;

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

	public Factura(Cliente cliente, ArrayList<Producto> productos) {

		this.cliente = cliente;
		this.productos = productos;

	}

	public BasicDBObject toDBObjectFactura() {
		BasicDBObject dBObjectFactura = new BasicDBObject();

		dBObjectFactura.append("numero", this.getNumeroFactura());
		dBObjectFactura.append("subtotal", this.getSubtotal());
		dBObjectFactura.append("subdescuento", this.getSubDescuento());
		dBObjectFactura.append("totalimpuesto", this.getTotalImpuesto());
		dBObjectFactura.append("totalpagar", this.getTotalPagar());

		return dBObjectFactura;

	}

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
