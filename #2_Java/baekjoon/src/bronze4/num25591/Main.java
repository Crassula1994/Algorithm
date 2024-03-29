package bronze4.num25591;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 두 양의 정수를 각 변수에 할당
		int num1 = Integer.parseInt(st.nextToken());
		int num2 = Integer.parseInt(st.nextToken());
		
		// 베다수학 곱셈범을 쓰는 과정에서 구하는 각 숫자를 각 변수에 할당
		int numA = 100 - num1;
		int numB = 100 - num2;
		int numC = 100 - (numA + numB);
		int numD = numA * numB;
		int numQ = numD / 100;
		int numR = numD % 100;
		
		// write() 메서드를 사용해 베다수학 곱셈범을 쓰는 과정에서 구하는 각 숫자를 출력
		out.write(numA + " " + numB + " " + numC + " " + numD + " " + numQ + " " + numR + "\n");
		
		// 숫자 d가 두 자리 수를 넘는 경우 곱셈 결과를 출력
		if (numD > 99) {
			out.write((numC + numQ) + " " + numR);
			
		// 숫자 d가 두 자리 수를 넘지 않는 경우 곱셈 결과를 출력
		} else {
			out.write(numC + " " + numD);
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}