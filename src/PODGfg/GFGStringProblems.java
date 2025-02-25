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


}
