package com.company;

import java.io.*;
import java.util.*;

public class TestClass
{
  public static void main(String[] args) throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter wr = new PrintWriter(System.out);
    long n = Long.parseLong(br.readLine().trim());

    long out_ = FindBigNum(n);
    wr.println(out_);
    wr.close();
    br.close();
  }

  static long FindBigNum(long n)
  {
    // Write your code here
    StringBuilder str = new StringBuilder();
    for (int i = 1; i <= n; i++)
    {
      getBinary(i, str);
    }
    return convertToNumber1(str);
  }

  private static long convertToNumber1(StringBuilder str)
  {
    long result = 0;
    int index = 0;
    for (int i = str.length() - 1; i >= 0; i--)
    {
      int c = str.charAt(i) - '0';
      if (c == 1)
      {
        result = (result + (long)Math.pow(2, index)) % 1000000007;
      }
      index++;
    }
    return result % 1000000007;
  }

  private static long convertToNumber(StringBuilder str)
  {
    return Long.parseLong(str.toString(), 2);
  }

  private static void getBinary(int i, StringBuilder str)
  {
    if (i > 1)
    {
      getBinary(i / 2, str);
    }
    str.append(i % 2);
  }
}