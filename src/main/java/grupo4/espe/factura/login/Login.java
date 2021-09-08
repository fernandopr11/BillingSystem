package grupo4.espe.factura.login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import grupo4.espe.factura.principal.InterfazFacturaPrincipal;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField_login;
	private JPasswordField passwordField;
	// ruta de imagenes
	private static final String Ruta_Imagen1 = "./ImagenesLogin/logoImgF.jpeg";
	private static final String Ruta_Imagen2 = "./ImagenesLogin/logoEspe.jpg";
	private static final String Ruta_Imagen3 = "./ImagenesLogin/LogoItin.jpg";
	private static final String Ruta_Imagen4 = "./ImagenesLogin/Usuario.png";
	private static final String Ruta_Imagen5 = "./ImagenesLogin/candadoL.png";
	private static final String Ruta_Imagen6 = "./ImagenesLogin/salirLogin.jpg";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(154, 205, 50));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Inicio Secci\u00F3n");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(155, 11, 139, 30);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Ruta_Imagen1));
		lblNewLabel_1.setBounds(186, 41, 70, 70);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Ruta_Imagen2));
		lblNewLabel_2.setBounds(10, 11, 119, 44);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Ruta_Imagen3));
		lblNewLabel_3.setBounds(323, 11, 87, 44);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Sistema de Facturaci\u00F3n");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_4.setBounds(129, 110, 215, 30);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(Ruta_Imagen4));
		lblNewLabel_5.setBounds(79, 134, 40, 44);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(Ruta_Imagen5));
		lblNewLabel_6.setBounds(79, 179, 40, 47);
		contentPane.add(lblNewLabel_6);

		textField_login = new JTextField();
		textField_login.setBounds(128, 142, 200, 30);
		contentPane.add(textField_login);
		textField_login.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(129, 193, 199, 30);
		contentPane.add(passwordField);

		JButton btn_Ingresar = new JButton("Ingresar");
		btn_Ingresar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_Ingresar.setBounds(155, 234, 139, 23);
		contentPane.add(btn_Ingresar);
		btn_Ingresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// accion login
				String usuario = textField_login.getText();
				String passwd = passwordField.getText();

				// contrase�a *********
				usuario = "Admin";
				passwd = "Admin";
				// fin contrase�a **************

				if (usuario.equals(textField_login.getText()) && passwd.equals(passwordField.getText())) {
					JOptionPane.showMessageDialog(null, "Bienvenido al Sistema Facturacion");
					// cambio de la interfaz
					InterfazFacturaPrincipal cambioInterfaz;
					try {
						cambioInterfaz = new InterfazFacturaPrincipal();
						cambioInterfaz.setVisible(true);
						setVisible(false);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				} else if (textField_login.getText().equals("") && passwordField.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							"Usuario y/o Contrase�a estan vacios\nIngrese los por favor.:(");
					textField_login.setFocusable(true);
				} else if (textField_login.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Usuario est� vacio\nIngrese lo por favor :(.");
					textField_login.setFocusable(true);
				} else if (passwordField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Contrase�a est� vacio\nIngrese lo por favor.:(");
					passwordField.setFocusable(true);
				} else if (textField_login.getText().compareTo(usuario) != 0
						&& passwordField.getText().compareTo(passwd) != 0) {
					JOptionPane.showMessageDialog(null, "Usuario y/o Contrase�a no v�lidos\nIngrese nuevamente.:(");
					textField_login.setFocusable(true);
				} else if (textField_login.getText().compareTo(usuario) != 0) {
					JOptionPane.showMessageDialog(null, "Usuario no v�lido\nIngrese nuevamente.:(");
					textField_login.setFocusable(true);
				} else if (passwordField.getText().compareTo(passwd) != 0) {
					JOptionPane.showMessageDialog(null, "Contrase�a no v�lida\nIngrese nuevamente.:(");
					passwordField.setFocusable(true);
				}

			}
		});

		JButton btn_Salir = new JButton("");
		btn_Salir.setIcon(new ImageIcon(Ruta_Imagen6));
		btn_Salir.setBounds(384, 212, 40, 38);
		contentPane.add(btn_Salir);
		btn_Salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// codigo para salir de principal
				System.exit(0);
			}
		});
	}

}
