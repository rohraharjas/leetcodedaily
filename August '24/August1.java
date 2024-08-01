/*
 * Q - Number of Senior Citizen
 * 
 * You are given a 0-indexed array of strings details. Each element of details provides information about a given passenger compressed into a string of length 15. The system is such that:

The first ten characters consist of the phone number of passengers.
The next character denotes the gender of the person.
The following two characters are used to indicate the age of the person.
The last two characters determine the seat allotted to that person.
Return the number of passengers who are strictly more than 60 years old.

Link - https://leetcode.com/problems/number-of-senior-citizens/description/
 */


 class Solution{
    public int countSeniors(String[] details) {
        int count = 0;
        for(String person:details){
            int age = Integer.parseInt(person.substring(11,13));
            System.out.println(age);
            if(age>60){
                count++;
            }
        }
        return count;
    }

    public static void main(String args[]){
        Solution obj = new Solution();
        // Example 1
        String[] details1 = {"7868190130M7522", "5303914400F9211", "9273338290F4010"};
        int result1 = obj.countSeniors(details1);
        System.out.println("Output: " + result1); // Expected output: 2

        // Example 2
        String[] details2 = {"1313579440F2036", "2921522980M5644"};
        int result2 = obj.countSeniors(details2);
        System.out.println("Output: " + result2); // Expected output: 0
    }
 }