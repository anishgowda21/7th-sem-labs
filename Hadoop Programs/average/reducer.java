package average;
import java.util.*;
import java.io.*;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.io.*;



public class reducer extends MapReduceBase implements Reducer<Text,FloatWritable,Text,FloatWritable> {
	public void reduce(Text key, Iterator<FloatWritable> value, OutputCollector<Text,FloatWritable> op,Reporter r) throws IOException {
		Float total = (float) 0;
		int count = 0;
		while(value.hasNext()){
			total+=value.next().get();
			count++;	
		}
		float avg = total/count;

		op.collect(new Text(key+" Total = "),new FloatWritable(total));
		op.collect(new Text(key+" AVG = "),new FloatWritable(avg));
	}
}
