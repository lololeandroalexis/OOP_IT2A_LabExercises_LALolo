class Person {
    private String name;
    private int age;

    //getter methods
    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age){
        if(age > 0){
          this.age = age;
        } else {
            System.out.println("Age must be positive.");
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Person p = new Person();

        p.setName("Leandro");
        p.setAge(20);

        System.out.println("Name: " + p.getName());
        System.out.println("Age: " + p.getAge());
    }

}
