/*
 * Optimized Java Swing Application Demo
 * Copyright(c) 2018, enuminfo.com
 */
package com.enuminfo.optimized.backend.repository;

import com.enuminfo.optimized.backend.JpaUtil;
import com.enuminfo.optimized.backend.entity.BaseEntity;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * Abstract Repository for all repositories.
 * @param <T> entity
 * @author Kumar
 */
@SuppressWarnings("unchecked")
public abstract class AbstractRepository<T extends BaseEntity> {

	private EntityManager entityManager;
	private final Class<T> entityClass;

	public AbstractRepository(Class<T> entityClass) {
		this.entityClass = entityClass;
	}
	
	public EntityManager getEntityManager() {
		if (entityManager == null)
			entityManager = JpaUtil.getEntityManager();
		return entityManager;
	}

	public Class<T> getEntityClass() {
		return entityClass;
	}

	public T save(T entity) {
		getEntityManager().getTransaction().begin();
		getEntityManager().persist(entity);
		getEntityManager().getTransaction().commit();
		return entity;
	}

	public T saveOrUpdate(T entity) {
		getEntityManager().getTransaction().begin();
		entity = getEntityManager().merge(entity);
		getEntityManager().getTransaction().commit();
		return entity;
	}

	public void delete(T entity) {
		getEntityManager().getTransaction().begin();
		getEntityManager().remove(getEntityManager().merge(entity));
		getEntityManager().getTransaction().commit();
	}

	public T find(Integer id) {
		return getEntityManager().find(entityClass, id);
	}

	public List<T> findWithNamedQuery(String namedQueryName) {
		return getEntityManager().createNamedQuery(namedQueryName).getResultList();
	}

	public List<T> findWithNamedQuery(String namedQueryName, int resultLimit) {
		return getEntityManager().createNamedQuery(namedQueryName).setMaxResults(resultLimit).getResultList();
	}

	public List<T> findWithNamedQuery(String namedQueryName, Map<String, Object> parameters) {
		return findWithNamedQuery(namedQueryName, parameters, 0);
	}

	public List<T> findWithNamedQuery(String namedQueryName, Map<String, Object> parameters, int resultLimit) {
		Set<Entry<String, Object>> params = parameters.entrySet();
		Query query = getEntityManager().createNamedQuery(namedQueryName);
		if (resultLimit > 0)
			query.setMaxResults(resultLimit);
		for (Entry<String, Object> entry : params)
			query.setParameter(entry.getKey(), entry.getValue());
		return query.getResultList();
	}
	
	public List<T> findWithNamedQuery(String namedQueryName, Map<String, Object> parameters, int start, int end) {
		Set<Entry<String, Object>> params = parameters.entrySet();
		Query query = getEntityManager().createNamedQuery(namedQueryName);
		for (Entry<String, Object> entry : params)
			query.setParameter(entry.getKey(), entry.getValue());
		query.setMaxResults(end - start);
		query.setFirstResult(start);
		return query.getResultList();
	}

	public List<T> findWithNamedQuery(String namedQueryName, int start, int end) {
		Query query = getEntityManager().createNamedQuery(namedQueryName);
		query.setMaxResults(end - start);
		query.setFirstResult(start);
		return query.getResultList();
	}

	public List<T> findByNativeQuery(String sql) {
		return getEntityManager().createNativeQuery(sql, entityClass).getResultList();
	}

	public List<T> findByNativeQuery(String sql, int resultLimit) {
		return getEntityManager().createNativeQuery(sql, entityClass).setMaxResults(resultLimit).getResultList();
	}
	
	public List<T> findByNativeQuery(String sql, int start, int end) {
		Query query = getEntityManager().createNativeQuery(sql, entityClass);
		query.setMaxResults(end - start);
		query.setFirstResult(start);
		return query.getResultList();
	}
}
