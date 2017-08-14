import java.io.*; // for BufferedReader
import java.util.*; // for StringTokenizer

public class Test {
    private static int max = 100;

    public static void main(String[] args) throws IOException {
        int[] max_bloc_ans = {12,23,-3,-1,-1,-2,2,3,4,25,25,8,8,23,23,23,23,23,23,10,8,9,17,15,5,3,3,3,3,3,3,3,3,3,5};
        int[] large_ans = {0,5,2,3,0,0,7,8,9,0,6,1,19,4,4,16,16,4,4,9,1,18,0,1,1,2,3,4,5,6,7,8,9,10,0};
        InputStream input_data = new FileInputStream(
                "data.txt");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(input_data));
        in.mark(1000);
        int[] numbers = new int[max];
        int size, maxblock, largest, ct = 0;
        boolean allgood = true;
        System.out.println("This program written by: " + ArrayUtilities.myName());
        System.out.println("out and reverse test");
        size = input(numbers, max, in);
        for (int i = 1; i <= 5; i++){
            ArrayUtilities.out1(numbers, size);
            ArrayUtilities.out2(numbers, size);
            ArrayUtilities.reverse(numbers, size);
            ArrayUtilities.out3(numbers, size);
            size = input(numbers, max, in);
            System.out.println();
        }
        in.reset();
        System.out.println();
        System.out.println("maxblock and largest test");
        size = input(numbers, max, in);
        while (size > 0) {
            System.out.print(".");
            maxblock = ArrayUtilities.maxBlock(numbers, size);
            largest = ArrayUtilities.largest(numbers,  size);
            if (maxblock != max_bloc_ans[ct]) {
                allgood = false;
                System.out.println("*** Error in maxblock #" + ct + "   " + maxblock + " should be " + max_bloc_ans[ct]);
            }
            if (numbers[largest] != numbers[large_ans[ct]]) {
                allgood = false;
                System.out.println("*** Error in largest #" + ct + "   " + numbers[largest] + " should be " + numbers[large_ans[ct]]);
            }
            size = input(numbers, max, in);
            ct++;
        }
        System.out.println();
        System.out.println("Test run on all " + ct + " tests complete.");
        if (allgood)
            System.out.println("ALL SEEMS GOOD.");
        System.out.println("This program written by: " + ArrayUtilities.myName());
    }

    public static int input(int[] a, int max, BufferedReader in)
            throws IOException {
        int num, size;
        size = 0;
        String inputLine = in.readLine(); // All input must be on a single line
        if (inputLine == null) // no blank line at bottom of file
            inputLine = " ";
        StringTokenizer input = new StringTokenizer(inputLine);
        while (input.hasMoreTokens() && (size <= max)) { // extract the integers
            num = Integer.parseInt(input.nextToken()); // from the input line
            a[size] = num;
            size++;
        }
        if (input.hasMoreTokens()) {
            System.out.print("Too much data.  Program terminates.");
            System.exit(0);
        }
        return size;
    }

}