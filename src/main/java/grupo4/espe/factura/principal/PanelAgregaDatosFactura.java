package grupo4.espe.factura.principal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Document;

import org.bson.BasicBSONObject;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import grupo4.espe.factura.mongodb.ConexionMongoTecnoSmart;
import grupo4.espe.factura.proyectoMundo.Producto;

public class PanelAgregaDatosFactura extends JPanel implements ActionListener{
	
	private InterfazFacturaPrincipal principal;
	//Panel Norte Agregar Datos Factura
	private JPanel agrDatosFactura;
	private JButton bntAgrProducto;
	private JLabel labCodigo;

	private JLabel labCantidad;

	private JTextField txtCodigo;

	private JTextField txtCantidad;
	
	public final static String AGREGAR_PRODUCTO = "Agregar Producto";
	
	//Panel Sur Lista de producto agregados-----------------------------------------------------
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
	  
	     
	     bntAgrProducto = new JButton(AGREGAR_PRODUCTO);
	     bntAgrProducto.setBackground(Color.decode("#6CC3E3"));
	     bntAgrProducto.addActionListener(this);
	     agrDatosFactura.add(bntAgrProducto, BorderLayout.CENTER);
	    
	   //Panel Sur Lista de producto agregados -------------------------------------------------------------------------------
	     listaProductoFactura = new JPanel();
	     listaProductoFactura.setLayout(new BorderLayout());
	     agrDatosFactura.add(listaProductoFactura, BorderLayout.SOUTH);
	     
	     LineBorder lineaBorde2 = new LineBorder(Color.BLACK); //Agregar borde con titulo
		 TitledBorder borDatos2 = new TitledBorder(lineaBorde2, "Lista de compra");
		 listaProductoFactura.setBorder(borDatos2);
	     
		 JScrollPane scrollPane = new JScrollPane();
	     scrollPane.setBounds(10,11,560, 227);
	     listaProductoFactura.add(scrollPane, BorderLayout.NORTH);
	     
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
	     listaProductoFactura.add(imToFactura, BorderLayout.SOUTH);
	     
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

	public void actionPerformed(ActionEvent e) {

		String comando = e.getActionCommand();

		if (comando.equals(AGREGAR_PRODUCTO)) {
	
			if(this.darCodigoTxt().equals("") || this.darCantidadTxt().equals("")) {
				JOptionPane.showMessageDialog(null, "Ingresar todos los datos necesarios", comando,
						JOptionPane.ERROR_MESSAGE);
			}else {
				
				try {
					ConexionMongoTecnoSmart mongo = new ConexionMongoTecnoSmart();
					DB db = mongo.conectarMongoDB();
					DBCollection coleccion = db.getCollection("Inventario");
					
					String codigo = txtCodigo.getText();
					mongo.mostrarProducto(coleccion, codigo);
					
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		}
	}
	
	public String darCodigoTxt() {
		String cod = txtCodigo.getText();
		return cod;
	}
	
	public String darCantidadTxt() {
		String cant = txtCantidad.getText();
		return cant;
	}
}
