package minetweaker_ide.editors;

import org.eclipse.ui.editors.text.TextEditor;

public class MinetweakerEditor extends TextEditor {

	private ColorManager colorManager;

	public MinetweakerEditor() {
		super();
		colorManager = new ColorManager();
		setSourceViewerConfiguration(new MinetweakerConfiguration(colorManager));
		setDocumentProvider(new MinetweakerDocumentProvider());
	}
	public void dispose() {
		colorManager.dispose();
		super.dispose();
	}

}
