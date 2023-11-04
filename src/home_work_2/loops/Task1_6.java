package home_work_2.loops;

class Task1_6 {
    public static void main(String[] args) {
        byte step = 0;
        for (int cycle = 0; cycle <= 1; cycle++) {
            for (int i = 1; i <= 10; i++) {
                for (int j = 2 + step; j <= 5 + step; j++) {
                    System.out.printf("%-7s", j + " x " + i);
                    System.out.printf("=");
                    System.out.printf("%3s", (i * j));
                    System.out.printf("    ");
                }
                System.out.println();
            }
            step = 4;
            System.out.println();
        }
    }
}
