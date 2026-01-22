package bronze2.num04388;

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
		
		// StringBuilder 객체를 불러와 변수 sb에 할당
		StringBuilder sb = new StringBuilder();
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (true) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 메서드를 사용해 입력 받은 각 숫자를 각 변수에 할당
			String numberStringA = st.nextToken();
			String numberStringB = st.nextToken();
			
			// 모든 테스트 케이스를 확인한 경우 반복문 탈출
			if (numberStringA.equals("0") && numberStringB.equals("0"))
				break;
			
			// length() 메서드를 사용해 현재 각 숫자의 자릿수, 받아올림의 값, 받아올림의 개수를 저장할 각 변수 초기화
			int curIdxA = numberStringA.length() - 1;
			int curIdxB = numberStringB.length() - 1;
			int carry = 0;
			int count = 0;
			
			// while 반복문을 사용해 각 자릿수를 순회
			while (curIdxA >= 0 || curIdxB >= 0) {
				
				// charAt() 메서드를 사용해 각 숫자의 해당 자릿수를 각 변수에 할당
				int digitA = (curIdxA >= 0) ? numberStringA.charAt(curIdxA--) - '0' : 0;
				int digitB = (curIdxB >= 0) ? numberStringB.charAt(curIdxB--) - '0' : 0;
				
				// 해당 자릿수에서 받아올림이 생기는 경우 받아올림의 값 및 받아올림의 개수를 갱신
				if (digitA + digitB + carry >= 10) {
					carry = 1;
					count++;
					
				// 해당 자릿수에서 받아올림이 생기지 않는 경우 받아올림의 값을 갱신
				} else {
					carry = 0;
				}
			}
			
			// append() 메서드를 사용해 받아올림의 개수를 sb에 저장
			sb.append(count).append("\n");
		}
		
		// toString() 및 write() 메서드를 사용해 
		out.write(sb.toString());
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}