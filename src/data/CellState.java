package data;


public enum CellState {
    DEAD(0),
    LIVE(1);
    private int value;

    CellState(int value) {
        this.value = value;//×´Ì¬¸³Öµ
    }

    public int getValue() {
        return value;
    }
}
