package bronze5.num34052;

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

		// 우경이가 네 바퀴를 뛰는 데 걸린 시간을 저장할 변수 totalTime 초기화
		int totalTime = 0;
		
		// for 반복문을 사용해 우경이가 네 바퀴를 뛰는 데 걸린 시간을 갱신
		for (int count = 0; count < 4; count++)
			totalTime += Integer.parseInt(in.readLine());
		
		// write() 메서드를 사용해 우경이가 마지막 바퀴를 300초에 뛰어서 수행평가를 무사히 통과할 수 있는지 여부를 출력
		out.write((totalTime <= 1500) ? "Yes" : "No");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}