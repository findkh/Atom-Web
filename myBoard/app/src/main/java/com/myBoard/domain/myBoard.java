package com.myBoard.domain;

import java.sql.Date;

public class myBoard {
  String title;
  String content;
  int viewCount;
  Date createdDate;

  @Override
  public String toString() {
    return "myBoard [title=" + title + ", content=" + content + ", viewCount=" + viewCount
        + ", createdDate=" + createdDate + "]";
  }

  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public int getViewCount() {
    return viewCount;
  }
  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
  }
  public Date getCreatedDate() {
    return createdDate;
  }
  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }
}
