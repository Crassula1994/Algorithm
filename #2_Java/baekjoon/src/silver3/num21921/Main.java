package silver3.num21921;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 블로그 운영 기간과 방문자 수 확인 기간을 각 변수에 할당
		int totalTerm = Integer.parseInt(st.nextToken());
		int checkTerm = Integer.parseInt(st.nextToken());
		
		// 각 날짜별 방문자 수를 저장할 배열 visitNum 초기화
		int[] visitNum = new int[totalTerm];
		
		// 최대 방문자 수, 기간의 빈도 수를 저장할 각 변수 초기화
		int maxSum = 0;
		int count = 1;
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 방문자 수를 배열 visitNum에 저장
		for (int idx = 0; idx < totalTerm; idx++) {
			visitNum[idx] = Integer.parseInt(st.nextToken());
			
			// 첫 기간 동안의 최대 방문자 수를 갱신
			if (idx < checkTerm)
				maxSum += visitNum[idx];
		}
		
		// 방문자 수를 확인할 기간의 시작과 끝을 나타낼 각 인덱스 변수, 방문자 수의 합을 저장할 변수 초기화
		int start = 0;
		int end = checkTerm;
		int sum = maxSum;
		
		// while 반복문을 사용해 끝 인덱스가 배열의 끝에 도달할 때까지 순회
		while (end < totalTerm) {
		
			// 가장 앞의 값을 제거하고 가장 뒤의 값을 제거한 값을 새로운 합으로 갱신
			sum = sum - visitNum[start++] + visitNum[end++];
			
			// 해당 합이 기존의 최대 방문자 수와 같은 경우 빈도 수 갱신
			if (sum == maxSum) {
				count++;
			
			// 해당 합이 기존의 최대 방문자 수보다 큰 경우 최대 방문자 수 및 빈도 수 갱신
			} else if (sum > maxSum) {
				maxSum = sum;
				count = 1;
			}
		}
		
		// 최대 방문자 수가 0인 경우 'SAD' 출력
		if (maxSum == 0) {
			out.write("SAD");
			
		// 최대 방문자 수가 0이 아닌 경우 최대 방문자 수와 해당 기간의 빈도 수를 출력
		} else {
			out.write(maxSum + "\n" + count); 
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}