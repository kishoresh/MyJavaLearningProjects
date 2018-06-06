package com.collections.hashcode;

public class ReportCard {
	private double MathMarks;
	private double ScienceMarks;
	private double EnglishMarks;
	
	public ReportCard(Double a,Double b,Double c){
		this.MathMarks = a;
		this.ScienceMarks = b;
		this.EnglishMarks = c;
	}

	public Double AverageMarks(){
		return (MathMarks + ScienceMarks + EnglishMarks) / 3;	
	}
	
	public double getMathMarks() {
		return MathMarks;
	}

	public void setMathMarks(double mathMarks) {
		MathMarks = mathMarks;
	}

	public double getScienceMarks() {
		return ScienceMarks;
	}

	public void setScienceMarks(double scienceMarks) {
		ScienceMarks = scienceMarks;
	}

	public double getEnglishMarks() {
		return EnglishMarks;
	}

	public void setEnglishMarks(double englishMarks) {
		EnglishMarks = englishMarks;
	}
}
