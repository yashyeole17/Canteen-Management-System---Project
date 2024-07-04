package in.co.canteen.mg.Utility;

import java.util.Date;

public class DataValidator {
	
	public static boolean isName(String val) {
		String name = "^[A-Za-z ]*$";
		if (val.matches(name)) {
			return true;
		} else {
			return false;
		}
	}
	public static boolean isEmail(String val) {
		String emailreg = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		if (isNotNull(val)) {
			try {		
				return val.matches(emailreg);
			} catch (NumberFormatException e) {
				return false;
			}

		} else {
			return false;
		}
	}

	public static boolean isNotNull(String val) {

		return !isNull(val);
	}

	public static boolean isNull(String val) {
		if (val == null || val.trim().length() == 0) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isInteger(String val) {
		if (isNotNull(val)) {
			int i = Integer.parseInt(val);
			return true;
		} else {
			return false;
		}
	}

	public static boolean isLong(String val) {
		if (isNotNull(val)) {
			try {
				long i = Long.parseLong(val);
				return true;
			} catch (NumberFormatException e) {
				return false;
			}

		} else {
			return false;
		}
	}
	public static boolean isPassword(String val) {
		String passregex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[\\S])[A-Za-z0-9\\S]{6,12}$";

		if (val.matches(passregex)) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isMobileNo(String val) {
		String mobreg = "[7-9][0-9]{9}$";
		if (val.matches(mobreg)) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isDate(String val){
		Date d = null;
		if (isNotNull(val)) {
			d = DataUtility.getDate(val);
		}
		return d != null;
	}

	public static boolean isPanNumber(String val) {

		String panregex = "[A-Z]{5}[0-9]{4}[A-Z]{1}";

		if (val.matches(panregex)) {
			return true;
		} else {

			return false;
		}
	}

	public static boolean isAdharNumber(String val) {
		
		String adharreg ="^[2-9]{1}[0-9]{3}\\\\s[0-9]{4}\\\\s[0-9]{4}$”;";
		if (val.matches(adharreg)) {
			return true;
		}else {
			return false;
		}
	}

}
