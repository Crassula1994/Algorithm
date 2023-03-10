package bronze5.num01271;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
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
		
		// nextToken() 메서드를 사용해 입력 받은 최백준 조교가 가진 돈과 돈을 받으러 온 생명체의 수를 각 변수에 할당
		BigInteger money = new BigInteger(st.nextToken());
		BigInteger distributee = new BigInteger(st.nextToken());
    	
		// divideAndRemainder() 메서드를 사용해 나눗셈 연산을 한 결과를 배열 result에 할당
		BigInteger[] result = money.divideAndRemainder(distributee);
		
		// write() 메서드를 사용해 생명체 하나에게 돌아가는 돈의 양과 1원씩 분배할 수 없는 남는 돈을 출력
		out.write(result[0] + "\n" + result[1]);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
    }
}