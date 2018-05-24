package slk.assignment;

public class App {
	public static void main(String[] args) {

		int []nums = new int[10];
		int []nums2 = {12, 34, 555};
		int []nums3;
		nums3 = new int[]{100, 200};
		
		
		Person[] persons;

		persons = new Person[5]; // creating an object (array of Person
								// references)

		// upcasting (Student to Person type); implicit
		persons[0] = new Student("Ram", 87); 
		persons[1] = new Professor("Shyam", 6);
		persons[2] = new Professor("Gyan", 5);
		persons[3] = new Student("Bhim", 67);
		persons[4] = new Professor("Snape", 0);
		
		for(int i=0; i<persons.length; i++){
			Person p = persons[i];
			
			if(p.isOutstanding()){
				if(p instanceof Student){
					Student st = (Student) p; // down-casting; explicit
					st.print();
				}
				else if(p instanceof Professor){
					Professor pf = (Professor) p;
					pf.display();
				}
				System.out.println();
			}
		}
	}
}











