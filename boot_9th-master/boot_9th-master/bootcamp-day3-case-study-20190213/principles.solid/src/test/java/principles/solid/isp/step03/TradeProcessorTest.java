package principles.solid.isp.step03;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TradeProcessorTest {
	
	String srcFilename = "src/main/resources/principles/solid/Trade.dat";
	String dstFolder   = "src/test/resources/principles/solid/isp/step03";
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
		
		TradeReadOnlyStore tradeStore = new TradeFileStore();
		try {
			List<String> trades = tradeStore.retrieveTrades("src/test/resources/principles/solid/isp/step03/TradeTransformed.dat");
			System.out.println(trades.toString());
			Assert.assertTrue(true);
		} catch (IOException e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
}
