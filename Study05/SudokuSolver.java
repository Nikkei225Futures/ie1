import java.io.*;

public class SudokuSolver {
    public static void main(String[] args) {
	Board board = new Board();
	board.cells = new Cell[9][9];
	for (int y = 0; y < 9; y++) {
	    for (int x = 0; x < 9; x++) {
		board.cells[y][x] = new Cell(x, y);
	    }
	}

	// 問題の読み込み
	try {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    for (int y = 0; y < 9; y++) {
		String buf = br.readLine();
		for (int x = 0; x < 9; x++) {
		    char c = buf.charAt(x);
		    if ('1' <= c && c <= '9') board.cells[y][x].value = (c - '0');
		}
	    }
	} catch (IOException e) {
	    System.out.println("Input Error");
	    System.exit(1);
	}

	// 問題を解く
	try {
	    solve(board);
	}catch (Exception e) {
	    e.printStackTrace();
	}
    }

    public static Board solve(Board board) throws Exception {
	while (true) {
	    for (int y = 0; y < 9; y++) {
		for (int x = 0; x < 9; x++) {
		    if (board.cells[y][x].value != 0) {
			System.out.print(board.cells[y][x].value);
		    } else {
			System.out.print(".");
		    }
		}
		System.out.println();
	    }

	    // possible の更新
	    for (int y = 0; y < 9; y++) {
		boolean[] filter = new boolean[10];
		for (int x = 0; x < 9; x++) {
		    filter[board.cells[y][x].value] = true;
		}
		for (int x = 0; x < 9; x++) {
		    for (int v = 1; v <= 9; v++) {
			board.cells[y][x].possible[v] = board.cells[y][x].possible[v] & !filter[v];
		    }
		}
	    }
	    for (int x = 0; x < 9; x++) {
		boolean[] filter = new boolean[10];
		for (int y = 0; y < 9; y++) {
		    filter[board.cells[y][x].value] = true;
		}
		for (int y = 0; y < 9; y++) {
		    for (int v = 1; v <= 9; v++) {
			board.cells[y][x].possible[v] = board.cells[y][x].possible[v] & !filter[v];
		    }
		}
	    }
	    for (int by = 0; by < 3; by++) {
		for (int bx = 0; bx < 3; bx++) {
		    Cell[] block = new Cell[9];
		    for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 3; x++) {
			    block[y * 3 + x] = board.cells[by * 3 + y][bx * 3 + x];
			}
		    }
		    boolean[] filter = new boolean[10];
		    for (int i = 0; i < 9; i++) {
			filter[block[i].value] = true;
		    }
		    for (int i = 0; i < 9; i++) {
			for (int v = 1; v <= 9; v++) {
			    block[i].possible[v] = block[i].possible[v] & !filter[v];
			}
		    }
		}
	    }

	    boolean isUpdated = false;
	    // 各マスの調査
	    for (int y = 0; y < 9; y++) {
		for (int x = 0; x < 9; x++) {
		    if (board.cells[y][x].value != 0) continue;
		    int count = 0;
		    int lastPossible = 0;
		    for (int v = 1; v <= 9; v++) {
			if (board.cells[y][x].possible[v]) {
			    count++;
			    lastPossible = v;
			}
		    }
		    if (count == 0) {
			throw new Exception("Error: No possible number at cell(" + x + "," + y + ")" + board.cells[y][x]);
		    }
		    if (count == 1) {
			board.cells[y][x].value = lastPossible;
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
			if (board.cells[y][x].value == v) {
			    isFixed = true; break;
			}
			if (board.cells[y][x].possible[v]) {
			    count++;
			    lastPos = x;
			}
		    }
		    if (isFixed) continue;
		    if (count == 0) {
			throw new Exception("Error: No possible number " + v);
		    }
		    if (count == 1) {
			board.cells[y][lastPos].value = v;
			System.out.println("Fixed at (" + lastPos + "," + y + ") => " + v);
			isUpdated = true;
		    }
		}
	    }

	    // 各列の調査
	    for (int x = 0; x < 9; x++) {
		for (int v = 1; v <= 9; v++) {
		    boolean isFixed = false;
		    int count = 0;
		    int lastPos = -1;
		    for (int y = 0; y < 9; y++) {
			if (board.cells[y][x].value == v) {
			    isFixed = true; break;
			}
			if (board.cells[y][x].possible[v]) {
			    count++;
			    lastPos = y;
			}
		    }
		    if (isFixed) continue;
		    if (count == 0) {
			throw new Exception("Error: No possible number " + v);
		    }
		    if (count == 1) {
			board.cells[lastPos][x].value = v;
			System.out.println("Fixed at (" + x + "," + lastPos + ") => " + v);
			isUpdated = true;
		    }
		}
	    }

	    // 各ブロックの調査
	    for (int by = 0; by < 3; by++) {
		for (int bx = 0; bx < 3; bx++) {
		    Cell[] block = new Cell[9];
		    for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 3; x++) {
			    block[y * 3 + x] = board.cells[by * 3 + y][bx * 3 + x];
			}
		    }
		    for (int v = 1; v <= 9; v++) {
			boolean isFixed = false;
			int count = 0;
			int lastPos = -1;
			for (int i = 0; i < 9; i++) {
			    if (block[i].value == v) {
				isFixed = true; break;
			    }
			    if (block[i].possible[v]) {
				count++;
				lastPos = i;
			    }
			}
			if (isFixed) continue;
			if (count == 0) {
			    throw new Exception("Error: No possible number " + v);
			}
			if (count == 1) {
			    block[lastPos].value = v;
			    System.out.println("Fixed at (" + block[lastPos].x + "," + block[lastPos].y + ") => " + v);
			    isUpdated = true;
			}
		    }
		}
	    }

	    if (!isUpdated) break;
	}

	Cell firstUndecidedCell = null;
	undecided_loop:
	for (int y = 0; y < 9; y++) {
	    for (int x = 0; x < 9; x++) {
		if (board.cells[y][x].value == 0) {
		    firstUndecidedCell = board.cells[y][x];
		    break undecided_loop;
		}
	    }
	}
	// 未定のマスがなければ終了
	if (firstUndecidedCell == null) {
	    System.out.println("Solved");
	    return board;
	}
	// 未定のマスがあれば，そのマスに仮の数を置く
	for (int nv = 1; nv <= 9; nv++) {
	    if (!firstUndecidedCell.possible[nv]) continue;
	    try {
		// 仮置きするための盤面の準備
		Board newboard = new Board();
		newboard.cells = new Cell[9][9];
		for (int y = 0; y < 9; y++) {
		    for (int x = 0; x < 9; x++) {
			newboard.cells[y][x] = new Cell(x, y);
			newboard.cells[y][x].value = board.cells[y][x].value;
			for (int v = 1; v <= 9; v++) {
			    newboard.cells[y][x].possible[v] = board.cells[y][x].possible[v];
			}
		    }
		}

		newboard.cells[firstUndecidedCell.y][firstUndecidedCell.x].value = nv;
		System.out.println("Fixed Temporaly at (" + firstUndecidedCell.y + "," + firstUndecidedCell.x + ") => " + nv);
		solve(newboard);
		return newboard;
	    } catch (Exception e) {
		System.out.println("Temporaly-fixing failed");
	    }
	}
	throw new Exception("Now possible value");
    }
}

