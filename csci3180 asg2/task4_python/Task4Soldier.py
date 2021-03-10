"""
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
 """
from Soldier import Soldier


class Task4Solider(Soldier):
    def __init__(self):
        self.coins = 0
        self.defence = 0
        super().__init__()

    def task4AddCoins(self):
        self.coins += 1

    def task4BuyElixirs(self):
        super().addElixir()
        self.coins -= 1

    def loseHealth(self):
        if self.defence >= 10:
            self.health -= 0 # minimum loseheal is 0
        else:
            self.health -= (10 - self.defence) #minus defence

        return self.health <= 0

    def task4BuyDefence(self):
        self.defence += 5
        self.coins -= 2

    def task4GetCoins(self):
        return self.coins

    def displayInformation(self):
        super().displayInformation()
        print("Defence: ", self.defence, ".", sep='')
        print("Coins: ", self.coins, ".", sep='')
