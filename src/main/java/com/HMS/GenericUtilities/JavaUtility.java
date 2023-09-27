package com.HMS.GenericUtilities;

import java.util.Date;
import java.util.Random;

/**
 * @author Prasad J
 */
public class JavaUtility {

	/**
	 * This method is used get random number
	 * @return
	 */
	public int randomNumber() {
		Random rn=new Random();
		int randomNum = rn.nextInt(1000);
		return randomNum;
	}
	
	/**
	 * This method will fetch System date in IST format
	 * @return
	 */
	public String getSystemDate() {
		Date date = new Date();
		return date.toString();
	}
	
	/**
	 * This method will fetch System date in required format
	 * @return
	 */
	public String getSystemDateInFormat() {
		Date dateTime = new Date();
		String[] d = dateTime.toString().split(" ");
		
		String day = d[0];
		String month = d[1];
		String date = d[2];
		String year = d[5];
		String dateFormat = day+" "+month+" "+date+" "+year;
		return dateFormat;
		
	}
	
}
