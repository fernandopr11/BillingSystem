package grupo4.test;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import grupo4.espe.factura.proyectoMundo.Cliente;
import grupo4.espe.factura.proyectoMundo.Factura;
import grupo4.espe.factura.proyectoMundo.Producto;

public class FacturaTest {

	/*
	 * Clase a la cual se realizara la prueba
	 */
	private Factura factura;

	/**
	 * Inicializa el libro con el precio y se inicializa el item con la cantidad
	 * compprada
	 */
	private void setup1() {

		ArrayList<Producto> pProducto = new ArrayList<Producto>();

		Producto producto1 = new Producto("001", "Intel Core I5", 150, 10);
		Producto producto2 = new Producto("002", "Fuente Corsair", 80, 30);

		pProducto.add(producto1);
		pProducto.add(producto2);

		Cliente client1 = new Cliente("2350818148", "Samuel Ledesma" , "0993601086", "wledesma@espe.edu.ec",
				"Proletariado");

		factura = new Factura(client1, pProducto);

	}

	@Test
	public void testSubtotal() {

		setup1();

		assertTrue("El Subtotal es incorrecto", 3900 == factura.calcularSubtotal());

	}

	@Test
	public void testImpuesto() {

		setup1();

		assertTrue("El impuesto es incorrecto", 546 == factura.calcularIva());

	}

	@Test
	public void testTotalPagar() {

		setup1();

		assertTrue("El total a pagar es incorrecto", 4446 == factura.calcularTotal());

	}

}
