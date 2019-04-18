import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
///QUESTION: https://www.hackerrank.com/challenges/30-dictionaries-and-maps/problem
public class DistionaryandMap {
	public static void main(String [] args)
	{
		@SuppressWarnings("resource")
		Scanner scanObj = new Scanner(System.in);
		System.out.println("Enter the number of entries you want to add:");
		int n = scanObj.nextInt();
		
		Map<String,Integer> mapObj= new HashMap<>();
		
		for(int i=0;i<n;i++)		{
			String name = scanObj.next();
			int phone = scanObj.nextInt();
			if(name != null && phone >= 0 )
			{
				mapObj.put(name, phone);
			}
		}
		System.out.println("printing the entries in map format: "+ mapObj);
		
		while(scanObj.hasNext())
		{
			String s = scanObj.next();
			if(mapObj.get(s)!=null)
			{
				System.out.println(s + "=" + mapObj.get(s));
			}
			else
			{
				System.out.println("Not found");
			}
		}
		
		mapObj.clear();
		scanObj.close();
	}

}
