package com.automati.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.automati.dataentity.Person;

@Aspect
@Component
public class MailingAspect {
	
	@Autowired
	private JavaMailSender mailSender;

	@Pointcut("execution(* com.automati.service.PersonService.savePerson(..))")
	private void forRegisterUser() {}
	
	@Before("forRegisterUser()")
	public void beforeRegister(JoinPoint theJoinPoint) {
		
		String theMethod = theJoinPoint.getSignature().toShortString();
		
		Object[] args = theJoinPoint.getArgs();
		Person person = null;
		
		for (Object tempArg : args) {
			person = (Person) tempArg;
		}
		
		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(person.getEmail());
		email.setSubject("Welcome");
		email.setText("Welcome to Automati");
		
		// sends the e-mail
		mailSender.send(email);
	}
}
