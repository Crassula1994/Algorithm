package silver4.num25379;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 배열의 원소의 개수를 변수 elementNum에 할당
		int elementNum = Integer.parseInt(in.readLine());
		
		// 각 원소까지 존재하는 홀수, 짝수의 수 및 홀수와 짝수를 각각 왼쪽 끝으로 보내기 위한 이동 횟수를 저장할 각 변수 초기화
		int countOdd = 0;
		int countEven = 0;
		long moveCountOdd = 0;
		long moveCountEven = 0;
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// while 반복문을 사용해 각 원소를 순회
		while (elementNum-- > 0) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 원소를 변수 element에 할당
			int element = Integer.parseInt(st.nextToken());
			
			// 해당 원소가 홀수인 경우 홀수의 개수 및 홀수를 왼쪽 끝으로 보내기 위한 이동 횟수를 갱신
			if ((element & 1) == 1) {
				countOdd++;
				moveCountOdd += countEven;
				
			// 해당 원소가 짝수인 경우 짝수의 개수 및 짝수를 왼쪽 끝으로 보내기 위한 이동 횟수를 갱신
			} else {
				countEven++;
				moveCountEven += countOdd;
			}
		}
		
		// min(), valueOf(), write() 메서드를 사용해 홀수와 짝수가 최대 한 번 인접하도록 하는 시행의 최소 횟수를 출력
		out.write(String.valueOf(Math.min(moveCountOdd, moveCountEven)));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}