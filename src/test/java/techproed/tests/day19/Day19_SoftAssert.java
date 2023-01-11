package techproed.tests.day19;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Day19_SoftAssert {

    @Test
    public void softAssertTest(){

        SoftAssert softAssert = new SoftAssert();

        System.out.println("Line 13 Code");
        softAssert.assertEquals(3, 5);
        System.out.println("Line 15 Code");
        softAssert.assertEquals("Apple", "Orange");
        System.out.println("Line 17 Code");
        softAssert.assertTrue(false);
        System.out.println("Line 19 Code");
        softAssert.assertAll();//Marking the test case as FAILED or PASSED

    }
}
