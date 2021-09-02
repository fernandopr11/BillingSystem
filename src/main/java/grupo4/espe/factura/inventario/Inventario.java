package grupo4.espe.factura.inventario;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Inventario extends JFrame {
	
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtCodigo;
	private JTextField txtDescripcion;
	private JTextField txtPrecio;
	private JTextField txtCantidad;
	private JButton btnGuardar;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JButton btnEliminarTodo;
	private JTable table;
	private DefaultTableModel model;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inventario frame = new Inventario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Inventario() {
		
		setTitle("Inventario TecnoSmart");
		setSize(793, 561); 
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		//contentPane.setBorder(new TitledBorder(null, "Panel1", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setBorder(new TitledBorder(null, "PanelNavegacion", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel labDescripcion = new JLabel("Sistema de Inventario TecnoSmart");
		labDescripcion.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		panel.add(labDescripcion);
		
		JButton btnIrFactura = new JButton("IrFactura");
		btnIrFactura.setBackground(Color.decode("#6CC3E3"));
		panel.add(btnIrFactura);
		
		
		JPanel panelDatosProductos = new JPanel();
		contentPane.add(panelDatosProductos, BorderLayout.WEST);
		panelDatosProductos.setBorder(new TitledBorder(null, "Panel Datos  Productos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDatosProductos.setLayout(new GridLayout(6, 2, 15, 20));
		
		
		
		JLabel labNombre = new JLabel("Nombre");
		JLabel labDescripcionP = new JLabel("Descripcion");
		JLabel labCodigo = new JLabel("Codigo");
		JLabel labPrecio = new JLabel("Precio");
		JLabel labCantidad = new JLabel("Cantidad");
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setColumns(10);
		
		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		
		txtCantidad = new JTextField();
		txtCantidad.setColumns(10);
			
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBackground(Color.decode("#6CC3E3"));
		
		
		panelDatosProductos.add(labNombre);
		panelDatosProductos.add(txtNombre);
		panelDatosProductos.add(labDescripcionP);
		panelDatosProductos.add(txtDescripcion);
		panelDatosProductos.add(labCodigo);
		panelDatosProductos.add(txtCodigo);
		panelDatosProductos.add(labPrecio);
		panelDatosProductos.add(txtPrecio);
		panelDatosProductos.add(labCantidad);
		panelDatosProductos.add(txtCantidad);
		//panelDatosProductos.add(btnBuscar);
		panelDatosProductos.add(btnGuardar);
		
		JPanel panelProductosAl = new JPanel();
		contentPane.add(panelProductosAl, BorderLayout.CENTER);
		panelProductosAl.setBorder(new TitledBorder(null, "Productos Almacenados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelProductosAl.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panelProductosAl.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setBackground(Color.decode("#F4A79B"));
		panel_1.add(btnActualizar);
		
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBackground(Color.decode("#F4A79B"));
		panel_1.add(btnEliminar);
		
		btnEliminarTodo = new JButton("EliminarTodo");
		btnEliminarTodo.setBackground(Color.decode("#F4A79B"));
		panel_1.add(btnEliminarTodo);
		
		JScrollPane scrollPane = new JScrollPane();
		panelProductosAl.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setBackground( new Color(176, 196, 22));
		model = new DefaultTableModel();
		Object [] colum = {"Codigo", "Nombre", "Descripcion", "Precio", "Cantidad"};
		Object [] row = new Object[0];
		model.setColumnIdentifiers(colum);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		
		
		
		
	
		
		
	
	}

}
