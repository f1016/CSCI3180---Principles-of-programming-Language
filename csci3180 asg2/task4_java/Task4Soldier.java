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

import java.util.HashSet;

public class Task4Soldier extends Soldier{
  private int coins;
  private int defence;

  public Task4Soldier() {
    super();
    this.coins = 0;
    this.defence = 0;
    /* It is possible for the soldier to obtain two identical keys in the game.
       To simplify the operation, we use set here to remove duplicate keys. */
  }

  public void task4AddCoins() { this.coins += 1; } // add Coins

  public void task4BuyElixirs() { // buy Exlixirs from merchant
    super.addElixir();
    this.coins -= 1;
  }

  public boolean loseHealth() {
    this.health -= (10 - this.defence) >= 0 ? 10 - this.defence : 0 ; // value > 0
    return this.health <= 0;
  }

  public void task4BuyDefence() { // but defence from merchant
    this.defence += 5;
    this.coins -= 2;
  }

  public int task4GetCoins() { return this.coins; } // return coins

  public void displayInformation() {
    super.displayInformation();
    System.out.printf("Defence: %d.%n", this.defence);
    System.out.printf("Coins: %d.%n", this.coins);
  }


}