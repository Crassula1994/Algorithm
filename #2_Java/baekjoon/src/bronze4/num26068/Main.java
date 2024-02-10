package bronze4.num26068;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 임스가 받은 기프티콘의 개수를 변수 gifticonNum에 할당
		int gifticonNum = Integer.parseInt(in.readLine());
		
		// 임스가 사용할 기프티콘의 개수를 저장할 변수 count 초기화
		int count = 0;
		
		// for 반복문을 사용해 각 기프티콘의 유효기간을 순회
		for (int gifticon = 0; gifticon < gifticonNum; gifticon++) {
			
			// readLine(), substring(), parseInt() 메서드를 사용해 기프티콘의 유효기간을 변수 expiryDate에 할당
			int expiryDate = Integer.parseInt(in.readLine().substring(2));
			
			// 유효기간이 90일 이하인 경우 임스가 사용할 기프티콘의 개수를 갱신
			if (expiryDate <= 90)
				count++;
		}
		
		// valueOf() 및 write() 메서드를 사용해 임스가 사용할 기프티콘의 개수를 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}