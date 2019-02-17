import java.util.*;
import java.io.*;
public class BFS
{
  public static void main(String[]args)throws IOException
  {
    BufferedReader br = new BufferedReader(new FileReader("D:\\task.txt"));
    StringTokenizer st;
    String s = "";
    int test = Integer.parseInt(br.readLine());
    int edge = Integer.parseInt(br.readLine()); 
    int src = Integer.parseInt(br.readLine());
    int x[][] = new int[test+1][test+1];
    while((s = br.readLine()) != null)
    {
      st = new StringTokenizer(s, " ");
      int i = Integer.parseInt(st.nextToken());
      int j = Integer.parseInt(st.nextToken());
      x[i][j] = 1;
      x[j][i] = 1;
    }
    BFS(x, src, test);
    
//    System.out.println("  1 2 3 4 5 6 7 8");
//    for(int i = 1; i <= test; i++)
//    {
//      System.out.print(i+" ");
//      for(int j = 1; j <= test; j++)
//        System.out.print(x[i][j]+" ");
//      System.out.println();
//    }
  }
  public  static void BFS(int x[][], int src, int vertex)
  {
    int color[] = new int[vertex+1];
    int distance[] = new int[vertex+1];
    int parent[] = new int[vertex+1];
    
    for(int i = 0; i <= vertex; i++)
    {
      color[i] = 0;
      distance[i] = 10000000;
      parent[i] = -1;
    }
    color[src] = 1; 
    distance[src] = 0;
    parent[src] = -1;
    Queue<Integer> queue = new LinkedList<Integer>();
    queue.add(src);
    while(!queue.isEmpty())
    {
      int u = queue.remove();
      for(int i = 0; i <= vertex; i++)
      {
        if(x[u][i] == 1 && color[i] == 0)
        {
          color[i] = 1;
          distance[i] = distance[u]+1;
          parent[i] = u;
          queue.add(i);
        }
      }
      color[u] = 2;
    }
//    COLOR & PARENT & DINTANCE
//    for(int i = 1; i <= vertex; i++)
//      System.out.print(color[i]+" ");
//    System.out.println();
    
    //SHORTEST PATH-->
    for(int i = 1; i <= vertex; i++)
    {
      System.out.println("Shortest path of node "+i+" from source: "+distance[i]);
      System.out.print(i);
      int c = i;
      while(c != src)
      {
        System.out.print(" --> "+parent[c]);
        c = parent[c];
      }
      System.out.println();
    }
  }
}