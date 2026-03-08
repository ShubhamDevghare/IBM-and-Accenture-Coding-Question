import java.util.*;

// ============================================================
//         PREPINSTA TOP 100 CODES - ALL JAVA SOLUTIONS
// ============================================================

public class Top100CodesJava {

    // =========================================================
    // SECTION 1: GETTING STARTED
    // =========================================================

    // Q1. Positive or Negative Number
    static void positiveOrNegative(int n) {
        if (n > 0) System.out.println(n + " is Positive");
        else if (n < 0) System.out.println(n + " is Negative");
        else System.out.println("Zero");
    }

    // Q2. Even or Odd Number
    static void evenOrOdd(int n) {
        System.out.println(n % 2 == 0 ? n + " is Even" : n + " is Odd");
    }

    // Q3. Sum of First N Natural Numbers
    static int sumFirstN(int n) {
        return n * (n + 1) / 2;
    }

    // Q4. Sum of N Natural Numbers (using loop)
    static int sumNNatural(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) sum += i;
        return sum;
    }

    // Q5. Sum of Numbers in a Given Range
    static int sumInRange(int a, int b) {
        int sum = 0;
        for (int i = a; i <= b; i++) sum += i;
        return sum;
    }

    // Q6. Greatest of Two Numbers
    static int greatestTwo(int a, int b) {
        return (a > b) ? a : b;
    }

    // Q7. Greatest of Three Numbers
    static int greatestThree(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    // Q8. Leap Year or Not
    static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // Q9. Prime Number or Not
    static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0) return false;
        return true;
    }

    // Q10. Prime Numbers in a Given Range
    static void primesInRange(int a, int b) {
        System.out.print("Primes between " + a + " and " + b + ": ");
        for (int i = a; i <= b; i++)
            if (isPrime(i)) System.out.print(i + " ");
        System.out.println();
    }

    // Q11. Sum of Digits of a Number
    static int sumOfDigits(int n) {
        n = Math.abs(n);
        int sum = 0;
        while (n > 0) { sum += n % 10; n /= 10; }
        return sum;
    }

    // Q12. Reverse of a Number
    static int reverseNumber(int n) {
        int rev = 0;
        boolean neg = n < 0;
        n = Math.abs(n);
        while (n > 0) { rev = rev * 10 + n % 10; n /= 10; }
        return neg ? -rev : rev;
    }

    // Q13. Palindrome Number
    static boolean isPalindromeNumber(int n) {
        return n == reverseNumber(n);
    }

    // Q14. Armstrong Number
    static boolean isArmstrong(int n) {
        int temp = n, sum = 0, digits = String.valueOf(n).length();
        while (temp > 0) {
            sum += (int) Math.pow(temp % 10, digits);
            temp /= 10;
        }
        return sum == n;
    }

    // Q15. Armstrong Numbers in a Given Range
    static void armstrongInRange(int a, int b) {
        System.out.print("Armstrong numbers between " + a + " and " + b + ": ");
        for (int i = a; i <= b; i++)
            if (isArmstrong(i)) System.out.print(i + " ");
        System.out.println();
    }

    // Q16. Fibonacci Series up to Nth Term
    static void fibonacciSeries(int n) {
        int a = 0, b = 1;
        System.out.print("Fibonacci: ");
        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");
            int c = a + b; a = b; b = c;
        }
        System.out.println();
    }

    // Q17. Find the Nth Term of Fibonacci Series
    static int nthFibonacci(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 0;
        if (n == 2) return 1;
        int a = 0, b = 1;
        for (int i = 2; i < n; i++) {
            int c = a + b; a = b; b = c;
        }
        return b;
    }

    // Q18. Factorial of a Number
    static long factorial(int n) {
        if (n == 0 || n == 1) return 1;
        return n * factorial(n - 1);
    }

    // Q19. Power of a Number
    static double power(double base, int exp) {
        return Math.pow(base, exp);
    }

    // Q20. Factors of a Number
    static void factors(int n) {
        System.out.print("Factors of " + n + ": ");
        for (int i = 1; i <= n; i++)
            if (n % i == 0) System.out.print(i + " ");
        System.out.println();
    }

    // Q21. Prime Factors of a Number
    static void primeFactors(int n) {
        System.out.print("Prime factors of " + n + ": ");
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) { System.out.print(i + " "); n /= i; }
        }
        System.out.println();
    }

    // Q22. Strong Number
    static boolean isStrong(int n) {
        int temp = n, sum = 0;
        while (temp > 0) {
            sum += factorial(temp % 10);
            temp /= 10;
        }
        return sum == n;
    }

    // Q23. Perfect Number
    static boolean isPerfect(int n) {
        int sum = 0;
        for (int i = 1; i < n; i++)
            if (n % i == 0) sum += i;
        return sum == n;
    }

    // Q24. Perfect Square
    static boolean isPerfectSquare(int n) {
        int sq = (int) Math.sqrt(n);
        return sq * sq == n;
    }

    // Q25. Automorphic Number
    static boolean isAutomorphic(int n) {
        int sq = n * n;
        int digits = String.valueOf(n).length();
        return sq % (int) Math.pow(10, digits) == n;
    }

    // Q26. Harshad Number (Niven Number)
    static boolean isHarshad(int n) {
        return n % sumOfDigits(n) == 0;
    }

    // Q27. Abundant Number
    static boolean isAbundant(int n) {
        int sum = 0;
        for (int i = 1; i < n; i++)
            if (n % i == 0) sum += i;
        return sum > n;
    }

    // Q28. Friendly Pair (Amicable Numbers)
    static boolean isFriendlyPair(int a, int b) {
        int sumA = 0, sumB = 0;
        for (int i = 1; i < a; i++) if (a % i == 0) sumA += i;
        for (int i = 1; i < b; i++) if (b % i == 0) sumB += i;
        return sumA == b && sumB == a;
    }

    // =========================================================
    // SECTION 2: WORKING WITH NUMBERS
    // =========================================================

    // Q29. HCF (GCD)
    static int hcf(int a, int b) {
        return b == 0 ? a : hcf(b, a % b);
    }

    // Q30. LCM
    static int lcm(int a, int b) {
        return (a / hcf(a, b)) * b;
    }

    // Q31. GCD (same as HCF)
    static int gcd(int a, int b) {
        while (b != 0) { int t = b; b = a % b; a = t; }
        return a;
    }

    // Q32. Binary to Decimal
    static int binaryToDecimal(String bin) {
        return Integer.parseInt(bin, 2);
    }

    // Q33. Octal to Decimal
    static int octalToDecimal(String oct) {
        return Integer.parseInt(oct, 8);
    }

    // Q34. Hexadecimal to Decimal
    static int hexToDecimal(String hex) {
        return Integer.parseInt(hex, 16);
    }

    // Q35. Decimal to Binary
    static String decimalToBinary(int n) {
        return Integer.toBinaryString(n);
    }

    // Q36. Decimal to Octal
    static String decimalToOctal(int n) {
        return Integer.toOctalString(n);
    }

    // Q37. Decimal to Hexadecimal
    static String decimalToHex(int n) {
        return Integer.toHexString(n).toUpperCase();
    }

    // Q38. Binary to Octal
    static String binaryToOctal(String bin) {
        return decimalToOctal(binaryToDecimal(bin));
    }

    // Q39. Octal to Binary
    static String octalToBinary(String oct) {
        return decimalToBinary(octalToDecimal(oct));
    }

    // Q40. Quadrant of a Coordinate
    static String quadrant(int x, int y) {
        if (x > 0 && y > 0) return "Quadrant I";
        if (x < 0 && y > 0) return "Quadrant II";
        if (x < 0 && y < 0) return "Quadrant III";
        if (x > 0 && y < 0) return "Quadrant IV";
        return "On Axis";
    }

    // Q41. Permutations nPr
    static long nPr(int n, int r) {
        return factorial(n) / factorial(n - r);
    }

    // Q42. Maximum Handshakes
    static int maxHandshakes(int n) {
        return n * (n - 1) / 2;
    }

    // Q43. Addition of Two Fractions
    static void addFractions(int n1, int d1, int n2, int d2) {
        int num = n1 * d2 + n2 * d1;
        int den = d1 * d2;
        int g = gcd(Math.abs(num), den);
        System.out.println("Sum = " + (num / g) + "/" + (den / g));
    }

    // Q44. Replace all 0's with 1 in a given integer
    static int replaceZeroWithOne(int n) {
        String s = String.valueOf(n).replace('0', '1');
        return Integer.parseInt(s);
    }

    // Q45. Can a number be expressed as sum of two primes?
    static boolean sumOfTwoPrimes(int n) {
        for (int i = 2; i <= n / 2; i++)
            if (isPrime(i) && isPrime(n - i)) return true;
        return false;
    }

    // Q46. Count Possible Decodings of a Digit Sequence
    static int countDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1; dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int one = Integer.parseInt(s.substring(i - 1, i));
            int two = Integer.parseInt(s.substring(i - 2, i));
            if (one >= 1) dp[i] += dp[i - 1];
            if (two >= 10 && two <= 26) dp[i] += dp[i - 2];
        }
        return dp[n];
    }

    // Q47. Area of a Circle
    static double areaOfCircle(double r) {
        return Math.PI * r * r;
    }

    // Q48. Prime numbers between 1 to 100
    static void primes1to100() {
        System.out.print("Primes 1-100: ");
        for (int i = 2; i <= 100; i++)
            if (isPrime(i)) System.out.print(i + " ");
        System.out.println();
    }

    // Q49. Number of digits in an integer
    static int countDigits(int n) {
        return String.valueOf(Math.abs(n)).length();
    }

    // Q50. Convert Number to Words
    static String numberToWords(int n) {
        String[] ones = {"", "One", "Two", "Three", "Four", "Five",
                "Six", "Seven", "Eight", "Nine", "Ten",
                "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
                "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty",
                "Sixty", "Seventy", "Eighty", "Ninety"};
        if (n == 0) return "Zero";
        if (n < 20) return ones[n];
        if (n < 100) return tens[n / 10] + (n % 10 != 0 ? " " + ones[n % 10] : "");
        if (n < 1000) return ones[n / 100] + " Hundred" + (n % 100 != 0 ? " " + numberToWords(n % 100) : "");
        return ones[n / 1000] + " Thousand" + (n % 1000 != 0 ? " " + numberToWords(n % 1000) : "");
    }

    // Q51. Number of Days in a Given Month of a Year
    static int daysInMonth(int month, int year) {
        int[] days = {31, isLeapYear(year) ? 29 : 28, 31, 30, 31, 30,
                31, 31, 30, 31, 30, 31};
        return days[month - 1];
    }

    // Q52. Occurrence of X digit in a number
    static int digitOccurrence(int n, int x) {
        int count = 0;
        n = Math.abs(n);
        while (n > 0) {
            if (n % 10 == x) count++;
            n /= 10;
        }
        return count;
    }

    // Q53. Count integers with exactly X divisors (from 1 to N)
    static int integersWithXDivisors(int n, int x) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int d = 0;
            for (int j = 1; j <= i; j++) if (i % j == 0) d++;
            if (d == x) count++;
        }
        return count;
    }

    // Q54. Roots of a Quadratic Equation (ax^2 + bx + c = 0)
    static void quadraticRoots(double a, double b, double c) {
        double disc = b * b - 4 * a * c;
        if (disc > 0) {
            System.out.printf("Roots: %.2f and %.2f%n",
                    (-b + Math.sqrt(disc)) / (2 * a),
                    (-b - Math.sqrt(disc)) / (2 * a));
        } else if (disc == 0) {
            System.out.printf("Equal roots: %.2f%n", -b / (2 * a));
        } else {
            System.out.printf("Complex roots: %.2f+%.2fi and %.2f-%.2fi%n",
                    -b / (2 * a), Math.sqrt(-disc) / (2 * a),
                    -b / (2 * a), Math.sqrt(-disc) / (2 * a));
        }
    }

    // =========================================================
    // SECTION 3: RECURSION
    // =========================================================

    // Q55. Power using Recursion
    static double powerRecursive(double base, int exp) {
        if (exp == 0) return 1;
        return base * powerRecursive(base, exp - 1);
    }

    // Q56. Prime Number using Recursion
    static boolean isPrimeRecursive(int n, int i) {
        if (n < 2) return false;
        if (i * i > n) return true;
        if (n % i == 0) return false;
        return isPrimeRecursive(n, i + 1);
    }

    // Q57. Largest Element in Array using Recursion
    static int largestRecursive(int[] arr, int n) {
        if (n == 1) return arr[0];
        return Math.max(arr[n - 1], largestRecursive(arr, n - 1));
    }

    // Q58. Smallest Element in Array using Recursion
    static int smallestRecursive(int[] arr, int n) {
        if (n == 1) return arr[0];
        return Math.min(arr[n - 1], smallestRecursive(arr, n - 1));
    }

    // Q59. Reverse a Number using Recursion
    static int reverseRecursive(int n, int rev) {
        if (n == 0) return rev;
        return reverseRecursive(n / 10, rev * 10 + n % 10);
    }

    // Q60. HCF using Recursion
    static int hcfRecursive(int a, int b) {
        if (b == 0) return a;
        return hcfRecursive(b, a % b);
    }

    // Q61. LCM using Recursion
    static int lcmRecursive(int a, int b) {
        return a / hcfRecursive(a, b) * b;
    }

    // Q62. Length of String using Recursion
    static int stringLengthRecursive(String s) {
        if (s.isEmpty()) return 0;
        return 1 + stringLengthRecursive(s.substring(1));
    }

    // Q63. Print All Permutations of a String
    static void permutations(String str, String current) {
        if (str.isEmpty()) { System.out.print(current + " "); return; }
        for (int i = 0; i < str.length(); i++) {
            permutations(str.substring(0, i) + str.substring(i + 1),
                    current + str.charAt(i));
        }
    }

    // Q64. Print F(N)th term (Fibonacci variant)
    static int fNth(int n) {
        if (n <= 1) return n;
        return fNth(n - 1) + fNth(n - 2);
    }

    // Q65. Print sums of all subsets
    static void subsetSums(int[] arr, int n, int sum) {
        if (n == 0) { System.out.print(sum + " "); return; }
        subsetSums(arr, n - 1, sum + arr[n - 1]);
        subsetSums(arr, n - 1, sum);
    }

    // Q66. Last Non-Zero Digit in Factorial
    static int lastNonZeroFactorial(int n) {
        String f = String.valueOf(factorial(n));
        for (int i = f.length() - 1; i >= 0; i--)
            if (f.charAt(i) != '0') return f.charAt(i) - '0';
        return -1;
    }

    // Q67. Nth Row of Pascal's Triangle
    static void nthRowPascal(int n) {
        long val = 1;
        System.out.print("Row " + n + ": ");
        for (int i = 0; i <= n; i++) {
            System.out.print(val + " ");
            val = val * (n - i) / (i + 1);
        }
        System.out.println();
    }

    // Q68. Generate All Balanced Parentheses
    static void generateParentheses(String s, int open, int close, int n) {
        if (s.length() == 2 * n) { System.out.print(s + " "); return; }
        if (open < n) generateParentheses(s + "(", open + 1, close, n);
        if (close < open) generateParentheses(s + ")", open, close + 1, n);
    }

    // Q69. Factorial using Recursion (same as Q18 - already recursive)
    // (reuse factorial method above)

    // Q70. All Palindromic Partitions of a String
    static void palindromicPartitions(String s, List<String> current, int start) {
        if (start == s.length()) { System.out.println(current); return; }
        for (int end = start + 1; end <= s.length(); end++) {
            String sub = s.substring(start, end);
            if (isPalindromeStr(sub)) {
                current.add(sub);
                palindromicPartitions(s, current, end);
                current.remove(current.size() - 1);
            }
        }
    }

    // Q71. N-bit binary numbers with more 1s than 0s
    static void nBitMoreOnes(String s, int ones, int zeros, int n) {
        if (s.length() == n) { System.out.print(s + " "); return; }
        nBitMoreOnes(s + "1", ones + 1, zeros, n);
        if (ones > zeros) nBitMoreOnes(s + "0", ones, zeros + 1, n);
    }

    // Q72. Find All Subsets
    static void allSubsets(int[] arr, int index, List<Integer> current) {
        System.out.println(current);
        for (int i = index; i < arr.length; i++) {
            current.add(arr[i]);
            allSubsets(arr, i + 1, current);
            current.remove(current.size() - 1);
        }
    }

    // Q73. Remove Adjacent Duplicates Recursively
    static String removeAdjacentDuplicates(String s) {
        if (s.length() <= 1) return s;
        if (s.charAt(0) == s.charAt(1))
            return removeAdjacentDuplicates(s.substring(1));
        return s.charAt(0) + removeAdjacentDuplicates(s.substring(1));
    }

    // =========================================================
    // SECTION 4: ARRAYS
    // =========================================================

    // Q74. Largest Element in Array
    static int largestInArray(int[] arr) {
        int max = arr[0];
        for (int x : arr) if (x > max) max = x;
        return max;
    }

    // Q75. Smallest Element in Array
    static int smallestInArray(int[] arr) {
        int min = arr[0];
        for (int x : arr) if (x < min) min = x;
        return min;
    }

    // Q76. Both Smallest and Largest
    static void smallestAndLargest(int[] arr) {
        System.out.println("Min=" + smallestInArray(arr) + " Max=" + largestInArray(arr));
    }

    // Q77. Second Smallest Element
    static int secondSmallest(int[] arr) {
        int min = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int x : arr) {
            if (x < min) { second = min; min = x; }
            else if (x < second && x != min) second = x;
        }
        return second;
    }

    // Q78. Sum of Elements in Array
    static int arraySum(int[] arr) {
        int sum = 0;
        for (int x : arr) sum += x;
        return sum;
    }

    // Q79. Reverse an Array
    static void reverseArray(int[] arr) {
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            int t = arr[i]; arr[i] = arr[j]; arr[j] = t;
        }
    }

    // Q80. Sort First Half Ascending, Second Half Descending
    static void sortHalves(int[] arr) {
        Arrays.sort(arr);
        int mid = arr.length / 2;
        int[] result = new int[arr.length];
        for (int i = 0; i < mid; i++) result[i] = arr[i];
        for (int i = mid, j = arr.length - 1; i < arr.length; i++, j--)
            result[i] = arr[j];
        System.out.println("Sorted halves: " + Arrays.toString(result));
    }

    // Q81. Sort Array (Ascending)
    static void sortArray(int[] arr) {
        Arrays.sort(arr);
        System.out.println("Sorted: " + Arrays.toString(arr));
    }

    // Q82. Frequency of Elements
    static void frequencyOfElements(int[] arr) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int x : arr) map.put(x, map.getOrDefault(x, 0) + 1);
        map.forEach((k, v) -> System.out.println(k + " -> " + v));
    }

    // Q83. Sort by Frequency
    static void sortByFrequency(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : arr) freq.put(x, freq.getOrDefault(x, 0) + 1);
        Integer[] boxed = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(boxed, (a, b) -> freq.get(b) - freq.get(a));
        System.out.println("Sorted by freq: " + Arrays.toString(boxed));
    }

    // Q84. Longest Palindrome in Array of Strings
    static String longestPalindromeInArray(String[] arr) {
        String longest = "";
        for (String s : arr)
            if (isPalindromeStr(s) && s.length() > longest.length()) longest = s;
        return longest;
    }

    // Q85. Count Distinct Elements
    static int countDistinct(int[] arr) {
        return (int) Arrays.stream(arr).distinct().count();
    }

    // Q86. Repeating Elements
    static void repeatingElements(int[] arr) {
        Set<Integer> seen = new HashSet<>();
        System.out.print("Repeating: ");
        for (int x : arr)
            if (!seen.add(x)) System.out.print(x + " ");
        System.out.println();
    }

    // Q87. Non-Repeating Elements
    static void nonRepeatingElements(int[] arr) {
        Map<Integer, Integer> freq = new LinkedHashMap<>();
        for (int x : arr) freq.put(x, freq.getOrDefault(x, 0) + 1);
        System.out.print("Non-repeating: ");
        freq.forEach((k, v) -> { if (v == 1) System.out.print(k + " "); });
        System.out.println();
    }

    // Q88. Remove Duplicate Elements
    static int[] removeDuplicates(int[] arr) {
        return Arrays.stream(arr).distinct().toArray();
    }

    // Q89. Minimum Scalar Product of Two Vectors
    static long minScalarProduct(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int n = a.length;
        long sum = 0;
        for (int i = 0; i < n; i++) sum += (long) a[i] * b[n - 1 - i];
        return sum;
    }

    // Q90. Maximum Scalar Product of Two Vectors
    static long maxScalarProduct(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        long sum = 0;
        for (int i = 0; i < a.length; i++) sum += (long) a[i] * b[i];
        return sum;
    }

    // Q91. Count Even and Odd Elements
    static void countEvenOdd(int[] arr) {
        int even = 0, odd = 0;
        for (int x : arr) { if (x % 2 == 0) even++; else odd++; }
        System.out.println("Even=" + even + " Odd=" + odd);
    }

    // Q92. Find All Symmetric Pairs (pairs (a,b) and (b,a))
    static void symmetricPairs(int[][] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        System.out.print("Symmetric pairs: ");
        for (int[] pair : arr) {
            if (map.containsKey(pair[1]) && map.get(pair[1]) == pair[0])
                System.out.print("[" + pair[0] + "," + pair[1] + "] ");
            else map.put(pair[0], pair[1]);
        }
        System.out.println();
    }

    // Q93. Maximum Product Sub-array
    static int maxProductSubarray(int[] arr) {
        int maxProd = arr[0], minProd = arr[0], result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < 0) { int t = maxProd; maxProd = minProd; minProd = t; }
            maxProd = Math.max(arr[i], maxProd * arr[i]);
            minProd = Math.min(arr[i], minProd * arr[i]);
            result = Math.max(result, maxProd);
        }
        return result;
    }

    // Q94. Arrays are Disjoint or Not
    static boolean areDisjoint(int[] a, int[] b) {
        Set<Integer> set = new HashSet<>();
        for (int x : a) set.add(x);
        for (int x : b) if (set.contains(x)) return false;
        return true;
    }

    // Q95. Array is Subset of Another Array
    static boolean isSubset(int[] a, int[] b) {
        Set<Integer> set = new HashSet<>();
        for (int x : a) set.add(x);
        for (int x : b) if (!set.contains(x)) return false;
        return true;
    }

    // Q96. Can All Numbers be Made Equal
    static boolean allEqual(int[] arr) {
        int min = Arrays.stream(arr).min().getAsInt();
        for (int x : arr) if (x % min != 0) return false;
        return true;
    }

    // Q97. Minimum Sum of Absolute Differences
    static int minSumAbsDiff(int[] a, int[] b) {
        Arrays.sort(a); Arrays.sort(b);
        int sum = 0;
        for (int i = 0; i < a.length; i++) sum += Math.abs(a[i] - b[i]);
        return sum;
    }

    // Q98. Sort Array According to Order Defined by Another Array
    static void sortByOrder(int[] arr, int[] order) {
        Map<Integer, Integer> rank = new HashMap<>();
        for (int i = 0; i < order.length; i++) rank.put(order[i], i);
        Integer[] boxed = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(boxed, (a, b) -> {
            int ra = rank.getOrDefault(a, order.length);
            int rb = rank.getOrDefault(b, order.length);
            return ra - rb;
        });
        System.out.println("Sorted by order: " + Arrays.toString(boxed));
    }

    // Q99. Replace Each Element by Its Rank
    static void replaceByRank(int[] arr) {
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        Map<Integer, Integer> rank = new HashMap<>();
        int r = 1;
        for (int x : sorted) if (!rank.containsKey(x)) rank.put(x, r++);
        System.out.print("Ranks: ");
        for (int x : arr) System.out.print(rank.get(x) + " ");
        System.out.println();
    }

    // Q100. Equilibrium Index of an Array
    static int equilibriumIndex(int[] arr) {
        int total = arraySum(arr), leftSum = 0;
        for (int i = 0; i < arr.length; i++) {
            total -= arr[i];
            if (leftSum == total) return i;
            leftSum += arr[i];
        }
        return -1;
    }

    // Q101. Left Rotation of Array
    static void rotateLeft(int[] arr, int k) {
        int n = arr.length; k %= n;
        reverse(arr, 0, k - 1);
        reverse(arr, k, n - 1);
        reverse(arr, 0, n - 1);
        System.out.println("Left rotated: " + Arrays.toString(arr));
    }

    // Q102. Block Swap Algorithm for Array Rotation
    static void blockSwap(int[] arr, int a, int b, int d) {
        for (int i = 0; i < d; i++) {
            int t = arr[a + i]; arr[a + i] = arr[b + i]; arr[b + i] = t;
        }
    }

    // Q103. Juggling Algorithm for Array Rotation
    static void jugglingRotate(int[] arr, int d) {
        int n = arr.length;
        for (int i = 0; i < gcd(d, n); i++) {
            int temp = arr[i], j = i;
            while (true) {
                int k = (j + d) % n;
                if (k == i) break;
                arr[j] = arr[k]; j = k;
            }
            arr[j] = temp;
        }
        System.out.println("Juggling rotated: " + Arrays.toString(arr));
    }

    // Q104. Circular Rotation by K Positions
    static void circularRotation(int[] arr, int k) {
        int n = arr.length; k %= n;
        reverse(arr, 0, n - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, n - 1);
        System.out.println("Circular rotation: " + Arrays.toString(arr));
    }

    static void reverse(int[] arr, int l, int r) {
        while (l < r) { int t = arr[l]; arr[l] = arr[r]; arr[r] = t; l++; r--; }
    }

    // Q105. Balanced Parenthesis
    static boolean balancedParenthesis(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') stack.push(c);
            else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if ((c == ')' && top != '(') || (c == '}' && top != '{') ||
                        (c == ']' && top != '[')) return false;
            }
        }
        return stack.isEmpty();
    }

    // =========================================================
    // SECTION 5: STRINGS
    // =========================================================

    // Q106. Vowel or Consonant
    static String vowelOrConsonant(char c) {
        c = Character.toLowerCase(c);
        return "aeiou".indexOf(c) != -1 ? "Vowel" : "Consonant";
    }

    // Q107. Alphabet or Not
    static boolean isAlphabet(char c) {
        return Character.isLetter(c);
    }

    // Q108. ASCII Value of a Character
    static int asciiValue(char c) {
        return (int) c;
    }

    // Q109. Length of String without length()
    static int lengthWithoutFunction(String s) {
        int count = 0;
        for (char c : s.toCharArray()) count++;
        return count;
    }

    // Q110. Toggle Each Character
    static String toggleCase(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray())
            sb.append(Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c));
        return sb.toString();
    }

    // Q111. Count Vowels
    static int countVowels(String s) {
        int count = 0;
        for (char c : s.toLowerCase().toCharArray())
            if ("aeiou".indexOf(c) != -1) count++;
        return count;
    }

    // Q112. Remove Vowels
    static String removeVowels(String s) {
        return s.replaceAll("[aeiouAEIOU]", "");
    }

    // Q113. Palindrome String
    static boolean isPalindromeStr(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        return s.equalsIgnoreCase(rev);
    }

    // Q114. Reverse a String
    static String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    // Q115. Remove All Characters Except Alphabets
    static String keepOnlyAlpha(String s) {
        return s.replaceAll("[^a-zA-Z]", "");
    }

    // Q116. Remove Spaces from a String
    static String removeSpaces(String s) {
        return s.replaceAll("\\s+", "");
    }

    // Q117. Remove Brackets from Algebraic Expression
    static String removeBrackets(String s) {
        return s.replaceAll("[(){}\\[\\]]", "");
    }

    // Q118. Count Sum of Numbers in a String
    static int sumOfNumbersInString(String s) {
        int sum = 0;
        String[] nums = s.split("[^0-9]+");
        for (String n : nums)
            if (!n.isEmpty()) sum += Integer.parseInt(n);
        return sum;
    }

    // Q119. Capitalize First and Last Character of Each Word
    static String capitalizeFirstLast(String s) {
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            if (word.length() == 1) {
                result.append(Character.toUpperCase(word.charAt(0)));
            } else {
                result.append(Character.toUpperCase(word.charAt(0)));
                result.append(word.substring(1, word.length() - 1));
                result.append(Character.toUpperCase(word.charAt(word.length() - 1)));
            }
            result.append(" ");
        }
        return result.toString().trim();
    }

    // Q120. Frequency of Characters in a String
    static void charFrequency(String s) {
        Map<Character, Integer> freq = new LinkedHashMap<>();
        for (char c : s.toCharArray())
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        freq.forEach((k, v) -> System.out.println("'" + k + "' -> " + v));
    }

    // Q121. Non-Repeating Characters in a String
    static void nonRepeatingChars(String s) {
        Map<Character, Integer> freq = new LinkedHashMap<>();
        for (char c : s.toCharArray())
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        System.out.print("Non-repeating chars: ");
        freq.forEach((k, v) -> { if (v == 1) System.out.print(k + " "); });
        System.out.println();
    }

    // Q122. Anagram Check
    static boolean isAnagram(String s1, String s2) {
        char[] a = s1.toLowerCase().toCharArray();
        char[] b = s2.toLowerCase().toCharArray();
        Arrays.sort(a); Arrays.sort(b);
        return Arrays.equals(a, b);
    }

    // Q123. Replace Substring in a String
    static String replaceSubstring(String s, String old, String newStr) {
        return s.replace(old, newStr);
    }

    // Q124. Replace a Word with Another Word
    static String replaceWord(String s, String oldWord, String newWord) {
        return s.replaceAll("\\b" + oldWord + "\\b", newWord);
    }

    // Q125. Count Common Subsequences in Two Strings
    static int countCommonSubsequences(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) dp[i][j] = 2*dp[i-1][j-1]+1;
                else dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1];
            }
        return dp[m][n];
    }

    // Q126. Wildcard String Matching
    static boolean wildcardMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int j = 1; j <= n; j++) if (p.charAt(j-1) == '*') dp[0][j] = dp[0][j-1];
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j-1) == '*') dp[i][j] = dp[i-1][j] || dp[i][j-1];
                else if (p.charAt(j-1) == '?' || s.charAt(i-1) == p.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
            }
        return dp[m][n];
    }

    // Q127. Print All Permutations in Lexicographic Order
    static void lexicographicPermutations(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        List<String> result = new ArrayList<>();
        permHelper(chars, 0, result);
        Collections.sort(result);
        result.forEach(p -> System.out.print(p + " "));
        System.out.println();
    }
    static void permHelper(char[] arr, int start, List<String> result) {
        if (start == arr.length - 1) { result.add(new String(arr)); return; }
        for (int i = start; i < arr.length; i++) {
            char t = arr[start]; arr[start] = arr[i]; arr[i] = t;
            permHelper(arr, start + 1, result);
            t = arr[start]; arr[start] = arr[i]; arr[i] = t;
        }
    }

    // =========================================================
    // MAIN METHOD - Demo of all solutions
    // =========================================================
    public static void main(String[] args) {
        System.out.println("========== TOP 100 CODES - JAVA SOLUTIONS ==========\n");

        // Section 1: Getting Started
        System.out.println("--- Section 1: Getting Started ---");
        positiveOrNegative(5);
        evenOrOdd(7);
        System.out.println("Sum of first 10 naturals: " + sumFirstN(10));
        System.out.println("Sum in range [3,7]: " + sumInRange(3, 7));
        System.out.println("Greatest of 5,9: " + greatestTwo(5, 9));
        System.out.println("Greatest of 3,7,5: " + greatestThree(3, 7, 5));
        System.out.println("2024 leap year: " + isLeapYear(2024));
        System.out.println("17 is prime: " + isPrime(17));
        primesInRange(1, 20);
        System.out.println("Sum of digits of 1234: " + sumOfDigits(1234));
        System.out.println("Reverse of 1234: " + reverseNumber(1234));
        System.out.println("121 is palindrome: " + isPalindromeNumber(121));
        System.out.println("153 is Armstrong: " + isArmstrong(153));
        armstrongInRange(1, 500);
        fibonacciSeries(8);
        System.out.println("7th Fibonacci: " + nthFibonacci(7));
        System.out.println("Factorial of 6: " + factorial(6));
        System.out.println("2^8 = " + power(2, 8));
        factors(12);
        primeFactors(60);
        System.out.println("145 is Strong: " + isStrong(145));
        System.out.println("28 is Perfect: " + isPerfect(28));
        System.out.println("25 is Perfect Square: " + isPerfectSquare(25));
        System.out.println("25 is Automorphic: " + isAutomorphic(25));
        System.out.println("18 is Harshad: " + isHarshad(18));
        System.out.println("12 is Abundant: " + isAbundant(12));
        System.out.println("220 & 284 Friendly pair: " + isFriendlyPair(220, 284));

        System.out.println("\n--- Section 2: Working with Numbers ---");
        System.out.println("HCF(36,48): " + hcf(36, 48));
        System.out.println("LCM(4,6): " + lcm(4, 6));
        System.out.println("Binary '1010' to Decimal: " + binaryToDecimal("1010"));
        System.out.println("Octal '17' to Decimal: " + octalToDecimal("17"));
        System.out.println("Hex 'FF' to Decimal: " + hexToDecimal("FF"));
        System.out.println("Decimal 10 to Binary: " + decimalToBinary(10));
        System.out.println("Decimal 8 to Octal: " + decimalToOctal(8));
        System.out.println("Decimal 255 to Hex: " + decimalToHex(255));
        System.out.println("Binary '111' to Octal: " + binaryToOctal("111"));
        System.out.println("Quadrant(3,-2): " + quadrant(3, -2));
        System.out.println("P(5,2): " + nPr(5, 2));
        System.out.println("Handshakes for 5 people: " + maxHandshakes(5));
        addFractions(1, 2, 1, 3);
        System.out.println("Replace 0s with 1s in 1030: " + replaceZeroWithOne(1030));
        System.out.println("6 = sum of two primes: " + sumOfTwoPrimes(6));
        System.out.println("Decodings of '121': " + countDecodings("121"));
        System.out.printf("Area of circle r=5: %.2f%n", areaOfCircle(5));
        primes1to100();
        System.out.println("Digits in 4567: " + countDigits(4567));
        System.out.println("42 in words: " + numberToWords(42));
        System.out.println("Days in Feb 2024: " + daysInMonth(2, 2024));
        System.out.println("Digit 3 in 3033: " + digitOccurrence(3033, 3));
        System.out.println("Integers with 3 divisors up to 10: " + integersWithXDivisors(10, 3));
        quadraticRoots(1, -5, 6);

        System.out.println("\n--- Section 3: Recursion ---");
        System.out.println("2^10 (recursive): " + powerRecursive(2, 10));
        System.out.println("17 prime (recursive): " + isPrimeRecursive(17, 2));
        int[] arr = {3, 1, 7, 2, 9};
        System.out.println("Largest (recursive): " + largestRecursive(arr, arr.length));
        System.out.println("Smallest (recursive): " + smallestRecursive(arr, arr.length));
        System.out.println("Reverse 1234 (recursive): " + reverseRecursive(1234, 0));
        System.out.println("HCF(24,36) recursive: " + hcfRecursive(24, 36));
        System.out.println("LCM(4,6) recursive: " + lcmRecursive(4, 6));
        System.out.println("Length of 'hello' recursive: " + stringLengthRecursive("hello"));
        System.out.print("Permutations of 'ABC': ");
        permutations("ABC", "");
        System.out.println();
        System.out.println("F(6): " + fNth(6));
        System.out.print("Subset sums of {1,2,3}: ");
        subsetSums(new int[]{1, 2, 3}, 3, 0);
        System.out.println();
        System.out.println("Last non-zero digit of 10!: " + lastNonZeroFactorial(10));
        nthRowPascal(5);
        System.out.print("Balanced parentheses n=2: ");
        generateParentheses("", 0, 0, 2);
        System.out.println();
        System.out.println("Palindromic partitions of 'aab': ");
        palindromicPartitions("aab", new ArrayList<>(), 0);
        System.out.print("3-bit with more 1s: ");
        nBitMoreOnes("", 0, 0, 3);
        System.out.println();
        System.out.println("Remove adj duplicates 'aabbcc': " + removeAdjacentDuplicates("aabbcc"));

        System.out.println("\n--- Section 4: Arrays ---");
        int[] a = {4, 1, 9, 3, 7};
        System.out.println("Largest: " + largestInArray(a));
        System.out.println("Smallest: " + smallestInArray(a));
        System.out.println("2nd Smallest: " + secondSmallest(a));
        System.out.println("Sum: " + arraySum(a));
        reverseArray(a);
        System.out.println("Reversed: " + Arrays.toString(a));
        sortHalves(new int[]{3,1,4,1,5,9,2,6});
        sortArray(new int[]{5,3,1,4,2});
        int[] freq = {1,2,2,3,3,3};
        System.out.println("Frequency of elements:");
        frequencyOfElements(freq);
        sortByFrequency(new int[]{2,3,2,4,3,3});
        System.out.println("Longest palindrome: " + longestPalindromeInArray(new String[]{"abc","racecar","level","hi"}));
        System.out.println("Distinct count: " + countDistinct(new int[]{1,2,2,3,3,3}));
        repeatingElements(new int[]{1,2,3,2,4,3});
        nonRepeatingElements(new int[]{1,2,3,2,4,3});
        System.out.println("Remove duplicates: " + Arrays.toString(removeDuplicates(new int[]{1,2,2,3})));
        System.out.println("Min scalar product: " + minScalarProduct(new int[]{1,3,5}, new int[]{2,4,1}));
        System.out.println("Max scalar product: " + maxScalarProduct(new int[]{1,3,5}, new int[]{2,4,1}));
        countEvenOdd(new int[]{1,2,3,4,5,6});
        symmetricPairs(new int[][]{{1,2},{3,4},{2,1},{4,3}});
        System.out.println("Max product subarray: " + maxProductSubarray(new int[]{2,3,-2,4}));
        System.out.println("Disjoint: " + areDisjoint(new int[]{1,2,3}, new int[]{4,5,6}));
        System.out.println("Subset: " + isSubset(new int[]{1,2,3,4}, new int[]{2,4}));
        System.out.println("Equilibrium index: " + equilibriumIndex(new int[]{-7,1,5,2,-4,3,0}));
        rotateLeft(new int[]{1,2,3,4,5}, 2);
        jugglingRotate(new int[]{1,2,3,4,5,6,7,8,9,10,11,12}, 3);
        circularRotation(new int[]{1,2,3,4,5}, 2);
        System.out.println("Balanced '{[()]}': " + balancedParenthesis("{[()]}"));
        System.out.println("Balanced '{[(])}': " + balancedParenthesis("{[(])}"));
        replaceByRank(new int[]{20,15,26,2,98,6});

        System.out.println("\n--- Section 5: Strings ---");
        System.out.println("'a' is: " + vowelOrConsonant('a'));
        System.out.println("'b' is alphabet: " + isAlphabet('b'));
        System.out.println("ASCII of 'A': " + asciiValue('A'));
        System.out.println("Length of 'hello' (manual): " + lengthWithoutFunction("hello"));
        System.out.println("Toggle 'HeLLo': " + toggleCase("HeLLo"));
        System.out.println("Vowels in 'programming': " + countVowels("programming"));
        System.out.println("Remove vowels: " + removeVowels("Hello World"));
        System.out.println("'racecar' palindrome: " + isPalindromeStr("racecar"));
        System.out.println("Reverse 'Java': " + reverseString("Java"));
        System.out.println("Keep alpha 'h3ll0 W0rld': " + keepOnlyAlpha("h3ll0 W0rld"));
        System.out.println("Remove spaces 'a b c': " + removeSpaces("a b c"));
        System.out.println("Remove brackets '(a+b)': " + removeBrackets("(a+b)"));
        System.out.println("Sum of numbers in 'a12b3': " + sumOfNumbersInString("a12b3"));
        System.out.println("Capitalize 'hello world': " + capitalizeFirstLast("hello world"));
        System.out.println("Char frequency of 'aabbcc':");
        charFrequency("aabbcc");
        nonRepeatingChars("aabbcd");
        System.out.println("'listen'&'silent' anagram: " + isAnagram("listen", "silent"));
        System.out.println("Replace sub: " + replaceSubstring("hello world", "world", "Java"));
        System.out.println("Replace word: " + replaceWord("I love Java and Java", "Java", "Python"));
        System.out.println("Wildcard 'aa' matches 'a*': " + wildcardMatch("aa", "a*"));
        System.out.print("Lex permutations of 'CAB': ");
        lexicographicPermutations("CAB");

        System.out.println("\n========== ALL 127 SOLUTIONS COMPLETE ==========");
    }
}
