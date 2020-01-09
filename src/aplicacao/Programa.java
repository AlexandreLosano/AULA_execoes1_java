package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import modelo.entidade.Reservas;

public class Programa {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Numero Quarto");
		int numero = sc.nextInt();
		System.out.print("Data de Entrada (dd/mm/aaaa): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Data de Saída (dd/mm/aaaa): ");
		Date checkOut = sdf.parse(sc.next());
		
		if (!checkOut.after(checkIn)) {
			System.out.println("Erro na reserva: A data de Saída deve ser maior que a data de Entrada!");
		}
		else {
			Reservas reserva = new Reservas(numero, checkIn, checkOut);
			System.out.println("Reserva: "+ reserva);
			
			System.out.println();
			System.out.println("Atualize as datas!:");
			System.out.print("Data de Entrada (dd/mm/aaaa): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data de Saída (dd/mm/aaaa): ");
			checkOut = sdf.parse(sc.next());
			
			String erro = reserva.atualizacaoDatas(checkIn, checkOut);
			if (erro !=null) {
				System.out.println(erro);
			}
			else {
				System.out.println("Reserva: "+ reserva);
			}
		}
		
		sc.close();
	}

}
