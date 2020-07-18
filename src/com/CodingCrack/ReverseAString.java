package com.CodingCrack;

public class ReverseAString
{
  public static void main(String[] args)
  {
    String str = "This is a demo string";
    System.out.println(reverseString(str, 10, str.length() - 1));
  }

  private static String reverseString(String str, int startIndex, int endIndex)
  {
    char[] arr = str.toCharArray();
    for (int i = startIndex; i < (startIndex + endIndex) / 2; i++)
    {
      char temp = arr[i];
      arr[i] = arr[endIndex - (i - startIndex)];
      arr[endIndex - (i - startIndex)] = temp;
    }
    return String.valueOf(arr);
  }
}
