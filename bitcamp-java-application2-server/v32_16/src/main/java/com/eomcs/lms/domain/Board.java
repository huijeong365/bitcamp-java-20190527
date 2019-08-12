package com.eomcs.lms.domain;

import java.io.Serializable;
import java.sql.Date;

public class Board implements Serializable {
private static final long serialVersionUID = 1L;

  private int no;
  private String contents;
  private String memo;
  private Date createdDate;
  private int viewcount;
  
  @Override
  public String toString() {
    return "Board [no=" + no + ", contents=" + contents + ", memo=" + memo + ", createdDate="
        + createdDate + ", viewcount=" + viewcount + "]";
  }
  
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getContents() {
    return contents;
  }
  public void setContents(String contents) {
    this.contents = contents;
  }
  public String getMemo() {
    return memo;
  }
  public void setMemo(String memo) {
    this.memo = memo;
  }
  public Date getCreatedDate() {
    return createdDate;
  }
  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }
  public int getViewcount() {
    return viewcount;
  }
  public void setViewcount(int viewcount) {
    this.viewcount = viewcount;
  }
  
}
