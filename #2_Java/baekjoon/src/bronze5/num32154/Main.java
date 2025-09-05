package bronze5.num32154;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// 각 팀이 푼 문제의 수와 푼 문제 번호를 저장할 배열 scoreBoard 초기화
	static String[] scoreBoard = {
			"11\nA B C D E F G H J L M",
			"9\nA C E F G H I L M",
			"9\nA C E F G H I L M",
			"9\nA B C E F G H L M",
			"8\nA C E F G H L M",
			"8\nA C E F G H L M",
			"8\nA C E F G H L M",
			"8\nA C E F G H L M",
			"8\nA C E F G H L M",
			"8\nA B C F G H L M",
	};
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine(), parseInt(), write() 메서드를 사용해 해당 팀이 푼 문제 수와 문제 번호를 출력
		out.write(scoreBoard[Integer.parseInt(in.readLine()) - 1]);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}