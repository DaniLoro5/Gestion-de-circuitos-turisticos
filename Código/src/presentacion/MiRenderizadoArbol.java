package presentacion;

import java.awt.Component;
import javax.swing.tree.TreeCellRenderer;
import java.awt.Component;
import javax.swing.*;
import javax.swing.tree.*;

class MiRenderizadoArbol extends DefaultTreeCellRenderer {
	
	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded,
			boolean leaf, int row, boolean hasFocus) {
		super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
		DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) value;
		String c = (String)(nodo.getUserObject());
		
		switch (c)
		{
		case "Ayuda":
		case "Help":
			setIcon(new ImageIcon(MiRenderizadoArbol.class.getResource("ayuda.png")));
			break;
		case "Principal":
		case "Main window":
			setIcon(new ImageIcon(MiRenderizadoArbol.class.getResource("principal.png")));
			break;
		case "Historial de rutas":
		case "Route history":
			setIcon(new ImageIcon(MiRenderizadoArbol.class.getResource("historial.png")));
			break;
		case "Rutas predefinidas":
		case "Predefined routes":
			setIcon(new ImageIcon(MiRenderizadoArbol.class.getResource("rutaTab.png")));
			break;
		case "Acceso a gestiones":
		case "Access to managements":
			setIcon(new ImageIcon(MiRenderizadoArbol.class.getResource("gestiones.png")));
			break;
		case "Gestión de guías":
		case "Guide management":
			setIcon(new ImageIcon(MiRenderizadoArbol.class.getResource("guia.png")));
			break;
		case "Gestión de grupos turísticos":
		case "Tourism group management":
			setIcon(new ImageIcon(MiRenderizadoArbol.class.getResource("grupo.png")));
			break;
		case "Diseño de nuevas rutas":
		case "Design of new routes":
			setIcon(new ImageIcon(MiRenderizadoArbol.class.getResource("ruta.png")));
			break;
		case "Promociones":
		case "Promotions":
			setIcon(new ImageIcon(MiRenderizadoArbol.class.getResource("promocion.png")));
			break;
		}
		return this;
	}
}
