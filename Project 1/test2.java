public class test2 {
	
	public static String millis(long n) {
		String rtn;
		if (n < 10)
			rtn = "00" + n;
		else if (n < 100)
			rtn = "0" + n;
		else
			rtn = String.valueOf(n);
		return rtn;
	}

    public static void main(String[] args) {
        String answers[] = { "1 1 false 0 36", "2 2 false 0 36", "3 2 false 0 36",
                "4 3 false 0 36", "5 2 false 0 36", "6 4 true 1 36",
                "7 2 false 1 36", "8 4 false 1 36", "9 3 false 1 36",
                "1 4 false 1 36", "1 2 false 1 36", "1 6 true 2 36",
                "1 2 false 2 36", "1 4 false 2 36", "1 4 false 2 36",
                
                "1 30 true 251 1296", "2 2 false 733 3136",
                "3 8 false 963 4356", "3 12 true 785 3600",
                "7 4 false 1789 7744", "8 4 false 198 900",
                "3 4 false 946 4356", "4 6 false 1056 4356",
                "7 12 true 1756 7056", "9 2 false 2400 10000",
                "6 2 false 1712 7056", "7 2 false 1807 7744", "6 4 false 1697 7056",
                "3 8 false 886 3600", "8 16 true 2120 9216",
                
                "3 8 false 9805 40000", "8 8 false 218481 883600",
                "3 24 false 85217 345744", "7 24 false 179193 725904",
                "5 16 false 132921 540225", "2 16 false 52524 213444",
                "1 48 true 42516 173056", "1 4 false 42044 171396",
                "4 24 true 107992 440896", "5 4 false 138236 559504",
                "2 12 false 67493 275625", "3 16 true 80462 327184",
                "6 8 false 164161 665856", "4 4 false 112075 456976",
                "2 8 false 70335 285156" };
        int i, val;
        String result;
        boolean allOK = true;
        long ran_num = 508, before, after;
		before = System.currentTimeMillis();
        System.out.println("Testing program by " + Utilities.myName());
        for (i = 1; i <= 15; i++) {
            result = String.valueOf(Utilities.mostSignificantDigit(i)) + " "
                    + String.valueOf(Utilities.numberOfDivisors(i)) + " "
                    + String.valueOf(Utilities.abundant(i)) + " "
                    + String.valueOf(Utilities.abundantCount(i)) + " "
                    + String.valueOf(Utilities.nextSquareAbundant(i));
            if (result.compareTo(answers[i-1]) != 0) {
                allOK = false;
                System.out.println("Error with test #" + i);
            }
        }
        System.out.println("Loop 1.");
        for (i = 16; i <= 30; i++) {
            val = 500 + (int) ran_num % 10000;
            result = String.valueOf(Utilities.mostSignificantDigit(val)) + " "
                    + String.valueOf(Utilities.numberOfDivisors(val)) + " "
                    + String.valueOf(Utilities.abundant(val)) + " "
                    + String.valueOf(Utilities.abundantCount(val)) + " "
                    + String.valueOf(Utilities.nextSquareAbundant(val));
            if (result.compareTo(answers[i-1]) != 0) {
                allOK = false;
                System.out.println("Error with test #" + i);
            }
            ran_num = (ran_num * 1234367 + 326) % 113437;
        }
        System.out.println("Loop 2.");
        for (i = 31; i <= 45; i++) {
            val = (int) ran_num % 1000000;
            result = String.valueOf(Utilities.mostSignificantDigit(val)) + " "
                    + String.valueOf(Utilities.numberOfDivisors(val)) + " "
                    + String.valueOf(Utilities.abundant(val)) + " "
                    + String.valueOf(Utilities.abundantCount(val)) + " "
                    + String.valueOf(Utilities.nextSquareAbundant(val));
            if (result.compareTo(answers[i-1]) != 0) {
                allOK = false;
                System.out.println("Error with test #" + i);
            }
            ran_num = (ran_num * 1234367 + 326) % 11343751;
        }
		after = System.currentTimeMillis();
		System.out.println();
		System.out.println("Total running time for" + Utilities.myName()
				+ " program is " + (after - before) / 1000 + "."
				+ millis((after - before) % 1000) + " seconds.");
		System.out.println();
        if (allOK)
            System.out.println("Everything seems to be working fine!");
    }
}
