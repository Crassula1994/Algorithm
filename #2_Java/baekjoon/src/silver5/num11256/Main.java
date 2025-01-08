package silver5.num11256;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 개수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (testCase-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 사탕의 개수와 상자의 개수를 각 변수에 할당
			int candyNum = Integer.parseInt(st.nextToken());
			int boxNum = Integer.parseInt(st.nextToken());
			
			// 사용한 최소한의 상자 개수를 저장할 변수 minCount 초기화
			int minCount = 0;
			
			// 각 상자의 크기를 저장할 배열 boxSizes 초기화
			int[] boxSizes = new int[boxNum];
			
			// for 반복문을 사용해 각 상자의 크기를 순회
			for (int idx = 0; idx < boxSizes.length; idx++) {
				
				// StringTokenizer 객체를 불러와 변수 st에 재할당
				st = new StringTokenizer(in.readLine());
				
				// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 상자의 세로 길이와 가로 길이를 각 변수에 할당
				int height = Integer.parseInt(st.nextToken());
				int width = Integer.parseInt(st.nextToken());
				
				// 상자의 크기를 계산해 배열 boxSizes에 저장
				boxSizes[idx] = height * width;
			}
			
			// sort() 메서드를 사용해 각 상자의 크기를 오름차순으로 정렬
			Arrays.sort(boxSizes);
			
			// for 반복문을 사용해 각 상자를 크기가 큰 순으로 순회
			for (int idx = boxNum - 1; idx >= 0; idx--) {
				
				// 사용한 최소한의 상자 개수 및 남은 사탕의 개수를 갱신
				minCount++;
				candyNum -= boxSizes[idx];
				
				// 사탕을 모두 담은 경우 반복문 탈출
				if (candyNum <= 0)
					break;
			}
			
			// write() 메서드를 사용해 사용한 최소한의 상자 개수를 출력
			out.write(minCount + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}