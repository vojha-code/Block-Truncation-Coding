package BtcLevel_III;
import java.io.*;
import java.math.*;
class BTC_LEVEL_III
{


  int x=4;
  int ivalue=0,jvalue=0;
  int icond=x,jcond=x;
  long brk=0;
  String r="null";
 
  long matrix(int array[][],int x,int n,String str)
   {
     
            
    try
     {
      
      FileReader  fread = new FileReader(str+"newout.txt");
      BufferedReader brab = new BufferedReader(fread);

      FileWriter  fwrite= new FileWriter(str+"newout1.txt");
      PrintWriter pr = new PrintWriter(fwrite);

     do
     {
      int p=0,q=0; 
      int i,j,l,k,xiq=0,xip=0;
      int th=0,tl=0;
      int a=0,b=0;
      double a3=0,b3=0;
      int arr[][]=new int[4][4];

      brk=brk+1;
                  
                  
//START OF CALCULATION
      
    for(l=0;l<4;l++)
    {
     for(k=0;k<4&&((r = brab.readLine()) !=null);k++)
      arr[l][k]=Integer.parseInt(r);
    }

     if(r!=null)
     {
      a=Integer.parseInt(r=brab.readLine());
      b=Integer.parseInt(r=brab.readLine());
     }
      
    th=(3*b+a)/4;
    tl=(3*a+b)/4;
   
       for(i=ivalue;i<icond;i++)
       {
        for(j=jvalue;j<jcond;j++)
        {
         
          if(array[i][j]<=tl)
          {
           p++;
           xip=xip + array[i][j];
           pr.println(-1);
          }
          else if(array[i][j]>th)
          {
           q++; 
           xiq=xiq + array[i][j];              
           pr.println(1);
          }
         else 
         {
          pr.println(0);
         }
        }
       }
       
      if(q==0)
       q=1;
      if(p==0)
       p=1;  

      a3=(double)xip/p;
      b3=(double)xiq/q;
 
       

       //System.out.println("a:"+a);
      // System.out.println("b:"+b);


//END OF CALCULATION    
       
       
       pr.println((int)a3);
       pr.println((int)b3);
       
   

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
       while(icond<=n&&r!=null);
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
 
 void rep(int m,String str)
  {
   String r="null";
   int i,j,n=m,ths=3;
   int a[][] = new int[n][n];
   int ar[][] = new int[n][n];

   try
   {

    FileReader  fread = new FileReader(str+"out.txt");
    BufferedReader br = new BufferedReader(fread);

    FileWriter  fwrite= new FileWriter(str+"newout1.txt");
    PrintWriter    pr = new PrintWriter(fwrite); 


    for(i=0;i<n;i++)
     {
      for(j=0;j<n&&((r = br.readLine()) !=null);j++)
        a[i][j]=Integer.parseInt(r);
     }

    // Coppying Array a[][] Into Array ar[][]
    for(i=0;i<n;i++)
      for(j=0;j<n;j++)
        ar[i][j]=a[i][j];
      
      matrix(ar,4,n,str);

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

 /* public static void main(String args[])
  {
 
   int data=512;  
 
   BTC_LEVEL_III obj=new BTC_LEVEL_III();
   obj.rep(data,"F");
 
   BTC_ChangeMatrix obj1 = new BTC_ChangeMatrix();
   obj1.change(4,"F");
   
   FinalMatrix obj2=new FinalMatrix();
   obj2.rep1(data,"F");
  
   FinalOutput obj3=new FinalOutput();
   obj3.rep2(data,"F");
   
   MSE_N_PSNR  obj4=new MSE_N_PSNR();
   obj4.calculate("F");
  }*/
}
