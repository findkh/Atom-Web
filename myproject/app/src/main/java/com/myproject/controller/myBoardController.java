package com.myproject.controller;

import static com.myproject.controller.ResultMap.FAIL;
import static com.myproject.controller.ResultMap.SUCCESS;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.UUID;
import javax.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.myproject.domain.Member;
import com.myproject.domain.myBoard;
import com.myproject.service.myBoardService;

@RestController 
public class myBoardController {

  @Autowired
  myBoardService myboardService;

  //log를 출력하는 도구 준비
  private static final Logger log = LogManager.getLogger(myBoardController.class);

  @RequestMapping("/myboard/list")
  public Object list(int pageSize, int pageNo, HttpSession session) {
    log.info("게시글 목록 조회");
    Member member = (Member) session.getAttribute("loginUser");

    try {
      if (pageSize < 10 || pageSize > 100) {
        pageSize = 10;
      }
    } catch (Exception e) {}

    int listSize = myboardService.size();


    int totalPageSize = listSize / pageSize;

    try {
      if ((listSize % pageSize) > 0) {
        totalPageSize++;
      }
    } catch (Exception e) {}

    try {
      if (pageNo < 1 || pageNo > totalPageSize) {
        pageNo = 1;
      }
    } catch (Exception e) {}

    //    log.info("게시글 개수 count : " + listSize);
    //    log.info("totalpageSize : " + totalPageSize);

    return new ResultMap()
        .setStatus(SUCCESS)
        .setTotalListCount(totalPageSize)
        .setPageNo(pageNo)
        .setTotalPageSize(totalPageSize)
        .setData(myboardService.list(pageSize, pageNo));
  }

  @RequestMapping("/myboard/add")
  public Object add(myBoard myboard, MultipartFile file, HttpSession session) {
    log.info("게시글 등록"); //운영자가 확인하기를 원하는 정보 
    log.debug(myboard.toString()); //개발자가 확인하기를 원하는 정보

    try {
      Member member = (Member) session.getAttribute("loginUser");
      myboard.setWriter(member);
      myboard.setPhoto(saveFile(file));
      myboardService.add(myboard);
      return new ResultMap().setStatus(SUCCESS);

    } catch (Exception e) {
      StringWriter out = new StringWriter();
      e.printStackTrace(new PrintWriter(out));
      log.error(out.toString());
      return new ResultMap().setStatus(FAIL).setData(e.getMessage());
    }
  }

  @RequestMapping("/myboard/get")
  public Object get(int no) {
    log.info("게시글 조회");
    myBoard board = myboardService.get(no);
    if (board == null) {
      return new ResultMap().setStatus(FAIL).setData("게시글 번호가 유효하지 않습니다.");
    }
    return new ResultMap().setStatus(SUCCESS).setData(board);
  }

  @RequestMapping("/myboard/update")
  public Object update(myBoard myboard, MultipartFile file, HttpSession session) {
    log.info("게시글 수정"); //운영자가 확인하기를 원하는 정보 
    log.debug(myboard.toString()); //개발자가 확인하기를 원하는 정보

    Member member = (Member) session.getAttribute("loginUser");

    try {
      myboard.setWriter(member);
      myboard.setPhoto(saveFile(file));

      int count = myboardService.update(myboard);
      System.out.println(count);
      if (count == 1) {
        return new ResultMap().setStatus(SUCCESS);
      } else {
        return new ResultMap().setStatus(FAIL).setData("게시글 번호가 유효하지 않거나 게시글 작성자가 아닙니다.");
      }
    } catch (Exception e) {
      StringWriter out = new StringWriter();
      e.printStackTrace(new PrintWriter(out));
      log.error(out.toString());
      return new ResultMap().setStatus(FAIL).setData(e.getMessage());
    }
  }

  @RequestMapping("/myboard/delete")
  public Object delete(int no, MultipartFile file, HttpSession session) {
    log.info("게시글 삭제"); //운영자가 확인하기를 원하는 정보 

    Member member = (Member) session.getAttribute("loginUser");

    myBoard myboard = new myBoard();
    myboard.setNo(no);
    myboard.setWriter(member);
    int count = myboardService.delete(myboard);

    if (count == 1) {
      return new ResultMap().setStatus(SUCCESS);
    } else {
      return new ResultMap().setStatus(FAIL).setData("게시글 번호가 유효하지 않거나 게시글 작성자가 아닙니다.");
    }
  }

  @RequestMapping("/myboard/photo")
  public ResponseEntity<Resource> photo(String filename) {
    try {
      File downloadFile = new File("./upload/myboard/" + filename); 
      FileInputStream fileIn = new FileInputStream(downloadFile.getCanonicalPath());
      InputStreamResource resource = new InputStreamResource(fileIn);

      HttpHeaders header = new HttpHeaders();

      header.add("Cache-Control", "no-cache, no-store, must-revalidate");
      header.add("Pragma", "no-cache");
      header.add("Expires", "0");
      header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename);

      return ResponseEntity.ok()
          .headers(header)
          .contentLength(downloadFile.length())
          .contentType(MediaType.APPLICATION_OCTET_STREAM)
          .body(resource);

    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  private String saveFile(MultipartFile file) throws Exception {
    if(file != null && file.getSize() > 0) {
      //파일을 저장할 때 사용할 파일명을 준비한다.
      String filename = UUID.randomUUID().toString();

      // 파일명의 확장자를 알아낸다.
      int dotIndex = file.getOriginalFilename().lastIndexOf(".");
      if (dotIndex != -1) {
        filename += file.getOriginalFilename().substring(dotIndex);
      }

      //파일을 지정된 폴더에 저장한다.
      File photoFile = new File("./upload/myboard/" + filename); //App 클래스를 실행하는 프로젝트 폴더
      file.transferTo(photoFile.getCanonicalFile()); //프로젝트 폴더의 전체 경로를 전달한다.

      return filename;
    } else {
      return null;
    }
  }

}


