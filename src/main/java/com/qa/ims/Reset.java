package com.qa.ims;

import com.qa.ims.utils.DBUtils;

public class Reset {
	
	static DBUtils test = new DBUtils();
	
	static String schema =("src/main/resources/sql-schema.sql");
	static String data = ("src/main/resources/sql-data.sql");
	
	public static void reset() {
		test.executeSQLFile(schema);
		test.executeSQLFile(data);
	}
}
