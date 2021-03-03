# Assignment02_COT3400

## Optimal Binary Search Tree

### NumberGenerator
#### n random keys are specified and then generated, along with n+1 dummy keys. An inclusive range of 1-1000 random integer values are created using the java.util.Random class.

### Sort
#### Once random keys and dummy keys are generated, a mergeSort() routine is called to store all integers in ascending order and then written to text files within NumberGenerator.

### ProbabilityCalculator
#### These files are then parsed within Main's subroutine, parseFile(), and random probabilities for successful key search (p) and unsuccessful key search (q) are 
calculated and stored within respective arrays to be referenced while finding the optimal BST.

### OptimalBST
#### Both p and q arrays are then passed through OptimalBST's constructor and the tables for expected cost (e), weights (w), and roots (root) are initialized. 
The findOptimalBST() calculates the values of these tables bottom up and then determines the optimal binary search tree to be constructed.

### Node
#### The optimal BST would be constructed and the key values would be inserted as nodes containing information regarding each Node's left and right children as well
as the key value. Due to a logical error in the findOptimalBST() routine (open GitHub issue), this class is not currently utilized as it should be within the 
constructOptimalBST() routine within OptimalBST.java. 

