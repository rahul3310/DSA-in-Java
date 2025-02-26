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
    public static int d = 256, q = 101;

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

}
