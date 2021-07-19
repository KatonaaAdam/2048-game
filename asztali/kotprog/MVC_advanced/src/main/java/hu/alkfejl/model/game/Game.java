package hu.alkfejl.model.game;

import hu.alkfejl.utils.Utils;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import org.apache.commons.lang3.time.StopWatch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Game extends javafx.scene.canvas.Canvas {

    private Cell[] cells;
    public boolean win = false;
    public boolean lose = false;
    public int score = 0;
    public IntegerProperty level = new SimpleIntegerProperty(1);
    public int szam=5;
    public StopWatch watch = new StopWatch();



    public int getLevel() {
        return level.get();
    }

    public IntegerProperty levelProperty() {
        return level;
    }

    public void setLevel(int level) {
        this.level.set(level);
    }

    public Cell[] getCells() {
        return cells;
    }


    public Game(int szam,int lvl) {
        super(800, 700);
        this.szam=szam;
        setLevel(lvl);
        setFocused(true);
        resetGame();
    }

    public Game(int szam) {
        super(800, 700);
        this.szam=szam;
        setFocused(true);
        resetGame();
    }
    public Game() {
        super(800, 700);
        setFocused(true);
        resetGame();

    }

    public Game(double width, double height) {
        super(width, height);
        setFocused(true);
        resetGame();
    }


    public void resetGame() {
        score = 0;
        win = false;
        lose = false;
        setLevel(getLevel());
        cells = new Cell[szam * szam];
        for (int cell = 0; cell < cells.length; cell++) {
            cells[cell] = new Cell();
        }
        int a=2;
        if (getLevel()==0){Utils.showWarning("A szint 0!");}
        if (getLevel()==1){
            a=2;
        }else if (getLevel()==2){
            a=4;
        }else if (getLevel()==3){
            a=8;
        }else if (getLevel()==4){
            a=16;
        }else if (getLevel()==5){
            a=32;
        }else if (getLevel()==6){
            a=64;
        }else if (getLevel()==7){
            a=128;
        }else if (getLevel()==8){
            a=256;
        }else if (getLevel()==9){
            a=512;
        }else if (getLevel()==10){
            a=1024;
        }else if (getLevel()==11){
            a=2048;}else{
            Utils.showWarning("Nem jó szint van megadva!");
        }


        int b= Math.random() < 0.9 ? 2 : 4;
        addCell(a);
        addCell(b);
    }

    private void addCell(int a) {
        List<Cell> list = availableSpace();
        if(!availableSpace().isEmpty()) {
            int index = (int) (Math.random() * list.size()) % list.size();
            Cell emptyCell = list.get(index);
            emptyCell.number =a;
        }
    }

    private List<Cell> availableSpace() {
        List<Cell> list = new ArrayList<>(16);
        for(Cell c : cells)
            if(c.isEmpty())
                list.add(c);
        return list;
    }

    private boolean isFull() {
        return availableSpace().size() == 0;
    }

    private Cell cellAt(int x, int y) {
        return cells[x + y * szam];

    }

    public boolean canMove() {
        if(!isFull()) return true;
        for(int x = 0; x < szam; x++) {
            for (int y = 0; y < szam; y++) {
                Cell cell = cellAt(x, y);
                if ((x < szam-1 && cell.number == cellAt(x + 1, y).number) ||
                        (y < szam-1) && cell.number == cellAt(x, y + 1).number) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean compare(Cell[] line1, Cell[] line2) {
        if(line1 == line2) {
            return true;
        }
        if (line1.length != line2.length) {
            return false;
        }

        for(int i = 0; i < line1.length; i++) {
            if(line1[i].number != line2[i].number) {
                return false;
            }
        }
        return true;
    }

    private Cell[] rotate(int angle) {
        Cell[] tiles = new Cell[szam * szam];
        int offsetX = szam-1;
        int offsetY = szam-1;
        if(angle == 90) {
            offsetY = 0;
        } else if(angle == 270) {
            offsetX = 0;
        }

        double rad = Math.toRadians(angle);
        int cos = (int) Math.cos(rad);
        int sin = (int) Math.sin(rad);
        for(int x = 0; x < szam; x++) {
            for(int y = 0; y < szam; y++) {
                int newX = (x*cos) - (y*sin) + offsetX;
                int newY = (x*sin) + (y*cos) + offsetY;
                tiles[(newX) + (newY) * szam] = cellAt(x, y);
            }
        }
        return tiles;
    }

    private Cell[] moveLine(Cell[] oldLine) {
        LinkedList<Cell> list = new LinkedList<Cell>();
        for(int i = 0; i < szam; i++) {
            if(!oldLine[i].isEmpty()){
                list.addLast(oldLine[i]);
            }
        }

        if(list.size() == 0) {
            return oldLine;
        } else {
            Cell[] newLine = new Cell[szam];
            while (list.size() != szam) {
                list.add(new Cell());
            }
            for(int j = 0; j < szam; j++) {
                newLine[j] = list.removeFirst();
            }
            return newLine;
        }
    }

    private Cell[] mergeLine(Cell[] oldLine) {
        LinkedList<Cell> list = new LinkedList<Cell>();
        for(int i = 0; i < szam && !oldLine[i].isEmpty(); i++) {
            int num = oldLine[i].number;
            if (i < szam-1 && oldLine[i].number == oldLine[i+1].number) {
                num *= 2;
                score += num;
                if ( num == 2048) {
                    win = true;
                }
                i++;
            }
            list.add(new Cell(num));
        }

        if(list.size() == 0) {
            return oldLine;
        } else {
            while (list.size() != szam) {
                list.add(new Cell());
            }
            return list.toArray(new Cell[szam]);
        }
    }

    private Cell[] getLine(int index) {
        Cell[] result = new Cell[szam];
        for(int i = 0; i < szam; i++) {
            result[i] = cellAt(i, index);
        }
        return result;
    }

    private void setLine(int index, Cell[] re) {
        System.arraycopy(re, 0, cells, index * szam, szam);
    }


    //mozgatások


    public void left() {
        boolean needAddCell = false;
        for(int i = 0; i < szam; i++) {
            Cell[] line = getLine(i);
            Cell[] merged = mergeLine(moveLine(line));
            setLine(i, merged);
            if( !needAddCell && !compare(line, merged)) {
                needAddCell = true;
            }
        }
        if(needAddCell) {
            int a= Math.random() < 0.9 ? 2 : 4;
            addCell(a);
        }
    }

    public void right() {
        cells = rotate(180);
        left();
        cells = rotate(180);
    }

    public void up() {
        cells = rotate(270);
        left();
        cells = rotate(90);
    }

    public void down() {
        cells = rotate(90);
        left();
        cells = rotate(270);
    }
}

