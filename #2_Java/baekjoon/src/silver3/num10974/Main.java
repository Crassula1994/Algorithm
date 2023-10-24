package silver3.num10974;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// 입력 받은 숫자를 저장할 변수 number 초기화
	static int number;
	
	// 각 숫자의 선택 여부, 만든 순열을 저장할 각 배열 초기화
	static boolean[] isSelected;
	static int[] permutation;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 숫자를 변수 number에 할당
		number = Integer.parseInt(in.readLine());
		
		// 각 숫자의 선택 여부, 만든 순열을 저장할 각 배열 초기화
		isSelected = new boolean[number + 1];
		permutation = new int[number];
		
		// permutationMaker() 메서드를 호출해 모든 순열 조합을 출력
		permutationMaker(0, out);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// permutationMaker() 메서드 정의
	public static void permutationMaker(int startIdx, BufferedWriter out) throws IOException {
		
		// 순열을 완성한 경우
		if (startIdx == number) {
			
			// for 반복문을 사용해 해당 순열을 출력
			for (int idx = 0; idx < permutation.length; idx++)
				out.write(permutation[idx] + " ");
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
			
			// 메서드 종료
			return;
		}
		
		// for 반복문을 사용해 각 숫자를 순회
		for (int idx = 1; idx <= number; idx++) {
			
			// 해당 숫자를 이미 선택한 경우 다음 숫자를 순회
			if (isSelected[idx])
				continue;
			
			// 해당 숫자를 선택 처리
			isSelected[idx] = true;
			permutation[startIdx] = idx;
			
			// permutationMaker() 메서드 재귀 호출
			permutationMaker(startIdx + 1, out);
			
			// 해당 숫자를 원상 복구
			isSelected[idx] = false;
			permutation[startIdx] = 0;
		}
	}
}