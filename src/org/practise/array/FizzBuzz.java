package org.practise.array;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by liguoxiang on 2016/11/06.
 */
public class FizzBuzz {
    public List<String> fizzBuzz(int n) {

        List<String> res = IntStream.rangeClosed(1, n).mapToObj(i -> getFizzBuzz(i)).collect(Collectors.toList());
        return res;

    }

    private String getFizzBuzz(Integer i) {

        if (i % 5 == 0 && i % 3 == 0) {
            return "FizzBuzz";
        } else if (i % 5 == 0) {
            return "Buzz";
        } else if (i % 3 == 0) {
            return "Fizz";
        } else {
            return String.valueOf(i);
        }


    }

    public static void main(String[] args) {
        FizzBuzz sol=new FizzBuzz();
        List<String> res=sol.fizzBuzz(15);
        res.forEach(i->System.out.println(i));

    }



}
