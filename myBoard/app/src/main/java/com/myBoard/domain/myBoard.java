package com.myBoard.domain;

import java.sql.Date;
import lombok.Data;

@Data
public class myBoard {
  int no;
  String title;
  String content;
  int viewCount;
  Date createdDate;
}
