package hu.alkfejl.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ModelGame {
    StringProperty ido=new SimpleStringProperty();
    IntegerProperty lvl=new SimpleIntegerProperty();

    public ModelGame(String ido, int lvl) {
        this.ido.set(ido);
        this.lvl.set(lvl);
    }
    public ModelGame() {
    }


    public String getIdo() {
        return ido.get();
    }

    public StringProperty idoProperty() {
        return ido;
    }

    public void setIdo(String ido) {
        this.ido.set(ido);
    }

    public int getLvl() {
        return lvl.get();
    }

    public IntegerProperty lvlProperty() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl.set(lvl);
    }
}
