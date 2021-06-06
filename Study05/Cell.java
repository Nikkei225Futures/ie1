// 各マスのためのクラス
public class Cell {
    public final int x;
    public final int y;
    public int value;
    public boolean[] possible;

    public Cell(int x, int y) {
	this.x = x;
	this.y = y;
	value = 0;
	possible = new boolean[9+1];
	for (int v = 1; v <= 9; v++) {
	    possible[v] = true;
	}
    }
}
