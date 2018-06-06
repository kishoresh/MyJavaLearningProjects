package com.io;
/*
 * Read a file having DVD information details and populate data into the DVDInfo object's Arraylist.
 * 
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class DVDInfo{
	int ID;
	String Title;
	String Genre;
	String LeadActor;
	Date ReleaseDt;
	Float Price;
	
	public int getID() {
		return ID;
	}
	public String getTitle() {
		return Title;
	}
	public String getGenre() {
		return Genre;
	}
	public String getLeadActor() {
		return LeadActor;
	}
	public Date getReleaseDt() {
		return ReleaseDt;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public void setGenre(String genre) {
		Genre = genre;
	}
	public void setLeadActor(String leadActor) {
		LeadActor = leadActor;
	}
	public void setReleaseDt(Date releaseDt) {
		ReleaseDt = releaseDt;
	}

	public Float getPrice() {
		return Price;
	}
	public void setPrice(Float price) {
		Price = price;
	}
	@Override
	public String toString() {
		return "DVDInfo [ID=" + ID + ", Title=" + Title + ", Genre=" + Genre + ", LeadActor=" + LeadActor
				+ ", ReleaseDt=" + ReleaseDt + ", Price=" + Price + "]";
	}	
}

public class ReadFileDemo {
	static List<DVDInfo> dvdList = new ArrayList<>();
	
	static void populateDVDList(String[] dvdList){
		try{
			DVDInfo dvd = new DVDInfo();
			dvd.ID = Integer.parseInt(dvdList[0]);
			dvd.Title = dvdList[1];
			dvd.Genre = dvdList[2];
			dvd.LeadActor = dvdList[3];
			dvd.ReleaseDt = new SimpleDateFormat("dd/mm/yyyy").parse(dvdList[4]);
			dvd.Price = Float.parseFloat(dvdList[5]);
			
			ReadFileDemo.dvdList.add(dvd);   //Add to the List
			//System.out.println(dvd.toString());
		}catch (ParseException e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		String csvFile = "D:\\My Folder\\MyJavaProjects\\src\\com\\io\\DVDInfoList.txt";
		String csvSplitBy = ",";
		String line="";
		int i;
		
		try{
			File fl = new File(csvFile);
			if (fl.exists()){
				BufferedReader br = new BufferedReader(new FileReader(fl));
				while ((line = br.readLine()) != null){
					String[] dvdList = line.split(csvSplitBy);
					populateDVDList(dvdList);
				}
			}
			
			if (dvdList.size() > 0){
				for(DVDInfo d : dvdList){
					System.out.println(d.toString());
				}
			}
		}catch (IOException e){
			e.printStackTrace();
		}

	}

}
