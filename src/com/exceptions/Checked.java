package com.exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Checked {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("D:/My Folder/Java Related/CheckList.txt");
		char[] cbuf = {};
		try
		{
		  FileReader fr = new FileReader(file);  
		  //If we do not handle exception, FileNotFoundException or IOException we get compile time error.
		  try
		  {
			  int i;
			  while ((i = fr.read())!= -1){
			    System.out.print((char)i);
			  }
		  //If we do not handle exception, IOException we get compile time error.
		  }catch(IOException e){  
			  System.out.println(e.getMessage());
		  }
		}catch(FileNotFoundException e){
			System.out.println(e.getMessage());
		}
		
	}

}
