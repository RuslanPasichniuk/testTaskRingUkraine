
#Task:

1. Create tests for the Dice Roller site to check the following hypothesis:

"For large number of rolls (number of rolls > 1000) distribution of dice points strives to uniform distribution."

Requirements: tests should check that maximum deviation of dice results is within 5%

First test: check hypothesis for 1 dice

Second test: check hypothesis for 2 dices (total roll points is a sum of 2 dices)

2. Provide your conclusions on test results in readme.md file (explain how you understand results).

3. As a plus: draw chart to visualize dice results deviation in each test.

 

#Hints:

- try 1000, 5000, 10000 number of rolls and see how distribution changes

- think about how to implement the solution in the most efficient way

- verify your results

 

We are kindly asking you to:

- implement solution in Java
 

#To run Dice Roller server on your PC:

- please ensure Docker is installed on your PC

- execute in terminal/command line "docker run --rm -p8888:8080 mosk766/diceroller". Site will be available by url "http://localhost:8888".


# junit5-gradle

Probability Distribution of one Die is 1/6 = 16.7%

Probability Distribution -[Sum of Two Dice]  are: 
- 2,	1+1_________________________________    1/36 = 2.8%
- 3,	1+2, 2+1____________________________	2/36 = 5.6%
- 4,	1+3, 2+2, 3+1_______________________    3/36 = 8.3%
- 5,	1+4, 2+3, 3+2, 4+1__________________    4/36 = 11.2%
- 6,	1+5, 2+4, 3+3, 4+2, 5+1_____________    5/36 = 13.9%
- 7,	1+6, 2+5, 3+4, 4+3, 5+2, 6+1________    6/36 = 16.6%
- 8,	2+6, 3+5, 4+4, 5+3, 6+2_____________    5/36 = 13.9%
- 9,	3+6, 4+5, 5+4, 6+3__________________    4/36 = 11.2%
- 10,	4+6, 5+5, 6+4_______________________    3/36 = 8.3%
- 11,	5+6, 6+5____________________________    2/36 = 5.6%
- 12,	6+6_________________________________    1/36 = 2.8%


[Sum of Two Dice]: http://www.math.hawaii.edu/~ramsey/Probability/TwoDice.html
