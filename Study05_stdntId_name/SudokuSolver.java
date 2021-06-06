import java.io.*;

public class SudokuSolver {
    public Board solve(Board board) throws Exception {
        SudokuSolverMethods methods = new SudokuSolverMethods();
        while (true) {
            methods.drawCurrentBoard(board);

            // possible の更新
            methods.renewPossibleRC(board);

            //ブロック内での処理 posibleの更新
            for (int by = 0; by < 3; by++) {
                for (int bx = 0; bx < 3; bx++) {
                    Cell[] block = methods.createBlock(bx, by, board);
                    boolean[] filter = new boolean[10];
                    for (int i = 0; i < 9; i++) {
                        filter[block[i].getValue()] = true;
                    }
                    for (int i = 0; i < 9; i++) {
                        for (int v = 1; v <= 9; v++) {
                            block[i].setPossible(v, block[i].getPossible(v) & !filter[v]);
                        }
                    }
                }
            }

            boolean isUpdated = false;
            // 各マスの調査
            for (int y = 0; y < 9; y++) {
                for (int x = 0; x < 9; x++) {
                    if (board.getCell(y, x).getValue() != 0)
                        continue;
                    int count = 0;
                    int lastPossible = 0;
                    for (int v = 1; v <= 9; v++) {
                        if (board.getCell(y, x).getPossible(v)) {
                            count++;
                            lastPossible = v;
                        }
                    }
                    if (count == 0) {
                        throw new Exception(
                                "Error: No possible number at cell(" + x + "," + y + ")" + board.getCell(y, x));
                    }
                    if (count == 1) {
                        board.getCell(y, x).setValue(lastPossible);
                        System.out.println("Fixed at (" + x + "," + y + ") => " + lastPossible);
                        isUpdated = true;
                    }
                }
            }

            // 各行の調査
            for (int y = 0; y < 9; y++) {
                for (int v = 1; v <= 9; v++) {
                    boolean isFixed = false;
                    int count = 0;
                    int lastPos = -1;
                    for (int x = 0; x < 9; x++) {
                        if (board.getCell(y, x).getValue() == v) {
                            isFixed = true;
                            break;
                        }
                        if (board.getCell(y, x).getPossible(v)) {
                            count++;
                            lastPos = x;
                        }
                    }
                    if (isFixed)
                        continue;
                    methods.printFixingResult(y, lastPos, v, count, isUpdated, board);
                }
            }

            // 各列の調査
            for (int x = 0; x < 9; x++) {
                for (int v = 1; v <= 9; v++) {
                    boolean isFixed = false;
                    int count = 0;
                    int lastPos = -1;
                    for (int y = 0; y < 9; y++) {
                        if (board.getCell(y, x).getValue() == v) {
                            isFixed = true;
                            break;
                        }
                        if (board.getCell(y, x).getPossible(v)) {
                            count++;
                            lastPos = y;
                        }
                    }
                    if (isFixed)
                        continue;

                    methods.printFixingResult(lastPos, x, v, count, isUpdated, board);
                }
            }

            // 各ブロックの調査
            for (int by = 0; by < 3; by++) {
                for (int bx = 0; bx < 3; bx++) {
                    Cell[] block = methods.createBlock(bx, by, board);
                    for (int v = 1; v <= 9; v++) {
                        boolean isFixed = false;
                        int count = 0;
                        int lastPos = -1;
                        for (int i = 0; i < 9; i++) {
                            if (block[i].getValue() == v) {
                                isFixed = true;
                                break;
                            }
                            if (block[i].getPossible(v)) {
                                count++;
                                lastPos = i;
                            }
                        }
                        if (isFixed)
                            continue;
                        if (count == 0) {
                            throw new Exception("Error: No possible number " + v);
                        }
                        if (count == 1) {
                            block[lastPos].setValue(v);
                            System.out.println("Fixed at (" + block[lastPos].getX() + "," + block[lastPos].getY() + ") => " + v);
                            isUpdated = true;
                        }
                    }
                }
            }

            if (!isUpdated)
                break;
        }//while end

        //未定のマスを探す
        Cell firstUndecidedCell = methods.findUndecidedCell(board);
        // 未定のマスがなければ終了
        if (firstUndecidedCell == null) {
            System.out.println("Solved");
            return board;
        }
        // 未定のマスがあれば，そのマスに仮の数を置く
        for (int nv = 1; nv <= 9; nv++) {
            if (!firstUndecidedCell.getPossible(nv))
                continue;
            try {
                // 仮置きするための盤面の準備
               return methods.tempFixing(board, firstUndecidedCell, nv);
            } catch (Exception e) {
                System.out.println("Temporaly-fixing failed");
            }
        }
        throw new Exception("Now possible value");
    }
}