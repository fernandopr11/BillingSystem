package grupo4.espe.factura.principal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class PanelEncabezado extends JPanel{
	private InterfazFacturaPrincipal principal;
	
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
	
	public PanelEncabezado(InterfazFacturaPrincipal pPrincipal) {
		principal = pPrincipal;
		
		setLayout(new BorderLayout());
		//Logo WEST
		logo = new JPanel();
		logo.setLayout(new GridLayout(1,1));
		add(logo, BorderLayout.WEST);
		
		JLabel fotoLogo = new JLabel("Logo aqui");
		logo.add(fotoLogo);
		
		//Fecha y nunero de factura EAST
		fechFac = new JPanel();
		fechFac.setLayout(new GridLayout(2,2));
		add(fechFac, BorderLayout.EAST);
		
		TitledBorder border = new TitledBorder("");
	    border.setTitleColor(Color.BLACK);
	    fechFac.setBorder(border);
	    
	    fechFac.add(new JLabel("Fecha"));
	    fechFac.add(new JLabel("_ _ _ _ _ _ _ _ _ _ _ _ _"));
	    fechFac.add(new JLabel("Nº Factura"));
	    fechFac.add(new JLabel("_ _ _ _ _ _ _ _ _ _ _ _ _"));
		//Datos Cliente
	    datosCliente = new JPanel();
	    datosCliente.setLayout(new GridLayout(5,2));
	    add(datosCliente, BorderLayout.SOUTH);
	    
	    //TitledBorder borTitulo = new TitledBorder("Datos de cliente");
	    LineBorder lineaBorde = new LineBorder(Color.BLACK);
	    TitledBorder borDatos = new TitledBorder(lineaBorde, " Datos de cliente ");
	    datosCliente.setBorder(borDatos);
	    
	    labCedRUC = new JLabel("Cedula/RUC (Configurar)");
	    datosCliente.add(labCedRUC);
	    
	    txtCedRUC = new JTextField();
	    datosCliente.add(txtCedRUC);
	    
	    labNombrePE = new JLabel("Nomnbre / Nombre empresa: ");
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
}
