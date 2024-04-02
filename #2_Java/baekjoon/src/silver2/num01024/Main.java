package silver2.num01024;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 수열의 합과 최소 길이를 각 변수에 할당
		int sum = Integer.parseInt(st.nextToken());
		int minLength = Integer.parseInt(st.nextToken());
		
		// 길이가 100보다 작은 수열이 존재하는지 여부를 나타낼 변수 isExist 초기화
		boolean isExist = false;
		
		// for 반복문을 사용해 가능한 수열의 길이를 순회
		for (int length = minLength; length <= 100; length++) {
			
			// 초항을 계산하기 위해 필요한 분자를 변수 numerator에 할당
			int numerator = 2 * sum - length * (length - 1);
			
			// 초항을 구할 수 있는 경우
			if (numerator >= 0 && numerator % (2 * length) == 0) {
				
				// 길이가 100보다 작은 수열이 존재하는지 여부를 갱신
				isExist = true;
				
				// 초항을 구해 변수 startTerm에 할당
				int startTerm = numerator / (2 * length);
			
				// for 반복문을 사용해 가능한 수열을 빈 칸으로 구분하여 출력
				for (int term = startTerm; term < startTerm + length; term++)
					out.write(term + " ");
				
				// 반복문 탈출
				break;
			}
		}
		
		// 길이가 100보다 작은 수열이 존재하지 않는 경우 -1을 출력
		if (!isExist)
			out.write(String.valueOf(-1));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}