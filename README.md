# online-problem-solving
This repository contains solutions to problems solved on GeeksForGeeks and Leetcode.

# Tips and Tricks useful in problem solving

# Bit Manipulation

(Notes from [Gaurav Sen's YouTube video](https://www.youtube.com/watch?v=JqxgC5zcdEw))

Consider that you have a 5x4 matrix of integers representing a game. Player 1 is represented by 1, player 2 is represented by 2 and 0 represents no player has occupied the position. Now, when this board is created, the matrix occupies a large portion of memory as each integer is 32 bit.

So the total size occupied by the matrix is 32*5*4.

If we observe the numbers,
* 0 can be represented by 0
* 1 can be represented by 1
* and 2 can be represented by 10

When we store them directly as 32 bit integers, every number has a large number of wasteful bits. Hence, the memory consumption can be optimized using bit representation.
Bit manipulation helps is speeding up programs to a great extent.

## TODO

* [ ] Bitwise Operators in Java
* [ ] Left shift, right shift operators
* [ ] [Useful Tricks by Gaurav Sen](https://www.quora.com/What-are-some-tricks-in-competitive-programming-especially-bit-wise-operations-that-everyone-should-know/answer/Gaurav-Sen-6?share=850b7996&srid=2k4y)
* [ ] [Bitwise Hacks for CP](https://www.geeksforgeeks.org/bitwise-hacks-for-competitive-programming/)

## Representing a 2D matrix as an array

Consider the following 2D matrix:

    [
     [7, 3]
     [4, 6]
    ]

In order to represent this matrix in an array, we need to map each element to its array indices. This can be done using the formula:

    position in 1D array = row * LEN_ROW + col

Consider the cell, (0,0)
new_index = 0 * 2 + 0 = 0

Similarly,
* (0, 1) -> 0*2+1 -> 1
* (1, 0) -> 1*2+0 -> 2
* (1, 1) -> 1*2+1 -> 3

1D array representing the above matrix is:

    [7, 3, 4, 6]

Now, this array occupies 32*4 space. These numbers can be represented in bits as follows:

    000...111, 000...11, 000...100, 0000...110

As we can see, each of these numbers has many wasteful bits. These extra 0 bits can be excluded. However, we need to find the minimum number of bits that can contain each number comfortably. For example, consider the number 7. This can be done by examining if:

        2^n - 1 >= 7

We have to find n here. For example, 2 bits can represent the integers 0, 1, 2 and 3, i.e. 4 numbers (2^n).