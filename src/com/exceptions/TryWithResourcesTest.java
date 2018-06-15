package com.exceptions;
/*
 * try-with-resources demo :
 * resources have to have implemented Closeable 
 * 1. Using single resource.
 * 2. Using 2 resources. One to write data into a text file and the other to read the text file.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class TryWithResourcesTest {

	//1. Using single resource.
	public static void Test1(){
	  try(FileOutputStream fos = new FileOutputStream("D:/abc.txt")){
		  String msg = "Welcome to Java try-with-resources example";
		  byte byteArray[] = msg.getBytes();
		  fos.write(byteArray);
	  } catch (IOException e) {
		e.printStackTrace();
	  }
	}
	
	//2. Using 2 resources. One to write data into a text file and the other to read the text file.
	//To make it more flexible, input the no of lines and than the lines.
	public static void Test2(){
		String fileName = "D:/abc.txt";
		try(
			Scanner sc = new Scanner(System.in);
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))		){	
			
			int noOfLines = sc.nextInt();			
			for(int i=0; i < noOfLines; i++){
				bw.write(sc.next());
				bw.newLine();
			}
			bw.flush();    //BufferWriter have to be flushed, otherwise it is not saved.
			System.out.println("Data written to file.");

			String line;
			while((line = br.readLine()) !=null){
				System.out.println(line);
			}			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		//Test1();
		Test2();

	}

}
