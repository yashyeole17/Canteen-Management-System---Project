package in.co.canteen.mg.Utility;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import in.co.canteen.mg.Bean.DropDownListBean;

public class HTMLUtility {
	public static String getList(String name, String selectedVal,HashMap<String , String>map) {
		Map<String, String> treeMap = new LinkedHashMap<String, String>(map);

		StringBuffer sb = new StringBuffer("<select class='form-control' name='" + name + "'>");

		Set<String> keys = map.keySet();
		String val = null;
		String select = "-----Select-----";
		sb.append("<option selected value='" + select + "'>" + select + "</option>");
		for (String key : keys) {
			val = map.get(key);
			if (key.trim().equals(selectedVal)) {

				sb.append("<option selected value='" + key + "'>" + val + "</option>");
			} else {
				sb.append("<option value='" + key + "'>" + val + "</option>");
			}
		}
		sb.append("</select>");
		return sb.toString();
	}
	
	public static String getList(String name, String selectedVal, List list){
        Collections.sort(list);
        List<DropDownListBean> dd = (List<DropDownListBean>) list;
        StringBuffer sb = new StringBuffer(
        		"select class='form-control' name='" + name + "'>");

        		
        String key = null;
        String val = null;

        String select="-----------Select-----------";
        sb.append("<option selected value=' '>" +select+ "</option>");
        System.out.println("selected value"+selectedVal);
        for (DropDownListBean obj : dd) {
            key = obj.getKey();
            val = obj.getValue();
            if (key.trim().equals(selectedVal)) {
                sb.append("<option selected value='" + key + "'>" + val
                        + "</option>");
            } else {
                sb.append("<option value='" + key + "'>" + val + "</option>");
            }
        }
        sb.append("</select>");
        return sb.toString();
    }



}
