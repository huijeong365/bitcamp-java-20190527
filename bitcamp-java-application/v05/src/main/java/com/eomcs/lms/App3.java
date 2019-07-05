package com.eomcs.lms;

import java.util.Scanner;

public class App3 {

  static Scanner keyScan;

  public static void main(String[] args) {
    java.io.InputStream keyboard = System.in;
    keyScan = new Scanner(keyboard);

    System.out.print("번호?");
    String no = keyScan.nextLine();



    System.out.print("내용?");
    String memo = keyScan.nextLine();

    System.out.print("작성일?");
    String makeDate = keyScan.nextLine();

    System.out.print("조회수?");
    String fineTimes = keyScan.nextLine();

    System.out.println();

    System.out.printf("번호: %s\n", no);
    System.out.printf("내용: %s\n", memo);
    System.out.printf("작성일: %s\n", makeDate);
    System.out.printf("조회수: %s\n", fineTimes);
  }

  private Integer getIntValue(String message) {
    while (true) {
      try {
        System.out.println(message);
        return Integer.parseInt(keyScan.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("숫자를 입력하세요.");
      }
    }
  }


}
