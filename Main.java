package techinterview;

public class Main {

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

