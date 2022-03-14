package model;

;

public class Tile extends AbstractTile{
    private boolean open;
    private boolean flag;
    private boolean explosive;

    public Tile(boolean open, boolean flag, boolean explosive) {
        this.open = open;
        this.flag = flag;
        this.explosive = explosive;
    }

    @Override
    public boolean open() {
        return open;
    }

    @Override
    public void flag() {

    }

    @Override
    public void unflag() {

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

