package com.yandex.kbelyako;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MyDictionary {

	private Map dict;

	public MyDictionary() {
		super();
		this.dict = mapCreration();
	}

	private Map<String, String> mapCreration() {
		Map dict = new HashMap<>();
		dict.put("go", "ходить");
		dict.put("school", "школа");
		dict.put("i", "я");
		dict.put("not", "не");

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
		//System.out.println("res=" + res);
		return res;
	}

	public static void stringToFile(String inputStr, String outFile) {

		try (PrintWriter a = new PrintWriter(outFile)) {
			a.println(inputStr);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			// System.out.println("ERROR FILE WRITE");
		}

	}

	public void translate(String inFileName, String outFileName) {
		String res = "";
		String[] array = FiletoString(inFileName).split(" ");

		for (int i = 0; i < array.length; i++) {
			// System.out.println((array[i]));
			if (this.dict.get(array[i]) != null) {
				if (i != 0)
					res = res + " " + this.dict.get(array[i]);
				else
					res = res + this.dict.get(array[i]);
			} else {
				if (i != 0)
					res = res + " " + array[i];
				else
					res = res + array[i];
			}
		}
		stringToFile(res,outFileName);
		//return res;
	}

	public void addWord(String english, String russian) {

		if (this.dict.get(english) != null) {
			System.out.println("Dictionary already contains such word");
		} else
			dict.put(english, russian);
	}

	public void saveDictToFile(String fileName) {
		try (ObjectOutputStream OOS = new ObjectOutputStream(
				new FileOutputStream(fileName))) {
			OOS.writeObject(dict);
		} catch (IOException e) {
			System.out.println("ERROR save dict !!!");
		}
	}

	public void loadDictFromFile(String fileName) {
		try (ObjectInputStream OIS = new ObjectInputStream(new FileInputStream(
				fileName))) {
			dict = (Map) OIS.readObject();
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("ERROR load dict !!!");
		}

	}

}
