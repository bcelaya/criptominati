package ventana;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DialogoConfirm extends JPanel {
	private JTextField mostrarinfo;

	/**
	 * Create the panel.
	 */
	public DialogoConfirm() {
		setLayout(null);
		
		JButton btnOk = new JButton("OK");
		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		btnOk.setBounds(12, 125, 117, 25);
		add(btnOk);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnCancelar.setBounds(206, 125, 117, 25);
		add(btnCancelar);
		
		mostrarinfo = new JTextField();
		mostrarinfo.setEditable(false);
		mostrarinfo.setBounds(12, 52, 311, 44);
		add(mostrarinfo);
		mostrarinfo.setColumns(10);

	}
}
