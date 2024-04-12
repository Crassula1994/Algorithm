package level1.num081301;

// Solution 클래스 정의
public class Solution {
	
	// solution() 메서드 정의
	public static int solution(String s) {
		
		// replace() 메서드를 사용해 영단어로 된 자릿수를 숫자로 변경
		s = s.replace("zero", "0").replace("one", "1").replace("two", "2").replace("three", "3")
			.replace("four", "4").replace("five", "5").replace("six", "6").replace("seven", "7")
			.replace("eight", "8").replace("nine", "9");
		
		// parseInt() 메서드를 사용해 해당 숫자를 숫자로 변환하고 이를 반환
		return Integer.parseInt(s);
    }
}