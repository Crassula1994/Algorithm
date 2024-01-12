package level2.num178870;

// Solution 클래스 정의
public class Solution {

	// solution() 메서드 정의
	public static int[] solution(int[] sequence, int k) {

		// 부분 수열의 시작 인덱스와 마지막 인덱스, 부분 수열의 합을 저장할 각 변수 초기화
		int start = 0;
        int end = 0;
        int sum = sequence[0];
        
        // 찾으려는 부분 수열의 시작 인덱스와 마지막 인덱스를 저장할 배열 result 초기화
        int[] result = {-1, -1};
        
        // while 반복문을 사용해 부분 수열의 시작 인덱스가 끝에 도달할 때까지 순회
        while (start < sequence.length) {
            
        	// 부분 수열의 합이 목표로 하는 합과 같은 경우
            if (sum == k) {
            	
            	// 처음 찾은 부분 수열이거나 기존에 찾은 부분 수열보다 길이가 짧은 경우 부분 수열의 각 인덱스를 갱신
                if (result[0] == -1 || result[1] - result[0] > end - start) {
                    result[0] = start;
                    result[1] = end;
                }
                
                // 부분 수열의 시작 인덱스 및 그 합을 갱신
                sum -= sequence[start++];
                
            // 부분 수열의 끝 인덱스가 마지막에 도달했거나 부분 수열의 합이 목표로 하는 합보다 큰 경우
            } else if (end == sequence.length -1 || sum > k) {
            	
            	// 부분 수열의 시작 인덱스 및 그 합을 갱신
                sum -= sequence[start++];
                
            // 부분 수열의 끝 인덱스가 마지막에 도달하지 않았고 부분 수열의 합이 목표로 하는 합보다 작은 경우
            } else {
            	
            	// 부분 수열의 끝 인덱스 및 그 합을 갱신
                sum += sequence[++end];
            }
        }
        
        // 부분 수열의 시작 인덱스와 마지막 인덱스를 저장한 배열 반환
        return result;
    }
}