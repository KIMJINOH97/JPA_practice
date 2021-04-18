# JPA ERD 연습 📝

### ERD를 토대로 테이블 작성 해보는 연습

![image](https://user-images.githubusercontent.com/62155304/115137542-b0001780-a061-11eb-8094-34043e02a403.png)

## 🔍 Table 설명

### Team 

- ID (PK)
- name 팀 이름


### Member

- ID (PK)
- name 회원 이름
- age 나이
- team_id (FK) 소속 팀


### Book

- ID (PK)
- name 책 이름


### Like

- ID (PK)
- member_id (FK) 어떤 회원이 좋아하는 지
- book_id (FK) 어떤 책을 좋아하는 지


# Relation(관계) ➡

- Team 과 Member는 1:N 관계 이다. (Team은 여러 회원을 포함한다.)
- Book 과 Member는 N:M 관계 이다. (여러 회원은 여러 책을 좋아한다.)
