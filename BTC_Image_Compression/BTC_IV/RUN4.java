package BTC_IV;
public class RUN4
{
 public void run(int data , String str)
 {
  
  System.out.println("\n\n ::--------->>START BTC LEVEL IV.<<----------::");

  BTC_IV obj=new BTC_IV();
  obj.rep(data,str);

  ChangeMatrix obj1 = new ChangeMatrix();
  obj1.change(4,str);
  
  FinalMatrix obj2=new FinalMatrix();
  obj2.rep1(data,str);
  
  FinalOutput obj3=new FinalOutput();
  obj3.rep2(data ,str);
 
  MSE_N_PSNR  obj4=new MSE_N_PSNR();
  obj4.calculate(str);
 }
/* public static void main(String args[])
 {
   int i,n=512;
 
   RUN4 run4=new RUN4();
   run4.run(n,"F"); 
 }*/
}