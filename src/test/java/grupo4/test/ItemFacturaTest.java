package grupo4.test;

import static org.junit.Assert.*;

import org.junit.Test;

import grupo4.espe.factura.mundo.*;

public class ItemFacturaTest {

	// -----------------------------------------------------------------
		// Atributos
		// -----------------------------------------------------------------

		/**
		 * Es la clase donde se harán las pruebas
		 */
		private ItemFactura item;
		
		
		private Producto producto;
		
		
		
		/**
		 * 1. Inicializa el producto con el precio
		 * 2. Inicializa el objeto item con la cantidad y el objeto producto
		 */
		private void setup1() {
			
			producto = new Producto((float) 345);
			
			item = new ItemFactura(34, producto);
			
		}
		
		
		/*
		 Prueba 1: Calcular Importe
		 */
		
		@Test
		public void testImporte() {
			
			setup1();
			
			assertTrue("El importe es incorrecto", 11730 == item.calcularImporte());
			
		}
		
	}
