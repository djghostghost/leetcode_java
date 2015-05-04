package org.test.array;

import junit.framework.TestCase;
import org.practise.array.RemoveDuplicates;

/**
 * Created by liguoxiang on 5/4/15.
 */
public class RemoveDuplicatesTest extends TestCase {

    RemoveDuplicates sol=null;

    @Override
    public void setUp() throws Exception{
        this.sol=new RemoveDuplicates();
        super.setUp();
    }

    //null
    public void testRemoveDuplicate_null(){
        int[] nums=null;
        assertEquals(this.sol.removeDuplicates(nums),0);
    }

    //empty array
    public void testRemoveDuplicate_empty_array(){
        int nums[]={};
        assertEquals(this.sol.removeDuplicates(nums),0);
    }

    //array without duplicate
    public void testRemoveDuplicate_without_duplicates(){
        int nums[]={1,2,3,4,5};
        assertEquals(this.sol.removeDuplicates(nums),5);
    }

    //array with duplicates

    public void testRemoveDuplicate_with_duplicates(){
        int nums[]={1,1,1,1,2,2,2,3,3,3,4,4,5};
        assertEquals(this.sol.removeDuplicates(nums),9);
    }

}
