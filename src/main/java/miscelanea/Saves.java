package miscelanea;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Saves {
	
	public static String giphyKey = "MLFfPqlrYXcEvv3V87zAKsXVSn4dng1w";
	
	public static String randomRes() {
		List<String> possible = responses();
		Random r = new Random();
		int max = possible.size();
		int min = 0;
		return possible.get(r.nextInt((max - min) + 1) + min);
	}
	
	private static List<String> responses() {
		List<String> res = new ArrayList<String>();
		res.add("I don't think so.");
		res.add("I think so.");
		res.add("Yes.");
		res.add("No.");
		res.add("Try asking me again later.");
		res.add("Definitely no.");
		res.add("Definitely yes.");
		res.add("Probably not.");
		res.add("Probably yes.");
		res.add("I can not answer this question right now.");
		res.add("Maybe yes.");
		res.add("Maybe not.");
		return res;
	}
	
}