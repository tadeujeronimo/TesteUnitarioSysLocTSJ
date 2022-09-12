package negocio;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Locacao {

	protected Cliente cliente;
	protected Filme filme;
	protected double valorAluguel;
	//protected Date dataHoraAluguel;
	private long dataHoraAluguel;
	
	public void alugar(Cliente cliente, Filme filme) {
		if (cliente.getAtivo() == true) {
			this.cliente = cliente;
			this.filme = filme;
			//System.out.println("Locacao realizada.");
		} else {
			System.out.println("Locacao nao realizada, cliente inativo!");
		}
	}
	
	public void setValorAluguel(double valorAluguel) {
		this.valorAluguel = valorAluguel;
	}
	
	public void setDataHoraAluguel(String dataHoraAluguel) throws ParseException {
		this.dataHoraAluguel = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(dataHoraAluguel).getTime();
	}
	
	public String getDataHoraAluguel() {
		return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date(this.dataHoraAluguel));
	}
	
}
