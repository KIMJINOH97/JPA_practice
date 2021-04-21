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


# API 명세서

## Member

### GET Member List

#### Description
Get member list.

#### URL Structure
`http://.../api/members`

#### Method
GET

#### Parameters
| Parameter |  |  |
|---|---|---|
| **id** | *Required* | User's ID. |
| **pw** | *Required* | User's password hashed with SHA-256 |

#### Returns
```
{
   [ 
        {
            "id": 1,
            "name": "jino😳",
            "age": 24,
            "teamName": "팀1",
            "address":{
            "city": "서울",
            "gu": "mapo",
            "dong": "sang-su",
        },
        {
            "id": 2,
            "name": "student",
            "age": 25,
            "teamName": "팀2",
            "address":{
            "city": "서울",
            "gu": "mapo",
            "dong": "sang-su"
        }
        .
        .
        .
   ]
}
```

### POST Member

#### Description
Post member information.

#### URL Structure
`http://.../api/member`

#### Method
POST

#### Body
| Variable |  | Type | What |
|---|---|---|----|
| **name** | *Required* | INT |  Member's Name  |
| **age** | *Required* | String |  Member's Age  |
| **city** | *Required* | String |  Member's City  |
| **gu** | *Required* | String |  Member's Gu  |
| **dong** | *Required* | String |  Member's Dong  |
| **team_name** | *Required* | String |  Member's Team  |

```
{
    "name" : "지노",
    "age" : 24,
    "city" : "부산",
    "gu" : "부산진구",
    "dong" : "부전동",
    "team_name" : "팀1"
}
```

#### Returns
```
{
   {
        "id": 1,
        "name": "jino😳",
        "age": 24,
        "address": {
            "city": "서울",
            "gu": "mapo",
            "dong": "sang-su"
        },
        "team_name": "팀1"
   }
}
```


### Update Member

#### Description
Update member information.

#### URL Structure
`http://.../api/member/:id`

#### Method
Update

#### Parameter
Path-variable: ID

#### Body
| Variable |  | Type | What |
|---|---|---|----|
| **name** | *Required* | INT |  Member's Name  |
| **age** | *Required* | String |  Member's Age  |
| **city** | *Required* | String |  Member's City  |
| **gu** | *Required* | String |  Member's Gu  |
| **dong** | *Required* | String |  Member's Dong  |
| **team_name** | *Required* | String |  Member's Team  |

```
{
    "name" : "지노",
    "age" : 24,
    "city" : "부산",
    "gu" : "부산진구",
    "dong" : "부전동",
    "team_name" : "팀1"
}
```


#### Returns
```
{
    "id": 1,
    "name": "jino😳",
    "age": 24,
    "city": "서울",
    "gu": "mapo",
    "dong": "sang-su",
    "team_name": "팀1"
}
```

### Delete Member

#### Description
Delete member information.

#### URL Structure
`http://.../api/member/:id`

#### Method
Delete

#### Path-Variable
| Type | Variable | What |
|----|----|---|
| Long |  ID | Member's Id  |

#### Returns
```
Member's ID
```

#### Errors

```
{
  "status": {
    "code": 400, 
    "msg": "SignIn Fail"
  },
  "errors": {
    "message": "존재하지 않는 아이디거나 틀린 패스워드입니다."
  }
}
```

## Book

### GET Book list

#### Description
Get book-list

#### URL Structure
`http://.../api/books`

#### Method
GET

#### Returns
```
{
   [ 
        {
            "id": 1,
            "name": "book1"
        },
        {
            "id": 2,
            "name": "book2"
        }
        .
        .
        .
   ]
}
```

