package principles.solid.lsp.step01;

import java.io.IOException;
import java.util.List;

public class AuditTradeProcessor extends TradeProcessor {

	@Override
	public List<String> readTrades(String srcFilename) throws IOException {
		List<String> lines = (new TradeProvider()).readTradeLines(srcFilename);
		(new TradeLogger()).logInfo("readTrades() complete.");
		return lines;
	}

	@Override
	public List<Trade> parse(List<String> lines) {
		List<Trade> trades = (new TradeParser()).parse(lines);
		(new TradeLogger()).logInfo("parse() complete.");
		return trades;
	}

	@Override
	public void saveTrades(List<Trade> trades, String dstFilename) throws IOException {
		(new TradeStore()).saveTrades(trades, dstFilename);
		(new TradeLogger()).logInfo("saveTrades() complete.");
	}

}
