package main.test;

import main.common.LogUtil;

public class testLog {

    public static void main(String[] args) {
        LogUtil.setLogFileName("TEST.txt");
        LogUtil.writeLogFile("testLog!");
    }
}
