package grade.management;

import grade.management.handler.ScoreHandler;
import grade.management.net.ScoreTableProxy;
import grade.util.Prompt;

public class ClientApp {

  //통신하는 코드는 scoreTableProxy라는 캡슐에 다 들어가 있다.
  public static void main(String[] args) {
    new ClientApp().service();
  }

  public void service() {

    try  {
      ScoreTableProxy scoreTableProxy = new ScoreTableProxy("localhost", 3336);
      ScoreHandler scorehandler = new ScoreHandler(scoreTableProxy);

      while(true) {
        printMenu();
        String input = Prompt.promptString("명령> ");

        if (checkQuit(input)) {
          scoreTableProxy.close();
          break;
        }

        try {
          switch(input) {
            case "1": scorehandler.create(); break;
            case "2": scorehandler.list(); break;
            case "3": scorehandler.detail(); break;
            case "4": scorehandler.update(); break;
            case "5": scorehandler.delete(); break;
            default:
              System.out.println("올바른 메뉴 번호를 입력하세요");
          }
        } catch(Exception e) {
          System.out.println("실행 중 오류 발생 - " + e.getMessage());
        }

        System.out.println();
      }//while
    } catch (Exception e) {
      System.out.println("서버와 통신하는 중 오류 발생" + e.getMessage());
    }

    System.out.println("종료");
  }

  private void printMenu() {
    System.out.println("메뉴: ");
    System.out.println("1. 등록");
    System.out.println("2. 목록");
    System.out.println("3. 상세정보");
    System.out.println("4. 변경");
    System.out.println("5. 삭제");
  }

  private boolean checkQuit(String input) {
    return input.equals("quit") || input.equals("exit");
  }
}















