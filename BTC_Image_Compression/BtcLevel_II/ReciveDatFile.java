package BtcLevel_II;
import BtcLevel_III.*;
import BTC_IV.*; 
import java.io.*;
class ReciveDatFile
{
 public void runII()
 //public static void main(String args[])
 {
   
  int flag=0;//proccessing permission for programm
  String outFile="";//the whole package( is kept in which Drive
  try{
    
   
   InputStreamReader in=new InputStreamReader(System.in);
   BufferedReader ibr=new BufferedReader(in);

   //System.out.print("\n Enter The Path until BTC_Image_Compression folder :");
   //Drive=ibr.readLine();

   String inFile = System.getProperty("user.dir") + File.separator + "DATA512" + File.separator;
   outFile = System.getProperty("user.dir") + File.separator + "OutputFile" + File.separator;
   
   System.out.print("\n Input Directory is: "+inFile);
   System.out.print("\n Output Directory is: "+outFile);
   System.out.print("\n Enter The File Name :");
   String FILE=ibr.readLine();

    FileReader  fread = new FileReader(inFile+""+FILE);
    FileWriter  fwrite= new FileWriter(outFile+"out.txt");
                                                 
    BufferedReader br = new BufferedReader(fread);
    PrintWriter    pr = new PrintWriter(fwrite);


  int  i=-1;//i store the read value(of one charracter at a time) from file
  int k=0;//it count the distinct digit charracter 
  int  count=0;//count counts the one  integer input data as a collection of three k value

   //int array[]=new int[262144];
   //int n=0;

  while((i=br.read())!=-1)
   {
    if(i!=13&&i!=10)
    {
     if(i!=32)
     {
      k++;
      pr.print((char)i); //Printing one digit at a time in out.txt
     }
     else
      pr.println(); //printin new line after three  digit print 

     if(k==3)
     {
      count++;//increase the counts of input integer data value   
      k=0;
     }
    }
   }
   
   System.out.println("\n\n ::--------->>START BTC LEVEL II.<<----------::");
   System.out.println("\n\n The input matrix of "+count+" integer data are  stored ");
   System.out.println(" into the File out.txt ");

  pr.close();
  br.close();
  }
  catch(Exception e)
  { System.out.println("\n"+e);
   flag=1;// if any exception occur it will not go on proccecing
  }
  
  if(flag==0)
  {
  int data=512;
  
  BrockenIntoBlock obj=new BrockenIntoBlock();
  obj.rep(data,outFile);//call the rep function
  
  ChangeMatrix obj1 = new ChangeMatrix();
  obj1.change(4,outFile);
  
  FinalMatrix obj2=new FinalMatrix();
  obj2.rep1(data,outFile);
  
  FinalOutput obj3=new FinalOutput();
  obj3.rep2(data ,outFile);
 
  MSE_N_PSNR  obj4=new MSE_N_PSNR();
  obj4.calculate(outFile);
 
  Run_BTC_III obj5=new Run_BTC_III();
  obj5.run(outFile);
  
  RUN4 run4=new RUN4();
  run4.run(data,outFile); 
  
  }
  else
   flag=0;
 }
 
}
