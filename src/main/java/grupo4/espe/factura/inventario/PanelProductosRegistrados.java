package grupo4.espe.factura.inventario;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import grupo4.espe.factura.principal.PanelAgregaDatosFactura;

public class PanelProductosRegistrados extends JPanel implements ActionListener {

	// -----------------------------------------
	// Constantes
	// -----------------------------------------

	/*
	 * Comando para el boton guardar
	 */

	private final static String GUARDAR = "Guardar";

	/*
	 * Comando para el boton actualizar
	 */
	private final static String ACTUALIZAR = "Actualizar";

	/*
	 * Comando para el boton eliminar un producto
	 * 
	 */
	private final static String ELIMINAR_PRODUCTO = "Eliminar";

	/*
	 * Comando para el boton eliminar todos los productos
	 */

	private final static String ELIMINAR_TODO = "Eliminar todo";

	// -----------------------------------------
	// Atributos
	// -----------------------------------------

	/*
	 * Boton para guardar los productos
	 */

	private JButton btnGuardar;

	/*
	 * Boton para actualizar los datos del los productos
	 */

	private JButton btnActualizar;

	/*
	 * Boton para eliminar un producto
	 */

	private JButton btnEliminar;

	/*
	 * Boton para eliminar todos los productos
	 */

	private JButton btnEliminarTodo;

	/*
	 * Panel donde se van a agregar los botones
	 */

	private JPanel panelBotones;

	/*
	 * Modelo por defecto de la tabla
	 */
	private DefaultTableModel model;

	/*
	 * Tabla para mostrar los campos de los productos
	 */
	private JTable tablaProductos;

	/*
	 * Scrollpane para redimensionar los componentes
	 */

	private JScrollPane scrollPane;

	/*
	 * Interfaz principal de la aplicacion
	 */
	private Inventario principal;

	/*
	 * Objeto para agregar las filas
	 */
	private Object[] row;

	/*
	 * Panel que contiene los datos del producto
	 */

	private PanelDProductos panelDatos;

	/*
	 * Indice de la fila del productos
	 */

	private int indice;

	private JTextField txtCodigo;
	private JTextField txtDescripcion;
	private JTextField txtPrecio;
	private JTextField txtCantidad;

	// Constructor para iniciar el panel
	public PanelProductosRegistrados(PanelDProductos pPanel) {

		// Panel que contiene los datos del producto
		panelDatos = pPanel;

		// Caracteristicas del panel
		setBorder(new TitledBorder(null, "Productos Almacenados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new BorderLayout(0, 0));

		// Panel para agregar los botones el cual estara en la zona sur
		panelBotones = new JPanel();
		add(panelBotones, BorderLayout.SOUTH);
		panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		/*
		 * Se crea el botones y se les asocia el comando respectivo
		 */

		// Configuracion del boton guardar

		btnGuardar = new JButton("Guardar");
		btnGuardar.setBackground(Color.decode("#F4A79B"));
		btnGuardar.setActionCommand(GUARDAR);
		panelBotones.add(btnGuardar);

		// Configuracion del boton actualizar

		btnActualizar = new JButton("Actualizar");
		btnActualizar.setBackground(Color.decode("#F4A79B"));
		btnActualizar.setActionCommand(ACTUALIZAR);
		panelBotones.add(btnActualizar);

		// Configuracion del boton para eliminar productos
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBackground(Color.decode("#F4A79B"));
		btnEliminar.setActionCommand(ELIMINAR_PRODUCTO);
		panelBotones.add(btnEliminar);

		// Configuracion del boton para eliminar todos los productos
		btnEliminarTodo = new JButton("EliminarTodo");
		btnEliminarTodo.setBackground(Color.decode("#F4A79B"));
		btnEliminarTodo.setActionCommand(ELIMINAR_TODO);
		panelBotones.add(btnEliminarTodo);

		/*
		 * Llamada al metodo addActionListener sobre los botones, el panel es encargado
		 * de atender a los eventos
		 */

		btnGuardar.addActionListener(this);
		btnActualizar.addActionListener(this);
		btnEliminar.addActionListener(this);
		btnEliminarTodo.addActionListener(this);

		// Configuracion de la tabla

		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		tablaProductos = new JTable();
		model = new DefaultTableModel();
		Object[] colum = { "Codigo", "Descripcion", "Precio", "Cantidad" };
		row = new Object[4];
		model.setColumnIdentifiers(colum);
		tablaProductos.setModel(model);
		scrollPane.setViewportView(tablaProductos);

		// MouseListener agregado a la tabla de los productos

		tablaProductos.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent arg0) {

				indice = tablaProductos.getSelectedRow();

				panelDatos.getTxtCodigo().setText(model.getValueAt(indice, 0).toString());
				panelDatos.getTxtDescripcion().setText(model.getValueAt(indice, 1).toString());
				panelDatos.getTxtPrecio().setText(model.getValueAt(indice, 2).toString());
				panelDatos.getTxtCantidad().setText(model.getValueAt(indice, 3).toString());

			}

		});

	}

	public void actionPerformed(ActionEvent evento) {
		String comando = evento.getActionCommand();

		if (comando.equals(ACTUALIZAR)) {

			indice = tablaProductos.getSelectedRow();

			if (indice >= 0) {

				model.setValueAt(panelDatos.darCodigo(), indice, 0);
				model.setValueAt(panelDatos.darDescripcion(), indice, 1);
				model.setValueAt(panelDatos.darPrecio(), indice, 2);
				model.setValueAt(panelDatos.darCantidad(), indice, 3);

				JOptionPane.showMessageDialog(null, "Producto actualizado satisfactoriamente");

			} else {

				JOptionPane.showMessageDialog(null, "Selecciona un producto para actualizar", comando,
						JOptionPane.ERROR_MESSAGE);

			}

		} else if (comando.equals(ELIMINAR_PRODUCTO)) {

			indice = tablaProductos.getSelectedRow();

			if (indice >= 0) {

				model.removeRow(indice);
				JOptionPane.showMessageDialog(null, "Producto eliminado correctamente");

			} else {

				JOptionPane.showMessageDialog(null, "Selecciona un producto", comando, JOptionPane.ERROR_MESSAGE);
			}

		} else if (comando.equals(ELIMINAR_TODO)) {

			model.setRowCount(0);

			JOptionPane.showMessageDialog(null, "Todos los productos han sido eliminados");

		} else if (comando.equals(GUARDAR)) {

			if (panelDatos.darCodigo().equals("") || panelDatos.darDescripcion().equals("")
					|| panelDatos.darPrecio().equals("") || panelDatos.darCantidad().equals("")) {

				JOptionPane.showMessageDialog(null, "Ingresar todos los datos de los productos", comando,
						JOptionPane.ERROR_MESSAGE);

			} else {

				row[0] = panelDatos.darCodigo();
				row[1] = panelDatos.darDescripcion();
				row[2] = panelDatos.darPrecio();
				row[3] = panelDatos.darCantidad();

				if (panelDatos.isControl() == true) {

					panelDatos.guardarMongoDatosProducto();

					model.addRow(row);

					panelDatos.limpiarCampos();

				}

			}

		}
	}

}
