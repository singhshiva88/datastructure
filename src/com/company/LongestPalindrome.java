package com.company;

public class LongestPalindrome
{
  public static void main(String[] args)
  {
    String palindromeTest = "forgeeksxskeegfor";
    LongestPalindrome longestPalindrome = new LongestPalindrome();
    String longestPalindromeString = longestPalindrome.findLongestPalindrome(palindromeTest);
  }

  private String findLongestPalindrome(String palindromeTest)
  {
    int length = palindromeTest.length();
    char[] arr = palindromeTest.toCharArray();
    int longestCurrentLength = 1;
    for (int i = 0; i < length; i++)
    {
      int palindromeLength = 0;
      // fix the center and check

      int k = 0;
      while ((i - k >= 0 && (i + k) < length))
      {
        if (arr[i - k] == arr[i + k] && (i - k) >= 0 && (i + k) < length)
        {
          palindromeLength = 2*k;
          k++;
        }
        else
        {
          break;
        }
      }
      if (palindromeLength > longestCurrentLength)
      {
        longestCurrentLength = palindromeLength;
      }
    }
    System.out.println("Longest Palindrome Length: " + longestCurrentLength);
    return null;
  }
}
