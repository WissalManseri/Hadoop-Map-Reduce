
import java.io.IOException;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class GradeAnalysisReducer extends Reducer<Text, Text, Text, Text> {
    private Text result = new Text();

    @Override
    public void reduce(Text key, Iterable<Text> values, Context context)
            throws IOException, InterruptedException {
        int sum = 0;
        int count = 0;

        for (Text value : values) {
            sum += gradeToValue(value.toString());
            count++;
        }
         System.out.println("Key: " + key.toString() + ", Sum: " + sum + ", Count: " + count);

        double average = (double) sum / count;

        result.set(String.format("%.2f", average));
        context.write(key, result);
    }

    private int gradeToValue(String grade) {
      
        switch (grade) {
            case "A": return 20;
            case "B": return 15;
            case "C": return 10;
           
            default: return 0;
        }
        
    }
}

