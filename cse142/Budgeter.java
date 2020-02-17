// Ryan Graue
// 10/23/18
// CSE 142
// TA: Ivy Yu
// assignment #4
//
// This program determines whether you spend or save more money monthly
// depending on your incomes and expenses
//
// @constant MONTH_DAYS    determines the amount of days that are considered in a month

import java.util.Scanner;

public class Budgeter {
   public static final int MONTH_DAYS = 31;
   
   public static void main (String[] args) {
      Scanner sc = new Scanner(System.in);
      intro();
      double income = incomeCalc(sc);
      double expenses = expensesCalc(sc);
      budget(income, expenses);
   }
   
   // prints out the introduction to the program
   public static void intro () {
      System.out.println("This program asks for your monthly income and");
      System.out.println("expenses, then tells you your net monthly income.");
      System.out.println();
   }
   
   // determines how much money you make a month
   //
   // @param sc      Scanner object allowing user input
   public static double incomeCalc (Scanner sc) {
      double total = addup(sc, "income");
      return total;
   }
   
   // determines the amount of expenses in the month
   //
   // @param sc      Scanner oject to allow user input
   public static double expensesCalc (Scanner sc) {
      double total = 0;
      System.out.print("Enter 1) monthly or 2) daily expenses? ");
      int expenseType = sc.nextInt();
      if (expenseType == 1) {
         total = addup(sc , "expense");
      } else if (expenseType == 2) {
         total = addup(sc , "expense") * MONTH_DAYS;
      }
      return total;
   }
   
   // adds up the numbers entered
   //
   // @param sc      Scanner ibject allowing for user input
   // @param type    Explains whether the amount being entered is an income or expense
   private static double addup (Scanner sc, String type) {
      double total = 0;
      System.out.print("How many categories of " + type + "? ");
      int catagoryNum = sc.nextInt();
      for (int inputs = 0; inputs < catagoryNum; inputs++) {
         System.out.print("    Next "+ type +" amount? $");
         total += sc.nextDouble();
      }
      System.out.println();
      return total;
   }
   
   // prints the total income and expenses and their daily rate
   // as well as determiens whether the user made or lost money
   //
   // @param income     the total income entered by user
   // @param expenses   the total expenses entered by the user
   public static void budget (double income, double expenses) {
      System.out.printf("Total income = $%.2f ($%.2f/day)\n", income , income/MONTH_DAYS);
      System.out.printf("Total expenses = $%.2f ($%.2f/day)\n", expenses, expenses/MONTH_DAYS);
      System.out.println();
      double difference = income - expenses;
      if(difference > 0) {
         madeMoney(difference);
      } else {
         lossMoney(difference);
      }
   }
   
   // determines whether user is a saver or a big saver
   //
   // @param difference    the difference between income and expenses
   public static void madeMoney (double difference) {
      System.out.printf("You earned $%.2f more than you spent this month.\n", difference);
      if (difference > 250) {
         System.out.println("You're a big saver.");
         System.out.println("Teach me your ways.");
      }else{
         System.out.println("You're a saver.");
         System.out.println("*high five*");
      }
   }
   
   // determines whether the user is a spender or a big spender
   //
   // @param difference    the difference between income and expenses
   public static void lossMoney (double difference) {
      System.out.printf("You spent $%.2f more than you earned this month.\n" , difference * -1);
      if(difference < -250){
         System.out.println("You're a big spender.");
         System.out.println("Wow you suck at this.");
      } else {
         System.out.println("You're a spender.");
         System.out.println("Maybe one day you'll get it");
      }
   }
}