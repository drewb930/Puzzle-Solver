package sudoku;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class wordUnscramble {
	
	private ArrayList<String> dictionary = new ArrayList<String>();
	private ArrayList<String> permutations = new ArrayList<String>();

	public wordUnscramble() {
		//load text file into dictionary
		File f = new File("C:\\Users\\Acer\\words.txt.");
		Scanner sc;
		try {
			sc = new Scanner(f);
			while(sc.hasNextLine()) {
				dictionary.add(sc.nextLine());
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String word(String in) {
		
		 permutations = permutationFinder(in);

		String word = "";
		for(int i = 0; i < permutations.size(); i++) {
			String test = permutations.get(i);
			for(int j = 0; j < dictionary.size(); j++) {
				if(test.compareTo(dictionary.get(j)) == 0) {
					word = dictionary.get(j);
				}
			}
		}
		return word;	
	}
	
    public static ArrayList<String> permutationFinder(String str) {
        ArrayList<String> perm = new ArrayList<String>();
        //Handling error scenarios
        if (str == null) {
            return null;
        } else if (str.length() == 0) {
            perm.add("");
            return perm;
        }
        char initial = str.charAt(0); // first character
        String rem = str.substring(1); // Full string without first character
        ArrayList<String> words = permutationFinder(rem);
        for (String strNew : words) {
            for (int i = 0;i<=strNew.length();i++){
                perm.add(charInsert(strNew, initial, i));
            }
        }
        return perm;
    }

    public static String charInsert(String str, char c, int j) {
        String begin = str.substring(0, j);
        String end = str.substring(j);
        return begin + c + end;
    }
    
    public void print() {
    	System.out.print(permutations);
    }	
}
