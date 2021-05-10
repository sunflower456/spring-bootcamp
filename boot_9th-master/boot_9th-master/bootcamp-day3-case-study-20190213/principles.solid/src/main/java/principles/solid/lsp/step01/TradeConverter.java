package principles.solid.lsp.step01;

public class TradeConverter {
	
	private static float LOT_SIZE = 100000f;
	
	public Trade convertToTrade(String[] fields) {
		int amount = Integer.parseInt(fields[1]);
		float price = Float.parseFloat(fields[2]);
		String srcCurrencyCode = fields[0].substring(0, 3);
		String dstCurrencyCode = fields[0].substring(3, 6);
		
		return new Trade(srcCurrencyCode, dstCurrencyCode, amount/LOT_SIZE, price);
	}

}
