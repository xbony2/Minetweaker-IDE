package minetweaker_ide.editors.scanner;

import minetweaker_ide.editors.detectors.MinetweakerWordDetector;
import org.eclipse.jface.text.rules.WordRule;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.Token;
import minetweaker_ide.editors.ColorManager;
import minetweaker_ide.editors.ZSReferences;
import minetweaker_ide.editors.detectors.MinetweakerWhitespaceDetector;
import org.eclipse.jface.text.rules.*;
import org.eclipse.jface.text.*;

public class MinetweakerScanner extends RuleBasedScanner {
	public MinetweakerScanner(ColorManager manager) {
		IToken comments = new Token(new TextAttribute(manager.getColor(ZSReferences.ZS_COMMENT)));
		IToken keywords = new Token(new TextAttribute(manager.getColor(ZSReferences.KEYWORD)));

		IRule[] rules = new IRule[4];
		rules[0] = new EndOfLineRule("#", comments);
		rules[1] = new EndOfLineRule("//", comments);
		rules[2] = new WhitespaceRule(new MinetweakerWhitespaceDetector());
		
		WordRule wordRule = new WordRule(new MinetweakerWordDetector(), Token.WHITESPACE);
		for(String keyword : ZSReferences.KEYWORDS)
			wordRule.addWord(keyword, keywords);
		
		rules[3] = wordRule;
		
		setRules(rules);
	}
}
