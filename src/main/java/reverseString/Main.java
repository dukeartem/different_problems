package reverseString;

public class Main {

    private static void reverseString(char[] s) {
        for (int i=s.length-1; i>=s.length/2; i--) {
            char temp = s[i];
            s[i] = s[s.length-1-i];
            s[s.length-1-i] = temp;
        }
        System.out.println(s);
    }

    public static void main(String[] args) {
        reverseString(new char[]{ 'h', 'e', 'l', 'l', 'o' });
        //Output: ["o","l","l","e","h"]
    }
}
