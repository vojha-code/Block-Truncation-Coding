package BtcLevel_II;
import java.io.*;
import java.math.*;
class BrockenIntoBlock
{


  int x=4;
  int ivalue=0,jvalue=0;
  int icond=x,jcond=x;
  long brk=0;

  long matrix(int array[][],int x,int n,String str)
   {
     int m=x*x;//no of integer data in the broken matrix
            
    try
     {
      FileWriter  fwrite= new FileWriter(str+"newout.txt");
      PrintWriter pr = new PrintWriter(fwrite);

     do
     {
      int i,j,q=0;//q counts the no of '1's in a 4x4 matrix
      int xi=0,xi2=0;
      double m1=0.0,m2=0.0;
      double xth=0.0;
      double sig=0.0;
      double sigma=0.0;
      double sqa=0.0,sqb=0.0;
      double sqra=0.0,sqrb=0.0;
      int a=0,b=0;

      brk=brk+1;

       for(i=ivalue;i<icond;i++)
        for(j=jvalue;j<jcond;j++)
         {
          xi=xi+array[i][j];
          xi2=xi2+(array[i][j]*array[i][j]);
         } 
      //System.out.println("xi:"+xi);
      //System.out.println("xi2:"+xi2);
      
      
       
//START OF CALCULATION
      
       
       m1=(double)xi/m;
       xth=m1;
    
       //System.out.println("xth:"+xth);

       m2=(double)xi2/m;

       sig=m2-m1*m1;
      
       sigma=Math.sqrt(sig);
       
        
       for(i=ivalue;i<icond;i++)
       {
        for(j=jvalue;j<jcond;j++)
        {
         
          if(array[i][j]>=xth)
          {
           q++;
           pr.println(1);
          }
          else
           pr.println(0);
        }
       }
       
       if(q==16)
         q=q-1;

       
     sqa=(double)q/(m-q);
     sqb=(double)(m-q)/q; 
   
     sqra=Math.sqrt(sqa);
     sqrb=Math.sqrt(sqb);       
 
       a=(int)(m1-sigma*sqra);
       b=(int)(m1+sigma*sqrb);

       //System.out.println("a:"+a);
      // System.out.println("b:"+b);


//END OF CALCULATION    
       
       pr.println(a);
       pr.println(b);
       
        if(jcond<n) //chekc whther the value of columns is less then 512
        {
         jvalue=jvalue+x; //increase value by 4(points to the next 4x4 matrix first position)in row
         jcond=jcond+x; //increase value by 4(points to the next 4x4 matrix last position)in row
        }
        else
        {
         ivalue=ivalue+x; //goes to the next position for another 4x4 matrix
         icond=icond+x;
         jvalue=0; //in the new row of 4x4 matrieses set value of culumn to 0
         jcond=x;
        }
       }
       while(icond<=n);//go to the last posotion in the row of 512x512 matrix
          //matrix(array,x,n);
        //else
         System.out.println("\n\n The matrixis Broken Into :"+brk+" matrix of ");
         System.out.println(" 4X4 matrix and stored into File newout.txt");


   pr.close();
   }
   catch(IOException e)
   {
    System.out.println("IOException:");
    e.printStackTrace();
   }
   return 0;
  }
 
//---> Here control comes from ReciveDataFile.java

 void rep(int m,String str)
  {
   String r="null";
   int i,j;
   int n=m;//recive the size od two dimention array
   int ths=3;
   int a[][] = new int[n][n];
   int ar[][] = new int[n][n];

   try
   {

    FileReader  fread = new FileReader(str+"out.txt");
    BufferedReader br = new BufferedReader(fread);

    FileWriter  fwrite= new FileWriter(str+"newout.txt");
    PrintWriter    pr = new PrintWriter(fwrite); 


    for(i=0;i<n;i++)
     {
      for(j=0;j<n&&((r = br.readLine()) !=null);j++)//read each integer data value from file out.txt
        a[i][j]=Integer.parseInt(r);
     }

    // Coppying Array a[][] Into Array ar[][]
    for(i=0;i<n;i++)
      for(j=0;j<n;j++)
        ar[i][j]=a[i][j];
      
      matrix(ar,4,n,str);//call the funtion matrix

      /*for(i=0;i<n;i++)
        {
         for(j=0;j<n;j++)
           System.out.print(ar[i][j]);
         System.out.println();
        }*/ 
      

    br.close();
    pr.close();

   }
   catch(IOException e)
   {
    System.out.println("IOException:");
    e.printStackTrace();
   }
  }
//--->Control gose to the ReciveDataFile.java

 /* public static void main(String args[])
  {
   BrockenIntoBlock obj=new BrockenIntoBlock();

   int i,n=0;

   for(i=0;i<args.length;i++)
    n=Integer.parseInt(args[i]);
   obj.rep(n);

  }*/
}
