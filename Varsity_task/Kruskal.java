import java.util.*;
import java.io.*;
public class Kruskal
{
  static int set[], y[][];
  public static void main(String[]args)throws IOException
  {
    BufferedReader br = new BufferedReader(new FileReader("D:\\kruskal.txt"));
    StringTokenizer st;
    String s = "";
    int test = Integer.parseInt(br.readLine());
    int edge = Integer.parseInt(br.readLine()); 
    //int src = Integer.parseInt(br.readLine());
    int x[][] = new int[test+1][test+1];
    y = new int[test+1][test+1];
    set = new int[test+1];
    while((s = br.readLine()) != null)
    {
      st = new StringTokenizer(s, " ");
      int i = Integer.parseInt(st.nextToken());
      int j = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());
      x[i][j] = k;
      //x[j][i] = 1;
    }
    int cost = KRUSKAL(x, edge);
    System.out.println("Total minimum cost is "+cost+"\n");
    for(int i = 0; i < y.length; i++)
    {
      for(int j = 0; j < y.length; j++)
      {
        if(y[i][j] > 0)
          System.out.println("("+i+" "+j+", "+y[i][j]+")");
      }
    }
  }
  public static int KRUSKAL(int x[][], int ed)
  {
    StringTokenizer st;
    int cost = 0;
    for(int l = 0, c = 0; l < ed; l++)
    {
      String s = findmin(x);
      st = new StringTokenizer(s, " ");
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());
      if(set[a] == 0 || set[b] == 0)
      {
        set[a]++;
        set[b]++;
        y[a][b] = k;
        cost+=k;
        x[a][b] = -1;
      }
      else
        x[a][b] = 0;
    }
    return cost;
  }
  public static String findmin(int y[][])
  {
    int a = 0, b = 0, k = 9999999;
    String s = "";
    for(int i = 0; i < y.length; i++)
    {
      for(int j = 0; j < y.length; j++)
      {
        if(y[i][j] > 0 && y[i][j] < k)
        {
          k = y[i][j];a = i;b = j;
        }
      }
    }
    s = ""+a+" "+b+" "+k;
    return s;
  }
}