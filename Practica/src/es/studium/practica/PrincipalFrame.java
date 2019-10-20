package es.studium.practica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.List;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JTextPane;
import javax.swing.DropMode;

public class PrincipalFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtEjecutar;
	private JList suc;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalFrame frame = new PrincipalFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PrincipalFrame() {
		setTitle("Programa Ejecutador");
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 589, 289);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNotas = new JButton("Bloc de Notas");
		btnNotas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ejecutar("notas");
			}
		});
		btnNotas.setBounds(243, 13, 109, 25);
		contentPane.add(btnNotas);
		
		JButton btnPractica2 = new JButton("Juego");
		btnPractica2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ejecutar("practica2");
			}
		});
		btnPractica2.setBounds(375, 13, 109, 25);
		contentPane.add(btnPractica2);
		
		JButton btnPractica = new JButton("Programa de Gestion");
		btnPractica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ejecutar("practica");
			}
		});
		btnPractica.setBounds(375, 51, 153, 25);
		contentPane.add(btnPractica);
		
		JButton btnPaint = new JButton("Paint");
		btnPaint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ejecutar("paint");
			}
		});
		btnPaint.setBounds(243, 51, 109, 25);
		contentPane.add(btnPaint);
		
		JLabel lblProgesosActivos = new JLabel("Progesos Activos");
		lblProgesosActivos.setBounds(243, 85, 148, 16);
		contentPane.add(lblProgesosActivos);
		
		List list = new List();
		list.setBounds(243, 107, 241, 128);
		contentPane.add(list);
		
		JButton btnMatar = new JButton("Matar");
		btnMatar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMatar.setBounds(490, 141, 78, 36);
		contentPane.add(btnMatar);
		
		txtEjecutar = new JTextField();
		txtEjecutar.setBounds(12, 14, 208, 22);
		contentPane.add(txtEjecutar);
		txtEjecutar.setColumns(10);
		
		JButton btnComando1 = new JButton("Ejecutar");
		btnComando1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Recogemos texto
				String aEjecutar= txtEjecutar.getText();
				//Ejecutamos dir
				comandos(aEjecutar);
			}
		});
		btnComando1.setBounds(12, 51, 90, 25);
		contentPane.add(btnComando1);
		
		JButton btnComando2 = new JButton("Borrar");
		btnComando2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtEjecutar.setText("");
			}
		});
		btnComando2.setBounds(136, 51, 84, 25);
		contentPane.add(btnComando2);
		
		JTextArea txtComandos = new JTextArea();
		txtComandos.setDropMode(DropMode.INSERT_ROWS);
		txtComandos.setLineWrap(true);
		txtComandos.setTabSize(9);
		txtComandos.setRows(20);
		txtComandos.setBounds(12, 107, 208, 128);
		contentPane.add(txtComandos);
	}
	
}
