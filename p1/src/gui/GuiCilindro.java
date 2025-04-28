package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hijos.Cilindro;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuiCilindro extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtRadio;
	private JTextField txtAltura;
	private JTextField txtÁrea;
	private JTextField txtVolumen;
	private JButton btnProcesar;
	private JButton btnLimpiar;
	private JButton btnSalir;
	private JScrollPane scrollPane;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GuiCilindro dialog = new GuiCilindro();
			dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GuiCilindro() {
		setModal(true);
		setBounds(100, 100, 471, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Radio");
			lblNewLabel.setBounds(44, 22, 46, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			txtRadio = new JTextField();
			txtRadio.setBounds(100, 19, 86, 20);
			contentPanel.add(txtRadio);
			txtRadio.setColumns(10);
		}
		{
			JLabel lblAltura = new JLabel("Altura");
			lblAltura.setBounds(44, 53, 46, 14);
			contentPanel.add(lblAltura);
		}
		{
			txtAltura = new JTextField();
			txtAltura.setColumns(10);
			txtAltura.setBounds(100, 50, 86, 20);
			contentPanel.add(txtAltura);
		}
		{
			JLabel lblrea = new JLabel("Área");
			lblrea.setBounds(44, 84, 46, 14);
			contentPanel.add(lblrea);
		}
		{
			JLabel lblVolumen = new JLabel("Volumen");
			lblVolumen.setBounds(44, 117, 66, 14);
			contentPanel.add(lblVolumen);
		}
		{
			txtÁrea = new JTextField();
			txtÁrea.setEditable(false);
			txtÁrea.setColumns(10);
			txtÁrea.setBounds(100, 81, 86, 20);
			contentPanel.add(txtÁrea);
		}
		{
			txtVolumen = new JTextField();
			txtVolumen.setEditable(false);
			txtVolumen.setColumns(10);
			txtVolumen.setBounds(100, 114, 86, 20);
			contentPanel.add(txtVolumen);
		}
		{
			btnProcesar = new JButton("Procesar");
			btnProcesar.addActionListener(this);
			btnProcesar.setBounds(44, 155, 86, 30);
			contentPanel.add(btnProcesar);
		}
		{
			btnLimpiar = new JButton("Limpiar");
			btnLimpiar.addActionListener(this);
			btnLimpiar.setBounds(159, 155, 86, 30);
			contentPanel.add(btnLimpiar);
		}
		{
			btnSalir = new JButton("Salir");
			btnSalir.addActionListener(this);
			btnSalir.setBounds(276, 155, 86, 30);
			contentPanel.add(btnSalir);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(227, 22, 157, 109);
			contentPanel.add(scrollPane);
			{
				txtS = new JTextArea();
				scrollPane.setViewportView(txtS);
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSalir) {
			do_btnSalir_actionPerformed(e);
		}
		if (e.getSource() == btnLimpiar) {
			do_btnLimpiar_actionPerformed(e);
		}
		if (e.getSource() == btnProcesar) {
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
		Cilindro ci = new Cilindro(radio, altura);
		txtÁrea.setText(""+ci.Área());
		txtVolumen.setText(""+ci.Volumen());
		txtS.append(ci.Mensaje());
		}
	}
	protected void do_btnLimpiar_actionPerformed(ActionEvent e) {
		txtRadio.setText("");
		txtAltura.setText("");
		txtÁrea.setText("");
		txtS.setText("");
		txtVolumen.setText("");
		txtRadio.grabFocus();
	}
	protected void do_btnSalir_actionPerformed(ActionEvent e) {
		dispose();
	}
}
