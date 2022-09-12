package negocio;

import java.util.ArrayList;

public class Cliente {

	protected String nome;
	protected int id;
	protected boolean ativo;
	protected ArrayList<Filme> filmesFavoritos;
	
	public Cliente(String nome, int id) {
		this.nome = nome;
		this.id = id;
		this.ativo = false;
		this.filmesFavoritos = new ArrayList<Filme>();
	}
	
	public Cliente(String nome, int id, boolean ativo) {
		this(nome, id);
		this.ativo = ativo;
	}
		
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public boolean getAtivo() {
		return this.ativo;
	}
	
	public Filme buscaFilmeFavorito(Filme f) {
		for (Filme filme: filmesFavoritos) {
			if (filme == f) {
				return filme;
			}
		}
		filmesFavoritos.add(f);
		return f;
	}
	
}
