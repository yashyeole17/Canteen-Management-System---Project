package in.co.canteen.mg.Utility;
import java.util.ResourceBundle;
public class PropertyReader {
	private static ResourceBundle rb = ResourceBundle.getBundle("system");	
	public static String getvalue(String key) {
		 String val = null;
	       try {
	           val = rb.getString(key);
	       } catch (Exception e) {
	           val = key;
	       }

	       return val;
	   }
	public static String getvalue(String key,String param) {
		
		 String msg = getvalue(key);
	       msg = msg.replace("{0}", param);
	       return msg;
	   }
	public static void main(String[] args) {
	   String params =  "login" ;
	   System.out.println(PropertyReader.getvalue("requires", params));
	}

}
