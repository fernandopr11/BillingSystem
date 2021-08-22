package item.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class PanelInicio extends JPanel implements ActionListener {

	//atributo de la clase**********************
	private InterfazHistorialFac historial;

	/*
	 * JLabel para mostar el logo de la empresa
	 */
   private JLabel labLogoEmpresaH;
   private JLabel labTituloFac;
   private JButton btnRetroceder;
  // ***************************************************
   //atributos de la imagnes /////////////////////////////////////////
	private static final String RUTA_IMAGEN = "./dataImg/logoImg.jpeg";
	private static final String RETROCEDER = "./dataImg/retroceder.png";
	
	
	//atributos de buscar ***********************************
	private JButton btnBuscar;
	private JTextField txtbuscar;
	private final static String BUSCAR_FACTURA = "BUSCAR FACTURA ";
	
	//Metodo constructor ///////////////////////////////////////////////////////
	public PanelInicio() {
		JPanel panelMuestraDatos;
		
		panelMuestraDatos =new JPanel();
		add(panelMuestraDatos, BorderLayout.CENTER);
		
		// Caracteristicas del panel
			setLayout(new FlowLayout());
				TitledBorder border = BorderFactory.createTitledBorder("Panel Inicio");
				border.setTitleColor(Color.blue);
				setBorder(border);
			
				// Se crean las etiquetas para el logo y el nombre de la empresa
		labLogoEmpresaH = new JLabel();
		labLogoEmpresaH.setIcon(new ImageIcon(RUTA_IMAGEN));
		labLogoEmpresaH.setFont(new Font("Noto", Font.PLAIN, 10));
		//variable del titulo 
		labTituloFac = new JLabel("      Historial Facturas      ");
		labTituloFac.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 20));
	//	labTituloFac.setHorizontalAlignment(SwingConstants.CENTER);
		
		// Se crean el boton para ir a la factura
		btnRetroceder = new JButton();
		btnRetroceder.setIcon(new ImageIcon(RETROCEDER));
	//	btnRetroceder.setActionCommand(RETROCEDER);
		btnRetroceder.setBackground(Color.decode("#ffffff"));
		btnRetroceder.setFont(new Font("Noto", Font.PLAIN, 5));
		btnRetroceder.setForeground(Color.WHITE);
		
		//boton para buscar
		btnBuscar= new JButton("Buscar # Factura ");
		txtbuscar = new JTextField(15);
		//txtbuscar.setEditable(true);
		txtbuscar.setBackground(Color.WHITE);
		txtbuscar.setEditable(true);
		
			
				
				// paneles
				panelMuestraDatos.setLayout(new GridLayout(2,3));
				// Se agregan los elementos al panel
				panelMuestraDatos.add(labLogoEmpresaH);
				panelMuestraDatos.add(labTituloFac);
				panelMuestraDatos.add(btnRetroceder);
				panelMuestraDatos.add(btnBuscar);
				panelMuestraDatos.add(txtbuscar);
				panelMuestraDatos.add (new JLabel (""));
		
	}
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if (comando.equals(RETROCEDER)) {
			// reacciona al metodo borrar 
		//	historial.retrocederInterfazP();
		}else if(comando.equals(BUSCAR_FACTURA)) {
			//historial.buscarFacturaH();
		}

	}
}


