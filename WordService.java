package hello;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class WordService {
	public boolean isPalindrome(String word) {
        Integer fwdCount, revCount;
        boolean isPalindrome = true;
            isPalindrome = true;
            
            fwdCount = 0;
            revCount = word.length() - 1;
            
            while(fwdCount < word.length()) {
                if(word.charAt(fwdCount) != word.charAt(revCount)) {
                    isPalindrome = false;
                    break;
                }
                
                fwdCount ++;
                revCount --;
            }
            
            if(isPalindrome) {
                System.out.println("" + word + " is Palindrome");
            } else {
                System.out.println("" + word + " is not a Palindrome");
            }
            
            return isPalindrome;
	}
	
	public boolean isAnagramOfPalindrome(String word) {
		boolean isAnagramOfPalindrome = true;
		/*
		 * Create a map of characters vs its count.
		 */
		Map<String,Long> mapOfElements = Arrays.stream(word.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		int oddCount = 0, evenCount = 0;
		if(!mapOfElements.isEmpty()) {
			for(Long count : mapOfElements.values()) {
				if(count % 2 == 0) {
					evenCount++;
				} else if(count % 1 == 0) {
					oddCount++;
				}  
				
				if(oddCount > 1) {
					isAnagramOfPalindrome = false;
					break;
				}
			}
		}
		
		return isAnagramOfPalindrome;
	}
} 
