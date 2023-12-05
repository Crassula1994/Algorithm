package bronze4.num16204;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 전체 카드의 수, 앞면과 뒷면에 각각 'O'가 적힌 카드의 수를 각 변수에 할당
		int cardNum = Integer.parseInt(st.nextToken());
		int frontNum = Integer.parseInt(st.nextToken());
		int backNum = Integer.parseInt(st.nextToken());
		
		// abs() 메서드를 사용해 앞면과 뒷면에 같은 모양이 적혀 있는 카드의 최대 개수를 계산해 변수 maxCount에 할당
		int maxCount = cardNum - Math.abs(frontNum - backNum);
		
		// valueOf() 및 write() 메서드를 사용해 앞면과 뒷면에 같은 모양이 적혀 있는 카드의 최대 개수를 출력
		out.write(String.valueOf(maxCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}