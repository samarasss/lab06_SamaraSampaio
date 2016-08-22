package loja;

import java.util.ArrayList;
import java.util.HashMap;

import jogo.Jogo;
import usuario.Noob;
import usuario.Usuario;

public class Loja {
	private HashMap<String, Usuario> listaUsuarios;
	private ArrayList<Jogo> listaJogos;
	
	public Loja() {
		listaUsuarios = new HashMap<String, Usuario>();
		listaJogos = new ArrayList<Jogo>();
	}
	
	public boolean addJogo(Jogo game) {
		listaJogos.add(game);
		return true;
	}
	
	public boolean addUsuario(String login, String nomeUsuario) {
		if(login == null || login.trim().equals("")) {
			return false;
		}
		
		if(existeUsuario(login)) {
			return false;
		}
		try {
			listaUsuarios.put(login, new Noob(nomeUsuario));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	private boolean existeUsuario(String nome) {
		if(listaUsuarios.containsKey(nome)) {
			return true;
		}
		return false;
	}
	
	private Jogo existeJogo(String nome) {
		for(Jogo game: listaJogos) {
			if(game.getNome().equals(nome));
			return game;
		}
		return null;
	}
	
	public boolean addDinheiroUsuario(String login, double quantia) {
		if(!existeUsuario(login)) {
			return false;
		}
		try {
			listaUsuarios.get(login).adicionaDinheiro(quantia);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	public boolean vendeJogo(String login, String nomeJogo) {
		if(!existeUsuario(login)) {
			return false;
		}
		if(existeJogo(nomeJogo) == null) {
			return false;
		}
		Jogo game = existeJogo(nomeJogo);
		try {
			listaUsuarios.get(login).compraJogo(game);
			return true;
		} catch(Exception e) {
			return false;
		}	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
