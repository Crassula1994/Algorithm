package silver4.num03048;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 두 그룹의 개미의 수를 각 변수에 할당
		int countGroup1 = Integer.parseInt(st.nextToken());
		int countGroup2 = Integer.parseInt(st.nextToken());
		
		// readLine() 메서드를 사용해 입력 받은 두 그룹의 개미를 각 변수에 할당
		String group1 = in.readLine();
		String group2 = in.readLine();
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 지난 시간을 변수 targetTime에 할당
		int targetTime = Integer.parseInt(in.readLine());
		
		// 개미의 순서를 저장할 배열 order 초기화
		char[] order = new char[countGroup1 + countGroup2];
		
		// 각 개미가 속한 그룹을 저장할 Map 객체 ants 초기화
		Map<Character, Integer> ants = new HashMap<>();
		
		// for 반복문을 사용해 첫 번째 그룹에 속한 개미의 정보를 ants에 저장
		for (int idx = 0; idx < countGroup1; idx++)
			ants.put(group1.charAt(idx), 1);
		
		// for 반복문을 사용해 두 번째 그룹에 속한 개미의 정보를 ants에 저장
		for (int idx = 0; idx < countGroup2; idx++)
			ants.put(group2.charAt(idx), 2);
		
		// for 반복문을 사용해 초기 개미의 배치 순서를 배열 order에 저장
		for (int idx = 0; idx < order.length; idx++)
			order[idx] = (idx < countGroup1) ? group1.charAt(countGroup1 - idx - 1) : group2.charAt(idx - countGroup1);
		
		// while 반복문을 사용해 각 시간을 순회
		while (targetTime-- > 0) {
			
			// 개미의 이동이 끝났는지 여부를 나타낼 변수 isFinished 초기화
			boolean isFinished = true;
			
			// for 반복문을 사용해 각 개미의 배치를 순회
			for (int idx = 0; idx < order.length - 1;) {
				
				// 두 개미가 서로 자리를 바꿔야 하는 경우
				if (ants.get(order[idx]) == 1 && ants.get(order[idx + 1]) == 2) {
					
					// 이동이 끝났는지 여부를 갱신
					isFinished = false;
					
					// 두 개미의 순서를 교체
					char temp = order[idx];
					order[idx] = order[idx + 1];
					order[idx + 1] = temp;
					
					// 다음 위치를 순회
					idx += 2;
					
				// 두 개미가 서로 자리를 바꿀 필요가 없는 경우 다음 위치를 순회
				} else {
					idx += 1;
				}
			}
			
			// 개미의 이동이 끝난 경우 반복문 탈출
			if (isFinished)
				break;
		}
		
		// write() 메서드를 사용해 시간이 지난 후 개미의 순서를 출력
		out.write(order);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}