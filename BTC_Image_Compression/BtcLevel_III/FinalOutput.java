package BtcLevel_III;
import java.io.*;
class FinalOutput
{

 void rep2(int m,String str)
  {
   String r="null";
   int i,j,n=m,row=0;
   long a[][] = new long[n][n];
   long ar[][] = new long[n][n];

   try
   {

    FileReader  fread = new FileReader(str+"Final1.txt");
    BufferedReader br = new BufferedReader(fread);

    FileWriter  fwrite= new FileWriter(str+"FinalOutputFile1.pgm");
    PrintWriter    pr = new PrintWriter(fwrite); 

	 pr.println("P2");
	 pr.println("512 512");
	 pr.println("255");

    for(i=0;i<n;i++)
     {
      for(j=0;j<n&&((r = br.readLine()) !=null);j++)
        a[i][j]=Integer.parseInt(r);
     }

    // Coppying Array a[][] Into Array ar[][]
    for(i=0;i<n;i++)
      for(j=0;j<n;j++)
        ar[i][j]=a[i][j];
      
     for(i=0;i<n;i++)
     {
         for(j=0;j<n;j++)
         { 
           row++;
           if(row==17)
           {
            row=0;

             if(ar[i][j]>=0 &&ar[i][j]<=9)
               pr.print(" 00"+ar[i][j]);
             else if(ar[i][j]>9 && ar[i][j]<=99)
               pr.print(" 0"+ar[i][j]); 
             else 
               pr.print(" "+ar[i][j]);

            pr.print(" "+(char)10);
           }
           else 
           {
           
             if(ar[i][j]>=0 &&ar[i][j]<=9)
               pr.print(" 00"+ar[i][j]);
             else if(ar[i][j]>9 && ar[i][j]<=99)
               pr.print(" 0"+ar[i][j]); 
             else 
               pr.print(" "+ar[i][j]);
           }
         }
         pr.print(" "+(char)10);
        row=0;
      }
     
    System.out.println("\n\n The 512x512 matrix Is Finaly  stored ");
    System.out.println(" into the File FinalOutputFile.pgm ");
 

    br.close();
    pr.close();

   }
   catch(IOException e)
   {
    System.out.println("IOException:");
    e.printStackTrace();
   }
  }

 /*public static void main(String args[])
  {
   FinalOutput obj=new FinalOutput();

   int i,n=512;

//   for(i=0;i<args.length;i++)
 //   n=Integer.parseInt(args[i]);
   obj.rep2(n);

  }*/
}
