package landdata;
import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;


public class LandMapper extends Mapper<LongWritable, Text, Text, Text> {

	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException{
		
		String s = value.toString();
		context.write(new Text(s), new Text());
		/*
		JSONParser parser = new JSONParser();
		try{
			
			Object o = parser.parse(s);
			//System.out.println(o);
			JSONObject jobj = (JSONObject)((JSONArray) o).get(0);
			JSONArray jobj1 = (JSONArray)jobj.get("features");
			JSONObject ob1 = (JSONObject)jobj1.get(0);
			JSONObject ob2 = (JSONObject)ob1.get("geometry");
			JSONArray obarr = (JSONArray)ob2.get("coordinates");
			JSONObject landcover = (JSONObject)ob1.get("properties");
			context.write(new Text(obarr.get(0)+","+obarr.get(1)+","+landcover.get("landcover")), new Text());
			
		}catch(Exception e){
			
			e.printStackTrace();
		}
		*/
	}
}
