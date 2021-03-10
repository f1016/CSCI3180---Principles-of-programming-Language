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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Task4Monster extends Monster{
  public Task4Monster(int monsterID, int healthCapacity) {
    super(monsterID, healthCapacity);
  }

  public void actionOnSoldier(Task4Soldier soldier) { // modify for add Coins part
    if (super.getHealth() <= 0) {
      super.talk("You had defeated me.%n%n");
    } else {
      if (this.requireKey(soldier.getKeys())) {
        this.fight(soldier);
        if (super.getHealth() <= 0) { soldier.task4AddCoins(); }
      } else {
        super.displayHints();
      }
    }
  }


}