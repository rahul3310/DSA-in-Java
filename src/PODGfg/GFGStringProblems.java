package PODGfg;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class GFGStringProblems {

    /**
     * Pattern searching
     */
    public int patternSearching(String text, String pat) {
        int n = text.length(), m = pat.length();

        for (int i = 0; i <= n - m; ) {
            int j;
            for (j = 0; j < m; j++) {
                if (pat.charAt(j) != text.charAt(i + j)) {
                    break;
                }
            }

            // If the entire pattern was matched
            if (j == m) return i; // Pattern found at index i

            if (j == 0) i++;
            else i = i + j;
        }

        return -1; // Pattern not found
    }

    /**
     * Rabin Karp Algorithm
     */
    public static int d = 10, q = 5;

    public void rabinKarpAlgo(String txt, String pat) {
        int n = txt.length(), m = pat.length();

        //Calculate the hash function for the computation (h = (d^m-1)%q
        int h = 1;
        for (int i = 1; i <= m - 1; i++) {
            h = (h * d) % q;
        }

        //Calculate the hash value
        int p = 0, t = 0;
        for (int i = 0; i < m; i++) {
            p = (p * d + pat.charAt(i)) % q;
            t = (t * d + txt.charAt(i)) % q;
        }

        for (int i = 0; i < n - m + 1; i++) {
            //check for the hit
            if (p == t) {
                boolean flag = true;
                for (int j = 0; j < m; j++) {
                    if (txt.charAt(i + j) != pat.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) System.out.println("Found at index i : " + i);
            }

            //now not a hit then move to next substring
            //Calculate hash value of ti+1 using hash value of ti

            if (i < n - m) {
                t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + m)) % q;
                if (t < 0) t = t + q;
            }
        }
    }

    /**
     * KMP (Knuth-Morris-Pratt) Algorithm
     * Idea behind is that there should be a proper prefix that is also is a suffix of a string with greater length
     */
    public void KMPAlgorithm(String txt, String pat) {
        int n = txt.length(), m = pat.length();
        int[] lps = new int[m];

        fillLPSArray(lps, pat);  //Preprocess the LPS Array

        int i = 0, j = 0;
        while (i < n) {
            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            } else {
                if (j == 0) i++;
                else {
                    j = lps[j - 1];  //When mismatch occurs we bring the pattern window where the last character matched
                }
            }

            if (j == m) {
                System.out.println("Found at : " + (i - j));
                j = lps[j - 1];
            }

        }
    }


    private void fillLPSArray(int[] lps, String pat) {
        int n = pat.length(), len = 0;
        lps[0] = 0;

        int i = 1;
        while (i < n) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;  //there exist prefix which is also as suffix
                lps[i] = len;
                i++;
            } else {
                if (len == 0) {
                    lps[i] = 0;  //there does not exit prefix which is also as suffix
                    i++;
                } else {
                    len = lps[len - 1];
                }
            }
        }
    }

    /**
     * Anagram Strings
     */
    public boolean areAnagram(String s1, String s2) {
        int[] count = new int[26];  //assume all characters are in lowercase

        for (int i = 0; i < s1.length(); i++) {
            count[(s1.charAt(i) - 'a')]++;    //count[s1.charAt(i) - 'a'] = count[s1.charAt(i) - 'a'] + 1;
        }

        //decrease the count w.r.t character
        for (int i = 0; i < s2.length(); i++) {
            count[(s2.charAt(i) - 'a')]--;    //count[s2.charAt(i) - 'a'] = count[s2.charAt(i) - 'a'] - 1;
        }

        //Now check if any value in count array is not 0 means that character not present in s2.
        for (int j : count) {
            if (j != 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * Anagram Search
     */

    static final int CHAR = 256;

    public boolean anagramSearch(String txt, String pat) {
        int n = txt.length(), m = pat.length();

        int[] countTxt = new int[CHAR];
        int[] countPat = new int[CHAR];

        //For first window match
        for (int i = 0; i < m; i++) {
            countTxt[i]++;
            countPat[i]++;
        }

        //for next window
        for (int i = pat.length(); i < n; i++) {
            if (areSame(countTxt, countPat)) return true;
            countTxt[txt.charAt(i)]++;   //add the first character of the new window
            countTxt[txt.charAt(i - pat.length())]--;  //remove the first character of the previous window
        }
        return false;
    }

    private boolean areSame(int[] CT, int[] CP) {
        for (int i = 0; i < CHAR; i++) {
            if (CT[i] != CP[i]) return false;
        }
        return true;
    }


    /**
     * Count lexicographic string smaller than given string + 1 is our result
     */
    public void lexicographicRankingOfString(String txt) {
        int[] count = new int[CHAR];
        int n = txt.length();
        int result = 1;
        int multiplier = fact(n); //Precompute the total String possible

        //Now count the Character in the String
        for (int i = 0; i < n; i++) {
            count[txt.charAt(i)]++;
            if (count[txt.charAt(i)] > 1) return;  //TO handle duplicate
        }

        //we are calculating the cumulative count So that we can find the
        //smaller character on the right side in linear time
        for (int i = 1; i < CHAR; i++) {
            count[i] += count[i - 1];
        }

        //Now Calculate the smaller String possible the Idea is that
        //Find the number of smaller character in the  string in linear time

        for (int i = 0; i < n - 1; i++) {
            multiplier = multiplier / (n - i);  //calculate for number of string possible with character

            result = result + count[txt.charAt(i) - 1] * multiplier;  //count[txt.charAt(i) - 1] this calculate the count of smaller character from text.charAt(i)
            for (int j = txt.charAt(i); j < CHAR; j++) {     // Reduce count of characters greater than S[i]
                count[j]--;                                  //This ensures that when processing the next character, it doesn't consider characters that have already been counted.
            }

        }

        System.out.println("Rank of given Text is : " + result);
    }


    private int fact(int n) {
        if (n == 0 || n == 1) return 1;
        return n * fact(n - 1);
    }

    /**
     * Find the length of longest sub-string with distinct characters
     */
    public int longestSubString(String txt) {
        int n = txt.length(), res = 1;

        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[CHAR]; //re-initialized the Array after one iteration completed
            for (int j = i; j < n; j++) {
                if (visited[txt.charAt(j)]) {
                    break;
                } else {
                    res = Math.max(res, j - i + 1);
                    visited[txt.charAt(j)] = true;
                }
            }
        }

        return res;
    }

    public int longestSubString2(String str) {
        int n = str.length(), res = 1;
        int[] prev = new int[CHAR];

        //First the default value is -1
        Arrays.fill(prev, -1);

        int start = 0;
        for (int j = 0; j < n; j++) {
            start = Math.max(start, prev[str.charAt(j)] + 1);
            int maxEnd = j - start + 1;
            res = Math.max(res, maxEnd);
            prev[str.charAt(j)] = j;
        }

        return res;
    }

    /**
     * Keypad typing Problem
     */
    public String keypadTyping(String str) {
        StringBuilder s = new StringBuilder();
        // Mapping letters to digits based on T9 keypad
        int[] mapping = {
                2, 2, 2,  // a, b, c
                3, 3, 3,  // d, e, f
                4, 4, 4,  // g, h, i
                5, 5, 5,  // j, k, l
                6, 6, 6,  // m, n, o
                7, 7, 7, 7, // p, q, r, s
                8, 8, 8,  // t, u, v
                9, 9, 9, 9 // w, x, y, z
        };

        // Convert each character to its corresponding digit
        for (char ch : str.toCharArray()) {
            s.append(mapping[ch - 'a']);  // Direct array lookup
        }
        return s.toString();
    }

    public char nonRepeatingChar(String s) {
        int n = s.length();

        int[] count = new int[256];

        for (char ch : s.toCharArray()) {
            count[ch]++;
        }

        for (char ch : s.toCharArray()) {
            if (count[ch] == 1) return ch;
        }
        return '$';
    }

    /**
     * String rotation of each other
     */
    public void stringRotation(String s1, String s2) {
        //The concept is that the string s2 after any number of rotation is present in the s1+s1 string
        //If not found means it is not rotation of s1
        String temp = s1.concat(s1);
        KMPAlgorithm(temp, s2);
    }


    /**
     * Isomorphic Strings e.g. aab == xxy
     */

    public boolean isIsomorphicString(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        HashMap<Character, Integer> m1 = new HashMap<>();
        HashMap<Character, Integer> m2 = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            if (!m1.containsKey(s1.charAt(i))) {
                m1.put(s1.charAt(i), i);
            }

            if (!m2.containsKey(s2.charAt(i))) {
                m2.put(s2.charAt(i), i);
            }

            //Compare the occurrence
            if (!m1.get(s1.charAt(i)).equals(m2.get(s2.charAt(i)))) {
                return false;
            }
        }

        return true;
    }

    //Function to find minimum number of characters which Ishaan must insert
    //such that string doesn't have three consecutive same characters.
    public void modified(String a) {
        long result = 0;
        int i = 0, n = a.length();
        while (i < n - 2) {
            if (a.charAt(i) == a.charAt(i + 1) && a.charAt(i) == a.charAt(i + 2)) {
                result++;
                i = i + 2;
            } else {
                i++;
            }
        }

        System.out.println("Character need to be added : " + result);
    }

    // Function to find the smallest window in the string s consisting
    // of all the characters of string p

    public String smallestWindow(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[] required = new int[256];
        int startInd = -1, count = 0, minLen = Integer.MAX_VALUE;

        StringBuilder smallestWindow = new StringBuilder();

        //fill the all array which tells us the required character to be matched

        for (int i = 0; i < m; i++) {
            required[s2.charAt(i)]++;
        }

        //Now apply the sliding window concept to match the characters

        int l = 0, r = 0;

        while (r < n) {

            //If the character exist in the map means one match
            //found So increase the count and decrease the character count
            //which indicates we remove that character

            if (required[s1.charAt(r)] > 0) count++;

            required[s1.charAt(r)]--;  //we found So decrease

            //if the size of the count is same as the length of S2 string
            //means we found a valid window
            //now the task is to find the smallest window So we shrink the window
            //by moving 'l'

            while (count == m) {

                int len = r - l + 1;
                if (len < minLen) {
                    minLen = len;
                    startInd = l;
                }

                //Add the character to map to track the count
                //And move the 'l'

                required[s1.charAt(l)]++;

                //It indicates we still need to find that character
                //So our count decreases
                if (required[s1.charAt(l)] > 0) count--;

                l++;
            }

            r++;
        }

        if (startInd != -1) {
            for (int i = startInd; i < (startInd + minLen); i++) {
                smallestWindow.append(s1.charAt(i));
            }
        }

        return smallestWindow.toString();
    }

    public int stringToInt(String s) {
        int maxInt = Integer.MAX_VALUE;
        int minInt = Integer.MIN_VALUE;
        int n = s.length();

        int i = 0;
        boolean negative = false;
        //Ignore white leading space

        // Ignore leading whitespaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // Handle optional '+' or '-' sign
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            negative = (s.charAt(i) == '-');
            i++;
        }

        int result = 0;
        while (i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            int digit = s.charAt(i) - '0';

            // **Overflow Check Before Multiplication**
            if (result > (maxInt - digit) / 10) {
                return negative ? -minInt : maxInt;
            }

            result = result * 10 + digit;
            i++;
        }

        return negative ? -result : result;

    }

    /**
     * Add Two Binary String
     */

    public String addBinaryString(String s1, String s2) {
        StringBuilder result = new StringBuilder();

        s1 = removeLeadingZeros(s1);
        s2 = removeLeadingZeros(s2);

        int carry = 0, n = s1.length(), m = s2.length();

        if (m > n) {
            return addBinaryString(s2, s1);
        }

        int j = m - 1;

        for (int i = n - 1; i >= 0; i--) {
            int bit1 = s1.charAt(i) - '0';
            int bitSum = bit1 + carry;

            if (j >= 0) {
                int bit2 = s2.charAt(j) - '0';
                bitSum = bitSum + bit2;
                j--;
            }

            carry = bitSum / 2;
            bitSum = bitSum % 2;

            result.append(bitSum);
        }

        if (carry > 0) {
            result.append(carry);
        }

        return result.reverse().toString();
    }

    private String removeLeadingZeros(String s) {
        String res = "";

        int i = 0, n = s.length();

        while (i < n && s.charAt(i) == '0') {
            i++;
        }

        return (i == n) ? "0" : s.substring(i);
    }

    //Roman to Integer
    /** [@Leetcode-13]*/
    public int romanToInteger(String s) {
        int sum = 0;
        HashMap<Character, Integer> map = new LinkedHashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int n = s.length();
        int prev = 0;

        for (int i = n - 1; i >= 0; i--) {
            int curr = map.get(s.charAt(i));
            sum += (curr>prev)? curr : -curr;

            prev = curr;

        }

        return sum;
    }

    /** [@Leetcode-11]*/
    public int maxArea(int[] height) {
        int i = 0,j=height.length-1;

        int maxWater = 0;

        while(i<j){
            int l = Math.min(height[i],height[j]);
            int b = j-i;
            int water = l * b;
            maxWater = Math.max(maxWater,water);

            if(height[i]<height[j]) i++;
            else j--;
        }

        return maxWater;

    }


}
