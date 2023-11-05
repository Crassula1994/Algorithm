package silver3.num10972;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 입력 받은 순열을 저장할 배열 permutation 초기화
	static int[] permutation;
	
	//----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 순열의 길이를 변수 size에 할당
		int size = Integer.parseInt(in.readLine());
		
		// 입력 받은 순열을 저장할 배열 permutation 초기화
		permutation = new int[size];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 순열을 배열 permutation에 저장
		for (int idx = 0; idx < permutation.length; idx++)
			permutation[idx] = Integer.parseInt(st.nextToken());
		
		// nextFinder() 메서드를 실행해 다음 순열이 존재하는지를 변수 hasNext에 할당
		boolean hasNext = nextFinder();
		
		// 다음 순열이 존재하는 경우
		if (hasNext) {
			
			// for 반복문을 사용해 다음 순열을 출력
			for (int idx = 0; idx < permutation.length; idx++)
				out.write(permutation[idx] + " ");
		
		// 다음 순열이 존재하지 않는 경우 -1을 출력
		} else {
			out.write(String.valueOf(-1));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	//----------------------------------------------------------------------------------------------------
	
	// nextFinder() 메서드 정의
	public static boolean nextFinder() {
		
		// 위치를 교환할 인덱스를 저장할 각 변수 초기화
		int originIdx = permutation.length - 1;
		int targetIdx = permutation.length - 1;
		int swappedIdx = permutation.length - 1;
		
		// while 반복문을 사용해 위치를 교환할 인덱스를 찾을 때까지 순회
		while (originIdx > 0 && permutation[originIdx - 1] > permutation[originIdx])
			originIdx--;
		
		// 다음 순열이 존재하지 않는 경우 false 반환
		if (originIdx == 0)
			return false;
		
		// while 반복문을 사용해 다른 위치를 교환할 인덱스를 찾을 때까지 순회
		while (permutation[originIdx - 1] > permutation[targetIdx])
			targetIdx--;
		
		// indexSwapper() 메서드를 사용해 두 순열의 위치를 교환
		indexSwapper(originIdx - 1, targetIdx);
		
		// while 반복문을 사용해 필요한 순열의 위치를 모두 교환할 때까지 순회
		while (originIdx < swappedIdx)
			indexSwapper(originIdx++, swappedIdx--);
		
		// 다음 순열이 존재하는 경우 true 반환
		return true;
	}
	
	//----------------------------------------------------------------------------------------------------
	
	// indexSwapper() 메서드 정의
	public static void indexSwapper(int index1, int index2) {
		
		// 입력 받은 두 인덱스의 값을 temp 변수를 활용해 교환
		int temp = permutation[index1];
		permutation[index1] = permutation[index2];
		permutation[index2] = temp;
	}
}