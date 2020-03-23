package edu.sunway.pustak.repositories;

import edu.sunway.pustak.entity.OAuthAccessToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OAuthAccessTokenRepository extends JpaRepository<OAuthAccessToken, String> {
	
	@Query("Select o from OAuthAccessToken o where o.user_name=?1")
	List<OAuthAccessToken> findByUsername(String userName);

	@Query("Select count(o) from OAuthAccessToken o where o.user_name=?1")
	Long countByUsername(String userName);

	@Query("Delete from OAuthAccessToken o where o.user_name=?1")
	void deleteByUsername(String userName);

}
