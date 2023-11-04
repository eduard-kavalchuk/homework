package home_work_1;

import java.util.Objects;

class One {
    public void Greet(String name) {
        if (Objects.equals(name, "Вася")) {
            System.out.println("Привет!");
            System.out.println("Я тебя так долго ждал.");
        }
        else {
            if (Objects.equals(name, "Анастасия")) {
                System.out.println("Я тебя так долго ждал.");
            }
            else 
                System.out.println("Добрый день, а вы кто?");
        }
    }
}

class Two {
    public void Greet(String name) {
        if (Objects.equals(name, "Вася")) {
            System.out.println("Привет!");
            System.out.println("Я тебя так долго ждал.");
        }
        else if (Objects.equals(name, "Анастасия")) {
            System.out.println("Я тебя так долго ждал.");
        }
        else 
            System.out.println("Добрый день, а вы кто?");
    }
}

class Three {
    public void Greet(String name) {
        switch(name.compareTo("Вася")) {
            case 0:
                System.out.println("Привет!");
                System.out.println("Я тебя так долго ждал.");
                break;
            default:
                switch(name.compareTo("Анастасия")) {
                    case 0:
                        System.out.println("Я тебя так долго ждал.");
                        break;
                    default:
                        System.out.println("Добрый день, а вы кто?");
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

        One one = new One();
        one.Greet(args[0]);

        Two two = new Two();
        two.Greet(args[0]);

        Three three = new Three();
        three.Greet(args[0]);
    }
}
