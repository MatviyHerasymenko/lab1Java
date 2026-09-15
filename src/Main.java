import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть n: ");
        int n = scanner.nextInt();

        int bestPrime = -1;
        int maxOnes = -1;

        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                int ones = countBits(i);

                if (ones > maxOnes) {
                    maxOnes = ones;
                    bestPrime = i;
                }
            }
        }

        if (bestPrime != -1) {
            System.out.println("Шукане просте число: " + bestPrime);
            System.out.println("Двійкова форма: " + toBinaryStringManual(bestPrime));
            System.out.println("Кількість одиниць: " + maxOnes);
        } else {
            System.out.println("Простих чисел у діапазоні до " + n + " не знайдено.");
        }

        scanner.close();
    }

    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int countBits(int number) {
        int count = 0;
        while (number > 0) {
            if (number % 2 == 1) {
                count++;
            }
            number /= 2;
        }
        return count;
    }

    public static String toBinaryStringManual(int number) {
        if (number == 0) {
            return "0";
        }
        String binary = "";
        while (number > 0) {
            binary = (number % 2) + binary;
            number /= 2;
        }
        return binary;
    }
}