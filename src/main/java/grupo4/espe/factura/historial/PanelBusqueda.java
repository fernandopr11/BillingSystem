package grupo4.espe.factura.historial;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class PanelBusqueda extends JPanel  implements ActionListener{

	//atributos ***************************************************************
	private InterfazHistorialFac historial;

	private DefaultTableModel model;
	// la tabla
	private JTable table;


	//metodo constructor ************************************************************** 
	public PanelBusqueda(InterfazHistorialFac pHistorial) {

		historial = pHistorial;

		JPanel panelMuestraDatos;

		setLayout(new BorderLayout());
		TitledBorder border = BorderFactory.createTitledBorder("Panel de Busquedas");
		border.setTitleColor(Color.BLUE);
		setBorder(border);

		panelMuestraDatos =new JPanel();
		add(panelMuestraDatos, BorderLayout.CENTER);


		//Panel Sur Lista de producto agregados
		JPanel listaProductoFactura = new JPanel();
		listaProductoFactura.setLayout(new BorderLayout());
		add(listaProductoFactura, BorderLayout.CENTER);

		LineBorder lineaBorde2 = new LineBorder(Color.BLACK); //Agregar borde con titulo
		TitledBorder borDatos2 = new TitledBorder(lineaBorde2, "Lista de Historial ");
		listaProductoFactura.setBorder(borDatos2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10,11,560, 227);
		listaProductoFactura.add(scrollPane, BorderLayout.CENTER);

		//Nombre de columnas
		String[] nombreDeColumnas = {"#FACT", "FECHA", "CLIENTE", 
				"TIP. CLIENTE", "TOTAL"
		};
		//Crea un modelo de tabla
		model = new DefaultTableModel(null, nombreDeColumnas);
		//Añade modelo a tabla
		table = new JTable(model);
		//Muestra tabla en scrollpane
		scrollPane.setViewportView(table);

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}


}
