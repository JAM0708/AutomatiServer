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

@Aspect
@Component
public class MailingAspect {

	private Logger logger = Logger.getLogger(MailingAspect.class);

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private TemplateEngine templateEngine;

	@Pointcut("execution(* com.automati.controller.PersonController.register(..))")
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

		// Prepare message using a Spring helper
		final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
		MimeMessageHelper message;
		try {
			message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
			message.setSubject("Welcome");
		//	message.setFrom("thymeleaf@example.com");
			message.setTo(person.getEmail());
			// Create the HTML body using Thymeleaf
			final String htmlContent = this.templateEngine.process("email", ctx);
			message.setText(htmlContent, true /* isHtml */);
			
			try {
				InputStreamSource imageSource = new ByteArrayResource(IOUtils.toByteArray(getClass().getResourceAsStream("/images/car.jpg")));
				message.addInline("car.jpg", imageSource, "image/jpg");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Send email
		this.mailSender.send(mimeMessage);

		/*
		 * Context ctx = new Context(); ctx.setVariable("name",
		 * person.getFirstName() + " " + person.getLastName());
		 * 
		 * MimeMessagePreparator messagePreparator = mimeMessage -> {
		 * logger.info("Entering message helpeer"); MimeMessageHelper
		 * messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
		 * messageHelper.setFrom("Automati@gmail.com");
		 * messageHelper.setTo(person.getEmail());
		 * messageHelper.setSubject("Welcome to Automati"); logger.info("here");
		 * final String htmlContent = this.templateEngine.process("email", ctx);
		 * messageHelper.setText(htmlContent, true);
		 * logger.info(messageHelper.toString()); }; try {
		 * logger.info(messagePreparator.toString());
		 * mailSender.send(messagePreparator); } catch (MailException e) { //
		 * runtime exception; compiler will not force you to handle it
		 * logger.info(e.getMessage()); logger.info("failed to send"); }
		 */
	}
}
