package model;

import static model.Difficulty.*;

public class Minesweeper extends AbstractMineSweeper{
    int explosionCount;
    int col;
    int row;
    Difficulty level;


    @Override
    public int getWidth() {
        return col;
    }

    @Override
    public int getHeight() {
        return row;
    }

    @Override
    public void startNewGame(Difficulty level) {
    setDifficulty(level);
    }

    @Override
    public void startNewGame(int row, int col, int explosionCount) {
    setDifficulty(this.level);
    }

    public void setDifficulty(Difficulty level)
    {
        this.level = level;
        if(this.level== EASY  )
        {
            this.explosionCount = 10;
            this.col = 8;
            this.row = 8;

        }
        else if(this.level== MEDIUM)
        {
            this.explosionCount = 40;
            this.col = 16;
            this.row = 16;
        }
        else if(this.level== HARD)
        {
            this.explosionCount = 40;
            this.col = 16;
            this.row = 30;
        }
        else
        {
            this.level = EASY;
            this.explosionCount = 10;
            this.col = 8;
            this.row = 8;
        }

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
