import java.util.Scanner;

public class Study01_4 {
    public static void main(String[] args){
        int i;  //ループカウンタ用変数
        int daysInMonth[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};    //1月1日からの日数カウント用
        
        //コマンドライン引数に対応する文字列の配列を作成
        String dayOfTheWeek[] = {"sun", "mon", "tue", "wed", "thu", "fri", "sat"};
        String dayOfTheWeekJP[] = {"日曜日", "月曜日", "火曜日", "水曜日", "木曜日", "金曜日", "土曜日"};
        String baseJP[] = {"日曜日", "月曜日", "火曜日", "水曜日", "木曜日", "金曜日", "土曜日"};

        //sunなら0個先の要素, monなら1個先,...　のようになるように差を決める 
        int diff[] = {0, 1, 2, 3, 4, 5, 6};
        int differenceFromBase = 0;
        for(i = 0; i < dayOfTheWeek.length; i++){
            if(dayOfTheWeek[i].equals(args[0])){
                differenceFromBase = diff[i];
            }
        }

        //曜日のインデックスが経過日数 mod 7 と合うように入れ替える
        for(i = 0; i < dayOfTheWeek.length; i++){
            if(differenceFromBase + i > 6){
                dayOfTheWeekJP[i] = baseJP[i + differenceFromBase - 7];
            }else{
                dayOfTheWeekJP[i] = baseJP[i + differenceFromBase];
            }
        }
        
        while(true){
            //入力
            System.out.println("曜日を調べる日の情報を入力して下さい.");
            System.out.print("> ");
            Scanner scan = new Scanner(System.in);
            String inputMonth = scan.next();
            String inputDay = scan.next();
            int month = Integer.parseInt(inputMonth);
            int day = Integer.parseInt(inputDay);

            //0 0なら終了
            if(month == 0 && day == 0){
                System.out.println("終了します");
                break;
            }

            //1月1日からの日数を求める(うるう年ではない年とする)
            int days = 0;
            for(i = 0; i < month; i++){
                days += daysInMonth[i];
            }
            days += day;
            days -= 1;

            //結果を出力
            int index = days % 7;
            System.out.println(month + "月" + day + "日は" + dayOfTheWeekJP[index] + "です.");

        }
    }
}