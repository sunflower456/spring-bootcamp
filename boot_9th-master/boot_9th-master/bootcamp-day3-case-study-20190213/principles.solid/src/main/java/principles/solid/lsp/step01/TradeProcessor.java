package principles.solid.lsp.step01;

import java.io.IOException;
import java.util.List;

public abstract class TradeProcessor {
	
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
