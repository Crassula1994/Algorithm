package gold2.num24056;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 배열의 크기를 변수 size에 할당
		int size = Integer.parseInt(in.readLine());
		
		/* 삽입 정렬 과정에서 두 배열이 같아질 수 있는지 여부, 삽입 정렬 과정이 진행된 인덱스,
		정렬 과정에서 같은 값이 존재하는 인덱스를 나타낼 각 변수 초기화 */
		boolean isSame = false;
		int endIdx = size - 1;
		int overlapIdx = -1;
		
		// 두 배열의 원소를 저장할 각 배열 초기화
		int[] arrayA = new int[size];
		int[] arrayB = new int[size];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 배열 A의 원소를 배열 arrayA에 저장
		for (int idx = 0; idx < arrayA.length; idx++)
			arrayA[idx] = Integer.parseInt(st.nextToken());
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 배열 B의 원소를 배열 arrayB에 저장
		for (int idx = 0; idx < arrayB.length; idx++)
			arrayB[idx] = Integer.parseInt(st.nextToken());
		
		// while 반복문을 사용해 삽입 정렬 과정이 진행된 인덱스를 갱신
		while (endIdx > 0 && arrayA[endIdx] == arrayB[endIdx])
			endIdx--;
		
		// for 반복문을 사용해 삽입 정렬 과정이 진행된 각 배열의 원소를 순회
		for (int idx = 0; idx < endIdx; idx++) {
			
			// 정렬 과정에서 같은 값이 존재하는 경우 정렬 과정에서 같은 값이 존재하는 인덱스를 갱신 후 반복문 탈출
			if (arrayB[idx] == arrayB[idx + 1]) {
				overlapIdx = idx;
				break;
			}
		}
		
		// 정렬 과정에서 같은 값이 존재하지 않는 경우
		if (overlapIdx == -1) {
			
			// sort() 메서드를 사용해 삽입 정렬 과정이 진행된 인덱스까지 배열 A를 정렬
			Arrays.sort(arrayA, 0, endIdx + 1);
			
			// equals() 메서드를 사용해 삽입 정렬 과정에서 두 배열이 같아질 수 있는지 여부를 갱신
			isSame = Arrays.equals(arrayA, arrayB);
		
		// 정렬 과정에서 같은 값이 존재하는 경우
		} else {
			
			// sort() 메서드를 사용해 삽입 정렬 과정이 진행된 바로 직전 인덱스까지 배열 A를 정렬
			Arrays.sort(arrayA, 0, endIdx);
			
			// for 반복문을 사용해 배열 B의 원소를 중복된 값이 존재하기 이전의 원래 위치로 복원
			for (int idx = overlapIdx + 1; idx < endIdx; idx++)
				arrayB[idx] = arrayB[idx + 1];
			
			// 중복된 값으로 덮어씌워진 값을 복원
			arrayB[endIdx] = arrayA[endIdx];
			
			// equals() 메서드를 사용해 삽입 정렬 과정에서 두 배열이 같아질 수 있는지 여부를 갱신
			isSame = arrayB[overlapIdx] > arrayA[endIdx] && Arrays.equals(arrayA, arrayB);
		}
		
		// valueOf() 및 write() 메서드를 사용해 삽입 정렬 과정에서 두 배열이 같아질 수 있는지 여부를 출력
		out.write((isSame) ? String.valueOf(1) : String.valueOf(0));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}