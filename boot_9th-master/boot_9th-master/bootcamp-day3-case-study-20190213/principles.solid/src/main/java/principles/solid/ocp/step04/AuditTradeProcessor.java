package principles.solid.ocp.step04;

import java.io.IOException;
import java.util.List;

public class AuditTradeProcessor implements TradeProcessor {

	public void processTrades(String srcFilename, String dstFilename) throws IOException {
		//
		List<String> lines = readTrades(srcFilename);
		List<Trade> trades = parse(lines);
		saveTrades(trades, dstFilename);
	}
	
	public List<String> readTrades(String srcFilename) throws IOException {
		List<String> lines = (new TradeProvider()).readTradeLines(srcFilename);
		(new TradeLogger()).logInfo("readTrades() complete.");
		return lines;
	}

	public List<Trade> parse(List<String> lines) {
		List<Trade> trades = (new TradeParser()).parse(lines);
		(new TradeLogger()).logInfo("parse() complete.");
		return trades;
	}

	public void saveTrades(List<Trade> trades, String dstFilename) throws IOException {
		(new TradeStore()).saveTrades(trades, dstFilename);
		(new TradeLogger()).logInfo("saveTrades() complete.");
	}

}
