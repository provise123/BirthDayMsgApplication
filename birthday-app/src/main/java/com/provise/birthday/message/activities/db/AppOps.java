package com.provise.birthday.message.activities.db;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.orientechnologies.orient.core.db.ODatabaseSession;
import com.orientechnologies.orient.core.sql.executor.OResultSet;
import com.provise.birthday.message.model.EmployeeModel;
import com.provise.birthday.message.util.StringUtil;

/**
 * @author swapnil.patil The Class AppOps.
 */
public class AppOps {

	@SuppressWarnings("unchecked")
	public static List<EmployeeModel> getAllEmployeeData(ODatabaseSession db, Date DOB) {
		System.out.println("Entered getAllEmployeedata method");
		OResultSet rs = null;
		ObjectMapper objectMapper = new ObjectMapper();
		List<EmployeeModel> employeModels = new ArrayList<EmployeeModel>();
		try {
			//String queryStr = "select * from `Employee` where DOB = '" + StringUtil.getDateFormatYearMonthDay(DOB, "yyyy-MM-dd")+ "'";
			String queryStr = "select * from `Employee` where DOB = '2019-10-10 00:00:00'";
			System.out.println("executing query ::" + queryStr);
			rs = db.query(queryStr);
			if (rs != null) {
				while (rs.hasNext()) {
					String jsonStr = rs.next().toJSON();
					Map<String, Object> mapData = objectMapper.readValue(jsonStr, Map.class);
					System.out.println("map::" + mapData);
					System.out.println("DateOfBirth::"+mapData.get("DOB").toString());
					EmployeeModel model = new EmployeeModel(mapData.get("firstName").toString(), mapData.get("lastName").toString(),
					StringUtil.convertStringTodate(mapData.get("DOB").toString(),"yyyy-mm-dd HH:mm:ss"),mapData.get("emailAddress").toString());
					employeModels.add(model);
					//return employeModels;
				} // while ends

			}
			System.out.println(employeModels);
			return employeModels;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				rs.close();
		}
		return employeModels;
	}

}
