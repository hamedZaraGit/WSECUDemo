package org.wsecu.test.pages;
import org.wsecu.base.BaseSetup;
public class POMFactory extends BaseSetup {
	
	private static POMFactory pomFactory;
	private wsecuPages wsecuPOM;

	private POMFactory() {
		this.wsecuPOM = new wsecuPages();
	}

	public static POMFactory getPomFactory() {
		if(pomFactory == null) {
			pomFactory = new POMFactory();
		}
		return pomFactory;
	}
	

	
	public wsecuPages getDemoPage() {
		return this.wsecuPOM;
	}

}
