package principles.solid.dip.step01;

import java.io.IOException;
import java.util.List;

public class AuditTradeProcessor extends TradeProcessor {
	
	String dstFolder   = "src/test/resources/principles/solid/lsp/step02";
	String dstFilename = "Trade.log";
	
	private Logger logger = new TradeFileLogger(dstFolder, dstFilename);

	@Override
	public List<String> readTrades(String srcFilename) throws IOException {
		List<String> lines = (new TradeProvider()).readTradeLines(srcFilename);
		logger.logInfo("readTrades() complete.");
		return lines;
	}

	@Override
	public List<Trade> parse(List<String> lines) {
		List<Trade> trades = (new TradeParser()).parse(lines);
		logger.logInfo("parse() complete.");
		return trades;
	}

	@Override
	public void saveTrades(List<Trade> trades, String dstFilename) throws IOException {
		(new TradeStore()).saveTrades(trades, dstFilename);
		logger.logInfo("saveTrades() complete.");
	}

}
