package grupo4.espe.factura.historial;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;


public class PanelBorrar extends JPanel  implements ActionListener {

	//atributos ***************************************************
	private InterfazHistorialFac historial; 
	
private JButton btnBorrarHistorial;
//el comando para el btoon borrar el historial
	private static final String BORRAR = "BORRAR";
//fin atributos ************************************************
	
	//Metodo Constructor /////////////////////////////////////////////
	public PanelBorrar(InterfazHistorialFac pHistorial) {
		
		historial = pHistorial;
		
		JPanel panelInformacion;
		
		setLayout(new BorderLayout());
		
	//	TitledBorder border = BorderFactory.createTitledBorder("Puntos de Extension ");
	//	border.setTitleColor(Color.BLUE);
	//	setBorder(border);
		//panel de de muestra
		panelInformacion =new JPanel();
		add(panelInformacion, BorderLayout.CENTER);
		//representar los botones
		
		
		btnBorrarHistorial= new JButton(" Borrar Historial ");
		btnBorrarHistorial.setActionCommand(BORRAR);

		
		//hacerlos visibles los botones
		panelInformacion.add(btnBorrarHistorial);
		
		//llamado al metodo addActionlistener sobre los botones
		//para indicar que en el panel es el indicado del 
		//evento cuando se genere cuando se presiona el boton 
		//note que this en este caso es el panel mismo
		btnBorrarHistorial.addActionListener(this);
	}
	//Fin metodo Constructor ///////////////////////////////////////////////
	
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if (comando.equals(BORRAR)) {
			// reacciona al metodo borrar 
		//	historial.borrar();

		}
		
	}

}
