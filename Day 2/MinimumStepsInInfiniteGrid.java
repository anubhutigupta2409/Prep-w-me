/*
Min Steps in Infinite Grid

Problem Description

You are in an infinite 2D grid where you can move in any of the 8 directions

 (x,y) to
    (x-1, y-1),
    (x-1, y)  ,
    (x-1, y+1),
    (x  , y-1),
    (x  , y+1),
    (x+1, y-1),
    (x+1, y)  ,
    (x+1, y+1)
You are given a sequence of points and the order in which you need to cover the points.. Give the minimum number of steps in
which you can achieve it. You start from the first point.




Input Format
Given two integer arrays A and B, where A[i] is x coordinate and B[i] is y coordinate of ith point respectively.



Output Format
Return an Integer, i.e minimum number of steps.



Example Input
Input 1:

 A = [0, 1, 1]
 B = [0, 1, 2]


Example Output
Output 1:

 2


Example Explanation
Explanation 1:

 Given three points are: (0, 0), (1, 1) and (1, 2).
 It takes 1 step to move from (0, 0) to (1, 1). It takes one more step to move from (1, 1) to (1, 2).


Note:You only need to implement the given function. Do not read input, instead use the arguments to the function. Do not print the output, instead return values as specified. Still have a doubt? Checkout Sample Codes for more details.


*/

/*

Since all the given points are to be covered in the specified order. Find the minimum number of steps required to reach from a
starting point to next point, then the sum of all such minimum steps for covering all the points would be the answer. One way to
reach from a point (x1, y1) to (x2, y2) is to move abs(x2-x1) steps in the horizontal direction and abs(y2-y1) steps in the
vertical direction, but this is not the shortest path to reach (x2, y2). The best way would be to cover the maximum possible
distance in a diagonal direction and remaining in horizontal or vertical direction.
If we look closely this just reduces to the maximum of abs(x2-x1) and abs(y2-y1). Traverse for all points and summation of all
diagonal distance will be the answer.




public class MinimumStepsInInfiniteGrid{

    private int shortestDistance(int x1, int x2, int y1, int y2)
    {
        int dx = Math.abs(x1-x2);
        int dy = Math.abs(y1-y2);

        return Math.max(dx,dy);
    }

    public int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {

        int res = 0;

        for(int i=0;i<A.size()-1;i++)
            res+= shortestDistance(A.get(i),A.get(i+1), B.get(i),B.get(i+1));

        return res;
    }
}
*/


public class Solution {

    public int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {

        int res = 0;

        for(int i=0;i<A.size()-1;i++)
            res+= Math.max(Math.abs(A.get(i)-A.get(i+1)),Math.abs( B.get(i)-B.get(i+1)));

        return res;
    }
}