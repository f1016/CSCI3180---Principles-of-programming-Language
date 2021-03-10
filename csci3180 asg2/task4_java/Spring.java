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
public class Spring {
  private int numChance;
  private int healingPower;
  private Pos pos;

  public Spring() {
    this.numChance = 1;
    this.healingPower = 100;
    this.pos = new Pos();
  }

  public void setPos(int row, int column) {
    this.pos.setPos(row, column);
  }

  public Pos getPos() {
    return this.pos;
  }

  public void actionOnSoldier(Task4Soldier task4Soldier) {
    this.talk();
    if (this.numChance == 1) {
      task4Soldier.recover(this.healingPower);
      this.numChance -= 1;
    }
  }

  public void talk() {
    System.out.printf("Spring@: You have %d chance to recover 100 health.%n%n", this.numChance);
  }

  public void displaySymbol() {
    System.out.printf("@");
  }
}