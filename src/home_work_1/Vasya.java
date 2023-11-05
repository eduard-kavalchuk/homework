package home_work_1;

import java.util.Objects;

class One {
    public String Greet(String name) {
        if (Objects.equals(name, "Вася")) {
            return "Привет!\nЯ тебя так долго ждал.";
        }
        else {
            if (Objects.equals(name, "Анастасия")) {
                return "Я тебя так долго ждал.";
            }
            else
                return "Добрый день, а вы кто?";
        }
    }
}

class Two {
    public String Greet(String name) {
        if (Objects.equals(name, "Вася")) {
            return "Привет!\nЯ тебя так долго ждал.";
        }
        else if (Objects.equals(name, "Анастасия")) {
            return "Я тебя так долго ждал.";
        }
        else
            return "Добрый день, а вы кто?";
    }
}

class Three {
    public String Greet(String name) {
        switch(name.compareTo("Вася")) {
            case 0:
                return "Привет!\nЯ тебя так долго ждал.";
            default:
                switch(name.compareTo("Анастасия")) {
                    case 0:
                        return "Я тебя так долго ждал.";
                    default:
                        return "Добрый день, а вы кто?";
                }
        }
    }
}

public class Vasya {
    public static void main(String args[]) {
        if (args.length != 1) {
            System.err.println("Usage: Vasya name");
            return;
        }

        Vasya vasya = new Vasya();
        System.out.println(vasya.greet1(args[0]));
        System.out.println(vasya.greet2(args[0]));
        System.out.println(vasya.greet3(args[0]));
    }

    public String greet1(String s) {
        One one = new One();
        return one.Greet(s);
    }

    public String greet2(String s) {
        Two two = new Two();
        return two.Greet(s);
    }

    public String greet3(String s) {
        Three three = new Three();
        return three.Greet(s);
    }
}
