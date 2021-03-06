package fr.epita.quiz.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

public abstract class GerneralDAO<T,I> {
	
	@PersistenceContext
	protected EntityManager em;
	
	@Transactional(value = TxType.REQUIRED)
	public void create(T entity) {	
		em.persist(entity);
		
	}
	
	@Transactional(value = TxType.REQUIRED)
	public void update(T entity) {
		em.merge(entity);
	}

	@Transactional(value = TxType.REQUIRED)
	public void delete(T entity) {
		em.remove(entity);
	}
	
	public abstract List<T> search(T criteria);
	public abstract T getById(I id);
}
