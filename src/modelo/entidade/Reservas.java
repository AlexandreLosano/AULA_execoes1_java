package modelo.entidade;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import modelo.execao.ExecaoDeDominio;

public class Reservas {

	private Integer numeroQuarto;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservas(Integer numeroQuarto, Date checkIn, Date checkOut) {
		if (!checkOut.after(checkIn)) {
			throw new ExecaoDeDominio("Erro na reserva: As datas de atualiza��o devem ser datas futuras");
	}
		this.numeroQuarto = numeroQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getcheckIn() {
		return checkIn;
	}

	public Date getcheckOut() {
		return checkOut;
	}

	public long duracao() {
		long dif = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);
	}
	
	public void atualizacaoDatas(Date checkInNovo, Date checkOutNovo) {
		Date agora = new Date();
		if (checkIn.before(agora) || checkOut.before(agora)) {
			throw new ExecaoDeDominio("Erro na reserva: As datas de atualiza��o devem ser datas futuras");
		}
		if (!checkOut.after(checkIn)) {
			throw new ExecaoDeDominio("Erro na reserva: A data de Sa�da deve ser maior que a data de Entrada!");
		}
		this.checkIn = checkInNovo;
		this.checkOut = checkOutNovo;
	}
	
	@Override
	public String toString() {
		return "Quarto "
			+ numeroQuarto
			+ ", entrada: "
			+ sdf.format(checkIn)
			+ ", sa�da "
			+ sdf.format(checkOut)
			+ ", "
			+ duracao()
			+ " noites.";
	}
}
