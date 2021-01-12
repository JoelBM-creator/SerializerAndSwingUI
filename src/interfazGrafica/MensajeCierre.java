package interfazGrafica;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MensajeCierre extends JDialog{
	
	public MensajeCierre(String cierre) {
		
		setModal(true);
		
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblTexto = new JLabel(cierre);
		lblTexto.setHorizontalTextPosition(SwingConstants.CENTER);
		lblTexto.setBounds(58, 101, 333, 16);
		getContentPane().add(lblTexto);
		
		JButton btnCerrar = new JButton("OK");
		btnCerrar.addMouseListener(new BtnCerrarMouseListener());
		btnCerrar.setBounds(166, 181, 117, 29);
		getContentPane().add(btnCerrar);
		
		setTitle("CONFIRMACIÓN");
		setSize(450, 300);
		setVisible(true);
		
	}
	
	private static final long serialVersionUID = -5983786684577504257L;

	private class BtnCerrarMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			dispose();
		}
	}
}
