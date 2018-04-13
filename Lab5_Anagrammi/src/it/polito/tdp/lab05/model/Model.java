package it.polito.tdp.lab05.model;

import java.util.*;

import it.polito.tdp.lab05.DAO.DizionarioDAO;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Model {
	private IntegerProperty Nerr= new SimpleIntegerProperty();
	private IntegerProperty Ncorr= new SimpleIntegerProperty();

	
	public List<String>trovaAnagrammi(String parola){
		
		List<String> anagrammi = new ArrayList<String>();
		String anagramma="";
		anagrammi.addAll(this.ricorsiva(parola,anagramma));
	
				
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
			List<String> parz=this.valutaDuplicato(this.ricorsiva(parola.substring(0,i)+parola.substring(i+1,parola.length()),anagramma), anagrammi);
			anagrammi.addAll(parz);
			anagramma=anagramma.substring(0, anagramma.length()-1);
		}
		return anagrammi;
	}
	public List<String> valutaDuplicato(List<String> parz,List<String> anagrammi) {
		for(String c:anagrammi)
			if(parz.contains(c))
				parz.remove(c);
		return parz;
	}
	
	
	public List<String> anagrammiCorretti(List<String> anagrammi){
		List<String> anagrammiC = new ArrayList<String>();
		for(String a:anagrammi)
			if(this.isCorrect(a))
				anagrammiC.add(a);
		Ncorr.set(anagrammiC.size());
		return anagrammiC;
	}
	
	public List<String> anagrammiErrati(List<String> anagrammi){
		List<String> anagrammiE = new ArrayList<String>();
		for(String a:anagrammi)
			if(!this.isCorrect(a))
				anagrammiE.add(a);
		Nerr.set(anagrammiE.size());
		return anagrammiE;
	}
	
	public boolean isCorrect(String anagramma) {
		DizionarioDAO d = new DizionarioDAO();
		return d.isCorrect(anagramma);
	}

	public final IntegerProperty NerrProperty() {
		return this.Nerr;
	}
	

	public final int getNerr() {
		return this.NerrProperty().get();
	}
	

	public final void setNerr(final int Nerr) {
		this.NerrProperty().set(Nerr);
	}
	

	public final IntegerProperty NcorrProperty() {
		return this.Ncorr;
	}
	

	public final int getNcorr() {
		return this.NcorrProperty().get();
	}
	

	public final void setNcorr(final int Ncorr) {
		this.NcorrProperty().set(Ncorr);
	}
	
	
	

}
