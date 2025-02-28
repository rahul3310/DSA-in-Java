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

        for (int i = 0; i < m; i++) {
            countTxt[i]++;
            countPat[i]++;
        }
        for (int i = pat.length(); i < n; i++) {
            if (areSame(countTxt, countPat)) return true;
            countTxt[txt.charAt(i)]++;
            countTxt[txt.charAt(i - pat.length())]--;
        }
        return false;
    }

    static boolean areSame(int[] CT, int[] CP) {
        for (int i = 0; i < CHAR; i++) {
            if (CT[i] != CP[i]) return false;
        }
        return true;
    }

}
