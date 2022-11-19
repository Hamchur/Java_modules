import java.util.ArrayList;
import java.util.List;

public class Program {
    private  static final int Max_Modulo = 1000;
    public static volatile int threadSum = 0;

    private static short[] initArr(int size){
        short[] arr = new short[size];
        while (size > 0){
            arr[--size] = (short)(-Max_Modulo + (Math.random() * (2 * Max_Modulo)));
        }
        return arr;
    }

    private static void checkArgs(String[] args){
        if (args.length != 2){
            System.err.println("Error: wrong arguments numbers");
            System.exit(-1);
        }
        if ((!args[0].matches("--arraySize=\\d+")) || (!args[1].matches("--threadsCount=\\d+"))){
            System.err.println("Error: wrong flags");
            System.exit(-1);
        }
    }

    private static void displayArr(short[] arr){
        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);
    }

    private static void displaySum(short[] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        System.out.println(("Sum: " + sum));
    }

    public static void main(String[] args) {
        checkArgs(args);
        int arrSize = Integer.parseInt(args[0].split("=")[1]);
        int threadCount = Integer.parseInt(args[1].split("=")[1]);
        short[] arr =initArr(arrSize);
        displaySum(arr);
        int Size = arrSize / threadCount;
        int start = 0;
        int end = Size - 1;
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < threadCount - 1; i++){
            threads.add(new Thread(new SumOfThreads(i, start, end, arr)));
            start += Size;
            end += Size;
        }
        threads.add(new Thread(new SumOfThreads(threadCount - 1, start, arrSize - 1, arr)));
        for (Thread thread: threads){
            thread.start();
        }
        for (Thread th: threads){
            try {
                th.join();
            }
            catch (InterruptedException interruptedException){
                throw new RuntimeException(interruptedException);
            }
        }
        System.out.println("Sum by threads: " + threadSum);
    }
}
