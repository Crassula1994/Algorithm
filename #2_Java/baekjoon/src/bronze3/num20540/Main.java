package bronze3.num20540;

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
		
		// readLine() 메서드를 사용해 입력 받은 연길이의 MBTI를 변수 indicatorY에 할당
		String indicatorY = in.readLine();
		
		// charAt() 및 write() 메서드를 사용해 연길이의 이상형 MBTI를 출력
		out.write((indicatorY.charAt(0) == 'I') ? "E" : "I");
		out.write((indicatorY.charAt(1) == 'S') ? "N" : "S");
		out.write((indicatorY.charAt(2) == 'T') ? "F" : "T");
		out.write((indicatorY.charAt(3) == 'J') ? "P" : "J");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}