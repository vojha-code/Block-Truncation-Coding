package BTC_IV;
import java.io.*;
class FinalMatrix
{

  String r="null"; 
  int array[][]=new int[512][512];
  int x=4;
  int ivalue=0,jvalue=0;
  int icond=x,jcond=x;
  long brk=0;

  int rep1(int n,String str)
   {
    try
     {
      FileReader  fread = new FileReader(str+"Change2.txt");
      BufferedReader br = new BufferedReader(fread);

      do
      {
       int i,j;
      
      //System.out.println("\n\nBroken Matrix No. :"+(brk=brk+1));
           
       for(i=ivalue;i<icond;i++)
       {
        for(j=jvalue;j<jcond && (r=br.readLine())!=null;j++)
         { 
           array[i][j]=Integer.parseInt(r);
         }
       }  
                       
        if(jcond<n)
        {
         jvalue=jvalue+x;
         jcond=jcond+x;
        }
        else
        {
         ivalue=ivalue+x;
         icond=icond+x;
         jvalue=0;
         jcond=x;
        }
       }
       while(icond<=n && r!=null);
      
      FileWriter  fwrite= new FileWriter(str+"Final2.txt");
      PrintWriter pr = new PrintWriter(fwrite);
      
      int k=0,l=0; 
      for(k=0;k<n;k++)
        for(l=0;l<n;l++)
          pr.println(array[k][l]);  

       System.out.println("\n\n The matrix Is Finaly rearraged and stored ");
       System.out.println(" into the File Final.txt ");

   br.close();
   pr.close();
   }
   catch(IOException e)
   {
    System.out.println("IOException:");
    e.printStackTrace();
   }
   return 0;
  }
 
 /*public static void main(String args[])
  {
   FinalMatrix obj=new FinalMatrix();

   int i,n=512;

   obj.rep1(n,"Change.txt");

  }*/
}
