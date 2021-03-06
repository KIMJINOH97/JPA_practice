# JPA ERD μ°μ΅ π

### ERDλ₯Ό ν λλ‘ νμ΄λΈ μμ± ν΄λ³΄λ μ°μ΅

![image](https://user-images.githubusercontent.com/62155304/115137542-b0001780-a061-11eb-8094-34043e02a403.png)

## π Table μ€λͺ

### Team 

- ID (PK)
- name ν μ΄λ¦


### Member

- ID (PK)
- name νμ μ΄λ¦
- age λμ΄
- team_id (FK) μμ ν


### Book

- ID (PK)
- name μ± μ΄λ¦


### Like

- ID (PK)
- member_id (FK) μ΄λ€ νμμ΄ μ’μνλ μ§
- book_id (FK) μ΄λ€ μ±μ μ’μνλ μ§


# Relation(κ΄κ³) β‘

- Team κ³Ό Memberλ 1:N κ΄κ³ μ΄λ€. (Teamμ μ¬λ¬ νμμ ν¬ν¨νλ€.)
- Book κ³Ό Memberλ N:M κ΄κ³ μ΄λ€. (μ¬λ¬ νμμ μ¬λ¬ μ±μ μ’μνλ€.)


# API λͺμΈμ

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
            "name": "jinoπ³",
            "age": 24,
            "teamName": "ν1",
            "address":{
            "city": "μμΈ",
            "gu": "mapo",
            "dong": "sang-su",
        },
        {
            "id": 2,
            "name": "student",
            "age": 25,
            "teamName": "ν2",
            "address":{
            "city": "μμΈ",
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
    "name" : "μ§λΈ",
    "age" : 24,
    "city" : "λΆμ°",
    "gu" : "λΆμ°μ§κ΅¬",
    "dong" : "λΆμ λ",
    "team_name" : "ν1"
}
```

#### Returns
```
{
   {
        "id": 1,
        "name": "jinoπ³",
        "age": 24,
        "address": {
            "city": "μμΈ",
            "gu": "mapo",
            "dong": "sang-su"
        },
        "team_name": "ν1"
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
    "name" : "μ§λΈ",
    "age" : 24,
    "city" : "λΆμ°",
    "gu" : "λΆμ°μ§κ΅¬",
    "dong" : "λΆμ λ",
    "team_name" : "ν1"
}
```


#### Returns
```
{
    "id": 1,
    "name": "jinoπ³",
    "age": 24,
    "city": "μμΈ",
    "gu": "mapo",
    "dong": "sang-su",
    "team_name": "ν1"
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
    "message": "μ‘΄μ¬νμ§ μλ μμ΄λκ±°λ νλ¦° ν¨μ€μλμλλ€."
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

