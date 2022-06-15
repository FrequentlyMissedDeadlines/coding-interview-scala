# Robbery optimisation

From: [https://www.codingame.com/ide/puzzle/robbery-optimisation](https://www.codingame.com/ide/puzzle/robbery-optimisation)

Rob is a robber. He wants to operate a last time in the neighborhood before he leaves.
He has been informed about the values of the content of each house of a street but he is careful and when he robs in a house he avoids the 2 houses aside (left and right).
What is the maximum money he can make without being caught?
! Be warned ! Some houses have been trapped. They have been rated with negative values.

For example, for a street of 3 houses with values: (A: 1) - (B: 2) - (C: 3), Rob shall visit houses A and C (he takes 4).
In this other street: (A: 1) - (B: 15) - (C: 10) - (D: 13) - (E: 16), Rob should avoid C and D and visit only B and E (he takes 31).

```
#Input
Line 1: An integer N for the number of houses in the street.
Next N lines: The value housevalue of the nth house content.


#Output
Line 1: A single integer being the maximum amount Rob can make in the street.


#Constraints
1 ≤ N ≤ 100
housevalue < 10^13
```