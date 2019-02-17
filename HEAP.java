import java.util.*;
import java.io.*;
public class HEAP
{
  public static void main(String[]args)throws IOException
  {
    BufferedReader br = new BufferedReader(new FileReader("D:\\HEAP.txt"));
    int n = Integer.parseInt(br.readLine());
    int arr[] = new int[n];
    for(int i = 0; i < n; i++)
    {
      int num = Integer.parseInt(br.readLine());
      arr[i] = num;
    }
//    BUILDmaxHEAP(arr);
//    for(int i = 0; i < n; i++)
//      System.out.print(arr[i]+" ");
//    System.out.println();
    Heapsort(arr);
    for(int i = 0; i < n; i++)
      System.out.print(arr[i]+" ");
    System.out.println();
  }
  
  public static void BUILDmaxHEAP(int arr[])
  {
    int n = arr.length;
    for(int i = (n/2)-1; i >= 0; i--)
      maxHEAPify(arr, i, n);
  }
  
  public static void maxHEAPify(int arr[], int i, int n)
  {
    int l = 2*i+1;
    int r = 2*i+2;
    int largest = 0;
    if(l < n && arr[l] > arr[i])
      largest = l;
    else
      largest = i;
    if(r < n && arr[r] > arr[largest])
      largest = r;
    if(largest != i)
    {
      int temp = arr[i];
      arr[i] = arr[largest];
      arr[largest] = temp;
      maxHEAPify(arr, largest, n);
    }
  }
  
  public static void Heapsort(int arr[])
  {
    BUILDmaxHEAP(arr);int n = arr.length;
    for(int i = arr.length-1; i >= 0; i--)
    {
      int temp = arr[1];
      arr[1] = arr[i];
      arr[i] = temp;
      maxHEAPify(arr, n--, i-1);
    }
  }
}