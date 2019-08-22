package edu.sunway.pustak.repositories;

import edu.sunway.pustak.entity.OAuthClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OAuthClientRepository extends JpaRepository<OAuthClient, String> {
	
	@Query("select c from OAuthClient c order by c.clientId asc")
	List<OAuthClient> getAllOAuthClient();

}
