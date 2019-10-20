package es.studium.practica;

import java.io.IOException;

public class MenuModeloP1 {

	public void ejecutar(String orden) {
		switch(orden) {
		case "notas":
			try
			{
				Process p1 = Runtime.getRuntime().exec ("C:/Windows/System32/notepad.exe");
				int retorno = p1.waitFor();
				
			}catch (Exception error)
			{
				System.out.println(error);
			}
			break;
		case "paint":
			try
			{
				Process p2 = Runtime.getRuntime().exec ("C:/Windows/System32/mspaint.exe");

				int retorno2 = p2.waitFor();
			}
			catch (Exception error)
			{
				System.out.println(error);
			}	
			break;

		case "practica1":
			try
			{
				Process p3 = Runtime.getRuntime().exec ("C:/Windows/System32/mspaint.exe");
				int retorno3 = p3.waitFor();
			}
			catch (Exception error)
			{
				System.out.println(error);
			}	
			break;
		case "practica2":
			try
			{
				Process p4 = Runtime.getRuntime().exec ("C:/Windows/System32/mspaint.exe");
				int retorno4 = p4.waitFor();
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
			
			int retorno5 = p5.waitFor();
			switch(retorno5) {
			case 0:
				//borrar en lista
				break;
					
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//mostrar en pantalla
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
