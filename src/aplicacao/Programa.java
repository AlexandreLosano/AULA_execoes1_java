package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import modelo.entidade.Reservas;
import modelo.execao.ExecaoDeDominio;

public class Programa {

	public static void main(String[] args) {
		
		
			Scanner sc = new Scanner(System.in);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			System.out.print("Numero Quarto");
			int numero = sc.nextInt();
			System.out.print("Data de Entrada (dd/mm/aaaa): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Data de Saída (dd/mm/aaaa): ");
			Date checkOut = sdf.parse(sc.next());
			
			Reservas reserva = new Reservas(numero, checkIn, checkOut);
			System.out.println("Reserva: "+ reserva);
			
			System.out.println();
			System.out.println("Atualize as datas!:");
			System.out.print("Data de Entrada (dd/mm/aaaa): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data de Saída (dd/mm/aaaa): ");
			checkOut = sdf.parse(sc.next());
			
			reserva.atualizacaoDatas(checkIn, checkOut);
			System.out.println("Reserva: "+ reserva);
		}
		catch (ParseException e) {
			System.out.println("Formato de data incorrto");
		}
		catch (ExecaoDeDominio e) {
			System.out.println(e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Erro Inesperado");
		}
		sc.close();
	}

}
