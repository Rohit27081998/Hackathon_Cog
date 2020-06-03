import java.io.*;
import java.util.*;
import org.json.simple.*;

class Test1 {
	public static void main(String args[]) {
		try {
			FileReader fr = new FileReader("C:\\Users\\LENOVO\\Desktop\\Battery.txt");
			BufferedReader br = new BufferedReader(fr);
			String line;
			JSONObject obj = new JSONObject();
			String foreground = null;
			String drain_percent = null;
			while ((line = br.readLine()) != null) {
				if (line.contains("Foreground activities:")) {
					foreground = line.replaceAll("    Foreground activities: ", "");
				}

				if (line.contains("Uid u0a202:")) {
					String array[] = line.split("\\s+");
					drain_percent = array[3];
				}
			}

			obj.put("Foreground_time", foreground);
			obj.put("Battery_percentage", (Float.parseFloat(drain_percent) / 1000));
			obj.put("Battery_drain", drain_percent);
			System.out.println(obj);
			FileWriter file = new FileWriter("Batteryoutput.json");
			file.write(obj.toJSONString());
			file.close();
			fr.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
