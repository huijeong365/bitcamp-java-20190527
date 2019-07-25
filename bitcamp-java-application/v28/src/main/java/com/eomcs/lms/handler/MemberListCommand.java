package com.eomcs.lms.handler;

import java.util.List;
import com.eomcs.lms.domain.Member;
import com.eomcs.util.Input;

public class MemberListCommand implements Command{
  
  private List<Member> list;
  private Input input;
  
  public MemberListCommand(Input input, List<Member> list) {
    this.input = input;
    this.list = list;
  }
  
  @Override
  public void execute() {
    Member[] memebrs = list.toArray(new Member[] {});
    for (Member member : memebrs) {
      System.out.printf("%s, %s, %s, %s, %s, %s\n",member.getNo(), member.getName(), member.getEmail(), 
          member.getPassword(),member.getTel(), member.getRegisteredDate());
    }
  }
}
