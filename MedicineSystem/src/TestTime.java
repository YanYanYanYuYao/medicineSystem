import java.text.SimpleDateFormat;

public class TestTime {
	public static void main(String[] args) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
		String time = df.format(System.currentTimeMillis());
		System.out.println(time);   
	}
}
