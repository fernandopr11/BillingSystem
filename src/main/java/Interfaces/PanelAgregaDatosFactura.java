package Interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class PanelAgregaDatosFactura extends JPanel implements ActionListener{
	
	private InterfazFacturaPrincipal principal;
	//Panel Norte Agregar Datos Factura
	private JPanel agrDatosFactura;
	private JButton bntAgrProducto;
	private JLabel labCodigo;
	private JLabel labDetalle;
	private JLabel labCantidad;
	private JLabel labVUnit;
	private JLabel labVTotal;
	private JTextField txtCodigo;
	private JTextField txtDetalle;
	private JTextField txtCantidad;
	private JTextField txtVUnit;
	private JTextField txtVTotal;
	//Panel Sur Lista de producto agregados
	private JPanel listaProductoFactura;
	
	private JLabel labCodigo2;
	private JLabel labDetalle2;
	private JLabel labCantidad2;
	private JLabel labVUnit2;
	private JLabel labVTotal2;
	
	// el modelo de tabla, aquí van a estar los datos.
	 private DefaultTableModel model;
	// la tabla
	 private JTable table;


	public PanelAgregaDatosFactura(InterfazFacturaPrincipal pPrincipal) {
		
		principal = pPrincipal;
		
		setLayout(new BorderLayout());
	    //-------------------------------------------------------
		//Panel Norte Agregar Datos Factura
		agrDatosFactura = new JPanel();
		agrDatosFactura.setLayout(new BorderLayout()); //Agrega nueva distribucion
		add(agrDatosFactura, BorderLayout.NORTH);
		
		LineBorder lineaBorde = new LineBorder(Color.BLACK); //Agregar borde con titulo
	    TitledBorder borDatos = new TitledBorder(lineaBorde, " Agregar producto ");
	    agrDatosFactura.setBorder(borDatos);
	    
	     JPanel tabla1 = new JPanel();
	     tabla1.setLayout(new GridLayout(2,2));
	     agrDatosFactura.add(tabla1, BorderLayout.NORTH);
	     
	     labCodigo = new JLabel("Codigo");
	     tabla1.add(labCodigo);
	     labCantidad = new JLabel("Cantidad");
	     tabla1.add(labCantidad);
	  
	     txtCodigo = new JTextField();
	     tabla1.add(txtCodigo);
	     txtCantidad = new JTextField();
	     tabla1.add(txtCantidad);
	  
	     
	     bntAgrProducto = new JButton("Agregar Producto");
	     bntAgrProducto.addActionListener(this);
	     agrDatosFactura.add(bntAgrProducto, BorderLayout.SOUTH);
	    //-------------------------------------------------------
	     //Panel Sur Lista de producto agregados
	     listaProductoFactura = new JPanel();
	     listaProductoFactura.setLayout(new BorderLayout());
	     add(listaProductoFactura, BorderLayout.SOUTH);
	     
	     LineBorder lineaBorde2 = new LineBorder(Color.BLACK); //Agregar borde con titulo
		 TitledBorder borDatos2 = new TitledBorder(lineaBorde2, "Lista de compra");
		 listaProductoFactura.setBorder(borDatos2);
	     
		 JScrollPane scrollPane = new JScrollPane();
	     scrollPane.setBounds(10,11,560, 227);
	     listaProductoFactura.add(scrollPane, BorderLayout.CENTER);
	     
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
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
