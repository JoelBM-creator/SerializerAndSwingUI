package interfazGrafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Principal extends JFrame {
	private JTextField nombre;
	private JTextField apellido;
	private JComboBox<Object> comboBox;
	private JRadioButton rdbtnHombre;
	private JRadioButton rdbtnMujer;
	private ButtonGroup bG;
	private JCheckBox chckbxProgramar;
	private JCheckBox chckbxDeporte;
	private JCheckBox chckbxCine;
	
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(80, 32, 70, 14);
		getContentPane().add(lblNombre);
		
		nombre = new JTextField();
		nombre.setBounds(160, 29, 179,20);
		getContentPane().add(nombre);
		nombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(80, 70, 70, 14);
		getContentPane().add(lblApellido);
		
		apellido = new JTextField();
		apellido.setBounds(160, 67, 179, 20);
		getContentPane().add(apellido);
		apellido.setColumns(10);
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(80, 113, 46, 14);
		getContentPane().add(lblEdad);
		
		comboBox = new JComboBox<Object>();
		comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"Seleccionar rango de edad", "10-15", "16-20", "21-25", "26-30"}));
		comboBox.setBounds(160, 110, 179, 20);
		getContentPane().add(comboBox);
		
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(80, 148, 46, 14);
		getContentPane().add(lblSexo); 
		
		rdbtnHombre = new JRadioButton("Hombre");
		rdbtnHombre.setBounds(160, 144, 85, 23);
		getContentPane().add(rdbtnHombre);
		
		rdbtnMujer = new JRadioButton("Mujer");
		rdbtnMujer.setBounds(275, 144, 64, 23);
		getContentPane().add(rdbtnMujer);
		
		bG = new ButtonGroup();
	    bG.add(rdbtnHombre);
	    bG.add(rdbtnMujer);
		
		JLabel lblAficiones = new JLabel("Aficiones:");
		lblAficiones.setBounds(80, 185, 59, 14);
		getContentPane().add(lblAficiones);
		
		chckbxProgramar = new JCheckBox("Programar");
		chckbxProgramar.setBounds(154, 181, 91, 23);
		getContentPane().add(chckbxProgramar);
		
		chckbxDeporte = new JCheckBox("Deporte");
		chckbxDeporte.setBounds(245, 181, 82, 23);
		getContentPane().add(chckbxDeporte);
		
		chckbxCine = new JCheckBox("Cine");
		chckbxCine.setBounds(324, 181, 59, 23);
		getContentPane().add(chckbxCine);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new BtnAceptarActionListener());
		btnAceptar.setBounds(176, 227, 89, 23);
		getContentPane().add(btnAceptar);
	}
	
	private static final long serialVersionUID = 7238084310151011694L;

	@SuppressWarnings("unused")
	private class BtnAceptarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(nombre.getText().isEmpty()) {
				MensajeError error = new MensajeError("Introduzca un nombre");
			} else if(apellido.getText().isEmpty()) {
				MensajeError error = new MensajeError("Introduzca un apellido");
			} else if(comboBox.getSelectedItem().toString().length()==0) {
				MensajeError error = new MensajeError("Seleccione un rango de edad");
			} else if(bG.getSelection() == null) {
				MensajeError error = new MensajeError("Seleccione un sexo");
			} else if(!chckbxProgramar.isSelected() && !chckbxDeporte.isSelected() && !chckbxCine.isSelected()) {
				MensajeError error = new MensajeError("Marque al menos una opción de afición.");
			} else {
				MensajeCierre mensaje = new MensajeCierre("Se ha almacenado correctamente en la DB: " + nombre.getText() + " " + apellido.getText());
			}
		}
	}
}
