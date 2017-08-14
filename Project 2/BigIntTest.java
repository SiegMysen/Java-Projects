public class BigIntTest {

    public static void main(String[] args) {
        String result;
        String answers[] = {
                "765423122",
                "3141592653589793238462643383279502884197169",
                "3141592653589793238462643383279502884197169-3141592653589793238462643383279502884197169",
                "3141592653589793238462643383279502884197169-3141592653589793238462643383279502884197170",
                "Result 0: 76159080909572301618801306271765994056795952743",
                "Result 1: 76159080909572301618801306271765994056795952743",
                "Result 2: 275546143282785844218295114048973991262329549079",
                "Result 3: 474933205655999386817788921826181988467863145415",
                "Result 4: 674320268029212929417282729603389985673396741751",
                "Result 5: 873707330402426472016776537380597982878930338087",
                "Result 6: 1073094392775640014616270345157805980084463934423",
                "Result 7: 1272481455148853557215764152935013977289997530759",
                "Result 8: 1471868517522067099815257960712221974495531127095",
                "Result 9: 1671255579895280642414751768489429971701064723431",
                "Result  0:  0, 1671255579895280642414751768489429971701064723431",
                "Result  1: 12, 923111384493397077484406109632235316",
                "Result  2: 12, 8855938824803760374140659523420255787705911043364",
                "Result  3: 10, 142818398801868766860783002948",
                "Result  4: 10, 525971483542521480630865371081732",
                "Result  5: 10, 382261688350360562863315939887816116",
                "Result  6: 10, 92411357603865105015070629264587550404",
                "Result  7: 10, 10129618118960195826683072162052124233252",
                "Result  8: 10, 612956838166204092808266359396001478197188",
                "Result  9: 10, 23368574069116277525019264486124485405100052",
                "Result 10: 10, 615888835596908250743802256744486180163253636",
                "Result 11: 10, 12005469371703927618065109648795760195783118084",
                "Result 12: 10, 182080335799636349089994031781291628908114265732",
                "Result 13: 10, 2233902865739563240082910566627029307611706547828",
                "Result 14: 10, 22858880688872314867394565439276140401782655080772",
                "Result 15:  8, 14139034228527889368303044",
                "Result 16:  8, 39040137310965014383171492",
                "Result 17:  8, 101470717280641020420426772",
                "Result 18:  8, 249949826381879936339972708",
                "Result 19:  8, 586846447141739532875101732",
                "Result 20:  8, 1319648933943846457504099684" };
        int ct, checkCt = 0;
        BigInt num1, num2, sum;
        sum = new BigInt(0); // make the compiler happy
        BigInt limit = new BigInt(10);
        System.out.println();
        System.out.print("Program written by " + BigInt.myName() + ".");
        System.out.println();
        System.out.println();
        System.out.print("Testing constructors.");
        num1 = new BigInt(765423122);
        result = num1.toString();
        check(result, answers[checkCt++]);
        num2 = new BigInt("3141592653589793238462643383279502884197169");
        result = num2.toString();
        check(result, answers[checkCt++]);
        num1 = new BigInt(num2);
        result = num1.toString() + "-" + num2.toString();
        check(result, answers[checkCt++]);
        num2.inc();
        result = num1.toString() + "-" + num2.toString();
        check(result, answers[checkCt++]);
        System.out.println();
        System.out.print("Testing plus.");
        num1 = new BigInt(1);
        num2 = new BigInt(0);
        num2 = num1.plus(num2);
        num1 = new BigInt(0);
        for (int i = 0; i < 10; i++) {
            for (ct = 1; ct <= 225; ct++) {
                sum = num1.plus(num2);
                num1 = new BigInt(num2);
                num2 = new BigInt(sum);
            }
            result = "Result " + i + ": " + sum;
            check(result, answers[checkCt++]);
            num1 = new BigInt(i);
            num2 = new BigInt(2 * i + 1);
        }
        System.out.println();
        System.out.print("Testing everything.");
        for (ct = 1; ct <= 24; ct++)
            limit = limit.times(new BigInt(10));
        num1 = new BigInt(1);
        num2 = new BigInt(0);
        num2 = num1.plus(num2);
        num1 = new BigInt(0);
        for (int i = 0; i <= 20; i++) {
            ct = 0;
            while (sum.compareTo(limit) == -1) {
                ct = ct + 1;
                if (ct % 4 == 0)
                    sum = num1.times(num2);
                else if (ct % 4 == 1)
                    sum = num1.plus(num2);
                else if (ct % 4 == 2)
                    sum = num2.times(num1);
                else
                    sum = num2.plus(num1);
                if (num1.compareTo(num2) == -1)
                    sum = sum.plus(new BigInt(0));
                if (num1.compareTo(num2) == 1)
                    sum.inc();
                if (num2.compareTo(num1) == -1) {
                    sum.inc();
                    sum.inc();
                }
                if (num2.compareTo(num1) == 1)
                    sum = sum.plus(new BigInt(4));
                num1 = new BigInt(num2);
                num2 = new BigInt(sum);
            }
            result = "Result " + (i < 10 ? " " : "") + i + ": "
                    + (ct < 10 ? " " : "") + ct + ", " + sum;
            check(result, answers[checkCt++]);
            num1 = new BigInt(i);
            num2 = new BigInt(2 * i + 1);
            sum = new BigInt(0);
        }
    }

    private static void check(String s1, String s2) {
        if (s1.compareTo(s2) == 0)
            System.out.print(".");
        else {
            System.out.println();
            System.out.println("*** Error. Answers don't match: ");
            System.out.println("Yours: " + s1);
            System.out.println("Mine:  " + s2);
        }
    }

}