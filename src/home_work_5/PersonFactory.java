package home_work_5;

public class PersonFactory {
    public static Person createWithRandomName(String nick, String password) {
        return new Person(nick, password, "abc");
    }
    public static Person createWithRandomRussianName(String nick, String password) {
        return new Person(nick, password, "abc");
    }
    public static Person createWithRandomRealName(String nick, String password) {
        return new Person(nick, password, "abc");
    }
    public static Person createWithNameFromFile(String nick, String password) {
        return new Person(nick, password, "abc");
    }
}
