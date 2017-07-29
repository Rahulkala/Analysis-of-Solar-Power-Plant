package com.bd.solar;

import java.io.IOException;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
public class SolarMapper extends Mapper<LongWritable, Text, Text, DoubleWritable> {

	@Override
   public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
	
		String line = value.toString();
		String content[] = line.split(",");
		String time[] = content[2].split("/");
		String month = time[0];
		Double PV = Double.parseDouble(content[3]);
		context.write(new Text(content[0]+","+content[1]+","+month), new DoubleWritable(PV));
	}
}
