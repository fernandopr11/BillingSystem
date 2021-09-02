package grupo4.espe.factura.principal;

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

	private JLabel labCantidad;

	private JTextField txtCodigo;

	private JTextField txtCantidad;

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
	     bntAgrProducto.setBackground(Color.decode("#6CC3E3"));
	     bntAgrProducto.addActionListener(this);
	     agrDatosFactura.add(bntAgrProducto, BorderLayout.SOUTH);
	    
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
