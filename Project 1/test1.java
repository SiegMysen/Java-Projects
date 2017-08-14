public class test1 {

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

	static int padder(int num) {
		int log = 0, result = num;
		if (num == 0)
			log = 1;
		else
			while (result >= 1) {
				log++;
				result /= 10;
			}
		return log;
	}

	static int booleanSize(boolean b) {
		return ((b) ? 4 : 5);
	}

	public static void main(String[] args) {
		String formatter = new String("      ");
		int result, val;
		boolean prime;
		long ran_num = 508, before, after;
		System.out.println("Output for " + Utilities.myName() + ": ");
		System.out.println();
		System.out
				.println("   num        msd   num facts    abundant  num abundants  sq abundant");
		System.out
				.println("   ===        ===   =========    ========  =============  ===========");
		for (int i = 1; i <= 20; i++) {
			System.out.print(formatter.substring(padder(i)) + i);
			result = Utilities.mostSignificantDigit(i);
			System.out.print(formatter.substring(padder(result)) + "     "
					+ result);
			result = Utilities.numberOfDivisors(i);
			System.out.print(formatter.substring(padder(result)) + "      "
					+ result);
			prime = Utilities.abundant(i);
			System.out.print(formatter.substring(booleanSize(prime)) + "      "
					+ prime);
			result = Utilities.abundantCount(i);
			System.out.print(formatter.substring(padder(result)) + "         "
					+ result);
			result = Utilities.nextSquareAbundant(i);
			System.out.print(formatter.substring(padder(result)) + "       "
					+ result);
			System.out.println();
		}
		System.out.println();
		System.out
				.println("   num        msd   num facts    abundant  num abundants  sq abundant");
		System.out
				.println("   ===        ===   =========    ========  =============  ===========");
		before = System.currentTimeMillis();
		for (int i = 1; i <= 15; i++) {
			val = 701 + (int) ran_num % 30000;
			System.out.print(formatter.substring(padder(val)) + val);
			result = Utilities.mostSignificantDigit(val);
			System.out.print(formatter.substring(padder(result)) + "     "
					+ result);
			result = Utilities.numberOfDivisors(val);
			System.out.print(formatter.substring(padder(result)) + "      "
					+ result);
			prime = Utilities.abundant(val);
			System.out.print(formatter.substring(booleanSize(prime)) + "      "
					+ prime);
			result = Utilities.abundantCount(val);
			System.out.print(formatter.substring(padder(result)) + "         "
					+ result);
			result = Utilities.nextSquareAbundant(val);
			System.out.print(formatter.substring(padder(result)) + "       "
					+ result);
			System.out.println();
			ran_num = (ran_num * 1234367 + 326) % 113437;
		}
		after = System.currentTimeMillis();
		System.out.println();
		System.out.println("Total running time for " + Utilities.myName()
				+ " program is " + (after - before) / 1000 + "."
				+ millis((after - before) % 1000) + " seconds.");
		System.out.println();
	}
}
