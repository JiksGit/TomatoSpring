# (P-Project) AI를 활용한 Spring 백엔드 개발

토마토 잎 질병을 CNN 기반 이미지 분류 인공지능을 통해 분석하고 사용자들의 정보 공유를 위한 게시판 기능을 제공

---------
### 주요 기능

1. 토마토 잎 질병 분석 및 해결 방안 제시(정확도 98%로 학습시킨 Densenet161 사용)

2. 회원가입 및 로그인 기능

3. 게시판 기능 및 댓글 기능

4. 주변 마트 검색 기능(Kakao map API 사용)

-------
#### 데이터베이스 구조

![image](https://github.com/JiksGit/TomatoSpring/assets/96871403/52b7bde0-b371-4165-8bb3-c5176908008a)


-------
#### API 명세서(Swagger 사용)

![image](https://github.com/JiksGit/TomatoSpring/assets/96871403/6bbf5e40-2bfc-4208-ae7b-66b9512c7045)
![image](https://github.com/JiksGit/TomatoSpring/assets/96871403/5192135e-0cba-4c96-a36c-6ef3263bfd68)



-------
#### 개발 도구

![image](https://github.com/JiksGit/TomatoSpring/assets/96871403/ebd5e2df-8c0a-45e2-a4a1-aae74fcc1e10)


-------
#### 1. 토마토 잎 질병 분석 및 해결 방안 제시
<img width="1423" alt="image" src="https://github.com/JiksGit/TomatoSpring/assets/96871403/18856706-28d6-4ee1-99c5-1c1fc1053b41">

-------
#### 2. 회원가입 및 로그인 기능
<img width="600" alt="image" src="https://github.com/JiksGit/TomatoSpring/assets/96871403/b4023570-8e24-4a5f-b495-7d0453649261">
<img width="600" alt="image" src="https://github.com/JiksGit/TomatoSpring/assets/96871403/fccb2c73-f5c2-4817-9805-adc8b9804ff3">

-------
#### 3. 게시판 작성 및 댓글 기능
<img width="800" alt="image" src="https://github.com/JiksGit/TomatoSpring/assets/96871403/dcc6deac-20ed-497d-b3e4-145eda88d770">
<img width="800" alt="image" src="https://github.com/JiksGit/TomatoSpring/assets/96871403/00f16ec0-3355-41fc-894d-4c1c07e20d5a">

-------
#### 4. 주변 농협마트 검색 기능
![image](https://github.com/JiksGit/TomatoSpring/assets/96871403/a99ac206-fda9-43a2-80c6-1ba5952681bb)

--------
+++JWT 토큰 활용
<img width="929" alt="image" src="https://github.com/JiksGit/TomatoSpring/assets/96871403/1ba998b9-8bb7-4de4-a032-c6ceb3639d87">
-> 로그아웃 했을때는 login 창, 로그인 했을 때는 logout 창 구현 (localStorage에서 토큰 인증 완료)

# 추가해야할 기능 
Docker 활용한 배포

