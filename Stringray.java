
public class Stringray extends MiniJava {

  public static void main(String[] args) {


    String input = readString("Bitte geben Sie einen Text ein:");


    /////////////////////// Teilaufgabe 1//////////////////////////////////////////////////


    int i = 0;
    int x;
    int j;
    int k;
    int anzahl;
    int[] array = new int[input.length()]; // Array für Buchstaben

    while (i < input.length()) { // Alle Buchstaben zu Großbuchstaben machen
      char c = input.charAt(i);
      x = c;
      if (x >= 97 && x <= 122) {
        x = x - 32;
        array[i] = x;
      } else {
        array[i] = x;
      }
      i++;
    }
    anzahl = 0; // Anzahl der Buchstaben in Array bestimmen
    for (j = 65; j <= 90; j++) {
      for (k = 0; k <= input.length() - 1; k++) {
        if (array[k] == j) {
          anzahl = anzahl + 1;
        }
      }
      char d = (char) j;
      if (anzahl != 0) {
        writeConsole(d + ":" + anzahl + "  ");
      }
      anzahl = 0;
    }


    ////////////////////// Teilaufgabe 2///////////////////////////////////////////////////////


    String output = "";
    boolean korrekt = false; // korrekte Eingabe der Buchstaben
    while (!korrekt) {
      String letters = readString("Bitte geben Sie zwei Buchstaben ein:");
      char erster = letters.charAt(0);
      char zweiter = letters.charAt(1);

      if (letters.length() != 2) {
        write("Es müssen genau zwei Buchstaben eingegeben werden!");
      }
      if (erster <= 64 || erster >= 91 && erster <= 96 || erster >= 123 || zweiter <= 64
          || zweiter >= 91 && zweiter <= 96 || zweiter >= 123) {
        write("Das sind keine Buchstaben.");

      } else { // Buchstaben können klein und groß sein
        if (erster >= 65 && erster <= 90) {
          erster = (char) (erster + 32);
        }
        if (zweiter >= 65 && zweiter <= 90) {
          zweiter = (char) (zweiter + 32);
        }
        char dritter = (char) (erster - 32);
        char vierter = (char) (zweiter - 32);
        int l = 0;
        while (l < input.length()) { // Buchstaben ersetzen
          char g = input.charAt(l);
          if (g == erster) {
            output += zweiter;
          }
          if (g == dritter) {
            output += vierter;
          }
          if (g != erster && g != dritter) {
            output += g;
          }
          l++;
        }
        writeConsole("\n" + output);
        korrekt = true;
      }
    }

    ////////////////////////// Teilaufgabe 3 ///////////////////////////////////////////


    int b;
    int d;
    int c = 0;
    String verdreht = "";
    for (b = 0; b < input.length(); b++) {
      char h = input.charAt(b);
      c = c + 1;
      d = b;
      if (h == 32) {
        while (d > b - c + 1) {
          char buchstabe = input.charAt(d - 1);
          verdreht += buchstabe;
          d--;

        }
        c = 0;
        verdreht += h;
      }
      if (b == input.length() - 1) { // letzter Buchstabe
        while (d > b - c) {
          char buchstabe = input.charAt(d);
          verdreht += buchstabe;
          d--;
        }
        c = 0;
      }
    }
    writeConsole("\n" + verdreht);
  }
}


