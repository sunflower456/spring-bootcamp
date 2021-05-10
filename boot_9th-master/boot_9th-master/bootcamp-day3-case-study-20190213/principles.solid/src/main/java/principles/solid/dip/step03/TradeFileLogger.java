package principles.solid.dip.step03;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TradeFileLogger extends Logger {

	private String filePath;
	private String filename;

	public TradeFileLogger(String filePath, String fileName) {
		//
		this.filePath = filePath;
		this.filename = fileName;
	}

	@Override
	public void logInfo(String message) {
		File dstFile = new File(filePath + "/" + filename);
		if (!dstFile.exists()) {
			try {
				dstFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(filePath + "/" + filename, true);
			fileWriter.append(message);
			fileWriter.append("\r\n");
			fileWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally { 
			try {
				fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
