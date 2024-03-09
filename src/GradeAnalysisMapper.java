
import java.io.IOException;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class GradeAnalysisMapper extends Mapper<LongWritable, Text, Text, Text> {
    private Text studentID = new Text();
    private Text grade = new Text();

    @Override
    public void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {
        String[] tokens = value.toString().split("\\s+");
        if (tokens.length == 3) {
            studentID.set(tokens[0]);
            grade.set(tokens[2]);
             System.out.println(grade);
            context.write(studentID, grade);
        }
    }
}

