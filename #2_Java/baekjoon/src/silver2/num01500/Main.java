package silver2.num01500;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 목표 합과 정수의 개수를 각 변수에 할당
		int targetSum = Integer.parseInt(st.nextToken());
		int numberCnt = Integer.parseInt(st.nextToken());
		
		// 정수의 최대 곱을 저장할 변수 maxProduct 초기화
		long maxProduct = 1;
		
		// 목표 합을 정수의 개수로 나눈 몫과 나머지를 각 변수에 할당 
		int quotient = targetSum / numberCnt;
		int remains = targetSum % numberCnt;
		
		// for 반복문을 사용해 정수의 값이 목표 합을 정수의 개수로 나눈 몫인 경우를 정수의 최대 곱에 반영
		for (int count = 0; count < numberCnt - remains; count++)
			maxProduct *= quotient;
		
		// for 반복문을 사용해 정수의 값이 목표 합을 정수의 개수로 나눈 몫보다 1 큰 경우를 정수의 최대 곱에 반영
		for (int count = 0; count < remains; count++)
			maxProduct *= quotient + 1;
		
		// valueOf() 및 write() 메서드를 사용해 정수의 최대 곱을 출력
		out.write(String.valueOf(maxProduct));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}