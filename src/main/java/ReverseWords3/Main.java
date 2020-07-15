package ReverseWords3;

public class Main {
    public static String reverseWords(String s) {
        StringBuilder revString = new StringBuilder();

        char[] stringInCharArr = s.toCharArray();
        int lenArr = stringInCharArr.length;
        int offset = 0;

        for (int i = 0; i < lenArr; i++) {

            if ((stringInCharArr[i] == ' ') || (i == lenArr - 1)) {
                int newI = i - 1;
                if (i == lenArr - 1) {
                    newI = i;
                }
                if (offset != 0) {
                    for (int j = newI; j >= i - offset; j--) {
                        revString.append(stringInCharArr[j]);
                    }
                    offset = 0;
                } else {
                    if (stringInCharArr[i] != ' ') {
                        revString.append(stringInCharArr[i]);
                    }
                }
            }

            if (stringInCharArr[i] == ' ') {
                revString.append(" ");
            } else {
                offset++;
            }

        }

        System.out.println(s + "///" + revString.toString());
        return revString.toString();
    }


    public static void main(String[] argc) {
        reverseWords("I love u"); // "I evol u"
        reverseWords("Let's take LeetCode contest"); //s'teL ekat edoCteeL tsetnoc
        reverseWords("QUICK FOX JUMPS"); // KCIUQ XOF SPMUJ
        reverseWords("  QUICK FOX   JUMPS "); //"  KCIUQ XOF   SPMUJ "
        reverseWords(" "); //" "
        reverseWords(""); //""
    }



}
