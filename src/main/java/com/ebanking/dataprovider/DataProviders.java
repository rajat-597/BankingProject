package com.ebanking.dataprovider;


import org.testng.annotations.DataProvider;

import com.ebanking.utility.ExcelUtility;


public class DataProviders {
	
   String path = System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\TestData.xlsx";
		   
	ExcelUtility xl = new ExcelUtility(path);
	
	@DataProvider(name = "input")
	public String[][] getData() throws Exception{
		
	int row =xl.getRowCount("Credentials");
    int column = xl.getCellCount("Credentials", 1);
		
		String[][] data = new String[row][column];
		
		for(int i = 1; i  <= row; i++) {
			for(int j = 0; j < column; j++) {
			 data[i-1][j] = xl.getCellData("Credentials", i, j); //here all the value of row col stored in data variable of array and all the value will be return at once as it is an array.
			 
			}
		}
		return data;
	}
	
	
}
