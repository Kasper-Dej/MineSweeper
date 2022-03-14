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
        this.level = level;

        switch (level) {
            case EASY :
                startNewGame(8, 8, 10);
                break;
            case MEDIUM:
                startNewGame(16,16,40);
                break;
            case HARD:
                startNewGame(16,30,99);
                break;
        }
    }

    @Override
    public void startNewGame(int row, int col, int explosionCount) {
            this.row = row;
            this.col = col;
            this.explosionCount = explosionCount;
            tilelist = new AbstractTile[row][col];

            this.explosionCount = explosionCount;

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
