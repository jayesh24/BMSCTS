package com.cts;

import static org.mockito.Mockito.when;

//import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;
import com.cts.model.UserDao;
import com.cts.model.UserDto;
import com.cts.repository.UserRepository;
import com.cts.service.UserserviceImpl;
@RunWith(SpringRunner.class)

@SpringBootTest
public class UserRegisterServiceApplicationTests {
	@MockBean
	UserRepository repo;
	@Autowired
	UserserviceImpl service;
	@Test
	public void  saveUserService()
	
		{
		UserDao dao=new UserDao(1,"name","JSCPS0082J","jasd12","8989898988","jaye@gmail.com");
		when(repo.save(dao)).thenReturn(dao);
		equals(repo.save(dao));
		}

}
