package principles.solid.srp.step07;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.List;

public class TradeStore {

	public void saveTrades(List<Trade> trades, String dstFilename) throws IOException {
		File dstFile = new File(dstFilename);
		FileOutputStream fos = new FileOutputStream(dstFile);
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fos, Charset.forName("UTF-8")));
		for (Trade tradeItem: trades) {
			bufferedWriter.write(tradeItem.getSourceCurrencyCode() + "," + tradeItem.getDestinationCurrencyCode() + "," + String.valueOf(tradeItem.getLots()) + "," + String.valueOf(tradeItem.getPrice()));
			bufferedWriter.newLine();
		}
		bufferedWriter.close();
	}
}
