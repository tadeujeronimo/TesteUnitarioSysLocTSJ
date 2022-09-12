package negocio;

import java.util.ArrayList;
import java.util.HashMap;

public class Transacao {

	protected ArrayList<Locacao> alugueis;
	
	public Transacao() {
		alugueis = new ArrayList<Locacao>();
	}
	
	public double valorLocacaoTotal() {
	    double valor = 0;
		for (Locacao locacao: alugueis) {
			valor += locacao.filme.valorCompra;
		}
		return valor;
	}
	
	public Cliente buscaCliente(int id) {
		for (Locacao locacao: alugueis) {
			if (locacao.cliente.id == id) {
				return locacao.cliente;
			}
		}
		return null;
	}
	
	public double calculoLucro(int filmeId) {
		double valor = 0;
		Filme aux = null;
		for (Locacao locacao: alugueis) {
			if (locacao.filme.id == filmeId) {
				valor += locacao.valorAluguel;
				aux = locacao.filme;
			}
		}
		return (valor * 100) / aux.valorCompra;
	}
	
	public Genero consultaGeneroMaisAlugado() {
		HashMap<Genero, Integer> hm = new HashMap<Genero, Integer>();
		Genero gen = null;
		int aux;
		
		for (Locacao locacao: alugueis) {
			/*if (hm.containsKey(locacao.filme.genero)) {
				hm.put(locacao.filme.genero, hm.get(locacao.filme.genero) + 1);
	    	} else {
	    		hm.put(locacao.filme.genero, 1);
	    	}*/
			aux = (hm.get(locacao.filme.genero) == null) ? 0 : hm.get(locacao.filme.genero);
			hm.put(locacao.filme.genero, aux + 1);
		}
		
		aux = 0;
		for (HashMap.Entry<Genero, Integer> e: hm.entrySet()) {
			if (e.getValue() > aux) { 
				aux = e.getValue();
				gen = e.getKey();
			}
		}
		
		return gen;
	}
	
	public double valorAluguelTotal() {
	    double valor = 0;
		for (Locacao locacao: alugueis) {
			valor += locacao.valorAluguel;
		}
		return valor;
	}
	
	public void adicionarDesconto(double desconto, Genero genero) {
		for (Locacao locacao: alugueis) {
			if (locacao.filme.genero == genero) {
				locacao.valorAluguel -= (locacao.valorAluguel * desconto / 100);
			}
		}
	}
	
}
