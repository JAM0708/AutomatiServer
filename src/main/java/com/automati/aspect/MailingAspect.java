package com.automati.aspect;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import com.automati.dataentity.Person;
import com.automati.service.interfaces.PersonServiceInterface;

@Aspect
@Component
public class MailingAspect {

	private Logger logger = Logger.getLogger(MailingAspect.class);

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private TemplateEngine templateEngine;
	
	@Autowired
	PersonServiceInterface personService;

	@Pointcut("execution(* com.automati.repo.PersonRepo.save(..))")
	private void forRegisterUser() {
	}

	@Before("forRegisterUser()")
	public void beforeRegister(JoinPoint theJoinPoint) {

		String theMethod = theJoinPoint.getSignature().toShortString();
		logger.info(theMethod);

		Object[] args = theJoinPoint.getArgs();
		final Person person = (Person) args[0];

		logger.info(person.toString());

		final Context ctx = new Context();
		ctx.setVariable("name", person.getFirstName() + " " + person.getLastName());
		ctx.setVariable("imageResourceName", "car.jpg");
		
		personService.sendEmail("email", ctx, "email", "car.jpg", "Welcome");
	}
}
