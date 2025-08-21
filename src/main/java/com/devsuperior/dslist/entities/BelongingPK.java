package com.devsuperior.dslist.entities;

import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

//Embeddable serve para que um atributo represente 2 campos na tabela do BD. Encapsula 2 atributos em 1 classe só
@Embeddable
public class BelongingPK {

	@ManyToOne
	@JoinColumn(name = "game_id")
	private Game game;
	
	@ManyToOne
	@JoinColumn(name = "list_id")
	private GameList list;
	
	public BelongingPK() {
		
	}

	public BelongingPK(Game game, GameList list) {
		this.game = game;
		this.list = list;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public GameList getList() {
		return list;
	}

	public void setList(GameList list) {
		this.list = list;
	}

	//Com a tabela relacional, tem que criar o HashCode e Equals para os atributos game e list
	@Override
	public int hashCode() {
		return Objects.hash(game, list);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BelongingPK other = (BelongingPK) obj;
		return Objects.equals(game, other.game) && Objects.equals(list, other.list);
	}
	
	
}
