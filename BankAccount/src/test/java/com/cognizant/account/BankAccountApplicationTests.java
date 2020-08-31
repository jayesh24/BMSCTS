package com.cognizant.account;

import static org.mockito.Mockito.when;

//import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;
import com.cognizant.account.dao.AccountRepository;
import com.cognizant.account.model.Account;
import com.cognizant.account.service.AccountServiceImpl;

@RunWith(SpringRunner.class)

@SpringBootTest
public class BankAccountApplicationTests {

	@MockBean
	AccountRepository repo;
	
	@Autowired
	AccountServiceImpl service;
	
	@Test
	public void saveAccountService()
	
		{
		Account dao=new Account(1, 1234561234, "SBI123", "SBI", 1, 111100);
		when(repo.save(dao)).thenReturn(dao);
		equals(repo.save(dao));
		}

}



