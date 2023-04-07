package com.schoolmanagementsystem.controllers;

public class Controller {
    public static boolean validateNum(String str) {
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                continue;
            }
            else {
                return true;
            }
        }
        return false;
    }
}
