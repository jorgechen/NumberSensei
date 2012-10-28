package numbersense.exam;

import numbersense.utility.Debugger;
import numbersense.utility.Randomizer;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author George Chen
 * @since 9/28/12 7:46 PM
 */
public class Composition {
	private ArrayList<Rule> rules;

	private HashSet<Rule> forbiddenRules;

	/**
	 * @param rules list of distinct rules
	 */
	public Composition(Rule[] rules) {
		this.rules = new ArrayList<Rule>();
		this.forbiddenRules = new HashSet<Rule>();

		for (Rule r : rules) {
			this.rules.add(r);
		}
	}

	public boolean isForbidden(Rule rule) {
		return forbiddenRules.contains(rule);
	}

	/**
	 * In one round, remove and deduct a random rule from the remaining rules we have in this composition
	 * @return
	 */
	public Rule removeNextRandomRule() {

		//Get array sizes
		int sizeRules = rules.size();
		int sizeForbidden = forbiddenRules.size();

		// Get a random rule
		int index = Randomizer.random(sizeRules);
		Rule rule = rules.get(index);


		// Each previous rule is forbidden from being used for the very next question, unless we run out of other rules
		if (sizeForbidden < sizeRules) {
			//TODO optimize randomization
			while (forbiddenRules.contains(rule)) {
				Debugger.p("Forbidden rule reached (i=" + index + "):" + rule.toString()); //DEBUG
				index = (index + 1) % sizeRules;
				rule = rules.get(index);
			}
		}

		// Deduct random rule
		rule.count--;
		if (rule.count == 0) {
			rules.remove(index);
		}

		// Add to forbidden rules for next round
		forbiddenRules.clear();
		forbiddenRules.add(rule);

		Debugger.p("Removed rule: " + rule.toString()); //DEBUG

		return rule;
	}


	public int countRemainingRules() {
		int count = 0;
		for (Rule r : rules) {
			count += r.count;
		}
		return count;
	}
}