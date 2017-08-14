import java.io.*; // for BufferedReader

public class BigIntSimpleTest {

    public static void main(String[] args) throws IOException {
        BigInt num = new BigInt("1"), num1, num2;
        BigInt nineninenine = new BigInt(999);
        BufferedReader stdin = new BufferedReader(new InputStreamReader(
                System.in));
        System.out.println("Constructor test.");
        num = new BigInt(9909);
        num1 = new BigInt("987654321234567898769");
        num2 = new BigInt(num1);
        System.out.println(num + " " + num1 + " " + num2);
        num1.inc();
        System.out.println(num + " " + num1 + " " + num2);
        while (num.compareTo(nineninenine) != 0) {
            System.out.print("A big integer (999 to stop): ");
            num = new BigInt(stdin.readLine());
            if (nineninenine.compareTo(num) != 0) {
                System.out.println(num);
                System.out.print("Another big integer: ");
                num1 = new BigInt(stdin.readLine());
                System.out.println(num1);
                if (num.compareTo(num1) == 1) {
                    System.out.println(num + " is bigger.");
                } else if (num.compareTo(num1) == -1) {
                    System.out.println(num1 + " is bigger.");
                } else {
                    System.out.println(" They are both " + num);
                }
                num2 = num1.plus(num);
                System.out.println("The sum is:  " + num2);
                num2 = num.times(num1);
                System.out.println("The product is: " + num2);
            }
        }
    }
}