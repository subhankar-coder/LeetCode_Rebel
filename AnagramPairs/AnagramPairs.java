package AnagramPairs;

import java.util.*;

public class AnagramPairs {

    public static void main(String[] args) {
        HashMap<Character, Integer> map = new HashMap<>();

        String str1 = "rasp";
        String str2 = "spaz";

        int len1 = str1.length();
        int len2 = str2.length();

        if (len1 != len2) {
            System.out.println("not out");
        }

        for (int i = 0; i < len1; i++) {
            if (map.containsKey(str1.charAt(i))) {
                map.put(str1.charAt(i), map.get(str1.charAt(i)) + 1);
            } else {
                map.put(str1.charAt(i), 1);
            }
        }

        for (int i = 0; i < len2; i++) {
            if (map.containsKey(str2.charAt(i))) {
                int index = map.get(str2.charAt(i)) - 1;
                if (index == 0) {
                    map.remove(str2.charAt(i));
                } else {
                    map.put(str2.charAt(i), index);
                }
            }
        }

        System.out.println(map.isEmpty());
        System.out.println(map);
    }
}
