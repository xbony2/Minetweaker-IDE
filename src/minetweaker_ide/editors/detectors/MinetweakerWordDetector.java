package minetweaker_ide.editors.detectors;

import org.eclipse.jface.text.rules.IWordDetector;

public class MinetweakerWordDetector implements IWordDetector{

	@Override
	public boolean isWordStart(char character){
		return Character.isJavaIdentifierPart(character);
	}

	@Override
	public boolean isWordPart(char character){
		return Character.isJavaIdentifierPart(character);
	}
}
