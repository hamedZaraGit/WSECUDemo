package org.wsecu.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileUtility {
	
	/**
	 * this method is used for reading file 
	 * @param filePath
	 * @return FileInputStream
	 * @throws FileNotFoundException
	 */
	public static FileInputStream getFileInputStream(String filePath) throws FileNotFoundException {
		return new FileInputStream(new File(filePath));
		
	}
	
	

}
