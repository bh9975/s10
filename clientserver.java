//client.java

import java.io.*;
import java.net.*;

class client3
  {
    public static void main(String[] args) throws IOException 
      {
    	Socket s = null;
    	PrintWriter out = null;
    	int i,n;
        try 
         {
           s = new Socket("127.0.0.1", 1234);
           out = new PrintWriter(s.getOutputStream(), true);
           BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
           BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           System.out.print("Enter the how many files you want: ");
           n=Integer.parseInt(br.readLine());
           out.println(n);
           String fname[]=new String[n];
           System.out.println("Enter the "+n+" file names: ");
           for(i=0;i<n;i++)
             {
             	fname[i]=br.readLine();
                out.println(fname[i]);
                System.out.println(in.readLine());
             }    
           s.close();
           in.close();
         } 
        catch (UnknownHostException e) 
         {
            System.out.println("Error :"+e);
         } 
     }
  }







//server.java

import java.net.*;
import java.io.*;

class server3
  {
    public static void main(String[] args) throws IOException 
     {
       Socket s = null;
       PrintWriter out = null;
       ServerSocket ss = null;
       String fname[]=new String[20];
       int i,n;
       try 
        {
          ss = new ServerSocket(1234);
          System.out.println("Server Started.......");
          s= ss.accept();
          System.out.println("Server Connected.......");
          BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));          
          out = new PrintWriter(s.getOutputStream(), true);
          n=Integer.parseInt(in.readLine());
          System.out.println("The files are: ");
          for(i=0;i<n;i++)
            {
              fname[i]=in.readLine();
               System.out.println(fname[i]);
              File f=new File(fname[i]);
              if(f.exists())
                out.println("File present ");
              else   
                out.println("The file "+fname[i]+" does not exists");
            }   
          out.close();
          s.close();
        } 
      catch (Exception e) 
        {
          System.out.println("Error: "+e);
        }
    } 
 }
