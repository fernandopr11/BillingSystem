package grupo4.espe.factura.proyectoMundo;

import java.sql.Date;
import java.util.ArrayList;

public class Factura {

	/*
	 * Fecha en que se emitio la factura
	 */
	private Date fecha;

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

	public Factura(Date fecha, int numeroFactura, Double subtotal, Double descuento, Double subDescuento,
			Double totalPagar, Cliente pCliente, ArrayList<Producto> pProducto, Double pImpuesto) {
		
		this.fecha = fecha;
		this.numeroFactura = numeroFactura;
		this.subtotal = subtotal;
		this.descuento = descuento;
		this.subDescuento = subDescuento;
		this.totalPagar = totalPagar;
		this.cliente = pCliente;
		this.totalImpuesto = pImpuesto;
		this.productos = pProducto;
	}

	public Date getFecha() {
		return fecha;
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

	public void setFecha(Date fecha) {
		this.fecha = fecha;
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

	public Double calcularSubtotal() {

		for (Producto produc : productos) {

			subtotal = produc.calcularImporte();

		}

		return subtotal;

	}

	public Double calcularIva() {

		for (Producto produc : productos) {

			subtotal = produc.calcularImporte();

			totalImpuesto = subtotal * iva;

		}

		return totalImpuesto;

	}

	public Double calcularTotal() {

		for (Producto produc : productos) {

			subtotal = produc.calcularImporte();

			totalImpuesto = subtotal * iva;

			totalPagar = subtotal + iva;

		}

		return totalPagar;

	}

}
