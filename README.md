# Random-Number-Generators

### Overview

This application creates a GUI where users can submit parameters to create pseudo random numbers. Two random number generators (RNGs) are available: linear congruential generator (LCG), which generates integers, and Java's built-in RNG, which generates decimal numbers between 0 and 1. 

Using these two RNGs, users can also estimate the area of a quadrant of radius 1 by the Monte Carlo method. Given that at least two pseudo random numbers are generated, each pair of consecutive numbers are plotted on a unit square. The area of a quadrant is estimated by the ratio of the number of the points inside the quadrant to the total number of points. The plot of these pairs of random numbers can be displayed to users. 

### Background

The formula used by an LCG to generate pseudo random numbers is given by

*N'* = (*a* \* *N* + *c*) mod *m*,

where parameters a, c, and m are chosen by users. The initial value of N, called a seed, must be specified by the users. Note that the numbers generated are bounded above by *m*.

Java's built-in RNG can be accessed by invoking Math.random(). This generates numbers within the range of [0,1]. 