import java.util.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import semestr_4.tests.MyNumber;

public class ListTest {

    @DataProvider
    public static Object[][] listOfNumbersToSplit() {
        return new Object[][] {
                {238, Arrays.asList(2,3,8)},
                {2, Arrays.asList(2)},
                {232321, Arrays.asList(2,3,2,3,2,1)},
                {12, Arrays.asList(1,2)},
                {1234567890, Arrays.asList(1,2,3,4,5,6,7,8,9,0)}
        };
    }

    @Test(dataProvider = "listOfNumbersToSplit")
    public void testToSplit(int number, List<Integer> listOfNumbers) {
        Assert.assertEquals(
                MyNumber.splitToNumbers(number),
                listOfNumbers
        );
    }

    @DataProvider
    public static Object[][] listOfNumbersToSum() {
        return new Object[][] {
                {238, 13},
                {2, 2},
                {0, 0},
                {1234567890, 45}
        };
    }

    @Test(dataProvider = "listOfNumbersToSum")
    public void testToSum(int number, int sum) {
        Assert.assertEquals(
                MyNumber.sum(number),
                sum
        );
    }
}




