package gold2.num07453;

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
	
	// 배열의 크기, 합이 0이 되는 쌍의 개수를 저장할 각 변수 초기화
	static int size;
	static long count = 0;
	
	// 두 배열을 묶어 각 원소의 합을 저장할 각 배열 초기화
	static int[] sumAB;
	static int[] sumCD;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 배열의 크기를 변수 size에 할당
		size = Integer.parseInt(in.readLine());
		
		// 각 배열의 원소를 저장할 각 배열 초기화
		int[] arrayA = new int[size];
		int[] arrayB = new int[size];
		int[] arrayC = new int[size];
		int[] arrayD = new int[size];
		
		// for 반복문을 사용해 각 원소를 순회
		for (int idx = 0; idx < size; idx++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 각 원소를 각 배열에 저장
			arrayA[idx] = Integer.parseInt(st.nextToken());
			arrayB[idx] = Integer.parseInt(st.nextToken());
			arrayC[idx] = Integer.parseInt(st.nextToken());
			arrayD[idx] = Integer.parseInt(st.nextToken());
		}
		
		// 두 배열을 묶어 각 원소의 합을 저장할 각 배열 초기화
		sumAB = new int[size * size];
		sumCD = new int[size * size];
		
		// elementAdder() 메서드를 호출해 두 배열의 각 원소의 합을 갱신
		elementAdder(arrayA, arrayB, sumAB);
		elementAdder(arrayC, arrayD, sumCD);
		
		// sort() 메서드를 사용해 각 배열의 원소 합을 오름차순으로 정렬
		Arrays.sort(sumAB);
		Arrays.sort(sumCD);
		
		// zeroSumFinder() 메서드를 호출해 합이 0이 되는 쌍의 개수를 갱신
		zeroSumFinder();
		
		// valueOf() 및 write() 메서드를 사용해 합이 0이 되는 쌍의 개수를 출력
		out.write(String.valueOf(count));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------

	// elementAdder() 메서드 정의
	public static void elementAdder(int[] array1, int[] array2, int[] sumArray) {
		
		// for 반복문을 사용해 두 배열의 각 원소의 합을 갱신
		for (int i = 0, idx = 0; i < size; i++) {
			for (int j = 0; j < size; j++)
				sumArray[idx++] = array1[i] + array2[j];
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// zeroSumFinder() 메서드 정의
	public static void zeroSumFinder() {
		
		// 각 배열의 원소 합의 인덱스를 나타낼 각 변수 초기화
		int left = 0;
		int right = sumCD.length - 1;
		
		// while 반복문을 사용해 두 원소 합의 인덱스 중 하나가 끝에 도달할 때까지 순회
		while (left < sumAB.length && right >= 0) {
			
			// 두 원소 합을 각 변수에 할당
			int sumLeft = sumAB[left];
			int sumRight = sumCD[right];
			
			// 네 배열의 합을 계산해 변수 totalSum에 할당
			int totalSum = sumLeft + sumRight;
			
			// 네 배열의 합이 0보다 작은 경우 첫 번째 원소 합의 인덱스를 갱신
			if (totalSum < 0) {
				left++;
			
			// 네 배열의 합이 0보다 큰 경우 두 번째 원소 합의 인덱스를 갱신
			} else if (totalSum > 0) {
				right--;
				
			// 네 배열의 합이 0인 경우
			} else {
				
				// 각 원소 합에서 같은 합을 지닌 원소의 개수를 저장할 각 변수 초기화
				long countAB = 0;
				long countCD = 0;
				
				// while 반복문을 사용해 첫 번째 원소 합에서 해당 값과 같은 값이 있는지 순회
				while (left < sumAB.length && sumAB[left] == sumLeft) {
					
					// 첫 번째 원소 합의 인덱스를 갱신
					left++;
					
					// 첫 번째 원소 합에서 같은 합을 지닌 원소의 개수를 갱신
					countAB++;
				}
				
				// while 반복문을 사용해 두 번째 원소 합에서 해당 값과 같은 값이 있는지 순회
				while (right >= 0 && sumCD[right] == sumRight) {
					
					// 두 번째 원소 합의 인덱스를 갱신
					right--;
					
					// 두 번째 원소 합에서 같은 합을 지닌 원소의 개수를 갱신
					countCD++;
				}
				
				// 합이 0이 되는 쌍의 개수를 갱신
				count += countAB * countCD;
			}
		}
	}
}