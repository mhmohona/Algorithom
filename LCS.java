import java.util.*;
import java.io.*;
public class LCS
{
  public static void main(String[]args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    String s = "", s1 = "", r1 = "", r2 = "";
    s = br.readLine();
    s1 = br.readLine();
    for(int i = 0, k = 0; i < s.length(); i++)
    {
      for(int j = k; j < s1.length(); j++)
      {
        if(s.charAt(i) == s1.charAt(j))
        {
          r1+=s.charAt(i);
          k = j+1;
          break;
        }
      }
    }
    for(int i = 0, k = 0; i < s1.length(); i++)
    {
      for(int j = k; j < s.length(); j++)
      {
        if(s1.charAt(i) == s.charAt(j))
        {
          r2+=s1.charAt(i);
          k = j+1;
          break;
        }
      }
    }
    if(r1.length() > r2.length())
      System.out.println(r1);
    else
      System.out.println(r2);
  }
}