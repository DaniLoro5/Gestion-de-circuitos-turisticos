package presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dominio.*;
import datos.*;

import java.awt.Toolkit;
import javax.swing.JToolBar;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Rectangle;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Point;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author Daniel Loro Durán
 */
public class VentanaDisenoRuta extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombreRuta;
	private JButton btnPlaza;
	private JButton btnMuseo;
	private JButton btnIglesia;
	private JButton btnRectangulo;
	private JButton btnTexto;
	private JButton btnGuardar;
	private JScrollPane spMapa;
	private JPanel panel;
	private JLabel lblNombreRuta;
	private JLabel lblLocalidades;
	private JComboBox cbLocalidad;
	private JLabel lblCoste;
	private JTextField txtCoste;
	private DatosPrueba datos;
	
	private boolean abierta = false;
	
	private JTextField txtTexto = new JTextField();

	private MiAreaDibujo miAreaDibujo;
	private ImageIcon imagen;
	
	int modo = -1;
	private final int PLAZA = 1;
	private final int MUSEO = 2;
	private final int IGLESIA = 3;
	private final int RECTANGULO = 4;
	private final int TEXTO = 5;
	
	private Toolkit toolkit;
	private Image imagPlaza;
	private Image imagMuseo;
	private Image imagIglesia;
	private Image imagRectangulo;
	private Image imagTexto;
	private Cursor cursorPlaza;
	private Cursor cursorMuseo;
	private Cursor cursorIglesia;
	private Cursor cursorRectangulo;
	private Cursor cursorTexto;
	
	private int x,y;

	private int cntMuseo;
	private int cntPlaza;
	private int cntIglesia;
	private int cntTotal;
	

	/**
	 * Create the dialog.
	 */
	public VentanaDisenoRuta(DatosPrueba datos) {
		
		addWindowListener(new ThisWindowListener());
		this.abierta = true;
		this.datos = datos;
		setTitle(Messages.getString("VentanaDisenoRuta.this.title")); //$NON-NLS-1$
		setResizable(false);
		setModal(true);
		setBounds(new Rectangle(0, 0, 715, 625));
		setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaDisenoRuta.class.getResource("/presentacion/ruta.png"))); //$NON-NLS-1$
		getContentPane().setLayout(null);
		contentPanel.setBounds(185, 0, 526, 595);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JToolBar toolBar = new JToolBar();
			contentPanel.add(toolBar, BorderLayout.NORTH);
			{
				btnPlaza = new JButton(""); //$NON-NLS-1$
				btnPlaza.setToolTipText(Messages.getString("VentanaDisenoRuta.btnPlaza.toolTipText")); //$NON-NLS-1$
				btnPlaza.addActionListener(new BtnPlazaActionListener());
				btnPlaza.setIcon(new ImageIcon(VentanaDisenoRuta.class.getResource("/presentacion/plazaIcon.png"))); //$NON-NLS-1$
				toolBar.add(btnPlaza);
			}
			{
				btnMuseo = new JButton(""); //$NON-NLS-1$
				btnMuseo.setToolTipText(Messages.getString("VentanaDisenoRuta.btnMuseo.toolTipText")); //$NON-NLS-1$
				btnMuseo.addActionListener(new BtnMuseoActionListener());
				btnMuseo.setIcon(new ImageIcon(VentanaDisenoRuta.class.getResource("/presentacion/museoIcon.png"))); //$NON-NLS-1$
				toolBar.add(btnMuseo);
			}
			{
				btnIglesia = new JButton(""); //$NON-NLS-1$
				btnIglesia.setToolTipText(Messages.getString("VentanaDisenoRuta.btnIglesia.toolTipText")); //$NON-NLS-1$
				btnIglesia.addActionListener(new BtnIglesiaActionListener());
				btnIglesia.setIcon(new ImageIcon(VentanaDisenoRuta.class.getResource("/presentacion/iglesiaIcon.png"))); //$NON-NLS-1$
				toolBar.add(btnIglesia);
			}
			{
				btnRectangulo = new JButton(""); //$NON-NLS-1$
				btnRectangulo.setToolTipText(Messages.getString("VentanaDisenoRuta.btnRectangulo.toolTipText")); //$NON-NLS-1$
				btnRectangulo.addActionListener(new BtnRectanguloActionListener());
				btnRectangulo.setIcon(new ImageIcon(VentanaDisenoRuta.class.getResource("/presentacion/rectángulo.png"))); //$NON-NLS-1$
				toolBar.add(btnRectangulo);
			}
			{
				btnTexto = new JButton(""); //$NON-NLS-1$
				btnTexto.setToolTipText(Messages.getString("VentanaDisenoRuta.btnTexto.toolTipText")); //$NON-NLS-1$
				btnTexto.addActionListener(new BtnTextoActionListener());
				btnTexto.setIcon(new ImageIcon(VentanaDisenoRuta.class.getResource("/presentacion/dialogo.png"))); //$NON-NLS-1$
				toolBar.add(btnTexto);
			}
		}
		{
			spMapa = new JScrollPane();
			contentPanel.add(spMapa, BorderLayout.CENTER);
			{
				miAreaDibujo = new MiAreaDibujo();
				miAreaDibujo.addMouseMotionListener(new MiAreaDibujoMouseMotionListener());
				miAreaDibujo.addMouseListener(new MiAreaDibujoMouseListener());
				spMapa.setViewportView(miAreaDibujo);
			}
		}
		{
			panel = new JPanel();
			panel.setBounds(0, 0, 183, 595);
			getContentPane().add(panel);
			panel.setLayout(null);
			{
				lblNombreRuta = new JLabel(Messages.getString("VentanaDisenoRuta.lblNombreRuta.text")); //$NON-NLS-1$
				lblNombreRuta.setBounds(27, 49, 112, 14);
				panel.add(lblNombreRuta);
			}
			{
				txtNombreRuta = new JTextField();
				txtNombreRuta.setBounds(27, 74, 138, 20);
				txtNombreRuta.addFocusListener(new MiFocusListener());
				panel.add(txtNombreRuta);
				txtNombreRuta.setColumns(10);
			}
			{
				lblLocalidades = new JLabel(Messages.getString("VentanaDisenoRuta.lblLocalidades.text")); //$NON-NLS-1$
				lblLocalidades.setBounds(27, 105, 112, 14);
				panel.add(lblLocalidades);
			}
			{
				cbLocalidad = new JComboBox();
				cbLocalidad.setModel(new DefaultComboBoxModel(new String[] {"Ciudad Real", "Malagón"})); //$NON-NLS-1$ //$NON-NLS-2$
				cbLocalidad.addActionListener(new ComboBoxActionListener());
				cbLocalidad.setBounds(27, 130, 138, 20);
				cbLocalidad.setSelectedItem(null);
				panel.add(cbLocalidad);
			}
			{
				btnGuardar = new JButton(Messages.getString("VentanaDisenoRuta.btnGuardar.text")); //$NON-NLS-1$
				btnGuardar.setToolTipText(Messages.getString("VentanaDisenoRuta.btnGuardar.toolTipText")); //$NON-NLS-1$
				btnGuardar.setBounds(10, 549, 162, 35);
				panel.add(btnGuardar);
				btnGuardar.addActionListener(new BtnGuardarActionListener());
				btnGuardar.setIcon(new ImageIcon(VentanaDisenoRuta.class.getResource("/presentacion/guardar.png"))); //$NON-NLS-1$
			}
			{
				lblCoste = new JLabel(Messages.getString("VentanaDisenoRuta.lblCoste.text")); //$NON-NLS-1$
				lblCoste.setBounds(27, 166, 112, 14);
				panel.add(lblCoste);
			}
			{
				txtCoste = new JTextField();
				txtCoste.setBounds(27, 187, 138, 20);
				txtCoste.addFocusListener(new MiFocusListener());
				panel.add(txtCoste);
				txtCoste.setColumns(10);
			}
		}
		
		//Creación de imágenes y cursores
		toolkit = Toolkit.getDefaultToolkit();
		imagPlaza = toolkit.getImage(getClass().getClassLoader().getResource("presentacion/plazaIcon.png")); //$NON-NLS-1$
		imagMuseo = toolkit.getImage(getClass().getClassLoader().getResource("presentacion/museoIcon.png")); //$NON-NLS-1$
		imagIglesia = toolkit.getImage(getClass().getClassLoader().getResource("presentacion/iglesiaIcon.png")); //$NON-NLS-1$
		imagRectangulo = toolkit.getImage(getClass().getClassLoader().getResource("presentacion/rectángulo.png")); //$NON-NLS-1$
		imagTexto = toolkit.getImage(getClass().getClassLoader().getResource("presentacion/dialogo.png")); //$NON-NLS-1$
		
		//Creación de los cursores
		cursorRectangulo = toolkit.createCustomCursor(imagRectangulo,new Point(0,0),"CURSOR_RECTANGULO"); //$NON-NLS-1$
		cursorTexto= toolkit.createCustomCursor(imagTexto,new Point(0,0),"CURSOR_TEXTO"); //$NON-NLS-1$
		cursorPlaza = toolkit.createCustomCursor(imagPlaza,new Point(0,0),"CURSOR_PLAZA"); //$NON-NLS-1$
		cursorMuseo = toolkit.createCustomCursor(imagMuseo,new Point(0,0),"CURSOR_MUSEO"); //$NON-NLS-1$
		cursorIglesia = toolkit.createCustomCursor(imagIglesia,new Point(0,0),"CURSOR_IGLESIA"); //$NON-NLS-1$
		
	}
	private class ComboBoxActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			
			if(cbLocalidad.getSelectedIndex()==0) {
				miAreaDibujo.setIcon(new ImageIcon(VentanaDisenoRuta.class.getResource("/presentacion/mapaCR.JPG"))); //$NON-NLS-1$
				cntTotal = 0;
				cntPlaza = 0;
				cntIglesia = 0;
				cntMuseo = 0;
			}
			if(cbLocalidad.getSelectedIndex()==1) {
				miAreaDibujo.setIcon(new ImageIcon(VentanaDisenoRuta.class.getResource("/presentacion/mapaMalagon.jpg"))); //$NON-NLS-1$
				cntTotal = 0;
				cntPlaza = 0;
				cntIglesia = 0;
				cntMuseo = 0;
			}
		}
	}
	private class BtnPlazaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			modo = PLAZA;
			setCursor(cursorPlaza);
		}
	}
	private class BtnMuseoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			modo = MUSEO;
			setCursor(cursorMuseo);
		}
	}
	private class BtnIglesiaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			modo = IGLESIA;
			setCursor(cursorIglesia);
		}
	}
	private class BtnRectanguloActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			modo = RECTANGULO;
			setCursor(cursorRectangulo);
		}
	}
	private class BtnTextoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			modo = TEXTO;
			setCursor(cursorTexto);
		}
	}
	private class BtnGuardarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			Ruta ruta = new Ruta("", "Pendiente", "", "", "", "", ""); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$
			
			if(cntPlaza!=0) {
				cntTotal += cntPlaza;
				for (int i = 0; i < cntPlaza; i++) {
					PuntoInteres pi = new PuntoInteres("Plaza "+ (i+1), "Plaza", "/presentacion/plazaIcon.png", "", "Descripción de la plaza", "Horario", "Duración"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$
					ruta.getPuntoInteres().add(pi);
				}
			}
			
			if(cntMuseo!=0) {
				cntTotal += cntMuseo;
				for (int i = 0; i < cntMuseo; i++) {
					PuntoInteres pi = new PuntoInteres("Museo "+ (i+1), "Museo", "/presentacion/museoIcon.png", "", "Descripción del museo", "Horario", "Duración"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$
					ruta.getPuntoInteres().add(pi);
				}
			}
			
			if(cntIglesia!=0) {
				cntTotal += cntIglesia;
				for (int i = 0; i < cntIglesia; i++) {
					PuntoInteres pi = new PuntoInteres("Iglesia "+ (i+1), "Iglesia", "/presentacion/iglesiaIcon.png", "", "Descripción de la iglesia", "Horario", "Duración"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$
					ruta.getPuntoInteres().add(pi);
				}
			}
			
			if(!txtNombreRuta.equals("") && cbLocalidad.getSelectedItem() != null && !txtCoste.equals("") && cntTotal!=0) { //$NON-NLS-1$ //$NON-NLS-2$
				ruta.setIdRuta(txtNombreRuta.getText());
				ruta.setCoste(txtCoste.getText());
				ruta.setLocalidad(cbLocalidad.getSelectedItem().toString());
				datos.rutas.add(ruta);
				JOptionPane.showMessageDialog(contentPanel, Messages.getString("VentanaDisenoRuta.TextoAvisoAñadir"), Messages.getString("VentanaDisenoRuta.TituloAvisoAñadir"), JOptionPane.INFORMATION_MESSAGE);  //$NON-NLS-1$ //$NON-NLS-2$
				panelRutasPredefinidas.actualizarListRutas(ruta);
			}else {
				cntTotal = 0;
				ruta.setPuntoInteres(new ArrayList<PuntoInteres>());
				JOptionPane.showMessageDialog(contentPanel, Messages.getString("VentanaDisenoRuta.TextoErrorAñadir"), Messages.getString("VentanaDisenoRuta.TituloErrorAñadir"), JOptionPane.WARNING_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
			}
			
		}
	}
	private class MiAreaDibujoMouseListener extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent arg0) {
			
			x = arg0.getX();
			y = arg0.getY();
			if (miAreaDibujo.getIcon() != null) {
				switch (modo) {
				case PLAZA:
					miAreaDibujo.addObjetoGrafico(new ImagenGrafico(x, y, imagPlaza));
					cntPlaza += 1;
					miAreaDibujo.repaint();
					break;
				case MUSEO:
					miAreaDibujo.addObjetoGrafico(new ImagenGrafico(x, y, imagMuseo));
					cntMuseo += 1;
					miAreaDibujo.repaint();
					break;
				case IGLESIA:
					miAreaDibujo.addObjetoGrafico(new ImagenGrafico(x, y, imagIglesia));
					cntIglesia += 1;
					miAreaDibujo.repaint();
					break;
				case RECTANGULO:
					miAreaDibujo.addObjetoGrafico(new RectanguloGrafico(x,y,x,y, Color.RED));
					break;
				case TEXTO:
					txtTexto.setBounds(x, y, 200, 30);
					txtTexto.setVisible(true);
					txtTexto.requestFocus();
					txtTexto.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg) {
							if (!txtTexto.getText().equals("")) //$NON-NLS-1$
								miAreaDibujo.addObjetoGrafico(new TextoGrafico(x, y + 15, txtTexto.getText(), Color.BLUE));
							txtTexto.setText(""); //$NON-NLS-1$
							txtTexto.setVisible(false);
							miAreaDibujo.repaint();
						}
					});
					miAreaDibujo.add(txtTexto);
				}
			}
			
		}
		@Override
		public void mouseExited(MouseEvent e) {
			setCursor(Cursor.getDefaultCursor());
			modo = -1;
		}
	}
	private class MiAreaDibujoMouseMotionListener extends MouseMotionAdapter {
		@Override
		public void mouseDragged(MouseEvent arg0) {
			if (modo == RECTANGULO && miAreaDibujo.getIcon()!=null) {
				((RectanguloGrafico)miAreaDibujo.getUltimoObjetoGrafico()).setX1(arg0.getX());
				((RectanguloGrafico)miAreaDibujo.getUltimoObjetoGrafico()).setY1(arg0.getY());
				miAreaDibujo.repaint();
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
			cntTotal = 0;
			cntPlaza = 0;
			cntIglesia = 0;
			cntMuseo = 0;

		}
	}
	
	public boolean getEstado() {
		return this.abierta;
	}
}
