package silver3.num07774;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 각 멀티탭의 개수를 각 변수에 할당
		int countA = Integer.parseInt(st.nextToken());
		int countB = Integer.parseInt(st.nextToken());
		
		// 멀티탭의 연결 상태에 따른 콘센트의 개수, 사용한 멀티탭의 개수를 저장할 각 변수 초기화
		int socketA = 1;
		int socketB = 0;
		int indexA = 0;
		int indexB = 0;
		
		// 각 멀티탭에 있는 콘센트의 개수를 저장할 각 배열 초기화
		Integer[] powerStripsA = new Integer[countA];
		Integer[] powerStripsB = new Integer[countB];
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 첫 번째 멀티탭에 있는 콘센트의 개수를 배열 powerStripsA에 저장
		for (int idx = 0; idx < powerStripsA.length; idx++)
			powerStripsA[idx] = Integer.parseInt(st.nextToken());
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 두 번째 멀티탭에 있는 콘센트의 개수를 배열 powerStripsB에 저장
		for (int idx = 0; idx < powerStripsB.length; idx++)
			powerStripsB[idx] = Integer.parseInt(st.nextToken());
		
		// reverseOrder() 및 sort() 메서드를 사용해 콘센트의 개수를 기준으로 내림차순 정렬
		Arrays.sort(powerStripsA, Collections.reverseOrder());
		Arrays.sort(powerStripsB, Collections.reverseOrder());
		
		// while 반복문을 사용해 두 종류의 멀티탭 중 어느 하나가 없어질 때까지 순회
		while (indexA < countA && indexB < countB) {
			
			// 첫 번째 멀티탭을 사용한 것으로 처리
			socketA--;
			socketB += powerStripsA[indexA++];
			
			// while 반복문을 사용해 첫 번째 멀티탭의 콘센트를 모두 사용하거나 두 번째 멀티탭을 모두 사용할 때까지 순회 
			while (socketB > 0 && indexB < countB) {
				
				// 두 번째 멀티탭을 사용한 것으로 처리
				socketB--;
				socketA += powerStripsB[indexB++];
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 표준 A 콘센트의 최대 개수를 출력
		out.write(String.valueOf(socketA));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}