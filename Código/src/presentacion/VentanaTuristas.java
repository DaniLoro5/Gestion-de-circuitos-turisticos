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

import datos.DatosPrueba;
import dominio.GrupoTuristas;
import dominio.Turista;

import javax.swing.JTabbedPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.MaskFormatter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.WindowConstants;
import java.awt.Font;

/**
 * @author Daniel Loro Durán
 */
public class VentanaTuristas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JComboBox cbTipo;
	private JLabel lblNDeIntegrantes;
	private JLabel lblDescripcin;
	private JTextArea txtDescripcion;
	private JLabel lblRestricciones;
	private JLabel lblIntereses;
	private JTextArea txtIntereses;
	private JButton btnAnadirTurista;
	private JButton btnGuardarTurista;
	private JButton btnEliminarTurista;
	private JButton btnAnadirGrupo;
	private JButton btnGuardarGrupo;
	private JButton btnEliminarGrupo;
	private JTextArea txtRestricciones;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JLabel lblDni;
	private JLabel lblApellidos;
	private JTextField txtApellidos;
	private JLabel lblEdad;
	private JButton btnEditar;
	private JLabel lblTelfonoDeContacto;
	private JLabel lblCorreoElectrnico;
	private JTextField txtCorreo;
	private JLabel lblNombreDelGrupo;
	private JTextField txtNombreGrupo;
	private JFormattedTextField ftxtDNI;
	private JScrollPane spListaGrupos;
	private JList listGrupoTuristas;
	private JLabel lblGrupos;
	private JScrollPane spTuristas;
	private JList listTuristas;
	private JLabel lblTuristas;
	private JScrollPane spFotoTurista;
	private JLabel lblFoto;
	private ImageIcon foto;
	private DatosPrueba datos;
	private JTextField txtNumIntegrantes;
	private JFormattedTextField ftxtTelefono;
	private JSpinner spinnerEdad;
	
	DefaultListModel<GrupoTuristas> modeloGrupos;
	DefaultListModel<Turista> modeloTuristas;
	private String rutaFoto = "/presentacion/personagenerica.png"; //$NON-NLS-1$
	
	private boolean abierta = false;


	/**
	 * Create the dialog.
	 */
	
	public VentanaTuristas(DatosPrueba datos) {
		setModal(false);
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		addWindowListener(new ThisWindowListener());
		this.datos = datos;
		this.abierta = true;
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaTuristas.class.getResource("/presentacion/grupo.png"))); //$NON-NLS-1$
		setTitle(Messages.getString("VentanaTuristas.this.title")); //$NON-NLS-1$
		setResizable(false);
		setBounds(100, 100, 706, 360);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			spListaGrupos = new JScrollPane();
			spListaGrupos.setBounds(5, 5, 90, 320);
			contentPanel.add(spListaGrupos);
			{
				listGrupoTuristas = new JList();
				modeloGrupos = new DefaultListModel<GrupoTuristas>();
				
				for(int i = 0; i< datos.grupoTurista.size();i++) {
					modeloGrupos.addElement(datos.grupoTurista.get(i));
				}
				
				listGrupoTuristas.setModel(modeloGrupos);
				listGrupoTuristas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				listGrupoTuristas.addListSelectionListener(new ListListSelectionListener());
				spListaGrupos.setViewportView(listGrupoTuristas);
			}
			{
				lblGrupos = new JLabel(Messages.getString("VentanaTuristas.lblGrupos.text")); //$NON-NLS-1$
				spListaGrupos.setColumnHeaderView(lblGrupos);
			}
		}
		{
			JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setBounds(102, 5, 594, 320);
			contentPanel.add(tabbedPane);
			{
				JPanel btnInformacionGrupo = new JPanel();
				tabbedPane.addTab(Messages.getString("VentanaTuristas.TabInformacionGrupo"), null, btnInformacionGrupo, null); //$NON-NLS-1$
				btnInformacionGrupo.setLayout(null);
				{
					JLabel lblTipoDeGrupo = new JLabel(Messages.getString("VentanaTuristas.lblTipoDeGrupo.text")); //$NON-NLS-1$
					lblTipoDeGrupo.setBounds(22, 46, 87, 14);
					btnInformacionGrupo.add(lblTipoDeGrupo);
				}
				{
					cbTipo = new JComboBox();
					cbTipo.setModel(new DefaultComboBoxModel(new String[] {Messages.getString("VentanaTuristas.CbTipo1"), Messages.getString("VentanaTuristas.CbTipo2"), Messages.getString("VentanaTuristas.CbTipo3")})); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					cbTipo.setBounds(120, 43, 100, 20);
					btnInformacionGrupo.add(cbTipo);
				}
				{
					lblNDeIntegrantes = new JLabel(Messages.getString("VentanaTuristas.lblNDeIntegrantes.text")); //$NON-NLS-1$
					lblNDeIntegrantes.setBounds(363, 11, 100, 14);
					btnInformacionGrupo.add(lblNDeIntegrantes);
				}
				{
					lblDescripcin = new JLabel(Messages.getString("VentanaTuristas.lblDescripcin.text")); //$NON-NLS-1$
					lblDescripcin.setBounds(22, 71, 77, 14);
					btnInformacionGrupo.add(lblDescripcin);
				}
				{
					txtDescripcion = new JTextArea();
					txtDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 11));
					txtDescripcion.setLineWrap(true);
					txtDescripcion.addFocusListener(new MiFocusListener());
					txtDescripcion.setBounds(22, 96, 515, 52);
					btnInformacionGrupo.add(txtDescripcion);
				}
				{
					lblRestricciones = new JLabel(Messages.getString("VentanaTuristas.lblRestricciones.text")); //$NON-NLS-1$
					lblRestricciones.setBounds(22, 159, 114, 14);
					btnInformacionGrupo.add(lblRestricciones);
				}
				{
					lblIntereses = new JLabel(Messages.getString("VentanaTuristas.lblIntereses.text")); //$NON-NLS-1$
					lblIntereses.setBounds(303, 159, 94, 14);
					btnInformacionGrupo.add(lblIntereses);
				}
				{
					txtIntereses = new JTextArea();
					txtIntereses.setFont(new Font("Tahoma", Font.PLAIN, 11));
					txtIntereses.setLineWrap(true);
					txtIntereses.addFocusListener(new MiFocusListener());
					txtIntereses.setBounds(303, 184, 234, 52);
					btnInformacionGrupo.add(txtIntereses);
				}
				{
					btnAnadirGrupo = new JButton(Messages.getString("VentanaTuristas.btnAnadirGrupo.text")); //$NON-NLS-1$
					btnAnadirGrupo.setToolTipText(Messages.getString("VentanaTuristas.btnAnadirGrupo.toolTipText")); //$NON-NLS-1$
					btnAnadirGrupo.addActionListener(new BtnAnadirGrupoActionListener());
					btnAnadirGrupo.setIcon(new ImageIcon(VentanaTuristas.class.getResource("/presentacion/add.png"))); //$NON-NLS-1$
					btnAnadirGrupo.setBounds(22, 247, 140, 35);
					btnInformacionGrupo.add(btnAnadirGrupo);
				}
				{
					btnGuardarGrupo = new JButton(Messages.getString("VentanaTuristas.btnGuardarGrupo.text")); //$NON-NLS-1$
					btnGuardarGrupo.setToolTipText(Messages.getString("VentanaTuristas.btnGuardarGrupo.toolTipText")); //$NON-NLS-1$
					btnGuardarGrupo.addActionListener(new BtnGuardarGrupoActionListener());
					btnGuardarGrupo.setEnabled(false);
					btnGuardarGrupo.setIcon(new ImageIcon(VentanaTuristas.class.getResource("/presentacion/guardar.png"))); //$NON-NLS-1$
					btnGuardarGrupo.setBounds(191, 247, 162, 35);
					btnInformacionGrupo.add(btnGuardarGrupo);
				}
				{
					btnEliminarGrupo = new JButton(Messages.getString("VentanaTuristas.btnEliminarGrupo.text")); //$NON-NLS-1$
					btnEliminarGrupo.setToolTipText(Messages.getString("VentanaTuristas.btnEliminarGrupo.toolTipText")); //$NON-NLS-1$
					btnEliminarGrupo.setEnabled(false);
					btnEliminarGrupo.addActionListener(new BtnEliminarGrupoActionListener());
					btnEliminarGrupo.setIcon(new ImageIcon(VentanaTuristas.class.getResource("/presentacion/eliminar.png"))); //$NON-NLS-1$
					btnEliminarGrupo.setBounds(377, 247, 160, 35);
					btnInformacionGrupo.add(btnEliminarGrupo);
				}
				{
					txtRestricciones = new JTextArea();
					txtRestricciones.setFont(new Font("Tahoma", Font.PLAIN, 11));
					txtRestricciones.setLineWrap(true);
					txtRestricciones.addFocusListener(new MiFocusListener());
					txtRestricciones.setBounds(22, 184, 234, 52);
					btnInformacionGrupo.add(txtRestricciones);
				}
				{
					lblNombreDelGrupo = new JLabel(Messages.getString("VentanaTuristas.lblNombreDelGrupo.text")); //$NON-NLS-1$
					lblNombreDelGrupo.setBounds(22, 11, 107, 14);
					btnInformacionGrupo.add(lblNombreDelGrupo);
				}
				{
					txtNombreGrupo = new JTextField();
					txtNombreGrupo.setBounds(120, 8, 100, 20);
					btnInformacionGrupo.add(txtNombreGrupo);
					txtNombreGrupo.addFocusListener(new MiFocusListener());
					txtNombreGrupo.setColumns(10);
				}
				{
					txtNumIntegrantes = new JTextField();
					txtNumIntegrantes.setEditable(false);
					txtNumIntegrantes.setBounds(469, 8, 68, 20);
					btnInformacionGrupo.add(txtNumIntegrantes);
					txtNumIntegrantes.setColumns(10);
				}
			}
			{
				JPanel btnInformacionTuristas = new JPanel();
				tabbedPane.addTab(Messages.getString("VentanaTuristas.TabTuristaSeleccionado"), null, btnInformacionTuristas, null); //$NON-NLS-1$
				btnInformacionTuristas.setLayout(null);
				{
					spTuristas = new JScrollPane();
					spTuristas.setBounds(0, 0, 90, 282);
					btnInformacionTuristas.add(spTuristas);
					{
						listTuristas = new JList();
						listTuristas.addListSelectionListener(new ListTuristasListSelectionListener());
						modeloTuristas = new DefaultListModel<Turista>();
						
//						for(int i = 0; i<datos.)
						
						listTuristas.setModel(modeloTuristas);
						listTuristas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						spTuristas.setViewportView(listTuristas);
					}
					{
						lblTuristas = new JLabel(Messages.getString("VentanaTuristas.lblTuristas.text")); //$NON-NLS-1$
						spTuristas.setColumnHeaderView(lblTuristas);
					}
				}
				{
					btnAnadirTurista = new JButton(Messages.getString("VentanaTuristas.btnAnadirTurista.text")); //$NON-NLS-1$
					btnAnadirTurista.setToolTipText(Messages.getString("VentanaTuristas.btnAnadirTurista.toolTipText")); //$NON-NLS-1$
					btnAnadirTurista.addActionListener(new BtnAnadirTuristaActionListener());
					btnAnadirTurista.setIcon(new ImageIcon(VentanaTuristas.class.getResource("/presentacion/add.png"))); //$NON-NLS-1$
					btnAnadirTurista.setBounds(94, 246, 151, 35);
					btnInformacionTuristas.add(btnAnadirTurista);
				}
				{
					btnGuardarTurista = new JButton(Messages.getString("VentanaTuristas.btnGuardarTurista.text")); //$NON-NLS-1$
					btnGuardarTurista.setToolTipText(Messages.getString("VentanaTuristas.btnGuardarTurista.toolTipText")); //$NON-NLS-1$
					btnGuardarTurista.addActionListener(new BtnGuardarTuristaActionListener());
					btnGuardarTurista.setEnabled(false);
					btnGuardarTurista.setIcon(new ImageIcon(VentanaTuristas.class.getResource("/presentacion/guardar.png"))); //$NON-NLS-1$
					btnGuardarTurista.setBounds(255, 246, 169, 35);
					btnInformacionTuristas.add(btnGuardarTurista);
				}
				{
					btnEliminarTurista = new JButton(Messages.getString("VentanaTuristas.btnEliminarTurista.text")); //$NON-NLS-1$
					btnEliminarTurista.setToolTipText(Messages.getString("VentanaTuristas.btnEliminarTurista.toolTipText")); //$NON-NLS-1$
					btnEliminarTurista.setEnabled(false);
					btnEliminarTurista.addActionListener(new BtnEliminarTuristaActionListener());
					btnEliminarTurista.setIcon(new ImageIcon(VentanaTuristas.class.getResource("/presentacion/eliminar.png"))); //$NON-NLS-1$
					btnEliminarTurista.setBounds(434, 246, 151, 35);
					btnInformacionTuristas.add(btnEliminarTurista);
				}
				{
					lblNombre = new JLabel(Messages.getString("VentanaTuristas.lblNombre.text")); //$NON-NLS-1$
					lblNombre.setBounds(223, 27, 46, 14);
					btnInformacionTuristas.add(lblNombre);
				}
				{
					txtNombre = new JTextField();
					txtNombre.setBounds(223, 52, 272, 20);
					txtNombre.addFocusListener(new MiFocusListener());
					btnInformacionTuristas.add(txtNombre);
					txtNombre.setColumns(10);
				}
				{
					lblDni = new JLabel(Messages.getString("VentanaTuristas.lblDni.text")); //$NON-NLS-1$
					lblDni.setBounds(223, 139, 46, 14);
					btnInformacionTuristas.add(lblDni);
				}
				{
					lblApellidos = new JLabel(Messages.getString("VentanaTuristas.lblApellidos.text")); //$NON-NLS-1$
					lblApellidos.setBounds(223, 83, 66, 14);
					btnInformacionTuristas.add(lblApellidos);
				}
				{
					txtApellidos = new JTextField();
					txtApellidos.setBounds(223, 108, 272, 20);
					txtApellidos.addFocusListener(new MiFocusListener());
					btnInformacionTuristas.add(txtApellidos);
					txtApellidos.setColumns(10);
				}
				{
					lblEdad = new JLabel(Messages.getString("VentanaTuristas.lblEdad.text")); //$NON-NLS-1$
					lblEdad.setBounds(512, 27, 46, 14);
					btnInformacionTuristas.add(lblEdad);
				}
				{
					btnEditar = new JButton(Messages.getString("VentanaTuristas.btnEditar.text")); //$NON-NLS-1$
					btnEditar.addActionListener(new BtnEditarActionListener());
					btnEditar.setIcon(new ImageIcon(VentanaTuristas.class.getResource("/presentacion/camara.png"))); //$NON-NLS-1$
					btnEditar.setBounds(94, 159, 119, 23);
					btnInformacionTuristas.add(btnEditar);
				}
				{
					lblTelfonoDeContacto = new JLabel(Messages.getString("VentanaTuristas.lblTelfonoDeContacto.text")); //$NON-NLS-1$
					lblTelfonoDeContacto.setBounds(365, 139, 146, 14);
					btnInformacionTuristas.add(lblTelfonoDeContacto);
				}
				{
					lblCorreoElectrnico = new JLabel(Messages.getString("VentanaTuristas.lblCorreoElectrnico.text")); //$NON-NLS-1$
					lblCorreoElectrnico.setBounds(94, 193, 107, 14);
					btnInformacionTuristas.add(lblCorreoElectrnico);
				}
				{
					txtCorreo = new JTextField();
					txtCorreo.setBounds(94, 215, 242, 20);
					txtCorreo.addFocusListener(new MiFocusListener());
					btnInformacionTuristas.add(txtCorreo);
					txtCorreo.setColumns(10);
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

					
					ftxtDNI.setBounds(223, 160, 110, 20);
					ftxtDNI.addFocusListener(new MiFocusListener());
					btnInformacionTuristas.add(ftxtDNI);
				}
				{
					spFotoTurista = new JScrollPane();
					spFotoTurista.setBounds(94, 27, 119, 119);
					btnInformacionTuristas.add(spFotoTurista);
					{
						lblFoto = new JLabel(""); //$NON-NLS-1$
						lblFoto.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/presentacion/personagenerica.png")).getImage().getScaledInstance(115, 115, Image.SCALE_SMOOTH))); //$NON-NLS-1$
						spFotoTurista.setViewportView(lblFoto);
					}
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

					
					ftxtTelefono.setBounds(368, 160, 127, 20);
					ftxtTelefono.addFocusListener(new MiFocusListener());
					btnInformacionTuristas.add(ftxtTelefono);
				}
				{
					spinnerEdad = new JSpinner();
					spinnerEdad.setModel(new SpinnerNumberModel(0, 0, 100, 1));
					spinnerEdad.setBounds(512, 52, 50, 20);
					spinnerEdad.addFocusListener(new MiFocusListener());
					btnInformacionTuristas.add(spinnerEdad);
				}
			}
		}
	}
	

	private class ListListSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent arg0) {
			
			if(!listGrupoTuristas.isSelectionEmpty()) {
				
				btnGuardarGrupo.setEnabled(true);
				btnEliminarGrupo.setEnabled(true);
				
				GrupoTuristas grupo = (GrupoTuristas) listGrupoTuristas.getSelectedValue();
				txtNombreGrupo.setText(grupo.getNombreGrupo());
				txtDescripcion.setText(grupo.getDescripcion());
				txtRestricciones.setText(grupo.getRestricciones());
				txtIntereses.setText(grupo.getIntereses());
				cbTipo.setSelectedItem(grupo.getTipo());
				txtNumIntegrantes.setText(Integer.toString(grupo.getNumIntegrantes()));
				
				modeloTuristas.removeAllElements();
				
				for(int i = 0; i < grupo.getTuristas().size(); i++) {
					modeloTuristas.addElement(grupo.getTuristas().get(i));
				}
				
				txtNombre.setText(""); //$NON-NLS-1$
				txtApellidos.setText(""); //$NON-NLS-1$
				ftxtDNI.setText(""); //$NON-NLS-1$
				ftxtTelefono.setText(""); //$NON-NLS-1$
				txtCorreo.setText(""); //$NON-NLS-1$
				spinnerEdad.setValue(0);
				
				foto = new ImageIcon(new ImageIcon(getClass().getResource("/presentacion/personagenerica.png")).getImage().getScaledInstance(115, 115, Image.SCALE_SMOOTH)); //$NON-NLS-1$
				lblFoto.setIcon(foto);
			}
			
		}
	}
	
	private class BtnAnadirGrupoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			if(comprobarCampos(1)) {
				
				GrupoTuristas grupo = new GrupoTuristas(txtNombreGrupo.getText(), cbTipo.getSelectedItem().toString(), txtDescripcion.getText(), txtIntereses.getText(), txtRestricciones.getText());
				modeloGrupos.addElement(grupo);
				datos.grupoTurista.add(grupo);
			}else {
				JOptionPane.showMessageDialog(contentPanel, Messages.getString("VentanaTuristas.TextoAvisoAñadir"), Messages.getString("VentanaTuristas.TituloAvisoAñadir"), JOptionPane.WARNING_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
			}
			
		}
	}
	
	private class BtnGuardarGrupoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			if(!listGrupoTuristas.isSelectionEmpty()) {
				
				GrupoTuristas grupo = (GrupoTuristas) listGrupoTuristas.getSelectedValue();
				
				if(comprobarCampos(1)) {
					
					grupo.setNombreGrupo(txtNombreGrupo.getText());
					grupo.setDescripcion(txtDescripcion.getText());
					grupo.setRestricciones(txtRestricciones.getText());
					grupo.setIntereses(txtIntereses.getText());
					grupo.setTipo(cbTipo.getSelectedItem().toString());
					
					JOptionPane.showMessageDialog(contentPanel, Messages.getString("VentanaTuristas.TextoAvisoModificado"), Messages.getString("VentanaTuristas.TituloAvisoModificar"), JOptionPane.INFORMATION_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
					
				}else {
					JOptionPane.showMessageDialog(contentPanel, Messages.getString("VentanaTuristas.TextoAvisoModificar"), Messages.getString("VentanaTuristas.TituloErrorModificar"), JOptionPane.WARNING_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
				}
				
			}else {
				
				JOptionPane.showMessageDialog(contentPanel, Messages.getString("VentanaTuristas.TextoAvisoGrupoNo"), Messages.getString("VentanaTuristas.TituloAvisoGrupoNo"), JOptionPane.ERROR_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
				
			}
			
		}
	}
	
	private class BtnEliminarGrupoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			if(!listGrupoTuristas.isSelectionEmpty()) {
				
				GrupoTuristas grupo = (GrupoTuristas) listGrupoTuristas.getSelectedValue();
				
				int resp=JOptionPane.showConfirmDialog(null, Messages.getString("VentanaTuristas.TextoConfirmacionEliminarGrupo")+ grupo.getNombreGrupo()+Messages.getString("VentanaTuristas.Texto2ConfirmacionEliminarGrupo"), Messages.getString("VentanaTuristas.TituloAvisoEliminarGrupo"), JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

				if(JOptionPane.OK_OPTION==resp) {
					
					for(int i = 0; i < grupo.getTuristas().size(); i++) {
						datos.turistasGeneral.remove(grupo.getTuristas().get(i));
					}
					listTuristas.repaint();
					modeloGrupos.removeElement(grupo);
					datos.grupoTurista.remove(grupo);
					
				}
			}else {
				
				JOptionPane.showMessageDialog(contentPanel, Messages.getString("VentanaTuristas.TextoAvisoEliminarGrupo"), Messages.getString("VentanaTuristas.TituloErrorEliminarGrupo"), JOptionPane.ERROR_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
				
			}
			

		}
	}
	
	private class ListTuristasListSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent arg0) {
			
			if(!listTuristas.isSelectionEmpty()) {
				
				btnGuardarTurista.setEnabled(true);
				btnEliminarTurista.setEnabled(true);
				
				Turista turista = (Turista) listTuristas.getSelectedValue();
				
				txtNombre.setText(turista.getNombre());
				txtApellidos.setText(turista.getApellidos());
				ftxtDNI.setText(turista.getDni());
				ftxtTelefono.setText(turista.getTelefono());
				txtCorreo.setText(turista.getCorreo());
				spinnerEdad.setValue(turista.getEdad());
		
				Path p = Paths.get(turista.getFoto());
				
				if(p.isAbsolute()) {
					foto = new ImageIcon(new ImageIcon(turista.getFoto()).getImage().getScaledInstance(115, 115, Image.SCALE_SMOOTH));
				}else {
					foto = new ImageIcon(new ImageIcon(getClass().getResource(turista.getFoto())).getImage().getScaledInstance(115, 115, Image.SCALE_SMOOTH));
				}
				
				lblFoto.setIcon(foto);
				
			}
			
		}
	}
	
	private class BtnAnadirTuristaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			if(!listGrupoTuristas.isSelectionEmpty()) {
				
				GrupoTuristas grupo = (GrupoTuristas) listGrupoTuristas.getSelectedValue();
				
				if(comprobarCampos(2)) {
					
					Turista turista = new Turista(txtNombre.getText(), txtApellidos.getText(), ftxtDNI.getText(), ftxtTelefono.getText(), txtCorreo.getText(), rutaFoto, (Integer)spinnerEdad.getValue());
					modeloTuristas.addElement(turista);
					grupo.getTuristas().add(turista);
					grupo.setNumIntegrantes();

					txtNumIntegrantes.setText(Integer.toString(grupo.getNumIntegrantes()));

					
				}else {
					
					JOptionPane.showMessageDialog(contentPanel, Messages.getString("VentanaTuristas.TextoAvisoAñadirTurista"), Messages.getString("VentanaTuristas.TituloErrorAñadirTurista"), JOptionPane.WARNING_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
				}
				
			}else {
				
				JOptionPane.showMessageDialog(contentPanel, Messages.getString("VentanaTuristas.TextoTuristaGrupoNo"), Messages.getString("VentanaTuristas.TituloErrorTuristaGrupoNo"), JOptionPane.ERROR_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
			}
			
		}
	}
	
	private class BtnGuardarTuristaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			if(!listTuristas.isSelectionEmpty()) {
				
				Turista turista = (Turista) listTuristas.getSelectedValue();
				
				String fotoAntigua = turista.getFoto();
				
				if(comprobarCampos(2)) {
					
					turista.setNombre(txtNombre.getText());
					turista.setApellidos(txtApellidos.getText());
					turista.setDni(ftxtDNI.getText());
					turista.setTelefono(ftxtTelefono.getText());
					turista.setCorreo(txtCorreo.getText());
					turista.setEdad((Integer)spinnerEdad.getValue());
					
					if(!rutaFoto.equals(fotoAntigua)) {
						turista.setFoto(rutaFoto);
					}
					
					JOptionPane.showMessageDialog(contentPanel, Messages.getString("VentanaTuristas.TextoTuristaModificado"), Messages.getString("VentanaTuristas.TituloTuristaModificado"), JOptionPane.INFORMATION_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
					
				}else {
					JOptionPane.showMessageDialog(contentPanel, Messages.getString("VentanaTuristas.TextoErrorTuristaModificar"), Messages.getString("VentanaTuristas.TituloErrorTuristaModificar"), JOptionPane.WARNING_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
				}
				
			}else {
				
				JOptionPane.showMessageDialog(contentPanel, Messages.getString("VentanaTuristas.TextoErrorTuristaMod"), Messages.getString("VentanaTuristas.TtuloErrorTuristaMod"), JOptionPane.ERROR_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
		
			}
			
		}
	}
	
	private class BtnEliminarTuristaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			if(!listGrupoTuristas.isSelectionEmpty()) {
				
				GrupoTuristas grupo = (GrupoTuristas) listGrupoTuristas.getSelectedValue();
				
				if(!listTuristas.isSelectionEmpty()) {
					
					Turista turista = (Turista) listTuristas.getSelectedValue();
					
					int resp=JOptionPane.showConfirmDialog(null, Messages.getString("VentanaTuristas.TextoConfirmarEliminarTurista")+ turista.getNombre()+" "+turista.getApellidos() +"?", Messages.getString("VentanaTuristas.TituloConfirmarEliminarTurista"), JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$

					if(JOptionPane.OK_OPTION==resp) {
						modeloTuristas.removeElement(turista);
						datos.turistasGeneral.remove(turista);
						grupo.getTuristas().remove(turista);
						grupo.setNumIntegrantes();
						
						txtNombre.setText(""); //$NON-NLS-1$
						txtApellidos.setText(""); //$NON-NLS-1$
						ftxtDNI.setText(""); //$NON-NLS-1$
						ftxtTelefono.setText(""); //$NON-NLS-1$
						txtCorreo.setText(""); //$NON-NLS-1$
						spinnerEdad.setValue(0);
						
						foto = new ImageIcon(new ImageIcon(getClass().getResource("/presentacion/personagenerica.png")).getImage().getScaledInstance(115, 115, Image.SCALE_SMOOTH)); //$NON-NLS-1$
						lblFoto.setIcon(foto);
						
						txtNumIntegrantes.setText(Integer.toString(grupo.getNumIntegrantes()));
					}else {
						JOptionPane.showMessageDialog(contentPanel, Messages.getString("VentanaTuristas.TextoErrorEliminarTurista"), Messages.getString("VentanaTuristas.TituloErrorEliminarTurista"), JOptionPane.ERROR_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$

					}
				}
				
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
				foto = new ImageIcon(new ImageIcon(file.getAbsolutePath()).getImage().getScaledInstance(119, 119,Image.SCALE_SMOOTH));
				lblFoto.setIcon(foto);
				
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
			
			boolean cerrar = true;
			
			for(int i = 0; i < modeloGrupos.size();i++) {
				
				GrupoTuristas grupo = (GrupoTuristas) modeloGrupos.getElementAt(i);
				
				if(grupo.getTuristas().size() < 4 || grupo.getTuristas().size() > 20) {
					cerrar = false;
				}
			}
			
			if(!cerrar) {
				JOptionPane.showMessageDialog(contentPanel, Messages.getString("VentanaTuristas.TextoErrorTamañoGrupo"), Messages.getString("VentanaTuristas.TituloErrorTamañoGrupo"), JOptionPane.ERROR_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
			}else {
				abierta = false;
				dispose();
			}
			
		}
	}

	public boolean getEstado() {
		return this.abierta;
	}
	
	private boolean comprobarCampos(int op) {
		
		if(op==1) {
			
			if(txtNombreGrupo.getText().equals("") || cbTipo.getSelectedItem().toString().equals("") || txtDescripcion.getText().equals("") || txtIntereses.getText().equals("") || txtRestricciones.getText().equals("")) {	 //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
				return false;	
			}
		
		}else if(op==2) {
			
			if(txtNombre.getText().equals("") || txtApellidos.getText().equals("") || ftxtDNI.getText().equals("") || ftxtTelefono.getText().equals("") || txtCorreo.getText().equals("") || spinnerEdad.getValue().toString().equals("")) {	 //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
				return false;		
			}
		}		
		return true;
	}
}
