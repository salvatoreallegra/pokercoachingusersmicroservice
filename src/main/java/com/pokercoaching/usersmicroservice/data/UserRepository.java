package com.pokercoaching.usersmicroservice.data;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Users, Long> {
          Users findByEmail(String email);

}
