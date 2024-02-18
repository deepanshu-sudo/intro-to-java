/**
 * The k-mer refers to all the possible substrings of length k that are contained in a string. In genomics, k-mers refers to all the possible subsequences (of length k) in a given DNA sequence. The number of possible k-mers given n possibilities (n=4 in the case of DNA e.g. ACTG) is n^k. For example: if k=1, there are 4-kmers possible (i.e. A,C,T,G). In case of k=2, 16 k-mers are possible (e.g. AA AT AC AG TA TT TC TG CA CT CC CG GA GT GC GG). Write a program which takes a DNA sequence file and value of k as input from the user, and calculates the occurrences of k-mers, and store it to a CSV file. [For example, ig given DNA sequence S=ATTGCCC, k = 2, then output should be as follows:
    AA - 0
    AT - 1
    AC - 0
    AG - 0
    TA - 0
    TT - 1
    TC - 0
    TG - 1
    CA - 0
    CT - 0
    CC - 2
    CG - 0
    GA - 0
    GT - 0
    GC - 1
    GG - 0
 */

//file imports 
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class KmersCalculator {
    //generate all possible kmers and add them to a hashmap
    //set the default frequency to zero
    public static void generateKmers(String kmer, int length, HashMap<String, Integer> kmers) {
        String[] variables = {"A", "T", "G", "C"}; //set of variables in DNA
        if (length == 0) kmers.put(kmer, 0);
        else {
            for (String variable : variables) {
                String newKmer = kmer + variable;
                generateKmers(newKmer, length - 1, kmers);
            }
        }
    }

    //Helper function for generateKmers
    public static HashMap<String, Integer> buildKmers(int k) {
        HashMap<String, Integer> kmers = new HashMap<>();
        generateKmers("", k, kmers);
        return kmers;
    }

    //Calculates the frequency of each kmer and adds it to the kmer hashmap
    public static void frequencyCalculator(HashMap<String, Integer> kmers, String dnaseq, int k) {
        for (int i = 0; i <= dnaseq.length() - k; i++) {
            String kmer = dnaseq.substring(i, i + k);
            kmers.put(kmer, kmers.get(kmer) + 1);
        }
    }

    //main driver code
    public static void main(String[] args) throws Exception {
        //check the length of arguments
        if (args.length != 2) {
            System.out.println("Usage: java KmersCalculator -path_to_dna_sequence_file -k");
            return;
        }

        //validate the value of K
        int k;
        try {
            k = Integer.valueOf(args[1]);
        } catch (NumberFormatException e) {
            System.out.println("Value of K must be an integer.");
            System.out.println("Usage: java KmersCalculator -path_to_dna_sequence_file -k");
            return;
        }

        //Validate the input path and store the content of file it into a variable
        String dnafilepath = args[0];
        String dnaseq = "";
        try {
            Scanner sc = new Scanner(new File(dnafilepath));
            while (sc.hasNextLine()) {
                dnaseq += sc.nextLine();
            }
        } catch (IOException e) {
            System.out.println("File not Found.");
            System.out.println("Usage: java KmersCalculator -path_to_dna_sequence_file -k");
            return;
        }

        //validate k and dna sequence together
        if(k >= dnaseq.length()) {
            System.out.println("Value of K can't be greater than that of dnaseq.");
            return;
        }
        
        //Create a hashmap and calculate and add frequencies
        HashMap<String, Integer> kmers = buildKmers(k);
        frequencyCalculator(kmers, dnaseq, k);

        //write the hashmap output to a csv file
        try {
            FileWriter csvWriter = new FileWriter("kmer_frequencies.csv");
            for (String kmer : kmers.keySet()) {
                csvWriter.write(kmer + " - " + kmers.get(kmer) + ",\n");
            }
            csvWriter.close();
            System.out.println("K-mer frequencies stored in kmer_frequencies.csv");
        } catch (IOException e) {
            System.out.println("Error writing to CSV file.");
        }
    }
}
