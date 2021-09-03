package grupo4.espe.factura.inventario;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class PanelProductosRegistrados extends JPanel implements ActionListener {

	// -----------------------------------------
	// Constantes
	// -----------------------------------------

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

	// Constructor para iniciar el panel
	public PanelProductosRegistrados(Inventario pPrincipal) {

		// Asociacion con la interfaz principal
		principal = pPrincipal;

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

		btnActualizar.addActionListener(this);
		btnEliminar.addActionListener(this);
		btnEliminarTodo.addActionListener(this);

		// Configuracion de la tabla

		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		tablaProductos = new JTable();
		tablaProductos.setBackground(new Color(176, 196, 22));
		model = new DefaultTableModel();
		Object[] colum = { "Codigo", "Nombre", "Descripcion", "Precio", "Cantidad" };
		Object[] row = new Object[0];
		model.setColumnIdentifiers(colum);
		tablaProductos.setModel(model);
		scrollPane.setViewportView(tablaProductos);

	}

	public void actionPerformed(ActionEvent evento) {
		String comando = evento.getActionCommand();

		if(comando.equals(ACTUALIZAR)) {			
			principal.actualizarProducto();
		} else if (comando.equals(ELIMINAR_PRODUCTO)) {
			principal.eliminarProducto();	

		} else if (comando.equals(ELIMINAR_TODO)) {		
			principal.eliminarTodo();	
		}
	}

}
