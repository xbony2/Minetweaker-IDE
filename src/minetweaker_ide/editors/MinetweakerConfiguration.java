package minetweaker_ide.editors;

import minetweaker_ide.editors.scanner.MinetweakerPartitionScanner;
import minetweaker_ide.editors.scanner.MinetweakerScanner;
import minetweaker_ide.editors.scanner.MinetweakerTagScanner;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextDoubleClickStrategy;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;

public class MinetweakerConfiguration extends SourceViewerConfiguration {
	private MinetweakerDoubleClickStrategy doubleClickStrategy;
	private MinetweakerTagScanner tagScanner;
	private MinetweakerScanner scanner;
	private ColorManager colorManager;

	public MinetweakerConfiguration(ColorManager colorManager) {
		this.colorManager = colorManager;
	}
	public String[] getConfiguredContentTypes(ISourceViewer sourceViewer) {
		return new String[] { IDocument.DEFAULT_CONTENT_TYPE,
				MinetweakerPartitionScanner.ZS_COMMENT, MinetweakerPartitionScanner.ZS_TAG };
	}
	public ITextDoubleClickStrategy getDoubleClickStrategy(ISourceViewer sourceViewer, String contentType) {
		if (doubleClickStrategy == null)
			doubleClickStrategy = new MinetweakerDoubleClickStrategy();
		return doubleClickStrategy;
	}

	protected MinetweakerScanner getZSScanner() {
		if (scanner == null) {
			scanner = new MinetweakerScanner(colorManager);
			scanner.setDefaultReturnToken(new Token(new TextAttribute(colorManager.getColor(ZSReferences.DEFAULT))));
		}
		return scanner;
	}
	protected MinetweakerTagScanner getZSTagScanner() {
		if (tagScanner == null) {
			tagScanner = new MinetweakerTagScanner(colorManager);
			tagScanner.setDefaultReturnToken(new Token(new TextAttribute(colorManager.getColor(ZSReferences.TAG))));
		}
		return tagScanner;
	}

	public IPresentationReconciler getPresentationReconciler(ISourceViewer sourceViewer) {
		PresentationReconciler reconciler = new PresentationReconciler();

		DefaultDamagerRepairer dr = new DefaultDamagerRepairer(getZSTagScanner());
		reconciler.setDamager(dr, MinetweakerPartitionScanner.ZS_TAG);
		reconciler.setRepairer(dr, MinetweakerPartitionScanner.ZS_TAG);

		dr = new DefaultDamagerRepairer(getZSScanner());
		reconciler.setDamager(dr, IDocument.DEFAULT_CONTENT_TYPE);
		reconciler.setRepairer(dr, IDocument.DEFAULT_CONTENT_TYPE);

		NonRuleBasedDamagerRepairer ndr = 
				new NonRuleBasedDamagerRepairer(new TextAttribute(colorManager.getColor(ZSReferences.ZS_COMMENT)));
		reconciler.setDamager(ndr, MinetweakerPartitionScanner.ZS_COMMENT);
		reconciler.setRepairer(ndr, MinetweakerPartitionScanner.ZS_COMMENT);

		return reconciler;
	}

}