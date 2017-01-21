import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class myReducerCancel extends Reducer<Text, IntWritable,Text, IntWritable>{

	TreeMap<Integer, String> sort = new TreeMap();
	@Override
	protected void reduce(Text key, Iterable<IntWritable> value,
			Reducer<Text, IntWritable, Text, IntWritable>.Context con)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		int sum = 0;
		for (IntWritable val : value) {
			sum += val.get();
		}
		/*
		 * A=CARRIER
		 * B=WEATHER
		 * C=NAS
		 * D=SEURITY
		 */
		sort.put(sum, key.toString());
		
	}
	
	
	protected void cleanup(Context con){
		int sum = sort.lastKey();
		String key = sort.get(sum);
		if(key.equalsIgnoreCase("a")){
			try {
				con.write(new Text("CARRIER"), new IntWritable(sum));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(key.toString().equalsIgnoreCase("B")){
			try {
				con.write(new Text("WEATHER"), new IntWritable(sum));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(key.toString().equalsIgnoreCase("C")){
			try {
				con.write(new Text("NAS"), new IntWritable(sum));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(key.toString().equalsIgnoreCase("D")){
			try {
				con.write(new Text("SECURITY"), new IntWritable(sum));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	}
	
	
	    
