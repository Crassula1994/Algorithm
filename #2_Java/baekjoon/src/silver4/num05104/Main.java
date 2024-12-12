package silver4.num05104;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 각 코드별 벌점을 저장할 Map 객체 codeList 초기화
	static Map<String, Integer> codeList = new HashMap<>();
	
	// put() 메서드를 사용해 각 코드별 벌점을 codeList에 저장
	static {
		codeList.put("TT", 75);
		codeList.put("TX", 50);
		codeList.put("PR", 80);
		codeList.put("RT", 30);
		codeList.put("AP", 25);
		codeList.put("PX", 60);
	}
	
	// ----------------------------------------------------------------------------------------------------

	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// while 반복문을 사용해 각 시나리오를 순회
		while (true) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 주 번호와 학생 벌점 항목 수를 각 변수에 할당
			int weekNum = Integer.parseInt(st.nextToken());
			int entryNum = Integer.parseInt(st.nextToken());
			
			// 모든 시나리오를 확인한 경우 반복문 탈출
			if (weekNum == 0 && entryNum == 0)
				break;
			
			// 휴대전화를 압수 당할 학생의 이름을 순서대로 저장할 List 객체 confiscatedStudents 초기화
			List<String> confiscatedStudents = new ArrayList<>();
			
			// 각 학생별 벌점 현황을 저장할 Map 객체 demeritPoints 초기화
			Map<String, Integer> demeritPoints = new LinkedHashMap<>();
			
			// while 반복문을 사용해 각 벌점 항목을 순회
			while (entryNum-- > 0) {
				
				// StringTokenizer 객체를 불러와 변수 st에 재할당
				st = new StringTokenizer(in.readLine());
				
				// nextToken() 메서드를 사용해 입력 받은 학생의 이름과 벌점 코드를 각 변수에 할당
				String name = st.nextToken();
				String code = st.nextToken();
				
				// getOrDefault(), get(), put() 메서드를 사용해 해당 학생의 벌점을 갱신
				demeritPoints.put(name, demeritPoints.getOrDefault(name, 0) + codeList.get(code));
			}
			
			// for 반복문을 사용해 각 학생을 순회
			for (String name : demeritPoints.keySet()) {
				
				// 해당 학생의 벌점이 100점 이상인 경우 confiscatedStudents에 추가
				if (demeritPoints.get(name) >= 100)
					confiscatedStudents.add(name);
			}
			
			// write() 메서드를 사용해 주 번호를 출력
			out.write("Week " + weekNum + " ");
			
			// 벌점 100점 이상인 학생이 없는 경우 'No phones confiscated' 출력
			if (confiscatedStudents.isEmpty()) {
				out.write("No phones confiscated");
				
			// 벌점 100점 이상인 학생이 있는 경우
			} else {
				
				// for 반복문을 사용해 벌점 100점 이상인 각 학생을 순회
				for (int idx = 0; idx < confiscatedStudents.size(); idx++) {
					
					// get() 및 write() 메서드를 사용해 벌점 100점 이상인 학생의 이름을 출력
					out.write(confiscatedStudents.get(idx));
					
					// 벌점 100점 이상인 학생들 중 마지막 학생이 아닌 경우 ','를 출력
					if (idx < confiscatedStudents.size() - 1)
						out.write(",");
				}
			}
			
			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}