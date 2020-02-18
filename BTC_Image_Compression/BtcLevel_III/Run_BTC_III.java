package BtcLevel_III;

public class Run_BTC_III
{
  //public static void main(String arsg[])
  public void run(String str)
  {
     
   int data=512;   
  
   System.out.println("\n\n ::--------->>START BTC LEVEL III.<<----------::");
   
   BTC_LEVEL_III obj=new BTC_LEVEL_III();
   obj.rep(data,str);
 
   BTC_ChangeMatrix obj1 = new BTC_ChangeMatrix();
   obj1.change(4,str);
   
   FinalMatrix obj2=new FinalMatrix();
   obj2.rep1(data,str);
  
   FinalOutput obj3=new FinalOutput();
   obj3.rep2(data,str);
   
   MSE_N_PSNR  obj4=new MSE_N_PSNR();
   obj4.calculate(str);
  }
}
