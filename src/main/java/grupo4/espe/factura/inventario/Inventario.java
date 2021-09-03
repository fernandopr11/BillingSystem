package grupo4.espe.factura.inventario;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import grupo4.espe.factura.principal.InterfazFacturaPrincipal;

import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Inventario extends JFrame {

	// ----------------------------------
	// Atributos de la interfaz
	// ----------------------------------

	/*
	 * Panel que contiene la descripcion y la navegacion
	 */

	private PanelNav panelNavegacion;

	/*
	 * Panel que contiene los datos de los productos
	 */
	private PanelDProductos panelDatosProductos;

	/*
	 * Panel que contiene la tabla con los productos almacenados
	 */
	private PanelProductosRegistrados panelProductosRegistrados;

	/*
	 * Panel principal del inventario
	 */

	private JPanel contentPane;
	
	
	/*
	 * Representa la interfaz principal de la factura
	 */
	private InterfazFacturaPrincipal principal;



	/**
	 * Create the frame.
	 */
	public Inventario(InterfazFacturaPrincipal pPrincipal) {
		
		principal = pPrincipal;
		principal.setVisible(false);

		// Caracteristicas del panel
		setTitle("Inventario TecnoSmart");
		setSize(793, 561);
		setLocationRelativeTo(null);
		setResizable(true);

		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		// Instancia de los paneles
		panelNavegacion = new PanelNav(this);
		panelDatosProductos = new PanelDProductos(this);
		panelProductosRegistrados = new PanelProductosRegistrados(this);

		// Organizar el panel mediante border layout
		contentPane.add(panelNavegacion, BorderLayout.NORTH);
		contentPane.add(panelDatosProductos, BorderLayout.WEST);
		contentPane.add(panelProductosRegistrados, BorderLayout.CENTER);

	}
	//Implementacion de metodos funcionales
	
	public void guardarProducto() {
		
	}
	
	public void actualizarProducto() {
		
	}
	
	public void eliminarProducto() {
		
	}
	
	public void eliminarTodo() {
		
	}
}


