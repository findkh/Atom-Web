package grade.management.vo;
//패키지 이름 vo = value object

public class Score {
  String name;
  int kor;
  int eng;
  int math;
  int sum;
  float avg;

  //내부에서 인스턴스 변수를 사용하지 않기 때문에 스태틱 클래스로 만들었다.
  public static Score fromCSV(String csv) {
    //입력된 값을 csv파일 형태로 만든다.
    String[] values = csv.split(",");
    Score score = new Score();
    score.setName(values[0]);
    score.setKor(Integer.parseInt(values[1]));
    score.setEng(Integer.parseInt(values[2]));
    score.setMath(Integer.parseInt(values[3]));
    return score;
  }

  //내부 인스턴스 변수의 값을 가지고 csv 문자열을 만들어 리턴하기 때문에 static을 붙이지 않았다.
  public String toCSV() {
    return String.format("%s,%d,%d,%d",
        this.getName(),
        this.getKor(),
        this.getEng(),
        this.getMath());
  }

  // 인스턴스 메서드는 호출할 때 인스턴스 주소를 앞쪽에 두어야 한다.
  // this는 생략이 가능하다.
  private void compute() {
    this.sum = this.kor + this.eng + this.math;
    this.avg = sum / 3f;
  }

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getKor() {
    return kor;
  }
  public void setKor(int kor) {
    this.kor = kor;
    this.compute();
  }
  public int getEng() {
    return eng;
  }
  public void setEng(int eng) {
    this.eng = eng;
    this.compute();
  }
  public int getMath() {
    return math;
  }
  public void setMath(int math) {
    this.math = math;
    this.compute();
  }

  //sum과 avg는 조회용이니까 꺼내는 getter만 있으면 된다.
  public int getSum() {
    return sum;
  }
  public float getAvg() {
    return avg;
  }

  @Override
  public String toString() {
    return "Score [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", sum="
        + sum + ", avg=" + avg + "]";
  }

}
