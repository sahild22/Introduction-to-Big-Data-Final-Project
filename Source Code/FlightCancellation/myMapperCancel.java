import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;


	 public class myMapperCancel extends Mapper<LongWritable, Text, Text, IntWritable>{
	        @Override
	        protected void map(LongWritable key, Text value, Context con)
	                throws IOException, InterruptedException {
	         String[] splitData = value.toString().split(",");
	        /*
	         int arrayLength = splitData.length;
	         String[] columnName = new String[arrayLength];
	         String[] columnValue = new String[arrayLength];
	         if(splitData[0].equalsIgnoreCase("Year")){
	        	 for(int i = 0; i < arrayLength; i++){
	        		 splitData[i] = columnName[i];
	        	 }
	         }
	         else{
	        	 for(int i = 0; i< arrayLength; i++){
	        		 splitData[i] = columnValue[i];
	        	 }
	        	 
	         }
	        
	         if(columnValue[21].equals("1")){
	        	 con.write(new Text(columnValue[22]), new IntWritable(1));
	         }
	 */
	         if(splitData[21].equals("1") && !splitData[22].equals("NA")){
	         con.write(new Text(splitData[22]), new IntWritable(1) );
	         }
	        }
	 }