package BTC_IV;
import java.io.*;
class ChangeMatrix
{
 void change(int m,String str)
 {
  String r="null";  
  int array[][]=new int[4][4];
  int i,j,k=0,l=0,a=0,b=0,c=0,d=0;
  try
  {

   FileReader  fread = new FileReader(str+"newout2.txt");
   BufferedReader br = new BufferedReader(fread);
   FileWriter fwrite = new FileWriter(str+"Change2.txt");
   PrintWriter pr = new PrintWriter(fwrite);

   do
   {
    for(i=0;i<4;i++)
    {
     for(j=0;j<4&&((r = br.readLine()) !=null);j++)
      array[i][j]=Integer.parseInt(r);
    }

   if(r!=null)
   {
    a=Integer.parseInt(r=br.readLine());
    b=Integer.parseInt(r=br.readLine());
    c=Integer.parseInt(r=br.readLine());
    d=Integer.parseInt(r=br.readLine());
   }
   if(r!=null)
    {
     for(i=0;i<4;i++)
      for(j=0;j<4;j++)
      {
       if(array[i][j]==1)
        array[i][j]=b;
       else
        array[i][j]=a;
       pr.println(array[i][j]);
      }
    }


   /*if(r!=-1)
    {
     System.out.println("a:"+(char)a);
     System.out.println("b:"+(char)b);

     for(i=0;i<2;i++)
      for(j=0;j<2;j++)
      {
       System.out.println("array["+i+"]["+j+"] :"+(char)array[i][j]);
      }
    }*/
   }
   while(r!=null);

   br.close();
   pr.close();
   
  System.out.println("\n\n The 1 and 0 are replaced by a and b value and  ");
  System.out.println(" stored into the File Change2.txt ");

   }
   catch(IOException e)
   {
    System.out.println(e);
   }
  
 }
 /*public static void main(String args[])
 {
  ChangeMatrix obj = new ChangeMatrix();
  obj.change(4);
 }*/
}
