package br.com.tardelli.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import org.springframework.stereotype.Repository;

import br.com.tardelli.model.Brand;

/**
 * @author: tardelli
 * 
 */
@Repository
public class BrandRepository {

	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager manager;

	@javax.transaction.Transactional
	public void save(Brand obj) {

		manager.persist(obj);
	}

	@javax.transaction.Transactional
	public void merge(Brand obj) {

		manager.merge(obj);
	}

	public Brand findById(int code) {

		return manager.find(Brand.class, code);
	}

	public void delete(int id) {

		Brand obj = this.findById(id);

		manager.remove(obj);

	}

	public List<Brand> findAll() {

		return manager.createQuery("SELECT c FROM Brand c ", Brand.class).getResultList();
	}

}
