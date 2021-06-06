import java.util.Random;

interface MineSweeperGUI {
    public void setTextToTile(int x, int y, String text);

    public void win();

    public void lose();
}

public class MineSweeper {

    private final int height;
    private final int width;
    private final int numberOfTiles;
    private final int numberOfBombs;
    private final int[][] table;        //table[][]は周りにある8マスにある地雷の数を表す。但し、-1を地雷とする。

    //追加
    private int openedTilesSum;     //開けたマスの合計、ただし、table[][]が0の場合は1を加算する。
    private int clearSum;           //地雷を除いた全てのマスの合計、ただしtable[][]が0の場合は1を加算する。
    private int[][] tileStats;      //0 = 初期値, 1 = オープンされた状態, 2 = Flagを表す

    public MineSweeper(int height, int width, int numberOfBombs) {
        this.height = height;
        this.width = width;
        this.numberOfTiles = height * width;
        this.numberOfBombs = numberOfBombs;
        this.table = new int[height][width];
        
        //追加フィールド
        this.openedTilesSum = 0;
        this.clearSum = 0;
        this.tileStats = new int[height][width];

        initTable();
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    void initTable() {
        setBombs();

        /* ----- ここから実装してください． ----- */
        for(int i = 0; i < this.height; i++){
            for(int j = 0; j < this.width; j++){
                if(this.table[i][j] != -1){
                    this.table[i][j] = this.getBombsNumAroundSq(i, j);
                    
                    //table[i][j]が0の時はclearSumを+10
                    if(table[i][j] == 0) this.clearSum += 10;
                    this.clearSum += this.table[i][j];
                }
            }
        }
        
        //チェック用
        /*
         for(int i = 0; i < this.height; i++){
            System.out.println();
            for(int j = 0; j < this.width; j++){
                if(this.table[i][j] == -1){
                    System.out.print("*  ");
                }else{
                    System.out.print(this.table[i][j] + "  ");
                }
            }
        }
        System.out.println();
        System.out.println("===================================");
        */
        
    }

    void setBombs() {
        /* ----- ここから実装してください． ----- */
        Random rndm = new Random();
        for(int i = 0; i < this.numberOfBombs; i++){
            int row = rndm.nextInt(this.height);
            int col = rndm.nextInt(this.width);
            
            //ランダムな位置に地雷を設置
            if(this.table[row][col] == -1){     //既に地雷が置かれていればやり直し 
                i--;     
            }else{
                this.table[row][col] = -1;
            }
        }
    }

    public void openTile(int x, int y, MineSweeperGUI gui) {
        /* ----- ここから実装してください． ----- */
        //テスト用
        //System.out.println(this.openedTilesSum + "/" + this.clearSum);
        
        //クリア条件を満たしているとき
        if(this.openedTilesSum == this.clearSum){
            gui.win();
        }

        //範囲外なら(基底条件)
        if(x < 0 || x >= this.width || y < 0 || y >= this.height){
            return;
        }

        //flagなら(基底条件)
        if(this.tileStats[y][x] == 2){
            System.out.println(y + " " + x + " = flag");
            return;
        }

        //開けたマスが地雷かつflagが立っていなければ
        if(this.table[y][x] == -1 && this.tileStats[y][x] != 2){
            //最初に開けたマスが地雷ならリセット
            if(this.openedTilesSum == 0){
                this.resetGame();
                this.openTile(x, y, gui);
                return;
            }
            this.openAllTiles(gui);
            gui.lose();
            return;
        }

        //既に開いている(基底条件)
        if (this.tileStats[y][x] == 1) {
            return;
        }

        //マスを開く
        this.tileStats[y][x] = 1;
        gui.setTextToTile(x, y, String.valueOf(this.table[y][x]));
        this.openedTilesSum += this.table[y][x];
        
        //テスト用
        //System.out.println("this stat = " + this.tileStats[y][x]);

        //クリア条件を満たしているとき
        if (this.openedTilesSum == this.clearSum) {
            gui.win();
        }

        //周りに爆弾が無ければ周りを開く(再帰)
        if(this.table[y][x] == 0){
            this.openedTilesSum += 10;
            this.openTile(x-1,  y-1, gui);
            this.openTile(x,    y-1, gui);
            this.openTile(x+1,  y-1, gui);
            this.openTile(x-1,  y, gui);
            this.openTile(x+1,  y, gui);
            this.openTile(x-1,  y+1, gui);
            this.openTile(x,    y+1, gui);
            this.openTile(x-1,  y+1, gui);
        }
        
    }

    private void resetGame(){
        this.clearSum = 0;
        this.openedTilesSum = 0;
        for(int i = 0; i < this.height; i++){
            for(int j = 0; j < this.width; j++){
                this.table[i][j] = 0;
                this.tileStats[i][j] = 0;
            }
        }
        initTable();
    }

    public void setFlag(int x, int y, MineSweeperGUI gui) {
        /* ----- ここから実装してください． ----- */
        if(this.tileStats[y][x] == 2){
            this.tileStats[y][x] = 0;   //開かれていない状態に戻す
            gui.setTextToTile(x, y, "");

        }else if(this.tileStats[y][x] == 0){
            this.tileStats[y][x] = 2;   //FLAGを立てる
            gui.setTextToTile(x, y, "F");
        }
    }

    private void openAllTiles(MineSweeperGUI gui) {
        /* ----- ここから実装してください． ----- */
        for(int i = 0; i < this.height; i++){
            for(int j = 0; j < this.width; j++){

                gui.setTextToTile(j, i, String.valueOf(table[i][j]));
                if(table[i][j] == -1){
                    gui.setTextToTile(j, i, "●");
                }
            }
        }
    }

    //iとjによって指定されたマスの周りにある地雷の数を返す
    private int getBombsNumAroundSq(int i, int j){
        int bombs = 0;
        int iDest = i+1, iOrg = i;
        int jDest = j+1, jOrg = j;

        for(i = iOrg-1; i <= iDest; i++){
            if(i == -1) i++;
            if(i == this.height) break;

            for(j = jOrg-1; j <= jDest; j++){
                if(j == -1) j++;
                if(j == this.width) break;

                if(this.table[i][j] == -1){
                    bombs++;
                }
            }
        }
        return bombs;
    }

}
