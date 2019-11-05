package es.studium.practica;

import java.awt.EventQueue;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class PrincipalFrame2 extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtEjecutar;
	private Process p1;
	private Process p2;
	private Process p3;
	private Process p4;
	private Process p5;
	private Process p6;
	List listaM;
	JTextArea txtComandos;
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
				String seleccionado = listaM.getSelectedItem();
				System.out.println(seleccionado);
				matarFuerte(seleccionado);
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
				txtComandos.setText("");
			}
		});
		btnComando2.setBounds(136, 51, 84, 25);
		contentPane.add(btnComando2);
		txtComandos = new JTextArea();
		txtComandos.setLineWrap(true);
		txtComandos.setTabSize(9);
		txtComandos.setRows(20);
		txtComandos.setBounds(12, 107, 208, 128);
		contentPane.add(txtComandos);
		listaM = new List();
		listaM.setBounds(243, 107, 241, 128);
		contentPane.add(listaM);
		rellenarLista();
	}
	private void rellenarLista() {
		try {
			String command = "cmd /c TASKLIST>%USERPROFILE%\\Desktop\\temp.txt";
			Process p5 = Runtime.getRuntime().exec(command);
			p5.waitFor();
			File f = new File("C:/Users/usuario/Desktop/temp.txt");
			FileReader fr = new FileReader(f);
			BufferedReader bf = new BufferedReader(fr);
			String linea=bf.readLine();
			while((linea=bf.readLine())!=null) {
				listaM.add(linea);
			}
			bf.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void matarFuerte(String seleccionado) {
		String sinEsp=borrarCosas(seleccionado);
		String[] linea =sinEsp.split(" ");
		String proceso = linea[1];
		String command = "cmd /c "+"tskill"+" "+proceso;		
		suprimirLista();
		rellenarLista();
		try {
			p6 = Runtime.getRuntime().exec(command);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	private String borrarCosas(String seleccionado) {
		String resultado="";
		int i=0;
		while(i<seleccionado.length()) {
			if(seleccionado.charAt(i) != ' ') {
				resultado+=seleccionado.charAt(i);
				i++;
			}
			else
			{
				resultado+=seleccionado.charAt(i);
				while(seleccionado.charAt(i)==' ') {
					i++;
				}
			}		
		}
		return resultado;
	}

	public void ejecutar(String orden) {
		switch(orden) {
		case "notas":
			try
			{
				p1 = Runtime.getRuntime().exec ("C:/Windows/System32/notepad.exe");
				suprimirLista();
				rellenarLista();
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
				suprimirLista();
				rellenarLista();
			}
			catch (Exception error)
			{
				System.out.println(error);
			}	
			break;

		case "practica":
			try
			{
				p3 = Runtime.getRuntime().exec ("C:/Users/usuario/Desktop/Programa_Gestion/PGE.exe");
				suprimirLista();
				rellenarLista();
			}
			catch (Exception error)
			{
				System.out.println(error);
			}	
			break;
		case "practica2":
			try
			{				
				p4 = Runtime.getRuntime().exec ("C:/Users/usuario/Desktop/Juego_Instalable/Juego.exe");
				suprimirLista();
				rellenarLista();
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
	private void suprimirLista() {
		listaM.removeAll();
	}

	public void comandos(String textoOrden) {
		try
		{
			String command = "cmd /c "+textoOrden+">%USERPROFILE%\\Desktop\\temp2.txt";
			Process p5 = Runtime.getRuntime().exec(command);
			p5.waitFor();
			File f = new File("C:/Users/usuario/Desktop/temp2.txt");
			FileReader fr = new FileReader(f);
			BufferedReader bf = new BufferedReader(fr);
			ArrayList<String> texto = new ArrayList<String>();
			String linea=bf.readLine();
			texto.add(linea);
			while(bf.readLine()!=null) {
				linea=bf.readLine();
				texto.add(linea);
			}
			String resultadoTexto="";
			for(int i=0; i<texto.size();i++) {
				resultadoTexto=resultadoTexto+texto.get(i);
			}			
			txtComandos.setText(resultadoTexto);
		}catch (Exception error)
		{
			System.out.println(error);
		}
	}
}