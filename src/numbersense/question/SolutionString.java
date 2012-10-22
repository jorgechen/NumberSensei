package numbersense.question;

/**
 * @author George Chen
 * @since 10/20/12 4:54 PM
 */
public class SolutionString extends Solution{
	private String text;

	public SolutionString(String text) {
		this.text = text;
	}

	@Override
	public String toText() {
		return text;
	}

}
