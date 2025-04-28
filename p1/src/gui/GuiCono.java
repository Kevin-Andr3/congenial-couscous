package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hijos.Cono;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuiCono extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtRadio;
	private JTextField txtAltura;
	private JTextField txtGeneratriz;
	private JTextField txtÁrea;
	private JTextField txtVolumen;
	private JButton btnProcesar_1;
	private JTextArea txtS;
	private JButton btnSalir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GuiCono dialog = new GuiCono();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GuiCono() {
		setBounds(100, 100, 565, 249);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Radio");
			lblNewLabel.setBounds(64, 11, 46, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblAltura = new JLabel("Altura");
			lblAltura.setBounds(64, 36, 46, 14);
			contentPanel.add(lblAltura);
		}
		{
			JLabel lblGeneratriz = new JLabel("Generatriz");
			lblGeneratriz.setBounds(64, 66, 68, 14);
			contentPanel.add(lblGeneratriz);
		}
		{
			JLabel lblrea = new JLabel("Área");
			lblrea.setBounds(64, 96, 68, 14);
			contentPanel.add(lblrea);
		}
		{
			JLabel lblVolumen = new JLabel("Volumen");
			lblVolumen.setBounds(64, 127, 68, 14);
			contentPanel.add(lblVolumen);
		}
		{
			txtRadio = new JTextField();
			txtRadio.setBounds(149, 8, 86, 20);
			contentPanel.add(txtRadio);
			txtRadio.setColumns(10);
		}
		{
			txtAltura = new JTextField();
			txtAltura.setColumns(10);
			txtAltura.setBounds(149, 33, 86, 20);
			contentPanel.add(txtAltura);
		}
		{
			txtGeneratriz = new JTextField();
			txtGeneratriz.setColumns(10);
			txtGeneratriz.setBounds(149, 63, 86, 20);
			contentPanel.add(txtGeneratriz);
		}
		{
			txtÁrea = new JTextField();
			txtÁrea.setEditable(false);
			txtÁrea.setColumns(10);
			txtÁrea.setBounds(149, 93, 86, 20);
			contentPanel.add(txtÁrea);
		}
		{
			txtVolumen = new JTextField();
			txtVolumen.setEditable(false);
			txtVolumen.setColumns(10);
			txtVolumen.setBounds(149, 124, 86, 20);
			contentPanel.add(txtVolumen);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(281, 11, 202, 136);
			contentPanel.add(scrollPane);
			{
				txtS = new JTextArea();
				scrollPane.setViewportView(txtS);
			}
		}
		{
			btnProcesar_1 = new JButton("Procesar");
			btnProcesar_1.addActionListener(this);
			btnProcesar_1.setBounds(96, 158, 89, 23);
			contentPanel.add(btnProcesar_1);
		}
		{
			btnSalir = new JButton("Salir");
			btnSalir.addActionListener(this);
			btnSalir.setBounds(356, 158, 89, 23);
			contentPanel.add(btnSalir);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSalir) {
			do_btnSalir_actionPerformed(e);
		}
		if (e.getSource() == btnProcesar_1) {
			do_btnProcesar_actionPerformed(e);
		}
	}
	protected void do_btnProcesar_actionPerformed(ActionEvent e) {
		if(txtRadio.getText().trim().isEmpty() || txtAltura.getText().trim().isEmpty())
		{
			JOptionPane.showMessageDialog(this, "Ingrese todos los datos");
			txtRadio.grabFocus(); 
		}
		else 
		{
			double radio = Double.parseDouble(txtRadio.getText());
			double altura = Double.parseDouble(txtAltura.getText());
			double generatriz = Double.parseDouble(txtGeneratriz.getText());
			Cono co = new Cono(radio, altura, generatriz);
			txtÁrea.setText(""+co.Área());
			txtVolumen.setText(""+co.Volumen());
			txtS.append(co.Mensaje());
		}
	}
	
	protected void do_btnSalir_actionPerformed(ActionEvent e) {
		dispose();
	}
}
