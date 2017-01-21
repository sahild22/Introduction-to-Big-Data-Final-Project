import java.io.IOException;
import java.util.TreeSet;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class myReducerProb extends Reducer<Text, IntWritable,Text, Text>{
	
	DoubleWritable count = new DoubleWritable();
	DoubleWritable relCount = new DoubleWritable();
	Text word = new Text("");
	TreeSet<ResultPair> sortedOutput_temp = new TreeSet<>();
	TreeSet<ResultPair1> sortedOutput = new TreeSet<>();
	
	@Override
	protected void reduce(Text key, Iterable<IntWritable> value,
			Reducer<Text, IntWritable, Text, Text>.Context con) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
	
		String[] keyy = key.toString().split(" ");
		
		if(keyy[1].equals("*")){
			if(keyy[0].equals(word.toString())){
				count.set(count.get() + getCount(value));
			}
			else{
				word.set(keyy[0]);
				count.set(0);
				count.set(getCount(value));
			}
		}
		
		else if(keyy[1].equals("y")){
			double cnt = getCount(value);
			relCount.set((double)cnt / count.get());
			Double rel = relCount.get();
			sortedOutput_temp.add(new ResultPair(rel, key.toString(), word.toString()));
			if (sortedOutput_temp.size() > 3) {
				sortedOutput_temp.pollLast();
			}
			
			sortedOutput.add(new ResultPair1(rel, key.toString(), word.toString()));
			if (sortedOutput.size() > 3) {
				sortedOutput.pollLast();
			}
			}
		}
	
	private double getCount(Iterable<IntWritable> values) {
		double count = 0;
		for (IntWritable value : values) {
			count += value.get();
		}
		return count;
	}
	
	protected void cleanup(Context context)
            throws IOException,
            InterruptedException {
		context.write(new Text("Airlines with Higher Probability:"), new Text());
		while(!sortedOutput_temp.isEmpty()){
			ResultPair p1= sortedOutput_temp.pollFirst();
			context.write(new Text(p1.key.split(" ")[0]), new Text(Double.toString(p1.prob)));
		}
		context.write(new Text("Airlines with Lowest Probability:"), new Text());
		while(!sortedOutput.isEmpty()){
			ResultPair1 p2= sortedOutput.pollFirst();
			context.write(new Text(p2.key.split(" ")[0]), new Text(Double.toString(p2.prob)));
		}
	}
	
	
	    
}