import java.util.InputMismatchException;

public class Study04 {
    private static boolean isEnd = false; // 戦闘が終了したかどうか

    public static void main(String[] args) {
        // 変数
        int rounds = 1; // ラウンドのカウンタ
        int selectedCompId = 0; // 選択された仲間のID

        // 各キャラクターのインスタンス生成
        Hero hero = new Hero("勇者", 100, 20); // id = 0
        // 仲間候補
        Character compCands[] = new Character[3];
        compCands[0] = new Warrior("戦士", 150, 30); // id = 1
        compCands[1] = new Priest("僧侶", 100, 10);
        compCands[2] = new Dancer("踊り子", 100, 10);
        Enemy enemy = new Enemy("魔王", 300, 25);
        // フィールド上のキャラクター [0]は選択したキャラクター(仲間), [1]はHero, [2]はEnemy
        Character charasOnField[] = new Character[3];
        charasOnField[1] = hero;
        charasOnField[2] = enemy;

        // 勇者のステータスを表示
        hero.showStatus();
        System.out.println();

        // 仲間の選択
        System.out.println(">> 仲間候補のキャラクター");

        // 仲間の候補のステータスを出力
        for (int i = 0; i < compCands.length; i++) {
            compCands[i].showStatus();
        }

        // 正しいIDが入力されるまで仲間の候補のIDを選択
        while (selectedCompId < 1 || selectedCompId > compCands.length) {

            try {
                System.out.println(">> 連れて行く仲間を一人選んでください(IDを入力)");
                System.out.print("ID: ");
                selectedCompId = new java.util.Scanner(System.in).nextInt();
                System.out.println(selectedCompId);
            } catch (InputMismatchException e) {
                continue;
            }

        }
        charasOnField[0] = compCands[selectedCompId - 1];
        System.out.println(">> " + compCands[selectedCompId - 1].getName() + "が仲間になった!");

        System.out.println();
        System.out.println(">> 現在のパーティ");
        // パーティーの出力
        for(int i = 0; i < charasOnField.length; i++){
            charasOnField[i].showStatus();
        }

        // 戦闘開始
        System.out.println("-------BATTLE START-------");
        System.out.println();
        endBattle: 
        while (true) {
            System.out.println("-------ラウンド " + rounds + "-------");
            System.out.println();
            for (int i = 0; i < charasOnField.length; i++) {
                battle(charasOnField[i], charasOnField, 1, 2);
                System.out.println();
                if (isEnd) {
                    break endBattle;
                }
            }
            rounds++;
        }

    }

    /*
     * 戦闘用メソッド 攻撃またはスキルを発動するキャラクター, フィールド上のキャラクターの配列(charasOnField), 
     * CharasOnField上のHero・Enemyのインデックスを引数に取り、 各クラスに応じた行動をとる。
     * パーティーが全滅するか、EnemyのHPが0になった場合、isEndをtrueにして戦闘を終了させる。 
     */
    private static void battle(Character characterTurn, Character[] charasOnField, int heroIdx, int enemyIdx) {
        // hpが1以上なら攻撃もしくはスキルを発動
        if (characterTurn.getHp() > 0) {
            // インスタンスがEnemyクラスの場合
            if (characterTurn instanceof Enemy) {
                Enemy enem = (Enemy) characterTurn;
                Hero[] party = getParty(charasOnField, enemyIdx);
                enem.attack(party);

                // 味方全員のhpが0以下なら終了
                boolean allHpZero = true;
                for(int i = 0; i < party.length; i++){ 
                    allHpZero &= isHpRemain(party[i]);
                }
                if (allHpZero) {
                    isEnd = true;
                    System.out.println("パーティーが全滅した!");
                    System.out.println();
                    System.out.println("--------YOU LOSE-------");
                }

                // インスタンスがPriestクラスの場合
            } else if (characterTurn instanceof Priest) {
                Priest priest = (Priest) characterTurn;
                priest.skill(charasOnField[heroIdx]);

                // インスタンスがDancerクラスの場合
            } else if (characterTurn instanceof Dancer) {
                Dancer dancer = (Dancer) characterTurn;
                dancer.skill(charasOnField[heroIdx]);

                // インスタンスがWarriorクラスの場合
            } else if (characterTurn instanceof Warrior) {
                Warrior warrior = (Warrior) characterTurn;
                warrior.skill(charasOnField[enemyIdx]);
                if (isHpRemain(charasOnField[enemyIdx])) {
                    isEnd = true;
                    System.out.println();
                    System.out.println("--------YOU WIN-------");
                }

                // インスタンスがHeroクラスの場合
            } else if (characterTurn instanceof Hero) {
                Hero hero = (Hero) characterTurn;
                hero.attack(charasOnField[enemyIdx]);
                hero.resetStatus();
                if (isHpRemain(charasOnField[enemyIdx])) {
                    isEnd = true;
                    System.out.println();
                    System.out.println("--------YOU WIN-------");
                }
            }

            // characterTurnのhpが無い場合、ただしenemyは除く
        } else {
            if (characterTurn instanceof Priest || characterTurn instanceof Dancer || characterTurn instanceof Warrior) {
                System.out.println(">> " + characterTurn.getName() + "は倒れているのでスキルを発動できない!");

            } else if (characterTurn instanceof Hero) {
                System.out.println(">> " + characterTurn.getName() + "は倒れているので攻撃できない!");
            }
        }
    }

    // 引数cのhpが0以下ならtrueそれ以外はfalseを返す
    private static boolean isHpRemain(Character c) {
        if (c.getHp() <= 0) {
            return true;
        } else {
            return false;
        }
    }

    // charasOnFieldのヒーローと仲間のオブジェクトをHeroクラスとして返す(Enemyクラスは除く)
    private static Hero[] getParty(Character[] charasOnField, int enemyIdx){
        Character cpy[] = new Character[charasOnField.length - 1];
        Hero party[] = new Hero[charasOnField.length - 1];
        for(int i = 0; i < cpy.length; i++){
            cpy[i] = charasOnField[i];
        }
        for(int i = enemyIdx; i < cpy.length; i++){
            cpy[i] = charasOnField[i + 1];
        }
        
        for(int i = 0; i < party.length; i++){
            party[i] = (Hero)cpy[i];
        }

        return party;
    }
}