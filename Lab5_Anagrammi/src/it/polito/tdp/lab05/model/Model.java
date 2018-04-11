package it.polito.tdp.lab05.model;

import java.util.*;

public class Model {
	public List<String> trovaAnagrammiCorretti(String parola){
		
		return null;
	}
	
	public List<String>trovaAnagrammi(String parola){
		
		List<String> anagrammi = new ArrayList<String>();
		String anagramma="";
		anagrammi.addAll(this.ricorsiva(parola,anagramma));
		for(String a:anagrammi) {
			Anagramma c = new Anagramma(a,false);
		}
			
		return anagrammi;
	}
	
	public List<String> ricorsiva(String parola,String anagramma) {
		List<String> anagrammi = new ArrayList<String>();
		if(parola.isEmpty()) {
			anagrammi.add(anagramma);
			return anagrammi;	
		}	
		for(int i=0;i<parola.length();i++) {
			anagramma+=parola.charAt(i);
			anagrammi.addAll(this.ricorsiva(parola.substring(0,i)+parola.substring(i+1,parola.length()),anagramma));
			anagramma=anagramma.substring(0, anagramma.length()-1);
		}
		return anagrammi;
	}

}
