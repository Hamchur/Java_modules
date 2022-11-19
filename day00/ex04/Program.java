import java.util.Scanner;

public class Program {
    private static final int max = 10;
    private static final int symbols = 65536;
    private static final int bar = 10;

    public static void printGraph(char[] letters, int[] eachLetterAmount){
        int max = eachLetterAmount[0];
        System.out.println();
        System.out.println();
        for(int i = 0; i < max; i++) {
            if(eachLetterAmount[i] * bar / max == 10) {
                System.out.print(eachLetterAmount[i] + "\t");
            }
        }
        System.out.println();
        for (int i = max; i > 0; i--) {
            for (int j = 0; j < max; j++) {
                if(eachLetterAmount[j] != 0) {
                    if (eachLetterAmount[j] * bar / max >= i) {
                        System.out.print("#\t");
                    }
                    if (eachLetterAmount[j] * bar / max == i - 1) {
                        System.out.print(eachLetterAmount[j] + "\t");
                    }
                }
            }
            System.out.println();
        }
        for(int i = 0; i < max; i++) {
            if(eachLetterAmount[i] != 0) {
                System.out.print(letters[i] + "\t");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(">_");
        String inputLine = scanner.nextLine();
        if (inputLine.length() == 0) {
            System.err.println("Empty string");
            System.exit(-1);
        }

        int[] eachCharFrequency = new int[symbols];
        char[] inputArr = inputLine.toCharArray();
        for (int i = 0; i < inputLine.length(); i++) {
            eachCharFrequency[inputArr[i]]++;
        }

        char[] tenSortedChars = new char[max];
        int[] tenSortedCharsAmount = new int[max];
        for (int j = 0; j < max; j++) {
            int max = eachCharFrequency[0];
            for (int i = 0; i < symbols; ++i) {
                if (max < eachCharFrequency[i]) {
                    max = eachCharFrequency[i];
                    tenSortedChars[j] = (char) i;
                }
            }
            tenSortedCharsAmount[j] = max;
            eachCharFrequency[(int) tenSortedChars[j]] = 0;
        }

        printGraph(tenSortedChars, tenSortedCharsAmount);
    }
}