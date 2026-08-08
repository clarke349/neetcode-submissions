class Solution {
    public int evalRPN(String[] tokens) {
        Set<String> operators = new HashSet<>(Set.of("+", "-", "*", "/"));
        Deque<Integer> exp = new ArrayDeque<>();

        for (int i = 0; i < tokens.length; i++) {
            String str = tokens[i];
            if (operators.contains(str) && !exp.isEmpty()){
                int num2 = exp.pop();
                int num1 = exp.pop();
                exp.push(calculate(num1, num2, str));
            } else {
                exp.push(Integer.parseInt(str));
            }
        }

        return exp.peek();
    }

    public int calculate(int num1, int num2, String operator){
        if (operator.equals("+")){
            return num1 + num2;
        } else if (operator.equals("-")){
            return num1 - num2;
        } else if (operator.equals("*")){
            return num1 * num2;
        } else if (operator.equals("/")){
            return num1 / num2;
        } else{
            return 0;
        }
    }
}
