package grupo4.espe.factura.principal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class PanelEncabezado extends JPanel{
	private InterfazFacturaPrincipal principal;
	
	private DateTimeFormatter dtf;
	private static final String RUTA_IMAGEN = "./dataImg/logoImg.jpeg";
	private JPanel logo;
    private JPanel fechFac;
    //Datos cliente
	private JPanel datosCliente;
    private JLabel labCedRUC;
    private JTextField txtCedRUC;
    private JLabel labNombrePE;
    private JTextField txtNombrePE;
    private JLabel labNumTelef;
    private JTextField txtNumTelef;
    private JLabel labCorreo;
    private JTextField txtCorreo;
    private JLabel labDireccion;
    private JTextField txtDireccion;
	
    private JTextField numeroFactura;
    private JTextField fechaFactura;
    
	public PanelEncabezado() {
		//principal = pPrincipal;
		
		setLayout(new BorderLayout());
		//Logo WEST
		logo = new JPanel();
		logo.setLayout(new GridLayout(1,1));
		add(logo, BorderLayout.WEST);
		
		JLabel fotoLogo = new JLabel();
		fotoLogo.setIcon(new ImageIcon(RUTA_IMAGEN));
		logo.add(fotoLogo);
		
		//Fecha y nunero de factura EAST
		fechFac = new JPanel();
		fechFac.setLayout(new GridLayout(2,2));
		add(fechFac, BorderLayout.EAST);
		
		dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
     	String fecha = dtf.format(LocalDateTime.now());
		
		TitledBorder border = new TitledBorder("");
	    border.setTitleColor(Color.BLACK);
	    fechFac.setBorder(border);
	    
	    fechFac.add(new JLabel("Fecha"));
	    fechaFactura = new JTextField(fecha);
	    fechFac.add(fechaFactura);
	  
	    fechFac.add(new JLabel("N� Factura"));
	    numeroFactura = new JTextField("");
	    fechFac.add(numeroFactura);
	    
	    

		//Datos Cliente
	    datosCliente = new JPanel();
	    datosCliente.setLayout(new GridLayout(5,2));
	    add(datosCliente, BorderLayout.SOUTH);
	    
	    //TitledBorder borTitulo = new TitledBorder("Datos de cliente");
	    LineBorder lineaBorde = new LineBorder(Color.BLACK);
	    TitledBorder borDatos = new TitledBorder(lineaBorde, " Datos de cliente ");
	    datosCliente.setBorder(borDatos);
	    
	    labCedRUC = new JLabel("Cedula/RUC");
	    datosCliente.add(labCedRUC);
	    
	    txtCedRUC = new JTextField();
	    datosCliente.add(txtCedRUC);
	    
	    labNombrePE = new JLabel("Cliente: ");
	    datosCliente.add(labNombrePE);
	    
	    txtNombrePE = new JTextField();
	    datosCliente.add(txtNombrePE);
	    
	    labNumTelef = new JLabel("Telefono :");
	    datosCliente.add(labNumTelef);
	    
	    txtNumTelef = new JTextField();
	    datosCliente.add(txtNumTelef);
	    
	    labCorreo = new JLabel("Correo: ");
	    datosCliente.add(labCorreo);
	    
	    txtCorreo = new JTextField();
	    datosCliente.add(txtCorreo);
	    
		labDireccion = new JLabel("Direccion: ");
		datosCliente.add(labDireccion);
		
		txtDireccion = new JTextField();
		datosCliente.add(txtDireccion);
	}
	
	//Datos de factura
	/*public String darFechaFactura() {
		String fechFac = fechaFactura.getText();
		return fechFac;
	}*/
	
	public String darNumFactura() {
		String numFac = "12";//numeroFactura.getText();
		return numFac;
	}
	
	
	//Datos de cliente
	public String darCedula() {
		String ced = txtCedRUC.getText();
		return ced;
	}
	
	public JTextField darNombre() {
		return txtNombrePE;
	}
	
	public JTextField darTelefono() {
		return txtNumTelef;
	}
	
	public JTextField darCorreo() {
		return txtCorreo;
	}
	
	public JTextField darDireccion() {
		return txtDireccion;
	}
	
}
