package bronze3.num25841;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 숫자의 범위 및 개수를 셀 자릿수를 각 변수에 할당
		int startNumber = Integer.parseInt(st.nextToken());
		int endNumber = Integer.parseInt(st.nextToken());
		int digit = Integer.parseInt(st.nextToken());
		
		// 숫자 범위에서 등장하는 자릿수의 개수를 저장할 변수 count 초기화
		int count = 0;
		
		// for 반복문을 사용해 숫자의 범위에 속한 각 숫자를 순회
		for (int number = startNumber; number <= endNumber; number++) {
			
			// 자릿수를 순회하기 위해 남은 자릿수를 저장할 변수 remain 초기화
			int remain = number;
			
			// while 반복문을 사용해 각 자릿수를 순회
			while (remain > 0) {
				
				// 해당 자릿수가 등장한 경우 자릿수의 개수를 갱신
				if (remain % 10 == digit)
					count++;
				
				// 다음 자릿수를 순회
				remain /= 10;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 숫자 범위에서 등장하는 자릿수의 개수를 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}