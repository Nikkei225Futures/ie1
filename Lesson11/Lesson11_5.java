public class Lesson11_5 {
  public static void main (String[] args) {
    java.util.Scanner scan = new java.util.Scanner(System.in);
    User u = new User();

    // ================ ここに記述 =================
    int age = 0;
    while(u.getName().equals("名無し") || u.getAge() == 0){
      try{
        System.out.print("ユーザーネーム: ");
        u.setName(scan.nextLine());

        System.out.print("年齢: "); 
        String ageStr = scan.nextLine();
        try{
          age = Integer.parseInt(ageStr);
        } catch (NumberFormatException e){
          System.out.println("年齢の入力が int 型ではないため、エラーが発生しました");
        }
        u.setAge(age);

      } catch (NameOutOfBoundsException e) {
        System.out.println(e);
      } catch (AgeOutOfBoundsException e) {
        System.out.println(e);
      }
    }
    System.out.println("名前:" + u.getName() + ", 年齢:" + u.getAge());
    // ===========================================
    
    scan.close();
  }
}
