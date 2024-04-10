package level1.num131705;

// Solution 클래스 정의
public class Solution {
	
	// solution() 메서드 정의
	public static int solution(int[] number) {
		
		// 삼총사를 만들 수 있는 방법의 수를 저장할 변수 count 초기화
		int count = 0;
		
		// for 반복문을 사용해 각 3명의 학생을 순회
		for (int s1 = 0; s1 < number.length - 2; s1++) {
			for (int s2 = s1 + 1; s2 < number.length - 1; s2++) {
				for (int s3 = s2 + 1; s3 < number.length; s3++) {
					
					// 세 명의 정수 번호 합이 0인 경우 삼총사를 만들 수 있는 방법의 수를 갱신
					if (number[s1] + number[s2] + number[s3] == 0)
						count++;
				}
			}
		}
		
		// 삼총사를 만들 수 있는 방법의 수를 반환
		return count;
    }
}