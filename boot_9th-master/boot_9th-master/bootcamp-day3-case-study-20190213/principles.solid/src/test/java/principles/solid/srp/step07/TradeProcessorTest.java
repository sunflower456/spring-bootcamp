package principles.solid.srp.step07;

import java.io.File;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TradeProcessorTest {
	
	String srcFilename = "src/main/resources/principles/solid/Trade.dat";
	String dstFolder   = "src/test/resources/principles/solid/srp/step07";
	String dstFilename = "TradeTransformed.dat";
	
	@Before
	public void before() {
		File dstDirectory = new File(dstFolder);
		if (!dstDirectory.exists()) {
			dstDirectory.mkdirs();
		}
		
		File dstFile = new File(dstFolder + "/" + dstFilename);
		if (dstFile.exists()) {
			dstFile.delete();
		}
	}

	@Test
	public void testProcess() {
		//
		TradeProcessor processor = new TradeProcessor();
		
		try {
			processor.processTrades(srcFilename, dstFolder + "/" + dstFilename);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
}
