package grupo4.espe.factura.proyectoMundo;

import java.sql.Date;

public class Factura {

	//Atributos

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
	private int subtotal;
	
	/*
	 * Descuento
	 */
	private int descuento;
	
	/*
	 * Sub total con descuento
	 */
	private int subDescuento;
	
	/*
	 * IVA 12%
	 */

	private int iva;
	
	/*
	 * Total a pagar
	 */
	private int totalPagar;
	
	public Factura(Date fecha, int numeroFactura, int subtotal, int descuento, int subDescuento, int iva,
			int totalPagar) {
		this.fecha = fecha;
		this.numeroFactura = numeroFactura;
		this.subtotal = subtotal;
		this.descuento = descuento;
		this.subDescuento = subDescuento;
		this.iva = iva;
		this.totalPagar = totalPagar;
	}

	
	
	
	
	public Date getFecha() {
		return fecha;
	}

	public int getNumeroFactura() {
		return numeroFactura;
	}

	public int getSubtotal() {
		return subtotal;
	}

	public int getDescuento() {
		return descuento;
	}

	public int getSubDescuento() {
		return subDescuento;
	}

	public int getIva() {
		return iva;
	}

	public int getTotalPagar() {
		return totalPagar;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public void setNumeroFactura(int numeroFactura) {
		this.numeroFactura = numeroFactura;
	}

	public void setSubtotal(int subtotal) {
		this.subtotal = subtotal;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	public void setSubDescuento(int subDescuento) {
		this.subDescuento = subDescuento;
	}

	public void setIva(int iva) {
		this.iva = iva;
	}

	public void setTotalPagar(int totalPagar) {
		this.totalPagar = totalPagar;
	}
	
	
}
