package gold5.num20495;

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
	
	// 준원이가 받은 수열의 길이를 저장할 변수 length 초기화
	static int length;
	
	// 각 수열의 원소가 최솟값, 최댓값일 때 정렬한 결과를 저장할 각 배열 초기화
	static int[] minSequence;
	static int[] maxSequence;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 준원이가 받은 수열의 길이를 변수 length에 할당
		length = Integer.parseInt(in.readLine());
		
		// 각 수열의 원소의 최솟값과 최댓값, 그리고 해당 값일 때 정렬한 결과를 저장할 각 배열 초기화
		int[] minValues = new int[length];
		int[] maxValues = new int[length];
		minSequence = new int[length];
		maxSequence = new int[length];
		
		// for 반복문을 사용해 각 수열의 원소를 순회
		for (int idx = 0; idx < length; idx++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 각 원소의 기본 값과 오차 범위를 각 변수에 할당
			int baseValue = Integer.parseInt(st.nextToken());
			int tolerance = Integer.parseInt(st.nextToken());
			
			// 각 원소의 최솟값과 최댓값을 계산해 각 배열에 저장
			minValues[idx] = baseValue - tolerance;
			maxValues[idx] = baseValue + tolerance;
			minSequence[idx] = minValues[idx];
			maxSequence[idx] = maxValues[idx];
		}
		
		// sort() 메서드를 사용해 각 원소가 최솟값, 최댓값일 때 수열을 정렬
		Arrays.sort(minSequence);
		Arrays.sort(maxSequence);
		
		// for 반복문을 사용해 각 수열의 원소를 순회
		for (int idx = 0; idx < length; idx++) {
			
			// minIndexFinder() 및 maxIndexFinder() 메서드를 호출해 해당 원소가 있을 수 있는 인덱스 범위를 각 변수에 할당
			int minIndex = minIndexFinder(minValues[idx]) + 1;
			int maxIndex = maxIndexFinder(maxValues[idx]);
			
			// write() 메서드를 사용해 해당 원소가 있을 수 있는 인덱스 범위를 출력
			out.write(minIndex + " " + maxIndex + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// minIndexFinder() 메서드 정의
	public static int minIndexFinder(int targetValue) {
		
		// 해당 값이 들어갈 최소 인덱스를 찾기 위한 인덱스의 범위를 나타낼 각 변수 초기화
		int left = 0;
		int right = length;
		
		// while 반복문을 사용해 해당 값을 찾을 때까지 순회
		while (left < right) {
			
			// 인덱스 범위의 중간 값을 계산해 변수 mid에 할당
			int mid = (left + right) / 2;
			
			// 범위의 중간에 위치한 원소가 주어진 원소보다 작은 경우 범위의 시작 부분을 갱신
			if (maxSequence[mid] < targetValue) {
				left = mid + 1;
				
			// 범위의 중간에 위치한 원소가 주어진 원소와 같거나 큰 경우 범위의 끝 부분을 갱신
			} else {
				right = mid;
			}
		}
		
		// 해당 값이 들어갈 최소 인덱스의 위치를 반환
		return right;
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// maxIndexFinder() 메서드 정의
	public static int maxIndexFinder(int targetValue) {
		
		// 해당 값이 들어갈 최대 인덱스를 찾기 위한 인덱스의 범위를 나타낼 각 변수 초기화
		int left = 0;
		int right = length;
		
		// while 반복문을 사용해 해당 값을 찾을 때까지 순회
		while (left < right) {
			
			// 인덱스 범위의 중간 값을 계산해 변수 mid에 할당
			int mid = (left + right) / 2;
			
			// 범위의 중간에 위치한 원소가 주어진 원소보다 작거나 같은 경우 범위의 시작 부분을 갱신
			if (minSequence[mid] <= targetValue) {
				left = mid + 1;
				
			// 범위의 중간에 위치한 원소가 주어진 원소보다 큰 경우 범위의 끝 부분을 갱신
			} else {
				right = mid;
			}
		}
		
		// 해당 값이 들어갈 최대 인덱스의 위치를 반환
		return right;
	}
}