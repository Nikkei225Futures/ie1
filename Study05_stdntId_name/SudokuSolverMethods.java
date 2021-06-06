public class SudokuSolverMethods {

    public void drawCurrentBoard(Board board) {
        //Board全体を出力
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                if (board.getCell(y, x).getValue() != 0) {
                    System.out.print(board.getCell(y, x).getValue());
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }

    //行・列のpossibleを更新 
    public void renewPossibleRC(Board board){
        for (int y = 0; y < 9; y++) {
            boolean[] filter1 = new boolean[10];
            boolean[] filter2 = new boolean[10];
            for (int x = 0; x < 9; x++) {
                filter1[board.getCell(y, x).getValue()] = true;
                filter2[board.getCell(x, y).getValue()] = true;
            } 
            for (int x = 0; x < 9; x++) {
                for (int v = 1; v <= 9; v++) {
                    board.getCell(y, x).setPossible(v, board.getCell(y, x).getPossible(v) & !filter1[v]);
                    board.getCell(x, y).setPossible(v, board.getCell(x, y).getPossible(v) & !filter2[v]);
                }
            }
        }
    }

    
    public void printFixingResult(int i, int j, int v, int count,
     Boolean isUpdated, Board board) throws Exception{
        if(count == 0){
            throw new Exception("Error: No possible number " + v);
        }else if(count == 1){
            board.getCell(i, j).setValue(v);
            System.out.println("Fixed at (" + j + "," + i + ") => " + v);
            isUpdated = true;
        }
    }

    //ブロックの作成
    public Cell[] createBlock(int bx, int by, Board board) {
        Cell[] block = new Cell[9];
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                block[y * 3 + x] = board.getCell(by * 3 + y, bx * 3 + x);
            }
        }
        return block;
    }

    //未定のマスを探す
    public Cell findUndecidedCell(Board board){
        Cell firstUndecidedCell = null;
        undecided_loop: for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                if (board.getCell(y, x).getValue() == 0) {
                    firstUndecidedCell = board.getCell(y, x);
                    break undecided_loop;
                }
            }
        }
        return firstUndecidedCell;

    }

    //仮置き->再帰
    public Board tempFixing(Board board, Cell firstUndecidedCell, int nv) throws Exception{
        SudokuSolver solver = new SudokuSolver();
        // 仮置きするための盤面の準備
        Board newboard = new Board();
        newboard.setCells(new Cell[9][9]);
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                newboard.setCell(y, x, new Cell(x, y));
                newboard.getCell(y, x).setValue(board.getCell(y, x).getValue());
                for (int v = 1; v <= 9; v++) {
                    newboard.getCell(y, x).setPossible(v, board.getCell(y, x).getPossible(v));
                }
            }
        }

        newboard.getCell(firstUndecidedCell.getY(), firstUndecidedCell.getX()).setValue(nv);
        System.out.println(
                "Fixed Temporaly at (" + firstUndecidedCell.getY() + "," + firstUndecidedCell.getX() + ") => " + nv);
        solver.solve(newboard);
        return newboard;
    }
    
}