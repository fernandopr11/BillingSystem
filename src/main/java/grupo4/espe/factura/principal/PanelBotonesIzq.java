package grupo4.espe.factura.principal;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import grupo4.espe.factura.historial.InterfazHistorialFac;
import grupo4.espe.factura.inventario.Inventario;

public class PanelBotonesIzq extends JPanel implements ActionListener{
	private InterfazFacturaPrincipal principal;
	//Constantes de botones panel izquierdo
	public final static String GENERAR_NUEVA_FACTURA = "Generar nueva factura";
	public final static String INVENTARIO = "Inventario";
	public final static String HISTORIAL = "Historial Facturas";
	public final static String SALIR = "Salir";
	
	private JButton generarNuevaFactura;
	private JButton inventario;
	private JButton historialFacturas;
	private JButton salir;
	public PanelBotonesIzq(InterfazFacturaPrincipal pPrincipal) {
		principal = pPrincipal;
		
		setLayout(new GridLayout(7,1));
		//-----------------------------------------------------------------------
		//Interruptores de prueba
		/*add( new JSwitchBox( "on", "off" ));
		SwitchButton ts = new SwitchButton();
		add(ts);*/
		//-----------------------------------------------------------------------
		generarNuevaFactura = new JButton(GENERAR_NUEVA_FACTURA);
		generarNuevaFactura.setBackground(Color.decode("#27FCE5"));
		generarNuevaFactura.addActionListener(this);
		add(generarNuevaFactura);
		//-----------------------------------------------------------------------
		add(new JLabel());
		//-----------------------------------------------------------------------
		inventario = new JButton(INVENTARIO);
		inventario.setBackground(Color.decode("#27FCE5"));
		inventario.addActionListener(this);
		add(inventario);
		//-----------------------------------------------------------------------
		add(new JLabel());
		//-----------------------------------------------------------------------
		historialFacturas = new JButton(HISTORIAL);
		historialFacturas.setBackground(Color.decode("#27FCE5"));
		historialFacturas.addActionListener(this);
		add(historialFacturas);
		//-----------------------------------------------------------------------
		add(new JLabel());
		//-----------------------------------------------------------------------
		salir = new JButton(SALIR);
		salir.setBackground(Color.decode("#FA757B"));
		salir.addActionListener(this);
		add(salir);
	}
	
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand( );

		if( comando.equals(INVENTARIO) )
		{
			Inventario frame = new Inventario(principal);
			frame.setVisible(true);
			
		}else if(comando.equals(GENERAR_NUEVA_FACTURA) ) {
			
			principal.generarNuevaFactura();
			
		}else if( comando.equals(HISTORIAL) )
		{
			InterfazHistorialFac frame2 = new InterfazHistorialFac(principal);
			frame2.setVisible(true);
			
		}else if(comando.equals(SALIR)) {
			System.exit(0);
			//Salir
		}

	}
}
