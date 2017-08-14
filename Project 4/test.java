public class test {

    public static boolean success = true;

    public static void main(String[] args) {
        int checkCt = 0;
        String answers[] = {
                "str1: comp, len = 4",
                "str1: comp, len = 4",
                "str1: 182, len = 3",
                "str1: 182, len = 3  str2: comp, len = 4",
                "str1: 182, len = 3",
                "str1: 182, len = 3  str2: , len = 0",
                "str1: 2182, len = 4",
                "str1: 2, len = 1",
                "str1: x2, len = 2",
                "str1: 2182, len = 4  str2: x2, len = 2",
                "str1: , len = 0",
                "str1: 21824, len = 5",
                "str1: 4, len = 1",
                "str1: 21824, len = 5  str2: 4, len = 1",
                "str1: abc, len = 3",
                "str1: abc, len = 3",
                "str1: abc*, len = 4",
                "str1: abc*, len = 4  str2: abc, len = 3",
                "str1: abc*, len = 4  str2: abc$, len = 4",
                "str1: abc*x, len = 5  str2: abc$y, len = 5",
                "str1: aabbacbaacbcbaaccbbabacabaa, len = 27  str2: aabbccbbccaabbaaaaaabbb, len = 23",
                "str1: aabbacbaacbcbaaccbbabacabaa, len = 27  str2: aabbccbbccaabbaaaaaabbb, len = 23",
                "str1: bbcbcbcbccbbbcb, len = 15  str2: bbccbbccbbbbb, len = 13",
                "str1: bbbbbbbbb, len = 9  str2: bbbbbbbbb, len = 9",
                "str1: , len = 0  str2: , len = 0",
                "str1: , len = 0  str2: , len = 0",
                "str1: , len = 0  str2: , len = 0",
                "str1: abc12345, len = 8  str2: 12345$, len = 6",
                "str1: 12345$, len = 6",
                "str1: 12345$, len = 6",
                "str1: 12345$12345$, len = 12",
                "str1: 12345$12345$12345$12345$, len = 24",
                "str1: abcdefghijk, len = 11",
                "str1: abcdefghijk, len = 11",
                "str1: abcdefghijk, len = 11",
                "str1: abcdefghijk, len = 11",
                "str1: abcdefghijk, len = 11",
                "str1: abcghijk, len = 8",
                "str1: ghijk, len = 5",
                "str1: gh, len = 2",
                "str1: , len = 0",
                "str1: , len = 0",
                "str1: , len = 0",
                "str1: defghabc, len = 8",
                "str1: defgh, len = 5",
                "str1: efgh, len = 4",
                "str1: efg, len = 3",
                "str1: fedcba, len = 6",
                "str1: a, len = 1",
                "str1: , len = 0",
                "str1: helwolorld, len = 10  str2: low, len = 3",
                "str1: helwolorld, len = 10  str2: low, len = 3",
                "str1: helwoldlro, len = 10  str2: orld, len = 4",
                "str1: wleholdlro, len = 10  str2: helw, len = 4",
                "str1: wleholdlro, len = 10  str2: helw, len = 4",
                "str1: wleholdlro, len = 10  str2: h, len = 1",
                "str1: wleholdlro, len = 10  str2: w, len = 1",
                "str1: orldlohelw, len = 10  str2: wleholdlro, len = 10",
                "str1: orldlohelw, len = 10  str2: , len = 0",
                "str1: orldlohelw, len = 10  str2: , len = 0"
        };
        
        System.out.println(Word.myName());
        System.out.print("Phase 1: Constructors and addHead");
        Word word1 = new Word("comp");
        check(outStrInfo(word1), answers[checkCt++]);
        Word word3 = new Word(word1);
        check(outStrInfo(word1), answers[checkCt++]);
        word1 = new Word("182");
        check(outStrInfo(word1), answers[checkCt++]);
        check(outStrInfo(word1, word3), answers[checkCt++]);
        Word word2 = new Word("");
        check(outStrInfo(word1), answers[checkCt++]);
        check(outStrInfo(word1, word2), answers[checkCt++]);
        word1.addHead('2');
        check(outStrInfo(word1), answers[checkCt++]);
        word2.addHead('2');
        check(outStrInfo(word2), answers[checkCt++]);
        word2.addHead('x');
        check(outStrInfo(word2), answers[checkCt++]);
        check(outStrInfo(word1, word2), answers[checkCt++]);
        System.out.println();

        System.out.print("Phase 2: Constructors and addTail");
        word2 = new Word("");
        check(outStrInfo(word2), answers[checkCt++]);
        word1.addTail('4');
        check(outStrInfo(word1), answers[checkCt++]);
        word2.addTail('4');
        check(outStrInfo(word2), answers[checkCt++]);
        check(outStrInfo(word1, word2), answers[checkCt++]);
        word1 = new Word("abc");
        check(outStrInfo(word1), answers[checkCt++]);
        word2 = new Word(word1);
        check(outStrInfo(word2), answers[checkCt++]);
        word1.addTail('*');
        check(outStrInfo(word1), answers[checkCt++]);
        check(outStrInfo(word1, word2), answers[checkCt++]);
        word2.addTail('$');
        check(outStrInfo(word1, word2), answers[checkCt++]);
        word1.addTail('x');
        word2.addTail('y');
        check(outStrInfo(word1, word2), answers[checkCt++]);
        System.out.println();

        System.out.print("Phase 3: removeChar");
        word1 = new Word("daabbacbaacbcbaaccbbadbacabaa");
        word2 = new Word("dddaabbccbbccaaddbbaaddaaaabbbd");
        word1.removeChar('d');
        word2.removeChar('d');
        check(outStrInfo(word1, word2), answers[checkCt++]);
        word1.removeChar('e');
        word2.removeChar('e');
        check(outStrInfo(word1, word2), answers[checkCt++]);
        word1.removeChar('a');
        word2.removeChar('a');
        check(outStrInfo(word1, word2), answers[checkCt++]);
        word1.removeChar('c');
        word2.removeChar('c');
        check(outStrInfo(word1, word2), answers[checkCt++]);
        word1.removeChar('b');
        word2.removeChar('b');
        check(outStrInfo(word1, word2), answers[checkCt++]);
        word1.removeChar('b');
        word2.removeChar('b');
        check(outStrInfo(word1, word2), answers[checkCt++]);
        System.out.println();

        System.out.print("Phase 4: concatenate");
        word1 = new Word();
        word2 = new Word();
        word1.concatenate(word2);
        word2.concatenate(word2);
        check(outStrInfo(word1, word2), answers[checkCt++]);
        word1 = new Word("abc");
        word2 = new Word("12345");
        word1.concatenate(word2);
        word2.addTail('$');
        check(outStrInfo(word1, word2), answers[checkCt++]);
        outStrInfo(word1, word2);
        word1 = new Word("");
        word1.concatenate(word1);
        word2.concatenate(word1);
        check(outStrInfo(word2), answers[checkCt++]);
        word1.concatenate(word2);
        check(outStrInfo(word1), answers[checkCt++]);
        word1.concatenate(word1);
        check(outStrInfo(word1), answers[checkCt++]);
        word1.concatenate(word1);
        check(outStrInfo(word1), answers[checkCt++]);
        System.out.println();

        System.out.print("Phase 5: removeWord");
        word1 = new Word("abcdefghijk");
        word1.removeWord(new Word("defab"));
        check(outStrInfo(word1), answers[checkCt++]);
        word1.removeWord(new Word("abcabc"));
        check(outStrInfo(word1), answers[checkCt++]);
        word1.removeWord(new Word("abcijk"));
        check(outStrInfo(word1), answers[checkCt++]);
        word1.removeWord(new Word("xyz"));
        check(outStrInfo(word1), answers[checkCt++]);
        word1.removeWord(new Word(""));
        check(outStrInfo(word1), answers[checkCt++]);
        word1.removeWord(new Word("def"));
        check(outStrInfo(word1), answers[checkCt++]);
        word1.removeWord(new Word("abc"));
        check(outStrInfo(word1), answers[checkCt++]);
        word1.removeWord(new Word("ijk"));
        check(outStrInfo(word1), answers[checkCt++]);
        word1.removeWord(new Word("gh"));
        check(outStrInfo(word1), answers[checkCt++]);
        word1.removeWord(new Word("gh"));
        check(outStrInfo(word1), answers[checkCt++]);
        word1.removeWord(new Word(""));
        check(outStrInfo(word1), answers[checkCt++]);
        word1 = new Word("abcdefghabc");
        word1.removeWord(new Word("abc"));
        check(outStrInfo(word1), answers[checkCt++]);
        word1.removeWord(new Word("abc"));
        check(outStrInfo(word1), answers[checkCt++]);
        word1.removeWord(new Word("d"));
        check(outStrInfo(word1), answers[checkCt++]);
        word1.removeWord(new Word("h"));
        check(outStrInfo(word1), answers[checkCt++]);
        System.out.println();

        System.out.print("Phase 6: reverse");
        word1 = new Word("abcdef");
        word1.reverse();
        check(outStrInfo(word1), answers[checkCt++]);
        word1 = new Word("a");
        word1.reverse();
        check(outStrInfo(word1), answers[checkCt++]);
        word1 = new Word("");
        word1.reverse();
        check(outStrInfo(word1), answers[checkCt++]);
        System.out.println();
        
        System.out.print("Phase 7: flipWord");
        word1 = new Word("helloworld");
        word2 = new Word("low");
        word1.flipWord(word2);
        check(outStrInfo(word1, word2), answers[checkCt++]);
        word2 = new Word("low");
        word1.flipWord(word2);
        check(outStrInfo(word1, word2), answers[checkCt++]);
        word2 = new Word("orld");
        word1.flipWord(word2);
        check(outStrInfo(word1, word2), answers[checkCt++]);
        word2 = new Word("helw");
        word1.flipWord(word2);
        check(outStrInfo(word1, word2), answers[checkCt++]);
        word2.flipWord(word1);
        check(outStrInfo(word1, word2), answers[checkCt++]);
        word2 = new Word("h");
        word1.flipWord(word2);
        check(outStrInfo(word1, word2), answers[checkCt++]);
        word2 = new Word("w");
        word1.flipWord(word2);
        check(outStrInfo(word1, word2), answers[checkCt++]);
        word2 = new Word("wleholdlro");
        word1.flipWord(word2);
        check(outStrInfo(word1, word2), answers[checkCt++]);
        word2.removeWord(new Word("wleholdlro"));
        word1.flipWord(word2);
        check(outStrInfo(word1, word2), answers[checkCt++]);
        word1.flipWord(word2);
        check(outStrInfo(word1, word2), answers[checkCt++]);
        System.out.println();

        if (success)
            System.out.println("Everything worked. Well done!");
    }

    private static void check(String s1, String s2) {
        if (s1.compareTo(s2) == 0)
            System.out.print(".");
        else {
            System.out.println();
            System.out.println("*** Error. Answers don't match: ");
            System.out.println("Yours: " + s1);
            System.out.println("Mine:  " + s2);
            success = false;
        }
    }
    
   private static String outStrInfo(Word str1) {
        return "str1: " + str1 + ", len = " + str1.length();
   }

    private static String outStrInfo(Word str1, Word str2) {
        return "str1: " + str1 + ", len = " + str1.length()
               + "  str2: " + str2 + ", len = " + str2.length();
   }

}