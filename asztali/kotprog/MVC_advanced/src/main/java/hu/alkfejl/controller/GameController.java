package hu.alkfejl.controller;

import hu.alkfejl.dao.GameDAO;
import hu.alkfejl.dao.GameDAOImp;
import hu.alkfejl.model.ModelGame;

import java.util.List;

public class GameController {
    private GameDAO dao = new GameDAOImp();
    private static GameController single_instance = null;

    private GameController() {

    }

    public static GameController getInstance(){
        if(single_instance == null){
            single_instance = new GameController();
        }
        return single_instance;
    }

    public boolean add(int lvl,String ido) {
        return dao.add(lvl,ido);
    }

    public List<ModelGame> getAll() {
        return dao.getAll();
    }




}
