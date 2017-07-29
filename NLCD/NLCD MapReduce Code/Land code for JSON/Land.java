package landdata;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class Land {

	public static void main(String arg[]) throws Exception{
		
		if(arg.length!=2){
			
			System.err.println("Input/Output file path missing");
			System.exit(0);
		}
		
		Job job = new Job();
		
		job.setJarByClass(Land.class);
		job.setJobName("Land");
		
		FileInputFormat.addInputPath(job, new Path(arg[0]));
		FileOutputFormat.setOutputPath(job, new Path(arg[1]));
		
		job.setMapperClass(LandMapper.class);
		job.setReducerClass(LandReducer.class);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		
		System.exit(job.waitForCompletion(true) ? 0:1);
	}
}
