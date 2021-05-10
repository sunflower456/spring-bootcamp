package principles.solid.isp.step02;

public class TradeProcessorFactory {

	public static TradeProcessor createInstance(ProcessorType processorType, LoggerType loggerType) {
		
		String logFolder   = "src/test/resources/principles/solid/isp/step02";
		String logFilename = "Trade.log";
		
		Logger logger = loggerType == LoggerType.File ? new TradeFileLogger(logFolder, logFilename) : new TradeConsoleLogger();
		
		TradeValidator validator = new TradeValidator(logger);
		TradeConverter converter = new TradeConverter();
		
		TradeProvider provider = new TradeProvider();
		TradeParser parser = new TradeParser(validator, converter);
		TradeStore store = new TradeStore();
		
		
		if (processorType == ProcessorType.Simple) {
			return new SimpleTradeProcessor(provider, parser, store, logger);
		} else if (processorType == ProcessorType.Audit) {
			return new AuditTradeProcessor(provider, parser, store, logger);
		} else {
			throw new RuntimeException("NoTypeTradeProcessor");
		}
	}
}
