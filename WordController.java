package hello;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordController {    
	@RequestMapping("/words/{word}")
	@ResponseBody
	public WordDTO words(@PathVariable("word") String name) {
		WordService wordService=new WordService();
		WordDTO wordDTO=new WordDTO();
		wordDTO.setWord("word");
		wordDTO.setPalindrome(wordService.isPalindrome(wordDTO.getWord()));
		wordDTO.setAnagramOfPalindrome(wordService.isAnagramOfPalindrome(wordDTO.getWord()));
		return wordDTO;
    }
}
	