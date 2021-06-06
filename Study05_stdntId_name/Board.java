// 盤面のためのクラス
public class Board {
    private Cell[][] cells;

    //getter, setter
    public Cell getCell(int i, int j){
       return this.cells[i][j];
    }

    public void setCells(Cell[][] cells){
        this.cells = cells;
    }

    public void setCell(int i, int j, Cell cell){
        this.cells[i][j] = cell;
    }
}
