package Selenium_Tutorial1.Test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;

public class TestSampleClass {

    SampleClass sc;
    String str1, str2;
    @BeforeTest
    public void initStringsAndObjects()
    {
        sc = new SampleClass();
        str1 = "abc";
        str2 = "def";
    }
    @Test (priority = 1)
    public void testMergeStrings()
    {
        Assert.assertNotNull(sc.mergeStrings(str1, str2));
        Assert.assertEquals(sc.mergeStrings(str1, str2), "abcdef");
        System.out.println(sc.mergeStrings(str1, str2));
    }
    @Test(priority = 2)
    public void testMergeStringsWithDash()
    {
        Assert.assertNotNull(sc.mergeStringsWithDash(str1, str2));
        Assert.assertEquals(sc.mergeStringsWithDash(str1, str2), "abc-def");
        Assert.assertNotSame(sc.mergeStringsWithDash(str1, str2), "abcdef");
        System.out.println(sc.mergeStringsWithDash(str1, str2));
    }
    @AfterTest
    public void cleanup()
    {
        str1 = null;
        str2 = null;
        sc = null;
    }

}
