package bronze2.num02355;

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
		
		// nextToken() 및 parseLong() 메서드를 사용해 입력 받은 두 정수를 각 변수에 할당
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		
		// abs() 메서드를 사용해 두 정수 사이의 값의 합을 저장할 변수 sum 초기화
		long sum = (a + b) * ((Math.abs(a - b) + 1) / 2);
		
		// 두 정수 사이의 수의 개수가 홀수인 경우 중간 값을 sum에 갱신
		if ((Math.abs(a - b)) % 2 == 0)
			sum += (a + b) / 2;
		
		// valueOf() 및 write() 메서드를 사용해 두 정수 사이의 값의 합을 출력
		out.write(String.valueOf(sum));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
    }
}