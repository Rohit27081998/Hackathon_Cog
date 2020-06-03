import java.io.*;
import java.util.*;
import org.json.simple.*;

class Test {
	public static void main(String args[]) {
		try {
			FileReader fr = new FileReader("C:\\Users\\LENOVO\\Desktop\\cpu.txt");
			BufferedReader br = new BufferedReader(fr);
			String line;
			int i = 1;
			float sum = 0;
			float max = 0;

			JSONObject val = new JSONObject();
			JSONObject finalObject = new JSONObject();
			JSONObject Object1 = new JSONObject();
			JSONArray finalarray = new JSONArray();
			while ((line = br.readLine()) != null) {
				String splitvalues[] = line.split("\\s+");
				float fval = Float.parseFloat(splitvalues[8]);
				if (fval > max)
					max = fval;
				sum = sum + fval;
				String seconds = i + "s";
				val.put(seconds, splitvalues[8].toString());
				i++;
			}
			float avg = (float) sum / i;
			finalObject.put("values", val);
			finalObject.put("maxcpu", (String.format("%.2f", max)));
			finalObject.put("avgcpu", (String.format("%.2f", avg)));
			Object1.put("sampletransaction", finalObject);
			finalarray.add(Object1);
			System.out.println(finalarray);
			FileWriter file = new FileWriter("output.json");
			file.write(finalarray.toJSONString());
			file.close();
			fr.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
