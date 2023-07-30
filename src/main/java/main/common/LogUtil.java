package main.common;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class LogUtil {

    private static String LOG_FILE_NAME = "logFile";
    private static String LOG_PATH = "src/main/resources/logFile/";

    // 로그 작성
    public static void writeLogFile(String msg){
        PrintWriter pw = null;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(LOG_PATH).append(LOG_FILE_NAME).append(".log");

            pw = new PrintWriter(new FileWriter(sb.toString(), true), false);
            sb.delete(0, sb.length());
            sb.append("[").append(getCurrentTime()).append("] : ").append(msg);
            pw.println(sb);
            pw.flush();
        }catch (IOException e){
            System.err.println("[ERROR] 로그 작성중 에러 : " + e.getMessage());
            e.printStackTrace();
        }finally {
            if (pw != null) pw.close();
        }
    }
    public static void writeLogFileBuffer(String msg){
        BufferedWriter bw = null;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(LOG_PATH).append(LOG_FILE_NAME).append(".log");

            bw = new BufferedWriter(new FileWriter(sb.toString(), true));
            sb.delete(0, sb.length());
            sb.append("[").append(getCurrentTime()).append("] : ").append(msg).append("\n");
            bw.append(sb.toString());
            bw.flush();
        }catch (IOException e){
            System.err.println("[ERROR] 로그 작성중 에러 : " + e.getMessage());
            e.printStackTrace();
        }finally {
            if (bw != null) try {bw.close();}catch (IOException e){}
        }
    }
    // 파일 이름 설정
    public static void setLogFileName(String logFileName){
        LOG_FILE_NAME = logFileName;
    }
    // 파일 경로 설정
    public static void setLogPath(String logPath){
        LOG_PATH = logPath;
    }
    // 현재 시간 가져오기
    public static String getCurrentTime(){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(calendar.getTime());
    }
    // 현재시간 포맷에 맞게 가져오기
    public static String getCurrentTime(String format){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(calendar.getTime());
    }
}
