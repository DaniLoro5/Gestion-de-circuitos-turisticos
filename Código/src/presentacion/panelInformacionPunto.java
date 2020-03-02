package presentacion;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import dominio.PuntoInteres;

import javax.swing.JScrollPane;
import java.awt.Font;

/**
 * @author Daniel Loro Durán
 */
public class panelInformacionPunto extends JPanel {
	private JLabel lblTipo;
	private static JTextField txtTipo;
	private JLabel lblDuracion;
	private JLabel lblEntrada;
	private static JTextField txtEntrada;
	private static JTextField txtDuracion;
	private JLabel lblDescripcin;
	private static JTextArea txtDescripcion;
	private JLabel lblHorario;
	private static JTextArea txtHorario;
	private JScrollPane spFotoPunto;
	private static JLabel lblFoto;
	private JScrollPane spDescripcion;
	private JScrollPane spHorario;
	
	private static ImageIcon foto;


	/**
	 * Create the panel.
	 */
	public panelInformacionPunto() {
		setBorder(new TitledBorder(null, Messages.getString("panelInformacionPunto.this.borderTitle"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
		setLayout(null);
		{
			spFotoPunto = new JScrollPane();
			spFotoPunto.setBounds(10, 27, 109, 109);
			add(spFotoPunto);
			{
				lblFoto = new JLabel("");
				spFotoPunto.setViewportView(lblFoto);
			}
		}
		{
			lblTipo = new JLabel(Messages.getString("panelInformacionPunto.lblTipo.text")); //$NON-NLS-1$
			lblTipo.setBounds(126, 27, 80, 14);
			add(lblTipo);
		}
		{
			lblDuracion = new JLabel(Messages.getString("panelInformacionPunto.lblDuracion.text")); //$NON-NLS-1$
			lblDuracion.setBounds(279, 27, 129, 14);
			add(lblDuracion);
		}
		{
			txtTipo = new JTextField();
			txtTipo.setEditable(false);
			txtTipo.setBounds(126, 46, 129, 20);
			add(txtTipo);
			txtTipo.setColumns(10);
		}
		{
			txtDuracion = new JTextField();
			txtDuracion.setEditable(false);
			txtDuracion.setBounds(279, 46, 129, 20);
			add(txtDuracion);
			txtDuracion.setColumns(10);
		}
		{
			lblEntrada = new JLabel(Messages.getString("panelInformacionPunto.lblEntrada.text")); //$NON-NLS-1$
			lblEntrada.setBounds(126, 77, 80, 14);
			add(lblEntrada);
		}
		{
			txtEntrada = new JTextField();
			txtEntrada.setEditable(false);
			txtEntrada.setBounds(126, 90, 129, 20);
			add(txtEntrada);
			txtEntrada.setColumns(10);
		}
		{
			lblDescripcin = new JLabel(Messages.getString("panelInformacionPunto.lblDescripcin.text")); //$NON-NLS-1$
			lblDescripcin.setBounds(126, 115, 96, 14);
			add(lblDescripcin);
		}
		{
			lblHorario = new JLabel(Messages.getString("panelInformacionPunto.lblHorario.text")); //$NON-NLS-1$
			lblHorario.setBounds(279, 115, 96, 14);
			add(lblHorario);
		}
		{
			spDescripcion = new JScrollPane();
			spDescripcion.setBounds(126, 134, 129, 96);
			add(spDescripcion);
			{
				txtDescripcion = new JTextArea();
				txtDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 11));
				spDescripcion.setViewportView(txtDescripcion);
				txtDescripcion.setWrapStyleWord(true);
				txtDescripcion.setLineWrap(true);
				txtDescripcion.setEditable(false);
			}
		}
		{
			spHorario = new JScrollPane();
			spHorario.setBounds(279, 134, 129, 96);
			add(spHorario);
			{
				txtHorario = new JTextArea();
				txtHorario.setFont(new Font("Tahoma", Font.PLAIN, 11));
				spHorario.setViewportView(txtHorario);
				txtHorario.setWrapStyleWord(true);
				txtHorario.setLineWrap(true);
				txtHorario.setEditable(false);
			}
		}

	}
	
	public static void infoPunto(PuntoInteres puntoInteres) {

		if(puntoInteres!=null) {
			foto = new ImageIcon(new ImageIcon(panelInformacionPunto.class.getResource(puntoInteres.getFoto())).getImage().getScaledInstance(106, 106, Image.SCALE_SMOOTH));

			lblFoto.setIcon(foto);
			
			txtTipo.setEnabled(true);
			txtEntrada.setEnabled(true);
			txtDescripcion.setEnabled(true);
			txtHorario.setEnabled(true);
			txtDuracion.setEnabled(true);
			
			txtTipo.setText(puntoInteres.getNombre());
			txtEntrada.setText(puntoInteres.getEntrada());
			txtDescripcion.setText(puntoInteres.getDescripcion());
			txtHorario.setText(puntoInteres.getHorario());
			txtDuracion.setText(puntoInteres.getDuracionVisita());
		}else {
			lblFoto.setIcon(null);
			
			txtTipo.setEnabled(false);
			txtEntrada.setEnabled(false);
			txtDescripcion.setEnabled(false);
			txtHorario.setEnabled(false);
			
			txtTipo.setText("");
			txtEntrada.setText("");
			txtDescripcion.setText("");
			txtHorario.setText("");
			txtDuracion.setText("");

		}
		
	}
}
