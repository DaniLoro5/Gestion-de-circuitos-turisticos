package presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import datos.DatosPrueba;
import dominio.Guia;
import dominio.Ruta;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;

import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ListSelectionModel;
import javax.swing.JFormattedTextField;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JSeparator;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Rectangle;
import javax.swing.SwingConstants;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Font;


/**
 * @author Daniel Loro Durán
 */
public class VentanaGuias extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnAnadirGuia;
	private JButton btnModificarGuia;
	private JButton btnEliminarGuia;
	private JPanel pnlInformacionGuia;
	private JLabel lblFotoGuia;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JLabel lblApellidos;
	private JTextField txtApellidos;
	private JLabel lblIdiomas;
	private JTextField txtIdiomas;
	private JLabel lblPrecioHora;
	private JTextField txtPrecioHora;
	private JButton btnEditar;
	private JLabel lblTelfono;
	private JLabel lblPuntuacin;
	private JTextField txtPuntuacion;
	private JLabel lblDisponibilidad;
	private JTextArea txtDisponibilidad;
	private JScrollPane spListaGuias;
	private JList listGuias;
	private JLabel lblGuias;
	private JScrollPane spRutas;
	private static JList listRutas;
	private JLabel lblRutas;
	private JScrollPane spFotoGuia;
	private ImageIcon foto;
	private DatosPrueba datos;
	private JFormattedTextField ftxtTelefono;
	private JButton btnEditar_1;
	private JSeparator separator;
	private JTextField txtPrecioDia;
	private JLabel lblPrecioDia;
	private JLabel lblDni;
	private JFormattedTextField ftxtDNI;
	private String rutaFoto = ""; //$NON-NLS-1$
	private JScrollPane spDisponibilidad;
	
	DefaultListModel modeloGuias;
	static DefaultListModel modeloRutas;
	
	public boolean abierta = false;

	
	/**
	 * Create the dialog.
	 */
	public VentanaGuias(DatosPrueba datos) {
		setResizable(false);
		addWindowListener(new ThisWindowListener());
		this.datos = datos;
		this.abierta = true;
		setModal(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaGuias.class.getResource("/presentacion/guia.png"))); //$NON-NLS-1$
		setTitle(Messages.getString("VentanaGuias.this.title")); //$NON-NLS-1$
		setModalityType(DEFAULT_MODALITY_TYPE.DOCUMENT_MODAL);
		setBounds(100, 100, 652, 400);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			pnlInformacionGuia = new JPanel();
			pnlInformacionGuia.setBorder(new TitledBorder(null, Messages.getString("VentanaGuias.pnlInformacionGuia.borderTitle"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
			pnlInformacionGuia.setBounds(110, 12, 531, 354);
			contentPanel.add(pnlInformacionGuia);
			pnlInformacionGuia.setLayout(null);
			{
				spFotoGuia = new JScrollPane();
				spFotoGuia.setBounds(22, 23, 114, 114);
				pnlInformacionGuia.add(spFotoGuia);
				{
					lblFotoGuia = new JLabel(""); //$NON-NLS-1$
					lblFotoGuia.setIcon(new ImageIcon(new ImageIcon(VentanaGuias.class.getResource("/presentacion/personagenerica.png")).getImage().getScaledInstance(110, 110, Image.SCALE_SMOOTH))); //$NON-NLS-1$
					spFotoGuia.setViewportView(lblFotoGuia);
				}
			}
			{
				lblNombre = new JLabel(Messages.getString("VentanaGuias.lblNombre.text")); //$NON-NLS-1$
				lblNombre.setBounds(147, 23, 46, 14);
				pnlInformacionGuia.add(lblNombre);
			}
			{
				txtNombre = new JTextField();
				txtNombre.setBounds(146, 41, 261, 20);
				txtNombre.addFocusListener(new MiFocusListener());
				pnlInformacionGuia.add(txtNombre);
			}
			{
				lblApellidos = new JLabel(Messages.getString("VentanaGuias.lblApellidos.text")); //$NON-NLS-1$
				lblApellidos.setBounds(147, 72, 104, 14);
				pnlInformacionGuia.add(lblApellidos);
			}
			{
				txtApellidos = new JTextField();
				txtApellidos.setBounds(146, 90, 261, 20);
				txtApellidos.addFocusListener(new MiFocusListener());
				pnlInformacionGuia.add(txtApellidos);
			}
			{
				lblIdiomas = new JLabel(Messages.getString("VentanaGuias.lblIdiomas.text")); //$NON-NLS-1$
				lblIdiomas.setBounds(146, 123, 46, 14);
				pnlInformacionGuia.add(lblIdiomas);
			}
			{
				txtIdiomas = new JTextField();
				txtIdiomas.setBounds(147, 141, 260, 20);
				txtIdiomas.addFocusListener(new MiFocusListener());
				pnlInformacionGuia.add(txtIdiomas);
			}
			{
				lblPrecioHora = new JLabel(Messages.getString("VentanaGuias.lblPrecioHora.text")); //$NON-NLS-1$
				lblPrecioHora.setBounds(147, 170, 126, 14);
				pnlInformacionGuia.add(lblPrecioHora);
			}
			{
				txtPrecioHora = new JTextField();
				txtPrecioHora.setBounds(147, 187, 126, 20);
				txtPrecioHora.addFocusListener(new MiFocusListener());
				pnlInformacionGuia.add(txtPrecioHora);
			}
			{
				btnEditar = new JButton(Messages.getString("VentanaGuias.btnEditar.text")); //$NON-NLS-1$
				btnEditar.setToolTipText(Messages.getString("VentanaGuias.btnEditar.toolTipText")); //$NON-NLS-1$
				btnEditar.addActionListener(new BtnEditarActionListener());
				btnEditar.setIcon(new ImageIcon(VentanaGuias.class.getResource("/presentacion/camara.png"))); //$NON-NLS-1$
				btnEditar.setBounds(22, 140, 114, 23);
				pnlInformacionGuia.add(btnEditar);
			}
			{
				lblTelfono = new JLabel(Messages.getString("VentanaGuias.lblTelfono.text")); //$NON-NLS-1$
				lblTelfono.setBounds(22, 210, 114, 14);
				pnlInformacionGuia.add(lblTelfono);
			}
			{
				lblPuntuacin = new JLabel(Messages.getString("VentanaGuias.lblPuntuacin.text")); //$NON-NLS-1$
				lblPuntuacin.setBounds(22, 262, 104, 14);
				pnlInformacionGuia.add(lblPuntuacin);
			}
			{
				txtPuntuacion = new JTextField();
				txtPuntuacion.setBounds(22, 283, 114, 20);
				txtPuntuacion.addFocusListener(new MiFocusListener());
				pnlInformacionGuia.add(txtPuntuacion);
			}
			{
				lblDisponibilidad = new JLabel(Messages.getString("VentanaGuias.lblDisponibilidad.text")); //$NON-NLS-1$
				lblDisponibilidad.setBounds(147, 210, 85, 14);
				pnlInformacionGuia.add(lblDisponibilidad);
			}
			{
				{
					spDisponibilidad = new JScrollPane();
					spDisponibilidad.setBounds(147, 229, 260, 74);
					pnlInformacionGuia.add(spDisponibilidad);
					txtDisponibilidad = new JTextArea();
					txtDisponibilidad.setFont(new Font("Tahoma", Font.PLAIN, 11));
					spDisponibilidad.setViewportView(txtDisponibilidad);
					txtDisponibilidad.setWrapStyleWord(true);
					txtDisponibilidad.setLineWrap(true);
					txtDisponibilidad.addFocusListener(new MiFocusListener());
				}
			}
			{
				spRutas = new JScrollPane();
				spRutas.setBounds(417, 11, 104, 255);
				pnlInformacionGuia.add(spRutas);
				{
					listRutas = new JList();
					modeloRutas = new DefaultListModel<Ruta>();					
					listRutas.setModel(modeloRutas);
					listRutas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					spRutas.setViewportView(listRutas);
				}
				{
					lblRutas = new JLabel(Messages.getString("VentanaGuias.lblRutas.text")); //$NON-NLS-1$
					lblRutas.setHorizontalAlignment(SwingConstants.CENTER);
					spRutas.setColumnHeaderView(lblRutas);
				}
			}
			{
				btnAnadirGuia = new JButton(Messages.getString("VentanaGuias.btnAnadirGuia.text")); //$NON-NLS-1$
				btnAnadirGuia.setToolTipText(Messages.getString("VentanaGuias.btnAnadirGuia.toolTipText")); //$NON-NLS-1$
				btnAnadirGuia.addActionListener(new BtnAnadirGuiaActionListener());
				btnAnadirGuia.setBounds(22, 314, 150, 33);
				pnlInformacionGuia.add(btnAnadirGuia);
				btnAnadirGuia.setIcon(new ImageIcon(VentanaGuias.class.getResource("/presentacion/add.png"))); //$NON-NLS-1$
			}
			{
				btnModificarGuia = new JButton(Messages.getString("VentanaGuias.btnModificarGuia.text")); //$NON-NLS-1$
				btnModificarGuia.setToolTipText(Messages.getString("VentanaGuias.btnModificarGuia.toolTipText")); //$NON-NLS-1$
				btnModificarGuia.addActionListener(new BtnModificarGuiaActionListener());
				btnModificarGuia.setEnabled(false);
				btnModificarGuia.setBounds(190, 314, 166, 33);
				pnlInformacionGuia.add(btnModificarGuia);
				btnModificarGuia.setIcon(new ImageIcon(VentanaGuias.class.getResource("/presentacion/guardar.png"))); //$NON-NLS-1$
			}
			{
				btnEliminarGuia = new JButton(Messages.getString("VentanaGuias.btnEliminarGuia.text")); //$NON-NLS-1$
				btnEliminarGuia.setToolTipText(Messages.getString("VentanaGuias.btnEliminarGuia.toolTipText")); //$NON-NLS-1$
				btnEliminarGuia.setEnabled(false);
				btnEliminarGuia.setBounds(371, 314, 150, 33);
				pnlInformacionGuia.add(btnEliminarGuia);
				btnEliminarGuia.addActionListener(new BtnEliminarGuiaActionListener());
				btnEliminarGuia.setIcon(new ImageIcon(VentanaGuias.class.getResource("/presentacion/eliminar.png"))); //$NON-NLS-1$
			}
			{
				
				MaskFormatter formatoTlfno;
				try {
					formatoTlfno = new MaskFormatter("###' ###' ###"); //$NON-NLS-1$
					formatoTlfno.setPlaceholderCharacter('*');
					ftxtTelefono = new JFormattedTextField(formatoTlfno);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
				ftxtTelefono.setBounds(22, 231, 114, 20);
				pnlInformacionGuia.add(ftxtTelefono);
			}
			{
				btnEditar_1 = new JButton(Messages.getString("VentanaGuias.btnEditar_1.text")); //$NON-NLS-1$
				btnEditar_1.setToolTipText(Messages.getString("VentanaGuias.btnEditar_1.toolTipText")); //$NON-NLS-1$
				btnEditar_1.addActionListener(new BtnEditar_1ActionListener());
				btnEditar_1.setIcon(new ImageIcon(VentanaGuias.class.getResource("/presentacion/rutaTab.png"))); //$NON-NLS-1$
				btnEditar_1.setBounds(417, 275, 104, 23);
				pnlInformacionGuia.add(btnEditar_1);
			}
			{
				separator = new JSeparator();
				separator.setBounds(417, 305, 104, 8);
				pnlInformacionGuia.add(separator);
			}
			{
				txtPrecioDia = new JTextField();
				txtPrecioDia.setBounds(283, 187, 124, 20);
				txtPrecioDia.addFocusListener(new MiFocusListener());
				pnlInformacionGuia.add(txtPrecioDia);
			}
			{
				lblPrecioDia = new JLabel(Messages.getString("VentanaGuias.lblPrecioDia.text")); //$NON-NLS-1$
				lblPrecioDia.setBounds(283, 172, 124, 14);
				pnlInformacionGuia.add(lblPrecioDia);
			}
			{
				lblDni = new JLabel(Messages.getString("VentanaGuias.lblDni.text")); //$NON-NLS-1$
				lblDni.setBounds(22, 170, 46, 14);
				pnlInformacionGuia.add(lblDni);
			}
			{
				
				MaskFormatter formatoDNI;
				try {
					formatoDNI = new MaskFormatter("########'-U"); //$NON-NLS-1$
					formatoDNI.setPlaceholderCharacter('X');
					ftxtDNI = new JFormattedTextField(formatoDNI);

				} catch (ParseException e) {
					e.printStackTrace();
				}
				ftxtDNI.addFocusListener(new MiFocusListener());
				ftxtDNI.setBounds(22, 187, 114, 20);
				pnlInformacionGuia.add(ftxtDNI);
			}
		}
		{
			spListaGuias = new JScrollPane();
			spListaGuias.setBounds(10, 11, 90, 349);
			contentPanel.add(spListaGuias);
			{
				listGuias = new JList();
				listGuias.addListSelectionListener(new ListGuiasListSelectionListener());
				modeloGuias = new DefaultListModel<Guia>();
				
				for(int i = 0; i < datos.guias.size();i++) {
					modeloGuias.addElement(datos.guias.get(i));
				}
				
				listGuias.setModel(modeloGuias);
				listGuias.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				spListaGuias.setViewportView(listGuias);
			}
			{
				lblGuias = new JLabel(Messages.getString("VentanaGuias.lblGuias.text")); //$NON-NLS-1$
				lblGuias.setHorizontalAlignment(SwingConstants.CENTER);
				spListaGuias.setColumnHeaderView(lblGuias);
			}
		}
	}
	
	private class ListGuiasListSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent e) {
			
			if(!listGuias.isSelectionEmpty()) {
				btnModificarGuia.setEnabled(true);
				btnEliminarGuia.setEnabled(true);
				
				Guia guiaselec = (Guia) listGuias.getSelectedValue();
				
				txtNombre.setText(guiaselec.getNombre());
				txtApellidos.setText(guiaselec.getApellidos());
				txtPuntuacion.setText(guiaselec.getPuntuacion());
				txtIdiomas.setText(guiaselec.getIdiomas());
				ftxtTelefono.setText(guiaselec.getTelefono());
				txtDisponibilidad.setText(guiaselec.getDisponibilidad());
				txtPrecioHora.setText(guiaselec.getPrecioHora());
				txtPrecioDia.setText(guiaselec.getPrecioDia());
				ftxtDNI.setText(guiaselec.getDni());
				
				Path p = Paths.get(guiaselec.getFoto());
				
				if(p.isAbsolute()) {
					foto = new ImageIcon(new ImageIcon(guiaselec.getFoto()).getImage().getScaledInstance(110, 110, Image.SCALE_SMOOTH));
				}else {
					foto = new ImageIcon(new ImageIcon(getClass().getResource(guiaselec.getFoto())).getImage().getScaledInstance(110, 110, Image.SCALE_SMOOTH));
				}
										
				lblFotoGuia.setIcon(foto);
				
				modeloRutas.removeAllElements();
				for(int i = 0; i < guiaselec.getRutas().size();i++) {
					modeloRutas.addElement(guiaselec.getRutas().get(i));
				}
				
			}
			
		}
	} 
	
	private class BtnAnadirGuiaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			if(comprobarCampos(1)) {
				
				Guia guia = new Guia(txtNombre.getText(), txtApellidos.getText(), rutaFoto, txtPuntuacion.getText(), txtIdiomas.getText(), ftxtTelefono.getText(), txtPrecioHora.getText(), txtPrecioDia.getText(), ftxtDNI.getText(), txtDisponibilidad.getText());
				ArrayList<Ruta> nuevasRutas = new ArrayList<Ruta>();

				for(int i = 0; i < modeloRutas.size();i++) {
					nuevasRutas.add((Ruta)modeloRutas.getElementAt(i));
				}
				guia.setRutas(nuevasRutas);	
				
				modeloGuias.addElement(guia);
				datos.guias.add(guia);
				
			}else {
				JOptionPane.showMessageDialog(contentPanel, Messages.getString("VentanaGuias.TextoErrorAñadirGuia"), Messages.getString("VentanaGuias.TituloErrorAñadirGuia"), JOptionPane.WARNING_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
			}
			
		}
	}
	
	private class BtnEditarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			JFileChooser fcAbrir = new JFileChooser();
			fcAbrir.setFileFilter(new ImageFilter());
			int valorDevuelto = fcAbrir.showOpenDialog(contentPanel);
			
			if(valorDevuelto == JFileChooser.APPROVE_OPTION) {
				File file = fcAbrir.getSelectedFile();
				rutaFoto = file.getAbsolutePath();
				foto = new ImageIcon(new ImageIcon(file.getAbsolutePath()).getImage().getScaledInstance(110, 110,Image.SCALE_SMOOTH));
				lblFotoGuia.setIcon(foto);
				
			}
			
		}
	}
	
	private class BtnModificarGuiaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			if(!listGuias.isSelectionEmpty()) {
				
				Guia guia = (Guia) listGuias.getSelectedValue();
				String fotoAntigua = guia.getFoto();
				if(comprobarCampos(2)) {

					guia.setNombre(txtNombre.getText());
					guia.setApellidos(txtApellidos.getText());
					guia.setPuntuacion(txtPuntuacion.getText());
					guia.setIdiomas(txtIdiomas.getText());
					guia.setTelefono(ftxtTelefono.getText());
					guia.setDisponibilidad(txtDisponibilidad.getText());
					guia.setPrecioHora(txtPrecioHora.getText());
					guia.setPrecioDia(txtPrecioDia.getText());
					
					if(!rutaFoto.equals(fotoAntigua) && !rutaFoto.equals("")) { //$NON-NLS-1$
						guia.setFoto(rutaFoto);
					}

					ArrayList<Ruta> nuevasRutas = new ArrayList<Ruta>();

					for(int i = 0; i < modeloRutas.size();i++) {
						nuevasRutas.add((Ruta)modeloRutas.getElementAt(i));
					}
					guia.setRutas(nuevasRutas);
					
					JOptionPane.showMessageDialog(contentPanel, Messages.getString("VentanaGuias.TextoAvisoGuiaModificado"), Messages.getString("VentanaGuias.TituloAvisoGuiaModificado"), JOptionPane.INFORMATION_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
					
				}else {
					JOptionPane.showMessageDialog(contentPanel, Messages.getString("VentanaGuias.TextoErrorGuiaModificado"), Messages.getString("VentanaGuias.TituloErrorGuiaModificado"), JOptionPane.WARNING_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
				}
			}else {
				
				JOptionPane.showMessageDialog(contentPanel, Messages.getString("VentanaGuias.TextoErrorGuiaNoSelec"), Messages.getString("VentanaGuias.TituloErrorGuiaNoSelec"), JOptionPane.ERROR_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
				
			}
			
		}
	}
	
	private class BtnEliminarGuiaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			if(!listGuias.isSelectionEmpty()) {

				Guia guia = (Guia) listGuias.getSelectedValue();

				int resp=JOptionPane.showConfirmDialog(null, Messages.getString("VentanaGuias.TextoAvisoEliminarGuia") + guia.getNombre() + " " + guia.getApellidos() + "?", Messages.getString("VentanaGuias.TituloAvisoEliminarGuia"), JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$

				if(JOptionPane.OK_OPTION==resp) {
					datos.guias.remove(guia);
					modeloGuias.removeElement(guia);
					
					txtNombre.setText(""); //$NON-NLS-1$
					txtApellidos.setText(""); //$NON-NLS-1$
					txtPuntuacion.setText(""); //$NON-NLS-1$
					txtIdiomas.setText(""); //$NON-NLS-1$
					ftxtTelefono.setText(""); //$NON-NLS-1$
					txtDisponibilidad.setText(""); //$NON-NLS-1$
					txtPrecioHora.setText(""); //$NON-NLS-1$
					ftxtDNI.setText(""); //$NON-NLS-1$
					
					
					foto = new ImageIcon(new ImageIcon("/presentacion/personagenerica.png").getImage().getScaledInstance(110, 110,Image.SCALE_SMOOTH)); //$NON-NLS-1$
					lblFotoGuia.setIcon(foto);
					
				}
			}else {
				JOptionPane.showMessageDialog(contentPanel, Messages.getString("VentanaGuias.TextoErrorEliminarGuiaNoSelec"), Messages.getString("VentanaGuias.TituloErrorEliminarGuiaNoSelec"), JOptionPane.ERROR_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}
	}

	
	private class BtnEditar_1ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			
			if(!listGuias.isSelectionEmpty()) {
				Guia guiaselec = (Guia) listGuias.getSelectedValue();
				AsignarRutas asignarrutas = new AsignarRutas(datos, guiaselec);
				asignarrutas.setVisible(true);
			}else {
				AsignarRutas asignarrutas = new AsignarRutas(datos, null);
				asignarrutas.setVisible(true);
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
		public void windowClosing(WindowEvent arg0) {
			abierta = false;
		}
	}

	public static void actualizarListRutas(ArrayList<Ruta> rutasNuevo) {
		listRutas.removeAll();
		modeloRutas.removeAllElements();
		for(int i = 0; i < rutasNuevo.size();i++) {
			modeloRutas.addElement(rutasNuevo.get(i));
		}
	}
	
	public boolean comprobarCampos(int op) {
		
		if(op == 1) {
			
			if(txtNombre.getText().equals("") || txtApellidos.getText().equals("") || txtPuntuacion.getText().equals("") || txtIdiomas.getText().equals("") || ftxtTelefono.getText().equals("") || txtDisponibilidad.getText().equals("") || txtPrecioHora.getText().equals("") || txtPrecioDia.getText().equals("") || ftxtDNI.getText().equals("") || rutaFoto.equals("")) { //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$
				return false;
			}
		}else if (op == 2){
			if(txtNombre.getText().equals("") || txtApellidos.getText().equals("") || txtPuntuacion.getText().equals("") || txtIdiomas.getText().equals("") || ftxtTelefono.getText().equals("") || txtDisponibilidad.getText().equals("") || txtPrecioHora.getText().equals("") || txtPrecioDia.getText().equals("") || ftxtDNI.getText().equals("")) { //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$
				return false;
			}
		}
		return true;		
	}
	
	public boolean getEstado() {
		return this.abierta;
	}
}
