package com.CodingCrack;

import java.util.Arrays;

public class StringUniqueCharacters
{
  public static void main(String[] args)
  {
    String str = "shivaS";
    boolean[] arr = new boolean[256];

    for (int i = 0; i < str.length(); i++)
    {
      int c = str.charAt(i);
      if (arr[c])
      {
        arr[c] = true;
      }
      else
      {
        System.out.println("boom....");
        break;
      }
    }
  }
}
