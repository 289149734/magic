/**
 * 
 */
package com.sjy.dict.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sjy.dict.domain.Dictionary;

/**
 * @copyright(c) Copyright SJY Corporation 2017.
 * 
 * @since 2017年3月29日
 * @author liyan
 * @e-mail 289149734@qq.com
 * 
 */
@Repository
public interface DictionaryRepository extends JpaRepository<Dictionary, String> {

	@Query("from Dictionary as o where o.category = ?1 order by o.code asc")
	List<Dictionary> findByCategory(String category);

	@Query("from Dictionary as o where o.category = ?1 and o.code = ?2")
	List<Dictionary> findByCategoryAndCode(String category, Integer code);

	@Query("from Dictionary as o order by o.category, o.code asc")
	List<Dictionary> findAll();
}
