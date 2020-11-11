package com.customer.dao;

public class DaoException extends Exception{
	public DaoException(String message, Throwable throwable) {
		super(message, throwable);
	}
	
	public DaoException(String message) {
		super(message);
	}
}
