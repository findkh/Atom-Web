package grade.management.handler;

import grade.management.net.ScoreTableProxy;
import grade.management.vo.Score;
import grade.util.Prompt;

public class ScoreHandler {

  ScoreTableProxy scoreTable;

  public ScoreHandler(ScoreTableProxy scoreTable) { 
    this.scoreTable = scoreTable;
  }

  public void create() throws Exception {
    Score score = new Score();
    score.setName(Prompt.promptString("이름? "));
    score.setKor(Prompt.promptInt("국어점수? "));
    score.setEng(Prompt.promptInt("영어점수? "));
    score.setMath(Prompt.promptInt("수학점수? "));

    int count = scoreTable.insert(score);
    if (count == 1) {
      System.out.println("입력 성공");
    } else {
      System.out.println("입력 실패");
    }
  }

  public void list() throws Exception{
    Score[] scores = scoreTable.selectList();
    int cnt = 0;
    for (Score score : scores) {
      System.out.printf("%d: %s, %d, %.2f\n",
          cnt++,
          score.getName(),
          score.getSum(),
          score.getAvg());
    }
  }

  public void detail() throws Exception{
    int no = Prompt.promptInt("번호? ");

    Score score = scoreTable.selectOne(no);
    System.out.printf("이름: %s\n", score.getName());
    System.out.printf("국어: %d\n", score.getKor());
    System.out.printf("영어: %d\n", score.getEng());
    System.out.printf("수학: %d\n", score.getMath());
    System.out.printf("합계: %d\n", score.getSum());
    System.out.printf("평균: %.2f\n", score.getAvg());
  }

  public void update() throws Exception {
    int no = Prompt.promptInt("번호? ");

    Score old = scoreTable.selectOne(no);

    Score score = new Score();
    score.setName(Prompt.promptString("이름(%s)? ", old.getName()));
    score.setKor(Prompt.promptInt("국어점수?(%d) ", old.getKor()));
    score.setEng(Prompt.promptInt("영어점수?(%d) ", old.getEng()));
    score.setMath(Prompt.promptInt("수학점수?(%d) ", old.getMath()));

    int count = scoreTable.update(no, score);
    if (count == 1) {
      System.out.println("입력 성공");
    } else {
      System.out.println("입력 실패");
    }
  }

  public void delete() throws Exception {
    int no = Prompt.promptInt("번호? ");

    int count = scoreTable.delete(no);
    if (count == 1) {
      System.out.println("삭제 성공");
    } else {
      System.out.println("삭제 실패");
    }
  }
}
