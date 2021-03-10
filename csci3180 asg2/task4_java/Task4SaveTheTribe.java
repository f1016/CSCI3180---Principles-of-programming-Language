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
import java.util.Random;
import java.util.Scanner;

public class Task4SaveTheTribe {
  private Task4Merchant task4Merchant;
  private Task4Map task4Map;
  private Task4Soldier task4Soldier;
  private Spring spring;
  private Task4Monster[] task4Monsters;

  private boolean gameEnabled;
  
  public Task4SaveTheTribe() {
    this.task4Merchant = new Task4Merchant(); // change to subclass
    this.task4Map = new Task4Map();	
    this.task4Soldier = new Task4Soldier(); // change to subclass
    this.spring = new Spring();
    this.task4Monsters = new Task4Monster[7];
    this.gameEnabled = true;
  }

  public void initialize() {
    /* We use the integer 1-7 to represent the keys for corresponding caves, and the integer -1 to represent the artifact. */

    Random random = new Random();

    this.task4Merchant.setPos(7, 7);

    this.task4Map.addObject(this.task4Merchant);

    this.task4Monsters[0] = new Task4Monster(1, random.nextInt(5) * 10 + 30);
    this.task4Monsters[0].setPos(4, 1);
    this.task4Monsters[0].addDropItem(2);
    this.task4Monsters[0].addDropItem(3);
 
    this.task4Monsters[1] = new Task4Monster(2, random.nextInt(5) * 10 + 30);
    this.task4Monsters[1].setPos(3, 3);
    this.task4Monsters[1].addDropItem(3);
    this.task4Monsters[1].addDropItem(6);
    this.task4Monsters[1].addHint(1);
    this.task4Monsters[1].addHint(5);

    this.task4Monsters[2] = new Task4Monster(3, random.nextInt(5) * 10 + 30);
    this.task4Monsters[2].setPos(5, 3);
    this.task4Monsters[2].addDropItem(4);
    this.task4Monsters[2].addHint(1);
    this.task4Monsters[2].addHint(2);

    this.task4Monsters[3] = new Task4Monster(4, random.nextInt(5) * 10 + 30);
    this.task4Monsters[3].setPos(5, 5);
    this.task4Monsters[3].addHint(3);
    this.task4Monsters[3].addHint(6);

    this.task4Monsters[4] = new Task4Monster(5, random.nextInt(5) * 10 + 30);
    this.task4Monsters[4].setPos(1, 4);
    this.task4Monsters[4].addDropItem(2);
    this.task4Monsters[4].addDropItem(6);

    this.task4Monsters[5] = new Task4Monster(6, random.nextInt(5) * 10 + 30);
    this.task4Monsters[5].setPos(3, 5);
    this.task4Monsters[5].addDropItem(4);
    this.task4Monsters[5].addDropItem(7);
    this.task4Monsters[5].addHint(2);
    this.task4Monsters[5].addHint(5);

    this.task4Monsters[6] = new Task4Monster(7, random.nextInt(5) * 10 + 30);
    this.task4Monsters[6].setPos(4, 7);
    this.task4Monsters[6].addDropItem(-1);
    this.task4Monsters[6].addHint(6);

    this.task4Map.addObject(task4Monsters);

    this.task4Soldier.setPos(1, 1);
    this.task4Soldier.addKey(1);
    this.task4Soldier.addKey(5);

    this.task4Map.addObject(this.task4Soldier);

    this.spring.setPos(7, 4);

    this.task4Map.addObject(this.spring);
  }

  public void start() {
    System.out.printf("=> Welcome to the desert!%n");
    System.out.printf("=> Now you have to defeat the monsters and find the artifact to save the tribe.%n%n");

    Scanner sc = new Scanner(System.in);

    while (gameEnabled) {
      this.task4Map.displayMap();
      this.task4Soldier.displayInformation();

      System.out.printf("%n=> What is the next step? (W = Up, S = Down, A = Left, D = Right.) Input: ");
      
      String move = sc.nextLine();

      Pos pos = this.task4Soldier.getPos();
      int newRow, oldRow;
      int newColumn, oldColumn;

      newRow = oldRow = pos.getRow();
      newColumn = oldColumn = pos.getColumn();

      if (move.equalsIgnoreCase("W")) {
        newRow = oldRow - 1;
      } else if (move.equalsIgnoreCase("S")) {
        newRow = oldRow + 1;
      } else if(move.equalsIgnoreCase("A")) {
        newColumn = oldColumn - 1;
      } else if(move.equalsIgnoreCase("D")) {
        newColumn = oldColumn + 1;
      } else {
        System.out.printf("=> Illegal move!%n%n");
        continue;
      }

      if (this.task4Map.checkMove(newRow, newColumn)) {
        Object occupiedObject = this.task4Map.getOccupiedObject(newRow, newColumn);

        if (occupiedObject instanceof Task4Monster) {
          ((Task4Monster)occupiedObject).actionOnSoldier(this.task4Soldier);
        } else if (occupiedObject instanceof Spring) {
          ((Spring) occupiedObject).actionOnSoldier(this.task4Soldier);
        } else if (occupiedObject instanceof  Task4Merchant) {
            ((Task4Merchant)occupiedObject).actionOnSoldier(this.task4Soldier);
        } else {
          this.task4Soldier.move(newRow, newColumn);
          this.task4Map.update(this.task4Soldier, oldRow, oldColumn, newRow, newColumn);
          System.out.printf("%n%n");
        }
      } else {
        System.out.printf("=> Illegal move!%n%n");
      }

      if (this.task4Soldier.getHealth() <= 0) {
        System.out.printf("=> You died.%n");
        System.out.printf("=> Game over.%n%n");
        this.gameEnabled = false;
      }

      /* Check if the soldier has received the artifact. */
      if (this.task4Soldier.getKeys().contains(-1)) {
      	System.out.printf("=> You found the artifact.%n");
        System.out.printf("=> Game over.%n%n");
      	this.gameEnabled = false;
      }
    }
  }

  public static void main(String[] args) {
    Task4SaveTheTribe game = new Task4SaveTheTribe();
    game.initialize();
    game.start();
  }
}