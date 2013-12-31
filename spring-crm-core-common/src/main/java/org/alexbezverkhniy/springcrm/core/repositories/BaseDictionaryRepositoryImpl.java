package org.alexbezverkhniy.springcrm.core.repositories;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.alexbezverkhniy.springcrm.core.domain.dictionaries.BaseDictionary;

/**
 * Implementation for the custom repository functionality declared in {@link BaseDictionaryRepository} based on JPA. 
 * 
 * @author Alexander Bezverkhniy
 *
 * @param <T> - Generic class of Model
 * @param <ID> - Generic class of ID
 */
public class BaseDictionaryRepositoryImpl<T extends BaseDictionary, ID extends Serializable> implements BaseDictionaryRepository<T, ID>{

	private Class<T> modelType;
	//private Class<ID> idType;
	
	@PersistenceContext private EntityManager em;

	/**
	 * Configure the entity manager to be used.
	 * 
	 * @param em the {@link EntityManager} to set.
	 */
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}


	public T findByCode(String code) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = builder.createQuery(this.modelType);
		Root<T> entityRoot =criteriaQuery.from(this.modelType);		
		criteriaQuery.select(entityRoot);
		criteriaQuery.where(builder.equal(entityRoot.get("code"), code));
		
		return em.createQuery(criteriaQuery).getSingleResult();
	}
	

	public List<T> findByName(String name) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = builder.createQuery(this.modelType);
		Root<T> entityRoot =criteriaQuery.from(this.modelType);		
		criteriaQuery.select(entityRoot);
		criteriaQuery.where(builder.equal(entityRoot.get("name"), name));
		
		return em.createQuery(criteriaQuery).getResultList();
	}

}
