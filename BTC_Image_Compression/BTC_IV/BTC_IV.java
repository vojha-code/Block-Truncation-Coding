package BTC_IV;
import java.io.*;
import java.math.*;
class BTC_IV
{


  int x=4;
  int ivalue=0,jvalue=0;
  int icond=x,jcond=x;
  long brk=0;

  long matrix(int array[][],int x,int n,String str)
   {
     int m=x*x;
            
    try
     {
      FileWriter  fwrite= new FileWriter(str+"newout2.txt");
      PrintWriter pr = new PrintWriter(fwrite);

     do
     {
      int i,j;
      int min=0,max=0;
      int count=0;
      int END=0,countLoop=1;
      double A=0.0,B=0.0,C=0.0,D=0.0; //taking A,B,C,D
      double Ax=0.0,Bx=0.0,Cx=0.0,Dx=0.0;  
      double A1=0.0,B1=0.0,C1=0.0,D1=0.0;//taking A1,B1,C1,D1
      double th=0.0,tm=0.0,tl=0.0;
      int p=0,q=0,r=0,s=0;
      int xp=0,xq=0,xr=0,xs=0; 
      double diffA=0.0,diffB=0.0,diffC=0.0,diffD=0.0;  
 
      int arr[][]=new int[4][4];

    
      brk=brk+1;//counting 4X4 matrics operation no:

//------>MAX AND MIN CALCULATION

       for(i=ivalue;i<icond;i++)
        for(j=jvalue;j<jcond;j++)
         {
          
          if(count==0)
            {
             min=array[i][j];
             max=array[i][j];
            }
          count++;
          
          if(min>=array[i][j])
             min=array[i][j];  
        
         if(max<=array[i][j])
             max=array[i][j];  

         } 
//--------> Copping the array into another array:
      
       int k=0,l=0;
       for(i=ivalue;i<icond;i++)
       {
        for(j=jvalue;j<jcond;j++)
         {
            arr[k][l]=array[i][j];
            l++;
         }
        k++;
        l=0;
       }
 

//-------->CALCULATION END HERE:
 
//---->START CALCULATION:
       
        A=min;
        B=(double)(2*min+max)/3;
        C=(double)(2*max+min)/3;
        D=max;
 
       Ax=A;
       Bx=B;
       Cx=C;
       Dx=D;

      
     // while(END!=0)
     // {
 
        th=(double)(Ax+Bx)/2;
        tm=(double)(Bx+Cx)/2;
        tl=(double)(Cx+Dx)/2; 

            
       for(k=0;k<4;k++)
        for(l=0;l<4;l++)
        {
         if(arr[k][l]<=th)
          {
           p++;
           xp=xp+arr[k][l];
           pr.println(0);
          }

         else if(arr[k][l]>th && arr[k][l]<=tm)  
          {
            q++;
            xq=xq+arr[k][l];
            pr.println(1);  
          }
         else if(arr[k][l]>tm && arr[k][l]<=tl)
          {
           r++;
           xr=xr+arr[k][l]; 
           pr.println(2);
          } 
         else if(arr[k][l]>tl)
          {
           s++;
           xs=xs+arr[k][l];
           pr.println(3);
          }    
        }
        
          if(p==0)
             p=1;
          if(q==0)
             q=1;
          if(r==0)
             r=1;
          if(s==0)
             s=1;
   
        A1=((double)xp)/p;
        B1=((double)xq)/q;
        C1=((double)xr)/r;
        D1=((double)xs)/s;
       
        diffA=A-A1;
        diffB=B-B1;
        diffC=C-C1;
        diffD=D-D1;
     
          if(diffA<0)
             diffA=diffA*(-1);
          if(diffB<0)
             diffB=diffB*(-1);
          if(diffC<0)
             diffC=diffC*(-1);
          if(diffD<0)
             diffD=diffD*(-1);
 
      /* if(diffA<=1.0 && diffB<=1.0 && diffC<=1.0 && diffD<=1.0)
          {
           END=0;
          } 
         else
          {   
          Ax=A1;
          Bx=B1;
          Cx=C1;
          Dx=D1;
          }
          
      }*/
      

//-------->END CALCULATION:
     
   
       pr.println((int)A1);
       pr.println((int)B1);
       pr.println((int)C1);
       pr.println((int)D1);
      
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
       while(icond<=n);
        
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

    FileWriter  fwrite= new FileWriter(str+"newout2.txt");
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

 /*public static void main(String args[])
  {
   BTC_IV obj=new BTC_IV();

   int i,n=512;

   obj.rep(n,"F");

  }*/
}
