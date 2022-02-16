package grade.util;

import java.util.Scanner;

public class Prompt {

  static Scanner in = new Scanner(System.in);

  //가변파라미터 적용 Object를 사용하여 여러 타입의 객체를 받는다.(0개 이상 받는다)
  public static String promptString(String titleFormat, Object... args) {
    System.out.print(String.format(titleFormat, args));
    return in.nextLine();
  }

  //가변파라미터 적용
  public static int promptInt(String titleFormat, Object... args) {
    return Integer.parseInt(promptString(titleFormat, args));
    //prompotInt()가 호출되면 기존의 메서드 prompt()에서 title을 넘겨받아 int로 변환한다.
  }
}
