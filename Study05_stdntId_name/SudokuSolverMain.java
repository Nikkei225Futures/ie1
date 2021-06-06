import java.io.*;

public class SudokuSolverMain {
    public static void main(String[] args) {
        Board board = new Board();
        SudokuSolver solver = new SudokuSolver();
        board.setCells(new Cell[9][9]);
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                board.setCell(y, x, new Cell(x, y));
            }
        }

        // 問題の読み込み
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            for (int y = 0; y < 9; y++) {
                String buf = br.readLine();
                for (int x = 0; x < 9; x++) {
                    char c = buf.charAt(x);
                    if ('1' <= c && c <= '9'){
                        board.getCell(y, x).setValue((c - '0'));
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Input Error");
            System.exit(1);
        }

        // 問題を解く
        try {
            solver.solve(board);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
