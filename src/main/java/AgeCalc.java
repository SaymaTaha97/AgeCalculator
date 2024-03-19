import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;
import java.io.PrintWriter;

public class AgeCalc {
  public static void main(String[] args) throws IOException {

    File inputFile = new File("input.csv");
    Scanner sc = new Scanner(inputFile);

    PrintWriter outputfile = new PrintWriter("output.txt");

    sc.useDelimiter(",|\n");

    while (sc.hasNext()) {
      String name = sc.next();
      System.out.println(name);
      int month =  Integer.parseInt(sc.next().trim());// trimming to remove leading/trailing whitespaces
      System.out.println(month);
      int year = Integer.parseInt(sc.next().trim());
      sc.nextLine(); // Consume newline character

      Calendar calendar = Calendar.getInstance();

      int CurrM = calendar.get(Calendar.MONTH);
      int CurrY = calendar.get(Calendar.YEAR);

      int age = CurrY - year;
      if (CurrM < month) {
        age = age - 1;
      }
      outputfile.println(name + " is " + age + " years old.");
    }
    sc.close();
    outputfile.close();
  }
}