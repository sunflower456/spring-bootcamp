package principles.solid.srp.step05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
		BufferedReader bufferedReader = readFile(srcFilename);
		List<String> lines = readLines(bufferedReader);
		List<Trade> trades = parseTrade(lines);
		writeTrades(trades, dstFilename);
	}
	
	private BufferedReader readFile(String srcFilename) throws FileNotFoundException {
		//
		File srcFile = new File(srcFilename);
		FileInputStream fis = new FileInputStream(srcFile);
		return new BufferedReader(new InputStreamReader(fis, Charset.forName("UTF-8")));
	}
	
	private List<String> readLines(BufferedReader bufferedReader) throws IOException {
		List<String> lines = new ArrayList<String>();
		String readLine = null;
		while ((readLine = bufferedReader.readLine()) != null) {
			lines.add(readLine);
		}
		bufferedReader.close();
		
		return lines;
	}
	
	private List<Trade> parseTrade(List<String> lines) {
		List<Trade> trades = new ArrayList<Trade>();
		String[] fields;
		for (String line: lines) {
			fields = line.split(",");
			
			if (!validateTrade(fields)) {
				continue;
			}
			
			Trade trade = convertToTrade(fields);
			trades.add(trade);
		}
		
		return trades;
	}
	
	private boolean validateTrade(String[] fields) {
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
	
	private Trade convertToTrade(String[] fields) {
		int amount = Integer.parseInt(fields[1]);
		float price = Float.parseFloat(fields[2]);
		String srcCurrencyCode = fields[0].substring(0, 3);
		String dstCurrencyCode = fields[0].substring(3, 6);
		
		return new Trade(srcCurrencyCode, dstCurrencyCode, amount/LOT_SIZE, price);
	}
	
	private void writeTrades(List<Trade> trades, String dstFilename) throws IOException {
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
