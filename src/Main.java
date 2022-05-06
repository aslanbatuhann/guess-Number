import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        int number = rand.nextInt(100);

        Scanner scan = new Scanner(System.in);
        int right = 0;
        int selected;
        int[] wrong = new int[5];
        boolean isWin = false;
        boolean isWrong = false;
        int i = 0;

        while (right < 5) {
            System.out.println("Lütfen Tahmininizi giriniz (0-99): ");
            selected = scan.nextInt();


            if (selected < 0 || selected > 99) {
                System.out.println("Lütfen 0-100 arasında bir değer giriniz.");
                if (isWrong) {
                    right++;
                    System.out.println("Çok fazla hatalı giriş yaptınız. Kalan hak : " + (5 - right));
                } else {
                    isWrong = true;
                    System.out.println("Bir daha hatalı girişinizde hakkınızdan düşülecektir.");

                }
                continue;
            }
            if (selected == number) {
                System.out.println("Tebrikler , doğru tahmin ettiniz!");
                break;
            } else {
                System.out.println("Hatalı bir sayı girdiniz ! ");
                if (selected > number) {
                    System.out.println(selected + " sayısı, gizli sayıdan büyüktür.");
                    right++;
                    System.out.println("Kalan hakkınız : " + (5 - right));
                } else if (selected < number) {
                    System.out.println(selected + " sayısı, gizli sayıdan küçüktür.");
                    right++;
                    System.out.println("Kalan hakkınız : " + (5 - right));
                }
                wrong[i++] = selected;
            }
        }
        if (!isWin) {
            System.out.println("Kaybettiniz ! ");
        }
        System.out.println("Tahminleriniz : " + Arrays.toString(wrong));
        System.out.println("GİZLİ SAYIMIZ: " + number + " idi.");
    }
}
