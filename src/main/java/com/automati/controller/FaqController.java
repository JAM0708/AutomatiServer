package com.automati.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.automati.dataentity.CreditCard;
import com.automati.dataentity.Faq;
import com.automati.dataentity.Lease;
import com.automati.dataentity.Person;
import com.automati.dto.CreditCardDTO;
import com.automati.dto.LeaseDTO;
import com.automati.dto.StatusCheck;
import com.automati.service.interfaces.CarServiceInterface;
import com.automati.service.interfaces.CreditCardServiceInterface;
import com.automati.service.interfaces.FaqServiceInterface;
import com.automati.service.interfaces.PersonServiceInterface;

@RestController
public class FaqController {
	
	@Autowired
	FaqServiceInterface faqService;
	
	
	@RequestMapping(path = "/getFaq", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Faq> getFaqs() {
		return faqService.getFaqs();
	}

}
