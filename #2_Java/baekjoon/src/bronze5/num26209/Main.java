package bronze5.num26209;

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
		
		// 모든 비트가 성공적으로 읽혔는지 여부를 저장할 변수 isReadable 초기화
		boolean isReadable = true;
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 각 비트를 순회
		for (int b = 0; b < 8; b++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 비트를 변수 bit에 할당
			int bit = Integer.parseInt(st.nextToken());
			
			// 해당 비트가 9인 경우 모든 비트가 성공적으로 읽혔는지 여부를 갱신 후 반복문 탈출
			if (bit == 9) {
				isReadable = false;
				break;
			}
		}
		
		// write() 메서드를 사용해 모든 비트가 성공적으로 읽혔는지 여부를 출력
		out.write((isReadable) ? "S" : "F");

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}