package principles.solid.srp.step06;

import java.util.ArrayList;
import java.util.List;

public class TradeParser {
	
	private static float LOT_SIZE = 100000f;

	public List<Trade> parse(List<String> lines) {
		return parseTrade(lines);
	}
	
	private List<Trade> parseTrade(List<String> lines) {
		List<Trade> trades = new ArrayList<Trade>();
		String[] fields;
		for (String line: lines) {
			fields = line.split(",");
			
			if (!validateTrade(fields)) {
				continue;
			}
			
			Trade trade = convertToTrade(fields);
			trades.add(trade);
		}
		
		return trades;
	}
	
	private boolean validateTrade(String[] fields) {
		if (fields.length != 3) {
			logMessage("NotEnough fileds");
			return false;
		}
		
		if (fields[0].length() != 6) {
			logMessage("NotEnough length");
			return false;
		}
		
		try {
			Integer.parseInt(fields[1]);
		} catch (Exception e) {
			logMessage("amount is not number.");
			return false;
		}
		
		try {
			Float.parseFloat(fields[2]);
		} catch (Exception e) {
			logMessage("amount is not number.");
			return false;
		}
		
		return true;
	}
	
	private void logMessage(String message) {
		System.out.println(message);
	}
	
	private Trade convertToTrade(String[] fields) {
		int amount = Integer.parseInt(fields[1]);
		float price = Float.parseFloat(fields[2]);
		String srcCurrencyCode = fields[0].substring(0, 3);
		String dstCurrencyCode = fields[0].substring(3, 6);
		
		return new Trade(srcCurrencyCode, dstCurrencyCode, amount/LOT_SIZE, price);
	}
}
