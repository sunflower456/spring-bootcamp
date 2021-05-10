package principles.solid.ocp.step03;

import java.io.IOException;
import java.util.List;

import principles.solid.ocp.step03.Trade;
import principles.solid.ocp.step03.TradeParser;
import principles.solid.ocp.step03.TradeProvider;
import principles.solid.ocp.step03.TradeStore;

public class SimpleTradeProcessor extends TradeProcessor {

	@Override
	public List<String> readTrades(String srcFilename) throws IOException {
		return (new TradeProvider()).readTradeLines(srcFilename);
	}

	@Override
	public List<Trade> parse(List<String> lines) {
		return (new TradeParser()).parse(lines);
	}

	@Override
	public void saveTrades(List<Trade> trades, String dstFilename) throws IOException {
		(new TradeStore()).saveTrades(trades, dstFilename);
	}

}
