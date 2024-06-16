# 캡스톤디자인 OfficeMate_ERP

## 📌프로젝트 개요
### 사내 인사/회계 관리 웹 시스템
회사 조직 내에서 각종 데이터를 활용하는 업무를 효율적으로 관리하기 위해 사용되는 자원 관리 소프트웨어 프로그램인 ERP(전사적 자원 관리) 시스템을 웹을 통하여 구현하였습니다.<br>
주요 기능은 공지사항 관리, 부서 관리, 업무 및 문서 관리, 근태(출퇴근) 관리와 기안서 작성 및 결재 기능, 급여 관리 등이 있습니다.
<hr>

## 👨🏻‍💻팀 구성 및 역할 분담
#### 정원준:
#### 신승철: Back-end, Cloud, GitHub 관리
#### 장성민:


## 🛠️기술 스택
#### Back-end

<img src="https://img.shields.io/badge/spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white"/> <img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white"/> <img alt="RED" src="https://camo.githubusercontent.com/7122c38c18f72432ed8e0269f5eccc729752384949ffeba63f6f19b342c64aff/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f4a4156412d3030343032372e7376673f267374796c653d666f722d7468652d6261646765266c6f676f3d4a616d65736f6e266c6f676f436f6c6f723d7768697465" data-canonical-src="https://img.shields.io/badge/JAVA-004027.svg?&amp;style=for-the-badge&amp;logo=Jameson&amp;logoColor=white" style="max-width: 100%;"> <img src="https://img.shields.io/badge/MyBatis-007396?style=for-the-badge&logo=mybatis&logoColor=white"/> <img src="https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white"/><br>


#### Front-end

<img src="https://img.shields.io/badge/html5-E34F26?style=for-the-badge&logo=html5&logoColor=white"/> <img src="https://img.shields.io/badge/css-1572B6?style=for-the-badge&logo=css3&logoColor=white"/> <img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black"/> <img src="https://img.shields.io/badge/Thymeleaf-005F0F?style=for-the-badge&logo=thymeleaf&logoColor=white"/><br>


#### DBMS

<img src="https://img.shields.io/badge/postgresql-4169E1?style=for-the-badge&logo=postgresql&logoColor=white"/><br>


#### Deploy

<img src="https://img.shields.io/badge/aws-232F3E?style=for-the-badge&logo=amazonaws&logoColor=white"/><br>

#### Collaboration Tool
<img src="https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github&logoColor=white"/> <img src="https://img.shields.io/badge/Slack-4A154B?style=for-the-badge&logo=slack&logoColor=white"/> <img src="https://img.shields.io/badge/Notion-000000?style=for-the-badge&logo=notion&logoColor=white"/> <img src="https://img.shields.io/badge/KakaoTalk-FFCD00?style=for-the-badge&logo=kakaotalk&logoColor=black"/><br>

<hr>

## Event Flow Diagram
![SoftwareFlow drawio](https://github.com/s-choory/OfficeMate_ERP/assets/135598730/b7a49c04-5809-4cca-ac8f-ef1dc3677ce6)

## ERD Diagram
![스크린샷 2024-06-16 오전 12 15 39](https://github.com/s-choory/OfficeMate_ERP/assets/135598730/c0c36766-86e7-41eb-855e-83a2ac1dad6b)

<hr>

## 🖥️주요 기능

### 공지사항 관리 <br>

![스크린샷 2024-06-16 185120](https://github.com/s-choory/OfficeMate_ERP/assets/130647831/e157d109-7fad-4001-845d-0d8883322a92)<br>
- 등록된 공지사항 목록 확인
- 공지사항 등록 기능(관리자)
- 공지사항 등록 시 사진 파일 첨부 기능(관리자)
<br>

![스크린샷 2024-06-16 185136](https://github.com/s-choory/OfficeMate_ERP/assets/130647831/09581de1-fb58-4ddc-a8af-455958e2df31)<br>
- 공지사항 상세 내용 확인
- 공지사항 수정 및 삭제 기능 (관리자)
<br>

### 부서 관리 <br>
![스크린샷 2024-06-16 185249](https://github.com/s-choory/OfficeMate_ERP/assets/130647831/d702428f-2412-4c10-b95b-1ec33a24fe6b)<br>
- 전체 부서 확인(관리자)
- 부서명 편집, 부서 등록 및 삭제 기능(관리자)
<br>

<img width="1444" alt="340080902-e186c557-6865-4b18-81ec-3a9ce46254ef" src="https://github.com/s-choory/OfficeMate_ERP/assets/130647831/08f48726-2145-4f56-bafe-ff8bb4c06ae1"><br>
- 부서 내 사원 정보 확인 기능
<br>

### 업무 관리 <br>
![스크린샷 2024-06-16 185332](https://github.com/s-choory/OfficeMate_ERP/assets/130647831/38c702d1-6ca8-4ad3-be6a-e91043143a3c)<br>
- 등록된 업무 목록 확인
- 업무 작업 상태,삭제 기능
- 전체 업무 목록 확인 기능(관리자)
<br>

![스크린샷 2024-06-16 185425](https://github.com/s-choory/OfficeMate_ERP/assets/130647831/cd7cfa2b-36db-4074-b9cb-0092272224f6)<br>
- 완료된 업무 목록 확인
<br>

![스크린샷 2024-06-16 185441](https://github.com/s-choory/OfficeMate_ERP/assets/130647831/5cce396b-6cfc-48c8-86ea-b35ed9da4f71)<br>
- 업무 상세 내용 저장 기능
<br>

### 문서 관리 <br>
![338836276-6396d8ba-6773-4636-a548-7fba63e63088](https://github.com/s-choory/OfficeMate_ERP/assets/130647831/7f4763e6-e2d7-4ca7-afdf-58d3c627e158)<br>
- 등록된 문서 목록 확인
- 문서 등록 기능
- 문서 등록 시 문서 파일 첨부 기능
- 전체 문서 목록 확인 기능(관리자)
<br>

<img width="1420" alt="340079609-1b3517a3-7a4d-4e96-86f1-68dc802396ab" src="https://github.com/s-choory/OfficeMate_ERP/assets/130647831/fa237524-ace3-44d7-8461-ba3601f7ba19"><br>
- 문서 세부 내용 확인
- 문서 첨부 파일 버전 관리 기능
- 문서 첨부 파일 다운로드 기능
- 문서 수정, 삭제, 공유 기능
<br>

### 근태 관리 <br>
- 출퇴근 등록 기능은 홈 화면에 통합
<br>
<img width="1450" alt="340079203-190f869b-1e87-42f6-98ff-af33a9bc1371" src="https://github.com/s-choory/OfficeMate_ERP/assets/130647831/7370487e-45ff-4168-a7de-83d63aec12fa"><br>
- 출퇴근 기록 확인
- 다른 사용자 출퇴근 기록 확인 기능(관리자)
<br>

### 결재 관리 <br>
![스크린샷 2024-06-16 185521](https://github.com/s-choory/OfficeMate_ERP/assets/130647831/a79f4674-682e-4a70-8623-84e84a315496)<br>
- 등록된 기안서 목록 확인
- 기안서 등록 기능
- 결재된 기안서 목록 확인 기능
<br>

<img width="1059" alt="338835739-ed739805-b84b-4688-abf1-acddc9b27263" src="https://github.com/s-choory/OfficeMate_ERP/assets/130647831/937eb1f0-5ad7-4768-a932-14979a783ff2"><br>
- 기안서 결재 기능
<br>

### 급여 관리<br>
<img width="1149" alt="338829700-e79a4824-59ae-412f-93dc-e893ac868b10" src="https://github.com/s-choory/OfficeMate_ERP/assets/130647831/5a5f3c72-867c-47ba-a3e8-a8a3d68475a6"><br>
- 급여 지급 기록 확인 기능
<br>

<img width="1319" alt="338831651-4acb1d61-f070-46af-81fc-dc9bbd58df31" src="https://github.com/s-choory/OfficeMate_ERP/assets/130647831/d4138264-b643-4eae-a112-0d545f7c5b49"><br>
- 급여 명세서 확인
- 급여 명세서 인쇄 기능
- 해당 사원 보너스 급여 지급 기능
<br>

<img width="1167" alt="338833008-e1cd4db4-3896-4da5-afe5-086b8995b524" src="https://github.com/s-choory/OfficeMate_ERP/assets/130647831/30c769a0-4d64-4a88-987c-f9a6cdb214a6"><br>
- 급여 대장 기능
<br>


