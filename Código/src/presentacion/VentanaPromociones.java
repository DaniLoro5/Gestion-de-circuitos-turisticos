package presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import datos.DatosPrueba;
import dominio.Promocion;
import dominio.Turista;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Font;

/**
 * @author Daniel Loro Durán
 */
public class VentanaPromociones extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTabbedPane tabbedPane;
	private JPanel pnlMensaje;
	private JPanel pnlEnvio;
	private JLabel lblContenidoMensaje;
	private JTextArea txtMensajePromo;
	private JLabel lblNombrePromoción;
	private JTextField txtNombrePromo;
	private JButton btnAdjuntarArchivo;
	private JLabel lblNombreDelArchivo;
	private JTextField txtNombreArchivo;
	private JLabel lblTamaoDelArchivo;
	private JTextField txtTamanoArchivo;
	private JButton btnAnadirPromocion;
	private JButton btnGuardarCambios;
	private JButton btnEliminarPromocion;
	private JButton btnAnadir;
	private JButton btnQuitar;
	private JButton btnEnviar;
	private JSeparator separator;
	private JScrollPane spPromociones;
	private JList listPromo;
	private JLabel lblPromociones;
	private JScrollPane spNoEnviar;
	private JScrollPane spEnviar;
	private JList listNoEnviar;
	private JLabel lblNoEnviarA;
	private JList listEnviar;
	private JLabel lblEnviarA;
	private JScrollPane spMensajePromo;

	private DatosPrueba datos;
	
	DefaultListModel modeloPromo;
	DefaultListModel modeloEnviar;
	DefaultListModel modeloNoEnviar;
	
	private boolean abierta = false;

	/**
	 * Create the dialog.
	 */
	public VentanaPromociones(DatosPrueba datos) {
		addWindowListener(new ThisWindowListener());
		this.datos = datos;
		this.abierta = true;
		setModal(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPromociones.class.getResource("/presentacion/promocion.png"))); //$NON-NLS-1$
		setTitle(Messages.getString("VentanaPromociones.this.title")); //$NON-NLS-1$
		setResizable(false);
		setBounds(100, 100, 674, 388);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setBounds(112, 11, 546, 340);
			contentPanel.add(tabbedPane);
			{
				pnlMensaje = new JPanel();
				tabbedPane.addTab(Messages.getString("VentanaPromociones.TabMensaje"), null, pnlMensaje, null); //$NON-NLS-1$
				pnlMensaje.setLayout(null);
				{
					lblContenidoMensaje = new JLabel(Messages.getString("VentanaPromociones.lblContenidoMensaje.text")); //$NON-NLS-1$
					lblContenidoMensaje.setBounds(10, 11, 142, 14);
					pnlMensaje.add(lblContenidoMensaje);
				}
				{
					spMensajePromo = new JScrollPane();
					spMensajePromo.setBounds(10, 36, 342, 222);
					pnlMensaje.add(spMensajePromo);
					{
						txtMensajePromo = new JTextArea();
						txtMensajePromo.setFont(new Font("Tahoma", Font.PLAIN, 11));
						spMensajePromo.setViewportView(txtMensajePromo);
						txtMensajePromo.setLineWrap(true);
						txtMensajePromo.setWrapStyleWord(true);
					}
				}
				{
					lblNombrePromoción = new JLabel(Messages.getString("VentanaPromociones.lblNombrePromoción.text")); //$NON-NLS-1$
					lblNombrePromoción.setBounds(362, 11, 134, 14);
					pnlMensaje.add(lblNombrePromoción);
				}
				{
					txtNombrePromo = new JTextField();
					txtNombrePromo.setBounds(362, 38, 166, 20);
					txtNombrePromo.addFocusListener(new MiFocusListener());
					pnlMensaje.add(txtNombrePromo);
					txtNombrePromo.setColumns(10);
				}
				{
					btnAdjuntarArchivo = new JButton(Messages.getString("VentanaPromociones.btnAdjuntarArchivo.text")); //$NON-NLS-1$
					btnAdjuntarArchivo.setToolTipText(Messages.getString("VentanaPromociones.btnAdjuntarArchivo.toolTipText")); //$NON-NLS-1$
					btnAdjuntarArchivo.addActionListener(new BtnAdjuntarArchivoActionListener());
					btnAdjuntarArchivo.setIcon(new ImageIcon(VentanaPromociones.class.getResource("/presentacion/archivo.png"))); //$NON-NLS-1$
					btnAdjuntarArchivo.setBounds(362, 119, 166, 33);
					pnlMensaje.add(btnAdjuntarArchivo);
				}
				{
					lblNombreDelArchivo = new JLabel(Messages.getString("VentanaPromociones.lblNombreDelArchivo.text")); //$NON-NLS-1$
					lblNombreDelArchivo.setBounds(362, 163, 134, 14);
					pnlMensaje.add(lblNombreDelArchivo);
				}
				{
					txtNombreArchivo = new JTextField();
					txtNombreArchivo.setHorizontalAlignment(SwingConstants.LEFT);
					txtNombreArchivo.setEditable(false);
					txtNombreArchivo.setBounds(362, 188, 166, 20);
					pnlMensaje.add(txtNombreArchivo);
					txtNombreArchivo.setColumns(10);
				}
				{
					lblTamaoDelArchivo = new JLabel(Messages.getString("VentanaPromociones.lblTamaoDelArchivo.text")); //$NON-NLS-1$
					lblTamaoDelArchivo.setBounds(362, 219, 134, 14);
					pnlMensaje.add(lblTamaoDelArchivo);
				}
				{
					txtTamanoArchivo = new JTextField();
					txtTamanoArchivo.setEditable(false);
					txtTamanoArchivo.setHorizontalAlignment(SwingConstants.RIGHT);
					txtTamanoArchivo.setBounds(362, 238, 169, 20);
					pnlMensaje.add(txtTamanoArchivo);
					txtTamanoArchivo.setColumns(10);
				}
				{
					btnAnadirPromocion = new JButton(Messages.getString("VentanaPromociones.btnAnadirPromocion.text")); //$NON-NLS-1$
					btnAnadirPromocion.setToolTipText(Messages.getString("VentanaPromociones.btnAnadirPromocion.toolTipText")); //$NON-NLS-1$
					btnAnadirPromocion.addActionListener(new BtnAadirPromocionActionListener());
					btnAnadirPromocion.setIcon(new ImageIcon(VentanaPromociones.class.getResource("/presentacion/add.png"))); //$NON-NLS-1$
					btnAnadirPromocion.setBounds(10, 274, 166, 33);
					pnlMensaje.add(btnAnadirPromocion);
				}
				{
					btnGuardarCambios = new JButton(Messages.getString("VentanaPromociones.btnGuardarCambios.text")); //$NON-NLS-1$
					btnGuardarCambios.setToolTipText(Messages.getString("VentanaPromociones.btnGuardarCambios.toolTipText")); //$NON-NLS-1$
					btnGuardarCambios.addActionListener(new BtnGuardarCambiosActionListener());
					btnGuardarCambios.setEnabled(false);
					btnGuardarCambios.setIcon(new ImageIcon(VentanaPromociones.class.getResource("/presentacion/guardar.png"))); //$NON-NLS-1$
					btnGuardarCambios.setBounds(186, 274, 166, 33);
					pnlMensaje.add(btnGuardarCambios);
				}
				{
					btnEliminarPromocion = new JButton(Messages.getString("VentanaPromociones.btnEliminarPromocion.text")); //$NON-NLS-1$
					btnEliminarPromocion.setToolTipText(Messages.getString("VentanaPromociones.btnEliminarPromocion.toolTipText")); //$NON-NLS-1$
					btnEliminarPromocion.setEnabled(false);
					btnEliminarPromocion.addActionListener(new BtnEliminarPromocionActionListener());
					btnEliminarPromocion.setIcon(new ImageIcon(VentanaPromociones.class.getResource("/presentacion/eliminar.png"))); //$NON-NLS-1$
					btnEliminarPromocion.setBounds(359, 274, 172, 33);
					pnlMensaje.add(btnEliminarPromocion);
				}
			}
			{
				pnlEnvio = new JPanel();
				tabbedPane.addTab(Messages.getString("VentanaPromociones.TabDestinatarios"), null, pnlEnvio, null); //$NON-NLS-1$
				pnlEnvio.setLayout(null);
				{
					btnAnadir = new JButton(Messages.getString("VentanaPromociones.btnAnadir.text")); //$NON-NLS-1$
					btnAnadir.setToolTipText(Messages.getString("VentanaPromociones.btnAnadir.toolTipText")); //$NON-NLS-1$
					btnAnadir.setEnabled(false);
					btnAnadir.addActionListener(new BtnAnadirActionListener());
					btnAnadir.setIcon(new ImageIcon(VentanaPromociones.class.getResource("/presentacion/flechaDer.png"))); //$NON-NLS-1$
					btnAnadir.setBounds(212, 84, 125, 33);
					pnlEnvio.add(btnAnadir);
				}
				{
					btnQuitar = new JButton(Messages.getString("VentanaPromociones.btnQuitar.text")); //$NON-NLS-1$
					btnQuitar.setToolTipText(Messages.getString("VentanaPromociones.btnQuitar.toolTipText")); //$NON-NLS-1$
					btnQuitar.setEnabled(false);
					btnQuitar.addActionListener(new BtnQuitarActionListener());
					btnQuitar.setIcon(new ImageIcon(VentanaPromociones.class.getResource("/presentacion/flechaIzq.png"))); //$NON-NLS-1$
					btnQuitar.setBounds(212, 140, 125, 33);
					pnlEnvio.add(btnQuitar);
				}
				{
					btnEnviar = new JButton(Messages.getString("VentanaPromociones.btnEnviar.text")); //$NON-NLS-1$
					btnEnviar.setEnabled(false);
					btnEnviar.addActionListener(new BtnEnviarActionListener());
					btnEnviar.setIcon(new ImageIcon(VentanaPromociones.class.getResource("/presentacion/enviar.png"))); //$NON-NLS-1$
					btnEnviar.setBounds(22, 274, 493, 33);
					pnlEnvio.add(btnEnviar);
				}
				{
					separator = new JSeparator();
					separator.setBounds(22, 259, 493, 12);
					pnlEnvio.add(separator);
				}
				{
					spNoEnviar = new JScrollPane();
					spNoEnviar.setBounds(22, 11, 125, 237);
					pnlEnvio.add(spNoEnviar);
					{
						listNoEnviar = new JList();
						listNoEnviar.setEnabled(false);
						modeloNoEnviar = new DefaultListModel<Turista>();
						
						for(int i = 0; i < datos.turistasGeneral.size();i++) {
							modeloNoEnviar.addElement(datos.turistasGeneral.get(i));
						}
						
						listNoEnviar.setModel(modeloNoEnviar);
						listNoEnviar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						spNoEnviar.setViewportView(listNoEnviar);
					}
					{
						lblNoEnviarA = new JLabel(Messages.getString("VentanaPromociones.lblNoEnviarA.text")); //$NON-NLS-1$
						spNoEnviar.setColumnHeaderView(lblNoEnviarA);
					}
				}
				{
					spEnviar = new JScrollPane();
					spEnviar.setBounds(390, 11, 125, 237);
					pnlEnvio.add(spEnviar);
					{
						listEnviar = new JList();
						listEnviar.setEnabled(false);
						modeloEnviar = new DefaultListModel<Turista>();
						listEnviar.setModel(modeloEnviar);
						listEnviar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						spEnviar.setViewportView(listEnviar);
					}
					{
						lblEnviarA = new JLabel(Messages.getString("VentanaPromociones.lblEnviarA.text")); //$NON-NLS-1$
						spEnviar.setColumnHeaderView(lblEnviarA);
					}
				}
			}
		}
		{
			spPromociones = new JScrollPane();
			spPromociones.setBounds(6, 11, 96, 340);
			contentPanel.add(spPromociones);
			{
				listPromo = new JList();
				listPromo.addListSelectionListener(new ListPromoListSelectionListener());
				modeloPromo = new DefaultListModel<Promocion>();
				
				for(int i = 0; i < datos.promociones.size();i++) {
					modeloPromo.addElement(datos.promociones.get(i));
				}
				
				listPromo.setModel(modeloPromo);
				listPromo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				spPromociones.setViewportView(listPromo);
			}
			{
				lblPromociones = new JLabel(Messages.getString("VentanaPromociones.lblPromociones.text")); //$NON-NLS-1$
				lblPromociones.setHorizontalAlignment(SwingConstants.CENTER);
				spPromociones.setColumnHeaderView(lblPromociones);
			}
			
		}

	}
	
	private class ListPromoListSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent e) {
			
			if(!listPromo.isSelectionEmpty()) {
				
				Promocion promoselec = (Promocion) listPromo.getSelectedValue();
				
				btnGuardarCambios.setEnabled(true);
				btnEliminarPromocion.setEnabled(true);
				btnEnviar.setEnabled(true);
				btnAnadir.setEnabled(true);
				btnQuitar.setEnabled(true);
				listEnviar.setEnabled(true);
				listNoEnviar.setEnabled(true);

				txtMensajePromo.setText(promoselec.getMensaje());
				txtNombrePromo.setText(promoselec.getNombrepromo());
			}
			
		}
	}
	
	private class BtnAadirPromocionActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			if(!txtNombrePromo.getText().equals("")) { //$NON-NLS-1$
				
				Promocion promo = new Promocion(txtNombrePromo.getText(), txtMensajePromo.getText());
				modeloPromo.addElement(promo);
				datos.promociones.add(promo);
				
			}else {
				JOptionPane.showMessageDialog(contentPanel, Messages.getString("VentanaPromociones.TextoErrorAñadirPromo"), Messages.getString("VentanaPromociones.TituloAvisoAñadirPromo"), JOptionPane.ERROR_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$

			}
			
		}
	}
	
	private class BtnGuardarCambiosActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			if(!listPromo.isSelectionEmpty()) {
				
				Promocion promo = (Promocion) listPromo.getSelectedValue();
				
				if(!txtNombrePromo.getText().equals("")) { //$NON-NLS-1$
					
					promo.setNombrepromo(txtNombrePromo.getText());
					promo.setMensaje(txtMensajePromo.getText());
					
					JOptionPane.showMessageDialog(contentPanel, Messages.getString("VentanaPromociones.TextoAvisoPromoMod"), Messages.getString("VentanaPromociones.TituloAvisoPromoMod"), JOptionPane.INFORMATION_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$

					
				}else {
					JOptionPane.showMessageDialog(contentPanel, Messages.getString("VentanaPromociones.TextoErrorPromoMod"), Messages.getString("VentanaPromociones.TituloErrorPromoMod"), JOptionPane.ERROR_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
				}
			}
			
		}
	}
	
	private class BtnEliminarPromocionActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			if(!listPromo.isSelectionEmpty()) {

				Promocion promo = (Promocion) listPromo.getSelectedValue();

				int resp=JOptionPane.showConfirmDialog(contentPanel, Messages.getString("VentanaPromociones.TextoConfirmarEliminar") + promo.getNombrepromo() + "?", Messages.getString("VentanaPromociones.TituloConfirmarEliminar"), JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

				if(JOptionPane.OK_OPTION==resp) {
					datos.promociones.remove(promo);
					modeloPromo.removeElement(promo);
				}

			}else {
				JOptionPane.showMessageDialog(contentPanel, Messages.getString("VentanaPromociones.TextoErrorEliminarPromo"), Messages.getString("VentanaPromociones.TituloErrorEliminarPromo"), JOptionPane.ERROR_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$

			}
		}
	}
	
	private class BtnAdjuntarArchivoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			JFileChooser fcAbrir = new JFileChooser();
			fcAbrir.setFileFilter(new FilterFile());
			int valorDevuelto = fcAbrir.showOpenDialog(contentPanel);
			
			if(valorDevuelto == JFileChooser.APPROVE_OPTION) {
				File file = fcAbrir.getSelectedFile();
				
				txtNombreArchivo.setText(file.getName());
				double tamano = file.length()/(1024*1024);
				txtTamanoArchivo.setText((double)(file.length()/(1024*1024)) +" MBs"); //$NON-NLS-1$
				
			}
			
		}
	}
	

	private class BtnEnviarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			if(!listPromo.isSelectionEmpty()) {
				
				Promocion promo = (Promocion) listPromo.getSelectedValue();
				
				if(!modeloEnviar.isEmpty()) {
				
				JOptionPane.showMessageDialog(null,promo.getNombrepromo() + Messages.getString("VentanaPromociones.TextoAvisoPromoEnviada"), Messages.getString("VentanaPromociones.TituloAvisoPromoEnviada"), JOptionPane.INFORMATION_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
				
				}else {
					JOptionPane.showMessageDialog(contentPanel, Messages.getString("VentanaPromociones.TextoErrorPromoEnviada"), Messages.getString("VentanaPromociones.TituloErrorPromoEnviada"), JOptionPane.ERROR_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$

				}
			}else {
				
				JOptionPane.showMessageDialog(contentPanel, Messages.getString("VentanaPromociones.TextoErrorPromoNoSelec"), Messages.getString("VentanaPromociones.TituloErrorPromoNoSelec"), JOptionPane.ERROR_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$

				
			}
			
			
		}
	}
	private class BtnAnadirActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			
			if(!listNoEnviar.isSelectionEmpty()) {
				
				modeloEnviar.addElement(listNoEnviar.getSelectedValue());
				modeloNoEnviar.removeElement(listNoEnviar.getSelectedValue());

			}
			
		}
	}
	private class BtnQuitarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			if(!listEnviar.isSelectionEmpty()) {
				
				modeloNoEnviar.addElement(listEnviar.getSelectedValue());
				modeloEnviar.removeElement(listEnviar.getSelectedValue());

			}
			
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
	private class ThisWindowListener extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent e) {
			
			abierta = false;
			
		}
	}

	public boolean getEstado() {
		return this.abierta;
	}

}
