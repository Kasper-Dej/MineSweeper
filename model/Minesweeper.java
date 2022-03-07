package model;

import static model.Difficulty.EASY;
import static model.Difficulty.MEDIUM;

public class Minesweeper extends AbstractMineSweeper{
    int mines;
    int wBords;
    int hBords;

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public void startNewGame(Difficulty level) {
        if(level == EASY){
            mines = 10;
            wBords = 8;
            hBords = 8;

        }
        else if(level == MEDIUM){
            mines = 40;
            wBords = 16;
            hBords = 16;

        }
        else{
            mines = 99;
            wBords = 16;
            hBords = 30;
        }


    }

    @Override
    public void startNewGame(int row, int col, int explosionCount) {

    }

    @Override
    public void toggleFlag(int x, int y) {

    }

    @Override
    public AbstractTile getTile(int x, int y) {
        return null;
    }

    @Override
    public void setWorld(AbstractTile[][] world) {

    }

    @Override
    public void open(int x, int y) {

    }

    @Override
    public void flag(int x, int y) {

    }

    @Override
    public void unflag(int x, int y) {

    }

    @Override
    public void deactivateFirstTileRule() {

    }

    @Override
    public AbstractTile generateEmptyTile() {
        return null;
    }

    @Override
    public AbstractTile generateExplosiveTile() {
        return null;
    }
}
