package BtcLevel_III;
import java.math.*;
import java.io.*;
class MSE_N_PSNR
{
  void calculate(String str){
  try{
    
   String old="null",nw="null";
   double  MSE=0.0;
   int n=0;
   double PSNR=0.0;
   
  
    FileReader  fread_old = new FileReader(str+"out.txt");
    FileReader  fread_new = new FileReader(str+"Final1.txt");

    
    BufferedReader br_old = new BufferedReader(fread_old);
    BufferedReader br_new = new BufferedReader(fread_new);

    
    while(n<262144&&(old=br_old.readLine())!=null&&(nw=br_new.readLine())!=null)
     {
       int x1=0,x2=0,val=0;
         
       x1=Integer.parseInt(old);
       x2=Integer.parseInt(nw);
       
       val=x1-x2;
 
       MSE=MSE+(val*val);
       n++;
     }
    
   MSE=(double)MSE/262144;  
   
   PSNR=10*(Math.log(((double)(255*255)/MSE)));
   
   
   System.out.println("\n MSE Value In BTC LEVEL III :"+MSE);
   System.out.println("\n PSNR Value In BTC LEVEL III :"+PSNR);
   System.out.println("\n _________________ % END OF BTC LEVEL III % _________________");
   

  br_old.close();
  br_new.close();

    }
    catch(Exception e)
    { 
    System.out.println("\n"+e);
    }
  }
}
