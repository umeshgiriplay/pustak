package edu.sunway.pustak.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Blob;

@Entity
@Table(name="oauth_code")
public class OAuthCode {

		@Id
		private String code;
		
		private Blob authentication;

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public Blob getAuthentication() {
			return authentication;
		}

		public void setAuthentication(Blob authentication) {
			this.authentication = authentication;
		}

		

}
