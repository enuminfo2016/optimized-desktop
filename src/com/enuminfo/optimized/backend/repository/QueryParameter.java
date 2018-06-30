/*
 * 
 */
package com.enuminfo.optimized.backend.repository;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kumar
 */
public class QueryParameter {

	private Map<String, Object> parameters;

	private QueryParameter(String name, Object value) {
		parameters = new HashMap<>();
		parameters.put(name, value);
	}

	public static QueryParameter with(String name, Object value) {
		return new QueryParameter(name, value);
	}

	public QueryParameter and(String name, Object value) {
		parameters.put(name, value);
		return this;
	}

	public Map<String, Object> parameters() {
		return parameters;
	}
}
