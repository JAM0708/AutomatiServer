package com.automati.service.interfaces;

import java.util.List;

import com.automati.dataentity.Faq;

public interface FaqServiceInterface extends GenericServiceInterface {
	public List<Faq> getFaqs();
}
