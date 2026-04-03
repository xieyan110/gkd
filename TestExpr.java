import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class TestExpr {
    public static void main(String[] args) {
        String[] testCases = {"540", "1700", "screenWidth * 0.5"};
        String[] vars = {"left", "top", "right", "bottom", "width", "height", "random", "screenWidth", "screenHeight"};
        
        for (String expr : testCases) {
            try {
                ExpressionBuilder builder = new ExpressionBuilder(expr);
                for (String v : vars) {
                    builder.variables(v);
                }
                Expression e = builder.build();
                for (String v : vars) {
                    e.setVariable(v, 0.0);
                }
                boolean valid = e.validate().isValid();
                System.out.println("'" + expr + "' -> valid: " + valid);
            } catch (Exception ex) {
                System.out.println("'" + expr + "' -> error: " + ex.getMessage());
            }
        }
    }
}
