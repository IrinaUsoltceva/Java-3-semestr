package semestr_4.tests;

public class Palindrome {

    public static boolean isPalindrome(String word) {
        for (int i = 0; i < word.length() / 2; i++)
            if (word.charAt(i) != word.charAt(word.length() - 1 - i))
                return false;
        return true;
    }
}