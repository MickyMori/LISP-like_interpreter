LISP-like_interpreter
=====================

Autor: Michele Moriconi
-----------------------

This is an assignment for the course "Analisi e Progettazione di Algoritmi" held at the University of Genoa. The goal of the assignemt is to code a LISP-like interpreter. 

The program has to:
* Read a file which contains the program that has to be interpreted.
* Execute the program contained in the file.
* Request inputs if needed.

Input format
------------

* program → stmt block

* stmt block → statement | ( BLOCK statement list )
* statement list → statement statement list | statement

* statement → variable def | io stmt | cond stmt | loop stmt
* variable def → ( SET variable id num expr )

* io stmt → ( PRINT num expr ) | ( INPUT variable id )

* cond stmt → ( IF bool expr stmt block stmt block )

* loop stmt → ( WHILE bool expr stmt block )

* num expr → ( ADD num expr num expr ) | ( SUB num expr num expr ) | ( MUL num expr num expr ) | ( DIV num expr num expr ) | number | variable id bool expr | (LT num expr num expr) | (GT num expr num expr) | (EQ num expr num expr) | (AND bool expr bool expr) | (OR bool expr bool expr) | (NOT bool expr) | TRUE | FALSE

* variable id → alpha list

* alpha list → alpha alpha list | alpha

* alpha → a | b | c | . . . | z | A | B | C | . . . | Z

* number → - posnumber | posnumber

* posnumber → 0 | sigdigit rest

* sigdigit → 1 | . . . | 9

* rest → digit rest | \(\epsilon\)

* digit → 0 | sigdigit

SET, PRINT, INPUT, IF, WHILE are the keywords for the statements instructions. 
 
ADD, SUB, MUL, DIV are the keywords for the arithmeticals operators.
 
LT, GT, EQ are the keywords for the relational intructions.
  
AND, OR, NOT are the keywors for the boolean operators.
  
TRUE and FALSE are the boolean constants.

UML
---

![UML](/Images/UML.png "UML")
