package edu.sunway.pustak.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Blob;

@Entity
@Table(name="oauth_client_token")
public class OAuthClientToken {
	
	@Id
	private String token_id;

	private Blob token;

	private String authentication_id;
	
	private String user_name;

	private String client_id;

	public String getToken_id() {
		return token_id;
	}

	public void setToken_id(String token_id) {
		this.token_id = token_id;
	}

	public Blob getToken() {
		return token;
	}

	public void setToken(Blob token) {
		this.token = token;
	}

	public String getAuthentication_id() {
		return authentication_id;
	}

	public void setAuthentication_id(String authentication_id) {
		this.authentication_id = authentication_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getClient_id() {
		return client_id;
	}

	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}
}
