package org.practise.string;

/**
 * Created by liguoxiang on 5/5/15.
 */
public class AddBinary {

    public String addBinary(String a,String b){

        if(a==null||b==null){
            return a==null?b:a;
        }

        char aArray[]=a.toCharArray();
        char bArray[]=b.toCharArray();

        int alength=a.length();
        int blength=b.length();
        int carray=0;
        int newlength=Math.max(alength,blength)+1;
        StringBuilder result=new StringBuilder(newlength);


        while(newlength>=1) {
            newlength--;
            alength--;
            blength--;

            int aInt = 0;
            int bInt = 0;

            aInt = (alength >= 0) ? aArray[alength] - '0' : 0;
            bInt = (blength >= 0) ? bArray[blength] - '0' : 0;

            int newResult = aInt + bInt + carray;

            carray = newResult / 2;
            result.insert(0,String.valueOf(newResult%2));

        }
        if(result.charAt(0)=='0'){
            result.delete(0,1);
        }
        return result.toString();

    }

    public static void main(String[] args) {
        AddBinary addBinary=new AddBinary();
        System.out.println(addBinary.addBinary("1111111","1"));
    }

}
