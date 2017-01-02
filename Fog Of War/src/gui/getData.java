package gui;

import java.sql.ResultSet;
import java.sql.SQLException;

public class getData {
	
	static String  val = null;
	static int value;
	public getData(String column, String table, String condition) {
		new DataConnection();
		ResultSet rs = DataConnection.SQLSELECTQuery("SELECT " + column + " FROM " + table + " WHERE " + condition);
		try {
			while ( rs.next() ) {
				val = rs.getString(column);
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	public static void getInt(String column, String table, String condition) {
		new DataConnection();
		ResultSet rs = DataConnection.SQLSELECTQuery("SELECT " + column + " FROM " + table + " WHERE " + condition);
		try {
			while ( rs.next() ) {
				value = (Integer) rs.getObject(column);
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void pushData(String table, String columns, String values) {
		DataConnection.executeUpdate("INSERT INTO " + table + "(" + columns + ") VALUES (" + values + ")");
	}
	
	public static void getIntNoCondition(String column, String table) {
		new DataConnection();
		ResultSet rs = DataConnection.SQLSELECTQuery("SELECT " + column + " FROM " + table);
		try {
			while ( rs.next() ) {
				value = (Integer) rs.getObject(column);
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void removeData(String table, String column, String value) {
		DataConnection.executeUpdate("DELETE FROM " + table + " where " + column + " = '" + value + "'");
	}
	

}
