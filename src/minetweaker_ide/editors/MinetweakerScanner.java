package minetweaker_ide.editors;

import minetweaker_ide.editors.detectors.MinetweakerWhitespaceDetector;

import org.eclipse.jface.text.rules.*;
import org.eclipse.jface.text.*;

public class MinetweakerScanner extends RuleBasedScanner {

	public MinetweakerScanner(ColorManager manager) {
		IToken procInstr = new Token(new TextAttribute(manager.getColor(IMinetweakerColorConstants.ZS_COMMENT)));

		IRule[] rules = new IRule[3];
		rules[0] = new EndOfLineRule("#", procInstr);
		rules[1] = new EndOfLineRule("//", procInstr);
		rules[2] = new WhitespaceRule(new MinetweakerWhitespaceDetector());

		setRules(rules);
	}
}
