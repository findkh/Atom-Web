package com.myproject.controller;

import static com.myproject.controller.ResultMap.FAIL;
import static com.myproject.controller.ResultMap.SUCCESS;
import java.io.File;
import java.io.FileInputStream;
import java.util.Map;
import java.util.UUID;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import com.myproject.domain.Member;
import com.myproject.service.MemberService;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

@RestController 
public class MemberController {

  @Autowired
  MemberService memberService;

  @RequestMapping("/member/signup") 
  public Object singUp(Member member, MultipartFile file) {
    try {
      member.setPhoto(saveFile(file));
      if (memberService.add(member) == 1) {
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
  public Object singIn(String email, String password, boolean saveEmail, HttpServletResponse response, HttpSession session) {
    Member loginUser = memberService.get(email, password);
    if (loginUser == null) {
      return new ResultMap().setStatus(FAIL).setData("로그인 하지 않았습니다.");
    }

    session.setAttribute("loginUser", loginUser);

    Cookie cookie = null;
    if (saveEmail) {
      //이메일을 쿠키로 보낸다.(응답할 때)
      cookie = new Cookie("userEmail", email); //쿠키는 문자열만 가능하다! 객체는 세션에 저장해야 한다.
    } else {
      cookie = new Cookie("userEmail", "");
      cookie.setMaxAge(0); // 클라이언트에게 쿠키를 삭제하도록 요구한다.
    }
    response.addCookie(cookie);
    return new ResultMap().setStatus(SUCCESS);
  }

  @SuppressWarnings("unchecked")
  @RequestMapping("/member/fbsingin")
  public Object fbSingIn(String accessToken, HttpSession session) throws Exception{

    //페이스북 서버에 접속하여 사용자 정보를 요구한다.
    RestTemplate restTemplate = new RestTemplate();
    Map<String,String> result = restTemplate.getForObject( //getForObject : get요청을 하는 URL
        "https://graph.facebook.com/v13.0/me?access_token={value1}&fields={value2}", // 요청할 URL 
        Map.class, // 서버에서 받은 결과의 타입 
        accessToken, // URL의 첫 번째 자리에 들어갈 값
        "id,name,email,picture" // 페이스북 측에 요청하는 로그인 사용자 정보
        );

    //사용자 이름과 이메일을 알아낸다
    String name = result.get("name");
    String email = result.get("email");

    //현재 등록된 사용자 중에서 해당 이메일의 사용자가 있는지 확인한다.
    Member member = memberService.get(email);

    if(member != null) {
      //등록된 사용자가 있다면 자동 로그인 처리한다.
      session.setAttribute("loginUser", member);
      return new ResultMap().setStatus(SUCCESS).setData("기존 회원 로그인");

    } else {
      //등록된 사용자가 아니라면 회원 등록 후 자동 로그인 처리한다.
      memberService.add(new Member().setEmail(email).setName(name).setPassword("1111"));
      session.setAttribute("loginUser", memberService.get(email));

      return new ResultMap().setStatus(SUCCESS).setData("새 회원 로그인");
    }

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
      .size(50, 50)
      .crop(Positions.CENTER)
      //      .outputFormat("jpg")
      .toFile(new File("./upload/profile/" + "50x50_" + filename));

      return filename;
    } else {
      return null;
    }
  }

}


