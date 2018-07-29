package org.practise;


import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class MyCode1 {
    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        //输入字符串中重复的字符的个数
        //比如 abbccc的情况下应该输出2 因为b c 重复出现了

        System.out.println(getRepeatCharacterCount(input));

    }

    private static int getRepeatCharacterCount(String word) {


        if (word == null || word.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int repeatCharacterCount = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {

            if (entry.getValue() > 1) {
                repeatCharacterCount++;
            }

        }
        return repeatCharacterCount;
    }
}
