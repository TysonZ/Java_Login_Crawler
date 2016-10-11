//==============================================
// Author: Tyson Skmuzz
// Github: https://github.com/skmuzz
// Project Git: https://github.com/skmuzz/Find-Admin-Login-Page
// Open Source & Free to distribute with credit.
//==============================================


import java.util.*;
import java.io.*;
import java.net.*;

public class FindAdminLogin{

public static void main(String[] args){
String address= "";
String fileName = "adminlist.txt";
String log = "";
String extension = "";
int counter = 0;

//Help, how can i do both http & https requsts w/o doubling the amount of requests?
System.out.println("#========== Web Crawler - Looking for Admin Login Dir ==========#");
System.out.println("# https://www.example.com | Include HTTP / HTTPS tag! ");
System.out.print("# Enter URL: ");
Scanner kb = new Scanner(System.in);
address = kb.nextLine();
System.out.println("# ");
try{
List<String> adminurl = new ArrayList<String>();
List<String> foundurl = new ArrayList<String>();
Scanner fl = new Scanner(new File(fileName));
System.out.println("# Populating array...");
while(fl.hasNextLine()){
  log = fl.nextLine();
  adminurl.add(log);
}
System.out.println("# Success: Array Populated!");
System.out.println("# Search Begun Please Wait.");
int adminlistsize = adminurl.size();

for(int i = 0; i < adminlistsize; i++){
  extension = adminurl.get(i);
  //Begin Connection
  URL url = new URL(address  + extension);
  HttpURLConnection connection = (HttpURLConnection)url.openConnection();
  connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
  connection.setRequestMethod("GET");
  connection.connect();
 //Get Responce Code
  int code = connection.getResponseCode();
  if(code == 200){
    //Responce OK, add to found arraylist
    System.out.print(".");
    foundurl.add(extension);
    counter++;
  }


}

//Alert User of results.
System.out.println("");
System.out.println("# " + counter + " results found.");
if(counter != 0){
  int foundurlsize = foundurl.size();
  String urlf = "";

  for(int i = 0; i < foundurlsize; i++){
      urlf = adminurl.get(i);
      System.out.println("# -   " + address + urlf);
  }
}


// I'm lazy with exceptions
} catch(Exception e){
  System.out.println(" ");
  System.out.println("!!========== ERROR ==========!! ");
  System.out.println("!! ");
  System.out.println("!! " + e.getMessage());
  System.out.println("!! ");
  System.out.println("!! Please contact me via github for help! https://github.com/skmuzz/Find-Admin-Login-Page");
}

}

}
