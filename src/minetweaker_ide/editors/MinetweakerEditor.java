package minetweaker_ide.editors;

import org.eclipse.ui.editors.text.TextEditor;

public class MinetweakerEditor extends TextEditor {

	private ColorManager colorManager;

	public MinetweakerEditor() {
		super();
		colorManager = new ColorManager();
		this.setSourceViewerConfiguration(new MinetweakerConfiguration(colorManager));
		this.setDocumentProvider(new MinetweakerDocumentProvider());
	}
	
	public void dispose() {
		colorManager.dispose();
		super.dispose();
	}

}
