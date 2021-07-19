package hu.alkfejl.controller;

import hu.alkfejl.model.game.Cell;

public class MaxSzint extends Thread{

    public Cell localMaximum = new Cell(0);
    public int fromIndex;
    public int toIndex;
    public final Cell[] array;



        public MaxSzint(Cell[] array, int fromIndex, int toIndex) {
            this.fromIndex = fromIndex;
            this.toIndex = toIndex;
            this.array = array;
        }

        @Override
        public void run() {
            for (int i = fromIndex; i < toIndex; i++) {
                if (array[i].number > localMaximum.number)
                    localMaximum = array[i];

            }
        }


    }

