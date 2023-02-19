package silver4.num1764;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 듣도 못한 사람 및 보도 못한 사람의 수를 각 변수에 할당
		int inLength = Integer.parseInt(st.nextToken());
		int outLength = Integer.parseInt(st.nextToken());
		
		// 듣도 못한 사람을 저장할 Set 객체 personSet 초기화
		Set<String> personSet = new HashSet<>();
		
		// 듣도 보도 못한 사람을 저장할 List 객체 personList 초기화
		List<String> personList = new ArrayList<>();
		
		// for 반복문을 사용해 각 듣도 못한 사람을 순회
		for (int i = 0; i < inLength; i++)

			// readLine() 및 add() 메서드를 사용해 입력 받은 사람 이름을 personSet에 추가
			personSet.add(in.readLine());
		
		// for 반복문을 사용해 각 보도 못한 사람을 순회
		for (int j = 0; j < outLength; j++) {
			
			// readLine() 메서드를 사용해 입력 받은 사람 이름을 변수 name에 할당
			String name = in.readLine();
			
			// 해당 이름이 듣도 못한 사람에 존재하는 경우 personList에 추가
			if (personSet.contains(name))
				personList.add(name);
		}
		
		// sort() 메서드를 사용해 personList를 사전순으로 정렬
		Collections.sort(personList);

		// size() 및 write() 메서드를 사용해 듣도 보도 못한 사람의 수를 출력
		out.write(personList.size() + "\n");
		
		// for 반복문을 사용해 듣도 보도 못한 사람의 이름을 출력
		for (String name : personList)
			out.write(name + "\n");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}