package grupo4.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import grupo4.espe.factura.proyectoMundo.Producto;

public class ProductoTest {
	// --------------------------------------------
	// Atributos
	// --------------------------------------------

	/*
	 * Clase donde se realizaran las pruebas
	 */

	private Producto producto;

	/*
	 * Inicializa el produc con el precio y la cantidad
	 */

	private void setup1() {

		producto = new Producto("001", "Ram 64GB", 50.5, 10);

	}

	/*
	 * Prueba 1: Dar codigo
	 */
	@Test
	public void testDarCodigo() {

		setup1();

		assertEquals("El codigo es incorrecto", "001", producto.getCodigo());

	}

	/*
	 * Prueba 2: Dar Descripcion
	 */
	@Test
	public void testDarDescripcion() {

		setup1();

		assertEquals("La descripcion es incorrecta", "Ram 64GB", producto.getDescripcion());

	}

	/*
	 * Prueba 3: Calcular Importe
	 */

	@Test
	public void testCalcularImporte() {

		setup1();
		assertTrue("El importe es incorrecto", 505 == producto.calcularImporte());

	}

}
