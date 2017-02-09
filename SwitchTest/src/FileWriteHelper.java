

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileWriteHelper {

<<<<<<< HEAD
	private static final String LOG_FOLDER_PATH = "\\logs";
	private static final String LOG_FILE_PATH = LOG_FOLDER_PATH + "\\Calculator.log";

	// 사용자에게 사용할것만 쓰게 가이드 하는 샘

	public static void log(String message) {

		// d:\\logs 폴더를 생성한다.

		makeLogsFolder();

		// d:\\logs\\Calculator.log 파일을 생성한다.

		makeCalculatorLogFile();

		// d:\\logs\\Calculator.log 파일에 message를 기록한다.

		writeLog(message);

	}

	public static void makeLogsFolder() {
		File logsFolder = new File(LOG_FOLDER_PATH);
		if (!logsFolder.exists() || !logsFolder.isDirectory()) {

			logsFolder.mkdirs();
		}

	}

	public static void makeCalculatorLogFile() {
		File logFile = new File(LOG_FILE_PATH);

		if (!logFile.exists() || !logFile.isFile()) {

=======
	private static final String LOG_FOLDER_PATH = "/Users/minchangjang/Desktop/logs";
	private static final String LOG_FILE_PATH = LOG_FOLDER_PATH + "/Calculator1.log";
	
	public static void log ( String message ) {
		
		// D:\\logs 폴더를 생성한다.
		makeLogsFolder();
		
		// D:\\logs\\Calculator.log 파일을 생성한다.
		makeCalculatorLogFile();
		
		// D:\\logs\\Calculator.log 파일에 message 를 기록한다.
		writeLog(message);
		
	}
	
	private static void makeLogsFolder() {
		File logsFolder = new File(LOG_FOLDER_PATH);
		
		if ( !logsFolder.exists() ) {
			logsFolder.mkdirs();
		}
		else if ( !logsFolder.isDirectory() ) {
			logsFolder.mkdirs();
		}
	}
	
	private static void makeCalculatorLogFile() {
		File logFile = new File(LOG_FILE_PATH);
		
		if ( !logFile.exists() ) {
			try {
				logFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if ( !logFile.isFile() ) {
>>>>>>> ff69b88e2508f4e7a315c72ea942424bd838b259
			try {
				logFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
<<<<<<< HEAD

	private static void writeLog(String message) {

		try {

			FileWriter fw = new FileWriter(LOG_FILE_PATH, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter out = new PrintWriter(bw);

			out.println(message);

			out.close();
			bw.close();
			fw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
=======
	
	private static void writeLog(String message) {
		try {
			FileWriter fw = new FileWriter(LOG_FILE_PATH, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter out  = new PrintWriter(bw);
			
			out.println(message);
			
			out.close();
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}






>>>>>>> ff69b88e2508f4e7a315c72ea942424bd838b259
