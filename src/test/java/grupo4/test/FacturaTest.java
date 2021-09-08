package grupo4.test;

import static org.junit.Assert.*;

import org.junit.Test;

import grupo4.espe.factura.mundo.*;

public class FacturaTest {

	/*
	 Clase a la cual se realizara la prueba
	 */
	private Factura factura;
	
	private ItemFactura item;
	
	private Producto producto;
	
	private ClienteParticular cliente;
	

	/**
	 * Inicializa el libro con el precio y se inicializa el item con la cantidad compprada
	 */
	private void setup1() {
		
		producto = new Producto((float)60);
		
		item = new ItemFactura(34, producto);
		
		factura = new Factura("CompraPC", cliente);		
		
	}
	
	@Test
	public void testSubtotal() {

		setup1();
		
		factura.addItemFactura(item);
		
		assertTrue("El subtotal es incorrecto", 2040 == factura.calcularSubtotal());
	
	}
	
	@Test
	public void testIva() {

		setup1();
		
		factura.addItemFactura(item);
		
		assertTrue("El iva es incorrecto", 285.6 == factura.calcularSubtotal() * 0.14);
	
	}
	
}
