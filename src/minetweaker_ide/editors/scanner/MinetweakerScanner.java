package minetweaker_ide.editors.scanner;

import minetweaker_ide.editors.ColorManager;
import minetweaker_ide.editors.IMinetweakerColorConstants;
import minetweaker_ide.editors.detectors.MinetweakerWhitespaceDetector;

import org.eclipse.jface.text.rules.*;
import org.eclipse.jface.text.*;

public class MinetweakerScanner extends RuleBasedScanner {

	public MinetweakerScanner(ColorManager manager) {
		IToken procInstr = new Token(new TextAttribute(manager.getColor(IMinetweakerColorConstants.ZS_COMMENT)));
		IToken keyword = new Token(new TextAttribute(manager.getColor(IMinetweakerColorConstants.KEYWORD)));

		IRule[] rules = new IRule[4];
		rules[0] = new EndOfLineRule("#", procInstr);
		rules[1] = new EndOfLineRule("//", procInstr);
		rules[2] = new WordRule(null, keyword);
		rules[3] = new WhitespaceRule(new MinetweakerWhitespaceDetector());

		setRules(rules);
	}
}
