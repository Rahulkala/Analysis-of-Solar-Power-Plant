package com.bd.solar;

import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class SolarReducer extends Reducer<Text, DoubleWritable, Text, Text>{

	public void reduce(Text key, Iterable<DoubleWritable> values, Context context) throws IOException, InterruptedException {
		
		  double total = 0;
		  for (DoubleWritable value : values) {
			  
			  double num = value.get();
			  if (num > 0){
				  
				  total = total + num;
			  }
		  }	  
		  Text newKey = new Text(key.toString()+","+total);
		  context.write(newKey, new Text());
	  }

}
