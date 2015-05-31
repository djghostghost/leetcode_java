package org.test.array;

/**
 * Created by liguoxiang on 5/31/15.
 */
import junit.framework.*;
import org.practise.array.ContainsDuplicate;

public class ContainsDuplicateTest extends TestCase{
    private  ContainsDuplicate sol=null;
    private int[] array=null;
    private int k=0;
    @Override
   public void setUp() throws Exception{
        sol=new ContainsDuplicate();
    }

    //if nums==null
    public void testContainsDuplicates_null(){
        assertEquals(sol.containsNearbyDuplicate(array,1),false);
    }

    public void testContainsDuplicates_k_is_0(){
        array=new int[]{1,2,3,4,5};
        assertEquals(sol.containsNearbyDuplicate(array,0),false);
    }

    public void testContainsDuplicates_k_wiout_duplicates(){
        array=new int[]{1,2,3,4,5,6};
        assertEquals(sol.containsNearbyDuplicate(array,3),false);
    }

    public void testContainsDuplicates_difference_large_than_k(){
        array=new int[]{1,2,3,4,5,1,6};
        assertEquals(sol.containsNearbyDuplicate(array,3),false);
    }

    public void testContainsDuplicates_difference_equal_than_k(){
        array=new int[]{1,2,3,4,5,2,6};
        assertEquals(sol.containsNearbyDuplicate(array,4),true);
    }

    public void testContainsDuplicates_differece_litter_than_k(){
        array=new int[]{1,2,3,4,5,1,2,3,1,6};
        assertEquals(sol.containsNearbyDuplicate(array,4),true);
    }







}
