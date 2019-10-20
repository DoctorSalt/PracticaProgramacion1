package es.studium.practica;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;

public class PrincipalFrame2 extends JFrame {

	private JPanel contentPane;
	private JTextField txtEjecutar;
	private int retorno1;
	private int retorno2;
	private int retorno3;
	private int retorno4;
	private Process p1;
	private Process p2;
	private Process p3;
	private Process p4;
	private Process p5;
	DefaultListModel<String> DLM = new DefaultListModel<String>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalFrame2 frame = new PrincipalFrame2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PrincipalFrame2() {
		iniciadorComponentes();
		DLM=new DefaultListModel();
	}

	private void iniciadorComponentes() {
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
		
		JButton btnMatar = new JButton("Matar");
		btnMatar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//int seleccionado = listaM.getSelectedIndex();
				//matarFuerte(seleccionado);
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
		txtComandos.setLineWrap(true);
		txtComandos.setTabSize(9);
		txtComandos.setRows(20);
		txtComandos.setBounds(12, 107, 208, 128);
		contentPane.add(txtComandos);
		
		JList listaM = new JList();
		listaM.setBounds(243, 107, 241, 128);
		contentPane.add(listaM);
	}
	protected void matarFuerte(int seleccionado) {
		switch(seleccionado) {
		case 0:
			p1.destroy();
			break;
		case 1:
			p2.destroy();
			break;
		case 2:
			p3.destroy();
			break;
		case 3:
			p4.destroy();
			break;
		}
		
	}
	public void ejecutar(String orden) {
		switch(orden) {
		case "notas":
			try
			{
				p1 = Runtime.getRuntime().exec ("C:/Windows/System32/notepad.exe");
				DLM.addElement("Proceso Notepad");
				add("Proceso Notepad");
				retorno1 = p1.waitFor();
				DLM.removeElement("Proceso Notepad");
			}
			catch (Exception error)
			{
				System.out.println(error);
			}
			break;
		case "paint":
			try
			{
				p2 = Runtime.getRuntime().exec ("C:/Windows/System32/mspaint.exe");
				//list.add("Proceso Paint");
				retorno2 = p2.waitFor();
				//list.remove("Proceso Paint");
			}
			catch (Exception error)
			{
				System.out.println(error);
			}	
			break;

		case "practica1":
			try
			{
				p3 = Runtime.getRuntime().exec ("C:/Program Files/Programa_Gestion/Programa_Gestion_Ejecutable.jar");
				//list.add("Proceso Programa Gestion");
				retorno3 = p3.waitFor();
				//list.remove("Proceso Programa Gestion");
			}
			catch (Exception error)
			{
				System.out.println(error);
			}	
			break;
		case "practica2":
			try
			{
				p4 = Runtime.getRuntime().exec ("C:/Program Files/ProgramaJuego/Juego.jar");
				//list.add("Proceso Juego");
				retorno4 = p4.waitFor();
				//list.remove("Proceso Juego");
			}
			catch (Exception error)
			{
				System.out.println(error);
			}	
			break;
		default:
			System.out.println("Se han producido errores");
			break;

		}

	}
	public void comandos(String textoOrden) {
		//se ejecutara bat con todo lo escrito
		try {
			Process p5 = Runtime.getRuntime().exec ("dir>temp.txt");
			//meter en lista
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
