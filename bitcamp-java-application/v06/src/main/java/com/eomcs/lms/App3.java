package com.eomcs.lms;

import java.util.Scanner;
//import java.sql.Date;

public class App3 {

  static Scanner keyScan;

  public static void main(String[] args) {
    java.io.InputStream keyboard = System.in;
    keyScan = new Scanner(keyboard);

    int[] no = new int[100];
    String[] memo = new String[100];
    
    int i = 0;
    for( ; i<no.length; i++) {
    no[i] = getIntValue("번호?");
    memo[i] = getStringValue("내용? ");
    
    System.out.println("계속 입력하시겠습니까? (Y/n) ");
    String response = keyScan.nextLine();
    
    if (response.contentEquals("n")) 
      break;
    }
    System.out.println();

    for(int i2 = 0; i2 <= i; i2++) {
      System.out.printf("%s, %s\n",no[i2], memo[i2], 2019-01-01, 0);
    }
  }

  private static Integer getIntValue(String message) {
    while (true) {
      try {
        System.out.print(message);
        return Integer.parseInt(keyScan.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("숫자를 입력하세요.");
      }
    }
  }
  
//  private static Date getDateValue(String message) {
//    while (true) {
//      try {
//        System.out.print(message);
//        return Date.valueOf(keyScan.nextLine());
//      } catch (IllegalArgumentException e) {
//        System.out.println("2019-07-05 형식으로 입력하세요.");
//      }
//    }
//  }

  private static String getStringValue(String message) {
    System.out.print(message);
    return (keyScan.nextLine());
  }
  
}
