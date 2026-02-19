import java.util.Scanner;

class Spotify 
{
	public static void main(String[] agrs)
	
	{
		Scanner sc=new Scanner(System.in);
		
		System.out.println("SPOTIFY");
        System.out.println("SELECT YOUR OPTION");
		System.out.println("1.A.R.RAHMAN");
		System.out.println("2.ANIRUDH");
		System.out.println("3.HARISH JEYARAJ");
		System.out.println("4.ILLAIYARAJA");
		System.out.println("5.U1");
		System.out.print("choose your Artist: ");
		
		
		int composer=sc.nextInt();
		
		if(composer==1)
		{   System.out.println("welecome to A.R.RAHMAN palylist");
	        System.out.println("1.melody");
			System.out.println("2.kuthu");
			System.out.println("3.motivational song");
			System.out.println("4.sad");
			System.out.print("5.choose your palylist: ");
			
			int option=sc.nextInt();
			
			if(option==1)
			{
				
			System.out.println("melody list");
			System.out.println("Netru illadha Matram");
			System.out.println("Enna Solla Pogirai");
	    	System.out.println("Ennavale Adi Ennavale");
			System.out.println("Malargale Malargale");
			}
			else if (option==2)
		{
			System.out.println("kuthu list");
			System.out.println("thaiya thaiya");
			System.out.println("mukkala mukkabala");
			System.out.println("urvashi urvashi");
		    System.out.println("aathichudi");
		}
		else if (option==3){
			System.out.println("motivational list");
			System.out.println("vande mataram");
		    System.out.println("oruvan oruvan mudhalali");
		    System.out.println("shakthi kodu");
		    System.out.println("kappal yeari poyachu");
		}
		else if(option==4){
			System.out.println("sad list");
			System.out.println("poongatrile");
			System.out.println("marudaani");
			System.out.println("minnalea en vazhvin");
			System.out.println("rasathi");
			System.out.println("oru poiyavathu sol");
		}
		else
			{
				System.out.println(" Your list is not avilable");
		}}
			  if(composer==2)
		{   System.out.println("welecome to ANIRUDH palylist");
	        System.out.println("1.melody");
			System.out.println("2.kuthu");
			System.out.println("3.motivational song");
			System.out.println("4.sad");
			System.out.print("5.choose your palylist: ");
			
			int option=sc.nextInt();
			if(option==1)
			{
				
			System.out.println("melody list");
			System.out.println("Netru illadha Matram");
			System.out.println("Enna Solla Pogirai");
	    	System.out.println("Ennavale Adi Ennavale");
			System.out.println("Malargale Malargale");
			}
			else if(option==2)
			{
			System.out.println("kuthu list");
			System.out.println("Neeyum nanum anbe");
			System.out.println("velicha poove");
	    	System.out.println("po indru neeyaga");
			System.out.println("nee partha vizhigal");
			}
			else if(option==3)
			{System.out.println("kuthu list");
			System.out.println("vaathi raid");
			System.out.println("naa ready");
	    	System.out.println("badass");
			System.out.println("vandha edam");
			}
			else if(option==4)
			{
		    System.out.println("sad");
			System.out.println("porkanda singam");
			System.out.println("kanave kanave");
	    	System.out.println("kannaana kanne");
			System.out.println("jodi nilave");
			}
			else{
				System.out.println("Your list is not avilable");
			}
		}
		else if(composer==3)
		{   System.out.println("welecome to HARISH JEYARAJ palylist");
	        System.out.println("1.melody");
			System.out.println("2.kuthu");
			System.out.println("3.sad");
			System.out.print("5.choose your palylist: ");
			
			int option=sc.nextInt();
			if(option==1){
				
			System.out.println("melody list");
			System.out.println("unnale");
			System.out.println("annul maele");
	    	System.out.println("yedho ondru");
			System.out.println("vaseegara");
			System.out.println("paartha mudhal");
			
			}
			else if(option==2){
				System.out.println("kuthu list");
				System.out.println("tirunelveli halwa da");
				System.out.println("aradi katre");
				System.out.println("soda bottle");
				System.out.println("aruva meesai");
			}
				else if(option==3){
				System.out.println("sad list");
				System.out.println("venmathiye");
				System.out.println("oh maname");
				System.out.println("yamma yamma");
				System.out.println("othayile");
			}
			else{
				System.out.println("Your list is not avilable");
			} 
		}
			if(composer==4)
		{   System.out.println("welecome to ILLAIYARAJA palylist");
	        System.out.println("1.melody");
			System.out.println("2.kuthu");
			System.out.println("3.motivational song");
			System.out.println("4.sad");
			System.out.print("5.choose your palylist: ");
			
			int option=sc.nextInt();
			if(option==1)
			{
				
			System.out.println("melody list");
			System.out.println("aathadi manasudhan");
			System.out.println("chinna sirisu");
	    	System.out.println("venmeggam");
			System.out.println("layyayyo");
			}
			else if(option==2){
			System.out.println("kutu list");
			System.out.println("machi open the bottle");
			System.out.println("saroja saman nikalo");
	    	System.out.println("no money no honey");
			System.out.println("villaiyadu mankatha");
			}
			else if(option==3){
				System.out.println("motivational list");
			System.out.println("edhirthu nill");
			System.out.println("oru nalil");
	    	System.out.println("nimirnthu nil");
			System.out.println("ungakkule mirugam");
			}	
			else if(option==4){
			System.out.println("sad list");
			System.out.println("kadhal valarthen");
			System.out.println("yedho ondru ennai");
	    	System.out.println("pogadhe");
			System.out.println("ninaithu ninaithu");
			}
			else{
				System.out.println("Your list is not avilable");
			}
		}
			 if(composer==5)
		{   System.out.println("welecome to U1 palylist");
	        System.out.println("1.melody");
			System.out.println("2.kuthu");
			System.out.println("3.motivational song");
			System.out.println("4.sad");
			System.out.print("5.choose your palylist: ");
			
			int option=sc.nextInt();
			if(option==1)
			{
				
			System.out.println("melody list");
			System.out.println("aathadi manasudhan");
			System.out.println("chinna sirisu");
	    	System.out.println("venmeggam");
			System.out.println("layyayyo");
			}
			else if(option==2){
			System.out.println("kutu list");
			System.out.println("machi open the bottle");
			System.out.println("saroja saman nikalo");
	    	System.out.println("no money no honey");
			System.out.println("villaiyadu mankatha");
			}
			else if(option==3){
				System.out.println("motivational list");
			System.out.println("edhirthu nill");
			System.out.println("oru nalil");
	    	System.out.println("nimirnthu nil");
			System.out.println("ungakkule mirugam");
			}	
			else if(option==4){
			System.out.println("sad list");
			System.out.println("kadhal valarthen");
			System.out.println("yedho ondru ennai");
	    	System.out.println("pogadhe");
			System.out.println("ninaithu ninaithu");
			}
			else{
				System.out.println("Your list is not avilable");
			}
          
		}
	}
}
		
	


			
			
			
			
			
		
	
	

		
		
		
		
		
		
		
	
	
	
	
	
	
	
	
	
	
	

	