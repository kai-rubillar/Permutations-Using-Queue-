package firstlabexam;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static Queue<String> queue = new LinkedList<>();
	public static void main(String[] args){
		int choice;
		
		do{
			System.out.println("\n==Permutations==");
			System.out.println("1. Add Elements");
			System.out.println("2. Display Elements");
			System.out.println("3. Generate Permutation");
			System.out.println("4. Exit");
			System.out.print("Enter choice: ");
			choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice){
				case 1:
					addElements();
					break;
				case 2:
					displayElements();
					break;
				case 3:
					generatePermutations();
					break;
				case 4:
					System.out.println("Program terminated");
					break;
				default: 
					System.out.println("Invalid choice");
					return;
			}
		}while(choice!= 4);
		
	}
	
	
	static void addElements(){
		System.out.println(" ADD ELEMENTS ");
		System.out.print("Enter 5 elements: ");
		String[] elements = sc.nextLine().split(" ");
		
		if(elements.length != 5){
			System.out.println("Please enter only 5 elements");
			return;
		}
		
		for(int i = 0; i < elements.length; i++){
			queue.add(elements[i]);
		}
		System.out.println("\nElements are added");
	}
	
	
	static void displayElements(){
		if(queue.isEmpty()){
			System.out.println("Queue is empty. Add elements first");
			return;
		}
		System.out.println("\nQueue: " + queue);
		
		System.out.println("Dequeing two elements..");
		queue.poll();
		queue.poll();
		
		System.out.println("Updated queue: " + queue);
	}
	static void generatePermutations(){
		if(queue.isEmpty()){
			System.out.println("Queue is empty. Add elements first");
			return;
		}
		List<String> items = new ArrayList<>(queue);
		int n = items.size();
		
		System.out.print("Enter number of elements to arrange: ");
		int r = sc.nextInt();
		sc.nextLine();
		
		if(r < 1 || r > n){
			System.out.println("Invalid r cannot be lower than 1 or higher than " + n);
			return;
		} 
		permCount = 0;
		System.out.println("Generated Permutations:");
		permute(items, r, new boolean[n], " ");
		System.out.println("\nTotal Permutatons: " + permCount);
		
	}
	static int permCount;
	static void permute(List<String> items, int r, boolean[] used, String current){
		if(r == 0){
			System.out.println(current);
			permCount++;
			return;
		}
		for(int i = 0; i < items.size(); i++){
			if(!used[i]){
				used[i] = true;
				permute(items, r - 1, used, current + items.get(i) + " ");
				used[i] = false;
			}
		}
	}
}
