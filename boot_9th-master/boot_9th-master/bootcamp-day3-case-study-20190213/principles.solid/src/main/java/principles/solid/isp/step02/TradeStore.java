package principles.solid.isp.step02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class TradeStore {
	
	public List<String> retrieveTrades(String filename) throws IOException {
		File srcFile = new File(filename);
		FileInputStream fis = new FileInputStream(srcFile);
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fis, Charset.forName("UTF-8")));
		
		List<String> lines = new ArrayList<String>();
		String readLine = null;
		while ((readLine = bufferedReader.readLine()) != null) {
			lines.add(readLine);
		}
		bufferedReader.close();
		
		return lines;
	}

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
