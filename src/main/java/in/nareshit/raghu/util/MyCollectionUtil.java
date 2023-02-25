package in.nareshit.raghu.util;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//jdk 8 (static method + default method ALLOWED)
public interface MyCollectionUtil {
	
	public static  Map<Long, String> convertToMap(List<Object[]> list){
		
		
		Map<Long, String > map=
		list
		.stream()
		.collect(Collectors.toMap(
				ob->Long.valueOf(
						ob[0].toString()), 
				ob->ob[1].toString()));
				
				return map;
		
	}

}
