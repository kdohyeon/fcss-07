# 로그인, 로그아웃, 회원가입 기능 만들어보기

## 환경 설정

### 로컬 환경에서 MySQL 데이터베이스 구동하기

- MySQL 데이터베이스를 구동하기 위해서는 `docker-compose` 을 활용한다.
- `./docker-compose.yml` 파일을 실행한다.
- 파일을 실행시키는 방법은 아래 커맨드를 참고한다.

```bash
# docker-compose.yml 파일이 존재하는 경로에서 아래 커맨드를 실행
$ docker-compose -f ./docker-compose.yml up -d

### 전체 도커 컨테이너 목록 확인
$ docker ps -a
```

- DBeaver 와 같은 데이터베이스 클라이언트 툴을 설치하고 아래 정보를 참고하여 접근을 해보자
```yml
url: localhost
port: 3306
username: root
password: admin
```

- 접근에 성공을 하면 `spring` 이라는 이름으로 스키마를 하나 생성한다.
- 만약 접근 시에 `Public Key Retrieval is not allowed` 에러가 발생하면 이 [링크](https://velog.io/@dailylifecoding/DBeaver-MySQL-connecting-error-Public-Key-Retrieval-is-not-allowed-solved)를 참고하여 해결한다.
- 로컬 환경에서 애플리케이션을 실행 시키면 `hibernate` 설정에 따라 구동한 로컬 데이터베이스로 테이블과 샘플 데이터가 생성된다.

## 패키지 소개

- `Controller`-`Service`-`Repository` 흐름으로 진행되는 일반적인 MVC 패턴을 따른다.
- `Controller` 에서는 클라이언트로부터의 요청을 받는다.
- `Service` 는 핵심 도메인 로직을 처리한다.
- `Repository` 는 JPA 를 활용하여 데이터베이스와의 통신을 담당한다.

## 의존성 및 기술 스택

- Java17
- SpringBoot 3.3
- SpringSecurity 6 - 보안 설정
- Thymeleaf - 웹 페이지의 정의를 위해 템플릿 엔진 활용
- JPA & Hibernate - 데이터베이스 연결
- MySQL - 데이터베이스
- JUnit5 - 테스팅 프레임워크
- Gradle - 빌드

## 비즈니스

- 메인 비즈니스는 로그인, 로그아웃, 회원가입 기능을 구현한다.
- 로그인, 로그아웃 기능은 스프링 시큐리티에서 기본으로 제공하는 기본 템플릿을 활용한다.
- 사용자를 조회 할 수 있는 기능을 제공한다.
- 회원가입은 REST API 를 구현하여 API 호출을 통해 구현한다.
  - 회원가입 시 사용자는 기본으로 `READ` 권한이 부여된다. 
  - 비밀번호는 기본적으로 `BCRYPT` 알고리즘으로 인코딩된다.
- 권한을 추가, 삭제, 조회할 수 있다.
  - 권한의 종류는 `READ`, `WRITE` 로 두 종류가 존재한다.

## ERD

- 사용자를 나타내는 `User` 과 각 사용자별 권한을 관리하는 `Authority` 테이블이 존재한다.
- `User` 와 `Authority` 는 `1:N` 관계이다. 즉, 한 명의 사용자는 N 개의 권한을 가질 수 있다.