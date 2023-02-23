package bronze1.num01037;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 진짜 약수의 수를 변수 length에 할당
		int length = Integer.parseInt(in.readLine());
		
		// 진짜 약수를 저장할 배열 properDiv 초기화
		int[] properDiv = new int[length];
		
		// 가장 작은 약수와 가장 큰 약수의 값을 저장할 각 변수 초기화
		int minDiv = Integer.MAX_VALUE;
		int maxDiv = 0;
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 배열 properDiv의 각 원소 순회
		for (int idx = 0; idx < properDiv.length; idx++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 약수를 배열 properDiv에 저장
			properDiv[idx] = Integer.parseInt(st.nextToken());
			
			// 가장 작은 약수 및 가장 큰 약수의 값을 갱신
			minDiv = (properDiv[idx] < minDiv) ? properDiv[idx] : minDiv;
			maxDiv = (properDiv[idx] > maxDiv) ? properDiv[idx] : maxDiv;
		}
		
		// valueOf() 및 write() 메서드를 사용해 해당 약수를 가지는 수를 출력
		out.write(String.valueOf(minDiv * maxDiv));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}