import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    private static ArrayList<Zadanie> listaZadan = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n1. Dodaj nowe zadanie");
            System.out.println("2. Oznacz zadanie jako zakończone");
            System.out.println("3. Usuń zadanie");
            System.out.println("4. Wyświetl listę zadań");
            System.out.println("5. Wyjście");
            System.out.print("\nWybierz opcję (1/2/3/4/5): ");
            int opcja = scanner.nextInt();
            scanner.nextLine();

            switch (opcja) {
                case 1:
                    dodajZadanie(scanner);
                    break;
                case 2:
                    oznaczZadanieJakoZakonczone(scanner);
                    break;
                case 3:
                    usunZadanie(scanner);
                    break;
                case 4:
                    wyswietlListeZadan();
                    break;
                case 5:
                    running = false;
                    System.out.println("koniec");
                    break;
                default:
                    System.out.println("Nieprawidłowa opcja, Spróbuj ponownie");
            }
        }

        scanner.close();
    }

    public static void dodajZadanie(Scanner scanner) {
        System.out.print("Podaj nazwę zadania: ");
        String nazwa = scanner.nextLine();
        System.out.print("Podaj opis zadania: ");
        String opis = scanner.nextLine();

        Zadanie noweZadanie = new Zadanie(nazwa, opis);
        listaZadan.add(noweZadanie);
        System.out.println("Zadanie \"" + nazwa + "\" zostało dodane do listy.");
    }

    public static void oznaczZadanieJakoZakonczone(Scanner scanner) {
        if (listaZadan.isEmpty()) {
            System.out.println("Lista zadań jest pusta");
            return;
        }

        wyswietlListeZadan();
        System.out.print("Podaj numer zadania do oznaczenia jako zakończone: ");
        int numerZadania = scanner.nextInt();
        scanner.nextLine();

        if (numerZadania > 0 && numerZadania <= listaZadan.size()) {
            Zadanie zadanie = listaZadan.get(numerZadania - 1);
            zadanie.oznaczJakoZakonczone();
            System.out.println("Zadanie \"" + zadanie + "\" zostało oznaczone jako zakończone");
        } else {
            System.out.println("Nieprawidłowy numer zadania");
        }
    }

    public static void usunZadanie(Scanner scanner) {
        if (listaZadan.isEmpty()) {
            System.out.println("Lista zadań jest pusta");
            return;
        }

        wyswietlListeZadan();
        System.out.print("Podaj numer zadania do usunięcia: ");
        int numerZadania = scanner.nextInt();
        scanner.nextLine(); 

        if (numerZadania > 0 && numerZadania <= listaZadan.size()) {
            Zadanie zadanie = listaZadan.remove(numerZadania - 1);
            System.out.println("Zadanie \"" + zadanie + "\" zostało usunięte z listy");
        } else {
            System.out.println("Nieprawidłowy numer zadania");
        }
    }

    public static void wyswietlListeZadan() {
        if (listaZadan.isEmpty()) {
            System.out.println("Lista zadań:\n(brak zadań)");
        } else {
            System.out.println("Lista zadań:");
            for (int i = 0; i < listaZadan.size(); i++) {
                System.out.println((i + 1) + ". " + listaZadan.get(i));
            }
        }
    }
}
