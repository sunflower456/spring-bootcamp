package principles.solid.ocp.step04;

import java.io.IOException;

public interface TradeProcessor {
	
	public abstract void processTrades(String srcFilename, String dstFilename) throws IOException;
	
}
