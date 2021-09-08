package grupo4.espe.factura.historial;

import java.awt.BorderLayout;
import javax.swing.*;

import grupo4.espe.factura.principal.InterfazFacturaPrincipal;


public class InterfazHistorialFac extends JFrame{

	
//	Atributos de paneles ------------------------------
	private PanelInicio panelInicio;
	private PanelBusqueda panelBusqueda;
	private PanelBorrar panelBorrar;
	
	private InterfazFacturaPrincipal principal;
	
	//Atributos de utilizados para el desarrollo del codigo****
	
	
	//inicio metodo contructor *******************************************************************************
	public InterfazHistorialFac(InterfazFacturaPrincipal pPrincipal) {
		principal = pPrincipal;
		principal.setVisible(false);
		
		setTitle(" Historial Factura ");
    	setSize(700, 650);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setLayout(new BorderLayout());
		
    	//crea la clase principal 
   // 	interfazHistorialFac = new InterfazHistorialFac();
    	
    	//crea el panel de datos de la muestra 
    	panelInicio = new PanelInicio(this);
    	panelBusqueda= new PanelBusqueda(this);
    	panelBorrar=new PanelBorrar(this);

    	
    	//organiza el panel principal 
    	add(panelInicio, BorderLayout.NORTH);
    	add(panelBusqueda, BorderLayout.CENTER);
    	add(panelBorrar, BorderLayout.SOUTH);
  
		
	}
	//cierre metodo constructor **********************************************************************************
	
	
	//METODO MAIN **********************************************************************************************
	/*public static void main(String[] args) {
		
		try {
			InterfazHistorialFac historial = new InterfazHistorialFac();
			historial.setVisible(true);
	}catch( Exception e ){
			e.printStackTrace();
		}
	
	}
	//fin metodo main ********************************************************************************************
*/
	
	
	//metodo de la implementacion buscar factura --------------------------------------------------
//metodo y funcion de borrar ******************
	public void borrar() {
		
		
	}

//metodo de la funcion retroceder 
	public void retrocederInterfazP() {
		
		
	}

//metodo para buscar la factura 
	public void buscarFacturaH() {
		
		
	}

}
