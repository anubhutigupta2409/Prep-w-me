/*
Pick from both sides!
Very Easy

94

30

Add to favorites
Asked In:
MEDIA.NET
Problem Description

Given an integer array A of size N.

You can pick B elements from either left or right end of the array A to get maximum sum.

Find and return this maximum possible sum.

NOTE: Suppose B = 4 and array A contains 10 elements then

You can pick first four elements or can pick last four elements or can pick 1 from front and 3 from back etc . you need to return the maximum possible sum of elements you can pick.


Problem Constraints
1 <= N <= 105

1 <= B <= N

-103 <= A[i] <= 103



Input Format
First argument is an integer array A.

Second argument is an integer B.



Output Format
Return an integer denoting the maximum possible sum of elements you picked.



Example Input
Input 1:

 A = [5, -2, 3 , 1, 2]
 B = 3
Input 2:

 A = [1, 2]
 B = 1


Example Output
Output 1:

 8
Output 2:

 2


Example Explanation
Explanation 1:

 Pick element 5 from front and element (1, 2) from back so we get 5 + 1 + 2 = 8
Explanation 2:

 Pick element 2 from end as this is the maximum we can get
*/

public class PickFromBothSides {
    public int solve(ArrayList<Integer> A, int B) {

        int n = A.size();
        int res = 0;

        //for the first i elements
        //[5,-2,3,1,2]
        // 0  1 2 3 4
        //      ^
        //res = 5 + -2 + 3 = 6
        for(int i=0;i<B;i++)
        {
            res+=A.get(i);
        }

        int sum = res;//sum = 6
        /*

        [5,-2,3,1,2]
         0  1 2 3 4
              ^   ^     sum = 6 - 3 + 2 = 5     res = max(6,5) = 6
            ^   ^       sum = 5 - -2 + 1 = 8    res = max(6,8) = 8
         ^    ^         sum = 8 - 5 + 3 = 6     res = max(8,6) = 6

        */
        for(int i=0;i<B;i++)
        {
            sum -= A.get(B-1-i);
            sum += A.get(n-1-i);

            res = Math.max(sum,res);
        }

        return res;
    }
}
