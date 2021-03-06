package com.worldbestsoft.dao;

import com.worldbestsoft.model.DocumentNumber;

public interface DocumentNumberDao extends GenericDao<DocumentNumber, Long> {

	public abstract DocumentNumber findByType(String type);

}