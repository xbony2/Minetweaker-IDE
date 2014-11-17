package minetweaker_ide.editors.detectors;

import org.eclipse.jface.text.rules.IWhitespaceDetector;

public class MinetweakerWhitespaceDetector implements IWhitespaceDetector {
	/**
	 * Checks if the following character is whitespace: a space, a tab, a new line, etc.
	 */
	public boolean isWhitespace(char c) {
		return (c == ' ' || c == '\t' || c == '\n' || c == '\r');
	}
}
