package bronze5.num08871;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 라운드의 수를 변수 roundNum에 할당
		int roundNum = Integer.parseInt(in.readLine()) + 1;
		
		// write() 메서드를 사용해 대회에서 주어질 수 있는 문제의 최솟값과 최댓값을 출력
		out.write((roundNum * 2) + " " + (roundNum * 3));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}