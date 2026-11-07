class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int m = num1.length();
        int n = num2.length();
        int[] product = new int[n + m]; // product is at most n + m digits.

        for (int i = m - 1; i >= 0; i--) {
            int d1 = num1.charAt(i) - '0'; // digit 1
            for (int j = n - 1; j >= 0; j--) {
                int d2 = num2.charAt(j) - '0';
                int sum = d1 * d2 + product[i + j + 1];

                product[i + j + 1] = sum % 10; // digit for this position
                product[i + j] += sum / 10; // carry to the postion on the left
            }
        }

        StringBuilder result = new StringBuilder();
        for (int digit : product) {
            if (result.length() == 0 && digit == 0) {
                continue; // skip leading zeros
            }
            result.append(digit);
        }
        return result.toString();
    }
}
