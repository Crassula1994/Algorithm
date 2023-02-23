package silver4.num01269;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 각 집합의 원소의 개수를 각 변수에 할당
		int elementsA = Integer.parseInt(st.nextToken());
		int elementsB = Integer.parseInt(st.nextToken());
		
		// 대칭 차집합의 결과를 저장할 Set 객체 symDiff 초기화
		Set<Integer> symDiff = new HashSet<>();
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 집합 A의 원소를 순회
		for (int i = 0; i < elementsA; i++)

			// nextToken(), parseInt(), add() 메서드를 사용해 입력 받은 원소를 symDiff에 추가
			symDiff.add(Integer.parseInt(st.nextToken()));
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 집합 B의 원소를 순회
		for (int j = 0; j < elementsB; j++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 원소를 변수 element에 할당
			int element = Integer.parseInt(st.nextToken());
			
			// 해당 원소가 symDiff에 존재하는 경우 symDiff에서 해당 원소 제거
			if (symDiff.contains(element)) {
				symDiff.remove(element);
				
			// 해당 원소가 symDiff에 존재하지 않는 경우 symDiff에 해당 원소 추가
			} else {
				symDiff.add(element);
			}
		}

		// size(), valueOf(), write() 메서드를 사용해 대칭 차집합의 원소 개수를 출력
		out.write(String.valueOf(symDiff.size()));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}