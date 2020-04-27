package org.masterserver.service;

public interface PlayerServiceTests extends CommonServiceTests {

	void getByUuid();
	void getByName();
	void getByPrefix();
	void getByNameColor();
	void getByNameFormat();
	void getByPrefixColor();
	void getByPrefixFormat();
	void getByFirstLogin();
	void getByLastLogin();
	void getByTimePlayed();
	
}
