package master;

public class Pracownik extends Osoba {
	
	private String stanowisko;
	private double pensja;
	
	public Pracownik(String imie, String nazwisko, String pesel, String stanowisko, double pensja) {
		super(imie, nazwisko, pesel);
		this.pensja = pensja;
		this.stanowisko = stanowisko;
	}
	
	@Override
	public String toString() {
		String imie = getImie();
		String nazwisko = getNazwisko();
		String pesel = getPesel();
		
		
	    char[] chars = pesel.toCharArray();

	    int year = (chars[0] - '0') * 10 + (chars[1] - '0');
	    int month = (chars[2] - '0') * 10 + (chars[3] - '0');
	    int day = (chars[4] - '0') * 10 + (chars[5] - '0');

	    int fullYear;

	    if (month >= 1 && month <= 12) {
	        fullYear = 1900 + year;
	    } else if (month >= 21 && month <= 32) {
	        fullYear = 2000 + year;
	        month -= 20;
	    } else if (month >= 41 && month <= 52) {
	        fullYear = 2100 + year;
	        month -= 40;
	    } else if (month >= 61 && month <= 72) {
	        fullYear = 2200 + year;
	        month -= 60;
	    } else if (month >= 81 && month <= 92) {
	        fullYear = 1800 + year;
	        month -= 80;
	    } else {
	        return "Invalid PESEL format.";
	    }

	    return "Imie i nazwisko: " + imie + " " + nazwisko +
	           "; Data Urodzenia: " + String.format("%02d/%02d/%d", day, month, fullYear)
	           + "; Stanowisko: " + stanowisko + "; Pensja: " + pensja + ";";
	}
	
	public double obliczRoczneWynagrodzenie() {
		return pensja * 12;
	}
	
	public double getPensja() {
		return pensja;
	}
	
	public void setPensja(double pensja) {
		this.pensja = pensja;
	}
	
	public String getStanowisko() {
		return stanowisko;
	}
	
	public void setStanowisko(String stanowisko) {
		this.stanowisko = stanowisko;
	}
}