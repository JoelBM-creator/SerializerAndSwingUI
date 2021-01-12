package login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Login extends JFrame {

	private static final long serialVersionUID = 3905161392233251698L;

	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel lblDatosIncorrectos;

	public Login() {
		setResizable(false);
		setTitle("Login");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setBounds(180, 34, 46, 14);
		getContentPane().add(lblLogin);

		JLabel lblNombreUsuario = new JLabel("Nombre usuario:");
		lblNombreUsuario.setBounds(100, 83, 100, 14);
		getContentPane().add(lblNombreUsuario);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(100, 117, 89, 14);
		getContentPane().add(lblContrasea);

		textField = new JTextField();
		textField.setBounds(199, 80, 139, 20);
		getContentPane().add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(199, 114, 139, 20);
		getContentPane().add(passwordField);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new BtnAceptarActionListener());
		btnAceptar.setBounds(160, 193, 89, 23);
		getContentPane().add(btnAceptar);

		lblDatosIncorrectos = new JLabel("DATOS INCORRECTOS");
		lblDatosIncorrectos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDatosIncorrectos.setForeground(Color.RED);
		lblDatosIncorrectos.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosIncorrectos.setBounds(138, 158, 196, 14);
		lblDatosIncorrectos.setVisible(false);
		getContentPane().add(lblDatosIncorrectos);

		setSize(450, 300);
		setVisible(true);
	}

	private class BtnAceptarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			String nombre = textField.getText();
			String password = new String(passwordField.getPassword());
			boolean loginCorrecto = false;
			if (nombre.length() == 0 || password.length() == 0) {
				lblDatosIncorrectos.setText("DEBES INTRODUCIR LOS DATOS");
				lblDatosIncorrectos.setVisible(true);
			} else {
				try {
					loginCorrecto = comprobarLogin(nombre, password);
					if (loginCorrecto) {
						lblDatosIncorrectos.setVisible(false);
						dispose();
						new Bienvenida(nombre);
					} else {
						lblDatosIncorrectos.setText("CREDENCIALES INCORRECTAS");
						lblDatosIncorrectos.setVisible(true);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		@SuppressWarnings("resource")
		private boolean comprobarLogin(String nombre, String password) throws Exception {
			FileReader fr = new FileReader("datos.txt");
			BufferedReader br = new BufferedReader(fr);
			String s;
			while ((s = br.readLine()) != null) {
				if (s.equals(nombre + " " + password)) {
					fr.close();
					return true;
				}
			}
			fr.close();
			return false;
		}
	}
}
