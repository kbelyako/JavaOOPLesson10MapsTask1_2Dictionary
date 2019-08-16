package com.yandex.kbelyako;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Dictionary {
	
	private String path;	
	private String name;	
	private Map dict;
	
		
	public Dictionary(String name) {
		super();
		this.name = name;
		this.dict=mapCreration();
	}
	
		
	
	public Dictionary() {
		super();
		// TODO Auto-generated constructor stub
	}





	private Map<String, String> mapCreration() {
		dict=new HashMap<>();
		dict.put("go", "ходить");
		dict.put("school", "школа");
		dict.put("i", "я");
		return dict;
	}
	
	private static String FiletoString(String fileName) {
		String res = "";
		try (BufferedReader f = new BufferedReader(new FileReader(fileName))) {
			String str = "";
			String str1 = "";
			for (; (str1 = f.readLine()) != null;) {
				str = str1 + str;
			}
			res = str;
		} catch (IOException e) {
			System.out.println("ERROR");
		}
		return res;
	}

	public static String translate(String fileName) {
		String res="";
		String[] array3 = FiletoString(fileName).split(" ");
		
		return res;
	}
	
	
//	public void saveGroupToFile(Group group, String fileName) {
//
//		try (ObjectOutputStream OOS = new ObjectOutputStream(
//				new FileOutputStream(fileName))) {
//			OOS.writeObject(group);
//		} catch (IOException e) {
//			System.out.println("ERROR save group !!!");
//		}
//
//	}

//	public void loadGroupFromFile(Group group, String fileName) {
//
//		try (ObjectInputStream OIS=new ObjectInputStream(new FileInputStream(fileName))){
//			group=(Group)OIS.readObject();
//		} catch(IOException |
//		ClassNotFoundException e){
//		System.out.println("ERROR load group !!!");
//		}
//
//	}

}
