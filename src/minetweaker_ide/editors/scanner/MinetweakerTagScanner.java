package minetweaker_ide.editors.scanner;

import minetweaker_ide.editors.ColorManager;
import minetweaker_ide.editors.detectors.MinetweakerWhitespaceDetector;

import org.eclipse.jface.text.*;
import org.eclipse.jface.text.rules.*;

public class MinetweakerTagScanner extends RuleBasedScanner {

	public MinetweakerTagScanner(ColorManager manager) {
		IRule[] rules = new IRule[1];
		// Add generic whitespace rule.
		rules[0] = new WhitespaceRule(new MinetweakerWhitespaceDetector());

		setRules(rules);
	}
}
