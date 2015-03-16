import javax.swing.JOptionPane;
public class finalProject
{
	public static void main (String [] args)
	{
		int choice;
		String menuOption = "";
		while ((menuOption != null) && (!(menuOption.equals("0"))))
		{
			menuOption = getMenuOption();
			if (menuOption != null)
			{
				choice = Integer.parseInt(menuOption);
				if (choice != 0)
				{
					switch(choice)
					{
						case 1: analyzeVowelContentOfWordPhrase();		 break;
						case 2: analyzeConsonatContentOfWordPrase();	 break;
						case 3: analyzeWordPhraseContent();				 break;
						case 4: analyzePalindrome();	 			     break;
						case 5: areWordsPhrasesAnagrams(); 		    	 break;
						case 6: determineLongestShortestWord();    		 break;
						
					}
				}
			}
		}
	}
///////////////////////////////////////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
///////////////////////////////////////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\	
	public static String getMenuOption()
	{
		String menuOptions = "1 . Analyze vowel content of word/phrase. " +
		  "\n2 . Analyze Consonant frequency of a word/phrase. " + 
		  "\n3 . Analyse a word or sentence " +
		  "\n4 . is word/phrase/scentence a palindrom? " + 
		  "\n5 . Are 2 words/phrases anagrams of each other. " + 
		  "\n6 . Display Shortest & longest words in a sentence. " + 
		  "\n0 . Exit. ";
		  
		  boolean validInput = false;
		  String selection = "", menuChoicePattern = "[0-6]{1}";
		  String errorMessage = "Invalid menu selection";
		  		 errorMessage += "\n\nValid options are 0 to 7 inclusive";
		  		 errorMessage += "\nSelect Ok to retry";	
		  		 
	 while (!(validInput))
	  	{
			selection = JOptionPane.showInputDialog(null, menuOptions, 
			  		"Choose number of option you wish have executed",3);
			if (selection == null || selection.matches(menuChoicePattern))
			  	validInput = true;
			else
				JOptionPane.showMessageDialog(null, errorMessage, "Error in user input", 2);
		}
			return selection;
			  				
		}
		
///////////////////////////////////////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
///////////////////////////////////////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\		
	public static String getWordPhraseFromUser(String windowMessage, String windowTitle)
	{
		boolean validInput = false;
		String userInput = "";
		String pattern = "([a-zA-Z]+)|(([a-zA-Z]+\\s[a-zA-Z]+)+)";
		String errorMessage = "Invalid input.";
		  		 errorMessage += "\n\nEnter a word or phrase comprising";
		  		 errorMessage += "\nalphabetic characters only";
		  		 errorMessage += "\nSelect OK to rety";
		  		 
		  		 
		while (!(validInput))
		{
			userInput = JOptionPane.showInputDialog(null, windowMessage, windowTitle, 3);
			
			if ((userInput == null) || (userInput.matches(pattern)))
			validInput = true;
			else
			JOptionPane.showMessageDialog(null, errorMessage, "Error in user input", 2);
		}
		return userInput;
	}
	
	
//////////////////////////////////////////////METHOD A\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
///////////////////////////////////////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\		
	public static void analyzeVowelContentOfWordPhrase()
	{	   		    
	  String vowels = "aeiou";
	  String[] vowelLetters = vowels.split("");
	  String windowMessage = "Please enter a word, sentence or phrase.";
	  String windowTitle= "Vowel analysis";
	  String userInput = getWordPhraseFromUser(windowMessage, windowTitle);
	  String copyInput = userInput;
      userInput = userInput.toLowerCase();    
      String[] inputLetters= userInput.split("");
      String aChar = "";
      boolean isAlpha = true, isVowel = true; 
      boolean isReverseAlpha = true; 
      String result = "";
      int positionVowel = -1;
      int reversePositionVowel=vowelLetters.length;
      int positionNo = 0, aNum = -1;
      int vCount = 0;
      int freq=0;	        
	  for(int i = 0;i<vowels.length();i++)
	  {
	    aChar = vowels.substring(i,i+1);
	    if(userInput.indexOf(aChar)!=-1)	    	   
	      positionNo++;	     
	  }              
      if (positionNo ==0)       
	    result+= "String contains no vowels" + "\n";	  
      else if (positionNo ==5)       
	    result+= "String contains all vowels in any order" + "\n";
           
      for(int i = 0;i<userInput.length();i++)
      {
        aChar = userInput.substring(i,i+1);
        if(vowels.indexOf(aChar)!=-1)      
          vCount++;
             
      }	
	  result+= "Vowel Count = " + vCount + "\n";  
	  if(positionNo == 5)
	  {  
        for(int i=0; i<copyInput.length() && isAlpha == true;i++)//Checks if input is alphabetical
		{		
		  System.out.print(copyInput.charAt(i));
		  isVowel = true;
		  for(int j=0; j<vowelLetters.length;j++)	
		  {
		    if(copyInput.substring(i, i+1).equalsIgnoreCase(vowelLetters[j]) && isVowel == true) 
		    {
		      aNum = j; 
		      System.out.print("-");	
		      isVowel = false; 		    
			}	                		  
	      }
	      if(aNum < positionVowel)
		    isAlpha = false;
		  else
			positionVowel = aNum;
		}	
				
		for(int i=0; i<copyInput.length() && isReverseAlpha == true;i++)//Checks if input is alphabetical
		{		
		  System.out.print(copyInput.charAt(i));
	      isVowel = true;
		  for(int j=0; j<vowelLetters.length;j++)	
		  {
		    if(copyInput.substring(i, i+1).equalsIgnoreCase(vowelLetters[j]) && isVowel == true) 
		    {
		      aNum = j; 
			    System.out.print("-");	
				isVowel = false; 		    
			}	                		  
	      }
		  if(aNum > reversePositionVowel)
		    isReverseAlpha = false;
		  else
		    reversePositionVowel = aNum;
		}	
	    if (isAlpha)
		  result+=  copyInput + " contains all the vowels in alphabetical order." + "\n"	;	
		if (isReverseAlpha)
	      result+=  copyInput + " contains all the vowels in reverse alphabetical order." + "\n"	;
	  }
      for (int i=0;i<vowelLetters.length;i++)
      { 
	    freq =0;  	   	  
        for(int j =0;j<inputLetters.length;j++)
        {	    	   
	      if(vowelLetters[i].equals(inputLetters[j]))
	        freq++;
	     }
	     if(freq>0 && vowelLetters[i] != vowelLetters[0])
	       result +="The letter " + vowelLetters[i] + " appears " + freq + " Time(s)" + "\n" ;
	  }    							
	  System.out.println("Alpha = " + isAlpha + "\n");
	  System.out.println("Reverse alpha = " + isReverseAlpha + "\n");
	  JOptionPane.showMessageDialog(null, result);
	}
	
//////////////////////////////////////////////METHOD B\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
///////////////////////////////////////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\		
	public static void analyzeConsonatContentOfWordPrase()
	{
	  String consonant = "bcdfghijklmnpqrstvwxyz";
	  String[] consonantLetters = consonant.split(""); 
	  String windowMessage = "Please enter a word, sentence or phrase.";
	  String windowTitle= "Consonant analysis";
	  String userInput = getWordPhraseFromUser(windowMessage, windowTitle);    
	  String copyInput = userInput;
	  userInput = userInput.toLowerCase();    
	  String[] inputLetters= userInput.split("");
	  String aChar = "";
	  boolean isAlpha = true; 
	  boolean isReverseAlpha = true; 
	  boolean isConsonant = true;
	  String result = "";
	  int positionConsonant = -1;
	  int reversePositionConsonant=consonantLetters.length;        
	  int positionNo = 0, aNum = -1;
	  int cCount = 0;
	  int freq=0;	        
	  for(int i = 0;i<consonant.length();i++)
	  {
	    aChar = consonant.substring(i,i+1);
        if(userInput.indexOf(aChar)!=-1)	    
	      positionNo++;	    
	  }              
	  if (positionNo ==0) 
	  { 
		result+= "String contains no consonants" + "\n";
      }
	  else if (positionNo ==22) 
	  {
	    result+= "String contains all consonants in any order" + "\n";
	  }       
	  for(int i = 0;i<userInput.length();i++)
	  {
	    aChar = userInput.substring(i,i+1);
	    if(consonant.indexOf(aChar)!=-1)
	    {  
	      cCount++;
	    }	      
	  }	
      result+= "Consonant Count = " + cCount + "\n";	
	  for (int i=0;i<consonantLetters.length;i++)//Frequency Check
	  { 
	    freq =0;  	   	  
	    for(int j =0;j<inputLetters.length;j++)
	    {	    
		  if(consonantLetters[i].equals(inputLetters[j]))
		  {
		    freq++;
		    System.out.println(freq); 		  
          }	   
	    }
		if(freq>0 && consonantLetters[i] != consonantLetters[0])
		result +="The letter " + consonantLetters[i] + " appears " + freq + " Times" + "\n" ;
      }    	    
		
		if(positionNo == 21)
		{  
			for(int i=0; i<copyInput.length() && isAlpha == true;i++)//Checks if input is alphabetical
			{		
				System.out.print(copyInput.charAt(i));
				isConsonant= true;
			    for(int j=0; j<consonantLetters.length;j++)	
			    {
			      if(copyInput.substring(i, i+1).equalsIgnoreCase(consonantLetters[j]) && isConsonant== true) 
			      {
					  aNum = j; 
					  System.out.print("-");	
					  isConsonant= false; 		    
				  }	                		  
				}
				if(aNum < positionConsonant)
					isAlpha = false;
				else
					positionConsonant= aNum;
			}	
					
			/*for(int i=0; i<copyInput.length() && isReverseAlpha == true;i++)//Checks if input is alphabetical
			{		
				System.out.print(copyInput.charAt(i));
				isConsonant = true;
			    for(int j=0; j<consonantLetters.length;j++)	
			    {
			      if(copyInput.substring(i, i+1).equalsIgnoreCase(consonantLetters[j]) && isConsonant == true) 
			      {
					  aNum = j; 
					  System.out.print("-");	
					  isConsonant = false; 		    
				  }	                		  
				}
				if(aNum > positionConsonant)
					isReverseAlpha = false;
				else
					positionConsonant= aNum;
			}	*/
		    if (isAlpha)
			  result+=  copyInput + " contains all the vowels in alphabetical order." + "\n"	;	
			if (isReverseAlpha)
				result+=  copyInput + " contains all the vowels in reverse alphabetical order." + "\n"	;		
		 }				
		  System.out.println("Alpha = " + isAlpha + "\n");
		  System.out.println("Reverse alpha = " + isReverseAlpha + "\n");
		  JOptionPane.showMessageDialog(null, result);
	}
	
	
//////////////////////////////////////////////METHOD C\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
///////////////////////////////////////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\		
	public static void analyzeWordPhraseContent()
	{
	}
			
	
			
//////////////////////////////////////////////METHOD D\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
///////////////////////////////////////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\		
	public static void areWordsPhrasesAnagrams()
	{
		String phrase1, phrase2;
		phrase1 = getWordPhraseFromUser("Are words/Phrases anagrams?","Enter first word/Phrase");
		
		if(phrase1 != null)
		{
			phrase2 = getWordPhraseFromUser("Are words/Phrases anagrams?","Enter second word/Phrase");
			
			if (phrase2 != null)
			{
			// code to check here	
				
			}
		}
	}


///////////////////////////////////////////////METHOD E\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
///////////////////////////////////////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\		  		 	
	public static void analyzePalindrome()
	{
		int wordLength;
		String userInput, reverseWord = ""; 
		userInput = getWordPhraseFromUser("Is word/phrase a palindrom?","Enter word/Phrase");
		boolean palin;
		
		userInput = userInput.trim();
		wordLength = userInput.length();
				
		for (int i = wordLength - 1; i >= 0; i--)
		{
			reverseWord += userInput.substring(i,i + 1);
		}
				
		palin = userInput.equalsIgnoreCase(reverseWord);
		
		if (palin == true)
		JOptionPane.showMessageDialog(null,"The word is a palindrome");
		else
		JOptionPane.showMessageDialog(null,"The word is not a palindrome");
	}	
	
//////////////////////////////////////////////METHOD F\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
///////////////////////////////////////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\		
	public static void determineLongestShortestWord()
	{
	}	
	
			
}	//CLOSE MAIN METHOD

	
