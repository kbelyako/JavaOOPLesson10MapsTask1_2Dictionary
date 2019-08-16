//1. �������� ��������� - ����������, ������� ����� ���������� ����� � ����� English.in, ���������� 
// �� ���������� �����, �� ���������� ����, �������� ������� ������������� �������. 
// ��������� ��������� � ���� Ukrainian.out.
//2. ������� �-� ������� ���������� ������� � ����������� ��� ���������� �� ����.


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
		dict.put("go", "������");
		dict.put("school", "�����");
		dict.put("i", "�");
		dict.put("not", "��");
		dict.put("every", "������");
						
			 try (ObjectOutputStream OOS = new ObjectOutputStream(
			 new FileOutputStream("test1.sav"))) {
			 OOS.writeObject(dict);
			 } catch (IOException e) {
			 System.out.println("ERROR save dict !!!");
			 }
			
	    MyDictionary testDict = new MyDictionary();	    
		
		//System.out.println(testDict.translate("English.txt","Russian.txt"));
		testDict.addWord("to", "�");
	//	System.out.println(testDict.translate("English.txt","Russian1.txt"));
		testDict.addWord("to", "�");
		testDict.saveDictToFile("test.sav");		
		testDict.loadDictFromFile("test.sav");
		testDict.loadDictFromFile("test1.sav");		
	//	System.out.println(testDict.translate("English.txt","Russian1.txt"));
	}


}