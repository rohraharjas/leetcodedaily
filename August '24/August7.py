'''
Q - Integer to English Word

Convert a non-negative integer num to its English words representation.
(This one made me cry)

Link - https://leetcode.com/problems/integer-to-english-words/description/
'''

def numberToWords(num: int) -> str:
        if num == 0:
            return "Zero"

        # Words for numbers less than 20
        below_20 = [
            "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven",
            "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
            "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
        ]

        # Words for tens
        tens = [
            "", "", "Twenty", "Thirty", "Forty", "Fifty",
            "Sixty", "Seventy", "Eighty", "Ninety"
        ]

        # Words for large numbers
        thousands = ["", "Thousand", "Million", "Billion"]

        # Helper function to convert a number less than 1000 to words
        def threeDigitToWords(num):
            if num == 0:
                return ""
            elif num < 20:
                return below_20[num] + " "
            elif num < 100:
                return tens[num // 10] + " " + threeDigitToWords(num % 10)
            else:
                return below_20[num // 100] + " Hundred " + threeDigitToWords(num % 100)

        # Convert number to words
        res = ""
        for i in range(len(thousands)):
            if num % 1000 != 0:
                res = threeDigitToWords(num % 1000) + thousands[i] + " " + res
            num //= 1000

        return res.strip()

if __name__ == '__main__':
    print("Example 1: 123")
    print(numberToWords(123))

    print("Example 2: 12345")
    print(numberToWords(12345))

    print("Example 3: 1234567")
    print(numberToWords(1234567))