package bronze2.num31844;

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
		
		// readLine() 및 toCharArray() 메서드를 사용해 입력 받은 창고의 상태를 배열 warehouse에 저장
		char[] warehouse = in.readLine().toCharArray();
		
		// 로봇이 있는 칸, 박스가 있는 칸, 박스를 놓아야 하는 칸을 저장할 각 변수 초기화
		int robotLoc = -1;
		int boxLoc = -1;
		int targetLoc = -1;
		
		// for 반복문을 사용해 각 창고의 상태를 순회
		for (int idx = 0; idx < warehouse.length; idx++) {
			
			// switch 조건문을 사용해 각 칸의 상태를 갱신
			switch (warehouse[idx]) {
				case '@':
					robotLoc = idx;
					break;
				case '#':
					boxLoc = idx;
					break;
				case '!':
					targetLoc = idx;
			}
		}
		
		// 박스를 원하는 칸으로 옮길 수 있는 경우 명령을 내려야 하는 횟수를 출력
		if ((robotLoc < boxLoc && boxLoc < targetLoc) || (robotLoc > boxLoc && boxLoc > targetLoc)) {
			out.write(String.valueOf(Math.abs(targetLoc - robotLoc) - 1));
		
		// 박스를 원하는 칸으로 옮길 수 없는 경우 -1 출력
		} else {
			out.write(String.valueOf(-1));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}