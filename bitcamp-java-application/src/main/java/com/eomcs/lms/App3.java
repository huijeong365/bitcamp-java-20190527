package com.eomcs.lms;

import java.util.Scanner;

public class App3 {
  public static void main(String[] args) {
    java.io.InputStream keyboard = System.in;
    Scanner keyScan = new Scanner(keyboard);
    
    System.out.print("번호?");
    String no = keyScan.nextLine();
    
    System.out.print("내용?");
    String memo = keyScan.nextLine();
    
    System.out.print("작성일?");
    String makeDate = keyScan.nextLine();
    
    System.out.print("조회수?");
    String fineTimes = keyScan.nextLine();
    
    System.out.println();
    
    System.out.println("번호: " + no);
    System.out.println("내용: " + memo);
    System.out.println("작성일: " + makeDate);
    System.out.println("조회수: " + fineTimes);
  }

}
