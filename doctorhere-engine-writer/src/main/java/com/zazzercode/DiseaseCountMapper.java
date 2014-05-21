package zazzercode;

import java.io.IOException;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;

public class DiseaseCountMapper extends 
        Mapper<LongWritable, Text, Text, IntWritable>  {

    @Override
    public void map(LongWritable key, Text value, Context context) 
            throws IOException, InterruptedException {
        String s = value.toString();
        for (String word : s.split("\\W+")) {
            if (word.length() > 0) {
                context.write(new Text(word), new IntWritable(1));
            }
        }
    }  
}
