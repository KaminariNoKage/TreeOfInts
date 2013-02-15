TreeOfInts
==========

Creates a tree (aka, pyramid) of integers with the root node of 1.
Each following branch will be the addition of the two leaves above it.

The user is prompted to enter in a number between 1 and 10.

```prompt
>> Enter a value between 1 and 10
```

Based on the entered number, the program will build the respective number of levels.


###Examples:

Minimum value of `1`
```prompt
>> Enter a value between 1 and 10
1
```
Results in:
```prompt
1
```

A value of `4`
```
            1    
         1   1   
   1   2   2   1 
1   3   3   4   4   3   3   1
```

And so on. NOTE: Spacing is of the numbers is...interesting.

