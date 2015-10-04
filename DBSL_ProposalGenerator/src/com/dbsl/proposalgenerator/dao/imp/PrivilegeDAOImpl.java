package com.dbsl.proposalgenerator.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;

import com.dbsl.proposalgenerator.beans.Privilege;
import com.dbsl.proposalgenerator.dao.PrivilegeDAO;
import com.vaadin.addon.jpacontainer.JPAContainer;
import com.vaadin.addon.jpacontainer.JPAContainerFactory;

public class PrivilegeDAOImpl implements PrivilegeDAO {
	final String PERSISTENCE_UNIT = "dbsl";
	JPAContainer<Privilege> empcontainer = JPAContainerFactory.make(
			Privilege.class, PERSISTENCE_UNIT);
	// Get an entity manager
	EntityManager em = empcontainer.getEntityProvider().getEntityManager();

	@Override
	public void addPrivilege(Privilege privilege) {
		empcontainer.addEntity(privilege);
	}

	@Override
	public Privilege getPrivilegeByName(String privilegeName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Privilege getPrivilegeById(Integer privilegeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePrivilegeByName(String rivilegeName) {
		// TODO Auto-generated method stub

	}

	@Override
	public Privilege searchPrivilegeByName(String privilegeName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Privilege> getAllPrivilege() {
		// TODO Auto-generated method stub
		return null;
	}

}
