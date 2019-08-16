//1. Написать программу - переводчик, которая будет переводить текст в файле English.in, написанный 
// на английском языке, на украинский язык, согласно заранее составленному словарю. 
// Результат сохранить в файл Ukrainian.out.
//2. Сделать ф-ю ручного наполнения словаря и возможность его сохранения на диск.


package com.yandex.kbelyako;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
				
		Map dict=new HashMap<>();
		dict.put("go", "ходить");
		dict.put("school", "школа");
		dict.put("i", "я");
		dict.put("not", "не");
		dict.put("every", "каждый");
						
			 try (ObjectOutputStream OOS = new ObjectOutputStream(
			 new FileOutputStream("test1.sav"))) {
			 OOS.writeObject(dict);
			 } catch (IOException e) {
			 System.out.println("ERROR save dict !!!");
			 }
			
	    MyDictionary testDict = new MyDictionary();	    
		
		//System.out.println(testDict.translate("English.txt","Russian.txt"));
		testDict.addWord("to", "в");
	//	System.out.println(testDict.translate("English.txt","Russian1.txt"));
		testDict.addWord("to", "в");
		testDict.saveDictToFile("test.sav");		
		testDict.loadDictFromFile("test.sav");
		testDict.loadDictFromFile("test1.sav");		
	//	System.out.println(testDict.translate("English.txt","Russian1.txt"));
	}


}