package com.company;

public class RecursivelyRemoveDuplicates
{
  public static void main(String[] args)
  {
    String str = "azxxzyshivaazxxzyjkjhghhhhhhhhhghlkjkjsjdgfuyf";
    RecursivelyRemoveDuplicates recursivelyRemoveDuplicates = new RecursivelyRemoveDuplicates();
    String finalStr = recursivelyRemoveDuplicates.removeDuplicates(str);
    System.out.println(str);
    System.out.println(finalStr);
  }

  private String removeDuplicates(String str)
  {
    char[] arr = str.toCharArray();
    removeDuplicateRecursively(arr, 0);
    return String.valueOf(arr);
  }

  private void removeDuplicateRecursively(char[] arr, int startIndex)
  {
    int i = startIndex;
    int j = startIndex + 1;
    boolean removing = false;
    while (j < arr.length)
    {
      if (arr[i] == arr[j] && arr[i] != ' ')
      {
        removing = true;
        arr[j] = ' ';
        j++;
      }
      else
      {
        if (removing)
        {
          arr[i] = ' ';
          i--;
          removing = false;
          if (arr[i] != arr[j])
          {
            removeDuplicateRecursively(arr, j);
          }
        }
        else
        {
          i++;
          j++;
        }
      }
    }
  }
}
