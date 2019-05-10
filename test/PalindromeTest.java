import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import semestr_4.tests.Palindrome;

import static org.testng.Assert.assertTrue;

public class PalindromeTest {


    // часто сначала пишут тесты, а потом саму программу
    @Test
    public void test1() {
        //убедиться, что
        //assert Palindrome.isPalindrome("abccba")
        //Palindrome.isPalindrome("abccba"); //тк написал через ., то сама функция будет статик

        assertTrue(Palindrome.isPalindrome("abccba"));
    }

    @Test
    public void test2() {
        assertTrue(Palindrome.isPalindrome("pqp"));
        assertTrue(Palindrome.isPalindrome(""));
        assertTrue(Palindrome.isPalindrome("a"));
    }



    @DataProvider
    public static Object[][] listOfPalindromes() {
        return new Object[][] {
                {"abcba", true},
                {"abcbA", false},
                {"AbcbA", true}
        };
    }

    @Test(dataProvider = "listOfPalindromes")
    public void test3(String word, Boolean isPalindrome) {
        Assert.assertEquals(
                Palindrome.isPalindrome(word),
                (boolean)isPalindrome
        );
    }
}
