package principles.solid.srp.step07;

public class TradeValidator {

	public boolean validateTrade(String[] fields) {
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
	
}
