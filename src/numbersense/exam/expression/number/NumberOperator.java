package numbersense.exam.expression.number;

/**
 * @author George Chen
 * @since 10/8/12 9:09 PM
 */
public interface NumberOperator {
	NumberExpression add(WholeNumber other);
	NumberExpression subtract(WholeNumber other);
	NumberExpression multiply(WholeNumber other);
	NumberExpression divide(WholeNumber other);

	NumberExpression add(Fraction other);
	NumberExpression subtract(Fraction other);
	NumberExpression multiply(Fraction other);
	NumberExpression divide(Fraction other);

	NumberExpression add(Decimal other);
	NumberExpression subtract(Decimal other);
	NumberExpression multiply(Decimal other);
	NumberExpression divide(Decimal other);

	NumberExpression add(MixedNumber other);
	NumberExpression subtract(MixedNumber other);
	NumberExpression multiply(MixedNumber other);
	NumberExpression divide(MixedNumber other);
}
