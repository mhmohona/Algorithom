import java.util.*;
import java.io.*;
public class Knapsack
{
  static int set[], y[][];
  public static void main(String[]args)throws IOException
  {
    BufferedReader br = new BufferedReader(new FileReader("D:\\knapsack.txt"));
    StringTokenizer st;
    int item = Integer.parseInt(br.readLine());
    int tw = Integer.parseInt(br.readLine());
    int weight[] = new int[item+1];
    int benefit[] = new int[item+1];
    int x[][] = new int[item+1][tw+1];
    st = new StringTokenizer(br.readLine());
    int k = 1;
    while(st.hasMoreTokens())
      weight[k++] = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());k = 1;
    while(st.hasMoreTokens())
      benefit[k++] = Integer.parseInt(st.nextToken());
    //knapsack
    for(int i = 1; i <= item; i++)
    {
      for(int j = 0; j <= tw; j++)
      {
        if(weight[i] <= j)
        {
          if((benefit[i]+x[i-1][j-weight[i]]) > x[i-1][j])
            x[i][j] = benefit[i]+x[i-1][j-weight[i]];
          else
            x[i][j] = x[i-1][j];
        }
        else
          x[i][j] = x[i-1][j];
      }
    }
    //finding the picked items
    String p = "";
    int c = item, d = tw;
    while(c > 0 && d > 0)
    {
      if(x[c][d] != x[c-1][d])
      {
        p = c+" "+p;
        d = d - weight[c];
      }
      c--;
    }
    System.out.println("Picked items "+p);
    System.out.println("Total benefit is "+x[item][tw]);
  }
}