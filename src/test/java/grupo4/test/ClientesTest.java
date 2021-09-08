package grupo4.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import grupo4.espe.factura.proyectoMundo.Cliente;

public class ClientesTest {

	// --------------------------------------------
	// Atributos
	// --------------------------------------------

	/*
	 * Clase donde se realizaran las pruebas
	 */

	private Cliente cliente;

	/*
	 * Inicializa el cliente con todos sus atributos
	 */

	public void setup1() {

		cliente = new Cliente("2350818148", "Samuel Ledesma", "0993601086", "wledesma@espe.edu.ec", "Proletariado");

	}

	/*
	 * 
	 * Prueba 1. Dar cedula
	 * 
	 */
	@Test
	public void testDarCedula() {

		setup1();

		assertEquals("La cedula es incorrecta", "2350818148", cliente.getCedula());

	}

	/*
	 * 
	 * Prueba 2. Dar nombre
	 * 
	 */

	@Test
	public void testDarNombre() {

		setup1();

		assertEquals("El nombre es incorrecto", "Samuel Ledesma", cliente.getNombre());

	}

	/*
	 * 
	 * Prueba 3. Dar numero telefono
	 * 
	 */

	@Test
	public void testDarNumeroTelefono() {

		setup1();

		assertEquals("El numero de telofono es incorrecto", "0993601086", cliente.getTelefono());

	}

	/*
	 * 
	 * Prueba 4. Dar correoElectronico
	 * 
	 */

	@Test
	public void testDarCorreoElectronico() {

		setup1();

		assertEquals("El correo electronico es incorrecto", "wledesma@espe.edu.ec", cliente.getCorreo());

	}

	/*
	 * 
	 * Prueba 5. Dar direccion
	 * 
	 */

	@Test
	public void testDarDireccion() {

		setup1();

		assertEquals("La direccion es incorrecta", "Proletariado", cliente.getDireccion());

	}

}
