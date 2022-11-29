package studio9;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import support.cse131.NotYetImplementedException;

public class NameToHeight {
	/**
	 * Construct and fill a map with your studio group members' names, each
	 * associated with his or her height.
	 * 
	 * Construct an ArgsProcessor and loop asking the args processor for a name to
	 * lookup the height. When the user cancels (that is: when args processor
	 * returns null), break from the loop. Otherwise, loop up the name in the map
	 * and output the results. Be sure to handle the case where the map does not
	 * contain a specified name.
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		Map<String, Integer> chart = new HashMap<>();
		chart.put("Nathan", 72);
		chart.put("Mary", 60);
		chart.put("Lawrence", 69);
		
		System.out.println("Whose height would you like to know? Type 'quit' to quit");
		String name = in.next();
		while(!name.equals("quit")) {
			if(name.equals("Nathan") || name.equals("Mary") || name.equals("Lawrence")) {
				System.out.println(name + " is " + chart.get(name) + " inches tall");
			} else {
				System.out.println("You're stupid, that's not one of the options");
			}
			System.out.println("Whose height would you like to know? Type 'quit' to quit");
			name = in.next();
		}
		System.out.println("Successfully quit");
	}
}
