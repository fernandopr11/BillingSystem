package Interfaces;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class InterfazFacturaPrincipal extends JFrame{

	//Atributos --------------------------------------

	private PanelBotonesIzq panelBotonesIzq;
	private PanelEncabezado panelEncabezado;
	private PanelAgregaDatosFactura panelAgregaDatosFactura;
	private PanelListaProductosFactura panelListaProductosFactura;
	private PanelBotonesInfFactura panelBotonesInfFactura;

	public InterfazFacturaPrincipal() throws Exception {
		
		String tipFact = "";
		/*boolean estFact;
		estFact = panelBotonesIzq.getEstadoBoton();
		if(estFact == true) {
			tipFact = "Cliente empresa";
		}else {
			tipFact = "Cliente particular";
		}*/
		setTitle("Sistema de facturacion" + " (" + tipFact + ")");
		setSize(645,760);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(new BorderLayout());//Primer distribucion
		
		//Añade segunda distribucion a centro de distribucion 1
		JPanel west1 = new JPanel();
		west1.setLayout(new BorderLayout());
		add(west1, BorderLayout.WEST);
		
		panelBotonesIzq = new PanelBotonesIzq(this);
		add(panelBotonesIzq, BorderLayout.EAST);
		
		panelEncabezado = new PanelEncabezado(this);
		west1.add(panelEncabezado, BorderLayout.NORTH); //Añade panelEncabezado a centro de distribucion 2
		
		JPanel centro2 = new JPanel();
		centro2.setLayout(new BorderLayout());
		west1.add(centro2, BorderLayout.CENTER); //Añade distribucion 3 dentro de parte sur de distribucion 2
		
		panelAgregaDatosFactura = new PanelAgregaDatosFactura(this);
		centro2.add(panelAgregaDatosFactura, BorderLayout.NORTH);
		
		panelListaProductosFactura = new PanelListaProductosFactura();
		centro2.add(panelListaProductosFactura, BorderLayout.CENTER);
		
		panelBotonesInfFactura = new PanelBotonesInfFactura();
		centro2.add(panelBotonesInfFactura, BorderLayout.SOUTH);
		
		
	}


	public static void main(String[] args) {

		try {
			InterfazFacturaPrincipal ventanaPrincipal = new InterfazFacturaPrincipal();
		}catch(Exception e) {

			JOptionPane.showMessageDialog(null, e.getMessage(), "Sistema de facturacion", JOptionPane.ERROR_MESSAGE);
		}

	}

}
