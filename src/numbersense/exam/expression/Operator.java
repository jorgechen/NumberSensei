package numbersense.exam.expression;


import numbersense.exam.expression.number.NumberExpression;

/**
 * @author George Chen
 * @since 10/5/12 9:46 PM
 */
public interface Operator {
	NumberExpression add(NumberExpression other);
	NumberExpression subtract(NumberExpression other);
	NumberExpression multiply(NumberExpression other);
	NumberExpression divide(NumberExpression other);
}
