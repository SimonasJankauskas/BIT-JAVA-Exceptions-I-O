package lt.simonasjankauskas.app;

import java.io.*;
import java.util.Scanner;


public class IoAndExceptions {
    public static void main(String[] args) throws IOException {


        // NAMU DARBAI
        System.out.println("----- Namų darbai -----");
        // Kokiame path'e veikia Java
        System.out.println("Working Directory = " + System.getProperty("user.dir"));

        // Skaidrių pavyzdžiai
        System.out.println("1. Namų darbų dalis");

        // READ
        System.out.println("-----READ-----");
        // ... sukuriu failo objektą, kuris laiko info kur failas randasi
        // File relativeFile = new File("data/singleLine.txt");
        File relativeFile = new File("./data/singleLine.txt");
        try {
            // standartinis būdas gauti duomenis iš teksitinio failo javoje
            FileReader fileReader = new FileReader(relativeFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            // skaitome eilutė po eilutės su .readLine() metodu
            String fileLine = bufferedReader.readLine(); // "\n", "\r\n" - ieško newline
            System.out.println(fileLine);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // WRITE
        // System.out.println("-----Write-----");
        File relativeFile2 = new File("./data/writeToFiles.csv");
        FileWriter fw = null;
        try {
            fw = new FileWriter(relativeFile2);
            BufferedWriter bw = new BufferedWriter(fw);
            String fileLine = "Mindaugas";
            bw.write(fileLine);
            // for (int k = 0; k < 20000; k++) {
            //     bw.write("A");
            // }

            // writting file with newline
            String fileLine2 = "Mindaugas\n";
            bw.write(fileLine2);
            bw.write("Jonas");
            bw.newLine();
            bw.write("Antanas");
            bw.write("\n");
            bw.write("Petras"); // neprideda new line
            // bw.flush();
            bw.close(); // close automatically flushes the buffer
        } catch (IOException e) {
            e.printStackTrace();
        }

        // APPEND
        // System.out.println("-----APPEND-----");
        try {
            fw = new FileWriter(relativeFile2, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fw);
            String fileLine = "\nPridėjome naują eilutę!";
            bufferedWriter.write(fileLine);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // TREČIA NAMŲ DARBŲ DALIS
        System.out.println("3. Namų darbų dalis");

        try {
            int a = 20;
            int b = 0;
            int result = a / b;
            System.out.println(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        // KETVIRTA NAMŲ DARBŲ DALIS
        System.out.println("4. Namų darbų dalis");

        try {
            FileWriter mw = new FileWriter("./data/newFile.txt");
            mw.write("Vardas: Romas, Amžius: 55m, Tel.nr: +37061198752\n");
            mw.write("Vardas: Darius, Amžius: 16m, Tel.nr: +37069933241\n");
            mw.write("Vardas: Virginijus, Amžius: 28m, Tel.nr: +37063155441\n");
            mw.write("Vardas: Stasys, Amžius: 45m, Tel.nr: +37065539751\n");

            mw.close();
            System.out.println("Failas buvo įrašyti!");
        } catch (Exception e) {
            System.out.println("Įvyko klaida!");
            e.printStackTrace();
        }
        // SPAUSDINIMAS Į KONSOLĘ
        try {
            BufferedReader reader = new BufferedReader((new FileReader("./data/newFile.txt")));
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // PENKTA NAMŲ DARBŲ DALIS
        System.out.println("5. Namų darbų dalis");
        String file = "./data/newFileTwo.txt";
        System.out.println("Įrašykite norimą tekstą, o norėdami įrašyti tekstą į pasirinktą failą parašykite DONE");

        Scanner scan = new Scanner(System.in);

        FileWriter write = new FileWriter(file);
        while(true){
            String input = scan.nextLine();
            if("DONE".equalsIgnoreCase(input.trim())){
                break;
            }
            write.write(input);
        }
        scan.close();
        write.close();

    }

}
