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
public class Cell {
  private Object occupiedObject;

  public Cell() {
    this.occupiedObject = null;
  }

  public Object getOccupiedObject() {
    return occupiedObject;
  }

  public void setOccupiedObject(Object occupiedObject) {
    this.occupiedObject = occupiedObject;
  }
}