package grupo4.espe.factura.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class PanelDatosProductos extends JPanel {

	// --------------------------------------
	// Constantes
	// --------------------------------------

	/*
	 * Constante que representa para guardar los productos
	 */

	public final static String GUARDAR = "Guardar";

	// --------------------------------------
	// Atributos
	// --------------------------------------

	// Etiqueta y zona de texto para el codigo del producto
	private JLabel labCodigo;
	private JTextField txtCodigo;

	// Etiqueta y zona de texto para el nombre del producto
	private JLabel labNombre;
	private JTextField txtNombre;

	// Etiqueta y zona de texto para la descrpcion del producto
	private JLabel labDescripcion;
	private JTextField txtDescripcion;

	// Etiqueta y zona de texto para el precio del producto
	private JLabel labPrecio;
	private JTextField txtPrecio;

	// Etiqueta y zona de texto para la cantidad del producto
	private JLabel labCantidad;
	private JTextField txtCantidad;

	// Boton para guardar los datos del productos
	private JButton btnGuardar;

	// Etiqueta para una foto random
	private JLabel labImagen;

	/*
	 * Interfaz principal de la aplicacion
	 */

	private InterfazProductos productos;

	public PanelDatosProductos(InterfazProductos pProductos) {

		// Caracteristicas del Panel
		setLayout(new BorderLayout());
		TitledBorder border = BorderFactory.createTitledBorder("Datos de los productos");
		border.setTitleColor(Color.blue);
		setBorder(border);

		// Panel donde se muestra la foto al alzar
		JPanel panelFoto;

		// Panel donde se muestra la informacion del producto
		JPanel panelInformacion;

		panelFoto = new JPanel();
		add(panelFoto, BorderLayout.EAST);

		panelInformacion = new JPanel();
		add(panelInformacion, BorderLayout.CENTER);

		// Etiqueta para la imagen
		labImagen = new JLabel("Foto");
		panelFoto.add(labImagen);

		// Creacion de las etiquetas
		labCodigo = new JLabel("Codigo: ");
		labNombre = new JLabel("Nombre: ");
		labDescripcion = new JLabel("Descripcion: ");
		labPrecio = new JLabel("Precio: ");
		labCantidad = new JLabel("Cantidad: ");

		// Creacion y configuracion de la zona de texto para el codigo
		txtCodigo = new JTextField(15);
		txtCodigo.setEditable(true);
		txtCodigo.setBackground(Color.WHITE);
		txtCodigo.setForeground(Color.BLUE);

		// Creacion y configuracion de la zona de texto para el nombre
		txtNombre = new JTextField(15);
		txtNombre.setEditable(true);
		txtNombre.setBackground(Color.WHITE);
		txtNombre.setForeground(Color.BLUE);

		// Creacion y configuracion de la zona de texto para el descripcion
		txtDescripcion = new JTextField(15);
		txtDescripcion.setEditable(true);
		txtDescripcion.setBackground(Color.WHITE);
		txtCodigo.setForeground(Color.BLUE);

		// Creacion y configuracion de la zona de texto para el precio
		txtPrecio = new JTextField(15);
		txtPrecio.setEditable(true);
		txtPrecio.setBackground(Color.WHITE);
		txtPrecio.setForeground(Color.BLUE);
		

		// Creacion y configuracion de la zona de texto para el cantidad
		txtCantidad = new JTextField(15);
		txtCantidad.setEditable(true);
		txtCantidad.setBackground(Color.WHITE);
		txtCantidad.setForeground(Color.BLUE);
		
		/*
		 * Comando para guardar los datos del producto
		 */
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setActionCommand(GUARDAR);
		
		//Se agregan los elementos al panel
		panelInformacion.setLayout( new GridLayout(6,2));
		panelInformacion.add(labCodigo);
		panelInformacion.add(txtCodigo);
		panelInformacion.add(labNombre);
		panelInformacion.add(txtNombre);
		panelInformacion.add(labDescripcion);
		panelInformacion.add(txtDescripcion);
		panelInformacion.add(labPrecio);
		panelInformacion.add(txtPrecio);
		panelInformacion.add(labCantidad);
		panelInformacion.add(txtCantidad);
		panelInformacion.add(btnGuardar);
		panelInformacion.add( new JLabel(""));
		
		
	}

}
