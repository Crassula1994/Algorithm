package bronze2.num01362;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringBuilder 객체를 불러와 변수 sb에 할당
		StringBuilder sb = new StringBuilder();
		
		// 시나리오 번호를 저장할 변수 scenarioNum 초기화
		int scenarioNum = 1;
		
		// while 반복문을 사용해 각 시나리오를 순회
		while (true) {
			
			// readLine() 메서드를 사용해 체중 정보를 변수 weightInfo에 할당
			String weightInfo = in.readLine();
			
			// 모든 시나리오를 확인한 경우 반복문 탈출
			if (weightInfo.equals("0 0"))
				break;
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(weightInfo);
			
			// nextToken() 및 parseInt() 메서드를 사용해 적정 체중과 실제 체중을 각 변수에 할당
			int healthyWeight = Integer.parseInt(st.nextToken());
			int actualWeight = Integer.parseInt(st.nextToken());
			
			// while 반복문을 사용해 각 작용을 순회
			while (true) {
				
				// readLine() 메서드를 사용해 입력 받은 작용의 정보를 변수 actionInfo에 할당
				String actionInfo = in.readLine();
				
				// 모든 작용이 완료된 경우 반복문 탈출
				if (actionInfo.equals("# 0"))
					break;
				
				// 해당 펫이 죽은 경우 다음 작용을 순회
				if (actualWeight <= 0)
					continue;
				
				// StringTokenizer 객체를 불러와 변수 st에 재할당
				st = new StringTokenizer(actionInfo);
				
				// nextToken() 및 parseInt() 메서드를 사용해 작용의 종류와 체중의 변화량을 각 변수에 할당
				String category = st.nextToken();
				int variance = Integer.parseInt(st.nextToken());
				
				// equals() 메서드를 사용해 해당 작용이 끝난 후 펫의 체중을 갱신
				actualWeight = (category.equals("E")) ? actualWeight - variance : actualWeight + variance;
			}
			
			// append() 메서드를 사용해 시나리오 번호를 sb에 추가
			sb.append(scenarioNum++).append(" ");
			
			// 펫이 사망한 경우 'RIP'을 sb에 추가
			if (actualWeight <= 0) {
				sb.append("RIP\n");
				
			// 펫이 행복한 경우 ':-)'를 sb에 추가
			} else if (actualWeight < healthyWeight * 2 && actualWeight > healthyWeight / 2) {
				sb.append(":-)\n");
				
			// 펫이 슬픈 경우 ':-('를 sb에 추가
			} else {
				sb.append(":-(\n");
			}
		}
		
		// toString() 및 write() 메서드를 사용해 각 시나리오의 번호와 모든 작용이 완료된 후 펫의 상태를 출력
		out.write(sb.toString());
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}