package gold4.num01364;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 송유진이 가진 아이템의 수를 변수 itemNum에 할당
		int itemNum = Integer.parseInt(in.readLine());
		
		// 아이템을 이용하여 점령할 수 있는 최대의 블록 수를 저장할 변수 maxBlock 초기화
		long maxBlock = 1;
		
		// for 반복문을 사용해 각 아이템의 개수를 갱신
		for (int item = 2; item <= itemNum; item++) {
			
			// 6으로 나눈 몫에서 1을 더한 값을 추가
			maxBlock += item / 6 + 1;
			
			// 6으로 나누었을 때 나머지가 1인 경우 1을 제거
			if (item % 6 == 1)
				maxBlock--;
		}

		// valueOf() 및 write() 메서드를 사용해 아이템을 이용하여 점령할 수 있는 최대의 블록 수를 출력
		out.write(String.valueOf(maxBlock));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}