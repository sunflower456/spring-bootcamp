package principles.solid.isp.step02;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TradeProcessorTest {
	
	String srcFilename = "src/main/resources/principles/solid/Trade.dat";
	String dstFolder   = "src/test/resources/principles/solid/isp/step02";
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
		TradeProcessor processor = TradeProcessorFactory.createInstance(ProcessorType.Audit, LoggerType.Console);
		try {
			processor.processTrades(srcFilename, dstFolder + "/" + dstFilename);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test
	public void testRetrieveTrades() {
		//
		testProcess();
		
		TradeStore tradeStore = new TradeStore();
		try {
			tradeStore.retrieveTrades("src/test/resources/principles/solid/isp/step02/TradeTransformed.dat");
			Assert.assertTrue(true);
		} catch (IOException e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
}
