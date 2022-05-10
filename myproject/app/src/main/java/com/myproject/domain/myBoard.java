package com.myproject.domain;

import java.sql.Date;
import lombok.Data;

@Data
public class myBoard {
  int no;
  String title;
  String content;
  int viewCount;
  Date createdDate;
  Member writer;
  String photo;
}
