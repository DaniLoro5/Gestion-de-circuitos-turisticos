package presentacion;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import javax.swing.SwingConstants;

import datos.DatosPrueba;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import dominio.*;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.awt.event.ItemEvent;

/**
 * @author Daniel Loro Durán
 */
public class panelRutasPredefinidas extends JPanel {
	private JLabel lblLocalidad;
	private JTextField txtLocalidad;
	private JLabel lblPuntoInteres;
	private JComboBox cbPuntoInteres;
	private JButton btnAnadir;
	private JButton btnQuitar;
	private JButton btnDisenoNuevaRuta;
	private JSeparator separator;
	private JPanel panel;
	private JScrollPane spRutas;
	private static JList listRutas;
	private JLabel lblRutas;
	private JScrollPane spNoRealizar;
	private JSeparator separator_1;
	private JScrollPane spRealizar;
	private JList listNoRealizada;
	private JList listRealizada;
	private JLabel lblNoHanRealizado;
	private JLabel lblVanARealizar;
	private DatosPrueba datos;
	
	static DefaultListModel modeloRutas;
	DefaultListModel modeloRealizarRuta;
	DefaultListModel modeloNoRealizarRuta;
	DefaultComboBoxModel modeloPuntoInteres;
	
	private VentanaDisenoRuta ventanadiseno;

	/**
	 * Create the panel.
	 */
	public panelRutasPredefinidas(DatosPrueba datos) {
		this.datos = datos;
		setLayout(null);
		{
			spRutas = new JScrollPane();
			spRutas.setBounds(10, 11, 117, 458);
			spRutas.setMaximumSize(new Dimension(200, 200));
			add(spRutas);
			{
				listRutas = new JList();
				listRutas.addListSelectionListener(new ListRutasListSelectionListener());
				modeloRutas = new DefaultListModel();
				
				for(int i = 0; i < datos.rutas.size();i++) {
					modeloRutas.addElement(datos.rutas.get(i));
				}
				
				listRutas.setModel(modeloRutas);
				listRutas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				spRutas.setViewportView(listRutas);
			}
			{
				lblRutas = new JLabel(Messages.getString("panelRutasPredefinidas.lblRutas.text")); //$NON-NLS-1$
				lblRutas.setHorizontalAlignment(SwingConstants.CENTER);
				spRutas.setColumnHeaderView(lblRutas);
			}
		}
		{
			lblLocalidad = new JLabel(Messages.getString("panelRutasPredefinidas.lblLocalidad.text")); //$NON-NLS-1$
			lblLocalidad.setBounds(140, 16, 81, 14);
			add(lblLocalidad);
		}
		{
			panel = new panelInformacionPunto();
			panel.setBounds(280, 12, 419, 249);
			add(panel);
		}
		{
			txtLocalidad = new JTextField();
			txtLocalidad.setEditable(false);
			txtLocalidad.setBounds(137, 35, 133, 20);
			add(txtLocalidad);
			txtLocalidad.setColumns(10);
		}
		{
			lblPuntoInteres = new JLabel(Messages.getString("panelRutasPredefinidas.lblPuntoInteres.text")); //$NON-NLS-1$
			lblPuntoInteres.setBounds(137, 66, 122, 14);
			add(lblPuntoInteres);
		}
		{
			cbPuntoInteres = new JComboBox();
			cbPuntoInteres.setEnabled(false);
			cbPuntoInteres.addItemListener(new ItemChangeListener());
			modeloPuntoInteres = new DefaultComboBoxModel();
			cbPuntoInteres.setBounds(137, 85, 133, 20);
			add(cbPuntoInteres);
		}
		{
			btnAnadir = new JButton(Messages.getString("panelRutasPredefinidas.btnAnadir.text")); //$NON-NLS-1$
			btnAnadir.setEnabled(false);
			btnAnadir.setToolTipText(Messages.getString("panelRutasPredefinidas.btnAnadir.toolTipText")); //$NON-NLS-1$
			btnAnadir.addActionListener(new BtnAnadirActionListener());
			btnAnadir.setBounds(365, 303, 106, 33);
			btnAnadir.setIcon(new ImageIcon(panelRutasPredefinidas.class.getResource("/presentacion/flechaDer.png"))); //$NON-NLS-1$
			add(btnAnadir);
		}
		{
			btnQuitar = new JButton(Messages.getString("panelRutasPredefinidas.btnQuitar.text")); //$NON-NLS-1$
			btnQuitar.setEnabled(false);
			btnQuitar.setToolTipText(Messages.getString("panelRutasPredefinidas.btnQuitar.toolTipText")); //$NON-NLS-1$
			btnQuitar.addActionListener(new BtnQuitarActionListener());
			btnQuitar.setBounds(365, 369, 106, 33);
			btnQuitar.setIcon(new ImageIcon(panelRutasPredefinidas.class.getResource("/presentacion/flechaIzq.png"))); //$NON-NLS-1$
			add(btnQuitar);
		}
		{
			separator = new JSeparator();
			separator.setBounds(137, 428, 562, 3);
			add(separator);
		}
		{
			btnDisenoNuevaRuta = new JButton(Messages.getString("panelRutasPredefinidas.btnDisenoNuevaRuta.text")); //$NON-NLS-1$
			btnDisenoNuevaRuta.addActionListener(new BtnDisenoNuevaRutaActionListener());
			btnDisenoNuevaRuta.setIcon(new ImageIcon(panelRutasPredefinidas.class.getResource("/presentacion/ruta.png"))); //$NON-NLS-1$
			btnDisenoNuevaRuta.setBounds(137, 436, 562, 33);
			add(btnDisenoNuevaRuta);
		}
		{
			spRealizar = new JScrollPane();
			spRealizar.setBounds(499, 283, 200, 137);
			add(spRealizar);
			{
				listRealizada = new JList();
				modeloRealizarRuta = new DefaultListModel();			
				listRealizada.setModel(modeloRealizarRuta);
				listRealizada.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				spRealizar.setViewportView(listRealizada);
			}
			{
				lblVanARealizar = new JLabel(Messages.getString("panelRutasPredefinidas.lblVanARealizar.text")); //$NON-NLS-1$
				lblVanARealizar.setHorizontalAlignment(SwingConstants.CENTER);
				spRealizar.setColumnHeaderView(lblVanARealizar);
			}
		}
		{
			spNoRealizar = new JScrollPane();
			spNoRealizar.setBounds(137, 283, 200, 137);
			add(spNoRealizar);
			{
				listNoRealizada = new JList();
				modeloNoRealizarRuta = new DefaultListModel();
				listNoRealizada.setModel(modeloNoRealizarRuta);
				listNoRealizada.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				spNoRealizar.setViewportView(listNoRealizada);
			}
			{
				lblNoHanRealizado = new JLabel(Messages.getString("panelRutasPredefinidas.lblNoHanRealizado.text")); //$NON-NLS-1$
				lblNoHanRealizado.setHorizontalAlignment(SwingConstants.CENTER);
				spNoRealizar.setColumnHeaderView(lblNoHanRealizado);
			}
		}
		{
			separator_1 = new JSeparator();
			separator_1.setBounds(137, 272, 562, 2);
			add(separator_1);
		}

	}
	private class BtnAnadirActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			if(!listNoRealizada.isSelectionEmpty()) {
				Ruta rutaselec = (Ruta) listRutas.getSelectedValue();
				modeloRealizarRuta.addElement(listNoRealizada.getSelectedValue());
				rutaselec.getGrupoTuristas().add((GrupoTuristas) listNoRealizada.getSelectedValue());
				rutaselec.setTuristasTotal();
				modeloNoRealizarRuta.removeElement(listNoRealizada.getSelectedValue());
				
			}
			
		}
	}
	private class BtnQuitarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			if(!listRealizada.isSelectionEmpty()) {
				Ruta rutaselec = (Ruta) listRutas.getSelectedValue();
				modeloNoRealizarRuta.addElement(listRealizada.getSelectedValue());
				rutaselec.getGrupoTuristas().remove((GrupoTuristas)listRealizada.getSelectedValue());
				rutaselec.setTuristasTotal();
				modeloRealizarRuta.removeElement(listRealizada.getSelectedValue());
				
			}
			
		}
	}
	private class BtnDisenoNuevaRutaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			if(ventanadiseno == null || !ventanadiseno.getEstado()) {
				ventanadiseno = new VentanaDisenoRuta(datos);
				ventanadiseno.setVisible(true);
				ventanadiseno.setModal(true);
			}else {
				JOptionPane.showMessageDialog(null, Messages.getString("panelRutasPredefinidas.3"), Messages.getString("panelRutasPredefinidas.4"), JOptionPane.WARNING_MESSAGE);  //$NON-NLS-1$ //$NON-NLS-2$
			}
			
		}
	}
	private class ListRutasListSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent e) {
			
			if(!listRutas.isSelectionEmpty()) {

				Ruta rutaselec = (Ruta) listRutas.getSelectedValue();
				txtLocalidad.setText(rutaselec.getLocalidad());
				cbPuntoInteres.removeAllItems();
				if(rutaselec.getPuntoInteres().size()>0) {
					for(int i = 0; i < rutaselec.getPuntoInteres().size();i++) {
						modeloPuntoInteres.addElement(rutaselec.getPuntoInteres().get(i));
						cbPuntoInteres.addItem(rutaselec.getPuntoInteres().get(i));
					}
					
					cbPuntoInteres.setSelectedItem(rutaselec.getPuntoInteres().get(0));

				}
				btnAnadir.setEnabled(true);
				btnQuitar.setEnabled(true);
				txtLocalidad.setEnabled(true);
				cbPuntoInteres.setEnabled(true);
				modeloRealizarRuta.removeAllElements();
				
				for(int i = 0; i < rutaselec.getGrupoTuristas().size();i++) {
					modeloRealizarRuta.addElement(rutaselec.getGrupoTuristas().get(i));
				}
				
				modeloNoRealizarRuta.removeAllElements();
				
				for(int i = 0; i < datos.grupoTurista.size();i++) {
					if(!modeloRealizarRuta.contains(datos.grupoTurista.get(i))) {
						modeloNoRealizarRuta.addElement(datos.grupoTurista.get(i));
					}
				}
			}
			
		}
	}
	
	private class ItemChangeListener implements ItemListener{
		@Override
		public void itemStateChanged(ItemEvent event) {
			if (event.getStateChange() == ItemEvent.SELECTED) {
				PuntoInteres item = (PuntoInteres) event.getItem();
				panelInformacionPunto.infoPunto(item);
			}else {
				panelInformacionPunto.infoPunto(null);
			}
		}       
	}
	
	public static void actualizarListRutas(Ruta ruta) {
		listRutas.removeAll();
		modeloRutas.addElement(ruta);
		listRutas.repaint();
		listRutas.revalidate();
	}

}
