package gold3.num13147;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 최대로 존재할 수 있는 난쟁이의 수를 저장할 상수 MAX_DWARF_COUNT 초기화
	static final int MAX_DWARF_COUNT = 10000;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 진술의 수를 변수 statementNum에 할당
		int statementNum = Integer.parseInt(in.readLine());
		
		// 확인한 난쟁이의 수를 저장할 변수 checkCount 초기화
		int checkCount = 0;
		
		// 각 난쟁이보다 키카 큰 난쟁이의 수 및 난쟁이 사이의 관계를 저장할 각 배열 초기화
		int[] tallCounts = new int[MAX_DWARF_COUNT];
		List<Integer>[] orders = new ArrayList[MAX_DWARF_COUNT];
		
		// 다음에 확인할 난쟁이의 번호를 저장할 Queue 객체 dwarfList 초기화
		Queue<Integer> dwarfList = new LinkedList<>();
		
		// for 반복문을 사용해 난쟁이 사이의 관계를 저장할 List 객체 초기화
		for (int idx = 0; idx < orders.length; idx++)
			orders[idx] = new ArrayList<>();
		
		// 각 난쟁이의 이름과 번호를 저장할 Map 객체 dwarves 초기화
		Map<String, Integer> dwarves = new HashMap<>();
		
		// while 반복문을 사용해 각 진술을 순회
		while (statementNum-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 charAt() 메서드를 사용해 진술의 각 관계 정보를 각 변수에 할당
			String dwarfA = st.nextToken();
			char sign = st.nextToken().charAt(0);
			String dwarfB = st.nextToken();
			
			// computeIfAbsent() 메서드를 사용해 각 난쟁이의 번호를 각 변수에 할당
			int indexA = dwarves.computeIfAbsent(dwarfA, _ -> dwarves.size());
			int indexB = dwarves.computeIfAbsent(dwarfB, _ -> dwarves.size());
			
			// 첫 번째 난쟁이가 두 번째 난쟁이보다 큰 경우 orders에 해당 관계를 저장
			if (sign == '>') {
				orders[indexA].add(indexB);
				tallCounts[indexB]++;
				
			// 두 번째 난쟁이가 첫 번째 난쟁이보다 큰 경우 orders에 해당 관계를 저장
			} else {
				orders[indexB].add(indexA);
				tallCounts[indexA]++;
			}
		}
		
		// size() 메서드를 사용해 난쟁이의 수를 변수 dwarfCount에 할당
		int dwarfCount = dwarves.size();
		
		// for 반복문을 사용해 각 난쟁이를 순회
		for (int idx = 0; idx < dwarfCount; idx++) {
			
			// 상대적으로 가장 키가 큰 난쟁이의 번호를 dwarfList에 추가
			if (tallCounts[idx] == 0)
				dwarfList.offer(idx);
		}
		
		// while 반복문을 사용해 dwarfList 가 빌 때까지 순회
		while (!dwarfList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 난쟁이를 변수 curDwarf에 할당
			int curDwarf = dwarfList.poll();
			
			// 확인한 난쟁이의 수를 갱신
			checkCount++;
			
			// 현재 난쟁이보다 더 작은 난쟁이를 순회
			for (int nextDwarf : orders[curDwarf]) {
				
				// 해당 난쟁이보다 키카 큰 난쟁이가 더 없을 경우 해당 난쟁이를 dwarfList에 추가
				if (--tallCounts[nextDwarf] == 0)
					dwarfList.offer(nextDwarf);
			}
		}
		
		// write() 메서드를 사용해 모든 진술이 일관된지 여부를 출력
		out.write((checkCount == dwarfCount) ? "possible" : "impossible");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}