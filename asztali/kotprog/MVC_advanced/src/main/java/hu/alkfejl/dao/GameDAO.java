package hu.alkfejl.dao;

import hu.alkfejl.model.ModelGame;

import java.util.List;

public interface GameDAO {
    public boolean add(int lvl,String ido);
    public List<ModelGame>getAll();

}
