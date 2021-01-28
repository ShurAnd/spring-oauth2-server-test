package org.andrey.springoauth2servertest.user.persistence;

import org.andrey.springoauth2servertest.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	public User findUserByUsername(String username);
}
