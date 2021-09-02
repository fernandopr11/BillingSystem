package grupo4.espe.factura.inventario;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import grupo4.espe.factura.principal.InterfazFacturaPrincipal;

public class PanelNav extends JPanel implements ActionListener {

	// -----------------------------------------
	// Constantes
	// -----------------------------------------

	/*
	 * Comando para el boton ir factura
	 */

	private final static String IRFACTURA = "Ir Factura";

	// -----------------------------------------
	// Atributos
	// -----------------------------------------

	/*
	 * Etiqueta para la descripcion del panel
	 */
	JLabel labDescripcion;

	/*
	 * Boton para ir a la interfaz principal factura
	 */
	JButton btnIrFactura;

	/*
	 * Interfaz principal de la aplicacion
	 */
	private Inventario principal;

	// Constructor para iniciar el panel
	public PanelNav(Inventario pPrincipal) {

		// Asosiacion con la interfaz principal
		principal = pPrincipal;

		// Caracteristicas del panel
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		TitledBorder border = BorderFactory.createTitledBorder("Panel Navegacion");
		border.setTitleColor(Color.blue);
		setBorder(border);

		// Creacion de las etiquetas y los botones
		JLabel labDescripcion = new JLabel("Sistema de Inventario TecnoSmart");
		labDescripcion.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));

		/*
		 * Se crea el boton para ir a la factura y se le asocia el comando respectivo
		 */
		btnIrFactura = new JButton("IrFactura");
		btnIrFactura.setBackground(Color.decode("#6CC3E3"));
		btnIrFactura.setActionCommand(IRFACTURA);

		/*
		 * Llamada al metodo addActionListener sobre los botones, el panel es encargado
		 * de atender a los eventos
		 */

		btnIrFactura.addActionListener(this);

		// Se agregan los elementos al panel
		add(labDescripcion);
		add(btnIrFactura);

	}

	/*
	 * Metodo actionPerformed que se ejecuta cada vez que se genera un evento como
	 * consecuencia de una accion al usuario
	 * 
	 * @param evento Evento generado
	 */

	public void actionPerformed(ActionEvent evento) {

		String comando = evento.getActionCommand();

		if (comando.equals(IRFACTURA)) {
			
			InterfazFacturaPrincipal ventanaP;
			
			try {
				
				ventanaP = new InterfazFacturaPrincipal();
				ventanaP.setVisible(true);
				principal.setVisible(false);
				
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}

		}

	}

}
