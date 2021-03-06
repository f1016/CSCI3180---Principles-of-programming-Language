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
class Pos:
    def __init__(self):
        self.column = None
        self.row = None

    def Pos(self, row, column):
        self.column = column
        self.row = row

    def setPos(self, row, column):
        self.row = row
        self.column = column

    def getRow(self):
        return self.row

    def getColumn(self):
        return self.column
