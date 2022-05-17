# 2022-05-16 ~ 2022-05-20 주간 Study 정리

## 19. 자바의 메모리 구조 **상수풀**
- Runtime Data Area(Memory Area)는 JVM이 프로그램을 수행하기 위해 OS로부터 할당받은 메모리 공간입니다.  
크게 3개로 나눌 수 있는데,
Method Area, JVM Stack, Heap이 있습니다.  
Method Area는 JVM이 실행하는 클래스파일을 두는 메모리 영역으로 이 곳에 놓인 코드를 JVM이 실행합니다.
JVM Stack은 각 스레드가 개인적으로 관리하는 메모리 영역으로 스레드에서 메서드를 호출할 때 메서드의 로컬 변수를 이 영역에 만듭니다. 메서드가 호출될 때 그 메서드가 사용하는 로컬 변수를 프레임에 담아 만들고 메서드 호출이 끝나면 그 영역은 삭제 됩니다.
Heap은 new 명령으로 생성한 인스턴스 변수가 놓입니다. 즉 인스턴스 필드가 생성되는 곳이고 가비지 컬렉터가 메모리를 관리합니다.

## 19-1 out of memory 에러 메시지는 어느 메모리 부족으로 나타나는가?
- heap 메모리 부족

## 20. 메서드에서 오버로딩과 오버라이딩
- 오버로딩은 파라미터는 다르지만 같은 기능을 하는 메서드를 같은 이름을 갖게 해서 그 메서드를 사용할 때 일관된 방식으로 쓸 수 있게 도와주는 문법입니다.  
- 오버라이딩은 상속 받은 메서드가 서브 클래스 역할에 맞지 않다면 상속받은 메서드를 서브 클래스 역할에 맞춰서 재정의 함으로써 나중에 그 메서드를 사용할 때 일관된 방식으로 사용할 수 있게 하는 문법입니다.

## 21. 예외 (Exception) ** 수정 **
- 메서드를 실행하거나 호출할 때 예외가 발생하면 호출자에게 알려주는 문법입니다.  
메서드 실행 중에 예외 상황을 만났을 때 리턴 값으로 알려주는 방식으로 사용했지만 예외가 발생하더라도 시스템을 멈추지 않고 적절한 조치를 취한 후 계속 실행하기 위해 예외 처리합니다.

## 21-1 java.lang.Throwable의 서브 클래스
  - Throwable에는 Error와 Exception 2개의 서브 클래스가 있습니다.  
  <img src="https://postfiles.pstatic.net/MjAyMjAyMDRfOTYg/MDAxNjQzOTY5OTY3OTQw.vOQkawGB4qf9iSb1RMl7hBZk1Xkl4DIdWpS3yPaZaSwg.d1HVqnFOJ9PTsO-gx5eXHhS5HtmBVOz--DAjmcrIsEkg.PNG.watermoon14/image.png?type=w773">  
  - Error는 JVM에서 발생된 오류로 이 오류가 발생하면 현재의 시스템 상태를 즉시 백업하고 실행을 멈춰야 합니다. 근본적으로 문제를 해결할 수 없습니다.  
  예로는 스택오버플로우, VM오류, AWT 오류, 스레드 종류 오류가 있습니다.
  <img src="https://postfiles.pstatic.net/MjAyMjAyMDRfNTcg/MDAxNjQzOTcwMDM3NzQ2.YbeNw9X2EM9zm5CSXxIZvWwgJg5lqE5TIPIc3nXD824g.bzPiGANsKbtpYAJJ7gVp6mO7_9EVgqb3rrwjSXG5Qg0g.PNG.watermoon14/image.png?type=w773">  
  - Exception은 애플리케이션 발생시킨 오류로 적절한 조치를 취하면 시스템을 계속 실행하게 만들 수 있습니다.  
  배열의 인덱스가 무효한 오류, I/O 오류, SQL 오류, parse 오류, 데이터 포멧 오류 등이 있습니다.  
  <img src="https://postfiles.pstatic.net/MjAyMjAyMDRfMTI5/MDAxNjQzOTcwMDU1MzM1.XUPwbQbVHlYNVyGzun0ATufuDejfDQ5GtQHUVvFJJzAg.2t0X01kDzWaXFAkHtQLQlw1RmIKfN3kjvhVlp2xf_kwg.PNG.watermoon14/image.png?type=w773">  

## 22. OSI 7계층
- 7계층 Application layer는 이메일, 파일전송, 웹 사이트 조회 등 애플리케이션에 대한 서비스를 제공합니다.
- 6계층 Presentation layer는 문자 코드, 압축, 암호화 등의 데이터를 변환합니다.
- 5계층 Session layer는 세션 체결, 통신 방식을 결정합니다.
- 4계층 Transport layer는 신뢰할 수 있는 통신을 구현합니다.
- 3계층 Network layer는 다른 네트워크와 통신하기 위한 경로설정 및 논리 주소를 결정합니다.
- 2계층 Datalink layer는 네트워크 기기 간의 데이터 전송 및 물리 주소를 결정합니다.
- 1계층 Physical layer는 시스템 간의 물리적인 연결과 전기 신호를 변환 및 제어합니다.

## 23. 동기화(synchronized)
- 프로세스 또는 스레드들이 수행되는 시점을 조절하여 서로 알고 있는 정보가 일치하는 것을 의미합니다.
예를 들어 P1이 a의 값을 1로 처리하는 로직을 수행하는 도중 P2라는 프로세스가 a의 값을 3으로 변경한다면 프로그램은 제가 원하는 형태의 값을 반환할 수 없습니다.  
이때 a를 공유 자원이라 말하고, 두개 이상의 프로세스 또는 스레드가 동기화 없이 접근하려는 현상을 race condition(경쟁상태)이라 하고 이런 문제를 해결하는 것을 동기화라 합니다.

## 24. 프로세스와 스레드의 차이
- 프로세스는 운영체제로부터 시스템 자원을 할당받은 작업의 단위로 실행된 프로그램을 의미합니다.
- 스레드는 프로세스가 할당 받은 자원을 이용하는 실행의 단위입니다.
애플리케이션이 하나의 프로세스이고 그 안에서 분기 처리되는 것이 스레드 입니다.  

## 24-1 멀티 프로세스와 멀티 스레드
- 멀티 프로세스는 하나의 프로그램을 여러 개의 프로세스로 구성하여 각 프로세스가 하나의 작업을 처리하는 것입니다. 
- 멀티 스레드는 프로그램을 여러개의 스레드로 구성하고 각 스레드가 작업을 처리하는 것입니다.
