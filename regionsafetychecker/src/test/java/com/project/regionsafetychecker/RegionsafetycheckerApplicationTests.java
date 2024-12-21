package com.project.regionsafetychecker;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.regionsafetychecker.entities.Address;
import com.project.regionsafetychecker.entities.DocNumber;
import com.project.regionsafetychecker.entities.Documents;
import com.project.regionsafetychecker.entities.Locations;
import com.project.regionsafetychecker.entities.ModeOfTransport;
import com.project.regionsafetychecker.entities.Reviews;
import com.project.regionsafetychecker.entities.User;
import com.project.regionsafetychecker.repo.LocationRepo;
import com.project.regionsafetychecker.repo.UserRepo;

import jakarta.transaction.Transactional;

@SpringBootTest()
class RegionsafetycheckerApplicationTests {
	@Autowired
	UserRepo repo;
	@Autowired
	LocationRepo repositary;

	@Test
	void saveUserTest() {
		User user = new User();
		user.setFName("Joan");
		user.setSurName("Blake");
		user.setUserName("JKl98");
		user.setEmail("Joan@gmail.com");
		Address address = new Address();
		address.setContactDetails("harsh123");
		address.setLine1("120 lalaland");
		address.setLine2("LONDON");
		address.setZipCode("Zn4PC".toUpperCase());
		Reviews review = new Reviews();;
		review.setReview("Good Safety");
		review.setTitle("Nice");
		//review.setUser(user);
		user.addNewReviews(review);
		user.setReviewList(List.of(review));
		user.setAddress(address);
		Documents doc = new Documents();
		doc.setUser(user);
		doc.setType("Aadhar");
		DocNumber docNumber = new DocNumber();
		docNumber.setNumber("LSK2134fsrr 9009041");
		docNumber.setStart(LocalDate.now());
		docNumber.setEnd(LocalDate.now().plusYears(10));
		doc.setDocNumber(docNumber);
		user.setDocument(doc);
		repo.save(user);
		

	}
	
	
	@Test
//	@Transactional
	void getUserData() {
		Optional<User> findById = repo.findById(252L);
		if(findById.isEmpty()) {
	      System.out.println("No resource found");
		}
		else {
			System.out.println(findById.get().getReviewList());
			System.out.println(findById.get().getDocument());
		}
		
	}
	
	@Test
	void updateUserDetails() {
		Optional<User> findById = repo.findById(52L);
		User user = findById.get();
		user.setFName("Luca");
		List<Reviews> reviewList = user.getReviewList();
		reviewList.get(0).setReview("Oh my god");
		user.setReviewList(reviewList);
		repo.save(user);
		user.getReviewList().forEach(c->System.out.println(c.getReview()));

	}
	
	@Test
	void deleteUserDetails() {
		Optional<User> findById = repo.findById(52L);
		User user = findById.get();
		repo.delete(user);
	}
	
	
	@Test
	void addnewLocation() {
		Locations loc = new Locations();
		loc.setLocationName("Belapur");
		ModeOfTransport e1 = new ModeOfTransport();
		e1.setPlaceName("Belapur Station");
		e1.setDescription("Trains yto all major stations available here");
		e1.setLocation(List.of(loc));
		loc.setModesofTransport(List.of(e1));
		repositary.save(loc);
	}

}
