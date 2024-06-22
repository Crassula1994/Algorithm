package silver4.num24605;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++) {

			// readLine() 및 toCharArray() 메서드를 사용해 입력 받은 테트로미노의 배열을 배열 tetrominoes에 저장
			char[] tetrominoes = in.readLine().toCharArray();
			
			// sequenceChecker() 메서드를 호출해 해당 테트로미노의 배열이 유효한지 여부를 변수 isValid에 할당
			boolean isValid = sequenceChecker(tetrominoes);
			
			// write() 메서드를 사용해 해당 테트로미노의 배열이 유효한지 여부를 출력
			out.write(isValid ? 1 + "\n" : 0 + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// sequenceChecker() 메서드 정의
	public static boolean sequenceChecker(char[] tetrominoes) {

		// for 반복문을 사용해 가능한 테트로미노 배열 세트의 시작 위치를 순회
		outer: for (int start = 0; start < Math.min(7, tetrominoes.length); start++) {
			
			// 각 테트로미노의 등장 여부를 나타낼 Set 객체 generated 초기화
			Set<Character> generated = new HashSet<>();
			
			// for 반복문을 사용해 시작 위치까지의 중복을 검사
			for (int idx = 0; idx < start; idx++) {
				
				// 해당 테트로미노를 변수 tetromino에 할당
				char tetromino = tetrominoes[idx];
				
				// 해당 테트로미노가 이미 등장한 경우 다음 테트로미노 배열 세트의 시작 위치를 순회
				if (generated.contains(tetromino))
					continue outer;
				
				// add() 메서드를 사용해 해당 테트로미노의 등장 여부를 갱신
				generated.add(tetromino);
			}
			
			// clear() 메서드를 사용해 각 테트로미노의 등장 여부를 초기화
			generated.clear();
			
			// for 반복문을 사용해 각 테트로미노 배열 세트를 순회
			for (int cycle = start; cycle < tetrominoes.length; cycle += 7) {
				
				// for 반복문을 사용해 해당 테트로미노 배열 세트의 각 테트로미노를 순회
				for (int idx = cycle; idx < Math.min(cycle + 7, tetrominoes.length); idx++) {
					
					// 해당 테트로미노를 변수 tetromino에 할당
					char tetromino = tetrominoes[idx];
					
					// 해당 테트로미노가 이미 등장한 경우 다음 테트로미노 배열 세트의 시작 위치를 순회
					if (generated.contains(tetromino))
						continue outer;
					
					// add() 메서드를 사용해 해당 테트로미노의 등장 여부를 갱신
					generated.add(tetromino);
				}
				
				// clear() 메서드를 사용해 각 테트로미노의 등장 여부를 초기화
				generated.clear();
			}
			
			// 해당 테트로미노의 배열이 유효한 경우 true 반환
			return true;
		}
		
		// 해당 테트로미노의 배열이 유효하지 않은 경우 false 반환
		return false;
	}
}