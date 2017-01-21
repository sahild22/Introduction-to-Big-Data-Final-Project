import org.apache.hadoop.io.Text;

public class ResultPair implements Comparable<ResultPair>  {
	

	double prob;
	String key;
	String value;

	ResultPair(double prob, String key, String value) {
		this.prob = prob;
		this.key = key;
		this.value = value;
	}

	@Override
	public int compareTo(ResultPair resultPair) {
		if (this.prob <= resultPair.prob) {
			return 1;
		} else {
			return -1;
		}
	}
}
