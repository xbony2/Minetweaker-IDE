package minetweaker_ide.editors;

import org.eclipse.jface.text.rules.*;

public class MinetweakerPartitionScanner extends RuleBasedPartitionScanner {
	public final static String ZS_COMMENT = "__zs_comment";
	public final static String ZS_TAG = "__zs_tag";

	public MinetweakerPartitionScanner() {

		IToken zsComment = new Token(ZS_COMMENT);
		IToken tag = new Token(ZS_TAG);

		IPredicateRule[] rules = new IPredicateRule[2];

		rules[0] = new MultiLineRule("/*", "*/", zsComment);
		rules[1] = new TagRule(tag);

		setPredicateRules(rules);
	}
}
