package com.automati.service.interfaces;

public interface GenericServiceInterface {
	
		public  <T>  void save(T object) ;
	
		public  <T>  void delete(T object) ;
		
		public <T> void update(T object);

}
