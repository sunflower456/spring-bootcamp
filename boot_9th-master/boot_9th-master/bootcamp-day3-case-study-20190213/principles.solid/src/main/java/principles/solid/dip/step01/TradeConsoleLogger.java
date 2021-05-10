package principles.solid.dip.step01;

public class TradeConsoleLogger extends Logger {

	@Override
	public void logInfo(String message) {
		System.out.println(message);
	}
	
}
