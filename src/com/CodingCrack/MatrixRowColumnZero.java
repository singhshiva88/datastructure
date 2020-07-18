package com.CodingCrack;

public class MatrixRowColumnZero
{
  public static void main(String[] args)
  {
    int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 0, 8},
            {9, 0, 11, 12},
            {13, 14, 15, 16}
    };
    boolean[] row = new boolean[4];
    boolean[] column = new boolean[4];
    for (int i = 0; i < 4; i++)
    {
      for (int j = 0; j < 4; j++)
      {
        if (matrix[i][j] == 0)
        {
          row[i] = true;
          column[j] = true;
        }
      }
    }
    for (int i = 0; i < 4; i++)
    {
      for (int j = 0; j < 4; j++)
      {
        if (row[i] || column[j])
        {
          matrix[i][j] = 0;
        }
      }
    }
    System.out.println(matrix);
  }
}
