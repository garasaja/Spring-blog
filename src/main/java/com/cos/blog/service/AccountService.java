package com.cos.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.dto.SendRequestDto;
import com.cos.blog.dto.WithdrawRequestDto;
import com.cos.blog.model.Account;
import com.cos.blog.repository.AccountRepository;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Transactional  //롤백 커밋 알아서 됨
	public void 송금(SendRequestDto dto) {

		//홍길동 -> 장보고 에게 송금
		//보내는사람 업데이트
		Account 홍길동 = accountRepository.findByAccountNumber(dto.getSenderAccountNumber());
		홍길동.setMoney(홍길동.getMoney()-dto.getMoney());
		accountRepository.update(홍길동);
		
		//받는사람 업데이트
		Account 장보고 = accountRepository.findByAccountNumber(dto.getReceiverAccountNumber());
		장보고.setMoney(장보고.getMoney()+dto.getMoney());
		accountRepository.update(장보고);
	}
	
	@Transactional  //롤백 커밋 알아서 됨
	public void 인출(WithdrawRequestDto dto) {
		Account 홍길동 = accountRepository.findByAccountNumber(dto.getAccountNumber());
		홍길동.setMoney(홍길동.getMoney()-dto.getMoney());
		accountRepository.update(홍길동);
	}
	
	@Transactional(readOnly = true)  //고립성
	public List<Account> 계좌정보보기() {
		return accountRepository.findAll();
	}
}
