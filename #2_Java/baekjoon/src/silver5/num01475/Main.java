package silver5.num01475;

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
		
		// readLine() 메서드를 사용해 입력 받은 다솜이의 방 번호를 변수 roomNum에 할당
		String roomNum = in.readLine();
		
		// 필요한 세트의 개수를 저장할 변수 setNum 초기화
		int setNum = 0;
		
		// 각 숫자의 개수를 저장할 배열 counter 초기화
		int[] counter = new int[10];
		
		// for 반복문을 사용해 방 번호의 각 숫자 개수를 갱신
		for (int idx = 0; idx < roomNum.length(); idx++)
			counter[roomNum.charAt(idx) - '0']++;
		
		// 6과 9의 개수를 계산해 필요한 세트의 수를 갱신
		counter[6] = ((counter[6] + counter[9]) % 2 == 0) ?
				(counter[6] + counter[9]) / 2 : (counter[6] + counter[9]) / 2 + 1;
		
		// for 반복문을 사용해 필요한 세트의 개수를 갱신
		for (int idx = 0; idx < 9; idx++)
			setNum = Math.max(counter[idx], setNum);
		
		// valueOf() 및 write() 메서드를 사용해 필요한 세트의 개수를 출력
		out.write(String.valueOf(setNum));
	
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}