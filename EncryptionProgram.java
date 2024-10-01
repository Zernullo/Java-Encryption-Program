package JavaProject1;

import java.util.*;

public class EncryptionProgram {

	private Scanner scanner;
	private ArrayList <Character> list;
	private ArrayList <Character> shuffledList;
	private char character;
	private char[] letters;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public EncryptionProgram() {
		scanner = new Scanner(System.in);
		new Random();
		list = new ArrayList();
		shuffledList = new ArrayList();
		character = ' ';

		newKey();
		askQuestion();
		
	}
	
	private void askQuestion(){
		while(true) {
			System.out.println("************************************************");
			System.out.println("What do you want to do?");
			System.out.println("(N)ewKey, (G)etKey, (E)ncrypt, (D)ecrypt, (Q)uit");
			char response = Character.toUpperCase(scanner.nextLine().charAt(0));
			
			switch(response) {
			case 'N':
				newKey();
				break;
			case 'G':
				getKey();
				break;
			case 'E':
				encrypt();
				break;
			case 'D':
				decrypt();
				break;
			case 'Q':
				quit();
				break;
			default:
				System.out.println("Not a valid answer");
			}
			
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void newKey() {
		
		character = ' ';
		list.clear();
		shuffledList.clear();
		
		for(int i = 32; i < 127; i++) {
			list.add(Character.valueOf(character));//change character to a ascii value and add into the list array
			character++;//till character reach 126
		}
		
		shuffledList = new ArrayList(list);//copy the list array
		Collections.shuffle(shuffledList);//shuffles the index in the array list
		System.out.println("*A new key has been generated");
	}
	
	private void getKey() {
		System.out.println("Key: ");
		for(Character x : list) {
			System.out.print(x);//print the normal key
		}
		
		System.out.println();
		for(Character x : shuffledList) {
			System.out.print(x);//print the shuffled key
		}
		System.out.println();
	}
	
	private void encrypt() {
		System.out.println("Enter a message to be encrypted");
		String message = scanner.nextLine();
		
		letters = message.toCharArray();//makes the string into char
		
		for(int i = 0; i < letters.length; i++) {
			
			
			for(int j = 0; j < list.size(); j++) {
				if(letters[i] == list.get(j)) {//letters == list(ascii symbols) at j
					letters[i] = shuffledList.get(j);//then letters will equal shuffled list at j
					break;
				}
			}
		}
		
		System.out.println("Encrypted: ");
		for(char x : letters) {
			System.out.print(x);
		}
		System.out.println();
			
	}
	
	private void decrypt() {
		System.out.println("Enter a message to be decrypted");
		String message = scanner.nextLine();
		
		letters = message.toCharArray();//makes the string into char
		
		for(int i = 0; i < letters.length; i++) {
			
			
			for(int j = 0; j < shuffledList.size(); j++) {
				if(letters[i] == shuffledList.get(j)) {//letters == shuffled (ascii symbols) at j
					letters[i] = list.get(j);//then letters will each list at j
					break;
				}
			}
		}
		
		System.out.println("Decrypted: ");
		for(char x : letters) {
			System.out.print(x);
		}
		System.out.println();
	}
	
	private void quit() {
		System.out.println("Thank you, have a nice day");
		System.exit(0);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
