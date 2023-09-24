package silver4.num02960;

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

		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 마지막 정수, 지워지는 수의 순서를 각 변수에 할당
		int lastNum = Integer.parseInt(st.nextToken());
		int targetOrder = Integer.parseInt(st.nextToken());
		
		// 각 숫자가 지워졌는지를 나타내는 배열 isErased 초기화
		boolean[] isErased = new boolean[lastNum + 1];
		
		// 지운 수의 개수를 저장할 변수 count 초기화
		int count = 0;
		
		// for 반복문을 사용해 각 숫자를 순회
		outer: for (int n = 2; n <= lastNum; n++) {
			
			// 해당 숫자가 이미 지워진 경우 다음 숫자를 순회
			if (isErased[n])
				continue;
			
			// for 반복문을 사용해 각 숫자의 배수를 순회
			for (int m = n; m <= lastNum; m += n) {
				
				// 해당 숫자가 이미 지워진 경우 다음 숫자를 순회
				if (isErased[m])
					continue;
				
				// 해당 숫자를 지우고, 지운 수의 개수를 갱신
				isErased[m] = true;
				count++;
				
				// 지운 수의 개수가 지워지는 수의 순서에 이른 경우
				if (count == targetOrder) {
					
					// valueOf() 및 write() 메서드를 사용해 해당 숫자를 출력
					out.write(String.valueOf(m));
					
					// 반복문 탈출
					break outer;
				}
			}			
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}