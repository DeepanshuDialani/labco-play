package utils;

import com.google.gson.Gson;


public class Utils {

	public static String toJSON(Object object) {
		Gson gson = new Gson();
		return gson.toJson(object);
	}
}
