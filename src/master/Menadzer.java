package master;

public class Menadzer extends Pracownik {

	private int liczbaPodwladnych;
	private double dodatekDoPensji;
	
	public Menadzer(String imie, String nazwisko, String pesel,
			String stanowisko, double pensja, int liczbapodwladnych) {
		super(imie, nazwisko, pesel, stanowisko, pensja);
		this.liczbaPodwladnych = liczbapodwladnych;
	}
	
	@Override
	public String toString() {
		String imie = getImie();
		String nazwisko = getNazwisko();
		String pesel = getPesel();
		String stanowisko = getStanowisko();
		double pensja = getPensja();
		
		
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
		           + "; Stanowisko: " + stanowisko + "; Pensja: " + pensja + "; Liczba podwladnych: "
		           + liczbaPodwladnych + "; Dodatek do pensji: " + dodatekDoPensji;
	}
	
	public int getLiczbaPodwladnych() {
		return this.liczbaPodwladnych;
	}
	
	public void setLiczbaPodwladnych(int liczbapodwladnych) {
		this.liczbaPodwladnych = liczbapodwladnych;
	}
	
	public double getDodatekDoPensji() {
		return this.dodatekDoPensji;
	}
	
	public void setDodatekDoPensji(double dodatekDoPensji) {
		this.dodatekDoPensji = dodatekDoPensji;
	}
	
	public double obliczRoczneWynagrodzenie() {
		return getPensja() * 12 + dodatekDoPensji;
	}
	
}