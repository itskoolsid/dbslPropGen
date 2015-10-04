package com.dbsl.proposalgenerator.dao;

import java.util.List;

import com.dbsl.proposalgenerator.beans.Privilege;

public interface PrivilegeDAO {

	public void addPrivilege(Privilege privilege);

	public Privilege getPrivilegeByName(String privilegeName);

	public Privilege getPrivilegeById(Integer privilegeId);

	public void deletePrivilegeByName(String rivilegeName);

	public Privilege searchPrivilegeByName(String privilegeName);

	public List<Privilege> getAllPrivilege();
}
