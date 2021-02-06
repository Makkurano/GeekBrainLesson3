import java.util.Random;
import java.util.Scanner;

public class Lesson32 {

    public static void main(String[] args) {

        lesson32();

    }

    private static void lesson32() {
        Scanner sc = new Scanner(System.in);
        int maxLength = 14; // Максимальная длина зашифрованного слова
        int lonWord; // Далее примет значение более короткого слова из загаданного или введенного
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
                "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak",
                "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear",
                "pepper", "pineapple", "pumpkin", "potato"};
        for (int i = 0; i < words.length; i++) { // Играть, пока не будут отгаданы все слова массива
            int randomWord = new Random().nextInt(words.length);
            String randWord = (words[randomWord]); // Берем рандомное слово из массива
            System.out.println("Загадано слово. Введите вашу версию.");

            while (true) {
                System.out.println(randWord);
                String scan = sc.next();
                String scanSmall = scan.toLowerCase(); // Приводим к строчным введенные слова
                if (randWord.equals(scanSmall)) { // Условие победы
                    System.out.println("Вы угадали! Ответ " + randWord);
                    break;
                }
                if (scanSmall.length() >= randWord.length()) { // Вычисляем какое слово короче
                    lonWord = randWord.length();
                } else {
                    lonWord = scanSmall.length();
                }

                for (int j = 0; j < lonWord; j++) { // Цикл посимвольного сравнения
                    char arrayLetter = randWord.charAt(j);
                    char userLetter = scanSmall.charAt(j);
                    if (userLetter == arrayLetter) {
                        System.out.print(scanSmall.charAt(j));
                    } else {
                        System.out.print("#");
                    }
                }

                for (int a = lonWord; a < maxLength; a++) { //Добивание оставшихся символов значками сокрытия
                    System.out.print("#");
                }
                System.out.print("\nПопробуйте еще раз");
            }
        }
    }
}

