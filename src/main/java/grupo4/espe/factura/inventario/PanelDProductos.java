package grupo4.espe.factura.inventario;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import grupo4.espe.factura.proyectoMundo.Producto;
import grupo4.espe.factura.proyectoMundo.TiendaTecnoSmart;

public class PanelDProductos extends JPanel implements ActionListener {

	// -----------------------------------------
	// Constantes
	// -----------------------------------------

	/*
	 * Comando para para limpiar los campos de los productos
	 */

	private final static String LIMPIAR_CAMPOS = "Limpiar";

	/*
	 * Comando para guardar los productos en mongoDB
	 */

	private final static String GUARDAR_MONGO = "Guardar mongo";

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
	 * Atributo que presenta la validacion de los campos
	 */
	private boolean control;

	/*
	 * Interfaz principal de la aplicacion
	 */
	private Inventario principal;

	/*
	 * Array list de los productos
	 */

	private ArrayList<Producto> productos;

	/*
	 * Atributo que repesenta a los productos
	 */
	private Producto product;

	/*
	 * Atributo que representa la tienda
	 */
	private TiendaTecnoSmart pTienda;

	// Constructor para iniciar el panel
	public PanelDProductos(Inventario pPrincipal, TiendaTecnoSmart myTienda, Boolean pControl) {

		// Asosiacion con la interfaz principal
		principal = pPrincipal;

		// Inicializacion de la tienda
		pTienda = myTienda;

		// Inicializacion de los productos
		product = new Producto();
		
		control = pControl;

		// Inicializacion del arrayList de los productos
		productos = new ArrayList<Producto>();
		

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
	
	public boolean isControl() {
		return control;
	}

	public void setControl(boolean control) {
		this.control = control;
	}

	public static String getLimpiarCampos() {
		return LIMPIAR_CAMPOS;
	}

	public static String getGuardarMongo() {
		return GUARDAR_MONGO;
	}

	public JLabel getLabCodigo() {
		return labCodigo;
	}

	public JLabel getLabDescripcionP() {
		return labDescripcionP;
	}

	public JLabel getLabPrecio() {
		return labPrecio;
	}

	public JLabel getLabCantidad() {
		return labCantidad;
	}

	public JButton getBtnLimpiarCampos() {
		return btnLimpiarCampos;
	}

	public Inventario getPrincipal() {
		return principal;
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public Producto getProduct() {
		return product;
	}

	public TiendaTecnoSmart getpTienda() {
		return pTienda;
	}

	public void actionPerformed(ActionEvent evento) {

		String comando = evento.getActionCommand();

		if (comando.equals(LIMPIAR_CAMPOS)) {

			this.limpiarCampos();

		}

	}

	public void guardarMongoDatosProducto() {

		// Obtener el valor de los campos de texto
		String codigo = txtCodigo.getText().toString().trim();
		String descripcion = txtDescripcion.getText().toString().trim();
		String precio = txtPrecio.getText().toString().trim();
		String cantidad = txtCantidad.getText().toString().trim();

		control = true;
		
		// Realizar las validaciones de los datos

		double precio_p = 0;

		int cantidad_p = 0;

		if (control) {

			try {

				precio_p = Double.parseDouble(precio);
				cantidad_p = Integer.parseInt(cantidad);


			} catch (Exception e) {

				control = false;
				JOptionPane.showMessageDialog(this, "El precio de venta o la cantidad debe ser numerica", "Error",
						JOptionPane.ERROR_MESSAGE);

			}

		}
	
		if (control) {

			pTienda.agregarProducto(codigo, descripcion, precio_p, cantidad_p);
			JOptionPane.showMessageDialog(null, "Productos almacenados existosamente en Base de Datos");
			principal.guardarMongo();

		}

	}
	
	

}
