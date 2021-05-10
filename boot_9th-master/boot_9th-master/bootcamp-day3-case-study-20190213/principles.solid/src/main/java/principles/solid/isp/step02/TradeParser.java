package principles.solid.isp.step02;

import java.util.ArrayList;
import java.util.List;

public class TradeParser {
	
	TradeValidator validator;
	TradeConverter converter;
	
	public TradeParser(TradeValidator validator, TradeConverter converter) {
		this.validator = validator;
		this.converter = converter;
	}
	
	public List<Trade> parse(List<String> lines) {
		return parseTrade(lines);
	}
	
	private List<Trade> parseTrade(List<String> lines) {
		List<Trade> trades = new ArrayList<Trade>();
		String[] fields;
		
		
		
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
