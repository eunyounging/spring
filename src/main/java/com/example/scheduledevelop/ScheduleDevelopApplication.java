package com.example.scheduledevelop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ScheduleDevelopApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScheduleDevelopApplication.class, args);
	}

    // Lv1. 일정 CRUD
    // 일정을 생성, 조회, 수정, 삭제 가능
    // 작성자명, 할일 제목, 할일 내용, 작성일, 수정일
    // 작성일, 수정일 -> JPA Auditing 활용

    // API -> URL -> URL을 정의 -> Controller
    // Service
    // Repository -> DB

    // Entity
    // Dto

	// Lv2. 유저 CRUD
	// 유저 저장, 조회, 삭제
	// 유저명, 이메일, 작성일, 수정일
	// 작성일, 수정일 -> JPA Auditing 활용

	// 연관관계 구현
	// 일정 테이블이 작성 유저명 대신 유저 고유 식별자를 가집니다.

	// Lv3. 비밀번호 추가

	// Lv4. 로그인
	// Cookie/Session
	// Filter, @Configuration
	// 이메일, 비밀번호 사용하여 로그인
	// 회원가입, 로그인 요청은 인증 처리에서 제외
	// 이메일과 비밀번호가 일치하지 않을 경우 401 반환

	// 로그인 기능 구현
	// 세션 설정
	// 필터 구현
	// 등록
	// 테스트
}
