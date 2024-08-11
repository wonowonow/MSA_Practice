# MSA_Practice

기간 - 2024-08-06 ~ 2024-08-12

## Server Architecture
<img width="1567" alt="스크린샷 2024-08-11 오후 5 03 43" src="https://github.com/user-attachments/assets/f8e235de-db6b-4a88-80f9-b7b3c72e0e2a">

## 구현 목록
- 라운드 로빈 형식 로드밸런싱
- 주문 추가 시 FeignClient 로 상품 서버 상품 목록 요청 및 검증
- Zipkin Server 을 통한 분산 추적
- Redis를 이용한 상품 목록 및 주문 목록 캐싱
- 상품 추가 시 상품 목록 캐시 데이터 삭제
- Oauth2, JWT를 통한 인증/인가
- 로컬 및 서버 환경 분리
