package src.stack;

public class Expression {

    public boolean isValidExpr(String expr) {
        int n = expr.length();
        Stack stack = new LinkedListStack();
        for (int i = 0; i < n; i++) {
            if (expr.charAt(i) == '(') {
                stack.push(i);
            }

            if (expr.charAt(i) == ')' && !stack.isEmpty()) {
                stack.push(i);
            } else if (expr.charAt(i) == ')' && stack.isEmpty()) {
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {

        Expression expr = new Expression();
        String f = "a+b-c(3+a)";
        System.out.println(expr.isValidExpr(f));

    }
}
