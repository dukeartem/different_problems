package RLE;

import java.util.LinkedList;

public class Main {
    private static String rleZip(String line) {
        StringBuilder resLine = new StringBuilder();
        LinkedList<Character> q = new LinkedList<>();

        if (line.length() == 0) {
            return resLine.toString();
        }

        char[] rleCharArray = line.toCharArray();

        for (int i = 0; i < rleCharArray.length; i++) {
            if (i == 0) {
                q.add(rleCharArray[0]);
                continue;
            }

            if (rleCharArray[i] == rleCharArray[i - 1]) {
                q.add(rleCharArray[i]);
                continue;
            }

            if (q.size() == 1) {
                resLine.append(q.peek());
            } else {
                resLine.append(q.peek()).append(q.size());
            }
            q.clear();
            q.add(rleCharArray[i]);
        }

        if (q.size() == 1) {
            resLine.append(q.pop());
        } else {
            resLine.append(q.peek()).append(q.size());
        }

        return resLine.toString();
    }

    public static void main(String[] args) {
        //A4B3C2XYZD4E3F3A6B28
        System.out.println(rleZip("AAAABBBCCXYZDDDDEEEFFFAAAAAABBBBBBBBBBBBBBBBBBBBBBBBBBBB"));

        //A4B3C2XYZD4E3F3A6B28C
        System.out.println(rleZip("AAAABBBCCXYZDDDDEEEFFFAAAAAABBBBBBBBBBBBBBBBBBBBBBBBBBBBC"));

        //A4B
        System.out.println(rleZip("AAAAB"));
    }
}
