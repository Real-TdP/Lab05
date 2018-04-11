package it.polito.tdp.lab05.model;
import java.util.*;
public class TestModel {

	public static void main(String[] args) {

		String parola="ciao";
		Model m=new Model();
		List<String> anagram =m.trovaAnagrammi(parola);
		for(String a:anagram)
			System.out.println(a);
		
		
		System.out.println(anagram.size());
			
		
		System.out.println(parola.substring(0,1)+" STOP "+parola.length()+"   EHI "+parola.substring(2,parola.length()));
	}

}
