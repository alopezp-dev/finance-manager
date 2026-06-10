package com.financemanager.infrastructure;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;

public class MigrationRunner {

	public Connection db;
	
	public void run() throws SQLException, IOException {
		db = DatabaseConnection.getInstance();
		InputStream is = getClass().getResourceAsStream(AppConfig.MIGRATIONS_PATH + "V1__create_tables.sql");
		String sql = new String(is.readAllBytes());
		db.createStatement().execute(sql);
	}
}
