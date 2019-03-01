package com.proyecto.server.active;

import org.springframework.boot.SpringApplication;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.ldap.filter.AndFilter;
import org.springframework.ldap.filter.EqualsFilter;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.proyecto.server.ServerApplication;

@Controller
public class ActiveDirective {
	
	public static void main(String[] args) {
		
		try
		{
			LdapContextSource lda = new LdapContextSource();
			lda.setUrl("ldap://ldap.forumsys.com:398");
			lda.setBase("dc=example,dc=com");
			lda.setUserDn("cn=read-only-admin,dc=example,dc=com");
			lda.setPassword("password");
			lda.afterPropertiesSet();
			LdapTemplate lt = new LdapTemplate();

			// Text Query
			AndFilter filter = new AndFilter();
			filter.and(new EqualsFilter("objectclass", "Person"));
			@SuppressWarnings("unchecked")
			List<String> list = lt.search("", filter.encode(), new ContactAttributeMapperJson());
			System.out.println(list.toString());
		}catch(
		Exception e)
		{
			e.printStackTrace();
		}
	}


}