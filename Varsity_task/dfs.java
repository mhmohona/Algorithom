import java.util.*;
import java.io.*;
public class dfs
{
  static int time;
  static int color[], prev[], d[], f[];
  public static void main(String[]args)throws IOException
  {
    BufferedReader br = new BufferedReader(new FileReader("D:\\task.txt"));
    StringTokenizer st;
    String s = "";
    int test = Integer.parseInt(br.readLine());
    int edge = Integer.parseInt(br.readLine()); 
    int src = Integer.parseInt(br.readLine());
    int x[][] = new int[test+1][test+1];
    color = new int[test+1];
    prev = new int[test+1];
    d = new int[test+1];
    f = new int[test+1];
    while((s = br.readLine()) != null)
    {
      st = new StringTokenizer(s, " ");
      int i = Integer.parseInt(st.nextToken());
      int j = Integer.parseInt(st.nextToken());
      x[i][j] = 1;
      x[j][i] = 1;
    }
    
    DFS(x);
    for(int i = 1; i <= test; i++)
      System.out.print(d[i]+"  ");System.out.println();
    for(int i = 1; i <= test; i++)
    System.out.print(f[i]+" ");
    System.out.println();
//    System.out.println("  1 2 3 4 5 6 7 8");
//    for(int i = 1; i <= test; i++)
//    {
//      System.out.print(i+" ");
//      for(int j = 1; j <= test; j++)
//        System.out.print(x[i][j]+" ");
//      System.out.println();
//    }
  }
  public  static void DFS(int x[][])
  {
    for(int i = 1; i < x.length; i++)
    {
      color[i] = 0;
      prev[i] = -1;
      f[i] = -1;d[i] = -1;
    }
    for(int i = 1; i < x.length; i++)
    {
      if(color[i] == 0)
        DFS_VISIT(x, i);
    }
  }
  public static void DFS_VISIT(int x[][], int u)
  {
    color[u] = 1;
    time++;
    d[u] = time;
    for(int i = 0; i < x[u].length; i++)
    {
      if(x[u][i] > 0 && color[i] == 0)
      {
        prev[i] = u;
        DFS_VISIT(x, i);
      }
    }
    color[u] = 2;
    time++;
    f[u] = time;
  }
}