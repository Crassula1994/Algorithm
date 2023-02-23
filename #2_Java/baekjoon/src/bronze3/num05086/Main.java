package bronze3.num05086;

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
		
		// while 반복문을 사용해 마지막 줄까지 순회
		while (true) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 두 숫자를 각 변수에 할당
			int num1 = Integer.parseInt(st.nextToken()); 
			int num2 = Integer.parseInt(st.nextToken());
			
			// 출력한 문자열 answer 초기화
			String answer = "";
			
			// 두 숫자가 0인 경우 반복문 탈출
			if (num1 == num2) {
				break;
			
			// 첫 번째 숫자가 더 큰 경우
			} else if (num1 > num2) {
				
				// 배수가 아니라면 'neither', 배수라면 'multiple'을 변수 answer에 할당
				answer = (num1 % num2 == 0) ? "multiple" : "neither";
			
			// 두 번째 숫자가 더 큰 경우
			} else {
				
				// 약수가 아니라면 'neither', 약수라면 'factor'를 변수 answer에 할당
				answer = (num2 % num1 == 0) ? "factor" : "neither";
			}
			
			// write() 메서드를 사용해 문자열을 출력
			out.write(answer + "\n");
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}