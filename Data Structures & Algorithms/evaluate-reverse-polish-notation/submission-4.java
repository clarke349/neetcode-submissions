class Solution {
    public int evalRPN(String[] tokens) {
        Set<String> operators = new HashSet<>(Set.of("+", "-", "*", "/"));
        Deque<Integer> exp = new ArrayDeque<>();

        for (int i = 0; i < tokens.length; i++) {
            String s = tokens[i];

            if (operators.contains(s) && !exp.isEmpty()) {
                int num2 = exp.pop();
                int num1 = exp.pop();
                exp.push(calculate(num1, num2, s));
            } else {
                exp.push(Integer.parseInt(s));
            }
        }

        return exp.peek();
    }

    private int calculate(int operand1, int operand2, String operator) {
        if (operator.equals("+")) {
            return operand1 + operand2;
        } else if (operator.equals("-")) {
            return operand1 - operand2;
        } else if (operator.equals("*")) {
            return operand1 * operand2;
        } else {
            return operand1 / operand2;
        }
    }
}
