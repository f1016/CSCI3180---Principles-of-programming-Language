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

class Spring:
    def __init__(self):
        self.numChance = 1
        self.healingPower = 100
        self.pos = Pos()

    def setPos(self, row, column):
        self.pos.setPos(row, column)

    def getPos(self):
        return self.pos

    def actionOnSoldier(self, soldier):
        self.talk()
        if self.numChance == 1:
            soldier.recover(self.healingPower)
            self.numChance -= 1

    def talk(self):
        print('Spring@: You have', self.numChance, 'chance to recover 100 health.\n')

    def displaySymbol(self):
        print('@', end = '')
