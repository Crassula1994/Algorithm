package bronze1.num25400;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 정수의 개수를 변수 cardNum에 할당
		int cardNum = Integer.parseInt(in.readLine());
		
		// 제자리 상태가 되기 위해 제거해야 하는 최소 카드의 수를 저장할 변수 minCount 초기화
		int minCount = 0;
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 각 카드에 적힌 숫자를 순회
		for (int card = 0, targetNumber = 1; card < cardNum; card++) {
			
			// 제자리 상태인 숫자인 경우 찾는 숫자를 갱신 후 다음 카드를 순회
			if (Integer.parseInt(st.nextToken()) == targetNumber) {
				targetNumber++;
				continue;
			}
			
			// 제자리 상태가 되기 위해 제거해야 하는 최소 카드의 수를 갱신
			minCount++;
		}
		
		// valueOf() 및 write() 메서드를 사용해 제자리 상태가 되기 위해 제거해야 하는 최소 카드의 수를 출력
		out.write(String.valueOf(minCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}