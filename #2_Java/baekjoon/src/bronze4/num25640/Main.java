package bronze4.num25640;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 진호의 MBTI 유형, 친구의 수를 각 변수에 할당
		String targetType = in.readLine();
		int friendNum = Integer.parseInt(in.readLine());
		
		// 진호와 MBTI 유형이 같은 사람의 수를 저장할 변수 count 초기화
		int count = 0;
		
		// for 반복문을 사용해 각 친구의 MBTI 유형을 순회
		for (int friend = 0; friend < friendNum; friend++) {
			
			// readLine() 메서드를 사용해 입력 받은 친구의 MBTI 유형을 변수 friendType에 할당
			String friendType = in.readLine();
			
			// 진호의 MBTI 유형과 같은 경우 MBTI 유형이 같은 사람의 수를 갱신
			if (friendType.equals(targetType))
				count++;
		}
		
		// valueOf() 및 write() 메서드를 사용해 진호와 MBTI 유형이 같은 사람의 수를 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}