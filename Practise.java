import java.util.*;
import java.io.*;
import java.text.DecimalFormat;
import java.math.RoundingMode;
import java.io.FileNotFoundException;
import org.json.JSONObject;

public class Practise {

	public static void main(String[] args) throws IOException {
		double[] array = new double[10000];
		JSONObject object = new JSONObject();
		JSONObject object1 = new JSONObject();
		File file = new File("Memory.txt");
		object.put();
		object1.put();
		try (BufferedReader bf = new BufferedReader(new FileReader(file))) {
			String readLine;
			double temp;
			int line = 0;
			int i = 0;
			double sum = 0.0;
			double max = 0.0;
			while ((readLine = bf.readLine()) != null) {
				if (line % 2 != 0) {

					String str = readLine;
					str = str.replaceAll("[^0-9]", "");
					str = str.trim();
					temp = Integer.parseInt(str);
					array[i++] = temp / 10000;
				}
				line++;
			}
			String str1;
			for (int j = 0; j < 938; j++) {
				str1 = String.format("%d", j);
				object1.put(str1 + "s", array[j]);
				if (max < array[j])
					max = array[j];
				sum = sum + array[j];
			}
			double avg = sum / 938;
			DecimalFormat df = new DecimalFormat("#.##");
			df.setRoundingMode(RoundingMode.CEILING);
			object.put("AverageMemory(MB)", df.format(avg));
			object.put("values: ", object1);
			object.put("MaximumMemory(MB)", df.format(max));
			System.out.println(object);
		}
	}
}
