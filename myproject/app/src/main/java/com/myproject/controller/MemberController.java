package com.myproject.controller;

import static com.myproject.controller.ResultMap.FAIL;
import static com.myproject.controller.ResultMap.SUCCESS;
import java.io.File;
import java.io.FileInputStream;
import java.util.UUID;
import javax.servlet.http.HttpSession;
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
import com.myproject.service.MemberService;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

@RestController 
public class MemberController {

  @Autowired
  MemberService memberSerivce;

  @RequestMapping("/member/signup") 
  public Object singUp(Member member, MultipartFile file) {
    try {
      member.setPhoto(saveFile(file));
      if (memberSerivce.add(member) == 1) {
        return new ResultMap().setStatus(SUCCESS);
      } else {
        return new ResultMap().setStatus(FAIL);
      }
    } catch (Exception e) {
      e.printStackTrace();
      return new ResultMap().setStatus(FAIL).setData(e.getMessage());
    }
  }

  @RequestMapping("/member/signin") 
  public Object singIn(String email, String password, HttpSession session) {
    Member loginUser = memberSerivce.get(email, password);
    if (loginUser == null) {
      return new ResultMap().setStatus(FAIL).setData("로그인 하지 않았습니다.");
    }
    //로그인이 성공하면, 
    //로그인 회원의 정보를 사용할 수 있도록 세션에 보관한다.
    session.setAttribute("loginUser", loginUser);
    return new ResultMap().setStatus(SUCCESS);
  }

  @RequestMapping("/member/getLoginUser") 
  public Object getLoginUser(HttpSession session) {
    Object member = session.getAttribute("loginUser");
    if (member != null) {
      return new ResultMap().setStatus(SUCCESS).setData(member);
    } else {
      return new ResultMap().setStatus(FAIL).setData("로그인 하지 않았습니다.");
    }
  }

  @RequestMapping("/member/signout") 
  public Object singOut(HttpSession session) {
    session.invalidate();
    return new ResultMap().setStatus(SUCCESS);
  }

  @RequestMapping("/member/photo")
  public ResponseEntity<Resource> photo(String filename) {
    try {
      File downloadFile = new File("./upload/profile/" + filename); 
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
      File photoFile = new File("./upload/profile/" + filename);
      file.transferTo(photoFile.getCanonicalFile());

      //썸네일 이미지 파일 생성
      Thumbnails.of(photoFile)
      .size(40, 40)
      .crop(Positions.CENTER)
      //      .outputFormat("jpg")
      .toFile(new File("./upload/profile/" + "40x40_" + filename));

      return filename;
    } else {
      return null;
    }
  }

}


