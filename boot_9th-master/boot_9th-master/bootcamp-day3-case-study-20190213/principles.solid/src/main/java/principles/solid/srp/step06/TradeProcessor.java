package principles.solid.srp.step06;

import java.io.IOException;
import java.util.List;

public class TradeProcessor {
	
	public void processTrades(String srcFilename, String dstFilename) throws IOException {
		//
		List<String> lines = (new TradeProvider()).readTradeLines(srcFilename);
		List<Trade> trades = (new TradeParser()).parse(lines);
		(new TradeStore()).saveTrades(trades, dstFilename);
	}
	
}
