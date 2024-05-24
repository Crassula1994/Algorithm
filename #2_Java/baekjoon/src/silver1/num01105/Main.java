package silver1.num01105;

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
		
		// nextToken() 및 toCharArray() 메서드를 사용해 입력 받은 숫자의 자릿수를 각 배열에 할당
		char[] left = st.nextToken().toCharArray();
		char[] right = st.nextToken().toCharArray();
		
		// 8이 가장 적게 들어있는 수에 들어있는 8의 개수를 저장할 변수 minCount 초기화
		int minCount = 0;
		
		// 두 숫자의 자릿수가 같은 경우
		if (left.length == right.length) {
			
			// for 반복문을 사용해 각 자릿수를 차례로 순회
			for (int idx = 0; idx < left.length; idx++) {
				
				// 각 자릿수를 각 변수에 할당
				int leftDigit = left[idx] - '0';
				int rightDigit = right[idx] - '0';
				
				// 두 숫자가 같지 않은 경우 반복문 탈출
				if (leftDigit != rightDigit)
					break;
				
				// 두 숫자가 8로 같은 경우 8이 가장 적게 들어있는 수에 들어있는 8의 개수를 갱신
				if (leftDigit == 8 && rightDigit == 8)
					minCount++;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 8이 가장 적게 들어있는 수에 들어있는 8의 개수를 출력
		out.write(String.valueOf(minCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}