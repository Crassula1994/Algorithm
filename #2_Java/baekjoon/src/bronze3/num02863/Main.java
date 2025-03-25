package bronze3.num02863;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 양의 정수를 각 변수에 할당
		double numberA = Integer.parseInt(st.nextToken());
		double numberB = Integer.parseInt(st.nextToken());
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 양의 정수를 각 변수에 할당
		double numberC = Integer.parseInt(st.nextToken());
		double numberD = Integer.parseInt(st.nextToken());
		
		// 가장 큰 표의 값과 그 때의 회전 수를 저장할 각 변수 초기화
		double maxValue = 0;
		int maxCount = -1;
		
		// 표의 회전 수에 따른 표의 값을 저장할 배열 tableValues 초기화
		double[] tableValues = {
				numberA / numberC + numberB / numberD, numberC / numberD + numberA / numberB,
				numberD / numberB + numberC / numberA, numberB / numberA + numberD / numberC		
		};
		
		// for 반복문을 사용해 각 표의 값을 순회
		for (int idx = 0; idx < tableValues.length; idx++) {
			
			// 해당 표의 값이 가장 큰 표의 값인 경우 가장 큰 표의 값과 그 때의 회전 수를 갱신
			if (tableValues[idx] > maxValue) {
				maxValue = tableValues[idx];
				maxCount = idx;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 가장 큰 표의 값일 때 회전 수를 출력
		out.write(String.valueOf(maxCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}