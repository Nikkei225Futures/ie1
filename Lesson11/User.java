public class User {

  private String name;
  private int age;

  public User() {
    this.name = "名無し";
    this.age = 0;
  }
  // ============= ここに記述 ==============
  public void setName(String name) throws NameOutOfBoundsException{
    if(name.length() <= 1 || name.length() >= 8){
      throw new NameOutOfBoundsException("設定できない名前です:" + name);
    }else{
      this.name = name;
    }
  }
  public void setAge(int age) throws AgeOutOfBoundsException{
    if(age < 0 || age > 120){
      throw new AgeOutOfBoundsException("設定できない年齢です:" + age);
    }else{
      this.age = age;
    }
    
  }
  // =====================================

  public String getName() {
    return this.name;
  }

  public int getAge() {
    return this.age;
  }
}
