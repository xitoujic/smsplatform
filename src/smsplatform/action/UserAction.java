package smsplatform.action;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import smsplatform.dao.TBdMessagesendgroup;

public class UserAction {
	public String sendmsg(TBdMessagesendgroup tBdMessagesendgroup){
		try {
			
			 String location = "http://www.baidu.com";
			 /*    String location = "http://baidu.com";
			 */  //  response.sendRedirect(location);
			    System.out.println(sendGet(location));;
			
			
		} catch (Exception e) {
		    e.printStackTrace();
			return "fail";
		}
		return "success";
	}

	
	public static String sendGet(String url)
    {
     String result = "";
     try{
      String urlName = url ;

      URL U = new URL(urlName);
      URLConnection connection = U.openConnection();
      connection.connect();
     
      BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      String line;
      while ((line = in.readLine())!= null)
      {
       result += line;
      }
      in.close();   
     }catch(Exception e){
      System.out.println("没有结果！"+e);
     }
     return result;
    }
	

}
