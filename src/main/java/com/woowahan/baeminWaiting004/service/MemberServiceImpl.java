package com.woowahan.baeminWaiting004.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woowahan.baeminWaiting004.model.Member;
import com.woowahan.baeminWaiting004.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberRepository memberRepository;

	@Override
	public Member findByUsername(String name) {

		Member member = memberRepository.findByUsername(name);
		return member;
	}
}
