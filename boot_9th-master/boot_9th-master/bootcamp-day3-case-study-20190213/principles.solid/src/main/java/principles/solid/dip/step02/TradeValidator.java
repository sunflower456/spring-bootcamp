package principles.solid.dip.step02;

public class TradeValidator {
	
	private Logger logger;
	
	public TradeValidator(Logger logger) {
		this.logger = logger;
	}
	
	public boolean validateTrade(String[] fields) {
		if (fields.length != 3) {
			logger.logInfo("NotEnough fileds");
			return false;
		}
		
		if (fields[0].length() != 6) {
			logger.logInfo("NotEnough length");
			return false;
		}
		
		try {
			Integer.parseInt(fields[1]);
		} catch (Exception e) {
			logger.logInfo("amount is not number.");
			return false;
		}
		
		try {
			Float.parseFloat(fields[2]);
		} catch (Exception e) {
			logger.logInfo("amount is not number.");
			return false;
		}
		
		return true;
	}
	
}
