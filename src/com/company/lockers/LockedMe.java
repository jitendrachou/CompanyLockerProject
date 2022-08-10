package com.company.lockers;

import java.io.File;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class LockedMe 
{
	
	static final String projectPath="C:\\Users\\Jitendra\\Downloads\\SimpliLearn Full Stack Java\\Phase 1 JAVA\\Finale Project\\LockedMeFiles"; 
			
	

	public static void main(String[] args)
	{
		Scanner obj = new Scanner (System.in);
		int ch;
		
		do
		{
			displayMenu();
			System.out.println("Enter your choice:");
			
			ch=Integer.parseInt(obj.nextLine());
			switch(ch)
			{
				case 1:getAllFiles();
					break;
				case 2:createFiles();
					break;
				case 3:deleteFiles();
					break;
				case 4:searchFiles();
					break;
				case 5:System.exit(0);
					break;
				default:System.out.println("Invalid Option");
					break;
			}
			
		}
		while(ch>0);
			
		
	 
	}
	
	public static void displayMenu()
	{
		System.out.println("******************************************************");
		System.out.println("\tWelcome to Company Lockers - LockedMe.com");
		System.out.println("\tDeveloper Name : Jitendra Choudhary");
		System.out.println("******************************************************");
		System.out.println("\t1. Display all the file");
		System.out.println("\t2. Add files to exiting directory");
		System.out.println("\t3. Delete a file");
		System.out.println("\t4. Search a file");
		System.out.println("\t5. Exit");
		System.out.println("******************************************************");
		
	}
	public static void getAllFiles()
	{
	 	File[] listOfFiles = new File(projectPath).listFiles();
	 	
	 	//if the folder is empty
	 	if(listOfFiles.length==0)
	 		System.out.println("No files exit in the directory");
	 	else
	 	{
	 		for(File l:listOfFiles)
	 		{
	 			System.out.println(l.getName());
	 		}
	 	}
	}
	public static void createFiles()
	{
		try
		{
			Scanner obj = new Scanner(System.in);
			String fileName;
			int linesCount;
			
			System.out.println("Enter file name");
			fileName=obj.nextLine();
			
			System.out.println("Enter how many lines you want to add in file:");
			linesCount=Integer.parseInt(obj.nextLine());
			
			FileWriter fw = new FileWriter(projectPath+"\\"+fileName);
			
			for(int i=1;i<=linesCount;i++)
			{
				System.out.println("Enter file content line:");
				fw.write(obj.nextLine()+"\n");
			}
			System.out.println("File Created Successfully");
			fw.close();
				
		}
		catch (Exception ex)
		{
			System.out.println("Some error occured");
		}
	
	}
	public static void deleteFiles()
	{
		Scanner obj = new Scanner(System.in);
		try
		{
			String fileName;
			System.out.println("Enter file name to be deleted:");
			fileName=obj.nextLine();
			
			File fl = new File(projectPath+"\\"+fileName);
			
			if(fl.exists())
			{
				fl.delete();
				System.out.println("File deleted successfully");
			}
			else
			{
				System.out.println("File do not exist");
			}	 
		}
		catch (Exception Ex)
		{
			System.out.println("Some error occoured");
		}
	}
	public static void searchFiles()
	{
		Scanner obj = new Scanner (System.in);
		try
		{
			String fileName;
			System.out.println("Enter file name to be searched:");
			fileName=obj.nextLine();
			
			File fl = new File(projectPath+"\\"+fileName);
			
			if(fl.exists())
			{
				
				System.out.println("File is available");
			}
			else
			{
				System.out.println("File is not available");
			}
			
			
		}
		catch(Exception Ex)
		{
			
		}
	}
	

}
