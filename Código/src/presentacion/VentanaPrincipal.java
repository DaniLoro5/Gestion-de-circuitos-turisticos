package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import java.awt.Dialog;

import java.awt.FlowLayout;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import dominio.*;
import datos.*;
import java.awt.Rectangle;
import java.awt.Window;
import java.awt.Dimension;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.Toolkit;
import java.awt.Font;

/**
 * @author Daniel Loro Durán
 */
public class VentanaPrincipal {

	public JFrame frame;
	private JPanel panel;
	private JPanel pnlInfoUsuario;
	private JLabel lblUsuario;
	private JLabel lblUlltimaConexion;
	private JButton btnCerrarSesion;
	private JMenuBar menuBar;
	private JMenu mnTema;
	private JMenu mnAyuda;
	private JTabbedPane tabbedPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPanel panelHistorialRutas;
	private JPanel panelRutasPredefinidas;
	private JPanel panelAccesoGestiones;
	private JButton btnGestionGuias;
	private JButton btnGestionTuristas;
	private JButton btnPromociones;
	private JMenuItem mntmAyuda;
	private JMenuItem mntmAcercaDe;
	private JScrollPane spRutas;
	private JList listRutas;
	private JLabel lblRutas;
	private JLabel lblEstado;
	private JTextField txtEstado;
	private JLabel lblNPersonasQue;
	private JTextField txtNumPersonas;
	private JLabel lblCoste;
	private JTextField txtCoste;
	private JLabel lblOpiniones;
	private JTextArea txtOpiniones;
	private JLabel lblIncidencias;
	private JTextArea txtIncidencias;
	private JLabel lblSugerencias;
	private JTextArea txtSugerencias;
	private JMenu mnEdicion;
	private DatosPrueba datos;
	private Usuario usuario;
	private ImageIcon foto;
	private JScrollPane spFotoUsuario;
	private JLabel lblFoto;
	private JScrollPane spSugerencias;
	private JScrollPane spIncidencias;
	private JScrollPane spOpiniones;
	private JRadioButton rbClaro;
	private JRadioButton rbOscuro;
	
	DefaultListModel modeloRutas;
	
	VentanaAyuda ventanaayuda;
	VentanaPromociones ventanapromo;
	VentanaGuias ventanaguias;
	VentanaAcercaDe ventanaacercade;
	VentanaTuristas ventanaturistas;


	/**
	 * Create the application.
	 */
	public VentanaPrincipal(DatosPrueba datos, Usuario usuario) {
		this.datos = datos;
		this.usuario = usuario;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/presentacion/principal.png"))); //$NON-NLS-1$
		frame.setResizable(false);
		frame.setBounds(100, 100, 715, 615);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		{
			panel = new JPanel();
			panel.setBounds(new Rectangle(0, 0, 0, 400));
			frame.getContentPane().add(panel, BorderLayout.NORTH);
			panel.setLayout(new BorderLayout(0, 0));
			{
				pnlInfoUsuario = new JPanel();
				panel.add(pnlInfoUsuario, BorderLayout.CENTER);
				pnlInfoUsuario.setLayout(new BorderLayout(0, 0));
				{
					lblUsuario = new JLabel(Messages.getString("VentanaPrincipal.TextoUsuario")+usuario.getNombreUsuario()); //$NON-NLS-1$
					pnlInfoUsuario.add(lblUsuario, BorderLayout.NORTH);
				}
				{
					lblUlltimaConexion = new JLabel(Messages.getString("VentanaPrincipal.TextoUltimaConexion")+usuario.getUltimaConexion()); //$NON-NLS-1$
					pnlInfoUsuario.add(lblUlltimaConexion, BorderLayout.CENTER);
				}
			}
			{
				btnCerrarSesion = new JButton(Messages.getString("VentanaPrincipal.btnCerrarSesion.text")); //$NON-NLS-1$
				btnCerrarSesion.addActionListener(new BtnCerrarSesionActionListener());
				btnCerrarSesion.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/presentacion/icons8-shutdown-64.png"))); //$NON-NLS-1$
				panel.add(btnCerrarSesion, BorderLayout.EAST);
			}
			{
				spFotoUsuario = new JScrollPane();
				panel.add(spFotoUsuario, BorderLayout.WEST);
				
				{
					lblFoto = new JLabel();
					lblFoto.setPreferredSize(new Dimension(50, 50));
					spFotoUsuario.setViewportView(lblFoto);
					
					if(usuario.getFoto()=="" || usuario.getFoto()==null) { //$NON-NLS-1$
						foto = new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/personagenerica.png")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)); //$NON-NLS-1$
					}else {
						foto = new ImageIcon(new ImageIcon(getClass().getResource(usuario.getFoto())).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
					}
					
					lblFoto.setIcon(foto);
					
				}
			}
		}
		{
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
			{
				panelHistorialRutas = new JPanel();
				tabbedPane.addTab(Messages.getString("VentanaPrincipal.TituloHistorialRutas"), new ImageIcon(VentanaPrincipal.class.getResource("/presentacion/historial.png")), panelHistorialRutas, null); //$NON-NLS-1$ //$NON-NLS-2$
				panelHistorialRutas.setLayout(null);
				{
					spRutas = new JScrollPane();
					spRutas.setBounds(10, 11, 117, 458);
					panelHistorialRutas.add(spRutas);
					{
						listRutas = new JList();
						listRutas.addListSelectionListener(new ListRutasListSelectionListener());
						modeloRutas = new DefaultListModel<Ruta>();
						
						for(int i = 0; i < datos.rutas.size();i++) {
							modeloRutas.addElement((Ruta)datos.rutas.get(i));
						}
						
						listRutas.setModel(modeloRutas);
						spRutas.setViewportView(listRutas);
					}
					{
						lblRutas = new JLabel(Messages.getString("VentanaPrincipal.lblRutas.text")); //$NON-NLS-1$
						lblRutas.setHorizontalAlignment(SwingConstants.CENTER);
						spRutas.setColumnHeaderView(lblRutas);
					}
				}
				{
					lblEstado = new JLabel(Messages.getString("VentanaPrincipal.lblEstado.text")); //$NON-NLS-1$
					lblEstado.setBounds(154, 12, 84, 14);
					panelHistorialRutas.add(lblEstado);
				}
				{
					lblNPersonasQue = new JLabel(Messages.getString("VentanaPrincipal.lblNPersonasQue.text")); //$NON-NLS-1$
					lblNPersonasQue.setBounds(386, 12, 170, 14);
					panelHistorialRutas.add(lblNPersonasQue);
				}
				{
					txtEstado = new JTextField();
					txtEstado.setEditable(false);
					txtEstado.setBounds(154, 30, 171, 20);
					panelHistorialRutas.add(txtEstado);
					txtEstado.setColumns(10);
				}
				{
					txtNumPersonas = new JTextField();
					txtNumPersonas.setEditable(false);
					txtNumPersonas.setBounds(386, 30, 170, 20);
					panelHistorialRutas.add(txtNumPersonas);
					txtNumPersonas.setColumns(10);
				}
				{
					lblCoste = new JLabel(Messages.getString("VentanaPrincipal.lblCoste.text")); //$NON-NLS-1$
					lblCoste.setBounds(154, 62, 84, 14);
					panelHistorialRutas.add(lblCoste);
				}
				{
					txtCoste = new JTextField();
					txtCoste.setEditable(false);
					txtCoste.setBounds(154, 78, 171, 20);
					panelHistorialRutas.add(txtCoste);
					txtCoste.setColumns(10);
				}
				{
					lblOpiniones = new JLabel(Messages.getString("VentanaPrincipal.lblOpiniones.text")); //$NON-NLS-1$
					lblOpiniones.setBounds(154, 129, 171, 14);
					panelHistorialRutas.add(lblOpiniones);
				}
				{
					spOpiniones = new JScrollPane();
					spOpiniones.setBounds(154, 153, 540, 128);
					panelHistorialRutas.add(spOpiniones);
					{
						txtOpiniones = new JTextArea();
						txtOpiniones.setFont(new Font("Tahoma", Font.PLAIN, 11));
						spOpiniones.setViewportView(txtOpiniones);
						txtOpiniones.setLineWrap(true);
						txtOpiniones.setWrapStyleWord(true);
						txtOpiniones.setEditable(false);
					}
				}
				{
					lblIncidencias = new JLabel(Messages.getString("VentanaPrincipal.lblIncidencias.text")); //$NON-NLS-1$
					lblIncidencias.setBounds(154, 292, 135, 14);
					panelHistorialRutas.add(lblIncidencias);
				}
				{
					spIncidencias = new JScrollPane();
					spIncidencias.setBounds(154, 311, 255, 157);
					panelHistorialRutas.add(spIncidencias);
					{
						txtIncidencias = new JTextArea();
						txtIncidencias.setFont(new Font("Tahoma", Font.PLAIN, 11));
						spIncidencias.setViewportView(txtIncidencias);
						txtIncidencias.setWrapStyleWord(true);
						txtIncidencias.setLineWrap(true);
						txtIncidencias.setEditable(false);
					}
				}
				{
					lblSugerencias = new JLabel(Messages.getString("VentanaPrincipal.lblSugerencias.text")); //$NON-NLS-1$
					lblSugerencias.setBounds(439, 292, 117, 14);
					panelHistorialRutas.add(lblSugerencias);
				}
				{
					spSugerencias = new JScrollPane();
					spSugerencias.setBounds(439, 311, 255, 157);
					panelHistorialRutas.add(spSugerencias);
					{
						txtSugerencias = new JTextArea();
						txtSugerencias.setFont(new Font("Tahoma", Font.PLAIN, 11));
						spSugerencias.setViewportView(txtSugerencias);
						txtSugerencias.setLineWrap(true);
						txtSugerencias.setWrapStyleWord(true);
						txtSugerencias.setEditable(false);
					}
				}
			}
			{
				panelRutasPredefinidas = new panelRutasPredefinidas(this.datos);
				tabbedPane.addTab(Messages.getString("VentanaPrincipal.TituloRutasPredefinidas"), new ImageIcon(VentanaPrincipal.class.getResource("/presentacion/rutaTab.png")), panelRutasPredefinidas, null); //$NON-NLS-1$ //$NON-NLS-2$
			}
			{
				panelAccesoGestiones = new JPanel();
				tabbedPane.addTab(Messages.getString("VentanaPrincipal.TituloAccesoGestiones"), new ImageIcon(VentanaPrincipal.class.getResource("/presentacion/gestiones.png")), panelAccesoGestiones, null); //$NON-NLS-1$ //$NON-NLS-2$
				GridBagLayout gbl_panelAccesoGestiones = new GridBagLayout();
				gbl_panelAccesoGestiones.columnWidths = new int[] {0, 370, 0, 0};
				gbl_panelAccesoGestiones.rowHeights = new int[] {30, 150, 30, 150, 30, 150, 31};
				gbl_panelAccesoGestiones.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
				gbl_panelAccesoGestiones.rowWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0};
				panelAccesoGestiones.setLayout(gbl_panelAccesoGestiones);
				{
					btnGestionGuias = new JButton(Messages.getString("VentanaPrincipal.btnGestionGuias.text")); //$NON-NLS-1$
					btnGestionGuias.setToolTipText(Messages.getString("VentanaPrincipal.btnGestionGuias.toolTipText")); //$NON-NLS-1$
					btnGestionGuias.addActionListener(new BtnGestionGuiasActionListener());
					btnGestionGuias.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/presentacion/guia.png"))); //$NON-NLS-1$
					GridBagConstraints gbc_btnGestionGuias = new GridBagConstraints();
					gbc_btnGestionGuias.fill = GridBagConstraints.BOTH;
					gbc_btnGestionGuias.insets = new Insets(0, 0, 5, 5);
					gbc_btnGestionGuias.gridx = 1;
					gbc_btnGestionGuias.gridy = 1;
					panelAccesoGestiones.add(btnGestionGuias, gbc_btnGestionGuias);
				}
				{
					btnGestionTuristas = new JButton(Messages.getString("VentanaPrincipal.btnGestionTuristas.text")); //$NON-NLS-1$
					btnGestionTuristas.setToolTipText(Messages.getString("VentanaPrincipal.btnGestionTuristas.toolTipText")); //$NON-NLS-1$
					btnGestionTuristas.addActionListener(new BtnGestionTuristasActionListener());
					btnGestionTuristas.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/presentacion/grupo.png"))); //$NON-NLS-1$
					GridBagConstraints gbc_btnGestionTuristas = new GridBagConstraints();
					gbc_btnGestionTuristas.fill = GridBagConstraints.BOTH;
					gbc_btnGestionTuristas.insets = new Insets(0, 0, 5, 5);
					gbc_btnGestionTuristas.gridx = 1;
					gbc_btnGestionTuristas.gridy = 3;
					panelAccesoGestiones.add(btnGestionTuristas, gbc_btnGestionTuristas);
				}
				{
					btnPromociones = new JButton(Messages.getString("VentanaPrincipal.btnPromociones.text")); //$NON-NLS-1$
					btnPromociones.setToolTipText(Messages.getString("VentanaPrincipal.btnPromociones.toolTipText")); //$NON-NLS-1$
					btnPromociones.addActionListener(new BtnPromocionesActionListener());
					btnPromociones.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/presentacion/promocion.png"))); //$NON-NLS-1$
					GridBagConstraints gbc_btnPromociones = new GridBagConstraints();
					gbc_btnPromociones.fill = GridBagConstraints.BOTH;
					gbc_btnPromociones.insets = new Insets(0, 0, 5, 5);
					gbc_btnPromociones.gridx = 1;
					gbc_btnPromociones.gridy = 5;
					panelAccesoGestiones.add(btnPromociones, gbc_btnPromociones);
				}
			}
		}
		{
			menuBar = new JMenuBar();
			frame.setJMenuBar(menuBar);
			{
				mnEdicion = new JMenu(Messages.getString("VentanaPrincipal.mnEdicion.text")); //$NON-NLS-1$
				mnEdicion.setMnemonic('e');
				menuBar.add(mnEdicion);
				{
					mnTema = new JMenu(Messages.getString("VentanaPrincipal.mnTema.text")); //$NON-NLS-1$
					mnTema.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/presentacion/tema.png"))); //$NON-NLS-1$
					mnEdicion.add(mnTema);
					mnTema.setMnemonic('t');
					{
						rbClaro = new JRadioButton(Messages.getString("VentanaPrincipal.rbClaro.text")); //$NON-NLS-1$
						rbClaro.addActionListener(new RbClaroActionListener());
						rbClaro.setSelected(true);
						buttonGroup.add(rbClaro);
						mnTema.add(rbClaro);
					}
					{
						rbOscuro = new JRadioButton(Messages.getString("VentanaPrincipal.rbOscuro.text")); //$NON-NLS-1$
						rbOscuro.addActionListener(new RbOscuroActionListener());
						buttonGroup.add(rbOscuro);
						mnTema.add(rbOscuro);
					}
				}
			}
			{
				mnAyuda = new JMenu(Messages.getString("VentanaPrincipal.mnAyuda.text")); //$NON-NLS-1$
				mnAyuda.setMnemonic('a');
				menuBar.add(mnAyuda);
				{
					mntmAyuda = new JMenuItem(Messages.getString("VentanaPrincipal.mntmAyuda.text")); //$NON-NLS-1$
					mntmAyuda.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/presentacion/ayuda.png"))); //$NON-NLS-1$
					mntmAyuda.addActionListener(new MntmAyudaActionListener());
					mnAyuda.add(mntmAyuda);
				}
				{
					mntmAcercaDe = new JMenuItem(Messages.getString("VentanaPrincipal.mntmAcercaDe.text")); //$NON-NLS-1$
					mntmAcercaDe.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/presentacion/autor.png"))); //$NON-NLS-1$
					mntmAcercaDe.addActionListener(new MntmAcercaDeActionListener());
					mnAyuda.add(mntmAcercaDe);
				}
			}
		}
	}
	private class BtnGestionGuiasActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			
			if(ventanaguias == null || !ventanaguias.getEstado()) {
				ventanaguias = new VentanaGuias(datos);
				ventanaguias.setModal(false);
				ventanaguias.setVisible(true);
			}else {
				JOptionPane.showMessageDialog(frame, Messages.getString("VentanaPrincipal.TextoAvisoGuias"), Messages.getString("VentanaPrincipal.TituloAvisoGuias"), JOptionPane.WARNING_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
			}
			
		}
	}
	private class BtnGestionTuristasActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			if(ventanaturistas == null || !ventanaturistas.getEstado()) {
				ventanaturistas = new VentanaTuristas(datos);
				ventanaturistas.setVisible(true);
			}else {
				JOptionPane.showMessageDialog(frame, Messages.getString("VentanaPrincipal.TextoAvisoTuristas"), Messages.getString("VentanaPrincipal.TituloAvisoTuristas"), JOptionPane.WARNING_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
			}
			
		}
	}
	
	private class BtnPromocionesActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			if(ventanapromo == null || !ventanapromo.getEstado()) {
				ventanapromo = new VentanaPromociones(datos);
				ventanapromo.setVisible(true);
			}else {
				JOptionPane.showMessageDialog(frame, Messages.getString("VentanaPrincipal.TextoAvisoPromociones"), Messages.getString("VentanaPrincipal.TituloAvisoPromociones"), JOptionPane.WARNING_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
			}
			
		}
	}
	
	private class MntmAyudaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			if(ventanaayuda == null || !ventanaayuda.getEstado()) {
				ventanaayuda = new VentanaAyuda();
				ventanaayuda.setVisible(true);
			}else {
				JOptionPane.showMessageDialog(frame, Messages.getString("VentanaPrincipal.TextoAvisoAyuda"), Messages.getString("VentanaPrincipal.TituloAvisoAyuda"), JOptionPane.WARNING_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
			}
			
		}
	}
	private class MntmAcercaDeActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			if(ventanaacercade == null || !ventanaacercade.getEstado()) {
				ventanaacercade = new VentanaAcercaDe();
				ventanaacercade.setVisible(true);
			}else {
				JOptionPane.showMessageDialog(frame, Messages.getString("VentanaPrincipal.TextoAvisoAcercaDe"), Messages.getString("VentanaPrincipal.TituloAvisoAcercaDe"), JOptionPane.WARNING_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
			}

		}
	}
	
	private class BtnCerrarSesionActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			
			int resp=JOptionPane.showConfirmDialog(frame, Messages.getString("VentanaPrincipal.TextoCerrarSesion"), Messages.getString("VentanaPrincipal.TituloCerrarSesion"), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
			
			if(JOptionPane.OK_OPTION == resp) {
				Window[] windows = frame.getWindows();

				for (Window window : windows)
				{
					if (window instanceof JDialog)
					{
						window.dispose();
					}
				}

				frame.dispose();
				new VentanaLogin().frmLogin.setVisible(true);
			}
			
		}
	}
	private class ListRutasListSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent arg0) {
			
			if(!listRutas.isSelectionEmpty()) {
				
				Ruta rutaselec = (Ruta) listRutas.getSelectedValue();
				txtEstado.setText(rutaselec.getEstado());
				txtCoste.setText(rutaselec.getCoste());
				txtOpiniones.setText(rutaselec.getOpiniones());
				txtSugerencias.setText(rutaselec.getSugerencias());
				txtIncidencias.setText(rutaselec.getIncidencias());
				txtNumPersonas.setText(Integer.toString(rutaselec.getTuristasTotal()));
			}
			
		}
	}
	private class RbClaroActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {

			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
					| UnsupportedLookAndFeelException e) {
				e.printStackTrace();
			}

			Window[] windows = frame.getWindows();

			for (Window window : windows)
			{
				if (window instanceof JDialog)
				{
					SwingUtilities.updateComponentTreeUI(window);
				}
			}
			SwingUtilities.updateComponentTreeUI(frame);
		}
	}
	private class RbOscuroActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {

			try {
				UIManager.setLookAndFeel("com.formdev.flatlaf.FlatDarculaLaf");
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
					| UnsupportedLookAndFeelException e) {
				e.printStackTrace();
			}

			Window[] windows = frame.getWindows();

			for (Window window : windows)
			{
				if (window instanceof JDialog)
				{
					SwingUtilities.updateComponentTreeUI(window);
				}
			}
			SwingUtilities.updateComponentTreeUI(frame);

		}
	}
}
