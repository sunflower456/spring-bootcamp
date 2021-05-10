package principles.solid.srp.step01;

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

public class TradeProcessor {
	
	private static float LOT_SIZE = 100000f;

	public void processTrades(String srcFilename, String dstFilename) throws IOException {
		//
		File srcFile = new File(srcFilename);
		FileInputStream fis = new FileInputStream(srcFile);
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fis, Charset.forName("UTF-8")));

		//
		List<String> lines = new ArrayList<String>();
		String readLine = null;
		while ((readLine = bufferedReader.readLine()) != null) {
			lines.add(readLine);
		}
		bufferedReader.close();
		
		//
		List<Trade> trades = new ArrayList<Trade>();
		String[] fields;
		for (String line: lines) {
			fields = line.split(",");
			
			if (fields.length != 3) {
				System.out.println("NotEnough fileds");
				continue;
			}
			
			if (fields[0].length() != 6) {
				System.out.println("NotEnough length");
			}
			
			int amount = 0;
			try {
				amount = Integer.parseInt(fields[1]);
			} catch (Exception e) {
				System.out.println("amount is not number.");
			}
			
			float price = 0;
			try {
				price = Float.parseFloat(fields[2]);
			} catch (Exception e) {
				System.out.println("amount is not number.");
			}
			
			String srcCurrencyCode = fields[0].substring(0, 3);
			String dstCurrencyCode = fields[0].substring(3, 6);
			
			Trade trade = new Trade(srcCurrencyCode, dstCurrencyCode, amount/LOT_SIZE, price);
			trades.add(trade);
		}

		//
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
