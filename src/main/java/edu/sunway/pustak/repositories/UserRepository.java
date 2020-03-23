package edu.sunway.pustak.repositories;

import edu.sunway.pustak.dto.UserDTO;
import edu.sunway.pustak.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    @Query("select u from User u where u.userName=?1")
     User findByUsername(String username);


}