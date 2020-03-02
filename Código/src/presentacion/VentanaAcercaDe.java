package presentacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author Daniel Loro Durán
 */
public class VentanaAcercaDe extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	private boolean abierta = false;
	private JLabel lblInteraccinPersonaordenadorI;

	/**
	 * Create the dialog.
	 */
	public VentanaAcercaDe() {
		addWindowListener(new ThisWindowListener());
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaAcercaDe.class.getResource("/presentacion/autor.png")));
		setModal(false);
		this.abierta = true;
		setTitle(Messages.getString("VentanaAcercaDe.this.title")); //$NON-NLS-1$
		setResizable(false);
		setBounds(100, 100, 371, 196);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNombrePrograma = new JLabel(Messages.getString("VentanaAcercaDe.lblNombrePrograma.text")); //$NON-NLS-1$
			lblNombrePrograma.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblNombrePrograma.setBounds(74, 26, 225, 21);
			contentPanel.add(lblNombrePrograma);
		}
		{
			JLabel lblAutor = new JLabel(Messages.getString("VentanaAcercaDe.lblAutor.text")); //$NON-NLS-1$
			lblAutor.setHorizontalAlignment(SwingConstants.CENTER);
			lblAutor.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblAutor.setBounds(74, 59, 225, 14);
			contentPanel.add(lblAutor);
		}
		{
			JLabel lblAplicacionPara = new JLabel(Messages.getString("VentanaAcercaDe.lblAplicacionPara.text")); //$NON-NLS-1$
			lblAplicacionPara.setHorizontalAlignment(SwingConstants.CENTER);
			lblAplicacionPara.setBounds(10, 94, 342, 14);
			contentPanel.add(lblAplicacionPara);
		}
		{
			lblInteraccinPersonaordenadorI = new JLabel(Messages.getString("VentanaAcercaDe.lblInteraccinPersonaordenadorI.text")); //$NON-NLS-1$
			lblInteraccinPersonaordenadorI.setHorizontalAlignment(SwingConstants.CENTER);
			lblInteraccinPersonaordenadorI.setBounds(82, 110, 203, 14);
			contentPanel.add(lblInteraccinPersonaordenadorI);
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new BorderLayout(0, 0));
			{
				JButton btnCerrar = new JButton(Messages.getString("VentanaAcercaDe.btnCerrar.text")); //$NON-NLS-1$
				btnCerrar.addActionListener(new BtnCerrarActionListener());
				btnCerrar.setActionCommand(Messages.getString("VentanaAcercaDe.btnCerrar.actionCommand")); //$NON-NLS-1$
				buttonPane.add(btnCerrar);
				getRootPane().setDefaultButton(btnCerrar);
			}
		}
	}
	
	
	
	public boolean getEstado() {
		return this.abierta;
	}

	private class ThisWindowListener extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent e) {
			abierta = false;
		}
	}
	private class BtnCerrarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			abierta = false;
			dispose();
		}
	}
}
