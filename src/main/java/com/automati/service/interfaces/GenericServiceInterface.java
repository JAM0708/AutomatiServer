package com.automati.service.interfaces;

import com.automati.dto.StatusCheck;

public interface GenericServiceInterface {
	
		public  <T>  StatusCheck  save(T object) ;
	
		public  <T>  void delete(T object) ;
		
		public <T> void update(T object);

}
