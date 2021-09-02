package grupo4.espe.factura.principal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class PanelListaProductosFactura extends JPanel{
	private InterfazFacturaPrincipal principal;
	//Panel Sur Lista de producto agregados
		private JPanel listaProductoFactura;		
		// el modelo de tabla, aquí van a estar los datos.
		 private DefaultTableModel model;
		// la tabla
		 private JTable table;
		 //Elementos de importes totales
		 
		 private JLabel labSubtotal;
		 private JTextField txtSubtotal;
		 
		 private JLabel labDescuento;
		 private JTextField txtDescuento;
		 
		 private JLabel labSubDescuento;
		 private JTextField txtSubDescuento;
		 
		 private JLabel labIVA;
		 private JTextField txtIVA;
		 
		 private JLabel labTotal;
		 private JTextField txtTotal;
		 
	public PanelListaProductosFactura(InterfazFacturaPrincipal pPrincipal) {
		principal = pPrincipal;
		//-------------------------------------------------------
		setLayout(new BorderLayout());
	     //Panel Sur Lista de producto agregados
	     listaProductoFactura = new JPanel();
	     add(listaProductoFactura, BorderLayout.NORTH);
	     
	     LineBorder lineaBorde2 = new LineBorder(Color.BLACK); //Agregar borde con titulo
		 TitledBorder borDatos2 = new TitledBorder(lineaBorde2, "Lista de compra");
		 setBorder(borDatos2);
	     
		 JScrollPane scrollPane = new JScrollPane();
	     scrollPane.setBounds(10,11,560, 227);
	     add(scrollPane, BorderLayout.NORTH);
	     
	     //Nombre de columnas
	     String[] nombreDeColumnas = {"Codigo", "Detalle", "Cantidad", 
	    		 "V. Unitario", "V. Total"
	     };
	     //Crea un modelo de tabla
	     model = new DefaultTableModel(null, nombreDeColumnas);
	     //Añade modelo a tabla
	     table = new JTable(model);
	     //Muestra tabla en scrollpane
	     scrollPane.setViewportView(table); 
	     
	     //Etiquetas y JFields de importes totales
	     
	     JPanel imToFactura = new JPanel();
	     imToFactura.setLayout(new GridLayout(5, 2));
	     add(imToFactura, BorderLayout.SOUTH);
	     
	     labSubtotal = new JLabel("Subtotal");
	     imToFactura.add(labSubtotal);
	     
	     txtSubtotal = new JTextField();
	     imToFactura.add(txtSubtotal);
	     
	     labDescuento = new JLabel("Descuento");
	     imToFactura.add(labDescuento);
	     
	     txtDescuento = new JTextField();
	     imToFactura.add(txtDescuento);
	     
	     labSubDescuento = new JLabel("Sub. Descuento");
	     imToFactura.add(labSubDescuento);
	     
	     txtSubDescuento = new JTextField();
	     imToFactura.add(txtSubDescuento);
	     
	     labIVA = new JLabel("IVA 12%");
	     imToFactura.add(labIVA);
	     
	     txtIVA = new JTextField();
	     imToFactura.add(txtIVA);
	     
	     labTotal = new JLabel("Total");
	     imToFactura.add(labTotal);
	     
	     txtTotal = new JTextField();
	     imToFactura.add(txtTotal);
	}
}
