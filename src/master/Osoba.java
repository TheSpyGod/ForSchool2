package master;

public class Osoba {
	private String imie;
	private String nazwisko;
	private String pesel;
	
	public Osoba(String imie, String nazwisko, String pesel) {
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.pesel = pesel;
	}
	
	@Override
	public String toString() {
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

	    return "Imie i nazwisko: " + this.imie + " " + this.nazwisko +
	           "; Data Urodzenia: " + String.format("%02d/%02d/%d", day, month, fullYear);
	}
	
	private static boolean czyPoprawnyPesel(String pesel) {
		if (pesel == null || pesel.length() != 11) {
	        return false;
	    }

	    int[] weights = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3};
	    int sum = 0;

	    for (int i = 0; i < 10; i++) {
	        int digit = pesel.charAt(i) - '0';
	        sum += digit * weights[i];
	    }

	    int control = (10 - (sum % 10)) % 10;
	    int lastDigit = pesel.charAt(10) - '0';

	    return control == lastDigit;
	}
	
	public String getImie() {
		return imie;
	}
	
	public void setImie(String imie) {
		this.imie = imie;
	}
	
	public String getNazwisko() {
		return nazwisko;
	}
	
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	
	public String getPesel() {
		return pesel;
	}
	
	public void setPesel(String pesel) {
		this.pesel = pesel;
	}
	
}