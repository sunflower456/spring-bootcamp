package principles.solid.dip.step02;

import java.io.IOException;
import java.util.List;

public class SimpleTradeProcessor extends TradeProcessor {
	
	public SimpleTradeProcessor(TradeProvider provider, TradeParser parser, TradeStore store, Logger logger) {
		super(provider, parser, store, logger);
	}

	@Override
	public List<String> readTrades(String srcFilename) throws IOException {
		return provider.readTradeLines(srcFilename);
	}

	@Override
	public List<Trade> parse(List<String> lines) {
		return parser.parse(lines);
	}

	@Override
	public void saveTrades(List<Trade> trades, String dstFilename) throws IOException {
		store.saveTrades(trades, dstFilename);
	}

}
