package grade.management.handler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import grade.management.vo.Score;
import grade.util.Prompt;

public class ScoreHandler {
  ArrayList<Score> scores = new ArrayList<>();

  //생성자
  public ScoreHandler() { //try~with~Resources
    try (BufferedReader in = new BufferedReader(new FileReader("./score.csv"));) {
      String line;

      while((line = in.readLine()) != null) { 
        scores.add(Score.fromCSV(line)); //csv형식으로 만들어서 ArrayList에 저장한다.
      }

    } catch(Exception e) {
      System.out.println("데이터 로딩 중 오류 발생!");
    }
  }

  private void save() {
    try (PrintWriter out = new PrintWriter(new FileWriter("./score.csv"));){
      for (Score score : scores) {
        out.println(score.toCSV());
      }
    } catch (Exception e) {
      System.out.println("데이터 저장 중 오류 발생!");
    }
  }

  public void create() {
    Score score = new Score();
    score.setName(Prompt.promptString("이름? "));
    score.setKor(Prompt.promptInt("국어점수? "));
    score.setEng(Prompt.promptInt("영어점수? "));
    score.setMath(Prompt.promptInt("수학점수? "));

    //ArrayList를 사용해서 입력받은 값을 저장한다.
    scores.add(score);
    save();
  }

  public void list() {
    int cnt = 0;
    for (Score score : scores) {
      System.out.printf("%d: %s, %d, %.2f\n",
          cnt++,
          score.getName(),
          score.getSum(),
          score.getAvg());
      /*for (:) 적용
    배열 전체를 반복하거나 컬렉션 객체 전체를 반복할 때 유용하다.
    배열의 일부만 반복할 수 없다.
    배열의 값을 다룰 때 인덱스를 사용할 필요가 없어서 편리하다.*/
    }
  }

  public void detail() {
    int no = Prompt.promptInt("번호? ");
    validation(no);

    Score score = scores.get(no);
    System.out.printf("이름: %s\n", score.getName());
    System.out.printf("국어: %d\n", score.getKor());
    System.out.printf("영어: %d\n", score.getEng());
    System.out.printf("수학: %d\n", score.getMath());
    System.out.printf("합계: %d\n", score.getSum());
    System.out.printf("평균: %.2f\n", score.getAvg());
  }

  public void update() {
    int no = Prompt.promptInt("번호? ");
    validation(no);

    Score old = scores.get(no);

    // 필드에 직접 접근하면(직접 값을 넣게 되면) 필드에 유효하지 않은 값이 들어갈 가능성이 있다.
    // 메서드를 통해 값을 넣게 유도한다. -> 메서드를 통해 접근하게 하여 무효한 값이 들어가지 않게 한다.(캡슐화)
    Score score = new Score();
    score.setName(Prompt.promptString("이름(%s)? ", old.getName()));
    score.setKor(Prompt.promptInt("국어점수?(%d) ", old.getKor()));
    score.setEng(Prompt.promptInt("영어점수?(%d) ", old.getEng()));
    score.setMath(Prompt.promptInt("수학점수?(%d) ", old.getMath()));

    scores.set(no, score);
    save();
  }

  public void delete() {
    int no = Prompt.promptInt("번호? ");
    validation(no);

    scores.remove(no);
    save();
  }

  private void validation(int no) {
    if (no < 0 || no >= scores.size()) {
      System.out.println("번호가 유효하지 않습니다.");
    }
  }
}
