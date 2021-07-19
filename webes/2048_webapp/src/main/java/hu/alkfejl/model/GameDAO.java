package hu.alkfejl.model;

import java.util.List;

import hu.alkfejl.model.bean.Game;

public interface GameDAO {
	
	boolean addGame(Game p);
	List<Game> listGame();

}
