package bronze3.num24265;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 입력의 크기를 변수 inputSize에 할당
		int inputSize = Integer.parseInt(in.readLine());
		
		// 수행 횟수를 저장할 변수 trialCnt 초기화
		long trialCnt = 0;
		
		// for 반복문을 사용해 수행 횟수를 갱신
		for (int num = 1; num < inputSize; num++)
			trialCnt += num;
		
		// write() 메서드를 사용해 코드의 수행 횟수 및 최고차항의 수를 출력
		out.write(trialCnt + "\n" + 2);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
    }
}