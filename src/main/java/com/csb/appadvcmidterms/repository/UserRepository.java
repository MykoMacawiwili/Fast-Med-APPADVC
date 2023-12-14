package com.csb.appadvcmidterms.repository;

import com.csb.appadvcmidterms.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByEmailAddress(String emailAddress);
}
