/*
 * Q- Filling Bookcase shelf

You are given an array books where books[i] = [thicknessi, heighti] indicates the thickness and height of the ith book. You are also given an integer shelfWidth.

We want to place these books in order onto bookcase shelves that have a total width shelfWidth.

We choose some of the books to place on this shelf such that the sum of their thickness is less than or equal to shelfWidth, then build another level of the shelf of the bookcase so that the total height of the bookcase has increased by the maximum height of the books we just put down. We repeat this process until there are no more books to place.

Note that at each step of the above process, the order of the books we place is the same order as the given sequence of books.

For example, if we have an ordered list of 5 books, we might place the first and second book onto the first shelf, the third book on the second shelf, and the fourth and fifth book on the last shelf.
Return the minimum possible height that the total bookshelf can be after placing shelves in this manner.

Link - https://leetcode.com/problems/filling-bookcase-shelves/description/
 */

 class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        
        for (int i = 1; i <= n; i++) {
            int width = 0;
            int height = 0;
            dp[i] = Integer.MAX_VALUE;
            
            for (int j = i; j > 0; j--) {
                width += books[j - 1][0];
                if (width > shelfWidth) break;
                height = Math.max(height, books[j - 1][1]);
                dp[i] = Math.min(dp[i], dp[j - 1] + height);
            }
        }
        
        return dp[n];
    }

    public static void main(String args[]){
        Solution obj = new Solution();
        int[][] ex1 = {{1, 1},{2, 3},{2, 3},{1, 1},{1, 1},{1, 1},{1, 2}};
        System.out.println("Example 1  [[1,1],[2,3],[2,3],[1,1],[1,1],[1,1],[1,2]]");
        System.out.println(obj.minHeightShelves(ex1, 4));
        int[][] ex2 = {{1,3},{2,4},{3,2}};
        System.out.println("Example 2 [[1,3],[2,4],[3,2]]");
        System.out.println(obj.minHeightShelves(ex2, 6));
    }
}