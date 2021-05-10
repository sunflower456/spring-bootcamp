package principles.solid.isp.step01;

public class TradeConsoleLogger extends Logger {

	@Override
	public void logInfo(String message) {
		System.out.println(message);
	}
	
}
