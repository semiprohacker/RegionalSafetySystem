package com.project.regionsafetychecker;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.regionsafetychecker.entities.User;
import com.project.regionsafetychecker.repo.UserRepo;

@SpringBootTest()
class RegionsafetycheckerApplicationTests {
	@Autowired
	UserRepo repo;

	@Test
	void saveUserTest() {
		User user = new User();
		user.setFName("Harsh");
		user.setSurName("Rathore");
		user.setUserName("harsh98");
		user.setEmail("harsh98@gmail.com");
		repo.save(user);
		

	}

}
