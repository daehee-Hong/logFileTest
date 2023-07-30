package main.common;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LogUtil {

    private static String LOG_FILE_NAME = "logFile.txt";
    private static final String LOG_PATH = "src/main/resources/logFile/";

    // 로그 작성
    public static void writeLogFile(String msg){
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileWriter(LOG_PATH + LOG_FILE_NAME, true), true);
            pw.println(msg);
            pw.flush();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (pw != null) pw.close();
        }
    }
    // 파일 이름 설정
    public static void setLogFileName(String logFileName){
        LOG_FILE_NAME = logFileName;
    }
    // 현재 시간 가져오기
}
