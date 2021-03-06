package simplilearnFinalProject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class LockedMe {
	static final String projectFilePath = "D:\\LockedMeProject";

	public static void displayMenu() {
		System.out.println("*******************************************");
		System.out.println("\tWelocome to LockedMe.com secure app");
		System.out.println("\tDeveloped by : Rameshwar M. Katkar");
		System.out.println("*******************************************");
		System.out.println("\t1. Display all files");
		System.out.println("\t2. Add a new file");
		System.out.println("\t3. Delete a file");
		System.out.println("\t4. Search a file");
		System.out.println("\t5. Exit");
		System.out.println("********************************************");
	}

	/*
	 * getAllFiles()- is Returns the list of All Files
	 */
	public static void getAllFiles() {
		File folder = new File(projectFilePath);
		File[] listOfFiles = folder.listFiles();

		if (listOfFiles.length > 0) {
			System.out.println("FILES LIST IS BELOW:\n");
			for (File l : listOfFiles) {
				System.out.println(l.getName());
			}
		} else {
			System.out.println("The folder is empty....");
		}
	}


	/*
	 * createFiles()- This Method is create File in Folder 
	 * its take parameter file name and number of lines
	 */
	public static void createFiles() {
		Scanner obj = new Scanner(System.in);
		String fileName;
		System.out.println("Enter file name :");
		fileName = obj.nextLine();

		int linesCount;
		System.out.println("Enter how many lines in the file : ");
		linesCount = Integer.parseInt(obj.nextLine());

		try {
			FileWriter fw = new FileWriter(projectFilePath + "\\" + fileName + ".txt");
			for (int i = 1; i <= linesCount; i++) {
				System.out.println("Enter file line :");
				fw.write(obj.nextLine() + "\n");
			}
			System.out.println("File Created Successfully");
			fw.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	

	/*
	 * deleteFiles()- This method is used to delete file from Folder
	 * Its take file name as parameter 
	 */

	public static void deleteFiles() {
		Scanner obj = new Scanner(System.in);
		String fileName;
		System.out.println("Enter file name to be deleted :");
		fileName = obj.nextLine();

		// Add all file names into a list
		ArrayList<String> allFilesNames = new ArrayList<String>();
		File folder = new File(projectFilePath);
		File[] listOfFiles = folder.listFiles();

		if (listOfFiles.length > 0) {
			
			for (File l : listOfFiles) {
				// System.out.println(l.getName());
				allFilesNames.add(l.getName());
			}
		}

		try {
			File file = new File(projectFilePath + "\\" + fileName);

			//if (file.exists()) 
			if(allFilesNames.contains(fileName))
			{
				file.delete();
				System.out.println("File deleted Successfully");
			} else {
				System.out.println("File does not exist");
			}
		} catch (Exception ex) {
			System.out.println("Unable to delete file. Please Contact Admin ");
		}

	}
	

	/*
	 * searchFiles()- This Method is Used to search a file in a Folder
	 * it takes fime name as parameter
	 *  
	 */

	public static void searchFiles() {
		try {
			Scanner obj = new Scanner(System.in);
			String fileName;
			System.out.println("Enter a file name to be searched :");
			fileName = obj.nextLine();
			
			// Add all file names into a list
			ArrayList<String> allFilesNames = new ArrayList<String>();
			File folder = new File(projectFilePath);
			File[] listOfFiles = folder.listFiles();

			if (listOfFiles.length > 0) {
				
				for (File l : listOfFiles) {
					// System.out.println(l.getName());
					allFilesNames.add(l.getName());
				}
			}

			
				File file = new File(projectFilePath + "\\" + fileName);

				//if (file.exists()) 
				if(allFilesNames.contains(fileName))
				{
					System.out.println("File is Avilable : ");
				} else {
					System.out.println("File not found : ");
				}
			
			
		} catch (Exception ex) {

		}

	}
	// public static void createFiles() {}
}
