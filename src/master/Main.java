package master;

public class Main {

    public static void main(String[] args) {

            Osoba osoba = new Osoba("Anna", "Nowak", "02270803628");

            Pracownik pracownik = new Pracownik("Jan", "Kowalski", "97040312347", "Programista", 8500.0);

            Menadzer menadzer = new Menadzer("Ewa", "Wiśniewska", "80010112369", "Kierownik działu", 12000.0, 10);

            System.out.println(osoba);

            System.out.println(pracownik);

            System.out.println(menadzer);

            System.out.println(pracownik.obliczRoczneWynagrodzenie());

            System.out.println(menadzer.obliczRoczneWynagrodzenie());

    }

}