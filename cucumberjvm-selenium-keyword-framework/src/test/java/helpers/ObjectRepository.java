package helpers;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
public class ObjectRepository {
	public static Properties OR = new Properties();
	public static Properties ObjectRepo(String filepath) throws IOException {
		InputStream in = new FileInputStream(filepath);
		OR.load(in);
		return OR;
	}
}
