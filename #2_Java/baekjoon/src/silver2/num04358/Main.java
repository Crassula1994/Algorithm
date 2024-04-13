package silver2.num04358;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.TreeMap;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 전체 나무의 수를 저장할 변수 count 초기화
		int count = 0;
		
		// 각 나무의 종 이름을 저장할 Map 객체 trees 초기화
		Map<String, Integer> trees = new TreeMap<>();
		
		// while 반복문을 사용해 각 나무의 종 이름을 모두 순회
		while (true) {
			
			// readLine() 메서드를 사용해 입력 받은 나무의 이름을 변수 treeName에 할당
			String treeName = in.readLine();
			
			// 모든 나무 이름을 확인한 경우 반복문 탈출
			if (treeName == null || treeName.isEmpty())
				break;
			
			// getOrDefault() 및 put() 메서드를 사용해 입력 받은 나무의 이름과 개수를 trees에 저장
			trees.put(treeName, trees.getOrDefault(treeName, 0) + 1);
			
			// 전체 나무의 수를 갱신
			count++;
		}
		
		// for 반복문을 사용해 각 나무의 이름을 사전 순으로 순회
		for (String treeName : trees.keySet()) {
			
			// get() 메서드를 사용해 나무의 비율을 계산하고 변수 percentage에 할당
			double percentage = (double) trees.get(treeName) / count * 100;
			
			// format() 및 write() 메서드를 사용해 나무의 이름과 그 비율을 소수점 넷째 자리까지 출력
			out.write(treeName + " " + String.format("%.4f", percentage) + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}