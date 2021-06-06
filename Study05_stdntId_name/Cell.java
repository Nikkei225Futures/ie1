// 各マスのためのクラス
public class Cell {
	private final int x;
	private final int y;
	private int value;
	private boolean[] possible;

	public Cell(int x, int y) {
		this.x = x;
		this.y = y;
		value = 0;
		possible = new boolean[9 + 1];
		for (int v = 1; v <= 9; v++) {
			possible[v] = true;
		}
	}

	//getter, setter
	public int getValue(){
		return this.value;
	}

	public boolean getPossible(int i){
		return this.possible[i];
	}

	public int getX(){
		return this.x;
	}

	public int getY(){
		return this.y;
	}

	public void setPossible(int i, boolean val){
		this.possible[i] = val;
	}

	public void setValue(int v){
		this.value = v;
	}


}
