package minetweaker_ide.editors;

import org.eclipse.jface.text.*;
import org.eclipse.jface.text.rules.*;

public class MinetweakerTagScanner extends RuleBasedScanner {

	public MinetweakerTagScanner(ColorManager manager) {
		IToken string =
			new Token(
				new TextAttribute(manager.getColor(IMinetweakerColorConstants.STRING)));

		IRule[] rules = new IRule[3];

		// Add rule for double quotes
		rules[0] = new SingleLineRule("\"", "\"", string, '\\');
		// Add a rule for single quotes
		rules[1] = new SingleLineRule("'", "'", string, '\\');
		// Add generic whitespace rule.
		rules[2] = new WhitespaceRule(new MinetweakerWhitespaceDetector());

		setRules(rules);
	}
}
