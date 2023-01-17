package com.sds.mvcOnboarding.repository;

import org.springframework.data.jpa.repository.JpaRepository;

interface MemberRepository extends JpaRepository<MemberEntity, Integer> {
}
