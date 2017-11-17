package com.automati.dataentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="faq")
public class Faq {
	
	@Id
	@Column(name="faq_id")
	@SequenceGenerator(name="faqSeq", sequenceName="faq_Seq", allocationSize=1)
	@GeneratedValue(generator="faqSeq", strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="question")
	private String question;
	
	@Column(name = "answer")
	private String answer;
	
	public Faq() {
	}

	public Faq(int id, String question, String answer) {
		this.id = id;
		this.question = question;
		this.answer = answer;
	}

	public Faq(String question, String answer) {
		this.question = question;
		this.answer = answer;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Faq [id=" + id + ", question=" + question + ", answer=" + answer + "]";
	}
	
	
	

	
}
