package com.financemanager.infrastructure;

import java.sql.*;

public class DatabaseConnection {
	private static Connection conexion;
	private static DatabaseConnection singleton;
	private DatabaseConnection() {
		conexion = getConexion();
	}
	
	public static Connection getInstance() throws SQLException {
		if(singleton == null || conexion.isClosed()) {
			singleton = new DatabaseConnection();
		}		
		return conexion;
	}
	
	private Connection getConexion() {
		Connection conn = null;
		String url = "jdbc:sqlite:" + AppConfig.DB_PATH;
		try {
			conn = DriverManager.getConnection(url);
			if(conn != null) {
				System.out.println("Conexión con la base de datos exitosa!");
				conn.createStatement().execute("PRAGMA foreign_keys = ON");
			} else {
				System.out.println("Error al conectar con la base de datos.");
			}
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error al abrir la base de datos.");
			e.printStackTrace();
		}
		return conn;
	}
}
