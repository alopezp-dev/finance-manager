package com.financemanager.infrastructure;

import java.io.IOException;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws SQLException, IOException{
		MigrationRunner mr = new MigrationRunner();
		System.out.println("Prueba");
		mr.run();
    }
}
