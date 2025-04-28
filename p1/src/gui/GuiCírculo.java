package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import padre.Círculo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuiCírculo extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private JTextField txtRadio;
	private JLabel lblrea;
	private JTextField txtArea;
	private JLabel lblLongitud;
	private JTextField txtLongitud;
	private JScrollPane scrollPane;
	private JTextArea txtS;
	private JButton btnProcesar;
	private JButton btnLimpiar;
	private JButton btnSalir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GuiCírculo dialog = new GuiCírculo();
			dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GuiCírculo() {
		setModal(true);
		setTitle("Círculo");
		setBounds(100, 100, 450, 214);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			lblNewLabel = new JLabel("Radio");
			lblNewLabel.setBounds(29, 11, 41, 23);
			contentPanel.add(lblNewLabel);
		}
		{
			txtRadio = new JTextField();
			txtRadio.setBounds(93, 12, 86, 20);
			contentPanel.add(txtRadio);
			txtRadio.setColumns(10);
		}
		{
			lblrea = new JLabel("Área");
			lblrea.setBounds(29, 45, 41, 23);
			contentPanel.add(lblrea);
		}
		{
			txtArea = new JTextField();
			txtArea.setEditable(false);
			txtArea.setColumns(10);
			txtArea.setBounds(93, 46, 86, 20);
			contentPanel.add(txtArea);
		}
		{
			lblLongitud = new JLabel("Longitud");
			lblLongitud.setBounds(29, 79, 54, 23);
			contentPanel.add(lblLongitud);
		}
		{
			txtLongitud = new JTextField();
			txtLongitud.setEditable(false);
			txtLongitud.setColumns(10);
			txtLongitud.setBounds(93, 80, 86, 20);
			contentPanel.add(txtLongitud);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(224, 11, 180, 91);
			contentPanel.add(scrollPane);
			{
				txtS = new JTextArea();
				scrollPane.setViewportView(txtS);
			}
		}
		{
			btnProcesar = new JButton("Procesar");
			btnProcesar.addActionListener(this);
			btnProcesar.setBounds(29, 126, 89, 23);
			contentPanel.add(btnProcesar);
		}
		{
			btnLimpiar = new JButton("Limpiar");
			btnLimpiar.addActionListener(this);
			btnLimpiar.setBounds(149, 126, 89, 23);
			contentPanel.add(btnLimpiar);
		}
		{
			btnSalir = new JButton("Salir");
			btnSalir.addActionListener(this);
			btnSalir.setBounds(267, 126, 89, 23);
			contentPanel.add(btnSalir);
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
		if(txtRadio.getText().trim().isEmpty())
		{
			JOptionPane.showMessageDialog(this, "Ingrese un radio");
			txtRadio.grabFocus(); 
		}
		else {
			double radio = Double.parseDouble(txtRadio.getText());
			Círculo ci=new Círculo(radio); //Holaaaaaa
			txtArea.setText(""+ci.Área());
			txtLongitud.setText(""+ci.Longitud());
			txtS.append(ci.Mensaje());
		}
		
	}
	protected void do_btnLimpiar_actionPerformed(ActionEvent e) {
		txtRadio.setText("");
		txtArea.setText("");
		txtLongitud.setText("");
		txtS.setText("");
		txtRadio.grabFocus(); //ubica el cursor
	}
	protected void do_btnSalir_actionPerformed(ActionEvent e) {
		dispose(); //cerrar ventana activa
	}
}
