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


class Monster:
    def __init__(self, monsterID, healthCapacity):
        self.monsterID = monsterID
        self.healthCapacity = healthCapacity
        self.health = healthCapacity
        self.pos = Pos()
        self.dropItemList = set() ###
        self.hintList = set()  ###

    def addDropItem(self, key):
        self.dropItemList.add(key)

    def addHint(self, monsterID):
        self.hintList.add(monsterID)

    def getMonsterId(self):
        return self.monsterID

    def getPos(self):
        return self.pos

    def setPos(self, row, column):
        self.pos.setPos(row, column)

    def getHealthCapacity(self):
        return self.healthCapacity

    def getHealth(self):
        return self.health

    def loseHealth(self):
        self.health -= 10
        return self.health <= 0

    def recover(self, healingPower):
        self.health = healingPower

    def actionOnSoldier(self, soldier):
        if self.health <= 0:
            self.talk('You had defeated me.\n')
        else:
            if self.requireKey(soldier.getKeys()):
                self.fight(soldier)
            else:
                self.displayHints()

    def requireKey(self, keys):
        return self.monsterID in keys

    def displayHints(self):
        str1 = '['
        for x in self.hintList:
            str1 += str(x) + ', '

        str1 = str1[:-2]
        str1 += '] '

        self.talk('Defeat Monster ' + str1 + 'first.\n')


    def fight(self, soldier):
        fightEnabled = True

        while fightEnabled:
            print('       | Monster', self.monsterID, ' | Soldier |', sep='')
            print('Health | ', '%8d' % self.health, ' | ', '%7d' % soldier.getHealth(), ' |\n', sep='')

            choice = input('=> What is the next step? (1 = Attack, 2 = Escape, 3 = Use Elixir.) Input: ')

            if choice == '1' :
                if self.loseHealth():
                    print('=> You defeated Monster', self.monsterID, '.\n', sep='')
                    self.dropItems(soldier)
                    fightEnabled = False
                else:
                    if soldier.loseHealth():
                        self.recover(self.healthCapacity)
                        fightEnabled = False
            elif choice == '2':
                self.recover(self.healthCapacity)
                fightEnabled = False
            elif choice == '3':
                if soldier.getNumElixirs() == 0:
                    print('=> You have run out of elixirs.\n')
                else:
                    soldier.useElixir()
            else:
                print('=> Illegal choice!\n')

    def dropItems(self, soldier):
        for item in self.dropItemList:
            soldier.addKey(item)

    def talk(self, text):
        print('Monster', self.monsterID, ': ', text, '\n', end='', sep='')

    def displaySymbol(self):
        print("M", end='')