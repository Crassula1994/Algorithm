package bronze1.num02609;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 두 자연수를 각 변수에 할당
		int num1 = Integer.parseInt(st.nextToken());
		int num2 = Integer.parseInt(st.nextToken());
		
		// num2가 더 큰 수일 경우 num1이 더 큰 수가 되도록 두 수 변경
		if (num1 < num2) {
			int temp = num1;
			num1 = num2;
			num2 = temp;
		}
		
		// 최대공약수를 저장할 변수 gcd 초기화
		int gcd = 0;
		
		// for 반복문을 사용해 작은 수까지 모든 자연수를 순회
		for (int n = 1; n < num2 + 1; n++) {
			
			// 두 수의 공약수인 경우 최대공약수의 값을 갱신
			if (num1 % n == 0 && num2 % n == 0)
				gcd = n;
		}
		
		// 최소공배수를 계산해 변수 lcm에 할당
		int lcm = gcd * (num1 / gcd) * (num2 / gcd);
		
		// write() 메서드를 사용해 최대공약수 및 최소공배수를 출력
		out.write(gcd + "\n" + lcm);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}