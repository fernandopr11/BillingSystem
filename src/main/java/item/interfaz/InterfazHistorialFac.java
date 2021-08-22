package item.interfaz;

import java.awt.BorderLayout;
import javax.swing.*;


public class InterfazHistorialFac extends JFrame{

	private InterfazHistorialFac interfazHistorialFac;
//	Atributos de paneles ------------------------------
	private PanelInicio panelInicio;
	private PanelBusqueda panelBusqueda;
	private PanelBorrar panelBorrar;
	
	
	
	//Atributos de utilizados para el desarrollo del codigo****
	
	
	//inicio metodo contructor *******************************************************************************
	public InterfazHistorialFac() {
		
		setTitle(" Historial Factura ");
    	setSize(700, 650);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setLayout(new BorderLayout());
		
    	//crea la clase principal 
   // 	interfazHistorialFac = new InterfazHistorialFac();
    	
    	//crea el panel de datos de la muestra 
    	panelInicio = new PanelInicio();
    	panelBusqueda= new PanelBusqueda();
    	panelBorrar=new PanelBorrar();

    	
    	//organiza el panel principal 
    	add(panelInicio, BorderLayout.NORTH);
    	add(panelBusqueda, BorderLayout.CENTER);
    	add(panelBorrar, BorderLayout.SOUTH);
  
		
	}
	//cierre metodo constructor **********************************************************************************
	
	
	//METODO MAIN **********************************************************************************************
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			InterfazHistorialFac historial = new InterfazHistorialFac();
			historial.setVisible(true);
	}catch( Exception e ){
			e.printStackTrace();
		}
	
	}
	//fin metodo main ********************************************************************************************

	
	
	//metodo de la implementacion buscar factura --------------------------------------------------
//metodo y funcion de borrar ******************
	public void borrar() {
		// TODO Auto-generated method stub
		
	}

//metodo de la funcion retroceder 
	public void retrocederInterfazP() {
		// TODO Auto-generated method stub
		
	}

//metodo para buscar la factura 
	public void buscarFacturaH() {
		// TODO Auto-generated method stub
		
	}

}
