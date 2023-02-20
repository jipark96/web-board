<img src="https://capsule-render.vercel.app/api?type=waving&color=auto&height=200&section=header&text=Project&fontSize=90" />

# Company Employment CRUD

---
### 박지현
<img src="https://github-readme-stats.vercel.app/api/top-langs/?username=jipark96&layout=compact"><br><br>
> 채용 목록 등록, 수정, 삭제, 조회 검색 기능 구현

---
## purpose
**기업 채용을 위한 웹 서비스**

---
## 목차
- [Stack](#stack)
- [개요](#summary)
- [기능 구현 목록](#feature)



---
## Stack
### Language
<img src="https://img.shields.io/badge/Java-11-007396?style=fflat&logo=java&logoColor=white"><br>

### API
<img src="https://img.shields.io/badge/Spring Boot-2.7.7-6DB33F?style=flat&logo=Spring Boot&logoColor=white"/><br>
<img src="https://img.shields.io/badge/spring-6DB33F?style=flat&logo=spring&logoColor=white"><br>
<img src="https://img.shields.io/badge/gradle-02303A?style=flat&logo=gradle&logoColor=white">

### ORM
<img src="https://img.shields.io/badge/JPA-6DB33F?style=flat&logo=&logoColor=white"/><br>

### DB
<img src="https://img.shields.io/badge/mariaDB-003545?style=flat&logo=mariaDB&logoColor=white"><br>

### Tools
<img src="https://img.shields.io/badge/IntelliJ IDEA-000000?style=flat&logo=IntelliJ IDEA&logoColor=white"><br>

---
## Summary
- **기업의 채용을 위한 웹 서비스**
- **기업 채용 공고를 생성하고 수정, 삭제가 가능**
- **기업 채용 공고를 검색 및 조회 가능**

---
## Feature
- [x] 채용 공고를 등록
    - API : ```/company/add```
        ```
        {
            "채용공고_id": 채용공고_id,
            "회사명":"잡코리아",
            "국가":"한국",
            "지역":"서울",
            "채용포지션":"프론트 주니어 개발자",
            "채용보상금":1000000,
            "사용기술":"Python",
            "채용내용": "잡코리아에서 프론트 주니어 개발자를 채용합니다.",
        }

- [x] 채용 공고를 수정
    - API : ```/company/update```
         ```
      {
          "채용공고_id":채용공고_id,
          "채용포지션":"백엔드 주니어 개발자",
          "채용보상금":1500000,
          "채용내용":"원티드랩에서 백엔드 주니어 개발자를 채용합니다.",
          "사용기술":"Python"
      } 

- [x] 채용 공고를 삭제
    - API : ```/company/delete/{id}```

- [x] 채용 공고 목록 조회
    - API : ```/company/list```
        ```
      [
        {
            "채용공고_id": 채용공고_id,
            "회사명":"카카오",
            "국가":"한국",
            "지역":"부산",
            "채용포지션":"백엔드 주니어 개발자",
            "채용보상금":1000000,
            "사용기술":"Python"
        },
        {
            "채용공고_id": 채용공고_id,
            "회사명":"네이버",
            "국가":"한국",
            "지역":"경기",
            "채용포지션":"Java 백엔드 개발자",
            "채용보상금":2000000,
            "사용기술":"Java"
        }, 
        ...
      ]

- [x] 채용 상세 페이지 조회
    - API : ```/company/detail/{id}```
        ```
    {
        "채용공고_id": 채용공고_id,
        "회사명":"카카오",
        "국가":"한국",
        "지역":"서울",
        "채용포지션":"백엔드 주니어 개발자",
        "채용보상금":500000,
        "사용기술":"Python",
        "채용내용": "카카오에서 파이썬 개발자를 채용합니다.",
    }
    

- [x] 채용 공고 검색
    - API : ```/company/search?keyword=Python```
        ```
     [
       {
           "채용공고_id": 채용공고_id,
           "회사명":"카카오",
           "국가":"한국",
           "지역":"서울",
           "채용포지션":"백엔드 주니어 개발자",
           "채용보상금":300000000,
           "사용기술":"Python"
       },
       {
           "채용공고_id": 채용공고_id,
           "회사명":"네이버",
           "국가":"한국",
           "지역":"부산",
           "채용포지션":"프론트엔드 개발자",
           "채용보상금":100000,
           "사용기술":"javascript"
       }
     ]
