package presentacion;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import java.awt.Dimension;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.Toolkit;
import javax.swing.JTextArea;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Font;

/**
 * @author Daniel Loro Durán
 */
public class VentanaAyuda extends JDialog {
	private JSplitPane splitPane;
	private JScrollPane spAyuda;
	private JTree treeAyuda;
	private JScrollPane spTextoAyuda;
	private JTextArea txtAyuda;
	
	private boolean abierta = false;

	/**
	 * Create the dialog.
	 */
	public VentanaAyuda() {
		addWindowListener(new ThisWindowListener());
		setResizable(false);
		setModal(false);
		this.abierta = true;
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaAyuda.class.getResource("/presentacion/ayuda.png"))); //$NON-NLS-1$
		setTitle(Messages.getString("VentanaAyuda.TituloVentanaAyuda")); //$NON-NLS-1$
		setBounds(100, 100, 573, 394);
		setLocationRelativeTo(null);
		{
			splitPane = new JSplitPane();
			getContentPane().add(splitPane, BorderLayout.CENTER);
			{
				spAyuda = new JScrollPane();
				spAyuda.setMinimumSize(new Dimension(200, 23));
				splitPane.setLeftComponent(spAyuda);
				{
					treeAyuda = new JTree();
					treeAyuda.addTreeSelectionListener(new TreeAyudaTreeSelectionListener());
					treeAyuda.setModel(new DefaultTreeModel(new DefaultMutableTreeNode(Messages.getString("VentanaAyuda.NodoAyuda")) { //$NON-NLS-1$
							{
								DefaultMutableTreeNode node_1;
								node_1 = new DefaultMutableTreeNode(Messages.getString("VentanaAyuda.NodoPrinicipal")); //$NON-NLS-1$
								node_1.add(new DefaultMutableTreeNode(Messages.getString("VentanaAyuda.NodoHistorial"))); //$NON-NLS-1$
								node_1.add(new DefaultMutableTreeNode(Messages.getString("VentanaAyuda.NodoRutasPredefinidas"))); //$NON-NLS-1$
								node_1.add(new DefaultMutableTreeNode(Messages.getString("VentanaAyuda.NodoGestiones"))); //$NON-NLS-1$
								add(node_1);
								node_1= new DefaultMutableTreeNode(Messages.getString("VentanaAyuda.NodoGuias")); //$NON-NLS-1$
								add(node_1);
								node_1 = new DefaultMutableTreeNode(Messages.getString("VentanaAyuda.NodoGrupos")); //$NON-NLS-1$
								add(node_1);
								node_1 = new DefaultMutableTreeNode(Messages.getString("VentanaAyuda.NodoPromociones")); //$NON-NLS-1$
								add(node_1);
								node_1 = new DefaultMutableTreeNode(Messages.getString("VentanaAyuda.NodoDiseñoNuevasRutas")); //$NON-NLS-1$
								add(node_1);
							}
						}
					));
					spAyuda.setViewportView(treeAyuda);
					treeAyuda.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
					treeAyuda.setCellRenderer(new MiRenderizadoArbol());
				}
			}
			{
				spTextoAyuda = new JScrollPane();
				splitPane.setRightComponent(spTextoAyuda);
				{
					txtAyuda = new JTextArea();
					txtAyuda.setFont(new Font("Tahoma", Font.PLAIN, 11));
					txtAyuda.setEditable(false);
					txtAyuda.setLineWrap(true);
					txtAyuda.setWrapStyleWord(true);
					spTextoAyuda.setViewportView(txtAyuda);
				}
			}
		}

	}

	private class TreeAyudaTreeSelectionListener implements TreeSelectionListener {
		public void valueChanged(TreeSelectionEvent arg0) {
			
			String nodo = (arg0.getPath().getLastPathComponent()).toString();
			
			switch(nodo) {
			case "Ayuda": 
			case "Help":
				txtAyuda.setText(Messages.getString("VentanaAyuda.TextoAyuda")); //$NON-NLS-1$
				break;
			case "Principal":
			case "Main window":
				txtAyuda.setText(Messages.getString("VentanaAyuda.TextoPrincipal")); //$NON-NLS-1$
				break;
			case "Historial de rutas": 
			case "Route history": 
				txtAyuda.setText(Messages.getString("VentanaAyuda.TextoHistorialRutas")); //$NON-NLS-1$
				break;
			case "Rutas predefinidas": 
			case "Predefined routes": 
				txtAyuda.setText(Messages.getString("VentanaAyuda.TextoRutasPredefinidas")); //$NON-NLS-1$
				break;
			case "Acceso a gestiones": 
			case "Access to managements": 
				txtAyuda.setText(Messages.getString("VentanaAyuda.TextoGestiones")); //$NON-NLS-1$
				break;
			case "Gestión de guías": 
			case "Guide management":
				txtAyuda.setText(Messages.getString("VentanaAyuda.TextoGuias")); //$NON-NLS-1$
				break;
			case "Gestión de grupos turísticos":
			case "Tourism group management": 
				txtAyuda.setText(Messages.getString("VentanaAyuda.TextoGrupos")); //$NON-NLS-1$
				break;
			case "Promociones": 
			case "Promotiones": 
				txtAyuda.setText(Messages.getString("VentanaAyuda.TextoPromociones")); //$NON-NLS-1$
				break;
			case "Diseño de nuevas rutas": 
			case "Design of new routes": 
				txtAyuda.setText(Messages.getString("VentanaAyuda.TextoDiseñoRutas")); //$NON-NLS-1$
				break;
			}
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
