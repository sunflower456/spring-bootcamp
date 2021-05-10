package principles.solid.isp.step03;

import java.io.IOException;
import java.util.List;

public interface TradeStore {

	public void saveTrades(List<Trade> trades, String dstFilename) throws IOException;
	
}
