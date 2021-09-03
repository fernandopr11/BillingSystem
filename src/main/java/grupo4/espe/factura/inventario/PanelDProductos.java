package grupo4.espe.factura.inventario;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class PanelDProductos extends JPanel implements ActionListener {

	// -----------------------------------------
	// Constantes
	// -----------------------------------------

	/*
	 * Comando para guardar un productos
	 */

	private final static String GUARDAR = "Guardar";

	// -----------------------------------------
	// Atributos
	// -----------------------------------------

	/*
	 * Etiqueta y zona de texto para el codigo
	 */
	private JTextField txtCodigo;
	private JLabel labCodigo;

	/*
	 * Etiqueta y zona de texto para la descripcion
	 */
	private JTextField txtDescripcion;
	private JLabel labDescripcionP;

	/*
	 * Etiqueta y zona de texto para el precio
	 */
	private JTextField txtPrecio;
	private JLabel labPrecio;

	/*
	 * Etiqueta y zona de texto para la cantidad
	 */
	private JTextField txtCantidad;
	private JLabel labCantidad;

	/*
	 * Boton para guardar el producto
	 */
	private JButton btnGuardar;

	/*
	 * Interfaz principal de la aplicacion
	 */
	private Inventario principal;

	// Constructor para iniciar el panel
	public PanelDProductos(Inventario pPrincipal) {

		// Asosiacion con la interfaz principal
		principal = pPrincipal;

		// Caracteristicas del panel
		setLayout(new GridLayout(6, 2, 5, 30));
		TitledBorder border = BorderFactory.createTitledBorder("Panel Datos Productos ");
		border.setTitleColor(Color.blue);
		setBorder(border);

		// Creacion de las etiquetas y zonas de texto
		labDescripcionP = new JLabel("Descripcion");
		txtDescripcion = new JTextField();
		txtDescripcion.setColumns(10);

		labCodigo = new JLabel("Codigo");
		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);

		labPrecio = new JLabel("Precio");
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);

		labCantidad = new JLabel("Cantidad");
		txtCantidad = new JTextField();
		txtCantidad.setColumns(10);

		/*
		 * Se crea el boton guardar el producto y se le asocia el comando respectivo
		 */
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBackground(Color.decode("#6CC3E3"));
		btnGuardar.setActionCommand(GUARDAR);

		/*
		 * Llamada al metodo addActionListener sobre los botones, el panel es encargado
		 * de atender a los eventos
		 */

		btnGuardar.addActionListener(this);

		// Se agregan los elementos al panel

		add(labCodigo);
		add(txtCodigo);
		add(labDescripcionP);
		add(txtDescripcion);
		add(labPrecio);
		add(txtPrecio);
		add(labCantidad);
		add(txtCantidad);
		add(btnGuardar);

	}

	/*
	 * Metodo actionPerformed que se ejecuta cada vez que se genera un evento como
	 * consecuencia de una accion al usuario
	 * 
	 * @param evento Evento generado
	 */
	public void actionPerformed(ActionEvent evento) {

		String comando = evento.getActionCommand();
		
		if(comando.equals(GUARDAR)) {
			principal.guardarProducto();
		}

	}

}
