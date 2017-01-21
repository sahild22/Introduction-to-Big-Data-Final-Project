
public class ResultPairHigh implements Comparable<ResultPairHigh>  {
	

	double avg;
	String key;

	ResultPairHigh(double avg, String key) {
		this.avg = avg;
		this.key = key;
	}

	@Override
	public int compareTo(ResultPairHigh resultPairHigh) {
		if (this.avg <= resultPairHigh.avg) {
			return 1;
		} else {
			return -1;
		}
	}
}