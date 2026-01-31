package com.jalanocca.bat_backend.service;

public interface GitService {
	void executeClone(String basePath, String repoUrl);
	void executePull(String basePath);
	void executeFetch(String basePath);
	void executeCheckout(String basePath, String branch);
	void executeCheckoutNewBranch(String basePath, String branch);

	void executeAddAll(String basePath);
	void executeDefaultBatCommit(String basePath, String branch);
	void executePushWithNewBranch(String basePath, String branch);
}
