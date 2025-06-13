package bronze2.num02966;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

// Main 클래스 정의
public class Main {
	
	// 상근이, 창영이, 현진이가 정답을 찍는 방법, 각 사람의 아이디를 저장할 각 배열 초기화
	static char[] methodA = {'A', 'B', 'C'};
	static char[] methodB = {'B', 'A', 'B', 'C'};
	static char[] methodG = {'C', 'C', 'A', 'A', 'B', 'B'};
	static String[] idList = {"Adrian", "Bruno", "Goran"};
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 필기시험 문제의 수와 시험의 정답을 각 변수에 할당
		int questionNum = Integer.parseInt(in.readLine());
		String answers = in.readLine();
		
		// 상근이, 창영이, 현진이가 맞춘 문제의 수를 저장할 배열 counts 초기화
		int[] counts = new int[3];
		
		// for 반복문을 사용해 각 필기시험 문제의 정답을 순회
		for (int idx = 0; idx < questionNum; idx++) {
			
			// charAt() 메서드를 사용해 해당 문제의 정답을 변수 answer에 할당
			char answer = answers.charAt(idx);
			
			// 상근이가 문제를 맞춘 경우 상근이가 맞춘 문제의 수를 갱신
			if (answer == methodA[idx % 3])
				counts[0]++;
			
			// 창영이가 문제를 맞춘 경우 창영이가 맞춘 문제의 수를 갱신
			if (answer == methodB[idx % 4])
				counts[1]++;
			
			// 현진이가 문제를 맞춘 경우 현진이가 맞춘 문제의 수를 갱신
			if (answer == methodG[idx % 6])
				counts[2]++;
		}
		
		// 가장 많이 맞춘 문제의 수를 저장할 변수 maxCount 초기화
		int maxCount = 0;
		
		// 가장 많이 맞춘 사람의 아이디를 저장할 List 객체 maxIdList 초기화
		List<String> maxIdList = new ArrayList<>();
		
		// for 반복문을 사용해 각 사람이 맞춘 문제의 수를 순회
		for (int idx = 0; idx < 3; idx++) {
			
			// 가장 많이 맞춘 문제의 수와 같은 문제를 맞춘 경우 해당 사람의 아이디를 maxIdList에 추가
			if (maxCount == counts[idx]) {
				maxIdList.add(idList[idx]);
				
			// 가장 많이 맞춘 문제의 수보다 많은 문제를 맞춘 경우
			} else if (maxCount < counts[idx]) {
				
				// 가장 많이 맞춘 문제의 수를 갱신
				maxCount = counts[idx];
				
				// clear() 메서드를 사용해 저장된 가장 많이 맞춘 사람의 아이디를 초기화
				maxIdList.clear();
				
				// add() 메서드를 사용해 해당 사람의 아이디를 maxIdList에 추가
				maxIdList.add(idList[idx]);
			}
		}
		
		// write() 메서드를 사용해 가장 많이 맞춘 문제의 수를 출력
		out.write(maxCount + "\n");
		
		// for 반복문을 사용해 가장 많이 맞춘 사람의 아이디를 출력
		for (String id : maxIdList)
			out.write(id + "\n");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}