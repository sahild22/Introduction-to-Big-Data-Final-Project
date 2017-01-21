
public class ResultPairLow implements Comparable<ResultPairLow>  {
	

	double avg;
	String key;

	ResultPairLow(double avg, String key) {
		this.avg = avg;
		this.key = key;
	}

	@Override
	public int compareTo(ResultPairLow resultPairLow) {
		if (this.avg >= resultPairLow.avg) {
			return 1;
		} else {
			return -1;
		}
	}
}