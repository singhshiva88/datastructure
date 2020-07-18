package com.company;

public class PermutationOfGivenString
{
  public static void main(String[] args)
  {
    String str = "ABC";
    int n = str.length();
    PermutationOfGivenString permutationOfGivenString = new PermutationOfGivenString();
    permutationOfGivenString.permute(str, 0, n - 1);
  }

  private void permute(String str, int l, int r)
  {
    if (l > r)
    {
      System.out.println("Left Index greater that RIght " + l + "   " + r);
    } else {
      System.out.println("Permuting String: " + str + " left index: " + l + " - " +
              str.charAt(l) + " & " + " right index: " + r + " - " + str.charAt(r));
    }

    if (l == r)
    {
      System.out.println(str);
    }
    for (int i = l; i <= r; i++)
    {
      str = swap(str, l, i);
      permute(str, l + 1, r);
      str = swap(str, l, i);
    }
  }

  private String swap(String str, int i, int j)
  {
    char[] strArray = str.toCharArray();
    if (i != j)
    {
      char temp = strArray[i];
      strArray[i] = strArray[j];
      strArray[j] = temp;
    }
    System.out.println("Swapping String : " + str + " index:" + i + " - " +
            strArray[i] + " & " + " index:" + j + " - " + strArray[i]);
    return String.valueOf(strArray);
  }
}
