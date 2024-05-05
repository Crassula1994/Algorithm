package gold4.num14002;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 수열의 크기를 변수 size에 할당
		int size = Integer.parseInt(in.readLine());
		
		// 가장 긴 증가하는 부분 수열의 길이 및 가장 긴 증가하는 부분 수열의 마지막 원소의 인덱스를 저장할 각 변수 초기화
		int maxLength = 0;
		int lastIndex = -1;
		
		// 수열 및 각 원소에서 가장 긴 증가하는 부분 수열의 길이, 이전 원소의 위치를 저장할 각 배열 초기화
		int[] sequence = new int[size];
		int[] lisLength = new int[size];
		int[] prevIndex = new int[size];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 수열을 배열 sequence에 저장
		for (int idx = 0; idx < sequence.length; idx++)
			sequence[idx] = Integer.parseInt(st.nextToken());
		
		// for 반복문을 사용해 각 수열의 원소를 순회
		for (int cur = 0; cur < sequence.length; cur++) {
			
			// 현재 원소의 가장 긴 증가하는 부분 수열의 길이 및 이전 원소의 위치를 초기화
			lisLength[cur] = 1;
			prevIndex[cur] = -1;
			
			// for 반복문을 사용해 각 수열의 이전 원소를 순회
			for (int prev = 0; prev < cur; prev++) {
				
				// 이전 원소가 현재 원소보다 작고, 가장 긴 증가하는 부분 수열의 갱신이 필요한 경우
				if (sequence[prev] < sequence[cur] && lisLength[cur] < lisLength[prev] + 1) {
					
					// 가장 긴 증가하는 부분 수열의 길이 및 이전 원소의 위치를 갱신
					lisLength[cur] = lisLength[prev] + 1;
					prevIndex[cur] = prev;
				}
			}
			
			// 저장된 가장 긴 증가하는 부분 수열의 길이보다 긴 경우
			if (lisLength[cur] > maxLength) {
				
				// 가장 긴 증가하는 부분 수열의 길이 및 마지막 원소의 인덱스 갱신
				maxLength = lisLength[cur];
				lastIndex = cur;
			}
		}
		
		// write() 메서드를 사용해 가장 긴 증가하는 부분 수열의 길이를 출력
		out.write(maxLength + "\n");
		
		// 가장 긴 증가하는 부분 수열의 원소를 저장할 StringBuilder 객체 sb 초기화
		StringBuilder sb = new StringBuilder();
		
		// while 반복문을 사용해 모든 부분 수열의 원소를 찾을 때까지 순회
		while (true) {
			
			// insert() 메서드를 사용해 부분 수열의 원소를 sb에 추가
			sb.insert(0, sequence[lastIndex] + " ");
			
			// 부분 수열의 원소를 모두 찾은 경우 반복문 탈출
			if (prevIndex[lastIndex] == -1)
				break;
			
			// 다음에 확인할 부분 수열 원소의 인덱스를 갱신
			lastIndex = prevIndex[lastIndex];
		}
		
		// toString() 및 write() 메서드를 사용해 가장 긴 증가하는 부분 수열의 원소를 출력
		out.write(sb.toString());
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}