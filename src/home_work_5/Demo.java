package home_work_5;

public class Demo {
    public static void main(String[] args) {
        Person person = PersonFactory.createWithRandomRussianName("nick", "password");
        System.out.println(person.getName());
        System.out.println(person.getNick());
        System.out.println(person.getPassword());
    }



}
