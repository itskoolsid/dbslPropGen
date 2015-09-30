package com.dbsl.proposalgenerator.dao.imp;

import java.util.List;

<<<<<<< HEAD
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.dbsl.proposalgenerator.beans.Employee;
import com.dbsl.proposalgenerator.dao.EmployeeDAO;
import com.vaadin.addon.jpacontainer.JPAContainer;
import com.vaadin.addon.jpacontainer.JPAContainerFactory;

public class EmployeeDAOImpl implements EmployeeDAO {
    final String PERSISTENCE_UNIT = "dbsl";
    JPAContainer<Employee> empcontainer = JPAContainerFactory.make(Employee.class, PERSISTENCE_UNIT);
    // Get an entity manager
    EntityManager em = empcontainer.getEntityProvider().getEntityManager();

    @Override
    public void addEmployee(Employee employee) {
        empcontainer.addEntity(employee);
    }

    @Override
    public Employee getEmployeeByName(String empName) {
        // Do a query
        em.getTransaction().begin();
        /*
         * CriteriaQuery<Employee> criteria = em.getCriteriaBuilder().createQuery(Employee.class); Root<Employee> root =
         * criteria.from(Employee.class); criteria.select(root).where(em.getCriteriaBuilder().equal(root.get("name"), empName));
         */
        Query query = em.createNativeQuery("SELECT FROM Person p WHERE p.name=:empName");
        query.setParameter("empName", empName);
        Employee emp = (Employee) query.getSingleResult();
        em.getTransaction().commit();
        return emp;
    }

    @Override
    public void deleteEmployeeByName(String empName) {

    }

    @Override
    public List<Employee> getAllEmployee() {
        return null;
    }

    @Override
    public Employee getEmployeeById(Integer empId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Employee searchEmployeeByName(String empName) {
        // TODO Auto-generated method stub
        return null;
    }

}
