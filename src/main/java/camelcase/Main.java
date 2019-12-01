package camelcase;

public class Main {


    private static int camelcase(String s) {
        char[] charArray = s.toCharArray();
        int count = 0;

        if (String.valueOf(
                charArray[0]).equals(
                        String.valueOf(charArray[0]).toLowerCase())) {
            count++;
        }

        for (char c : charArray) {
            if (String.valueOf(
                    c).equals(
                            String.valueOf(c).toUpperCase())) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] argc) {
        System.out.println(camelcase("saveChangesInTheEditor"));
    }
}
