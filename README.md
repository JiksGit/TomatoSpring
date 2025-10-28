# 🍅 Tomato Disease Classification Web Service

> **AI 모델을 활용하여 토마토 잎의 질병을 자동 분류하고 정보를 제공하는 Spring 기반 웹서비스**

---

## 📘 프로젝트 개요

**TomatoSpring**은 CNN 기반 인공지능 모델을 활용해  
토마토 잎의 이미지를 분석하고, 질병 유형 및 해결 방안을 사용자에게 제공합니다.  
또한 커뮤니티 기능을 통해 사용자 간 정보 공유가 가능하며,  
Docker 기반으로 AWS EC2에 배포된 **AI + Spring Boot 통합 서비스**입니다.

> 🎯 **목표:** 이미지 분석 AI 모델을 실서비스 환경에 통합하고,  
> 사용자가 농작물 질병을 빠르게 진단·대응할 수 있도록 지원하는 플랫폼 구현

---

## ⚙️ 기술 스택

### 🧩 Backend
![Java](https://img.shields.io/badge/Java-%23ED8B00.svg?style=flat-square&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=flat-square&logo=springboot&logoColor=white)
![Spring Security](https://img.shields.io/badge/Spring_Security-6DB33F?style=flat-square&logo=springsecurity&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-black?style=flat-square&logo=jsonwebtokens&logoColor=white)
![MyBatis](https://img.shields.io/badge/MyBatis-FF6C37?style=flat-square&logoColor=white)

### 🧠 AI Model
![Python](https://img.shields.io/badge/Python-3776AB?style=flat-square&logo=python&logoColor=white)
![PyTorch](https://img.shields.io/badge/PyTorch-EE4C2C?style=flat-square&logo=pytorch&logoColor=white)
![DenseNet161](https://img.shields.io/badge/DenseNet161-FF6F00?style=flat-square&logo=googlecolab&logoColor=white)

> Kaggle 토마토 질병 이미지 데이터셋을 활용하여 **DenseNet161** 모델로 전이 학습 (정확도 98%)  
> Flask REST API를 통해 Spring 서버와 AI 모델을 연동하여 결과 반환

### ☁️ Infra & DevOps
![Docker](https://img.shields.io/badge/Docker-2496ED?style=flat-square&logo=docker&logoColor=white)
![AWS](https://img.shields.io/badge/AWS_EC2-232F3E?style=flat-square&logo=amazonaws&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-005C84?style=flat-square&logo=mysql&logoColor=white)
![Swagger](https://img.shields.io/badge/Swagger-85EA2D?style=flat-square&logo=swagger&logoColor=black)
![Kakao Map API](https://img.shields.io/badge/Kakao_Map_API-FFCD00?style=flat-square&logo=kakao&logoColor=black)

---

## 🧩 주요 기능

| 기능 | 설명 |
|------|------|
| 🧠 **AI 질병 분석** | 사용자가 업로드한 잎 이미지를 DenseNet161 모델로 분석하여 질병 유형 및 해결 방안 제시 |
| 👥 **회원가입 / 로그인** | JWT 기반 인증 구조로 세션 부하를 줄이고 보안 강화 |
| 💬 **게시판 및 댓글 기능** | 사용자 간 정보 공유를 위한 커뮤니티 구현 |
| 🗺️ **주변 마트 검색** | Kakao Map API를 통한 주변 농협 마트 검색 기능 |
| ⚙️ **Swagger 문서화** | 백엔드 API 명세 자동화로 유지보수성 향상 |
| 🚀 **Docker + AWS 배포** | Docker 컨테이너로 EC2에 배포하여 안정적인 운영 환경 구성 |

---

## 🧾 시스템 구조

- **Spring Boot**: 회원, 게시판, 인증, 요청 처리  
- **Flask API**: 이미지 업로드 → AI 예측 결과 반환  
- **AWS EC2 + Docker**: 웹·AI 서버 컨테이너화 및 자동 배포  
- **MySQL**: 사용자 및 질병 데이터 관리  

---

## ⚡ 트러블슈팅 & 개선

- **문제:** AI 서버와 Spring 간 이미지 전송 시 Request Timeout 발생  
  → **해결:** Multipart 요청 전송 방식을 비동기로 전환하고, Flask 서버 응답 타임아웃을 조정  

- **문제:** Swagger API 문서가 Docker 환경에서 인식되지 않음  
  → **해결:** 컨테이너 내부 경로와 호스트 포트를 일치시켜 엔드포인트 접근 정상화  

- **문제:** 게시판 등록 중 파일 업로드 실패 시 데이터 불일치  
  → **해결:** 트랜잭션 적용으로 파일 저장 실패 시 DB 롤백 처리  

> ✅ 결과: AI 모델 응답 안정성 향상, 서비스 배포 자동화, 데이터 무결성 강화  

---

## 🧠 배운 점

- AI 모델을 **Flask REST API**로 분리해 Spring과 연동하는 구조 이해  
- **JWT 인증**, **트랜잭션 처리**, **Docker 배포 자동화** 경험  
- 실시간 위치 기반 API(Kakao Map) 및 클라우드 배포의 연계성 학습  
- Spring + AI + Cloud를 연결한 **엔드투엔드 백엔드 구조 경험**

---

## 📫 Contact

📧 **Email:** yanghyunjik99@gmail.com  
🌐 **Notion Portfolio:** [yanghyunjik.notion.site](https://chatter-glider-3f4.notion.site/292b5b4ec16181578fc5dc7a69780ad3)

---

> 🍅 *TomatoSpring — AI로 농작물 질병을 빠르게 진단하고,  
> 사용자와 정보를 공유하는 스마트 농업 플랫폼*
