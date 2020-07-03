package it.polito.tdp.parole.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Parole {
		
	List<String> parole; 
	
	public Parole() {
		//Costruttore 
		parole = new ArrayList<String>();
	}
	
	public void addParola(String p) {
		//Il metodo permette di aggiungere la stringa p alla lista di stringhe
		//p è la stringa da aggiungere
		parole.add(p);
	}
	
	public List<String> getElenco() {
		//Il metodo permette di ottenere la lista di stringhe ordinate seguendo l'ordine alfabetico
		Collections.sort(parole);
		return parole;
	}
	
	public void reset() {
		//Il metodo permette di eliminare tutte le stringhe della lista
		parole.clear();
	}

	public void cancella(String s) {
		parole.remove(s);
	}
}
