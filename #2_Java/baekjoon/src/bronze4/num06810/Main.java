package bronze4.num06810;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 메서드를 사용해 입력 받은 열세 자리의 ISBN을 변수 isbn에 할당
		String isbn = "9780921418" + in.readLine() + in.readLine() + in.readLine();
		
		// 주어진 ISBN의 1-3 합을 저장할 변수 sum 초기화
		int sum = 0;
		
		// for 반복문을 사용해 각 ISBN의 자리를 순회
		for (int idx = 0; idx < isbn.length(); idx++) {
			
			// charAt() 메서드를 사용해 해당 자릿수를 변수 digit에 할당
			int digit = isbn.charAt(idx) - '0';

			// 홀수 번째 자리인 경우 ISBN의 1-3 합을 갱신
			if (idx % 2 == 0) {
				sum += digit;
				
			// 짝수 번째 자리인 경우 ISBN의 1-3 합을 갱신
			} else {
				sum += digit * 3;
			}
		}
		
		// vwrite() 메서드를 사용해 주어진 ISBN의 1-3 합을 출력
		out.write("The 1-3-sum is " + sum);
			
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}