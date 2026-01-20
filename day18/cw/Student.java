import java.util.Scanner;
class Student{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		Scanner sc1=new Scanner(System.in);
			System.out.print("Enter the total no of student : ");
		
		int no_of_student = sc.nextInt();
		
		String student_name[]=new String [no_of_student];
		
		int count=0;
		int chioce=0;
			
			do {
			System.out.println("welcome to class ");
			System.out.println("1:add students");
			System.out.println("2:see the students");
			System.out.println("3:Eixt");
			System.out.println("Enter your chioce: ");
			chioce=sc.nextInt();
			
			switch(chioce){
				
				case 1:
				if(count<student_name.length){
					System.out.print("Enter student Name: ");
					
					student_name[count]=sc1.nextLine();
					
					count++;
					System.out.print("student name added Successfully.");
				}
				else{
					System.out.println("student list is full");
				}
				break;
				case 2:
					System.out.println("student name: ");
					
					for(int i=0;i<count;i++){
						System.out.println(student_name [i]);
					}
					break;
					case 3:
					System.out.println("Exit");
					break;
					
					default:
					System.out.println("invalid chioce");
					
				}
				}while(chioce != 3);
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			}
			
				
			}
			
		
		
		
		
