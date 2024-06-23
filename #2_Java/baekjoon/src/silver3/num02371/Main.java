package silver3.num02371;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 각 파일의 수열을 저장할 배열 sequences 초기화
	static List<Integer>[] sequences;
	
	// 각 파일에 중복되는 값이 존재하는지 여부를 확인할 Set 객체 elementChecker 초기화
	static Set<Integer> elementChecker = new HashSet<>();
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 파일의 개수를 변수 fileNum에 할당
		int fileNum = Integer.parseInt(in.readLine());
		
		// 모든 파일을 구별할 수 있게 해주는 최소의 값을 저장할 변수 minValue 초기화
		int minValue = 0;
		
		// 각 파일의 수열을 저장할 배열 sequence 초기화
		sequences = new ArrayList[fileNum];
			
		// for 반복문을 사용해 각 파일을 순회
		for (int idx = 0; idx < fileNum; idx++) {
			
			// 각 파일의 수열을 저장할 List 객체 초기화
			sequences[idx] = new ArrayList<>();
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// while 반복문을 사용해 입력 받은 원소를 순회
			while (true) {
				
				// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 원소를 변수 element에 할당
				int element = Integer.parseInt(st.nextToken());
				
				// -1이 입력된 경우 반복문 탈출
				if (element == -1)
					break;
				
				// add() 메서드를 사용해 입력 받은 원소를 배열 sequences에 저장
				sequences[idx].add(element);
			}
		}
		
		// while 반복문을 사용해 모든 파일을 구별할 수 있게 해주는 최소의 값을 찾을 때까지 순회
		while (!valueFinder(minValue)) {
			
			// clear() 메서드를 사용해 elementChecker에 저장된 원소를 제거
			elementChecker.clear();
			
			// 모든 파일을 구별할 수 있게 해주는 최소의 값을 갱신
			minValue++;
		}
		
		// valueOf() 및 write() 메서드를 사용해 모든 파일을 구별할 수 있게 해주는 최소의 값을 출력
		out.write(String.valueOf(minValue + 1));
			
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// valueFinder() 메서드 정의
	public static boolean valueFinder(int index) {
		
		// for 반복문을 사용해 각 파일을 순회
		for (List<Integer> file : sequences) {
			
			// 해당 파일의 수열 길이보다 확인하려는 인덱스가 큰 경우 다음 파일을 순회
			if (index >= file.size())
				continue;
			
			// get() 메서드를 사용해 해당 원소를 변수 element에 할당
			int element = file.get(index);
			
			// 해당 원소와 같은 원소가 존재하는 경우 false 반환
			if (elementChecker.contains(element))
				return false;
			
			// add() 메서드를 사용해 해당 원소를 elementChecker에 저장
			elementChecker.add(element);
		}
		
		// 모든 파일을 구분할 수 있는 경우 true 반환
		return true;
	}
}