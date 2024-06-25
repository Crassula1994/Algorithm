package silver1.num24474;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// 각 카스텔라 조각의 길이 및 해당 조각까지의 카스텔라 조각의 개수를 저장할 각 배열 초기화
	static int[] lengths;
	static long[] counts;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 카스테라 조각의 개수를 변수 castellarNum에 할당
		int castellarNum = Integer.parseInt(in.readLine());
		
		// 각 카스텔라 조각의 길이 및 해당 조각까지의 카스텔라 조각의 개수를 저장할 각 배열 초기화
		lengths = new int[castellarNum + 1];
		counts = new long[castellarNum + 1];
		
		// for 반복문을 사용해 각 카스테라 조각을 순회
		for (int idx = 1; idx <= castellarNum; idx++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 카스텔라의 길이를 배열 lengths에 저장
			lengths[idx] = Integer.parseInt(in.readLine());
			
			// 해당 길이를 가진 카스텔라 조각의 개수를 저장할 변수 count 초기화
			long count = 1;
			
			// while 반복문을 사용해 해당 카스텔라 조각의 길이가 홀수가 될 때까지 순회
			while (lengths[idx] % 2 == 0) {
				
				// 카스텔라 조각의 길이과 그 개수를 갱신
				lengths[idx] /= 2;
				count *= 2;
			}
			
			// 해당 카스텔라 조각까지의 카스텔라 조각의 개수를 갱신
			counts[idx] = counts[idx - 1] + count;
		}
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 문제의 개수를 변수 questionNum에 할당
		int questionNum = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 문제를 순회
		for (int question = 0; question < questionNum; question++) {
			
			// readLine() 및 parseLong() 메서드를 사용해 입력 받은 찾고자 하는 조각의 순서를 변수 targetOrder에 할당
			long targetOrder = Long.parseLong(in.readLine());
			
			// lengthFinder() 메서드를 호출해 찾고자 하는 조각의 길이를 변수 targetLength에 할당
			int targetLength = lengthFinder(castellarNum, targetOrder);
			
			// write() 메서드를 사용해 찾고자 하는 조각의 길이를 출력
			out.write(targetLength + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// lengthFinder() 메서드 정의
	public static int lengthFinder(int castellarNum, long targetOrder) {
		
		// 이분탐색을 위해 필요한 양 끝을 나타낼 각 변수 초기화
		int start = 1;
		int end = castellarNum + 1;
		
		// while 반복문을 사용해 찾고자 하는 조각을 찾을 때까지 순회
		while (start < end) {
			
			// 이분탐색을 위해 구간의 중간을 계산해 변수 mid에 할당
			int mid = (start + end) / 2;
			
			// 중간까지의 개수가 찾고자 하는 조각의 순서보다 작은 경우 구간의 왼쪽 끝을 갱신
			if (counts[mid] < targetOrder) {
				start = mid + 1;
			
			// 중간까지의 개수가 찾고자 하는 조각의 순서보다 크거나 같은 경우 구간의 오른쪽 끝을 갱신
			} else {
				end = mid;
			}
		}
		
		// 찾은 카스텔라 조각의 위치를 반환
		return lengths[end];
	}
}