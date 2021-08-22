package grupo4.espe.factura.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class PanelProductos extends JPanel {

	// el modelo de tabla, aquí van a estar los datos.
	private DefaultTableModel model;
	// la tabla
	private JTable table;

	/**
	 * Create the panel.
	 */
	public PanelProductos() {

		// Caracteristicas del Panel
		setLayout(new BorderLayout());
		TitledBorder border = BorderFactory.createTitledBorder("Productos Almacenados");
		border.setTitleColor(Color.blue);
		setBorder(border);

		// Panel Sur Lista de producto agregados
		JPanel listaProductoFactura = new JPanel();
		listaProductoFactura.setLayout(new BorderLayout());
		add(listaProductoFactura, BorderLayout.SOUTH);

		LineBorder lineaBorde2 = new LineBorder(Color.BLACK); // Agregar borde con titulo
		TitledBorder borDatos2 = new TitledBorder(lineaBorde2, "Lista de compra");
		listaProductoFactura.setBorder(borDatos2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 560, 227);
		listaProductoFactura.add(scrollPane, BorderLayout.CENTER);

		// Nombre de columnas
		String[] nombreDeColumnas = { "Codigo", "Detalle", "Cantidad", "V. Unitario", "V. Total" };
		// Crea un modelo de tabla
		model = new DefaultTableModel(null, nombreDeColumnas);
		// Añade modelo a tabla
		table = new JTable(model);
		// Muestra tabla en scrollpane
		scrollPane.setViewportView(table);		

	}

}
