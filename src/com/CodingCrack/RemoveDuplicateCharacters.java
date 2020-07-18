package com.CodingCrack;

public class RemoveDuplicateCharacters
{
  public static void main(String[] args)
  {
    String str = "shivanandsingh";
    char[] arr = str.toCharArray();
    boolean[] bool = new boolean[256];
    for (int i = 0; i < arr.length; i++)
    {
      int code = (int)arr[i];
      if (!bool[code]) {
        bool[code] = true;
      } else {

      }
    }
  }
}
