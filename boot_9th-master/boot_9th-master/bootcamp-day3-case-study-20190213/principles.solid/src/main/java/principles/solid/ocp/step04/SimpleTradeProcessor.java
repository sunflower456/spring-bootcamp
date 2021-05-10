package principles.solid.ocp.step04;

import java.io.IOException;
import java.util.List;

import principles.solid.ocp.step03.Trade;
import principles.solid.ocp.step03.TradeParser;
import principles.solid.ocp.step03.TradeProvider;
import principles.solid.ocp.step03.TradeStore;

public class SimpleTradeProcessor implements TradeProcessor {
	
	public void processTrades(String srcFilename, String dstFilename) throws IOException {
		//
		List<String> lines = readTrades(srcFilename);
		List<Trade> trades = parse(lines);
		saveTrades(trades, dstFilename);
	}
	
	public List<String> readTrades(String srcFilename) throws IOException {
		return (new TradeProvider()).readTradeLines(srcFilename);
	}

	public List<Trade> parse(List<String> lines) {
		return (new TradeParser()).parse(lines);
	}

	public void saveTrades(List<Trade> trades, String dstFilename) throws IOException {
		(new TradeStore()).saveTrades(trades, dstFilename);
	}

}
