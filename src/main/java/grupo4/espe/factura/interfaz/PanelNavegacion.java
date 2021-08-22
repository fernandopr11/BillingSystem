package grupo4.espe.factura.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelNavegacion extends JPanel  implements ActionListener{

	// --------------------------------------
	// Constantes
	// --------------------------------------

	/*
	 * Constante que presente el regreso a la factura
	 */

	private static final String IR_FACTURA = "Ir Factura";

	/*
	 * Constante que representa la ruta de la imagen
	 */

	private static final String RUTA_IMAGEN = "./data/logo.jpg";

	// --------------------------------------
	// Atributos
	// --------------------------------------

	/*
	 * JLabel para mostrar el nombre de la empresa
	 */

	private JLabel labNombreEmpresa;

	/*
	 * JLabel para mostar el logo de la empresa
	 */
	private JLabel labLogoEmpresa;

	/*
	 * JButton para regresar a la factura
	 */
	private JButton btnIrFactura;

	/*
	 * Interfaz principal de la aplicacion
	 */

	private InterfazProductos productos;

	public PanelNavegacion(InterfazProductos pProductos) {

		// Caracteristicas del panel
		setLayout(new FlowLayout());
		TitledBorder border = BorderFactory.createTitledBorder("Navegacion");
		border.setTitleColor(Color.blue);
		setBorder(border);
		
		
		//Se crean las etiquetas para el logo y el nombre de la empresa
		labLogoEmpresa = new JLabel();
		labLogoEmpresa.setIcon( new ImageIcon(RUTA_IMAGEN));
		
		labNombreEmpresa = new JLabel("Sistema de Inventario TecnoSmart");
		labLogoEmpresa.setFont( new Font("Noto", Font.PLAIN, 25));

		
		//Se crean el boton para ir a la factura
		btnIrFactura = new JButton(IR_FACTURA);
		btnIrFactura.setBackground(Color.decode("#6CC3E3"));
		btnIrFactura.setFont( new Font("Noto", Font.PLAIN, 15));
		btnIrFactura.setForeground(Color.BLACK);
		
		//Se agregan los elementos al panel
		add(labLogoEmpresa);
		add(labNombreEmpresa);
		add(btnIrFactura);		
		
		
		

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
