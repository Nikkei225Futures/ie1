public class Student {
    public int id;
    public int grade;
    public String name;
    
    public void printInfo(){
        System.out.println("*****************************");
        System.out.println("学籍番号: " + this.id);
        System.out.println("学年: " + this.grade);
        System.out.println("氏名: " + this.name);
        System.out.println("*****************************");
    }
    
}