// Ryan Graue
// 11/20/2018
// CSE 142
// TA: Ivy Yu
// assignment #7
//
// This program reads in a user entered file and processes through DNA code
// and determines some characteristsic such as mass percentage of 
// each nucleotide, the number of each nucleotide, list of codons, and 
// whether or not it is a protien. The summary of all the results are then 
// printed to a user entered file.

import java.io.*;
import java.util.*;

public class DNA {
   // @class consatnt CODONS_PER_PROTIEN     amount of codons required to count as a valid protien
   // @class constant MIN_PERCENTAGE         minimum percentage that the c and g nucleotides
   //                                        must be greater then for it to count as a protien
   // @class constant NUM_NUCLEOTIDES        The number of unique nucleotide there are
   // @class constant NUC_PER_CODON          number of nucleotides per codon   
   public static final int CODONS_PER_PROTIEN = 5;
   public static final int MIN_PERCENTAGE = 30;
   public static final int NUM_NUCLEOTIDES = 4;
   public static final int NUC_PER_CODON = 3;
   public static void main (String[] args) throws FileNotFoundException {
      Scanner console = new Scanner (System.in);
      String title = "";
      String data ="";
      int[] nCounts = new int[NUM_NUCLEOTIDES];
      double[] mass = new double[NUM_NUCLEOTIDES + 1];
      String proteinStatus = "";
      
      intro();
      Scanner input = inputCreator(console);
      PrintStream output = outputCreator(console);
      
      while (input.hasNextLine()){
         title = input.nextLine();
         data = input.nextLine().toUpperCase();
         nCounts = counts(data, nCounts);
         mass = massCalc(data, mass);
         String[] codons = codonCalc(data);
         proteinStatus = isProtein(mass, codons);
         results(title, data, nCounts, mass, codons, proteinStatus, output);
      }
      
   }
   
   // Prints the intro to the program
   public static void intro () {
      System.out.println("This program reports information about DNA");
      System.out.println("nucleotide sequences that may encode proteins.");
   }
   
   // creates a new scanner for the user input file and then returns that scanner
   //
   // @param console    Scanner object for user input
   public static Scanner inputCreator (Scanner console) throws FileNotFoundException {
      System.out.print("Input file name? ");
      File inputFile = new File(console.next());
      Scanner input = new Scanner(inputFile);
      return input;  
   }
   
   // creates a PrintStream object for the user input file 
   // and then returns that PrintStream object
   //
   // @param console    Scanner object allowing for user input
   public static PrintStream outputCreator (Scanner console) throws FileNotFoundException {
      System.out.print("Output file name? ");
      File outputFile = new File(console.next());
      PrintStream output = new PrintStream(outputFile);
      return output;
   }
   
   // adds up how many times each nucleotide occurs and returns and array
   // with the number counts of each nucleotide
   //
   // @param data       list of nucleotides in region
   // @param nCounts    array used to keep track of the counts for each nucleotide
   public static int[] counts (String data, int[] nCounts) {
      Arrays.fill(nCounts,0);
      char[] nucleotides = {'A','C','G','T'};
      for (int i =0; i < data.length(); i++) {
         for (int j = 0; j < nucleotides.length; j++) {
            if (data.charAt(i) == nucleotides[j]) {
               nCounts[j]++;
            }
         }
      }
      return nCounts;
   }
   
   // calculates the mass percentage of each nucleotide within the region and returns
   // that data within a single array
   //
   // @param data       list of nucleotides within the region
   // @param mass       array for the total mass and mass percentage of each nucleotide
   public static double[] massCalc (String data, double[] mass) {
      Arrays.fill(mass,0);
      String list = "ACGT-";
      double[] masses = {135.128,111.103,151.128,125.107,100.000};
      for (int i = 0; i < data.length(); i++) {
         int index = list.indexOf(data.charAt(i));
         if(index != NUM_NUCLEOTIDES) {
            mass[index] += masses[index];
            mass[NUM_NUCLEOTIDES] += masses[index];
         } else {
            mass[NUM_NUCLEOTIDES] += masses[index];
         }
      }
      for (int i = 0; i < mass.length-1; i++) {
         mass[i] = Math.round((mass[i]/mass[NUM_NUCLEOTIDES] * 100) * 10.0) / 10.0;
      }
      mass[NUM_NUCLEOTIDES] = Math.round(mass[NUM_NUCLEOTIDES] *10.0) / 10.0;
      return mass;
   }
   
   // breaks the list of nucleotides into their respective codons and returns
   // an array containing all the codons
   //
   // @param data       list of nucletides within the given region
   public static String[] codonCalc (String data) {
      String filteredData = "";
      for (int i = 0; i < data.length(); i++) {
         if (data.charAt(i) != '-') {
            filteredData += data.charAt(i);
         }
      }
      int arrayLength = filteredData.length() / NUC_PER_CODON;
      String[] codons = new String[arrayLength];
      for(int i = 0; i < codons.length; i ++) {
         codons[i] = filteredData.substring(i * NUC_PER_CODON, i * NUC_PER_CODON + NUC_PER_CODON);
      }
      return codons;
   }
   
   // determines whether the reggion is a protien or not and returns a string
   // for the determination of the protien status
   //
   // @param mass    array for total mass and individual nucleotide mass percentages
   // @param codons  array for each individual codons
   public static String isProtein (double[] mass, String[] codons){
      if (!codons[0].equals("ATG")) {
         return "NO";
      }
      if (!codons[codons.length-1].equals("TAA") &&
          !codons[codons.length-1].equals("TAG") &&
          !codons[codons.length-1].equals("TGA")) {
         return "NO";
      }
      if (codons.length < CODONS_PER_PROTIEN) {
         return "NO";
      }
      if (mass[1] + mass[2] < MIN_PERCENTAGE) {
         return "NO";
      }
      return "YES";
   }
   
   // prints the formatted results into the given output file
   //
   // @param title         the title of the dna region
   // @param data          list of the nucleoties in the given region
   // @param nCounts       array for the counts of each indiviual nucleotide occurance
   // @param mass          array for total mass and individual nucleotide mass percentages
   // @param codons        array for each individual codons
   // @param proteinStatus The status of the region being a protein or not
   // @param output        PrintStream object for printing to the output file 
   public static void results (String title, String data, int[] nCounts, double[] mass,
                               String[] codons, String proteinStatus, PrintStream output) { 
      output.println("Region Name: " + title);
      output.println("Nucleotides: " + data);
      output.println("Nuc. Counts: " + Arrays.toString(nCounts));
      output.print("Total Mass%: ");
      output.print("[" + mass[0]);
      for(int i = 1; i < mass.length-1; i++) {
         output.print(", " + mass[i]);
      }
      output.println("] of " + mass[mass.length-1]);
      output.println("Codons List: " + Arrays.toString(codons));
      output.println("Is Protein?: " + proteinStatus);
      output.println();
      
   }
}