package principles.solid.isp.step01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class TradeProvider {

	public List<String> readTradeLines(String srcFilename) throws IOException {
		BufferedReader bufferedReader = readFile(srcFilename);
		return readLines(bufferedReader);
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
}
