package presentacion;

import java.awt.EventQueue;


import javax.swing.JDialog;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.ListSelectionModel;

import datos.*;
import dominio.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

/**
 * @author Daniel Loro Durán
 */
public class AsignarRutas extends JDialog {
	private JPanel panel;
	private JScrollPane spRutasNoAsignadas;
	private JScrollPane spRutasAsignadas;
	private JList listNoAsignadas;
	private JList listAsignadas;
	private JLabel lblRutasNoAsignadas;
	private JLabel lblRutasAsignadas;
	private JButton btnAnadir;
	private JButton btnQuitar;
	private JButton btnGuardar;
	private JLabel lblInfoGuia;
	
	private DatosPrueba datos;
	private Guia guia;
	private DefaultListModel modeloAsignadas;
	private DefaultListModel modeloNoAsignadas;

	/**
	 * Create the dialog.
	 */
	
	public AsignarRutas(DatosPrueba datos, Guia guia) {
		setTitle(Messages.getString("AsignarRutas.this.title")); //$NON-NLS-1$
		setIconImage(Toolkit.getDefaultToolkit().getImage(AsignarRutas.class.getResource("/presentacion/rutaTab.png"))); //$NON-NLS-1$
		this.guia = guia;
		this.datos = datos;
		setModal(true);
		setBounds(100, 100, 521, 448);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout(0, 0));
		{
			panel = new JPanel();
			getContentPane().add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			{
				spRutasAsignadas = new JScrollPane();
				spRutasAsignadas.setBounds(342, 41, 126, 308);
				panel.add(spRutasAsignadas);
				{
					listAsignadas = new JList();
					modeloAsignadas = new DefaultListModel<Ruta>();
					if(guia!=null) {
						for(int i = 0; i < guia.getRutas().size();i++) {
							modeloAsignadas.addElement(guia.getRutas().get(i));
						}
					}
					
					listAsignadas.setModel(modeloAsignadas);
					listAsignadas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					spRutasAsignadas.setViewportView(listAsignadas);
				}
				{
					lblRutasAsignadas = new JLabel(Messages.getString("AsignarRutas.lblRutasAsignadas.text")); //$NON-NLS-1$
					lblRutasAsignadas.setHorizontalAlignment(SwingConstants.CENTER);
					spRutasAsignadas.setColumnHeaderView(lblRutasAsignadas);
				}
			}
			
			{
				spRutasNoAsignadas = new JScrollPane();
				spRutasNoAsignadas.setBounds(33, 41, 126, 308);
				panel.add(spRutasNoAsignadas);
				{
					listNoAsignadas = new JList();
					modeloNoAsignadas = new DefaultListModel<Ruta>();

					
					if(guia!=null) {

						for(int i = 0;i < datos.rutas.size(); i++) {
							if(!modeloAsignadas.contains(datos.rutas.get(i))) {
								modeloNoAsignadas.addElement(datos.rutas.get(i));
							}
						}
					}else {
						for(int i = 0; i < datos.rutas.size(); i++) {
							modeloNoAsignadas.addElement(datos.rutas.get(i));
						}
					}
					
					listNoAsignadas.setModel(modeloNoAsignadas);
					
					listNoAsignadas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					spRutasNoAsignadas.setViewportView(listNoAsignadas);
				}
				{
					lblRutasNoAsignadas = new JLabel(Messages.getString("AsignarRutas.lblRutasNoAsignadas.text")); //$NON-NLS-1$
					lblRutasNoAsignadas.setHorizontalAlignment(SwingConstants.CENTER);
					spRutasNoAsignadas.setColumnHeaderView(lblRutasNoAsignadas);
				}
			}

			{
				btnAnadir = new JButton(Messages.getString("AsignarRutas.btnAnadir.text")); //$NON-NLS-1$
				btnAnadir.addActionListener(new BtnAnadirActionListener());
				btnAnadir.setIcon(new ImageIcon(AsignarRutas.class.getResource("/presentacion/flechaDer.png"))); //$NON-NLS-1$
				btnAnadir.setBounds(197, 117, 106, 33);
				panel.add(btnAnadir);
			}
			{
				btnQuitar = new JButton(Messages.getString("AsignarRutas.btnQuitar.text")); //$NON-NLS-1$
				btnQuitar.addActionListener(new BtnQuitarActionListener());
				btnQuitar.setIcon(new ImageIcon(AsignarRutas.class.getResource("/presentacion/flechaIzq.png"))); //$NON-NLS-1$
				btnQuitar.setBounds(197, 207, 106, 33);
				panel.add(btnQuitar);
			}
			{
				btnGuardar = new JButton(Messages.getString("AsignarRutas.btnGuardar.text")); //$NON-NLS-1$
				btnGuardar.addActionListener(new BtnGuardarActionListener());
				btnGuardar.setIcon(new ImageIcon(AsignarRutas.class.getResource("/presentacion/guardar.png"))); //$NON-NLS-1$
				btnGuardar.setBounds(170, 351, 162, 33);
				panel.add(btnGuardar);
			}
			{
				lblInfoGuia = new JLabel(""); //$NON-NLS-1$
				
				if(guia==null) {
					lblInfoGuia.setText(Messages.getString("AsignarRutas.TextoNuevoGuía")); //$NON-NLS-1$
				}else {
					lblInfoGuia.setText(Messages.getString("AsignarRutas.TextoGuiaYaCreado") + guia.getNombre() + " " + guia.getApellidos()); //$NON-NLS-1$ //$NON-NLS-2$
				}
				
				lblInfoGuia.setBounds(33, 16, 362, 14);
				panel.add(lblInfoGuia);
			}
		}

	}
	private class BtnGuardarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			ArrayList<Ruta> rutasAsignadas = new ArrayList<Ruta>();		
			for(int i = 0; i < modeloAsignadas.size(); i++) {
				rutasAsignadas.add((Ruta) modeloAsignadas.get(i));
			}		
			VentanaGuias.actualizarListRutas(rutasAsignadas);
			dispose();

		}
	}
	private class BtnAnadirActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			if(!listNoAsignadas.isSelectionEmpty()) {
				modeloAsignadas.addElement(listNoAsignadas.getSelectedValue());
				modeloNoAsignadas.removeElement(listNoAsignadas.getSelectedValue());
			}
			
		}
	}
	private class BtnQuitarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			if(!listAsignadas.isSelectionEmpty()) {
				modeloNoAsignadas.addElement(listAsignadas.getSelectedValue());
				modeloAsignadas.removeElement(listAsignadas.getSelectedValue());
			}
			
		}
	}
}
