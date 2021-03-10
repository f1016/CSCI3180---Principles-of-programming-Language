/*
 * CSCI3180 Principles of Programming Languages
 *
 * --- Declaration ---
 *
 * I declare that the assignment here submitted is original except for source
 * material explicitly acknowledged. I also acknowledge that I am aware of
 * University policy and regulations on honesty in academic work, and of the
 * disciplinary guidelines and procedures applicable to breaches of such policy
 * and regulations, as contained in the website
 * http://www.cuhk.edu.hk/policy/academichonesty/
 *
 * Assignment 2
 * Name : Cheung Kam Fung
 * Student ID : 1155110263
 * Email Addr : 1155110263@link.cuhk.edu.hk
 */
import java.util.Scanner;

public class Task4Merchant {
  private int elixirPrice;
  private int shieldPrice;
  private Pos pos;

  public Task4Merchant() {
    // TODO: Initialization.
    this.elixirPrice = 1;
    this.shieldPrice = 2;
    this.pos = new Pos();
  }

  public void actionOnSoldier(Task4Soldier soldier) {
    this.talk("Do you want to buy something? (1. Elixir, 2. Shield, 3. Leave.) Input: ");

    // TODO: Main logic.
    Scanner sc = new Scanner(System.in);

    String choice = sc.nextLine();

    if (choice.equalsIgnoreCase("1")) {   //Action1
      if (soldier.task4GetCoins() >= 1) { // if it has more than 1 coin
        soldier.task4BuyElixirs();
      } else {
        this.talk("You don't have enough coins.%n%n");
      }
    } else if (choice.equalsIgnoreCase("2")) { // if it has more than 2 coins
      if (soldier.task4GetCoins() >= 2) {
        soldier.task4BuyDefence();
      }else {
        this.talk("You don't have enough coins.%n%n");
      }
    } else if (choice.equalsIgnoreCase("3")) {
    } else {
      System.out.printf("=> Illegal choice!%n%n");// illegal choice
    }

    // If the soldier doesn't have enough coins to buy what (s)he wants, the merchant will say "You don't have enough coins.%n%n".
    // Then, the soldier will automatically leave.

    // After the soldier successfully buys an item from the merchant, (s)he will also automatically leave.
  }

  public void talk(String text) {
    System.out.printf("Merchant$: " + text);
  }

  // TODO: Other functions.

  public void setPos(int row, int column) {
    this.pos.setPos(row, column);
  }

  public void displaySymbol() {
    System.out.printf("$");
  }

  public Pos getPos() {
    return this.pos;
  }


}