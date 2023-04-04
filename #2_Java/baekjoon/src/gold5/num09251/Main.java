package gold5.num09251;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 메서드를 사용해 입력 받은 문자열을 각 변수에 할당
		String string1 = in.readLine();
		String string2 = in.readLine();
		
		// 첫 번째 문자열이 두 번째 문자열보다 길이가 길 경우 두 변수를 교체
		if (string1.length() > string2.length()) {
			String temp = string1;
			string1 = string2;
			string2 = temp;
		}
		
		// toCharArray() 메서드를 사용해 각 문자열을 배열로 저장
		char[] charArray1 = string1.toCharArray();
		char[] charArray2 = string2.toCharArray();
		
		// 해당 문자열까지 가장 긴 공통 부분 수열의 길이를 저장할 배열 lcsLength 초기화
		int[][] lcsLength = new int[charArray1.length][2];
		
		// 최장 공통 부분 수열의 길이를 저장할 변수 maxLength 초기화
		int maxLength = Integer.MIN_VALUE;
		
		// for 반복문을 사용해 해당 문자열의 문자를 차례로 순회
		for (int i = 0; i < charArray1.length; i++) {
			
			// for 반복문을 사용해 두 번째 수열을 순회
			for (int j = 0; j < charArray2.length; j++) {}
			
			
		}
		
		
		
		int[][] connection = new int[wireNum][2];
		
		// 해당 전깃줄까지 가장 많이 연결된 전깃줄의 숫자를 저장할 배열 maxWire 초기화
		int[] maxWire = new int[wireNum];
		
		// for 반복문을 사용해 각 전깃줄을 순회
		for (int wire = 0; wire < wireNum; wire++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 전깃줄의 연결 정보를 배열 connection에 저장
			connection[wire][0] = Integer.parseInt(st.nextToken());
			connection[wire][1] = Integer.parseInt(st.nextToken());
		}
		
		// sort() 메서드를 사용해 전깃줄의 연결 정보를 정렬
		Arrays.sort(connection, (w1, w2) -> {
			return w1[0] - w2[0];
		});
		
		// 모든 전깃줄이 교차하지 않게 하기 위해 없애야 하는 전깃줄의 최소 개수를 저장할 변수 minCnt 초기화
		int minCnt = Integer.MAX_VALUE;
		
		// for 반복문을 사용해 각 전깃줄을 순회
		for (int i = 0; i < wireNum; i++) {
			
			// 해당 위치의 값을 1로 초기화
			maxWire[i] = 1;
			
			// for 반복문을 사용해 해당 전깃줄 이전의 전깃줄을 순회
			for (int j = 0; j < i; j++) {
				
				// 해당 전깃줄이 현재 전깃줄과 교차하지 않는 경우 교차하지 않는 전깃줄의 개수를 갱신
				if (connection[j][1] < connection[i][1])
					maxWire[i] = Math.max(maxWire[j] + 1, maxWire[i]);
			}
			
			// min() 메서드를 사용해 없애야 하는 전깃줄의 최소 개수를 갱신
			minCnt = Math.min(wireNum - maxWire[i], minCnt);
		}
		
		// valueOf() 및 write() 메서드를 사용해 모든 전깃줄이 교차하지 않게 하기 위해 없애야 하는 전깃줄의 최소 개수를 출력
		out.write(String.valueOf(minCnt)); 

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}