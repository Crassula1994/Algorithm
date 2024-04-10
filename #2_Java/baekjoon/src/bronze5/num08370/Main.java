package bronze5.num08370;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 비즈니스석과 이코노미석의 행과 열의 개수를 각 변수에 저장
		int businessR = Integer.parseInt(st.nextToken());
		int businessC = Integer.parseInt(st.nextToken());
		int economyR = Integer.parseInt(st.nextToken());
		int economyC = Integer.parseInt(st.nextToken());
		
		// 비행기의 총 좌석 수를 계산해 변수 totalSeat에 할당
		int totalSeat = businessR * businessC + economyR * economyC;
		
		// valueOf() 및 write() 메서드를 사용해 비행기의 총 좌석 수를 출력
		out.write(String.valueOf(totalSeat));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}