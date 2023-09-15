package silver3.num02193;

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
		
		// parseInt() 및 readLine() 메서드를 사용해 입력 받은 이친수의 길이를 변수 length에 할당
		int length = Integer.parseInt(in.readLine());
		
		// 각 길이별 이친수의 개수를 저장할 배열 counter 초기화
		long[] counter = new long[length + 1];
		
		// 길이가 1인 경우 이친수의 개수를 초기화
		counter[1] = 1;
		
		// for 반복문을 사용해 각 이친수의 길이를 갱신
		for (int l = 2; l <= length; l++)
			counter[l] = counter[l - 1] + counter[l - 2];
		
		// valueOf() 및 write() 메서드를 사용해 이친수의 개수를 출력
		out.write(String.valueOf(counter[length]));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}