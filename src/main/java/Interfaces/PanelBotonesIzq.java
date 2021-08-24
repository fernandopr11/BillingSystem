package Interfaces;

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

import grupo4.espe.factura.interfaz.InterfazProductos;
import item.interfaz.InterfazHistorialFac;

public class PanelBotonesIzq extends JPanel implements ActionListener{
	private InterfazFacturaPrincipal principal;

	public final static String INVENTARIO = "Inventario";
	public final static String HISTORIAL = "Historial Facturas";
	
	public final static String SALIR = "Salir";
	
	
	private boolean estadoBoton;
	private JToggleButton clientePE;
	private JButton generarNuevaFactura;
	private JButton inventario;
	private JButton historialFacturas;
	private JButton salir;
	public PanelBotonesIzq(InterfazFacturaPrincipal pPrincipal) {
		principal = pPrincipal;
		
		setLayout(new GridLayout(9,1));
		
		//-----------------------------------------------------------------------
		//Interruptores de prueba
		/*add( new JSwitchBox( "on", "off" ));
		SwitchButton ts = new SwitchButton();
		add(ts);*/
		//-----------------------------------------------------------------------
		clientePE = new JToggleButton("Cliente empresa");
		add(clientePE);

		clientePE.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent itemEvent) {
				int estado = itemEvent.getStateChange();
				if(estado == ItemEvent.SELECTED){
					clientePE.setText("Cliente particular");
					estadoBoton = true;
				} else {
					clientePE.setText("Cliente empresa");
					estadoBoton = false;
				}
			}
		});
		//-----------------------------------------------------------------------
		add(new JLabel());
		//-----------------------------------------------------------------------
		generarNuevaFactura = new JButton("Generar nueva factura");
		generarNuevaFactura.addActionListener(this);
		add(generarNuevaFactura);
		//-----------------------------------------------------------------------
		add(new JLabel());
		//-----------------------------------------------------------------------
		inventario = new JButton(INVENTARIO);
		inventario.addActionListener(this);
		add(inventario);
		//-----------------------------------------------------------------------
		add(new JLabel());
		//-----------------------------------------------------------------------
		historialFacturas = new JButton(HISTORIAL);
		historialFacturas.addActionListener(this);
		add(historialFacturas);
		//-----------------------------------------------------------------------
		add(new JLabel());
		//-----------------------------------------------------------------------
		salir = new JButton(SALIR);
		salir.addActionListener(this);
		add(salir);
	}
	public boolean getEstadoBoton() {
		return estadoBoton;
	}
	public void actionPerformed(ActionEvent e) {

		String comando = e.getActionCommand( );

		if( comando.equals(INVENTARIO) )
		{
			InterfazProductos frame = new InterfazProductos(principal);
			frame.setVisible(true);
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
