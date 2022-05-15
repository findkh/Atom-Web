# 2022-05-16 ~ 2022-05-20 주간 Study 정리
## 1. DB 종류
- DB의 종류는   
관계형 데이터베이스 관리 시스템(RDBMS;Relational Datagbase Management System),  
계층형 데이터베이스 관리시스템(HDBMS;Hierarchical Database Management System),  
네트워크 데이터베이스 관리시스템(NDBMS;Network Database Management System)이 있습니다.
RDBMS - Oracle, SQL Server, MySQL, MariaDB  
HDBMS - IMS, System2000  
NDBMS - IDS, IDMS  

## 1-1 Oracle과 MySQL의 차이
- 오라클은 큰 예산과 복잡한 비즈니스 요구와 기업 고객을 위해 설계되었습니다. 그에 비해 MySQL은 가장 일반적으로 데이터베이스 기반 웹 사이트 및 Non-Critical 애플리케이션에 사용되는 저가의 데이터 베이스입니다.
구조의 차이는 오라클은 서버가 통합된 하나의 스토리지를 공유하는 방식이고 MySQL은 서버마다 독립적인 스토리지를 할당하는 방식입니다.  
조인 방식의 차이는 오라클은 중첩 루프 조인, 해시 조인, 소트 머지 조인 방식을 제공하지만 MySQL은 중첩 루프 조인 방식을 제공합니다.  
확장성의 차이는 오라클은 별도의 DBMS를 설치해 사용할 수 없지만 MySQL은 별도의 DBMS를 설치해야 사용할 수 있습니다.  
오라클은 사용율이 커서 최소 수백 MB 이상이 되어야 설치할 수 있지만, MySQL은 메모리 사용율이 낮아서 1MB 환경에서도 설치가 가능합니다.  

## 2. 데이터베이스 언어
- DDL(Data Definition Language) 데이터 정의어로 테이블이나 인덱스 같은 데이터 구조를 정의하거나 수정, 삭제하는데 사용하는 명령어로 CREATE, ALTER, DROP, TRUNCATE가 있습니다.   
DML(Data Manipulation Language)은 데이터 조작어로 DB에 들어 있는 데이터를 조회하거나 변경하기 위한 명령어로 SELECT, INSERT, DELETE, UPDATE가 있습니다.  
DCL(Data Control Language)은 데이터 제어어로 DB에 접근하거나 객체들을 사용할 수 있는 권한을 제어하기 위한 명령어로 GRANT, REVOKE가 있습니다.  
TCL(Transaction Control Language)은 트랜잭션 제어어로 트랜잭션을 제어하기 위한 명령어로 COMMIT, ROLLBACK, SAVEPOINT 가 있습니다.  

## 3. 제약사항(Constraint)
- 제약조건은 사용자가 원하는 조건의 데이터만 유지하기 위한 방법입니다.   
PRIMARY KEY(기본키) 테이블에 저장된 행 데이터를 고유학 식별하기 위한 기본키 정의로 하나의 테이블에 하나의 기본키 제약만 정의 가능합니다.  기본키를 구성하는 컬럼은 NULL 입력이 불가합니다.
UNIQUE KEY(고유키)는 테이블에 저장된 행 데이터를 고유하기 식별하기 위한 고유키 정의입니다. 유니크키는 NULL 입력이 가능합니다.  
NOT NULL은 NULL 값 입력을 금지하는 키입니다.
CHECK는 입력할 수 있는 값의 범위 등을 제한합니다. 
FOREIGN KEY(외래키) 관계형 DB에서 테이블 간의 관계를 정의하기 위해 기본키를 다른 테이블의 외래키로 복사하여 생성합니다.  
DEFAULT는 INSERT를 수행할 때 컬럼의 값이 지정되지 않으면 자동으로 입력될 기본값을 설정합니다.

## 4. 색인(Index)
- 인덱스는 DB에 저장된 데이터를 빠르게 조회하기 위해서 테이블에 연관된 정보를 독립적인 저장 공간에 저장한 객체입니다.  
테이블의 특정 레코드 위치를 알려주는 용도로 사용하며, 인덱스 데이터는 인덱스를 구성하는 컬럼의 정렬 순서에 따라 오름 차순 혹은 내림 차순으로 정렬됩니다.  
인덱스의 장점은 SELECT 작업의 성능 최적화이지만, 단점으로는 INSERT, UPDATE, DELETE 작업의 성능 저하가 있을 수 있습니다. 성능저하가 일어나는 이유는 데이터를 수정하는 경우 테이블과 인덱스 모두 변경해야하기 때문입니다.  
그래서 대량의 데이터를 수정할 때는 모든 인덱스를 제거하고 데이터 수정이 끝난 후에 인덱스를 다시 생성하면 성능 저하를 개선할 수 있습니다.

## 5. 트랜잭션(Transaction)
- 트랜잭션은 인가받지 않은 사용자로부터 데이터를 보장하기위 DBMS가 가져야하는 특성이자 DB시스템에서 하나의 논리적인 기능을 정상적으로 수행하기 위한 작업의 기본단위입니다.  
트랜잭션의 특성은 원자성, 일관성, 격리성, 지속성이 있습니다.  
원자성(Automicity) : 작업의 최소 단위로 연산 중 하나라도 실패할 경우 전체가 취소되어야 하는 특성입니다.  
일관성(Consistency) : 트랜잭션이 실행 성공 후 항상 일관된 데이터베이스 상태를 보존해야하는 특성입니다.  
격리성(Isolation) : 트랜잭션 실행 중 생성하는 연산의 중간 결과를 다른 트랜잭션이 접근 불가합니다.  
영속성(Durability) : 성공이 완료된 트랜잭션의 결과는 영속적으로 데이터베이스에 저장하는 특성입니다.

## 6. COMMIT, ROLLBACK 설명
- COMMIT은 트랜잭션의 확정으로 트랜잭션을 메모리에 영구적으로 저장하는 명령어이고 ROLLBACK은 트랜잭션 내역을 저장 무효화 시키는 명령어입니다.

## 7. CRUD(CREATE, READ, UPDATE, DELETE)
- CRUD는 컬럼을 조회, 삽입, 갱신, 삭제하는 것으로 SQL 명령어는 SELECT, INSERT, UPDATE, DELETE가 있습니다.

## 8. 커서(Cursor) ** 이해가 잘 안감....
- 커서는 쿼리문에 의해서 반환되는 결과값들을 저장하는 메모리 공간입니다.


