package bronze2.num10870;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 피보나치 수의 순번을 변수 parameter에 저장
		int parameter = Integer.parseInt(in.readLine());
		
		// fibo() 메서드를 호출해 나온 결과를 변수 result에 할당
		int result = fibo(parameter);
		
		// valueOf() 및 write() 메서드를 사용해 피보나치 수를 출력
		out.write(String.valueOf(result));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	//----------------------------------------------------------------------------------------------------
	
	// fibo() 메서드 정의
	public static int fibo(int parameter) {
		
		// 0 또는 1인 경우 해당 값을 그대로 반환
		if (parameter < 2)
			return parameter;

		// fibo() 메서드 재귀 호출
		return fibo(parameter - 1) + fibo(parameter - 2);
	}
}