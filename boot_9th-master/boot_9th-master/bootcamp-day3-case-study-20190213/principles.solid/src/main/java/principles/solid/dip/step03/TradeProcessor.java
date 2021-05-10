package principles.solid.dip.step03;

import java.io.IOException;
import java.util.List;

public abstract class TradeProcessor {
	
	protected TradeProvider provider;
	protected TradeParser parser;
	protected TradeStore store;
	protected Logger logger;
	
	public TradeProcessor(TradeProvider provider, TradeParser parser, TradeStore store, Logger logger) {
		this.provider = provider;
		this.parser = parser;
		this.store = store;
		this.logger = logger;
	}
	
	public void processTrades(String srcFilename, String dstFilename) throws IOException {
		//
		List<String> lines = readTrades(srcFilename);
		List<Trade> trades = parse(lines);
		saveTrades(trades, dstFilename);
	}
	
	public abstract List<String> readTrades(String srcFilename) throws IOException;
	public abstract List<Trade> parse(List<String> lines);
	public abstract void saveTrades(List<Trade> trades, String dstFilename) throws IOException;
	
}
