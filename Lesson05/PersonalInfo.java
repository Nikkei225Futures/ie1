public class PersonalInfo {

  String name;
  int age;

  // ----------- add here (Lesson05_4) ----------
  public PersonalInfo(String n, int a){
    this.name = n;
    this.age = a;
  }

  // --------------------------------------
  
  // ----------- add here (Lesson05_5) ----------
  public PersonalInfo(String n){
    this(n, 0);
  }

  public PersonalInfo(int a){
    this("名無し", a);
  }

  public PersonalInfo(){
    this("名無し", 0);
  }
  //----------------------------------------

  public void printInfo() {
    System.out.println("name: " + name + ", age: " + age);
  }
}
