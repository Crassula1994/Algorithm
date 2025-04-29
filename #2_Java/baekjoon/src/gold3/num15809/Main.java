package gold3.num15809;

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
	
	// 각 국가의 종주국과 병력을 저장할 각 배열 초기화
	static int[] rootNations;
	static int[] troops;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 국가의 수 및 기록의 수를 각 변수에 할당
		int nationNum = Integer.parseInt(st.nextToken());
		int recordNum = Integer.parseInt(st.nextToken());
		
		// 남아 있는 국가의 수를 저장할 변수 remains 초기화
		int remains = 0;
		
		// 각 국가의 종주국과 병력을 저장할 각 배열 초기화
		rootNations = new int[nationNum];
		troops = new int[nationNum];
		
		// for 반복문을 사용해 각 국가를 순회
		for (int idx = 0; idx < nationNum; idx++) {
			
			// 해당 국가의 종주국을 초기화
			rootNations[idx] = idx;
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 해당 국가의 병력을 배열 troops에 저장
			troops[idx] = Integer.parseInt(in.readLine());
		}
		
		// while 반복문을 사용해 각 기록을 순회
		while (recordNum-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 기록의 종류 및 대상 국가를 각 변수에 할당
			int category = Integer.parseInt(st.nextToken());
			int nationA = Integer.parseInt(st.nextToken()) - 1;
			int nationB = Integer.parseInt(st.nextToken()) - 1;
			
			// rootNationFinder() 메서드를 호출해 두 국가의 종주국을 각 변수에 할당
			int rootNationA = rootNationFinder(nationA);
			int rootNationB = rootNationFinder(nationB);
			
			// 두 국가가 동맹을 맺은 경우
			if (category == 1) {
				
				// min() 및 max() 메서드를 사용해 동맹을 맺은 국가의 종주국과 종속국을 각 변수에 할당
				int suzerain = Math.min(rootNationA, rootNationB);
				int vassal = Math.max(rootNationA, rootNationB);
				
				// 동맹을 맺은 종속국의 종주국을 갱신
				rootNations[vassal] = suzerain;
				
				// 각 국가의 병력을 갱신
				troops[suzerain] += troops[vassal];
				troops[vassal] = 0;
				
			// 두 국가가 전쟁을 벌인 경우
			} else {
				
				// 두 국가의 병력이 같은 경우 두 국가를 멸망 처리 후 다음 기록을 순회
				if (troops[rootNationA] == troops[rootNationB]) {
					troops[rootNationA] = 0;
					troops[rootNationB] = 0;
					continue;
				}
				
				// 전쟁을 벌인 국가의 종주국과 종속국을 각 변수에 할당
				int suzerain = (troops[rootNationA] > troops[rootNationB]) ? rootNationA : rootNationB;
				int vassal = (troops[rootNationA] > troops[rootNationB]) ? rootNationB : rootNationA;
				
				// 전쟁을 벌여 속국이 된 국가의 종주국을 갱신
				rootNations[vassal] = suzerain;
				
				// 각 국가의 병력을 갱신
				troops[suzerain] -= troops[vassal];
				troops[vassal] = 0;
			}
		}
		
		// sort() 메서드를 사용해 각 국가의 병력을 오름차순으로 정렬
		Arrays.sort(troops);
		
		// 각 국가의 남은 병력의 수를 저장할 StringBuilder 객체 sb 초기화
		StringBuilder sb = new StringBuilder();
		
		// for 반복문을 사용해 각 국가의 병력을 순회
		for (int troop : troops) {
			
			// 멸망한 국가인 경우 다음 국가를 순회
			if (troop == 0)
				continue;
			
			// 남아 있는 국가의 수를 갱신
			remains++;
			
			// append() 메서드를 사용해 해당 국가의 남은 병력의 수를 sb에 추가
			sb.append(troop).append(" ");
		}
		
		// toString() 및 write() 메서드를 사용해 남아 있는 국가의 수 및 각 국가의 남은 병력의 수를 출력
		out.write(remains + "\n" + sb.toString());
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// rootNationFinder() 메서드 정의
	public static int rootNationFinder(int nation) {
		
		// 해당 국가가 자기 자신의 종주국인 경우 해당 국가를 반환
		if (rootNations[nation] == nation)
			return nation;
		
		// rootNationFinder() 메서드를 재귀 호출해 해당 국가의 종주국을 찾아 반환
		return rootNations[nation] = rootNationFinder(rootNations[nation]);
	}
}