package com.company;

public class ReverseWordsOfString
{
  public static void main(String[] args)
  {
    String str = "getting good at coding needs a lot of practice";
    char[] strArray = str.toCharArray();
    int wordStart = 0;
    int wordEnd = -1;
    for (int i = 0; i < strArray.length; i++)
    {
      if ((int)strArray[i] == 32)
      {
        wordEnd = i - 1;
      }
      else if (i == strArray.length - 1)
      {
        wordEnd = i;
      }
      if (wordEnd >= wordStart && wordEnd != -1)
      {
        reverseWord(strArray, wordStart, wordEnd);
        wordStart = i + 1;
      }
    }
    for (int i = 0; i < strArray.length / 2; i++)
    {
      char temp = strArray[strArray.length - i - 1];
      strArray[strArray.length - i - 1] = strArray[i];
      strArray[i] = temp;
    }
    System.out.println(strArray);
  }

  private static void reverseWord(char[] strArray, int wordStart, int wordEnd)
  {
    for (int i = wordStart; i < wordStart + Math.ceil(((double)wordEnd - (double)wordStart) / 2); i++)
    {
      char temp = strArray[i];
      strArray[i] = strArray[wordStart + wordEnd - i];
      strArray[wordStart + wordEnd - i] = temp;
    }
  }
}
