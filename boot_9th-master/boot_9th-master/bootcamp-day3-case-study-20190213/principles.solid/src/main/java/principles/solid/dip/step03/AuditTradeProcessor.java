package principles.solid.dip.step03;

import java.io.IOException;
import java.util.List;

public class AuditTradeProcessor extends TradeProcessor {
	
	public AuditTradeProcessor(TradeProvider provider, TradeParser parser, TradeStore store, Logger logger) {
		super(provider, parser, store, logger);
	}

	@Override
	public List<String> readTrades(String srcFilename) throws IOException {
		List<String> lines = provider.readTradeLines(srcFilename);
		logger.logInfo("readTrades() complete.");
		return lines;
	}

	@Override
	public List<Trade> parse(List<String> lines) {
		List<Trade> trades = parser.parse(lines);
		logger.logInfo("parse() complete.");
		return trades;
	}

	@Override
	public void saveTrades(List<Trade> trades, String dstFilename) throws IOException {
		store.saveTrades(trades, dstFilename);
		logger.logInfo("saveTrades() complete.");
	}

}
