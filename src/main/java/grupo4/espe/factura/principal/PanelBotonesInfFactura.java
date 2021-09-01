package grupo4.espe.factura.principal;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelBotonesInfFactura extends JPanel implements ActionListener{
	
	private JButton resetDatos;
	private JButton borrarDato;
	private JButton generarFactura;

	public PanelBotonesInfFactura() {
		setLayout(new GridLayout(1, 3));
	
		resetDatos = new JButton("Resetear datos");
		add(resetDatos);
		
		borrarDato = new JButton("Borrar dato");
		add(borrarDato);
		
		generarFactura = new JButton("Generar Factura");
		add(generarFactura);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
