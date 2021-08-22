package Interfaces;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class PanelBotonesIzq extends JPanel implements ActionListener{
	private InterfazFacturaPrincipal principal;

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
		inventario = new JButton("Inventario");
		inventario.addActionListener(this);
		add(inventario);
		//-----------------------------------------------------------------------
		add(new JLabel());
		//-----------------------------------------------------------------------
		historialFacturas = new JButton("Historial Facturas");
		historialFacturas.addActionListener(this);
		add(historialFacturas);
		//-----------------------------------------------------------------------
		add(new JLabel());
		//-----------------------------------------------------------------------
		salir = new JButton("Salir");
		salir.addActionListener(this);
		add(salir);
	}
	public boolean getEstadoBoton() {
		return estadoBoton;
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
