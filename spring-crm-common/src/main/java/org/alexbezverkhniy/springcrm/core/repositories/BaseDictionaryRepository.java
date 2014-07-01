package org.alexbezverkhniy.springcrm.core.repositories;

import java.io.Serializable;
import java.util.List;

import org.alexbezverkhniy.springcrm.core.domain.dictionaries.BaseDictionary;
/**
 * Interface for repository functionality of dictionary
 * 
 * @author Alexander Bezverkhniy
 *
 * @param <T> - Generic class of Model
 * @param <ID> - Generic class of ID
 */
public interface BaseDictionaryRepository<T extends BaseDictionary, ID extends Serializable> {
	/**
	 * Find data of dictionary by <pre>code</pre>
	 * @param code - Code of data 
	 * @return dictionary data
	 */
	T findByCode(String code);
	
	/**
	 * Find data of dictionary by <pre>name</pre>
	 * @param name - Name of data   
	 * @return dictionary data list
	 */
	List<T> findByName(String name);
}
