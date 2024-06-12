# 로그인, 로그아웃, 회원가입 기능 만들어보기

## 환경 설정

### 로컬 환경에서 MySQL 데이터베이스 구동하기

- MySQL 데이터베이스를 구동하기 위해서 ./docker-compose.yml 파일을 작성해두었다.
- `docker-compose` 를 활용하여 로컬 환경에서 MySQL 데이터베이스를 구동해보자. 

```bash
# docker-compose.yml 파일이 존재하는 경로에서 아래 커맨드를 실행
$ docker-compose up -d
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

### 패키지 소개

- `Controller`-`Service`-`Repository` 흐름으로 진행되는 일반적인 MVC 패턴을 따른다.
- `Controller` 에서는 클라이언트로부터의 요청을 받는다.
- `Service` 는 핵심 도메인 로직을 처리한다.
- `Repository` 는 JPA 를 활용하여 데이터베이스와의 통신을 담당한다.

### 의존성 및 기술 스택

- Java17
- SpringBoot 3.3
- SpringSecurity 6 - 보안 설정
- Thymeleaf - 웹 페이지의 정의를 위해 템플릿 엔진 활용
- JPA & Hibernate - 데이터베이스 연결
- MySQL - 데이터베이스
- JUnit5 - 테스팅 프레임워크
- Gradle - 빌드