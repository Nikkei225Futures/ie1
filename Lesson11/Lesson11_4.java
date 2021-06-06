public class Lesson11_4 {
  public static void main (String[] args) {
    String[] names = {"ヒロ", "ア", "ルイス・イ・ピカソ", "ヤマダ", "タロウ"};
    int[] ages = {18, 25, 20, 200, -1};
    User u = new User();

    for (int i = 0; i < names.length; i++) {
      try {
        u.setName(names[i]);
        u.setAge(ages[i]);
        System.out.println("名前:" + u.getName() + ", 年齢:" + u.getAge());
      } catch (NameOutOfBoundsException e) {
        System.out.println(e);
      } catch (AgeOutOfBoundsException e) {
        System.out.println(e);
      }
    }
  }
}
