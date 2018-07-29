package org.practise;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
*
* * 与https://leetcode.com/problems/lru-cache/高度相似
 *
 * 但是注意的是原题是cache满的情况下 清除最近使用频度最小的key-value
 * 此题目是执行evict下就要清除最近使用频度最小的key-value
 *
 *Java的LinkedHashMap即为双向相表 活用可以缩减代码长度
 */
public class MyCode3Hash {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;


        LRUCacheTreeMap cache = new LRUCacheTreeMap();
        while ((input = br.readLine()) != null) {

            input = input.trim();


            String[] commands = input.split(" ");

            int key = 0;
            switch (commands[0]) {
                case "add":
                    key = Integer.valueOf(commands[1]);
                    int value = Integer.valueOf(commands[2]);
                    cache.add(key, value);
                    break;

                case "get":
                    key = Integer.valueOf(commands[1]);
                    System.out.println(cache.get(key));
                    break;
                case "remove":
                    key = Integer.valueOf(commands[1]);
                    System.out.println(cache.remove(key));
                    break;
                case "evict":
                    cache.evict();
                    break;
                case "exit":
                    return;
                default:
                    break;

            }
        }
    }


}


class LRUCacheTreeMap {
    private final LinkedHashMap<Integer, Integer> cache;

    public LRUCacheTreeMap() {
        cache = new LinkedHashMap<>(100,0.75f,true);

    }

    public int get(int key) {

        return cache.getOrDefault(key, -1);

    }

    public void add(int key, int value) {


        cache.put(key, value);
        cache.get(key);
    }

    public int remove(int key) {

        Integer value = cache.remove(key);
        return value == null ? -1 : value.intValue();
    }


    public void evict() {

        if (cache.keySet().iterator().hasNext()) {
            int key = cache.keySet().iterator().next();
            cache.remove(key);
        }

    }

}


