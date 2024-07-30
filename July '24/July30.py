'''
Q- Minimum deletions to make string balanced

You are given a string s consisting only of characters 'a' and 'b'​​​​.

You can delete any number of characters in s to make s balanced. s is balanced if there is no pair of indices (i,j) such that i < j and s[i] = 'b' and s[j]= 'a'.

Return the minimum number of deletions needed to make s balanced.

Link - https://leetcode.com/problems/minimum-deletions-to-make-string-balanced/description/
'''

def minimumDeletions(s: str) -> int:
        n = len(s)
        #dp array
        f = [0]*(n+1)
        b = 0
        #while no b appears no value will be deleted
        #after first b we begin deleting values depending on minimum value of f[i-1] or b
        for i in range(1,n+1):
            # if 'b' appears increment b, set f[i] to f[i-1]
            if s[i-1] == 'b':
                f[i] = f[i-1]
                b+=1
            else:
                #f[i] is minimum of b and 1 more than f[i-1]
                f[i] = min(f[i-1]+1, b)
        return f[n]

if __name__ == '__main__':
    print("Example 1: aababbab")
    print(minimumDeletions("aababbab"))
    print("Example 2: bbaaaaabb")
    print(minimumDeletions("bbaaaaabb"))