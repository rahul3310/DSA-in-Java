package PODGfg;

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
            }

            if (j == m) {
                System.out.println("Found at : " + (i - j));
                j = lps[j - 1];
            } else if (i < n && txt.charAt(i) != pat.charAt(j)) {
                if (j == 0) i++;
                else {
                    j = lps[j - 1];
                }
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
            count[(s2.charAt(i) - 'a')]++;    //count[s2.charAt(i) - 'a'] = count[s2.charAt(i) - 'a'] - 1;
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

        //For fist window match
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
            for (int j = txt.charAt(i); j < CHAR; j++) {
                count[j]--;
            }

        }

        System.out.println("Rank of given Text is : " + result);
    }


    private int fact(int n) {
        if (n == 0 || n == 1) return 1;
        return n * fact(n - 1);
    }

}
