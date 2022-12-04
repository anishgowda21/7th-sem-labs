package average;
import java.io.*;
import java.util.*;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.io.*;

class mapper extends MapReduceBase implements Mapper<LongWritable , Text , Text , FloatWritable>{
	public void map(LongWritable key, Text value, OutputCollector<Text,FloatWritable> output ,Reporter r) throws IOException{
		String[] word = value.toString().split("\\t");
        	String sex = word[3];
		Float salary = Float.parseFloat(word[8]);
		output.collect(new Text(sex), new FloatWritable(salary));
	}
}
