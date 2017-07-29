package com.bd.solar;

import java.io.IOException;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
public class SolarReducer extends Reducer<Text, DoubleWritable, Text, Text> {
  @Override
  public void reduce(Text key, Iterable<DoubleWritable> values, Context context) throws IOException, InterruptedException {
	  double maxValue = Double.MIN_VALUE;
	  double minValue = Double.MAX_VALUE;
	  int count = 0;
	  double avg = 0;
	  double total = 0;
	  for (DoubleWritable value : values) {
		  
		  if (value.get() > 0){
			  
			  count++;
			  minValue = Math.min(minValue, value.get());
			  total = total + value.get();
			  maxValue = Math.max(maxValue, value.get());
		  }
	  }	  
	  if(count == 0){
		  
		  avg = 0;
		  maxValue = 0;
		  minValue = 0;
	  }  
	  else
		  avg = total/count;
	  
	  Text newKey = new Text(key.toString()+",");
	  context.write(newKey, new Text(minValue+ "," + maxValue + "," + avg));
  }
}

