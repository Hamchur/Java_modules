import java.util.Scanner;

public class Program {
    static int coffee = 0;

    static public int sqrt(int num) {
        int i = 1;
        while (i * i < num) {
            i++;
        }
        return i;
    }

    static public void summa(long num) {
        int sumDigits = 0;
        if (num == 1 || num == 0) {
            return;
        }
        while (num > 0) {
            sumDigits += num % 10;
            num /= 10;
        }
        for (int i = 2; i < sqrt(sumDigits); i++) {
            if (sumDigits % i == 0) {
                return;
            }
        }
        coffee++;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long num = input.nextInt();

        do {
           if (num < 2){
                System.err.println("IllegalArgument");
                System.exit(-1);
            }
            else {
                num = input.nextInt();
                summa(num);
            }
        } while (num != 42);
        System.out.println("Count of coffee-request - " + coffee);
        System.exit(0);
    }
}

