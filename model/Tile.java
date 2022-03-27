package model;

;

public class Tile extends AbstractTile{
    private boolean open;
    private boolean flag;
    private boolean explosive;

    public Tile(boolean explosive) {
        this.open = false;
        this.flag = false;
        this.explosive = explosive;
    }


    @Override
    public boolean open() {
        this.open = true;
        return explosive;
    }

    @Override
    public void flag() {
        flag = true;
    }

    @Override
    public void unflag() {
        flag = false;
    }

    @Override
    public boolean isFlagged() {
        return flag;
    }

    @Override
    public boolean isExplosive() {
        return explosive;
    }

    @Override
    public boolean isOpened() {
        return open;
    }
}

