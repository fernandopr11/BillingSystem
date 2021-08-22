package grupo4.espe.factura.interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class InterfazProductos extends JFrame {

	// ---------------------------------------
	// Atributos
	// ---------------------------------------
	
	/*
	 * Representa al panel de Navegacion
	 */
	
	private PanelNavegacion panelNavegacion;
	
	/*
	 * Representa al panel de los productos
	 */
	
	private PanelDatosProductos panelDatosProductos;
	
	
	/*
	 * Representa el panel de los productos guardados
	 */
	private PanelProductos panelProductos;


	// Constructor
	public InterfazProductos() {

		setTitle("Inventario TecnoSmart");
		setSize(800, 1000);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		//Instancia de los paneles
		panelNavegacion = new PanelNavegacion(this);
		panelDatosProductos = new PanelDatosProductos(this);
		panelProductos = new PanelProductos();
		
		
		// Organizar el panel principal mediante BorderLayout
		add(panelNavegacion, BorderLayout.NORTH);
		add(panelDatosProductos, BorderLayout.CENTER);
		add(panelProductos, BorderLayout.EAST);
		
		
		
		
		

	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazProductos frame = new InterfazProductos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
