package presentacion;

import datos.*;
import dominio.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JComboBox;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Component;
import java.awt.ComponentOrientation;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JSeparator;

/**
 * @author Daniel Loro Durán
 */
public class VentanaLogin {

	public JFrame frmLogin;
	private JPanel panel;
	private JLabel lblLogo;
	private JLabel lblUsuario;
	private JTextField txtUsuario;
	private JLabel lblContrasena;
	private JPasswordField pwdfContrasena;
	private JButton btnEntrar;
	
	private final String password = "ipo1"; //$NON-NLS-1$
	private JComboBox cbIdioma;
	private JLabel lblIdioma;
	
	private DatosPrueba datos;
	private JLabel lblPulseAqui;
	private JLabel lblSiHaOlvidado;
	private JSeparator separator;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLogin window = new VentanaLogin();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		this.datos = new DatosPrueba();
		frmLogin.setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaLogin.class.getResource("/presentacion/login.png"))); //$NON-NLS-1$
		frmLogin.setResizable(false);
		frmLogin.setTitle(Messages.getString("VentanaLogin.frmLogin.title")); //$NON-NLS-1$
		frmLogin.setBounds(100, 100, 380, 220);
		frmLogin.setLocationRelativeTo(null);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		panel = new JPanel();
		panel.setBounds(0, 0, 374, 191);
		frmLogin.getContentPane().add(panel);
		panel.setLayout(null);
		
		lblLogo = new JLabel(""); //$NON-NLS-1$
		lblLogo.setIcon(new ImageIcon(VentanaLogin.class.getResource("/presentacion/login.png"))); //$NON-NLS-1$

		lblLogo.setBounds(10, 14, 128, 128);
		panel.add(lblLogo);
		
		lblUsuario = new JLabel(Messages.getString("VentanaLogin.lblUsuario.text")); //$NON-NLS-1$
		lblUsuario.setBounds(151, 44, 60, 14);
		panel.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.addActionListener(new TxtUsuarioActionListener());
		txtUsuario.setBounds(234, 41, 126, 20);
		txtUsuario.addFocusListener(new MiFocusListener());
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		lblContrasena = new JLabel(Messages.getString("VentanaLogin.lblContrasena.text")); //$NON-NLS-1$
		lblContrasena.setEnabled(false);
		lblContrasena.setBounds(151, 92, 83, 14);
		panel.add(lblContrasena);
		
		pwdfContrasena = new JPasswordField();
		pwdfContrasena.addActionListener(new PwdfContrasenaActionListener());
		pwdfContrasena.addFocusListener(new MiFocusListener());
		pwdfContrasena.setEnabled(false);
		pwdfContrasena.setBounds(234, 89, 126, 20);
		panel.add(pwdfContrasena);
		
		btnEntrar = new JButton(Messages.getString("VentanaLogin.btnEntrar.text")); //$NON-NLS-1$
		btnEntrar.addActionListener(new BtnEntrarActionListener());
		btnEntrar.setEnabled(false);
		btnEntrar.setBounds(271, 131, 89, 23);
		panel.add(btnEntrar);
		{
			cbIdioma = new JComboBox();
			cbIdioma.addActionListener(new CbIdiomaActionListener());
			cbIdioma.setModel(new DefaultComboBoxModel(new String[] {"Español", "English"})); //$NON-NLS-2$
			cbIdioma.setBounds(271, 11, 89, 20);
			panel.add(cbIdioma);
		}
		{
			lblIdioma = new JLabel(Messages.getString("VentanaLogin.lblIdioma.text")); //$NON-NLS-1$
			lblIdioma.setIcon(new ImageIcon(VentanaLogin.class.getResource("/presentacion/lenguaje.png"))); //$NON-NLS-1$
			lblIdioma.setBounds(190, 10, 77, 25);
			panel.add(lblIdioma);
		}
		{
			separator = new JSeparator();
			separator.setBounds(0, 160, 374, 3);
			panel.add(separator);
		}
		{
			lblPulseAqui = new JLabel(Messages.getString("VentanaLogin.lblPulseAqui.text")); //$NON-NLS-1$
			lblPulseAqui.setBounds(85, 165, 55, 14);
			panel.add(lblPulseAqui);
			lblPulseAqui.addMouseListener(new LblPulseAquiMouseListener());
			lblPulseAqui.setForeground(SystemColor.textHighlight);
		}
		{
			lblSiHaOlvidado = new JLabel(Messages.getString("VentanaLogin.lblSiHaOlvidado.text")); //$NON-NLS-1$
			lblSiHaOlvidado.setBounds(143, 165, 188, 14);
			panel.add(lblSiHaOlvidado);
		}
	}
	
	private class MiFocusListener extends FocusAdapter {
		public void focusGained(FocusEvent e) {
			e.getComponent().setBackground(new Color(250,250,210));
		}
		public void focusLost(FocusEvent e) {
			e.getComponent().setBackground(new Color(255,255,255));
		}
	}
	
	private class BtnEntrarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			Usuario usuario = null;
			boolean puedeEntrar = false;
			for(int i = 0;i<datos.usuarios.size();i++) {
			
				if(String.valueOf(pwdfContrasena.getPassword()).toString().equals(password) && datos.usuarios.get(i).getNombreUsuario().equals(txtUsuario.getText())) {
					puedeEntrar = true;
					usuario = datos.usuarios.get(i);
				}
			}
			
			if(puedeEntrar) {
				
				Calendar fecha = new GregorianCalendar();
				usuario.setUltimaConexion(fecha.getTime().toString());
				
				ImageIcon icon = new ImageIcon(VentanaLogin.class.getResource("/presentacion/tick.png")); //$NON-NLS-1$
				JOptionPane.showMessageDialog(frmLogin, Messages.getString("VentanaLogin.TextoDatosCorrectos"), Messages.getString("VentanaLogin.BtnDatosCorrectos"), JOptionPane.PLAIN_MESSAGE, icon); //$NON-NLS-1$ //$NON-NLS-2$
				new VentanaPrincipal(datos, usuario).frame.setVisible(true);
				frmLogin.dispose();
			}else {
				ImageIcon icon = new ImageIcon(VentanaLogin.class.getResource("/presentacion/equis.png")); //$NON-NLS-1$
				JOptionPane.showMessageDialog(frmLogin, Messages.getString("VentanaLogin.TextoDatosIncorrectos"), Messages.getString("VentanaLogin.BtnDatosIncorrectos"), JOptionPane.PLAIN_MESSAGE, icon); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}
	}
	
	private class TxtUsuarioActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			lblContrasena.setEnabled(true);
			pwdfContrasena.setEnabled(true);
			btnEntrar.setEnabled(true);
			pwdfContrasena.requestFocus();
		}
	}
	private class PwdfContrasenaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			btnEntrar.requestFocus();
		}
	}
	private class LblPulseAquiMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			
			JOptionPane.showMessageDialog(frmLogin, Messages.getString("VentanaLogin.TextoContraseñaOlvidada"), Messages.getString("VentanaLogin.TituloContraseñaOlvidada"), JOptionPane.INFORMATION_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
			
		}
	}
	private class CbIdiomaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			if(cbIdioma.getSelectedIndex()==0) {
				Messages.setIdioma("español"); //$NON-NLS-1$
			}
			if(cbIdioma.getSelectedIndex()==1) {
				Messages.setIdioma("inglés"); //$NON-NLS-1$
			}
			
			VentanaLogin ventanaLogin = new VentanaLogin();
			ventanaLogin.frmLogin.setLocationRelativeTo(null);
			ventanaLogin.frmLogin.setVisible(true);
			frmLogin.dispose();
		}
	}
}
