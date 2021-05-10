package principles.solid.ocp.step01;

import java.util.ArrayList;
import java.util.List;

public class TradeParser {
	
	public List<Trade> parse(List<String> lines) {
		return parseTrade(lines);
	}
	
	private List<Trade> parseTrade(List<String> lines) {
		List<Trade> trades = new ArrayList<Trade>();
		String[] fields;
		
		TradeValidator validator = new TradeValidator();
		TradeConverter converter = new TradeConverter();
		
		for (String line: lines) {
			fields = line.split(",");
			
			if (!validator.validateTrade(fields)) {
				continue;
			}
			
			Trade trade = converter.convertToTrade(fields);
			trades.add(trade);
		}
		
		return trades;
	}
	
}
