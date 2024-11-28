package silver5.num11536;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 선수들의 이름의 수를 변수 nameNum에 할당
		int nameNum = Integer.parseInt(in.readLine());
		
		// 주어진 이름이 증가하는 순인지 감소하는 순인지를 나타낼 각 변수 초기화
		boolean isIncreasing = true;
		boolean isDecreasing = true;
		
		// 선수들의 이름과 그 이름을 오름차순으로 정렬하여 저장할 각 배열 초기화
		String[] names = new String[nameNum];
		String[] sortedNames = new String[nameNum];
		
		// for 반복문을 사용해 입력 받은 선수의 이름을 각 배열에 저장
		for (int idx = 0; idx < nameNum; idx++) {
			names[idx] = in.readLine();
			sortedNames[idx] = names[idx];
		}
		
		// sort() 메서드를 사용해 입력 받은 선수의 이름을 오름차순으로 정렬
		Arrays.sort(sortedNames);
		
		// for 반복문을 사용해 각 선수들의 이름을 차례로 순회
		for (int idx = 0; idx < nameNum; idx++) {
			
			// 선수들의 이름이 증가하는 순으로 주어지지 않는 경우 주어진 이름이 증가하는 순인지 여부를 갱신 후 반복문 탈출
			if (!names[idx].equals(sortedNames[idx])) {
				isIncreasing = false;
				break;
			}
		}
		
		// 선수들의 이름이 증가하는 순이 아닌 경우
		if (!isIncreasing) {
			
			// for 반복문을 사용해 각 선수들의 이름을 차례로 순회
			for (int idx = 0; idx < nameNum; idx++) {
				
				// 선수들의 이름이 감소하는 순으로 주어지지 않는 경우 주어진 이름이 감소하는 순인지 여부를 갱신 후 반복문 탈출
				if (!names[idx].equals(sortedNames[nameNum - idx - 1])) {
					isDecreasing = false;
					break;
				}
			}
		}
		
		// 선수들의 이름이 증가하는 순으로 나타나는 경우 'INCREASING' 출력
		if (isIncreasing) {
			out.write("INCREASING");
			
		// 선수들의 이름이 감소하는 순으로 나타나는 경우 'DECREASING' 출력
		} else if (isDecreasing) {
			out.write("DECREASING");
			
		// 선수들의 이름이 정렬되지 않은 경우 'NEITHER' 출력
		} else {
			out.write("NEITHER");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}