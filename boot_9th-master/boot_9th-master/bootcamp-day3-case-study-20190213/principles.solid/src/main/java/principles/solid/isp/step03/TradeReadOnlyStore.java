package principles.solid.isp.step03;

import java.io.IOException;
import java.util.List;

public interface TradeReadOnlyStore {

	public List<String> retrieveTrades(String filename) throws IOException;
	
}
