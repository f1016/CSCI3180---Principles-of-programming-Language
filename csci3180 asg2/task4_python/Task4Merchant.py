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
from Pos import Pos

class Task4Merchant():
    def __init__(self):
        self.elixirPrice = 0
        self.shieldPrice = 0
        self.pos = Pos()

    def actionOnSoldier(self, soldier):

        choice = input('Merchant$: Do you want to buy something? (1. Elixir, 2. Shield, 3. Leave.) Input: ') # input choice

        if choice == '1': # if choice = 1
            if soldier.task4GetCoins() >= 1:  # check enough coin
                soldier.task4BuyElixirs()
            else :
                self.talk("You don't have enough coins.\n\n")

        elif choice == '2': 
            if soldier.task4GetCoins() >= 2: # check enough coins
                soldier.task4BuyDefence()
            else:
                self.talk("You don't have enough coins.\n\n")
        elif choice != '3':
            print("=> Illegal choice!\n") # illegal choice

    def talk(self, text):
        print("Merchant$: ", text, sep='', end='')

    def setPos(self, row, column):
        self.pos.setPos(row, column)

    def displaySymbol(self):
        print('$', end='')

    def getPos(self):
        return self.pos