package principles.solid.dip.step02;

import java.io.File;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TradeProcessorTest {
	
	String srcFilename = "src/main/resources/principles/solid/Trade.dat";
	String dstFolder   = "src/test/resources/principles/solid/dip/step02";
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
		String logFolder   = "src/test/resources/principles/solid/dip/step02";
		String logFilename = "Trade.log";
		
		Logger logger = new TradeFileLogger(logFolder, logFilename);
		
		TradeValidator validator = new TradeValidator(logger);
		TradeConverter converter = new TradeConverter();
		
		TradeProvider provider = new TradeProvider();
		TradeParser parser = new TradeParser(validator, converter);
		TradeStore store = new TradeStore();
		
		TradeProcessor processor = new AuditTradeProcessor(provider, parser, store, logger);
		
		try {
			processor.processTrades(srcFilename, dstFolder + "/" + dstFilename);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
}
