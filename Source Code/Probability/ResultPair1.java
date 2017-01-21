public class ResultPair1 implements Comparable<ResultPair1>  {
	

	double prob;
	String key;
	String value;

	ResultPair1(double prob, String key, String value) {
		this.prob = prob;
		this.key = key;
		this.value = value;
	}

	@Override
	public int compareTo(ResultPair1 resultPair) {
		if (this.prob >= resultPair.prob) {
			return 1;
		} else {
			return -1;
		}
	}
}
