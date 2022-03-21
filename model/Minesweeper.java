package model;

import java.util.Random;
import static model.Difficulty.*;

public class Minesweeper extends AbstractMineSweeper{
    int explosionCount;
    int col;
    int row;
    private AbstractTile[][] tilelist;
    Difficulty level;
    private int timesClicked;

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
            if( tilelist[x][y].isFlagged()) {
                tilelist[x][y].unflag();
            }
            else{
                tilelist[x][y].flag();
            }
    }

    @Override
    public AbstractTile getTile(int x, int y) {
        if(0<=x && x<col && 0<=y && y<row)
            return tilelist[x][y];
        return null;
    }

    @Override
    public void setWorld(AbstractTile[][] world) {
        tilelist = world;
    }

    @Override
    public void open(int x, int y) {
        if(timesClicked == 0){
            deactivateFirstTileRule();
        }
        if (0 <= x && x < getWidth() && 0 <= y && y < getHeight()) {
            if (!tilelist[x][y].isExplosive() && !tilelist[x][y].isFlagged() && !tilelist[x][y].isOpened()) {
                tilelist[x][y].open();
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        int xPos = x + i;
                        int yPos = y + j;
                        if (0 <= xPos && xPos < getWidth() && 0 <= yPos && yPos < getHeight()) {
                            if (!tilelist[xPos][yPos].isExplosive()) {
                                tilelist[xPos][yPos].open();
                            }
                        }
                    }
                }
            } else if (tilelist[x][y].isExplosive() && !tilelist[x][y].isFlagged() && !tilelist[x][y].isOpened()) {
                for (int i = 0; i < getWidth(); i++) {
                    for (int j = 0; j < getHeight(); j++) {
                        tilelist[x][y].open();
                    }
                }
            }
        }
    }

    @Override
    public void flag(int x, int y) {
        if(!tilelist[x][y].isFlagged()){
            tilelist[x][y].flag();
            explosionCount--;
        }
    }

    @Override
    public void unflag(int x, int y) {
        if(tilelist[x][y].isFlagged()){
            tilelist[x][y].unflag();
            explosionCount++;
        }
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
        return new Tile(false, false, true);
    }

    public int getBombsAroundTile(int x, int y) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int xPos = x + i;
                int yPos = y + j;
                if (0 <= xPos && xPos < getWidth() && 0 <= yPos && yPos< getHeight())
                    if (tilelist[xPos][yPos] == generateExplosiveTile()) {
                        count++;
                    }
            }
        }
        return count;
    }


}
