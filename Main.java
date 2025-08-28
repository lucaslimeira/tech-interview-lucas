package techinterview;

public class Main {


    /**
     * Given a string S that consists of only alphanumeric characters and dashes. The string is separated into N + 1 groups by N dashes.
     * Also given an integer K. We want to reformat the string S, such that each group contains exactly K characters,
     * except for the first group, which could be shorter than K but still must contain at least one character.
     * Furthermore, a dash must be inserted between two groups, and you should convert all lowercase letters to uppercase.
     * Return the reformatted string.
     * Examples:
     * Input: S = “5F3Z-2e-9-w”, K = 4
     * Output: “5F3Z-2E9W”
     * Explanation: The string S has been split into two parts, each part has 4 characters.
     * Note that two extra dashes are not needed and can be removed.
     * Input: S = “2-5g-3-J”, K = 2
     * Output: “2-5G-3J”
     * Explanation: The string s has been split into three parts,
     * each part has 2 characters except the first part
     * as it could be shorter as mentioned above
     * @param args
     */

    public static void main(String[] args) {


        System.out.println(formatLicenseKey("5F3Z-2e-9-w", 4)); // 5F3Z-2E9W
        System.out.println(formatLicenseKey("2-5g-3-J", 2));    // 2-5G-3J
        System.out.println(formatLicenseKey("--a-a-a-a--", 2)); // AA-AA
        System.out.println(formatLicenseKey("--", 3));

    }


    //Input: S = “5F3Z-2e-9-w”, K = 4
    public static String formatLicenseKey(String input, int k) {
        //remove all dashes from input

        char[] chars = input.toCharArray();
        StringBuilder sbResult = new StringBuilder();

        int count = 0;
        for(int i = input.length() - 1; i >= 0; i--) {

            if (String.valueOf(chars[i]).equals("-")) {
                continue;
            }

            if (count < k) {
                sbResult.append(String.valueOf(chars[i]));
                count++;
            }

            if (count == k) {
                count = 0;
                if (i > 0) {
                    sbResult.append("-");
                }
            }
        }

        return sbResult.reverse().toString().toUpperCase();
    }
}
