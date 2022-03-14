package model;

import java.util.Random;
import static model.Difficulty.*;

public class Minesweeper extends AbstractMineSweeper{
    int explosionCount;
    int col;
    int row;
    private AbstractTile[][] tilelist;
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
            this.row = row;
            this.col = col;
            this.explosionCount = explosionCount;
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


        tilelist = new AbstractTile[col][row];
        for(int i = 0; i < col; i++){
            for(int j = 0; j < row; j++){
                tilelist[i][j] = generateEmptyTile();
            }
        }

        Random r = new Random();
        for(int k = 0; k < explosionCount; k++){
            int xPos = r.nextInt(getWidth()-1);
            int yPos = r.nextInt(getHeight()-1);
            tilelist[xPos][yPos] = generateExplosiveTile();
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
        tilelist = world;
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
        return new Tile(false, false, false);
    }

    @Override
    public AbstractTile generateExplosiveTile() {
        return new Tile(true, false, true);
    }
}
