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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class PanelDProductos extends JPanel implements ActionListener {

	// -----------------------------------------
	// Constantes
	// -----------------------------------------

	/*
	 * Comando para para limpiar los campos de los productos
	 */

	private final static String LIMPIAR_CAMPOS = "Limpoiar";

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
	 * Boton para limpiar los campos
	 */
	private JButton btnLimpiarCampos;

	/*
	 * Interfaz principal de la aplicacion
	 */
	private Inventario principal;

	// Constructor para iniciar el panel
	public PanelDProductos(Inventario pPrincipal) {

		// Asosiacion con la interfaz principal
		principal = pPrincipal;

		// Caracteristicas del panel
		setLayout(new GridLayout(5, 2, 5, 50));
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

		// Configuracion del boton para limpiar los campos
		btnLimpiarCampos = new JButton("Limpiar Campos");
		btnLimpiarCampos.setBackground(Color.decode("#A3A3F1"));
		btnLimpiarCampos.setActionCommand(LIMPIAR_CAMPOS);

		/*
		 * Llamada al metodo addActionListener sobre los botones, el panel es encargado
		 * de atender a los eventos
		 */

		btnLimpiarCampos.addActionListener(this);

		// Se agregan los elementos al panel

		add(labCodigo);
		add(txtCodigo);
		add(labDescripcionP);
		add(txtDescripcion);
		add(labPrecio);
		add(txtPrecio);
		add(labCantidad);
		add(txtCantidad);
		add(btnLimpiarCampos);

	}

	// Metodos funcionales

	/*
	 * Metodo que devuelve el codigo del producto
	 */

	public String darCodigo() {

		String rta = txtCodigo.getText();

		return rta;

	}

	/*
	 * Metodo que devuelve la descripcion del producto
	 */

	public String darDescripcion() {

		String rta = txtDescripcion.getText();

		return rta;

	}

	/*
	 * Metodo que devuelve el precio del producto
	 */

	public String darPrecio() {

		String rta = txtPrecio.getText();

		return rta;

	}

	/*
	 * Metodo que devuelve la cantidad del producto
	 */

	public String darCantidad() {

		String rta = txtCantidad.getText();

		return rta;

	}

	/*
	 * 
	 * Metodo para limpiar los campos del producto
	 * 
	 */

	public void limpiarCampos() {

		txtCodigo.setText("");
		txtDescripcion.setText("");
		txtPrecio.setText("");
		txtCantidad.setText("");
	}

	public JTextField getTxtCodigo() {

		return txtCodigo;
	}

	public JTextField getTxtDescripcion() {
		return txtDescripcion;
	}

	public JTextField getTxtPrecio() {
		return txtPrecio;
	}

	public JTextField getTxtCantidad() {
		return txtCantidad;
	}

	public void actionPerformed(ActionEvent evento) {
		
		String comando = evento.getActionCommand();
		
		if(comando.equals(LIMPIAR_CAMPOS)) {
			
		 this.limpiarCampos();	
			
			
		}
		
	}

}
