package helperMethods;

import java.io.FileReader;
import java.io.FileWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonUtils {

	private static FileWriter file;
	private static FileReader reader;
	private static JSONParser jsonParser;
	private static JSONObject jsonObject;
	private static Object object;
	@SuppressWarnings("unused")
	private static JSONArray jsonArray;

	public static String getData(String filePath, String field) {
		try {
			reader = new FileReader(filePath);
			jsonParser = new JSONParser();
			object = jsonParser.parse(reader);
			jsonObject = (JSONObject) object;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (String) jsonObject.get(field);
	}

	public static String getData(String field) {
		try {			
			jsonParser = new JSONParser();
			object = jsonParser.parse(reader);
			jsonObject = (JSONObject) object;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (String) jsonObject.get(field);
	}

	
	@SuppressWarnings("unchecked")
	public static void setData(String key, String value, String inputFile) {
		try {
			jsonParser = new JSONParser();
			object = jsonParser.parse(new FileReader(inputFile));
			jsonObject = (JSONObject) object;

			jsonObject.put(key, value);

			file = new FileWriter(inputFile);
			file.write(jsonObject.toJSONString());
			file.flush();
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static JSONArray getArrayValues(String filePath, String field) {
		try {
			reader = new FileReader(filePath);
			jsonParser = new JSONParser();
			object = jsonParser.parse(reader);
			jsonObject = (JSONObject) object;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (JSONArray) jsonObject.get(field);
	}

	public static JSONObject getData1(String filePath) {
		try {
			reader = new FileReader(filePath);
			jsonParser = new JSONParser();
			object = jsonParser.parse(reader);
			jsonObject = (JSONObject) object;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonObject;

	}

	public static void main(String[] ar) throws Exception {
		/*
		 * System.out.println("started"); // JsonUtils.getArrayValues(
		 * "C:\\Users\\Admin\\workspace\\Plumb5\\Test_Data\\Contacts\\Contact_Import2.json"
		 * ,"data"); JSONParser parser = new JSONParser(); FileReader reader =
		 * new FileReader(
		 * "C:\\Users\\Admin\\workspace\\Plumb5\\Test_Data\\Contacts\\Contact_Import3.json"
		 * );
		 * 
		 * Object object = parser.parse(reader);
		 * 
		 * JSONArray array = (JSONArray) object; System.out.println(array);
		 */

		JSONParser parser = new JSONParser();
		FileReader reader = new FileReader(
				"C:\\Users\\Admin\\workspace\\Plumb5\\Test_Data\\Contacts\\Contact_Import3.json");

		Object object = parser.parse(reader);

		JSONObject jsonObject = (JSONObject) object;

		JSONObject val=(JSONObject)jsonObject.get("data2");
		System.out.println(val.get("name"));
		System.out.println(jsonObject.get("data1"));
		System.out.println(jsonObject.get("data2"));
	}
}