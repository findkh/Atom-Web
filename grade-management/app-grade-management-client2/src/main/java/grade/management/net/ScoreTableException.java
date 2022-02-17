package grade.management.net;


// 서버의 ScoreTable을 다루다가 예외가 발생했을 때 
// 상황을 직관적으로 알 수 있도록 별도의 서브 클래스를 정의하였다.
// 기능을 추가하기 위해 상속 받아 만든 클래스가 아니다.
// 예외가 발생했을 때 예외이름만으로 어떤 예외인지 인지하기 위해 만든 클래스이다.
public class ScoreTableException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  public ScoreTableException() {
    super();
  }

  public ScoreTableException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

  public ScoreTableException(String message, Throwable cause) {
    super(message, cause);
  }

  public ScoreTableException(String message) {
    super(message);
  }

  public ScoreTableException(Throwable cause) {
    super(cause);
  }
}
