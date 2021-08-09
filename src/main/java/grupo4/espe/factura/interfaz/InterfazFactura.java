package grupo4.espe.factura.interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class InterfazFactura extends JFrame {

	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public InterfazFactura() {
		setTitle( "Cálculo impuestos" );
		setSize( 600, 700 );
		setResizable( false );
		setDefaultCloseOperation( EXIT_ON_CLOSE );
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazFactura frame = new InterfazFactura();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


}
