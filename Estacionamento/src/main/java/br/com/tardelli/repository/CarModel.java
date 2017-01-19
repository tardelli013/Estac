package br.com.tardelli.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.springframework.stereotype.Repository;

/**
 * @author: tardelli
 * 
 */
@Repository
public class CarModel {

	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager manager;

	@javax.transaction.Transactional
	public void save(CarModel obj) {

		manager.persist(obj);
	}

	@javax.transaction.Transactional
	public void merge(CarModel obj) {

		manager.merge(obj);
	}

	public CarModel findById(int code) {

		return manager.find(CarModel.class, code);
	}

	public void delete(int id) {

		CarModel obj = this.findById(id);

		manager.remove(obj);

	}

	public List<CarModel> findAll() {

		return manager.createQuery("SELECT c FROM CarModel c ", CarModel.class).getResultList();
	}

}
