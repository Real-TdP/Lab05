package it.polito.tdp.lab05.model;


public class Anagramma {
	private String anagramma;
	private boolean corretto;
	
	public Anagramma(String anagramma, boolean corretto) {
		this.anagramma = anagramma;
		this.corretto = corretto;
	}

	public String getAnagramma() {
		return anagramma;
	}

	public void setAnagramma(String anagramma) {
		this.anagramma = anagramma;
	}

	public boolean isCorretto() {
		return corretto;
	}

	public void setCorretto(boolean corretto) {
		this.corretto = corretto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anagramma == null) ? 0 : anagramma.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Anagramma other = (Anagramma) obj;
		if (anagramma == null) {
			if (other.anagramma != null)
				return false;
		} else if (!anagramma.equals(other.anagramma))
			return false;
		return true;
	}
	
	
	

}
