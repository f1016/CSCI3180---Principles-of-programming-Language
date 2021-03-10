from Monster import Monster


class Task4Monster(Monster):
    def __init__(self, monsterID, healthCapacity):
        super().__init__(monsterID, healthCapacity)

    def actionOnSoldier(self, soldier):
        if self.health <= 0:
            self.talk('You had defeated me.\n')
        else:
            if self.requireKey(soldier.getKeys()):
                self.fight(soldier)
                if super().getHealth() <= 0 :
                    soldier.task4AddCoins() # add coin to soldier
            else:
                self.displayHints()