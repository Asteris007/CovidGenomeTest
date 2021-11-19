import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;
import java.util.Scanner;

public class Main {



    static Object readDNA() {
        try {
            File dna = new File("genome.txt");
            Scanner reader = new Scanner(dna);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                System.out.println(data);

            }
            reader.close();
        } catch (FileNotFoundException f) {
            System.out.println("Error file!");
            f.printStackTrace();
        }

        return null;
    }

    static void collateDNA() throws IOException {
        try {
            File genome = new File("genome.txt");
            Scanner fr = new Scanner(genome);
            Random rand = new Random();

            int tests = 100000;
            int s = 0;
            int f = 0;
            String data= Files.readString(Path.of("genome.txt"));

            while (fr.hasNextLine()) {
                    for (int i = 0; i <= tests; i++) {
           //String data= Files.readString(Path.of("genome.txt"));
                   //String data1 = new FileNotFoundException("genome.txt");
               data= data.replace('T','G');
               if (genome.equals(readDNA())) {
                        s++;
                       // System.out.println("\nIdentical template: " + s);

                    } else {
                        f++;
                        //System.out.println("\n"+genome.compareTo((File) readDNA()));
                        //System.out.println("\n Exist mutation " + f);
                    }

                }
                System.out.println("\nIdentical template: " + s);
                System.out.println("\n Exist mutation " + f);
            }
            fr.close();
        } catch (FileNotFoundException el) {
            System.out.println("Error file!");
            el.printStackTrace();
        }

    }

    public static void main(String[] args) throws IOException {
        readDNA();
        collateDNA();

    }
}
