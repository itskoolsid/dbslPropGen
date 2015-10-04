package com.dbsl.proposalgenerator.dao.imp;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.dbsl.proposalgenerator.beans.Solution;
import com.dbsl.proposalgenerator.dao.SolutionDAO;
import com.vaadin.addon.jpacontainer.JPAContainer;
import com.vaadin.addon.jpacontainer.JPAContainerFactory;

public class SolutionDAOImpl implements SolutionDAO {
	final String PERSISTENCE_UNIT = "dbsl";
	JPAContainer<Solution> container = JPAContainerFactory.make(Solution.class,
			PERSISTENCE_UNIT);
	// Get an entity manager
	EntityManager em = container.getEntityProvider().getEntityManager();

	@Override
	public void addSolution(Solution solution) {
		container.addEntity(solution);
	}

	@Override
	public Solution getSolution(Integer solutionId) {
		return (Solution) container.getItem(solutionId);
	}

	@Override
	public Solution getSolutionByName(String solutionName) {
		em.getTransaction().begin();
		/*
		 * CriteriaQuery<Employee> criteria =
		 * em.getCriteriaBuilder().createQuery(Employee.class); Root<Employee>
		 * root = criteria.from(Employee.class);
		 * criteria.select(root).where(em.getCriteriaBuilder
		 * ().equal(root.get("name"), empName));
		 */
		Query query = em
				.createNativeQuery("SELECT FROM Person p WHERE p.name=:empName");
		query.setParameter("empName", solutionName);
		Solution sol = (Solution) query.getSingleResult();
		em.getTransaction().commit();
		return sol;
	}

}
