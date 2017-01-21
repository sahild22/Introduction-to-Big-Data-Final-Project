import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;


public class myMapperTaxiIn extends Mapper<LongWritable, Text, Text, IntWritable>{
	  @Override
	  protected void map(LongWritable key, Text value, Context con)
	  throws IOException, InterruptedException {
	        	
	        String[] splitData = value.toString().split(",");
	        if(!splitData[0].equalsIgnoreCase("year") && !splitData[16].equals("NA") && !splitData[19].equals("NA")){
	        con.write(new Text(splitData[16]), new IntWritable(Integer.parseInt(splitData[19])));
	        }
	  }
}