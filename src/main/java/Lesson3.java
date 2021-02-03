import java.util.Scanner;

public class Lesson3 {

    public static void main(String[] args) {

        lesson3();
    }
        // Метод сканирует вводы пользователя
        private static int scan() {
        Scanner sc = new Scanner(System.in);
        int scan = sc.nextInt();
        return scan;
        }
        // Метод для сокращения фраз и проверки продолжения игры
        private static int again() {
            System.out.println("Повторить игру еще раз?\nВведите 1, " +
                    "что бы продолить, 0 что бы закончить");
            int gameReStart = scan();
            if (gameReStart == 0) {
                gameReStart = 0;
            } else if (gameReStart == 1) {
                gameReStart = 1;
            }
            return gameReStart;
        }

        private static void lesson3() {
            int a = 0; // Минимальное значение диапазона
            int b = 9; // Максимальное значение диапазона
            int maxTry = 3; // Количество попыток
            int gameProc = 1; // Триггер продолжения игры для бесконечного цикла
            System.out.println("Игра в угадывание числа от 0 до 9");
            while (gameProc == 1) { // Бесконечный цикл, пока пользователь жаждет играть
                System.out.println("Загадано число!");
                int randnum = a + (int) (Math.random() * b);
                for (int w = 0; w < maxTry; w++) {      //Цикл для трех попыток
                    System.out.println("Введите ваш вариант");
                    int userAnswer = scan();
                    if (userAnswer == randnum) {
                        System.out.println("Вы угадали!");
                            gameProc = again();
                            break;
                    } else if (userAnswer > randnum) {
                        System.out.println("Вы ввели число больше загаданного. " +
                                "У вас осталось попыток " + ((maxTry - 1) - w));
                    } else if (userAnswer < randnum) {
                        System.out.println("Вы ввели число меньше загаданного. " +
                                "У вас осталось попыток " + ((maxTry - 1) - w));
                    }
                }
                System.out.println("Закончились попытки.\nБыло загадано: " + randnum);
                gameProc = again(); // Проверка желания пользователя продолжать
            }
        }
}


