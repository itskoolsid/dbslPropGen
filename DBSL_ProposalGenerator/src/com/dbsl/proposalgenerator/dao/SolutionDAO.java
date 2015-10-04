package com.dbsl.proposalgenerator.dao;

import com.dbsl.proposalgenerator.beans.Solution;

public interface SolutionDAO {

	public void addSolution(Solution solution);

	public Solution getSolution(Integer solutionId);

	public Solution getSolutionByName(String solutionName);
}
