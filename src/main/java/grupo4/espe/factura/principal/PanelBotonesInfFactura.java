package grupo4.espe.factura.principal;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.mongodb.DB;
import com.mongodb.DBCollection;

import grupo4.espe.factura.mongodb.ConexionMongoTecnoSmart;
import grupo4.espe.factura.proyectoMundo.Cliente;
import grupo4.espe.factura.proyectoMundo.Factura;
import grupo4.espe.factura.proyectoMundo.Producto;
import grupo4.espe.factura.proyectoMundo.TiendaTecnoSmart;

public class PanelBotonesInfFactura extends JPanel implements ActionListener{
	
	private final static String GENERAR_FACTURA = "Generar Factura";
	
	private PanelEncabezado datos;
	
	private JButton resetDatos;
	private JButton borrarDato;
	private JButton generarFactura;
	
	//private PanelEncabezado datos;
	
	private TiendaTecnoSmart pTienda;

	public PanelBotonesInfFactura() {
		datos = new PanelEncabezado();
		setLayout(new GridLayout(1, 3));
	
		resetDatos = new JButton("Resetear datos");
		resetDatos.setBackground(Color.decode("#6CC3E3"));
		add(resetDatos);
		
		borrarDato = new JButton("Borrar dato");
		borrarDato.setBackground(Color.decode("#6CC3E3"));
		add(borrarDato);
		
		generarFactura = new JButton(GENERAR_FACTURA);
		generarFactura.setBackground(Color.decode("#49FF33"));
		generarFactura.addActionListener(this);
		add(generarFactura);
	}

	public void actionPerformed(ActionEvent e) {
		

		String comando = e.getActionCommand();

		if (comando.equals(GENERAR_FACTURA)) {

			
			//String fechaDeFactura = datos.darFechaFactura();
			String numeroDeFacturaString = datos.darNumFactura();
			String cedula = datos.darCedula();
			String nombreCliente = datos.darNombre().toString().trim();
			String telefono = datos.darTelefono().toString().trim();
			String correo = datos.darCorreo().toString().trim();
			String direccion = datos.darDireccion().toString().trim();
			
			Factura factura = new Factura( numeroDeFacturaString, 
					cedula, nombreCliente, telefono, correo, direccion);
			
			 ArrayList<Factura> facturas = new ArrayList<>();
			 
			 facturas.add(factura);
			 
			ConexionMongoTecnoSmart mongo = new ConexionMongoTecnoSmart();

			try {
				DB db = mongo.conectarMongoDB();
				DBCollection coleccion =  (DBCollection) db.getCollection("Facturas");
				for(Factura fac: facturas) {
					
					coleccion.insert(fac.toDBObjectFactura());
					
				}
			} catch (UnknownHostException e1) {
				
				e1.printStackTrace();
			}
			
			
		}
		
	}
}
