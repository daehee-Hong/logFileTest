package main.test;

import main.common.LogUtil;

public class testLog {

    public static void main(String[] args) {
        LogUtil.setLogFileName("testLog-" + LogUtil.getCurrentTime("yyyy-MM-dd"));
        LogUtil.setLogPath("src/main/resources/logFile/");
        LogUtil.writeLogFile("msg");
    }
}
